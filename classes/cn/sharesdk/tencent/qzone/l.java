package cn.sharesdk.tencent.qzone;

import android.webkit.WebView;

class l
  extends cn.sharesdk.framework.i
{
  l(i parami) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString != null) && (paramString.startsWith(i.b(this.a)))) {
      i.a(this.a, paramString);
    }
    for (;;)
    {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
      if ((paramString != null) && (paramString.startsWith("mqzone://"))) {
        i.b(this.a, paramString);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qzone\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */