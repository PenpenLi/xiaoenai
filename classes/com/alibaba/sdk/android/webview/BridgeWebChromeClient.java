package com.alibaba.sdk.android.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.ui.UIContext;
import java.lang.reflect.Method;

public class BridgeWebChromeClient
  extends WebChromeClient
{
  private static final String TAG = BridgeWebChromeClient.class.getSimpleName();
  private static boolean evaluateJavascriptSupported;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool = true;; bool = false)
    {
      evaluateJavascriptSupported = bool;
      return;
    }
  }
  
  private void handleWindVaneNoHandler(WebView paramWebView, String paramString)
  {
    try
    {
      int i = paramString.indexOf(':', 9);
      paramWebView.post(new JavaScriptTask(paramWebView, String.format("window.WindVane&&window.WindVane.onFailure(%s,'{\"ret\":\"HY_NO_HANDLER\"');", new Object[] { paramString.substring(i + 1, paramString.indexOf(47, i)) })));
      return;
    }
    catch (Exception paramWebView)
    {
      AliSDKLogger.e("ui", "fail to handler windvane request, the error message is " + paramWebView.getMessage(), paramWebView);
    }
  }
  
  private HavanaBridgeProtocal parseMessage(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    String str1 = ((Uri)localObject).getHost();
    int i = ((Uri)localObject).getPort();
    String str2 = ((Uri)localObject).getLastPathSegment();
    ((Uri)localObject).getQuery();
    int j = paramString.indexOf("?");
    if (j == -1) {}
    for (paramString = null;; paramString = paramString.substring(j + 1))
    {
      localObject = new HavanaBridgeProtocal();
      ((HavanaBridgeProtocal)localObject).methodName = str2;
      ((HavanaBridgeProtocal)localObject).objName = str1;
      ((HavanaBridgeProtocal)localObject).param = paramString;
      ((HavanaBridgeProtocal)localObject).requestId = i;
      return (HavanaBridgeProtocal)localObject;
    }
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (UIContext.pluginConfigurations != null) {}
    for (boolean bool = UIContext.pluginConfigurations.getBooleanValue("useToastForJsAlert", false);; bool = false)
    {
      if (bool)
      {
        Toast.makeText(paramWebView.getContext(), paramString2, 1).show();
        return true;
      }
      return false;
    }
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (paramString3 == null) {
      return false;
    }
    if ((UIContext.pluginConfigurations != null) && (UIContext.pluginConfigurations.getStringValue("blockJsPromptDefaultValues", "").indexOf(paramString3) != -1))
    {
      paramJsPromptResult.confirm("");
      return true;
    }
    if (paramString3.equals("wv_hybrid:"))
    {
      handleWindVaneNoHandler(paramWebView, paramString2);
      paramJsPromptResult.confirm("");
      return true;
    }
    if (!TextUtils.equals(paramString3, "hv_hybrid:")) {
      return false;
    }
    if (!(paramWebView instanceof TaeWebView)) {
      return false;
    }
    paramString3 = (TaeWebView)paramWebView;
    paramWebView = parseMessage(paramString2);
    paramString1 = new BridgeCallbackContext();
    paramString1.requestId = paramWebView.requestId;
    paramString1.webView = paramString3;
    paramString2 = paramString3.getBridgeObj(paramWebView.objName);
    if (paramString2 == null)
    {
      paramWebView = MessageUtils.createMessage(10000, new Object[] { paramWebView.objName });
      AliSDKLogger.log(TAG, paramWebView);
      paramString1.onFailure(paramWebView.code, paramWebView.message);
      paramJsPromptResult.confirm("");
      return true;
    }
    for (;;)
    {
      try
      {
        paramString3 = paramString2.getClass().getMethod(paramWebView.methodName, new Class[] { BridgeCallbackContext.class, String.class });
        if (!paramString3.isAnnotationPresent(BridgeMethod.class)) {
          break label366;
        }
      }
      catch (NoSuchMethodException paramString2)
      {
        paramWebView = MessageUtils.createMessage(951, new Object[] { paramWebView.objName, paramWebView.methodName });
        AliSDKLogger.log(TAG, paramWebView, paramString2);
        paramString1.onFailure(paramWebView.code, paramWebView.message);
        paramJsPromptResult.confirm("");
        return true;
      }
      try
      {
        if (!TextUtils.isEmpty(paramWebView.param)) {
          break label316;
        }
        paramWebView = "{}";
        paramString3.invoke(paramString2, new Object[] { paramString1, paramWebView });
      }
      catch (Exception paramWebView)
      {
        paramString2 = MessageUtils.createMessage(10010, new Object[] { paramWebView.getMessage() });
        AliSDKLogger.log(TAG, paramString2, paramWebView);
        paramString1.onFailure(paramString2.code, paramString2.message);
        continue;
      }
      paramJsPromptResult.confirm("");
      return true;
      label316:
      paramWebView = paramWebView.param;
      continue;
      label366:
      paramWebView = MessageUtils.createMessage(952, new Object[] { paramWebView.objName, paramWebView.methodName });
      AliSDKLogger.log(TAG, paramWebView);
      paramString1.onFailure(paramWebView.code, paramWebView.message);
    }
  }
  
  private static class JavaScriptTask
    implements Runnable
  {
    public String script;
    public WebView webView;
    
    public JavaScriptTask(WebView paramWebView, String paramString)
    {
      this.webView = paramWebView;
      this.script = paramString;
    }
    
    @TargetApi(19)
    public void run()
    {
      try
      {
        boolean bool = BridgeWebChromeClient.evaluateJavascriptSupported;
        if (bool) {}
        for (;;)
        {
          try
          {
            this.webView.evaluateJavascript(this.script, null);
            return;
          }
          catch (Exception localException1)
          {
            AliSDKLogger.e("ui", "fail to evaluate the script " + localException1.getMessage(), localException1);
          }
          if (UIContext.pluginConfigurations != null) {}
          for (bool = UIContext.pluginConfigurations.getBooleanValue("executeJavaScriptWithLoadUrl", true); bool; bool = true)
          {
            String str = "javascript:" + this.script;
            if ((this.webView instanceof TaeWebView))
            {
              ((TaeWebView)this.webView).loadUrl(str, false);
              return;
            }
            this.webView.loadUrl(str);
            return;
          }
        }
        return;
      }
      catch (Exception localException2) {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BridgeWebChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */