package com.alibaba.sdk.android.ui.support;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.webview.BaseWebViewActivity;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;
import java.util.Map;

public abstract class BaseActivityResultHandler
  implements ActivityResultHandler
{
  private static final String TAG = "system";
  
  public void onActivityResult(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap)
  {
    WebView localWebView = (WebView)paramMap.get(WebView.class);
    if (paramInt1 == 1)
    {
      onCallbackContext(paramInt2, paramInt3, paramIntent, paramActivity, paramMap, localWebView);
      return;
    }
    if (paramInt1 == 2)
    {
      if ((paramActivity instanceof BaseWebViewActivity))
      {
        onTaeSDKActivity(paramInt2, paramInt3, paramIntent, (BaseWebViewActivity)paramActivity, paramMap, localWebView);
        return;
      }
      AliSDKLogger.e("system", "OnActivityResult is invoked from unsupported activity type " + paramActivity.getClass().getName());
      return;
    }
    if (paramInt1 == 3)
    {
      onWebViewActivitySupport(paramInt2, paramInt3, paramIntent, paramActivity, paramMap, (OnActivityResultCallback)paramMap.get(OnActivityResultCallback.class), localWebView);
      return;
    }
    if (paramInt1 == 4)
    {
      onWebViewProxyActivitySupport(paramInt2, paramInt3, paramIntent, paramActivity, paramMap, (OnActivityResultCallback)paramMap.get(OnActivityResultCallback.class), (WebViewProxy)paramMap.get(WebViewProxy.class));
      return;
    }
    AliSDKLogger.e("system", "Unrecognized source " + paramInt1);
  }
  
  protected abstract void onCallbackContext(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap, WebView paramWebView);
  
  protected abstract void onTaeSDKActivity(int paramInt1, int paramInt2, Intent paramIntent, BaseWebViewActivity paramBaseWebViewActivity, Map<Class<?>, Object> paramMap, WebView paramWebView);
  
  protected abstract void onWebViewActivitySupport(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap, OnActivityResultCallback paramOnActivityResultCallback, WebView paramWebView);
  
  protected abstract void onWebViewProxyActivitySupport(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap, OnActivityResultCallback paramOnActivityResultCallback, WebViewProxy paramWebViewProxy);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\support\BaseActivityResultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */