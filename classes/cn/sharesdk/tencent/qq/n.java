package cn.sharesdk.tencent.qq;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.widget.Toast;
import cn.sharesdk.framework.i;
import com.mob.tools.b.g;

class n
  extends i
{
  n(k paramk) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.startsWith("wtloginmqq://")))
    {
      int i = g.b(k.e(this.a), "ssdk_use_login_button");
      if (i > 0) {
        Toast.makeText(k.f(this.a), i, 0).show();
      }
      return;
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    if ((paramString != null) && (paramString.startsWith(k.b(this.a))))
    {
      k.a(this.a, paramString);
      bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    int i;
    do
    {
      return bool;
      if ((paramString != null) && (paramString.startsWith("http://www.myapp.com/down/")))
      {
        k.a(this.a, true);
        break;
      }
      if ((paramString == null) || (!paramString.startsWith("wtloginmqq://"))) {
        break;
      }
      i = g.b(k.c(this.a), "ssdk_use_login_button");
    } while (i <= 0);
    Toast.makeText(k.d(this.a), i, 0).show();
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\tencent\qq\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */