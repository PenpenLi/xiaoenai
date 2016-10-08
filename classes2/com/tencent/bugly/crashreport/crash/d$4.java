package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.crashreport.crash.h5.b;
import com.tencent.bugly.proguard.w;
import java.util.Map;

final class d$4
  implements Runnable
{
  d$4(Thread paramThread, String paramString1, String paramString2, String paramString3, Map paramMap) {}
  
  public final void run()
  {
    try
    {
      d.d().a(this.a, this.b, this.c, this.d, this.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (w.b(localThrowable) != true) {
        localThrowable.printStackTrace();
      }
      w.e("H5 crash error %s %s %s", new Object[] { this.b, this.c, this.d });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\d$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */