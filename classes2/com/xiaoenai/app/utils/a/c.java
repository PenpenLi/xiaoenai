package com.xiaoenai.app.utils.a;

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class c
  implements Runnable
{
  c(a.a parama) {}
  
  public void run()
  {
    int i = 0;
    File[] arrayOfFile = this.a.a.listFiles();
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      int j = 0;
      int k = 0;
      while (i < m)
      {
        File localFile = arrayOfFile[i];
        k = (int)(k + a.a.b(this.a, localFile));
        j += 1;
        a.a.b(this.a).put(localFile, Long.valueOf(localFile.lastModified()));
        i += 1;
      }
      a.a.c(this.a).set(k);
      a.a.d(this.a).set(j);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */