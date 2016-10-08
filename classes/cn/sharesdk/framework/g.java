package cn.sharesdk.framework;

class g
  extends Thread
{
  g(f paramf, int paramInt, Object paramObject) {}
  
  public void run()
  {
    try
    {
      f.a(this.c);
      if (f.b(this.c).checkAuthorize(this.a, this.b)) {
        this.c.b(this.a, this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      cn.sharesdk.framework.utils.d.a().w(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */