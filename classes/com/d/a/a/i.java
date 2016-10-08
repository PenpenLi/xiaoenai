package com.d.a.a;

class i
  implements Runnable
{
  i(f paramf, long paramLong1, int paramInt, long paramLong2, b paramb, a parama) {}
  
  public void run()
  {
    try
    {
      long l = (System.nanoTime() - this.a) / 1000000L;
      l = this.f.a(this.b, Math.max(0L, this.c - l), this.d);
      if (this.e != null) {
        this.e.a(l);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.d.a.a.e.b.a(localThrowable, "addJobInBackground received an exception. job class: %s", new Object[] { this.d.getClass().getSimpleName() });
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\d\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */