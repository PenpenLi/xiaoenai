package dagger.internal;

import dagger.a;

public final class c
{
  public static <T> a<T> a()
  {
    return a.a;
  }
  
  public static <T> T a(a<T> parama, T paramT)
  {
    parama.a(paramT);
    return paramT;
  }
  
  private static enum a
    implements a<Object>
  {
    private a() {}
    
    public void a(Object paramObject)
    {
      d.a(paramObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\dagger\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */