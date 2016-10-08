package com.alibaba.sdk.android.ui.support;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.Version;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.ExecutionResult;
import com.alibaba.sdk.android.ui.bus.UIBus;
import com.alibaba.sdk.android.ui.bus.UIBusRequest;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import com.alibaba.sdk.android.webview.TaeWebView;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;
import com.alibaba.sdk.android.webview.utils.WebViewUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WebViewActivitySupport
{
  private static final String TAG = WebViewActivitySupport.class.getSimpleName();
  private static final String UA_ALIAPP_APPEND = " AliApp(BC/" + ConfigManager.TAE_SDK_VERSION.toString() + ")";
  private static final String UA_TAESDK_APPEND = " tae_sdk_" + ConfigManager.SDK_INTERNAL_VERSION;
  private String lastReloadUrl = "";
  private WeakReference<WebView> superWebViewWR;
  
  public static WebViewActivitySupport getInstance()
  {
    return SingletonHolder.SINGLETON_INSTANCE;
  }
  
  public Map<String, String[]> getCookies()
  {
    if (UIContext.appContext == null) {
      return null;
    }
    CredentialService localCredentialService = (CredentialService)UIContext.appContext.getService(CredentialService.class, Collections.singletonMap("scop", "system"));
    if (localCredentialService == null) {
      return null;
    }
    return (Map)localCredentialService.getSessionExtraInfos("cookies");
  }
  
  public void initSettings(WebView paramWebView)
  {
    this.superWebViewWR = new WeakReference(paramWebView);
    StringBuilder localStringBuilder = new StringBuilder(paramWebView.getSettings().getUserAgentString());
    if (!WebViewUtils.isLoginDowngraded()) {
      localStringBuilder.append(UA_TAESDK_APPEND);
    }
    localStringBuilder.append(UA_ALIAPP_APPEND);
    paramWebView.getSettings().setUserAgentString(localStringBuilder.toString());
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, OnActivityResultCallback paramOnActivityResultCallback)
  {
    if ((paramIntent == null) || (paramActivity == null)) {
      return false;
    }
    paramOnActivityResultCallback = new HashMap();
    paramOnActivityResultCallback.put("requestCodeKey", String.valueOf(paramInt1));
    paramOnActivityResultCallback = (ActivityResultHandler)UIContext.appContext.getService(ActivityResultHandler.class, paramOnActivityResultCallback);
    if (paramOnActivityResultCallback != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(WebView.class, this.superWebViewWR.get());
      paramOnActivityResultCallback.onActivityResult(3, paramInt1, paramInt2, paramIntent, paramActivity, localHashMap);
    }
    return true;
  }
  
  public void onDestory()
  {
    CookieManagerWrapper.INSTANCE.removeCookies();
  }
  
  public void refreshLoginState(String paramString)
  {
    CookieManagerWrapper.INSTANCE.refreshCookie(paramString);
  }
  
  public void safeReload(WebView paramWebView)
  {
    String str = paramWebView.getUrl();
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, "reload url: " + str);
    }
    if (str == null)
    {
      paramWebView.loadUrl(this.lastReloadUrl);
      this.lastReloadUrl = str;
      return;
    }
    if (!"T".equals(AlibabaSDK.getGlobalProperty("DEGRADE_NOT_LOGIN"))) {
      CookieManagerWrapper.INSTANCE.refreshCookie(str);
    }
    this.lastReloadUrl = str;
    paramWebView.reload();
  }
  
  public void safeReload(WebViewProxy paramWebViewProxy)
  {
    String str = paramWebViewProxy.getUrl();
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, "reload url: " + str);
    }
    if (str == null)
    {
      paramWebViewProxy.loadUrl(this.lastReloadUrl);
      this.lastReloadUrl = str;
      return;
    }
    if (!"T".equals(AlibabaSDK.getGlobalProperty("DEGRADE_NOT_LOGIN"))) {
      CookieManagerWrapper.INSTANCE.refreshCookie(str);
    }
    this.lastReloadUrl = str;
    paramWebViewProxy.reload();
  }
  
  public void setCookiesByDomain(String paramString1, String paramString2)
  {
    CookieManagerWrapper.INSTANCE.setDomainCookies(paramString2);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, paramString);
    }
    if (paramWebView == null) {
      return false;
    }
    Object localObject = null;
    if ((paramWebView instanceof TaeWebView)) {
      localObject = ((TaeWebView)paramWebView).getContextParameters();
    }
    UIBusRequest localUIBusRequest = new UIBusRequest();
    localUIBusRequest.webView = paramWebView;
    localUIBusRequest.url = paramString;
    localUIBusRequest.scenario = 2;
    localUIBusRequest.extraParams = new HashMap();
    if (localObject != null) {
      localUIBusRequest.extraParams.put("ui_contextParams", localObject);
    }
    localObject = UIBus.getDefault().execute(localUIBusRequest);
    if (((ExecutionResult)localObject).procceed) {
      return true;
    }
    localObject = ((ExecutionResult)localObject).uri;
    if (!WebViewUtils.isLoginDowngraded()) {
      CookieManagerWrapper.INSTANCE.refreshCookie((String)localObject);
    }
    if (TextUtils.equals((CharSequence)localObject, paramString)) {
      return false;
    }
    if ((paramWebView instanceof TaeWebView)) {
      ((TaeWebView)paramWebView).loadUrl((String)localObject, false);
    }
    for (;;)
    {
      return true;
      paramWebView.loadUrl((String)localObject);
    }
  }
  
  private static class SingletonHolder
  {
    private static final WebViewActivitySupport SINGLETON_INSTANCE = new WebViewActivitySupport(null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\support\WebViewActivitySupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */