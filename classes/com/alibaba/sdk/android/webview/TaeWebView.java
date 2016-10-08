package com.alibaba.sdk.android.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.Version;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.bus.UIBus;
import com.alibaba.sdk.android.ui.bus.UIBusRequest;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;
import com.alibaba.sdk.android.webview.utils.WebViewUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class TaeWebView
  extends WebView
{
  private static final String TAG = TaeWebView.class.getSimpleName();
  private static final String UA_ALIAPP_APPEND = " AliApp(BC/" + ConfigManager.TAE_SDK_VERSION.toString() + ")";
  private static final String UA_TAESDK_APPEND = " tae_sdk_" + ConfigManager.SDK_INTERNAL_VERSION;
  private String appCacheDir;
  private HashMap<String, String> contextParameters = new HashMap();
  private String lastReloadUrl = "";
  private Map<String, Object> nameToObj = new HashMap();
  private String startUrl;
  
  public TaeWebView(Context paramContext)
  {
    super(paramContext);
    initSettings(paramContext, true);
  }
  
  public TaeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initSettings(paramContext, true);
  }
  
  public TaeWebView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    initSettings(paramContext, paramBoolean);
  }
  
  @TargetApi(21)
  private void initSettings(Context paramContext, boolean paramBoolean)
  {
    WebSettings localWebSettings = getSettings();
    try
    {
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setSavePassword(false);
      localWebSettings.setUseWideViewPort(true);
      localWebSettings.setLoadWithOverviewMode(true);
      localWebSettings.setJavaScriptCanOpenWindowsAutomatically(false);
      localWebSettings.setDomStorageEnabled(true);
      this.appCacheDir = paramContext.getApplicationContext().getDir("cache", 0).getPath();
      localWebSettings.setAppCachePath(this.appCacheDir);
      localWebSettings.setAllowFileAccess(true);
      localWebSettings.setAppCacheEnabled(true);
      if (CommonUtils.isNetworkAvailable(paramContext))
      {
        localWebSettings.setCacheMode(-1);
        localWebSettings.setBuiltInZoomControls(false);
        if (paramBoolean)
        {
          paramContext = new StringBuilder();
          String str = localWebSettings.getUserAgentString();
          if (str != null) {
            paramContext.append(str);
          }
          if (!WebViewUtils.isLoginDowngraded()) {
            paramContext.append(UA_TAESDK_APPEND);
          }
          paramContext.append(UA_ALIAPP_APPEND);
          localWebSettings.setUserAgentString(paramContext.toString());
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
          if (UIContext.pluginConfigurations != null) {
            break label193;
          }
        }
      }
      label193:
      for (int i = -1;; i = UIContext.pluginConfigurations.getIntValue("mixedContentMode", -1))
      {
        if (i != -1) {
          localWebSettings.setMixedContentMode(i);
        }
        return;
        localWebSettings.setCacheMode(1);
        break;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public final void addBridgeObject(String paramString, Object paramObject)
  {
    this.nameToObj.put(paramString, paramObject);
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public void clearCache()
  {
    try
    {
      clearCache(true);
      UIContext.executorService.postTask(new TaeWebView.1(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AliSDKLogger.e("ui", "fail to clear cache ", localException);
      }
    }
  }
  
  public Object getBridgeObj(String paramString)
  {
    return this.nameToObj.get(paramString);
  }
  
  public HashMap<String, String> getContextParameters()
  {
    return this.contextParameters;
  }
  
  public void loadUrl(String paramString)
  {
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, "load url: " + paramString);
    }
    if (paramString != null)
    {
      this.startUrl = normalizeURL(paramString);
      if (this.startUrl != null) {
        super.loadUrl(this.startUrl);
      }
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, "load url: " + paramString);
    }
    if (paramString != null)
    {
      this.startUrl = normalizeURL(paramString);
      if (this.startUrl != null) {
        super.loadUrl(this.startUrl, paramMap);
      }
    }
  }
  
  public void loadUrl(String paramString, boolean paramBoolean)
  {
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, "load url: " + paramString);
    }
    if (paramString != null)
    {
      String str = paramString;
      if (paramBoolean) {
        str = normalizeURL(paramString);
      }
      if (str != null) {
        super.loadUrl(str);
      }
    }
  }
  
  protected String normalizeURL(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new UIBusRequest();
      ((UIBusRequest)localObject).scenario = 1;
      ((UIBusRequest)localObject).url = paramString;
      ((UIBusRequest)localObject).extraParams = new HashMap();
      ((UIBusRequest)localObject).extraParams.put("ui_contextParams", this.contextParameters);
      localObject = UIBus.getDefault().doFilters((UIBusRequest)localObject);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AliSDKLogger.e("ui", "fail to execute do filters for url " + paramString + ", the error message is " + localException.getMessage(), localException);
      }
    }
    refreshCookies(paramString);
    return paramString;
  }
  
  protected void refreshCookies(String paramString)
  {
    if (WebViewUtils.isLoginDowngraded()) {
      return;
    }
    try
    {
      CookieManagerWrapper.INSTANCE.refreshCookie(paramString);
      return;
    }
    catch (Exception paramString)
    {
      AliSDKLogger.e("ui", "fail to refresh cookie", paramString);
    }
  }
  
  public void reload()
  {
    String str = getUrl();
    if (AliSDKLogger.isDebugEnabled()) {
      AliSDKLogger.d(TAG, "reload url: " + str);
    }
    if ((TextUtils.equals(this.lastReloadUrl, str)) || (TextUtils.equals(this.lastReloadUrl, this.startUrl))) {
      return;
    }
    if (str == null)
    {
      loadUrl(this.startUrl);
      this.lastReloadUrl = this.startUrl;
      return;
    }
    if (!"T".equals(AlibabaSDK.getGlobalProperty("DEGRADE_NOT_LOGIN"))) {
      CookieManagerWrapper.INSTANCE.refreshCookie(str);
    }
    this.lastReloadUrl = str;
    super.reload();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\TaeWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */