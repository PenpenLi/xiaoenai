package cn.sharesdk.wechat.utils;

import android.os.Handler.Callback;
import android.os.Message;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.b.c;
import com.mob.tools.b.j;
import java.util.HashMap;

class l
  implements Handler.Callback
{
  int a = 0;
  
  l(WechatHelper paramWechatHelper, c paramc, String paramString, PlatformActionListener paramPlatformActionListener, Platform paramPlatform, HashMap paramHashMap) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = this.b.B();
    if (!this.c.equals(paramMessage)) {
      if (this.d != null) {
        this.d.onComplete(this.e, 9, this.f);
      }
    }
    for (;;)
    {
      return true;
      if (this.a < 5)
      {
        this.a += 1;
        j.a(0, 500L, this);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\wechat\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */