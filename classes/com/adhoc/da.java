package com.adhoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class da
{
  private final ew a = new ew(new db(this, parameq), new dc(this));
  private int b;
  private final eq c = ex.a(this.a);
  
  public da(eq parameq) {}
  
  private er b()
  {
    int i = this.c.j();
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
  
  public List<ct> a(int paramInt)
  {
    this.b += paramInt;
    int i = this.c.j();
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
      er localer1 = b().e();
      er localer2 = b();
      if (localer1.f() == 0) {
        throw new IOException("name.size == 0");
      }
      localArrayList.add(new ct(localer1, localer2));
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */