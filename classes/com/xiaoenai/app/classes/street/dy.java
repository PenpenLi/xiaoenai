package com.xiaoenai.app.classes.street;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.xiaoenai.app.classes.common.webview.w;
import com.xiaoenai.app.ui.component.view.ProgressView;

class dy
  extends w
{
  dy(StreetWebPageActivity paramStreetWebPageActivity, String paramString)
  {
    super(paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((StreetWebPageActivity.c(this.a)) && (StreetWebPageActivity.d(this.a) != null) && (StreetWebPageActivity.d(this.a).length() > 0))
    {
      StreetWebPageActivity.a(this.a, false);
      StreetWebPageActivity.a(this.a).loadData(StreetWebPageActivity.d(this.a), "text/html; charset=UTF-8", null);
      return;
    }
    StreetWebPageActivity.b(this.a).b();
    StreetWebPageActivity.a(this.a).setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    StreetWebPageActivity.b(this.a).a();
    StreetWebPageActivity.a(this.a).setVisibility(4);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    StreetWebPageActivity.b(this.a).b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */