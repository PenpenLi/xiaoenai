package com.google.gson;

import com.google.gson.a.a.f;
import com.google.gson.a.a.s;
import com.google.gson.c.e;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class j
{
  final t a = new k(this);
  final aa b = new l(this);
  private final ThreadLocal<Map<com.google.gson.b.a<?>, a<?>>> c = new ThreadLocal();
  private final Map<com.google.gson.b.a<?>, af<?>> d = Collections.synchronizedMap(new HashMap());
  private final List<ah> e;
  private final com.google.gson.a.c f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  
  public j()
  {
    this(com.google.gson.a.r.a, c.a, Collections.emptyMap(), false, false, false, true, false, false, ac.a, Collections.emptyList());
  }
  
  j(com.google.gson.a.r paramr, i parami, Map<Type, r<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ac paramac, List<ah> paramList)
  {
    this.f = new com.google.gson.a.c(paramMap);
    this.g = paramBoolean1;
    this.i = paramBoolean3;
    this.h = paramBoolean4;
    this.j = paramBoolean5;
    paramMap = new ArrayList();
    paramMap.add(com.google.gson.a.a.v.Y);
    paramMap.add(com.google.gson.a.a.l.a);
    paramMap.add(paramr);
    paramMap.addAll(paramList);
    paramMap.add(com.google.gson.a.a.v.D);
    paramMap.add(com.google.gson.a.a.v.m);
    paramMap.add(com.google.gson.a.a.v.g);
    paramMap.add(com.google.gson.a.a.v.i);
    paramMap.add(com.google.gson.a.a.v.k);
    paramac = a(paramac);
    paramMap.add(com.google.gson.a.a.v.a(Long.TYPE, Long.class, paramac));
    paramMap.add(com.google.gson.a.a.v.a(Double.TYPE, Double.class, a(paramBoolean6)));
    paramMap.add(com.google.gson.a.a.v.a(Float.TYPE, Float.class, b(paramBoolean6)));
    paramMap.add(com.google.gson.a.a.v.x);
    paramMap.add(com.google.gson.a.a.v.o);
    paramMap.add(com.google.gson.a.a.v.q);
    paramMap.add(com.google.gson.a.a.v.a(AtomicLong.class, a(paramac)));
    paramMap.add(com.google.gson.a.a.v.a(AtomicLongArray.class, b(paramac)));
    paramMap.add(com.google.gson.a.a.v.s);
    paramMap.add(com.google.gson.a.a.v.z);
    paramMap.add(com.google.gson.a.a.v.F);
    paramMap.add(com.google.gson.a.a.v.H);
    paramMap.add(com.google.gson.a.a.v.a(BigDecimal.class, com.google.gson.a.a.v.B));
    paramMap.add(com.google.gson.a.a.v.a(BigInteger.class, com.google.gson.a.a.v.C));
    paramMap.add(com.google.gson.a.a.v.J);
    paramMap.add(com.google.gson.a.a.v.L);
    paramMap.add(com.google.gson.a.a.v.P);
    paramMap.add(com.google.gson.a.a.v.R);
    paramMap.add(com.google.gson.a.a.v.W);
    paramMap.add(com.google.gson.a.a.v.N);
    paramMap.add(com.google.gson.a.a.v.d);
    paramMap.add(com.google.gson.a.a.d.a);
    paramMap.add(com.google.gson.a.a.v.U);
    paramMap.add(s.a);
    paramMap.add(com.google.gson.a.a.q.a);
    paramMap.add(com.google.gson.a.a.v.S);
    paramMap.add(com.google.gson.a.a.a.a);
    paramMap.add(com.google.gson.a.a.v.b);
    paramMap.add(new com.google.gson.a.a.c(this.f));
    paramMap.add(new com.google.gson.a.a.k(this.f, paramBoolean2));
    paramMap.add(new f(this.f));
    paramMap.add(com.google.gson.a.a.v.Z);
    paramMap.add(new com.google.gson.a.a.o(this.f, parami, paramr));
    this.e = Collections.unmodifiableList(paramMap);
  }
  
  private static af<Number> a(ac paramac)
  {
    if (paramac == ac.a) {
      return com.google.gson.a.a.v.t;
    }
    return new o();
  }
  
  private static af<AtomicLong> a(af<Number> paramaf)
  {
    return new p(paramaf).a();
  }
  
  private af<Number> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return com.google.gson.a.a.v.v;
    }
    return new m(this);
  }
  
  private void a(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) {
      throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }
  }
  
  private static void a(Object paramObject, com.google.gson.c.a parama)
  {
    if (paramObject != null) {
      try
      {
        if (parama.f() != com.google.gson.c.c.j) {
          throw new v("JSON document was not fully consumed.");
        }
      }
      catch (e paramObject)
      {
        throw new ab((Throwable)paramObject);
      }
      catch (IOException paramObject)
      {
        throw new v((Throwable)paramObject);
      }
    }
  }
  
  private static af<AtomicLongArray> b(af<Number> paramaf)
  {
    return new q(paramaf).a();
  }
  
  private af<Number> b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return com.google.gson.a.a.v.u;
    }
    return new n(this);
  }
  
  public <T> af<T> a(ah paramah, com.google.gson.b.a<T> parama)
  {
    int k = 0;
    if (!this.e.contains(paramah)) {
      k = 1;
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ah)localIterator.next();
      if (k == 0)
      {
        if (localObject == paramah) {
          k = 1;
        }
      }
      else
      {
        localObject = ((ah)localObject).a(this, parama);
        if (localObject != null) {
          return (af<T>)localObject;
        }
      }
    }
    throw new IllegalArgumentException("GSON cannot serialize " + parama);
  }
  
  public <T> af<T> a(com.google.gson.b.a<T> parama)
  {
    Object localObject1 = (af)this.d.get(parama);
    if (localObject1 != null) {
      return (af<T>)localObject1;
    }
    Object localObject3 = (Map)this.c.get();
    int k = 0;
    if (localObject3 == null)
    {
      localObject3 = new HashMap();
      this.c.set(localObject3);
      k = 1;
    }
    for (;;)
    {
      Object localObject4 = (a)((Map)localObject3).get(parama);
      localObject1 = localObject4;
      if (localObject4 != null) {
        break;
      }
      try
      {
        localObject1 = new a();
        ((Map)localObject3).put(parama, localObject1);
        Iterator localIterator = this.e.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject4 = ((ah)localIterator.next()).a(this, parama);
            if (localObject4 != null)
            {
              ((a)localObject1).a((af)localObject4);
              this.d.put(parama, localObject4);
              ((Map)localObject3).remove(parama);
              localObject1 = localObject4;
              if (k == 0) {
                break;
              }
              this.c.remove();
              return (af<T>)localObject4;
            }
          }
        }
        throw new IllegalArgumentException("GSON cannot handle " + parama);
      }
      finally
      {
        ((Map)localObject3).remove(parama);
        if (k != 0) {
          this.c.remove();
        }
      }
    }
  }
  
  public <T> af<T> a(Class<T> paramClass)
  {
    return a(com.google.gson.b.a.get(paramClass));
  }
  
  public com.google.gson.c.d a(Writer paramWriter)
  {
    if (this.i) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new com.google.gson.c.d(paramWriter);
    if (this.j) {
      paramWriter.c("  ");
    }
    paramWriter.d(this.g);
    return paramWriter;
  }
  
  /* Error */
  public <T> T a(com.google.gson.c.a parama, Type paramType)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 461	com/google/gson/c/a:p	()Z
    //   6: istore 4
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 463	com/google/gson/c/a:a	(Z)V
    //   13: aload_1
    //   14: invokevirtual 338	com/google/gson/c/a:f	()Lcom/google/gson/c/c;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 466	com/google/gson/b/a:get	(Ljava/lang/reflect/Type;)Lcom/google/gson/b/a;
    //   25: invokevirtual 432	com/google/gson/j:a	(Lcom/google/gson/b/a;)Lcom/google/gson/af;
    //   28: aload_1
    //   29: invokevirtual 469	com/google/gson/af:b	(Lcom/google/gson/c/a;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: invokevirtual 463	com/google/gson/c/a:a	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: iload_3
    //   43: ifeq +11 -> 54
    //   46: aload_1
    //   47: iload 4
    //   49: invokevirtual 463	com/google/gson/c/a:a	(Z)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 350	com/google/gson/ab
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 353	com/google/gson/ab:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_2
    //   64: aload_1
    //   65: iload 4
    //   67: invokevirtual 463	com/google/gson/c/a:a	(Z)V
    //   70: aload_2
    //   71: athrow
    //   72: astore_2
    //   73: new 350	com/google/gson/ab
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 353	com/google/gson/ab:<init>	(Ljava/lang/Throwable;)V
    //   81: athrow
    //   82: astore_2
    //   83: new 350	com/google/gson/ab
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 353	com/google/gson/ab:<init>	(Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	j
    //   0	92	1	parama	com.google.gson.c.a
    //   0	92	2	paramType	Type
    //   1	42	3	k	int
    //   6	60	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	18	41	java/io/EOFException
    //   20	33	41	java/io/EOFException
    //   13	18	63	finally
    //   20	33	63	finally
    //   54	63	63	finally
    //   73	82	63	finally
    //   83	92	63	finally
    //   13	18	72	java/lang/IllegalStateException
    //   20	33	72	java/lang/IllegalStateException
    //   13	18	82	java/io/IOException
    //   20	33	82	java/io/IOException
  }
  
  public <T> T a(Reader paramReader, Type paramType)
  {
    paramReader = new com.google.gson.c.a(paramReader);
    paramType = a(paramReader, paramType);
    a(paramType, paramReader);
    return paramType;
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
  {
    paramString = a(paramString, paramClass);
    return (T)com.google.gson.a.aa.a(paramClass).cast(paramString);
  }
  
  public <T> T a(String paramString, Type paramType)
  {
    if (paramString == null) {
      return null;
    }
    return (T)a(new StringReader(paramString), paramType);
  }
  
  public String a(u paramu)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramu, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String a(Object paramObject)
  {
    if (paramObject == null) {
      return a(w.a);
    }
    return a(paramObject, paramObject.getClass());
  }
  
  public String a(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  public void a(u paramu, com.google.gson.c.d paramd)
  {
    boolean bool1 = paramd.g();
    paramd.b(true);
    boolean bool2 = paramd.h();
    paramd.c(this.h);
    boolean bool3 = paramd.i();
    paramd.d(this.g);
    try
    {
      com.google.gson.a.ab.a(paramu, paramd);
      return;
    }
    catch (IOException paramu)
    {
      throw new v(paramu);
    }
    finally
    {
      paramd.b(bool1);
      paramd.c(bool2);
      paramd.d(bool3);
    }
  }
  
  public void a(u paramu, Appendable paramAppendable)
  {
    try
    {
      a(paramu, a(com.google.gson.a.ab.a(paramAppendable)));
      return;
    }
    catch (IOException paramu)
    {
      throw new RuntimeException(paramu);
    }
  }
  
  public void a(Object paramObject, Type paramType, com.google.gson.c.d paramd)
  {
    paramType = a(com.google.gson.b.a.get(paramType));
    boolean bool1 = paramd.g();
    paramd.b(true);
    boolean bool2 = paramd.h();
    paramd.c(this.h);
    boolean bool3 = paramd.i();
    paramd.d(this.g);
    try
    {
      paramType.a(paramd, paramObject);
      return;
    }
    catch (IOException paramObject)
    {
      throw new v((Throwable)paramObject);
    }
    finally
    {
      paramd.b(bool1);
      paramd.c(bool2);
      paramd.d(bool3);
    }
  }
  
  public void a(Object paramObject, Type paramType, Appendable paramAppendable)
  {
    try
    {
      a(paramObject, paramType, a(com.google.gson.a.ab.a(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new v((Throwable)paramObject);
    }
  }
  
  public String toString()
  {
    return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
  }
  
  static class a<T>
    extends af<T>
  {
    private af<T> a;
    
    public void a(af<T> paramaf)
    {
      if (this.a != null) {
        throw new AssertionError();
      }
      this.a = paramaf;
    }
    
    public void a(com.google.gson.c.d paramd, T paramT)
    {
      if (this.a == null) {
        throw new IllegalStateException();
      }
      this.a.a(paramd, paramT);
    }
    
    public T b(com.google.gson.c.a parama)
    {
      if (this.a == null) {
        throw new IllegalStateException();
      }
      return (T)this.a.b(parama);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */