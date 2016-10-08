package com.bumptech.glide.d.b;

import android.util.Log;
import com.bumptech.glide.d.g;
import com.bumptech.glide.i.d;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

class a<A, T, Z>
{
  private static final b a = new b();
  private final f b;
  private final int c;
  private final int d;
  private final com.bumptech.glide.d.a.c<A> e;
  private final com.bumptech.glide.f.b<A, T> f;
  private final g<T> g;
  private final com.bumptech.glide.d.d.f.c<T, Z> h;
  private final a i;
  private final b j;
  private final com.bumptech.glide.e k;
  private final b l;
  private volatile boolean m;
  
  public a(f paramf, int paramInt1, int paramInt2, com.bumptech.glide.d.a.c<A> paramc, com.bumptech.glide.f.b<A, T> paramb, g<T> paramg, com.bumptech.glide.d.d.f.c<T, Z> paramc1, a parama, b paramb1, com.bumptech.glide.e parame)
  {
    this(paramf, paramInt1, paramInt2, paramc, paramb, paramg, paramc1, parama, paramb1, parame, a);
  }
  
  a(f paramf, int paramInt1, int paramInt2, com.bumptech.glide.d.a.c<A> paramc, com.bumptech.glide.f.b<A, T> paramb, g<T> paramg, com.bumptech.glide.d.d.f.c<T, Z> paramc1, a parama, b paramb1, com.bumptech.glide.e parame, b paramb2)
  {
    this.b = paramf;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramc;
    this.f = paramb;
    this.g = paramg;
    this.h = paramc1;
    this.i = parama;
    this.j = paramb1;
    this.k = parame;
    this.l = paramb2;
  }
  
  private k<Z> a(k<T> paramk)
  {
    long l1 = d.a();
    paramk = c(paramk);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transformed resource from source", l1);
    }
    b(paramk);
    l1 = d.a();
    paramk = d(paramk);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transcoded transformed from source", l1);
    }
    return paramk;
  }
  
  private k<T> a(com.bumptech.glide.d.c paramc)
  {
    Object localObject1 = null;
    Object localObject3 = this.i.a().a(paramc);
    if (localObject3 == null) {}
    for (;;)
    {
      return (k<T>)localObject1;
      try
      {
        localObject3 = this.f.a().a(localObject3, this.c, this.d);
        localObject1 = localObject3;
        if (localObject3 != null) {
          continue;
        }
        this.i.a().b(paramc);
        return (k<T>)localObject3;
      }
      finally
      {
        if (0 == 0) {
          this.i.a().b(paramc);
        }
      }
    }
  }
  
  private k<T> a(A paramA)
  {
    if (this.j.a()) {
      paramA = b(paramA);
    }
    long l1;
    k localk;
    do
    {
      return paramA;
      l1 = d.a();
      localk = this.f.b().a(paramA, this.c, this.d);
      paramA = localk;
    } while (!Log.isLoggable("DecodeJob", 2));
    a("Decoded from source", l1);
    return localk;
  }
  
  private void a(String paramString, long paramLong)
  {
    Log.v("DecodeJob", paramString + " in " + d.a(paramLong) + ", key: " + this.b);
  }
  
  private k<T> b(A paramA)
  {
    long l1 = d.a();
    paramA = new c(this.f.c(), paramA);
    this.i.a().a(this.b.a(), paramA);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Wrote source to cache", l1);
    }
    l1 = d.a();
    paramA = a(this.b.a());
    if ((Log.isLoggable("DecodeJob", 2)) && (paramA != null)) {
      a("Decoded source from cache", l1);
    }
    return paramA;
  }
  
  private void b(k<T> paramk)
  {
    if ((paramk == null) || (!this.j.b())) {}
    long l1;
    do
    {
      return;
      l1 = d.a();
      paramk = new c(this.f.d(), paramk);
      this.i.a().a(this.b, paramk);
    } while (!Log.isLoggable("DecodeJob", 2));
    a("Wrote transformed from source to cache", l1);
  }
  
  private k<T> c(k<T> paramk)
  {
    Object localObject;
    if (paramk == null) {
      localObject = null;
    }
    k localk;
    do
    {
      return (k<T>)localObject;
      localk = this.g.a(paramk, this.c, this.d);
      localObject = localk;
    } while (paramk.equals(localk));
    paramk.d();
    return localk;
  }
  
  private k<Z> d(k<T> paramk)
  {
    if (paramk == null) {
      return null;
    }
    return this.h.a(paramk);
  }
  
  private k<T> e()
  {
    try
    {
      long l1 = d.a();
      Object localObject1 = this.e.a(this.k);
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Fetched data", l1);
      }
      boolean bool = this.m;
      if (bool) {
        return null;
      }
      localObject1 = a(localObject1);
      return (k<T>)localObject1;
    }
    finally
    {
      this.e.a();
    }
  }
  
  public k<Z> a()
  {
    Object localObject;
    if (!this.j.b()) {
      localObject = null;
    }
    long l1;
    k localk;
    do
    {
      return (k<Z>)localObject;
      l1 = d.a();
      localObject = a(this.b);
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Decoded transformed from cache", l1);
      }
      l1 = d.a();
      localk = d((k)localObject);
      localObject = localk;
    } while (!Log.isLoggable("DecodeJob", 2));
    a("Transcoded transformed from cache", l1);
    return localk;
  }
  
  public k<Z> b()
  {
    if (!this.j.a()) {
      return null;
    }
    long l1 = d.a();
    k localk = a(this.b.a());
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Decoded source from cache", l1);
    }
    return a(localk);
  }
  
  public k<Z> c()
  {
    return a(e());
  }
  
  public void d()
  {
    this.m = true;
    this.e.c();
  }
  
  static abstract interface a
  {
    public abstract com.bumptech.glide.d.b.b.a a();
  }
  
  static class b
  {
    public OutputStream a(File paramFile)
    {
      return new BufferedOutputStream(new FileOutputStream(paramFile));
    }
  }
  
  class c<DataType>
    implements com.bumptech.glide.d.b.b.a.b
  {
    private final com.bumptech.glide.d.b<DataType> b;
    private final DataType c;
    
    public c(DataType paramDataType)
    {
      this.b = paramDataType;
      Object localObject;
      this.c = localObject;
    }
    
    /* Error */
    public boolean a(File paramFile)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: aconst_null
      //   4: astore_3
      //   5: aconst_null
      //   6: astore_2
      //   7: aload_0
      //   8: getfield 21	com/bumptech/glide/d/b/a$c:a	Lcom/bumptech/glide/d/b/a;
      //   11: invokestatic 39	com/bumptech/glide/d/b/a:a	(Lcom/bumptech/glide/d/b/a;)Lcom/bumptech/glide/d/b/a$b;
      //   14: aload_1
      //   15: invokevirtual 44	com/bumptech/glide/d/b/a$b:a	(Ljava/io/File;)Ljava/io/OutputStream;
      //   18: astore_1
      //   19: aload_1
      //   20: astore_2
      //   21: aload_1
      //   22: astore_3
      //   23: aload_0
      //   24: getfield 26	com/bumptech/glide/d/b/a$c:b	Lcom/bumptech/glide/d/b;
      //   27: aload_0
      //   28: getfield 28	com/bumptech/glide/d/b/a$c:c	Ljava/lang/Object;
      //   31: aload_1
      //   32: invokeinterface 49 3 0
      //   37: istore 4
      //   39: iload 4
      //   41: istore 5
      //   43: aload_1
      //   44: ifnull +11 -> 55
      //   47: aload_1
      //   48: invokevirtual 54	java/io/OutputStream:close	()V
      //   51: iload 4
      //   53: istore 5
      //   55: iload 5
      //   57: ireturn
      //   58: astore_1
      //   59: aload_2
      //   60: astore_3
      //   61: ldc 56
      //   63: iconst_3
      //   64: invokestatic 62	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   67: ifeq +14 -> 81
      //   70: aload_2
      //   71: astore_3
      //   72: ldc 56
      //   74: ldc 64
      //   76: aload_1
      //   77: invokestatic 68	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   80: pop
      //   81: aload_2
      //   82: ifnull -27 -> 55
      //   85: aload_2
      //   86: invokevirtual 54	java/io/OutputStream:close	()V
      //   89: iconst_0
      //   90: ireturn
      //   91: astore_1
      //   92: iconst_0
      //   93: ireturn
      //   94: astore_1
      //   95: aload_3
      //   96: ifnull +7 -> 103
      //   99: aload_3
      //   100: invokevirtual 54	java/io/OutputStream:close	()V
      //   103: aload_1
      //   104: athrow
      //   105: astore_1
      //   106: iload 4
      //   108: ireturn
      //   109: astore_2
      //   110: goto -7 -> 103
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	this	c
      //   0	113	1	paramFile	File
      //   6	80	2	localFile	File
      //   109	1	2	localIOException	java.io.IOException
      //   4	96	3	localObject	Object
      //   37	70	4	bool1	boolean
      //   1	55	5	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   7	19	58	java/io/FileNotFoundException
      //   23	39	58	java/io/FileNotFoundException
      //   85	89	91	java/io/IOException
      //   7	19	94	finally
      //   23	39	94	finally
      //   61	70	94	finally
      //   72	81	94	finally
      //   47	51	105	java/io/IOException
      //   99	103	109	java/io/IOException
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\d\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */