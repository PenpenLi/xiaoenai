package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.i;

public abstract class b
  extends i
{
  protected g a;
  protected String b;
  protected AuthorizeListener c;
  
  public b(g paramg)
  {
    this.a = paramg;
    paramg = paramg.a();
    this.b = paramg.getRedirectUri();
    this.c = paramg.getAuthorizeListener();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView.stopLoading();
    paramWebView = this.a.a().getAuthorizeListener();
    this.a.finish();
    if (paramWebView != null) {
      paramWebView.onError(new Throwable(paramString1 + " (" + paramInt + "): " + paramString2));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\authorize\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */