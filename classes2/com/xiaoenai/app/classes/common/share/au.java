package com.xiaoenai.app.classes.common.share;

import android.webkit.WebView;
import com.xiaoenai.app.utils.f.a;

class au
  implements Runnable
{
  au(at paramat) {}
  
  public void run()
  {
    a.c("======================= onComplete", new Object[0]);
    at.b(this.a).loadUrl("javascript:shareCallback('" + at.a(this.a) + "','" + 1 + "')");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */