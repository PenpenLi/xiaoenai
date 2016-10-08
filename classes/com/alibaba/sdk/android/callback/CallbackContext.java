package com.alibaba.sdk.android.callback;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import com.alibaba.sdk.android.ui.support.ActivityResultHandler;
import com.alibaba.sdk.android.ui.support.UserActivityResultHandler;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CallbackContext
{
  private static final String TAG = CallbackContext.class.getSimpleName();
  public static volatile WeakReference<Activity> activity;
  public static volatile Object loginCallback;
  public static volatile Object paymentProcessCallback;
  public static volatile Object tradeProcessCallback;
  
  public static void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, WebView paramWebView)
  {
    ActivityResultHandler localActivityResultHandler = (ActivityResultHandler)UIContext.appContext.getService(ActivityResultHandler.class, Collections.singletonMap("requestCodeKey", String.valueOf(paramInt1)));
    HashMap localHashMap;
    if (localActivityResultHandler != null)
    {
      localHashMap = new HashMap();
      localHashMap.put(WebView.class, paramWebView);
      if (activity == null) {
        break label80;
      }
    }
    label80:
    for (paramWebView = (Activity)activity.get();; paramWebView = null)
    {
      localActivityResultHandler.onActivityResult(3, paramInt1, paramInt2, paramIntent, paramWebView, localHashMap);
      return;
    }
  }
  
  public static void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, WebViewProxy paramWebViewProxy)
  {
    ActivityResultHandler localActivityResultHandler = (ActivityResultHandler)UIContext.appContext.getService(ActivityResultHandler.class, Collections.singletonMap("requestCodeKey", String.valueOf(paramInt1)));
    if (localActivityResultHandler != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(WebViewProxy.class, paramWebViewProxy);
      localActivityResultHandler.onActivityResult(4, paramInt1, paramInt2, paramIntent, paramActivity, localHashMap);
    }
  }
  
  public static boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (activity != null) {}
    for (Activity localActivity = (Activity)activity.get();; localActivity = null) {
      return onActivityResult(localActivity, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public static boolean onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("requestCodeKey", String.valueOf(paramInt1));
    ActivityResultHandler localActivityResultHandler = (ActivityResultHandler)UIContext.appContext.getService(ActivityResultHandler.class, (Map)localObject);
    if (localActivityResultHandler == null)
    {
      AliSDKLogger.i(TAG, "No ActivityResultHandler handler to support the request code " + paramInt1);
      localObject = (UserActivityResultHandler)UIContext.appContext.getService(UserActivityResultHandler.class, (Map)localObject);
      if (localObject != null)
      {
        ((UserActivityResultHandler)localObject).onActivityResult(paramActivity, paramInt1, paramInt2, paramIntent, null);
        return true;
      }
      AliSDKLogger.i(TAG, "No UserActivityResultHandler handler to support the request code " + paramInt1);
      return false;
    }
    if (paramActivity == null)
    {
      AliSDKLogger.e(TAG, "No active activity is set, ignore invoke " + localActivityResultHandler);
      return false;
    }
    localActivityResultHandler.onActivityResult(1, paramInt1, paramInt2, paramIntent, paramActivity, Collections.emptyMap());
    return true;
  }
  
  public static void setActivity(Activity paramActivity)
  {
    activity = new WeakReference(paramActivity);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\callback\CallbackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */