package com.xiaoenai.app.classes.common.share;

import android.webkit.WebView;
import com.xiaoenai.app.utils.f.a;

class av
  implements Runnable
{
  av(at paramat) {}
  
  public void run()
  {
    a.c("======================= onError", new Object[0]);
    at.b(this.a).loadUrl("javascript:shareCallback('" + at.a(this.a) + "','" + 0 + "')");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */