package com.alibaba.sdk.android.login.impl;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.login.LoginServiceProvider;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.login.task.RefreshPageAfterOpenTb;
import com.alibaba.sdk.android.login.task.RefreshProxyPageAfterOpenTb;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.system.RequestCode;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.support.BaseActivityResultHandler;
import com.alibaba.sdk.android.ui.support.OnActivityResultCallback;
import com.alibaba.sdk.android.ui.support.WebViewActivitySupport;
import com.alibaba.sdk.android.ut.UserTrackerService;
import com.alibaba.sdk.android.webview.BaseWebViewActivity;
import com.alibaba.sdk.android.webview.proxy.WebViewProxy;
import java.lang.ref.WeakReference;
import java.util.Map;

public class LoginActivityResultHandler
  extends BaseActivityResultHandler
{
  private static final String TAG = "login";
  
  private void onLoginFailure(String paramString, LoginCallback paramLoginCallback, int paramInt)
  {
    LoginContext.userTrackerService.sendCustomHit(paramString, (Activity)CallbackContext.activity.get());
    if (paramLoginCallback != null)
    {
      paramString = MessageUtils.createMessage(paramInt, new Object[0]);
      paramLoginCallback.onFailure(paramString.code, paramString.message);
    }
  }
  
  private void onLoginSuccess(String paramString, LoginCallback paramLoginCallback)
  {
    LoginContext.userTrackerService.sendCustomHit(paramString, (Activity)CallbackContext.activity.get());
    if (paramLoginCallback != null) {
      paramLoginCallback.onSuccess(LoginContext.credentialService.getSession());
    }
  }
  
  /* Error */
  protected void onCallbackContext(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap, WebView paramWebView)
  {
    // Byte code:
    //   0: getstatic 86	com/alibaba/sdk/android/callback/CallbackContext:loginCallback	Ljava/lang/Object;
    //   3: checkcast 60	com/alibaba/sdk/android/login/callback/LoginCallback
    //   6: astore 4
    //   8: iload_1
    //   9: getstatic 91	com/alibaba/sdk/android/system/RequestCode:OPEN_H5_LOGIN	I
    //   12: if_icmpne +52 -> 64
    //   15: iload_2
    //   16: getstatic 97	com/alibaba/sdk/android/ResultCode:SUCCESS	Lcom/alibaba/sdk/android/ResultCode;
    //   19: getfield 98	com/alibaba/sdk/android/ResultCode:code	I
    //   22: if_icmpne +26 -> 48
    //   25: aload_0
    //   26: ldc 100
    //   28: aload 4
    //   30: invokespecial 102	com/alibaba/sdk/android/login/impl/LoginActivityResultHandler:onLoginSuccess	(Ljava/lang/String;Lcom/alibaba/sdk/android/login/callback/LoginCallback;)V
    //   33: iconst_1
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +11 -> 47
    //   39: aconst_null
    //   40: putstatic 86	com/alibaba/sdk/android/callback/CallbackContext:loginCallback	Ljava/lang/Object;
    //   43: aconst_null
    //   44: putstatic 27	com/alibaba/sdk/android/callback/CallbackContext:activity	Ljava/lang/ref/WeakReference;
    //   47: return
    //   48: aload_0
    //   49: ldc 104
    //   51: aload 4
    //   53: sipush 10003
    //   56: invokespecial 106	com/alibaba/sdk/android/login/impl/LoginActivityResultHandler:onLoginFailure	(Ljava/lang/String;Lcom/alibaba/sdk/android/login/callback/LoginCallback;I)V
    //   59: iconst_1
    //   60: istore_1
    //   61: goto -26 -> 35
    //   64: iload_1
    //   65: getstatic 109	com/alibaba/sdk/android/system/RequestCode:OPEN_TAOBAO	I
    //   68: if_icmpne +147 -> 215
    //   71: iload_2
    //   72: iconst_m1
    //   73: if_icmpne +62 -> 135
    //   76: getstatic 21	com/alibaba/sdk/android/login/impl/LoginContext:userTrackerService	Lcom/alibaba/sdk/android/ut/UserTrackerService;
    //   79: ldc 111
    //   81: getstatic 27	com/alibaba/sdk/android/callback/CallbackContext:activity	Ljava/lang/ref/WeakReference;
    //   84: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   87: checkcast 35	android/app/Activity
    //   90: invokeinterface 41 3 0
    //   95: new 113	com/alibaba/sdk/android/login/task/LoginAfterOpenTb
    //   98: dup
    //   99: getstatic 27	com/alibaba/sdk/android/callback/CallbackContext:activity	Ljava/lang/ref/WeakReference;
    //   102: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   105: checkcast 35	android/app/Activity
    //   108: aload 4
    //   110: invokespecial 116	com/alibaba/sdk/android/login/task/LoginAfterOpenTb:<init>	(Landroid/app/Activity;Lcom/alibaba/sdk/android/login/callback/LoginCallback;)V
    //   113: iconst_1
    //   114: anewarray 118	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: ldc 120
    //   122: invokevirtual 126	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   125: aastore
    //   126: invokevirtual 130	com/alibaba/sdk/android/login/task/LoginAfterOpenTb:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   129: pop
    //   130: iconst_1
    //   131: istore_1
    //   132: goto -97 -> 35
    //   135: iload_2
    //   136: ifne +19 -> 155
    //   139: aload_0
    //   140: ldc -124
    //   142: aload 4
    //   144: sipush 10003
    //   147: invokespecial 106	com/alibaba/sdk/android/login/impl/LoginActivityResultHandler:onLoginFailure	(Ljava/lang/String;Lcom/alibaba/sdk/android/login/callback/LoginCallback;I)V
    //   150: iconst_1
    //   151: istore_1
    //   152: goto -117 -> 35
    //   155: invokestatic 138	com/alibaba/sdk/android/trace/AliSDKLogger:isDebugEnabled	()Z
    //   158: ifeq +32 -> 190
    //   161: ldc 8
    //   163: new 140	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   170: ldc -113
    //   172: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: ldc 120
    //   178: invokevirtual 126	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 155	com/alibaba/sdk/android/trace/AliSDKLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: getstatic 161	com/alibaba/sdk/android/login/impl/H5LoginServiceProviderImpl:INSTANCE	Lcom/alibaba/sdk/android/login/LoginServiceProvider;
    //   193: getstatic 27	com/alibaba/sdk/android/callback/CallbackContext:activity	Ljava/lang/ref/WeakReference;
    //   196: invokevirtual 33	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   199: checkcast 35	android/app/Activity
    //   202: aload 4
    //   204: invokeinterface 167 3 0
    //   209: pop
    //   210: iconst_0
    //   211: istore_1
    //   212: goto -177 -> 35
    //   215: iload_1
    //   216: getstatic 170	com/alibaba/sdk/android/system/RequestCode:OPEN_QR_LOGIN	I
    //   219: if_icmpne +26 -> 245
    //   222: iload_2
    //   223: getstatic 97	com/alibaba/sdk/android/ResultCode:SUCCESS	Lcom/alibaba/sdk/android/ResultCode;
    //   226: getfield 98	com/alibaba/sdk/android/ResultCode:code	I
    //   229: if_icmpne +57 -> 286
    //   232: aload_0
    //   233: ldc -84
    //   235: aload 4
    //   237: invokespecial 102	com/alibaba/sdk/android/login/impl/LoginActivityResultHandler:onLoginSuccess	(Ljava/lang/String;Lcom/alibaba/sdk/android/login/callback/LoginCallback;)V
    //   240: iconst_1
    //   241: istore_1
    //   242: goto -207 -> 35
    //   245: iload_1
    //   246: getstatic 175	com/alibaba/sdk/android/system/RequestCode:OPEN_QR_LOGIN_CONFIRM	I
    //   249: if_icmpne +37 -> 286
    //   252: iload_2
    //   253: getstatic 97	com/alibaba/sdk/android/ResultCode:SUCCESS	Lcom/alibaba/sdk/android/ResultCode;
    //   256: getfield 98	com/alibaba/sdk/android/ResultCode:code	I
    //   259: if_icmpne +16 -> 275
    //   262: aload_0
    //   263: ldc -79
    //   265: aload 4
    //   267: invokespecial 102	com/alibaba/sdk/android/login/impl/LoginActivityResultHandler:onLoginSuccess	(Ljava/lang/String;Lcom/alibaba/sdk/android/login/callback/LoginCallback;)V
    //   270: iconst_1
    //   271: istore_1
    //   272: goto -237 -> 35
    //   275: aload_0
    //   276: ldc -77
    //   278: aload 4
    //   280: sipush 10003
    //   283: invokespecial 106	com/alibaba/sdk/android/login/impl/LoginActivityResultHandler:onLoginFailure	(Ljava/lang/String;Lcom/alibaba/sdk/android/login/callback/LoginCallback;I)V
    //   286: iconst_1
    //   287: istore_1
    //   288: goto -253 -> 35
    //   291: astore_3
    //   292: aconst_null
    //   293: putstatic 86	com/alibaba/sdk/android/callback/CallbackContext:loginCallback	Ljava/lang/Object;
    //   296: aconst_null
    //   297: putstatic 27	com/alibaba/sdk/android/callback/CallbackContext:activity	Ljava/lang/ref/WeakReference;
    //   300: aload_3
    //   301: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	LoginActivityResultHandler
    //   0	302	1	paramInt1	int
    //   0	302	2	paramInt2	int
    //   0	302	3	paramIntent	Intent
    //   0	302	4	paramActivity	Activity
    //   0	302	5	paramMap	Map<Class<?>, Object>
    //   0	302	6	paramWebView	WebView
    // Exception table:
    //   from	to	target	type
    //   8	33	291	finally
    //   48	59	291	finally
    //   64	71	291	finally
    //   76	130	291	finally
    //   139	150	291	finally
    //   155	190	291	finally
    //   190	210	291	finally
    //   215	240	291	finally
    //   245	270	291	finally
    //   275	286	291	finally
  }
  
  protected void onTaeSDKActivity(int paramInt1, int paramInt2, Intent paramIntent, BaseWebViewActivity paramBaseWebViewActivity, Map<Class<?>, Object> paramMap, WebView paramWebView)
  {
    if (paramInt1 == RequestCode.OPEN_H5_LOGIN) {
      if (paramInt2 == ResultCode.SUCCESS.code) {
        paramWebView.reload();
      }
    }
    while (paramInt1 != RequestCode.OPEN_TAOBAO)
    {
      return;
      paramBaseWebViewActivity.setResult(ResultCode.create(10003, new Object[0]));
      return;
    }
    if (paramInt2 == -1)
    {
      new RefreshPageAfterOpenTb(paramBaseWebViewActivity, paramWebView).execute(new String[] { paramIntent.getStringExtra("result") });
      return;
    }
    if (paramInt2 == 0)
    {
      paramBaseWebViewActivity.setResult(ResultCode.create(10003, new Object[0]));
      return;
    }
    AliSDKLogger.e("login", "taobao return " + paramInt2);
    H5LoginServiceProviderImpl.INSTANCE.showLogin((Activity)CallbackContext.activity.get(), null);
  }
  
  protected void onWebViewActivitySupport(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap, OnActivityResultCallback paramOnActivityResultCallback, WebView paramWebView)
  {
    if (paramInt1 == RequestCode.OPEN_H5_LOGIN) {
      if ((paramWebView != null) && (paramInt2 == ResultCode.SUCCESS.code))
      {
        if (CallbackContext.activity != null) {
          LoginContext.userTrackerService.sendCustomHit("h5_login_success", (Activity)CallbackContext.activity.get());
        }
        WebViewActivitySupport.getInstance().safeReload(paramWebView);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (CallbackContext.activity != null) {
            LoginContext.userTrackerService.sendCustomHit("h5_login_failure", (Activity)CallbackContext.activity.get());
          }
        } while (paramOnActivityResultCallback == null);
        paramOnActivityResultCallback.onAuthCancel();
        return;
      } while (paramInt1 != RequestCode.OPEN_TAOBAO);
      if ((paramWebView != null) && (paramInt2 == -1))
      {
        if (CallbackContext.activity != null) {
          LoginContext.userTrackerService.sendCustomHit("tb_login_success", (Activity)CallbackContext.activity.get());
        }
        new RefreshPageAfterOpenTb(paramActivity, paramWebView).execute(new String[] { paramIntent.getStringExtra("result") });
        return;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (CallbackContext.activity != null) {
        LoginContext.userTrackerService.sendCustomHit("tb_login_failure", (Activity)CallbackContext.activity.get());
      }
    } while (paramOnActivityResultCallback == null);
    paramOnActivityResultCallback.onAuthCancel();
    return;
    AliSDKLogger.e("login", "taobao return " + paramInt2);
    H5LoginServiceProviderImpl.INSTANCE.showLogin((Activity)CallbackContext.activity.get(), null);
  }
  
  protected void onWebViewProxyActivitySupport(int paramInt1, int paramInt2, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap, OnActivityResultCallback paramOnActivityResultCallback, WebViewProxy paramWebViewProxy)
  {
    if (paramInt1 == RequestCode.OPEN_H5_LOGIN) {
      if ((paramWebViewProxy != null) && (paramInt2 == ResultCode.SUCCESS.code))
      {
        if (CallbackContext.activity != null) {
          LoginContext.userTrackerService.sendCustomHit("h5_login_success", (Activity)CallbackContext.activity.get());
        }
        WebViewActivitySupport.getInstance().safeReload(paramWebViewProxy);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (CallbackContext.activity != null) {
            LoginContext.userTrackerService.sendCustomHit("h5_login_failure", (Activity)CallbackContext.activity.get());
          }
        } while (paramOnActivityResultCallback == null);
        paramOnActivityResultCallback.onAuthCancel();
        return;
      } while (paramInt1 != RequestCode.OPEN_TAOBAO);
      if ((paramWebViewProxy != null) && (paramInt2 == -1))
      {
        if (CallbackContext.activity != null) {
          LoginContext.userTrackerService.sendCustomHit("tb_login_success", (Activity)CallbackContext.activity.get());
        }
        new RefreshProxyPageAfterOpenTb(paramActivity, paramWebViewProxy).execute(new String[] { paramIntent.getStringExtra("result") });
        return;
      }
      if (paramInt2 != 0) {
        break;
      }
      if (CallbackContext.activity != null) {
        LoginContext.userTrackerService.sendCustomHit("tb_login_failure", (Activity)CallbackContext.activity.get());
      }
    } while (paramOnActivityResultCallback == null);
    paramOnActivityResultCallback.onAuthCancel();
    return;
    AliSDKLogger.e("login", "taobao return " + paramInt2);
    H5LoginServiceProviderImpl.INSTANCE.showLogin((Activity)CallbackContext.activity.get(), null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\LoginActivityResultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */