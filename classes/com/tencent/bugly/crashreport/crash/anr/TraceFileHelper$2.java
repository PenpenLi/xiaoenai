package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.w;
import java.util.HashMap;
import java.util.Map;

final class TraceFileHelper$2
  implements TraceFileHelper.b
{
  TraceFileHelper$2(TraceFileHelper.a parama, boolean paramBoolean) {}
  
  public final boolean a(long paramLong)
  {
    w.c("process end %d", new Object[] { Long.valueOf(paramLong) });
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, String paramString)
  {
    w.c("new process %s", new Object[] { paramString });
    this.a.a = paramLong1;
    this.a.b = paramString;
    this.a.c = paramLong2;
    return this.b;
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    w.c("new thread %s", new Object[] { paramString1 });
    if (this.a.d == null) {
      this.a.d = new HashMap();
    }
    this.a.d.put(paramString1, new String[] { paramString2, paramString3, paramInt });
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\TraceFileHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */