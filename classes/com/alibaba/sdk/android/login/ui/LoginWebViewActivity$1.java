package com.alibaba.sdk.android.login.ui;

import android.webkit.WebView;
import com.alibaba.sdk.android.ui.bus.ExecutionResult;
import com.alibaba.sdk.android.ui.bus.UIBus;
import com.alibaba.sdk.android.ui.bus.UIBusRequest;
import com.alibaba.sdk.android.webview.BaseWebViewClient;
import com.alibaba.sdk.android.webview.TaeWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class LoginWebViewActivity$1
  extends BaseWebViewClient
{
  LoginWebViewActivity$1(LoginWebViewActivity paramLoginWebViewActivity) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject = new UIBusRequest();
    ((UIBusRequest)localObject).webView = paramWebView;
    ((UIBusRequest)localObject).url = paramString;
    ((UIBusRequest)localObject).scenario = 2;
    ((UIBusRequest)localObject).scope = "login";
    if (UIBus.getDefault().execute((UIBusRequest)localObject).procceed) {
      return true;
    }
    localObject = paramString;
    String[] arrayOfString;
    int i;
    if (paramString.startsWith("https://aq.taobao.com/durex/wirelessValidate"))
    {
      localObject = paramString;
      if (paramString.contains("+"))
      {
        arrayOfString = paramString.substring(paramString.indexOf("?") + 1, paramString.length()).split("&");
        i = 0;
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (i < arrayOfString.length)
      {
        localObject = arrayOfString[i].split("=");
        if ((localObject.length != 2) || (!localObject[0].equals("param"))) {}
      }
      else
      {
        try
        {
          String str = URLEncoder.encode(localObject[1], "UTF-8");
          localObject = paramString.replace(localObject[1], str);
          if (!(paramWebView instanceof TaeWebView)) {
            break;
          }
          ((TaeWebView)paramWebView).loadUrl((String)localObject, false);
          return true;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      i += 1;
    }
    paramWebView.loadUrl(localUnsupportedEncodingException);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\LoginWebViewActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */