package com.bumptech.glide.d.c;

import com.bumptech.glide.i.e;
import com.bumptech.glide.i.h;
import java.util.Queue;

public class j<A, B>
{
  private final e<a<A>, B> a;
  
  public j()
  {
    this(250);
  }
  
  public j(int paramInt)
  {
    this.a = new k(this, paramInt);
  }
  
  public B a(A paramA, int paramInt1, int paramInt2)
  {
    paramA = a.a(paramA, paramInt1, paramInt2);
    Object localObject = this.a.b(paramA);
    paramA.a();
    return (B)localObject;
  }
  
  public void a(A paramA, int paramInt1, int paramInt2, B paramB)
  {
    paramA = a.a(paramA, paramInt1, paramInt2);
    this.a.b(paramA, paramB);
  }
  
  static final class a<A>
  {
    private static final Queue<a<?>> a = h.a(0);
    private int b;
    private int c;
    private A d;
    
    static <A> a<A> a(A paramA, int paramInt1, int paramInt2)
    {
      a locala2 = (a)a.poll();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      locala1.b(paramA, paramInt1, paramInt2);
      return locala1;
    }
    
    private void b(A paramA, int paramInt1, int paramInt2)
    {
      this.d = paramA;
      this.c = paramInt1;
      this.b = paramInt2;
    }
    
    public void a()
    {
      a.offer(this);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.c == ((a)paramObject).c)
        {
          bool1 = bool2;
          if (this.b == ((a)paramObject).b)
          {
            bool1 = bool2;
            if (this.d.equals(((a)paramObject).d)) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return (this.b * 31 + this.c) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */