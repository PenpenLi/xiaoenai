package com.alibaba.sdk.android.login.impl;

import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.login.utils.LoginUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.rpc.RpcService;
import com.alibaba.sdk.android.rpc.model.RpcRequest;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.web.CookieService;
import java.util.HashMap;
import java.util.Map;

public class LoginComponent
{
  public static final LoginComponent INSTANCE = new LoginComponent();
  private static final String TAG = "login";
  
  public Result<LoginResultData> loginAfterDoubleCheck(String paramString)
  {
    RpcRequest localRpcRequest = new RpcRequest();
    localRpcRequest.target = "thirdpartlogindoublecheck";
    HashMap localHashMap = new HashMap();
    localHashMap.put("tempLoginToken", paramString);
    paramString = new HashMap();
    paramString.put("loginInfo", localHashMap);
    localRpcRequest.params = paramString;
    return LoginUtils.toLoginResultData(LoginContext.rpcService.invoke(localRpcRequest));
  }
  
  public Result<LoginResultData> loginByCode(String paramString)
  {
    RpcRequest localRpcRequest = new RpcRequest();
    localRpcRequest.target = "thirdpartloginbytoken";
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("token", paramString);
    localHashMap2.put("mid", LoginContext.cookieService.getMid());
    localHashMap2.put("utdid", LoginContext.appContext.getUserTrackerId());
    localHashMap1.put("token", localHashMap2);
    localRpcRequest.params = localHashMap1;
    paramString = LoginContext.rpcService.invoke(localRpcRequest);
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d("login", "login by code result json: " + paramString);
    }
    return LoginUtils.toLoginResultData(paramString);
  }
  
  public Result<LoginResultData> loginByTrustToken(String paramString1, String paramString2)
  {
    RpcRequest localRpcRequest = new RpcRequest();
    localRpcRequest.target = "taobao-thirdpart-loginbytrustpasstoken";
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("token", paramString2);
    localHashMap2.put("mid", LoginContext.cookieService.getMid());
    localHashMap2.put("utdid", LoginContext.appContext.getUserTrackerId());
    localHashMap2.put("caller", paramString1);
    localHashMap1.put("token", localHashMap2);
    localRpcRequest.params = localHashMap1;
    paramString1 = LoginContext.rpcService.invoke(localRpcRequest);
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d("login", "login by trust token code result json: " + paramString1);
    }
    return LoginUtils.toLoginResultData(paramString1);
  }
  
  public String loginByUserName(String paramString)
  {
    paramString = RpcRequest.create(paramString);
    if (paramString == null) {
      return null;
    }
    Map localMap = (Map)paramString.params.get("loginInfo");
    localMap.put("mid", LoginContext.cookieService.getMid());
    localMap.put("utdid", LoginContext.appContext.getUserTrackerId());
    return LoginContext.rpcService.invoke(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */