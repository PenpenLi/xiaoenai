package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.z;

final class d$2
  implements Runnable
{
  d$2(Thread paramThread, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    try
    {
      d.b().a(this.a, this.b, this.c, this.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (w.b(localThrowable) != true) {
        localThrowable.printStackTrace();
      }
      w.e("u3d crash error %s %s %s", new Object[] { this.b, this.c, this.d });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\d$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */