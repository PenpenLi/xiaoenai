package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.Utility;

class WeiboGameClient
  extends WeiboWebViewClient
{
  private Activity mAct;
  private GameRequestParam mGameRequestParam;
  private WeiboAuthListener mListener;
  
  public WeiboGameClient(Activity paramActivity, GameRequestParam paramGameRequestParam)
  {
    this.mAct = paramActivity;
    this.mGameRequestParam = paramGameRequestParam;
    this.mListener = this.mGameRequestParam.getAuthListener();
  }
  
  private void handleRedirectUrl(String paramString)
  {
    Bundle localBundle = Utility.parseUrl(paramString);
    String str1;
    String str2;
    if (localBundle.getString("error") == null)
    {
      paramString = "";
      str1 = localBundle.getString("code");
      str2 = localBundle.getString("msg");
      if ((paramString != null) || (str1 != null)) {
        break label68;
      }
      if (this.mListener != null) {
        this.mListener.onComplete(localBundle);
      }
    }
    label68:
    while (this.mListener == null)
    {
      return;
      paramString = localBundle.getString("error");
      break;
    }
    this.mListener.onWeiboException(new WeiboAuthException(str1, paramString, str2));
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.mCallBack != null) {
      this.mCallBack.onPageFinishedCallBack(paramWebView, paramString);
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.mCallBack != null) {
      this.mCallBack.onPageStartedCallBack(paramWebView, paramString, paramBitmap);
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (this.mCallBack != null) {
      this.mCallBack.onReceivedErrorCallBack(paramWebView, paramInt, paramString1, paramString2);
    }
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (this.mCallBack != null) {
      this.mCallBack.onReceivedSslErrorCallBack(paramWebView, paramSslErrorHandler, paramSslError);
    }
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (this.mCallBack != null) {
      this.mCallBack.shouldOverrideUrlLoadingCallBack(paramWebView, paramString);
    }
    if (paramString.startsWith("sinaweibo://browser/close"))
    {
      paramWebView = Utility.parseUri(paramString);
      if ((!paramWebView.isEmpty()) && (this.mListener != null)) {
        this.mListener.onComplete(paramWebView);
      }
      WeiboSdkBrowser.closeBrowser(this.mAct, this.mGameRequestParam.getAuthListenerKey(), null);
      return true;
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboGameClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */