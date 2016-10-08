package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.a.a.a;
import java.io.File;
import java.util.concurrent.Executor;

class f
  implements Runnable
{
  f(e parame, h paramh) {}
  
  public void run()
  {
    File localFile = this.b.a.o.a(this.a.a());
    if ((localFile != null) && (localFile.exists())) {}
    for (int i = 1;; i = 0)
    {
      e.a(this.b);
      if (i == 0) {
        break;
      }
      e.b(this.b).execute(this.a);
      return;
    }
    e.c(this.b).execute(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\nostra13\universalimageloader\core\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */