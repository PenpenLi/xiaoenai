package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class c$2
  extends Thread
{
  c$2(c paramc) {}
  
  public final void run()
  {
    if (!a.a(c.b(this.a), "local_crash_lock", 10000L)) {
      return;
    }
    List localList = this.a.k.a();
    if ((localList != null) && (localList.size() > 0))
    {
      int j = localList.size();
      if (j > 100L)
      {
        ArrayList localArrayList = new ArrayList();
        Collections.sort(localList);
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= 100L) {
            break;
          }
          localArrayList.add(localList.get(j - 1 - i));
          i += 1;
        }
      }
      Object localObject = localList;
      this.a.k.a((List)localObject, 0L, false);
    }
    a.b(c.b(this.a), "local_crash_lock");
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\bugly\crashreport\crash\c$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */