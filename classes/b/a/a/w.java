package b.a.a;

import c.h;
import c.i;
import c.o;
import c.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class w
{
  private final o a = new o(new x(this, paramh), new y(this));
  private int b;
  private final h c = p.a(this.a);
  
  public w(h paramh) {}
  
  private i b()
  {
    int i = this.c.k();
    return this.c.c(i);
  }
  
  private void c()
  {
    if (this.b > 0)
    {
      this.a.b();
      if (this.b != 0) {
        throw new IOException("compressedLimit > 0: " + this.b);
      }
    }
  }
  
  public List<r> a(int paramInt)
  {
    this.b += paramInt;
    int i = this.c.k();
    if (i < 0) {
      throw new IOException("numberOfPairs < 0: " + i);
    }
    if (i > 1024) {
      throw new IOException("numberOfPairs > 1024: " + i);
    }
    ArrayList localArrayList = new ArrayList(i);
    paramInt = 0;
    while (paramInt < i)
    {
      i locali1 = b().e();
      i locali2 = b();
      if (locali1.f() == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new r(locali1, locali2));
      paramInt += 1;
    }
    c();
    return localArrayList;
  }
  
  public void a()
  {
    this.c.close();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */