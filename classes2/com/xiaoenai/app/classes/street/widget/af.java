package com.xiaoenai.app.classes.street.widget;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.WebViewInsideViewPager;

class af
  extends WebViewClient
{
  af(ad paramad) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    a.c("===================== onPageFinished {}", new Object[] { paramString });
    if (ad.c(this.a))
    {
      ad.b(this.a, false);
      if ((ad.d(this.a) != null) && (ad.d(this.a).length() > 0)) {
        ad.b(this.a).loadData(ad.d(this.a), "text/html; charset=UTF-8", null);
      }
      return;
    }
    ad.a(this.a, true);
    ad.b(this.a).setVisibility(0);
    ad.a(this.a).findViewById(2131558669).setVisibility(8);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    a.c("===================== onPageStarted", new Object[0]);
    ad.a(this.a).findViewById(2131558669).setVisibility(0);
    ad.b(this.a).setVisibility(8);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    ad.a(this.a).findViewById(2131558669).setVisibility(8);
    ad.a(this.a, false);
    ad.b(this.a).setVisibility(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */