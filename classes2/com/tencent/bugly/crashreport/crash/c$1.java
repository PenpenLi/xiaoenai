package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.w;

final class c$1
  implements Runnable
{
  c$1(c paramc, boolean paramBoolean, Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    try
    {
      w.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
      c.a(this.f).a(this.b, this.c, false, this.d, this.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (w.b(localThrowable) != true) {
        localThrowable.printStackTrace();
      }
      w.e("java catch error: %s", new Object[] { this.c.toString() });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */