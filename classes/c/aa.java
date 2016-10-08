package c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class aa
{
  public static final aa b = new ab();
  private boolean a;
  private long c;
  private long d;
  
  public aa a(long paramLong)
  {
    this.a = true;
    this.c = paramLong;
    return this;
  }
  
  public aa a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.d = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long d()
  {
    if (!this.a) {
      throw new IllegalStateException("No deadline");
    }
    return this.c;
  }
  
  public aa f()
  {
    this.a = false;
    return this;
  }
  
  public void g()
  {
    if (Thread.interrupted()) {
      throw new InterruptedIOException("thread interrupted");
    }
    if ((this.a) && (this.c - System.nanoTime() <= 0L)) {
      throw new InterruptedIOException("deadline reached");
    }
  }
  
  public long o_()
  {
    return this.d;
  }
  
  public boolean p_()
  {
    return this.a;
  }
  
  public aa q_()
  {
    this.d = 0L;
    return this;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\c\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */