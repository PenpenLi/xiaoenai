package com.meiqia.core;

import b.aq;
import b.h;
import c.p;
import com.meiqia.core.d.q;
import java.io.File;
import java.io.IOException;

class bc
  implements h
{
  bc(as paramas, q paramq, File paramFile) {}
  
  public void a(b.g paramg, aq paramaq)
  {
    if (paramaq.c())
    {
      paramg = p.a(p.b(this.b));
      paramg.a(paramaq.g().c());
      paramg.close();
      this.a.a();
      return;
    }
    this.a.a(0, "download failed");
  }
  
  public void a(b.g paramg, IOException paramIOException)
  {
    this.a.a(0, "download failed");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */