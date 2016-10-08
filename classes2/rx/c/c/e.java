package rx.c.c;

import java.io.PrintStream;
import java.util.Queue;
import rx.c.a.b;
import rx.c.c.a.y;
import rx.l;

public class e
  implements l
{
  static int b;
  public static final int c;
  private static final b<Object> d = ;
  private static a<Queue<Object>> h;
  private static a<Queue<Object>> i;
  public volatile Object a;
  private Queue<Object> e;
  private final int f;
  private final a<Queue<Object>> g;
  
  static
  {
    b = 128;
    if (c.a()) {
      b = 16;
    }
    String str = System.getProperty("rx.ring-buffer.size");
    if (str != null) {}
    try
    {
      b = Integer.parseInt(str);
      c = b;
      h = new f();
      i = new g();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.err.println("Failed to set 'rx.buffer.size' with value " + str + " => " + localException.getMessage());
      }
    }
  }
  
  e()
  {
    this(new n(c), c);
  }
  
  private e(Queue<Object> paramQueue, int paramInt)
  {
    this.e = paramQueue;
    this.g = null;
    this.f = paramInt;
  }
  
  private e(a<Queue<Object>> parama, int paramInt)
  {
    this.g = parama;
    this.e = ((Queue)parama.a());
    this.f = paramInt;
  }
  
  public static e a()
  {
    if (y.a()) {
      return new e(h, c);
    }
    return new e();
  }
  
  public void a(Object paramObject)
  {
    int j = 1;
    int k = 0;
    try
    {
      Queue localQueue = this.e;
      if (localQueue != null) {
        if (localQueue.offer(d.a(paramObject))) {}
      }
      for (;;)
      {
        if (k == 0) {
          break;
        }
        throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        j = 0;
        continue;
        k = 1;
        j = 0;
      }
      if (j == 0) {
        return;
      }
    }
    finally {}
    throw new rx.a.c();
  }
  
  public void b()
  {
    try
    {
      Queue localQueue = this.e;
      a locala = this.g;
      if ((locala != null) && (localQueue != null))
      {
        localQueue.clear();
        this.e = null;
        locala.a(localQueue);
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    b();
  }
  
  public boolean d()
  {
    return this.e == null;
  }
  
  public boolean e()
  {
    Queue localQueue = this.e;
    if (localQueue == null) {
      return true;
    }
    return localQueue.isEmpty();
  }
  
  public Object f()
  {
    for (;;)
    {
      try
      {
        Queue localQueue = this.e;
        if (localQueue == null) {
          return null;
        }
        Object localObject1 = localQueue.poll();
        Object localObject3 = this.a;
        if ((localObject1 == null) && (localObject3 != null) && (localQueue.peek() == null))
        {
          this.a = null;
          localObject1 = localObject3;
          return localObject1;
        }
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\rx\c\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */