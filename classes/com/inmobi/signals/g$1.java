package com.inmobi.signals;

class g$1
  implements Runnable
{
  g$1(g paramg) {}
  
  public void run()
  {
    c localc = g.a(this.a);
    if (!localc.a())
    {
      g.b(this.a).a(System.currentTimeMillis());
      if (!localc.e()) {
        g.a(this.a, localc, g.a(this.a, localc.b()));
      }
    }
    g.a(this.a, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\g$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */