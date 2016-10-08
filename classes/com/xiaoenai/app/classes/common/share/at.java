package com.xiaoenai.app.classes.common.share;

import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.xiaoenai.app.Xiaoenai;
import java.util.HashMap;

public class at
  implements PlatformActionListener
{
  private WebView a = null;
  private String b = null;
  
  public at() {}
  
  public at(WebView paramWebView, String paramString)
  {
    this.a = paramWebView;
    this.b = paramString;
  }
  
  public void a() {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    a();
    if ((this.a != null) && (this.b != null)) {
      Xiaoenai.j().a(new aw(this));
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    a();
    if ((this.a != null) && (this.b != null)) {
      Xiaoenai.j().a(new au(this));
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    a();
    if ((this.a != null) && (this.b != null)) {
      Xiaoenai.j().a(new av(this));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\share\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */