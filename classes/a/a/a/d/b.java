package a.a.a.d;

import android.os.Process;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

abstract class b<T, Q extends a<T>>
{
  final String a;
  final a.a.a.a<T, ?> b;
  final String[] c;
  final SparseArray<WeakReference<Q>> d;
  
  b(a.a.a.a<T, ?> parama, String paramString, String[] paramArrayOfString)
  {
    this.b = parama;
    this.a = paramString;
    this.c = paramArrayOfString;
    this.d = new SparseArray();
  }
  
  Q a()
  {
    int i = Process.myTid();
    if (i == 0)
    {
      long l = Thread.currentThread().getId();
      if ((l < 0L) || (l > 2147483647L)) {
        throw new RuntimeException("Cannot handle thread ID: " + l);
      }
      i = (int)l;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        Object localObject1 = (WeakReference)this.d.get(i);
        if (localObject1 == null) {
          break label157;
        }
        localObject1 = (a)((WeakReference)localObject1).get();
        if (localObject1 == null)
        {
          c();
          localObject1 = b();
          this.d.put(i, new WeakReference(localObject1));
          return (Q)localObject1;
        }
        System.arraycopy(this.c, 0, ((a)localObject1).d, 0, this.c.length);
      }
      continue;
      label157:
      Object localObject3 = null;
    }
  }
  
  Q a(Q paramQ)
  {
    if (Thread.currentThread() == paramQ.e)
    {
      System.arraycopy(this.c, 0, paramQ.d, 0, this.c.length);
      return paramQ;
    }
    return a();
  }
  
  protected abstract Q b();
  
  void c()
  {
    for (;;)
    {
      int i;
      synchronized (this.d)
      {
        i = this.d.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.d.valueAt(i)).get() == null) {
            this.d.remove(this.d.keyAt(i));
          }
        }
        else {
          return;
        }
      }
      i -= 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */