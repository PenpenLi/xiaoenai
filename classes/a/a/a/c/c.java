package a.a.a.c;

import java.util.Arrays;

public final class c<T>
{
  private a<T>[] a;
  private int b;
  private int c;
  private int d;
  
  public c()
  {
    this(16);
  }
  
  public c(int paramInt)
  {
    this.b = paramInt;
    this.c = (paramInt * 4 / 3);
    this.a = new a[paramInt];
  }
  
  public T a(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    int k = this.b;
    for (a locala = this.a[(((i ^ j) & 0x7FFFFFFF) % k)]; locala != null; locala = locala.c) {
      if (locala.a == paramLong) {
        return (T)locala.b;
      }
    }
    return null;
  }
  
  public T a(long paramLong, T paramT)
  {
    int i = (((int)(paramLong >>> 32) ^ (int)paramLong) & 0x7FFFFFFF) % this.b;
    Object localObject2 = this.a[i];
    for (Object localObject1 = localObject2; localObject1 != null; localObject1 = ((a)localObject1).c) {
      if (((a)localObject1).a == paramLong)
      {
        localObject2 = ((a)localObject1).b;
        ((a)localObject1).b = paramT;
        return (T)localObject2;
      }
    }
    this.a[i] = new a(paramLong, paramT, (a)localObject2);
    this.d += 1;
    if (this.d > this.c) {
      a(this.b * 2);
    }
    return null;
  }
  
  public void a()
  {
    this.d = 0;
    Arrays.fill(this.a, null);
  }
  
  public void a(int paramInt)
  {
    a[] arrayOfa = new a[paramInt];
    int j = this.a.length;
    int i = 0;
    while (i < j)
    {
      a locala;
      for (Object localObject = this.a[i]; localObject != null; localObject = locala)
      {
        long l = ((a)localObject).a;
        int k = (((int)(l >>> 32) ^ (int)l) & 0x7FFFFFFF) % paramInt;
        locala = ((a)localObject).c;
        ((a)localObject).c = arrayOfa[k];
        arrayOfa[k] = localObject;
      }
      i += 1;
    }
    this.a = arrayOfa;
    this.b = paramInt;
    this.c = (paramInt * 4 / 3);
  }
  
  public T b(long paramLong)
  {
    Object localObject4 = null;
    int i = (((int)(paramLong >>> 32) ^ (int)paramLong) & 0x7FFFFFFF) % this.b;
    Object localObject1 = this.a[i];
    Object localObject2 = null;
    for (;;)
    {
      Object localObject3 = localObject4;
      if (localObject1 != null)
      {
        localObject3 = ((a)localObject1).c;
        if (((a)localObject1).a != paramLong) {
          break label98;
        }
        if (localObject2 != null) {
          break label88;
        }
        this.a[i] = localObject3;
      }
      for (;;)
      {
        this.d -= 1;
        localObject3 = ((a)localObject1).b;
        return (T)localObject3;
        label88:
        ((a)localObject2).c = ((a)localObject3);
      }
      label98:
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt * 5 / 3);
  }
  
  static final class a<T>
  {
    final long a;
    T b;
    a<T> c;
    
    a(long paramLong, T paramT, a<T> parama)
    {
      this.a = paramLong;
      this.b = paramT;
      this.c = parama;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */