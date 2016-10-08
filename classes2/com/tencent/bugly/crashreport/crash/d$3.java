package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;

final class d$3
  implements Runnable
{
  d$3(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    try
    {
      d.c().a(this.a, this.b, this.c, this.d, this.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (w.b(localThrowable) != true) {
        localThrowable.printStackTrace();
      }
      w.e("cocos2d-x crash error %s %s %s", new Object[] { this.c, this.d, this.e });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\d$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */