package com.xiaoenai.app.classes.common.image.croper;

import android.graphics.BitmapFactory.Options;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class a
{
  private static a b = null;
  private final WeakHashMap<Thread, c> a = new WeakHashMap();
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  private c b(Thread paramThread)
  {
    try
    {
      c localc2 = (c)this.a.get(paramThread);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(null);
        this.a.put(paramThread, localc1);
      }
      return localc1;
    }
    finally {}
  }
  
  public void a(b paramb)
  {
    try
    {
      paramb = paramb.iterator();
      while (paramb.hasNext()) {
        a((Thread)paramb.next());
      }
    }
    finally {}
  }
  
  public void a(Thread paramThread)
  {
    try
    {
      paramThread = b(paramThread);
      paramThread.a = a.a;
      if (paramThread.b != null) {
        paramThread.b.requestCancelDecode();
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  private static enum a
  {
    private a() {}
  }
  
  public static class b
    implements Iterable<Thread>
  {
    private final WeakHashMap<Thread, Object> a = new WeakHashMap();
    
    public Iterator<Thread> iterator()
    {
      return this.a.keySet().iterator();
    }
  }
  
  private static class c
  {
    public a.a a = a.a.b;
    public BitmapFactory.Options b;
    
    public String toString()
    {
      String str;
      if (this.a == a.a.a) {
        str = "Cancel";
      }
      for (;;)
      {
        return "thread state = " + str + ", options = " + this.b;
        if (this.a == a.a.b) {
          str = "Allow";
        } else {
          str = "?";
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\croper\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */