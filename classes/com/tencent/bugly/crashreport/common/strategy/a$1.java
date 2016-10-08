package com.tencent.bugly.crashreport.common.strategy;

import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.w;
import java.util.Map;

final class a$1
  extends Thread
{
  a$1(a parama) {}
  
  public final void run()
  {
    try
    {
      Object localObject2 = o.a().a(a.a, null, true);
      if (localObject2 != null)
      {
        localObject1 = (byte[])((Map)localObject2).get("key_imei");
        localObject2 = (byte[])((Map)localObject2).get("key_ip");
        if (localObject1 != null) {
          com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).e(new String((byte[])localObject1));
        }
        if (localObject2 != null) {
          com.tencent.bugly.crashreport.common.info.a.a(a.a(this.a)).d(new String((byte[])localObject2));
        }
      }
      Object localObject1 = this.a;
      localObject1 = a.d();
      a.a(this.a, (StrategyBean)localObject1);
      this.a.a(a.b(this.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      while (w.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\strategy\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */