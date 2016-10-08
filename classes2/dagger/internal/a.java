package dagger.internal;

public final class a<T>
  implements javax.inject.a<T>
{
  private static final Object b;
  private volatile javax.inject.a<T> c;
  private volatile Object d = b;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new Object();
      return;
    }
  }
  
  private a(javax.inject.a<T> parama)
  {
    if ((!a) && (parama == null)) {
      throw new AssertionError();
    }
    this.c = parama;
  }
  
  public static <T> javax.inject.a<T> a(javax.inject.a<T> parama)
  {
    d.a(parama);
    if ((parama instanceof a)) {
      return parama;
    }
    return new a(parama);
  }
  
  public T get()
  {
    Object localObject2 = this.d;
    Object localObject1 = localObject2;
    if (localObject2 == b)
    {
      try
      {
        localObject2 = this.d;
        localObject1 = localObject2;
        if (localObject2 != b) {
          break label108;
        }
        localObject1 = this.c.get();
        localObject2 = this.d;
        if ((localObject2 != b) && (localObject2 != localObject1)) {
          throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + localObject2 + " & " + localObject1);
        }
      }
      finally {}
      this.d = ?;
      this.c = null;
    }
    label108:
    return ?;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\dagger\internal\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */