package com.adhoc;

import java.util.concurrent.CountDownLatch;

public final class dd
{
  private final CountDownLatch a = new CountDownLatch(1);
  private long b = -1L;
  private long c = -1L;
  
  void a()
  {
    if (this.b != -1L) {
      throw new IllegalStateException();
    }
    this.b = System.nanoTime();
  }
  
  void b()
  {
    if ((this.c != -1L) || (this.b == -1L)) {
      throw new IllegalStateException();
    }
    this.c = System.nanoTime();
    this.a.countDown();
  }
  
  void c()
  {
    if ((this.c != -1L) || (this.b == -1L)) {
      throw new IllegalStateException();
    }
    this.c = (this.b - 1L);
    this.a.countDown();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */