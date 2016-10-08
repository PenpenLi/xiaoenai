package com.inmobi.commons.core.network;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.a.a;

public class e
{
  private NetworkRequest a;
  private WebViewClient b;
  private WebView c;
  
  public e(NetworkRequest paramNetworkRequest, WebViewClient paramWebViewClient)
  {
    this.b = paramWebViewClient;
    this.a = paramNetworkRequest;
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void b()
  {
    this.c = new WebView(a.b());
    this.c.setWebViewClient(this.b);
    this.c.getSettings().setJavaScriptEnabled(true);
    this.c.getSettings().setCacheMode(2);
  }
  
  public void a()
  {
    b();
    this.c.loadUrl(this.a.j());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\network\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */