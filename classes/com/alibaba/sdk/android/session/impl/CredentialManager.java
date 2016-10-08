package com.alibaba.sdk.android.session.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.AlibabaSDKException;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.Environment;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.event.EventBus;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.initialization.InitializationHandler;
import com.alibaba.sdk.android.initialization.InitializationServiceClient;
import com.alibaba.sdk.android.initialization.impl.DefaultInitializationServiceClientImpl;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.security.SecurityService;
import com.alibaba.sdk.android.security.impl.SecurityGuardWrapper;
import com.alibaba.sdk.android.security.utils.SecurityUtils;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.SessionListener;
import com.alibaba.sdk.android.session.model.InternalSession;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.session.model.RefreshToken;
import com.alibaba.sdk.android.session.model.Session;
import com.alibaba.sdk.android.session.model.User;
import com.alibaba.sdk.android.system.SystemContext;
import com.alibaba.sdk.android.system.util.SystemUtils;
import com.alibaba.sdk.android.trace.ActionTraceLogger;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.trace.TraceLoggerManager;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.JSONUtils;
import com.taobao.tae.sdk.log.SdkCoreLog;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CredentialManager
  implements CredentialService
{
  public static final CredentialManager INSTANCE = new CredentialManager(new CredentialManagerPolicy());
  private static final String TAG = CredentialManager.class.getSimpleName();
  private volatile String authorizationCode;
  private SessionInitHandler forceSessionInitHandler = new SessionInitHandler(true);
  private volatile InternalSession internalSession;
  private CredentialManagerPolicy policy;
  private volatile RefreshToken refreshToken;
  private volatile SessionListener sessionListener;
  
  public CredentialManager(CredentialManagerPolicy paramCredentialManagerPolicy)
  {
    this.policy = paramCredentialManagerPolicy;
    preInit();
  }
  
  private void handleRefreshSidResponse(String paramString, boolean paramBoolean)
  {
    paramString = createInternalSession(new JSONObject(paramString));
    if ((this.internalSession != null) && (paramBoolean))
    {
      paramString.user = this.internalSession.user;
      paramString.otherInfo = this.internalSession.otherInfo;
    }
    paramString.createTime = Long.valueOf(System.currentTimeMillis());
    if (this.policy.isUpdateWebCookie) {
      EventBus.getDefault().sendEvent("session.refreshSid", Collections.singletonMap("cookies", paramString.cookies));
    }
    refreshInternalSession(paramString);
  }
  
  private boolean isNeedRefreshSession()
  {
    return (this.internalSession == null) || (isSessionDirtyOrExpired());
  }
  
  private boolean isSessionDirtyOrExpired()
  {
    if (this.internalSession == null) {}
    while ((this.internalSession.createTime == null) || (this.internalSession.expireIn == null) || ((System.currentTimeMillis() - this.internalSession.createTime.longValue()) / 1000L > this.internalSession.expireIn.intValue())) {
      return true;
    }
    return false;
  }
  
  private void postSessionStateChangedMsg()
  {
    SystemContext.executorService.postUITask(new SessionStateChangeTask(null));
    SessionListener[] arrayOfSessionListener = (SessionListener[])SystemContext.appContext.getServices(SessionListener.class, this.policy.filterProperties);
    int j = arrayOfSessionListener.length;
    int i = 0;
    while (i < j)
    {
      SessionListener localSessionListener = arrayOfSessionListener[i];
      SystemContext.executorService.postUITask(new CredentialManager.1(this, localSessionListener));
      i += 1;
    }
  }
  
  private void preInit()
  {
    if (SystemContext.securityGuardService == null) {
      SystemContext.securityGuardService = SecurityGuardWrapper.INSTANCE;
    }
    if (this.policy == null) {
      this.policy = new CredentialManagerPolicy();
    }
    Object localObject = SystemContext.securityGuardService.getValueFromDynamicDataStore("loginEnvironmentIndex");
    String str = String.valueOf(SystemContext.appContext.getEnvironment().ordinal());
    if ((localObject != null) && (!((String)localObject).equals(str)))
    {
      SystemContext.securityGuardService.putValueInDynamicDataStore("loginEnvironmentIndex", str);
      SystemContext.securityGuardService.removeValueFromDynamicDataStore(this.policy.internalSessionStoreKey);
      SystemContext.securityGuardService.removeValueFromDynamicDataStore(this.policy.refreshTokenStoreKey);
    }
    do
    {
      return;
      str = SystemContext.securityGuardService.getValueFromDynamicDataStore(this.policy.internalSessionStoreKey);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = SystemContext.securityGuardService.getValueFromDynamicDataStore(this.policy.internalSessionStoreKey);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.internalSession = SystemUtils.toInternalSession((String)localObject);
      }
      str = SystemContext.securityGuardService.getValueFromDynamicDataStore(this.policy.refreshTokenStoreKey);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = SystemContext.securityGuardService.getValueFromDynamicDataStore(this.policy.refreshTokenStoreKey);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.refreshToken = SystemUtils.toRefreshToken((String)localObject);
      }
      if ((!"true".equals(AlibabaSDK.getProperty("system", "disableCredentialCleanUp"))) && (CommonUtils.isApplicationDefaultProcess() == 1) && (this.refreshToken == null) && (this.internalSession != null) && (this.internalSession.user != null) && (this.internalSession.user.id != null))
      {
        this.internalSession = new InternalSession();
        SystemContext.securityGuardService.removeValueFromDynamicDataStore(this.policy.internalSessionStoreKey);
        SystemContext.securityGuardService.removeValueFromDynamicDataStore(this.policy.refreshTokenStoreKey);
      }
    } while ((!this.policy.isUpdateWebCookie) || (this.internalSession == null) || (this.internalSession.cookies == null));
    EventBus.getDefault().sendEvent("session.init", Collections.singletonMap("cookies", this.internalSession.cookies));
  }
  
  private ResultCode processRefreshSessionResult(Result<String> paramResult, ActionTraceLogger paramActionTraceLogger)
  {
    i = paramResult.code;
    Object localObject = (String)paramResult.data;
    if (i == 1) {}
    try
    {
      handleRefreshSidResponse((String)localObject, true);
      paramActionTraceLogger.success();
      return ResultCode.SUCCESS;
    }
    catch (JSONException localJSONException)
    {
      paramActionTraceLogger.failed("e", localJSONException.getMessage());
      paramResult = MessageUtils.createMessage(10004, new Object[] { " code = " + i + " message = " + paramResult.message + " " + localJSONException.getMessage() });
      AliSDKLogger.log(TAG, paramResult, localJSONException);
      throw new AlibabaSDKException(paramResult, localJSONException);
    }
    if (i == 205)
    {
      handleRefreshSidResponse((String)localObject, false);
      localObject = getReToken();
      removeReToken();
      if (localObject != null) {
        postSessionStateChangedMsg();
      }
      paramActionTraceLogger.failed("code", "REFRESH_SID_EXCEPTION");
      return ResultCode.create(101, new Object[] { paramResult.message });
    }
    if (i == 203)
    {
      paramActionTraceLogger.failed("code", "RSA_DECRYPT_EXCEPTION");
      return ResultCode.create(10005, new Object[] { paramResult.message });
    }
    paramActionTraceLogger.failed("code", String.valueOf(i));
    localObject = MessageUtils.createMessage(10004, new Object[] { " code = " + i + " message = " + paramResult.message });
    AliSDKLogger.log(TAG, (Message)localObject);
    throw new AlibabaSDKException((Message)localObject);
  }
  
  private void refreshInternalSession(InternalSession paramInternalSession)
  {
    paramInternalSession.expireIn = Integer.valueOf(paramInternalSession.expireIn.intValue() - 120);
    this.internalSession = paramInternalSession;
    SystemContext.securityGuardService.putValueInDynamicDataStore(this.policy.internalSessionStoreKey, SystemUtils.toInternalSessionJSON(paramInternalSession));
  }
  
  private void refreshReToken(RefreshToken paramRefreshToken)
  {
    paramRefreshToken.expireIn = Integer.valueOf(paramRefreshToken.expireIn.intValue() - 120);
    this.refreshToken = paramRefreshToken;
    SystemContext.securityGuardService.putValueInDynamicDataStore(this.policy.refreshTokenStoreKey, SystemUtils.toRefreshTokenJSON(paramRefreshToken));
  }
  
  private void removeReToken()
  {
    this.refreshToken = null;
    SystemContext.securityGuardService.removeValueFromDynamicDataStore(this.policy.refreshTokenStoreKey);
  }
  
  private Result<String> requestInitServer(String paramString1, String paramString2, String paramString3)
  {
    SecurityGuardService localSecurityGuardService = SystemContext.securityGuardService;
    HashMap localHashMap = new HashMap();
    localHashMap.put("appKey", localSecurityGuardService.getAppKey());
    localHashMap.put("clientTimestamp", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("securityToken", localSecurityGuardService.getSecurityToken());
    localHashMap.put("sdkVersion", ConfigManager.SDK_INTERNAL_VERSION);
    if (paramString2 != null) {
      localHashMap.put("refreshToken", paramString2);
    }
    if (paramString1 != null) {
      localHashMap.put("sid", paramString1);
    }
    paramString2 = new JSONObject(localHashMap).toString();
    paramString1 = new HashMap();
    paramString1.put("certName", "201506");
    paramString1.put("seedKey", localSecurityGuardService.genAsymEncryptedSeedKey(this.policy.seedKey));
    paramString1.put("data", localSecurityGuardService.symEncrypt(paramString2, this.policy.seedKey));
    paramString2 = localSecurityGuardService.sign(paramString2, this.policy.seedKey);
    if (paramString2 != null)
    {
      if (AliSDKLogger.isDebugEnabled()) {
        SdkCoreLog.d(TAG, "sign: " + paramString2);
      }
      paramString1.put("sign", paramString2);
    }
    paramString1 = SecurityUtils.requestInitServer(paramString1, paramString3);
    if (AliSDKLogger.isDebugEnabled()) {
      SdkCoreLog.d(TAG, "request init server, response: " + paramString1);
    }
    return paramString1;
  }
  
  private void updateUTUser(User paramUser)
  {
    if (this.policy.isUpdateUTUser) {
      try
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("user_nick", paramUser.nick);
        Long localLong = null;
        if (paramUser.id != null) {
          localLong = SystemContext.securityService.analyzeUserId(paramUser.id);
        }
        if (localLong != null) {}
        for (paramUser = String.valueOf(localLong);; paramUser = paramUser.id)
        {
          localHashMap.put("user_id", paramUser);
          SystemContext.userTrackerService.updateUserTrackerProperties(localHashMap);
          return;
        }
        return;
      }
      catch (Exception paramUser)
      {
        AliSDKLogger.e(TAG, "Fail to update UT properties, the error message is " + paramUser.getMessage(), paramUser);
      }
    }
  }
  
  public InternalSession createInternalSession(JSONObject paramJSONObject)
  {
    localInternalSession = new InternalSession();
    localInternalSession.sid = JSONUtils.optString(paramJSONObject, "sid");
    localInternalSession.expireIn = JSONUtils.optInteger(paramJSONObject, "expireIn");
    Object localObject1 = paramJSONObject.optJSONObject("user");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new User();
      ((User)localObject2).avatarUrl = ((JSONObject)localObject1).optString("avatarUrl");
      ((User)localObject2).id = ((JSONObject)localObject1).optString("id");
      ((User)localObject2).nick = ((JSONObject)localObject1).optString("nick");
      localInternalSession.user = ((User)localObject2);
    }
    localInternalSession.createTime = Long.valueOf(System.currentTimeMillis());
    paramJSONObject = paramJSONObject.optJSONObject("cookiesMap");
    if (paramJSONObject != null) {
      try
      {
        localInternalSession.cookies = new HashMap();
        localObject1 = paramJSONObject.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          JSONArray localJSONArray = paramJSONObject.optJSONArray((String)localObject2);
          if (localJSONArray != null) {
            localInternalSession.cookies.put(localObject2, JSONUtils.toStringArray(localJSONArray));
          }
        }
        return localInternalSession;
      }
      catch (Exception paramJSONObject)
      {
        AliSDKLogger.e(TAG, "fail to parse the cookies", paramJSONObject);
      }
    }
  }
  
  public CredentialManagerPolicy getCredentialManagerPolicy()
  {
    return this.policy;
  }
  
  public InternalSession getInternalSession()
  {
    return this.internalSession;
  }
  
  public String getReToken()
  {
    if (this.refreshToken == null) {
      return null;
    }
    return this.refreshToken.token;
  }
  
  public Session getSession()
  {
    return new CredentialManager.2(this);
  }
  
  public Object getSessionExtraInfos(String paramString)
  {
    if ((!"cookies".equals(paramString)) || (this.internalSession == null)) {
      return null;
    }
    return this.internalSession.cookies;
  }
  
  public InitializationHandler<ResultCode> getSessionInitHandler(boolean paramBoolean)
  {
    return new SessionInitHandler(paramBoolean);
  }
  
  public SessionListener getSessionListener()
  {
    return this.sessionListener;
  }
  
  public String getSid()
  {
    if (this.internalSession == null) {
      return null;
    }
    return this.internalSession.sid;
  }
  
  public ResultCode init()
  {
    if (ConfigManager.DEBUG) {
      SdkCoreLog.startTimeRecord("credentialInit");
    }
    try
    {
      if (isNeedRefreshSession()) {
        return refreshSession();
      }
      if (ConfigManager.DEBUG) {
        SdkCoreLog.d("credentialInit", SdkCoreLog.content(TAG, SdkCoreLog.getTimeUsed("credentialInit"), new String[] { "success" }));
      }
      return ResultCode.SUCCESS;
    }
    catch (Throwable localThrowable)
    {
      if (ConfigManager.DEBUG) {
        SdkCoreLog.d("credentialInit", SdkCoreLog.content(TAG, SdkCoreLog.getTimeUsed("credentialInit"), new String[] { "failure" }));
      }
      AliSDKLogger.e(TAG, localThrowable.getMessage(), localThrowable);
    }
    return ResultCode.SYSTEM_EXCEPTION;
  }
  
  public boolean isRefreshTokenExpired()
  {
    if (this.refreshToken == null) {}
    while ((System.currentTimeMillis() - this.refreshToken.createTime.longValue()) / 1000L > this.refreshToken.expireIn.intValue()) {
      return true;
    }
    return false;
  }
  
  public ResultCode logout()
  {
    if (!getSession().isLogin().booleanValue()) {
      return ResultCode.create(10011, new Object[0]);
    }
    Object localObject1 = requestInitServer(getSid(), this.refreshToken.token, SystemContext.logoutUrl);
    int i = ((Result)localObject1).code;
    Object localObject2 = (String)((Result)localObject1).data;
    if (i != 1)
    {
      localObject2 = new StringBuilder().append("code ").append(i);
      if (((Result)localObject1).message == null) {}
      for (localObject1 = "";; localObject1 = ((Result)localObject1).message)
      {
        localObject1 = Message.create(10004, new Object[] { (String)localObject1 });
        AliSDKLogger.log(TAG, (Message)localObject1);
        throw new AlibabaSDKException((Message)localObject1);
      }
    }
    StringBuilder localStringBuilder;
    try
    {
      localObject2 = new JSONObject(SystemContext.securityGuardService.symDecrypt((String)localObject2, this.policy.seedKey));
      refreshInternalSession(createInternalSession((JSONObject)localObject2));
      removeReToken();
      postSessionStateChangedMsg();
      return ResultCode.SUCCESS;
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder().append("code ").append(i);
      if (((Result)localObject1).message != null) {}
    }
    for (localObject1 = "";; localObject1 = ((Result)localObject1).message)
    {
      localObject1 = Message.create(10004, new Object[] { (String)localObject1 });
      AliSDKLogger.log(TAG, (Message)localObject1, localJSONException);
      throw new AlibabaSDKException((Message)localObject1, localJSONException);
    }
  }
  
  public ResultCode refreshSession()
  {
    try
    {
      if (AliSDKLogger.isDebugEnabled()) {
        AliSDKLogger.d("refreshSession");
      }
      InitializationServiceClient localInitializationServiceClient = (InitializationServiceClient)SystemContext.appContext.getService(InitializationServiceClient.class);
      Object localObject1 = localInitializationServiceClient;
      if (localInitializationServiceClient == null) {
        localObject1 = new DefaultInitializationServiceClientImpl(SystemContext.appContext);
      }
      localObject1 = (ResultCode)((InitializationServiceClient)localObject1).request(this.forceSessionInitHandler, ResultCode.class);
      return (ResultCode)localObject1;
    }
    finally {}
  }
  
  public void refreshWhenLogin(LoginResultData paramLoginResultData)
  {
    InternalSession localInternalSession = new InternalSession();
    if (this.policy.isUpdateWebCookie)
    {
      localInternalSession.cookies = paramLoginResultData.cookiesMap;
      EventBus.getDefault().sendEvent("session.refreshLogin", Collections.singletonMap("cookies", paramLoginResultData.cookiesMap));
    }
    this.authorizationCode = paramLoginResultData.authCode;
    User localUser = new User();
    localUser.id = paramLoginResultData.openId;
    if (paramLoginResultData.taobaoNick != null) {}
    try
    {
      localUser.nick = URLDecoder.decode(paramLoginResultData.taobaoNick, "UTF-8");
      localUser.avatarUrl = paramLoginResultData.avatarUrl;
      localInternalSession.user = localUser;
      localInternalSession.createTime = Long.valueOf(System.currentTimeMillis());
      localInternalSession.expireIn = paramLoginResultData.sessionExpireTime;
      localInternalSession.otherInfo = paramLoginResultData.otherInfo;
      if (this.internalSession == null)
      {
        String str1 = null;
        localInternalSession.sid = str1;
        if ((this.internalSession != null) && (this.internalSession.user != null) && (this.internalSession.user.id != null))
        {
          this.internalSession = null;
          this.refreshToken = null;
          postSessionStateChangedMsg();
        }
        refreshInternalSession(localInternalSession);
        if (this.refreshToken == null) {
          this.refreshToken = new RefreshToken();
        }
        this.refreshToken.createTime = Long.valueOf(System.currentTimeMillis());
        this.refreshToken.token = paramLoginResultData.refreshToken;
        this.refreshToken.expireIn = paramLoginResultData.refreshTokenExpireTime;
        refreshReToken(this.refreshToken);
        updateUTUser(localUser);
        postSessionStateChangedMsg();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AliSDKLogger.e(TAG, localException.getMessage(), localException);
        continue;
        String str2 = this.internalSession.sid;
      }
    }
  }
  
  public void refreshWithInterval()
  {
    InternalSession localInternalSession = getInternalSession();
    Long localLong = null;
    if (localInternalSession != null) {
      localLong = localInternalSession.createTime;
    }
    if ((getSid() == null) || (localLong == null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (AliSDKLogger.isDebugEnabled()) {
        AliSDKLogger.d("isNeedRefresh = " + bool + " nowTime " + System.currentTimeMillis() + " createTime = " + localLong + " sidForceRefreshInterval = " + this.policy.sidForceRefreshInterval);
      }
      if ((bool) || (System.currentTimeMillis() - localLong.longValue() > this.policy.sidForceRefreshInterval) || (!SystemContext.securityGuardService.restoreSecretIfAbsent(this.policy.seedKey))) {
        refreshSession();
      }
      return;
    }
  }
  
  public void setSessionListener(SessionListener paramSessionListener)
  {
    this.sessionListener = paramSessionListener;
  }
  
  private class SessionInitHandler
    implements InitializationHandler<ResultCode>
  {
    private boolean isForceRefresh;
    
    public SessionInitHandler(boolean paramBoolean)
    {
      this.isForceRefresh = paramBoolean;
    }
    
    public Object createRequestParameters()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        byte[] arrayOfByte = SystemContext.securityGuardService.genSeedKey();
        localJSONObject.putOpt("seedKey", Base64.encodeToString(arrayOfByte, 3));
        SystemContext.securityGuardService.saveSecret(CredentialManager.this.policy.seedKey, arrayOfByte);
        localJSONObject.putOpt("refreshToken", CredentialManager.this.getReToken());
        localJSONObject.putOpt("sid", CredentialManager.this.getSid());
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        AliSDKLogger.e(CredentialManager.TAG, localJSONException);
      }
      return localJSONObject;
    }
    
    public String getRequestParameterKey()
    {
      return "session";
    }
    
    public int getRequestRequirement()
    {
      if ((CredentialManager.this.isNeedRefreshSession()) || (this.isForceRefresh)) {
        return 1;
      }
      if (AliSDKLogger.isDebugEnabled()) {
        AliSDKLogger.d("isNeedRefreshSession() = " + CredentialManager.this.isNeedRefreshSession() + " isForceRefresh = " + this.isForceRefresh);
      }
      return 2;
    }
    
    public int getRequestServiceType()
    {
      return 2;
    }
    
    public String getResponseValueKey()
    {
      return "session";
    }
    
    public void handleResponseError(int paramInt, String paramString) {}
    
    public ResultCode handleResponseValue(JSONObject paramJSONObject)
    {
      if (AliSDKLogger.isDebugEnabled()) {
        AliSDKLogger.d("handleInitSession response " + paramJSONObject);
      }
      ActionTraceLogger localActionTraceLogger = TraceLoggerManager.INSTANCE.action("system", "refreshSession").begin();
      Result localResult = new Result();
      localResult.code = paramJSONObject.optInt("code");
      localResult.data = JSONUtils.optString(paramJSONObject, "data");
      localResult.message = JSONUtils.optString(paramJSONObject, "message");
      return CredentialManager.this.processRefreshSessionResult(localResult, localActionTraceLogger);
    }
  }
  
  private class SessionStateChangeTask
    implements Runnable
  {
    private SessionStateChangeTask() {}
    
    public void run()
    {
      SessionListener localSessionListener = CredentialManager.this.sessionListener;
      if (localSessionListener != null) {
        localSessionListener.onStateChanged(CredentialManager.this.getSession());
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\impl\CredentialManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */