package b;

import b.a.j;
import c.g;
import c.p;
import c.z;
import java.io.Closeable;
import java.io.File;

final class ap
  extends an
{
  ap(ae paramae, File paramFile) {}
  
  public ae a()
  {
    return this.a;
  }
  
  public void a(g paramg)
  {
    Object localObject = null;
    try
    {
      z localz = p.a(this.b);
      localObject = localz;
      paramg.a(localz);
      j.a(localz);
      return;
    }
    finally
    {
      j.a((Closeable)localObject);
    }
  }
  
  public long b()
  {
    return this.b.length();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */