package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.h5.b;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public final class d
{
  private static z a;
  private static y b;
  private static b c;
  
  public static void a(Context paramContext)
  {
    c localc = c.a();
    if (localc == null) {
      return;
    }
    a = new z(paramContext, localc.k, com.tencent.bugly.crashreport.common.strategy.a.a(), com.tencent.bugly.crashreport.common.info.a.a(), localc.l);
    b = new y(paramContext, localc.k, com.tencent.bugly.crashreport.common.strategy.a.a(), com.tencent.bugly.crashreport.common.info.a.a(), localc.l);
    c = new b(paramContext, localc.k, com.tencent.bugly.crashreport.common.strategy.a.a(), com.tencent.bugly.crashreport.common.info.a.a(), localc.l);
    v.a().b(new d.1());
  }
  
  public static void a(StrategyBean paramStrategyBean)
  {
    if (b != null)
    {
      y localy = b;
      boolean bool = paramStrategyBean.h;
    }
  }
  
  public static void a(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (b == null) {
      return;
    }
    v.a().b(new d.3(paramThread, paramInt, paramString1, paramString2, paramString3));
  }
  
  public static void a(Thread paramThread, String paramString1, String paramString2, String paramString3)
  {
    if (a == null) {
      return;
    }
    v.a().b(new d.2(paramThread, paramString1, paramString2, paramString3));
  }
  
  public static void a(Thread paramThread, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    if (c == null) {
      return;
    }
    v.a().b(new d.4(paramThread, paramString1, paramString2, paramString3, paramMap));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */