package d.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ao
  implements ba<ao, e>, Serializable, Cloneable
{
  public static final Map<e, bi> d;
  private static final bx e = new bx("Response");
  private static final bp f = new bp("resp_code", (byte)8, (short)1);
  private static final bp g = new bp("msg", (byte)11, (short)2);
  private static final bp h = new bp("imprint", (byte)12, (short)3);
  private static final Map<Class<? extends bz>, ca> i = new HashMap();
  public int a;
  public String b;
  public ak c;
  private byte j = 0;
  private e[] k = { e.b, e.c };
  
  static
  {
    i.put(cb.class, new b(null));
    i.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("resp_code", (byte)1, new bj((byte)8)));
    localEnumMap.put(e.b, new bi("msg", (byte)2, new bj((byte)11)));
    localEnumMap.put(e.c, new bi("imprint", (byte)2, new bm((byte)12, ak.class)));
    d = Collections.unmodifiableMap(localEnumMap);
    bi.a(ao.class, d);
  }
  
  public void a(bs parambs)
  {
    ((ca)i.get(parambs.y())).b().b(parambs, this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = ay.a(this.j, 0, paramBoolean);
  }
  
  public boolean a()
  {
    return ay.a(this.j, 0);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(bs parambs)
  {
    ((ca)i.get(parambs.y())).b().a(parambs, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean c()
  {
    return this.b != null;
  }
  
  public ak d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.c != null;
  }
  
  public void f()
  {
    if (this.c != null) {
      this.c.f();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Response(");
    localStringBuilder.append("resp_code:");
    localStringBuilder.append(this.a);
    if (c())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("msg:");
      if (this.b == null) {
        localStringBuilder.append("null");
      }
    }
    else if (e())
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("imprint:");
      if (this.c != null) {
        break label120;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.b);
      break;
      label120:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends cb<ao>
  {
    public void a(bs parambs, ao paramao)
    {
      parambs.f();
      bp localbp = parambs.h();
      if (localbp.b == 0)
      {
        parambs.g();
        if (!paramao.a()) {
          throw new bt("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (localbp.c)
        {
        default: 
          bv.a(parambs, localbp.b);
        }
        for (;;)
        {
          parambs.i();
          break;
          if (localbp.b == 8)
          {
            paramao.a = parambs.s();
            paramao.a(true);
          }
          else
          {
            bv.a(parambs, localbp.b);
            continue;
            if (localbp.b == 11)
            {
              paramao.b = parambs.v();
              paramao.b(true);
            }
            else
            {
              bv.a(parambs, localbp.b);
              continue;
              if (localbp.b == 12)
              {
                paramao.c = new ak();
                paramao.c.a(parambs);
                paramao.c(true);
              }
              else
              {
                bv.a(parambs, localbp.b);
              }
            }
          }
        }
      }
      paramao.f();
    }
    
    public void b(bs parambs, ao paramao)
    {
      paramao.f();
      parambs.a(ao.g());
      parambs.a(ao.h());
      parambs.a(paramao.a);
      parambs.b();
      if ((paramao.b != null) && (paramao.c()))
      {
        parambs.a(ao.i());
        parambs.a(paramao.b);
        parambs.b();
      }
      if ((paramao.c != null) && (paramao.e()))
      {
        parambs.a(ao.j());
        paramao.c.b(parambs);
        parambs.b();
      }
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public ao.a a()
    {
      return new ao.a(null);
    }
  }
  
  private static class c
    extends cc<ao>
  {
    public void a(bs parambs, ao paramao)
    {
      parambs = (by)parambs;
      parambs.a(paramao.a);
      BitSet localBitSet = new BitSet();
      if (paramao.c()) {
        localBitSet.set(0);
      }
      if (paramao.e()) {
        localBitSet.set(1);
      }
      parambs.a(localBitSet, 2);
      if (paramao.c()) {
        parambs.a(paramao.b);
      }
      if (paramao.e()) {
        paramao.c.b(parambs);
      }
    }
    
    public void b(bs parambs, ao paramao)
    {
      parambs = (by)parambs;
      paramao.a = parambs.s();
      paramao.a(true);
      BitSet localBitSet = parambs.b(2);
      if (localBitSet.get(0))
      {
        paramao.b = parambs.v();
        paramao.b(true);
      }
      if (localBitSet.get(1))
      {
        paramao.c = new ak();
        paramao.c.a(parambs);
        paramao.c(true);
      }
    }
  }
  
  private static class d
    implements ca
  {
    public ao.c a()
    {
      return new ao.c(null);
    }
  }
  
  public static enum e
  {
    private static final Map<String, e> d;
    private final short e;
    private final String f;
    
    static
    {
      d = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        d.put(locale.a(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.e = paramShort;
      this.f = paramString;
    }
    
    public String a()
    {
      return this.f;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */