package d.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class am
  implements ba<am, e>, Serializable, Cloneable
{
  public static final Map<e, bi> d;
  private static final bx e = new bx("ImprintValue");
  private static final bp f = new bp("value", (byte)11, (short)1);
  private static final bp g = new bp("ts", (byte)10, (short)2);
  private static final bp h = new bp("guid", (byte)11, (short)3);
  private static final Map<Class<? extends bz>, ca> i = new HashMap();
  public String a;
  public long b;
  public String c;
  private byte j = 0;
  private e[] k = { e.a };
  
  static
  {
    i.put(cb.class, new b(null));
    i.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("value", (byte)2, new bj((byte)11)));
    localEnumMap.put(e.b, new bi("ts", (byte)1, new bj((byte)10)));
    localEnumMap.put(e.c, new bi("guid", (byte)1, new bj((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    bi.a(am.class, d);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(bs parambs)
  {
    ((ca)i.get(parambs.y())).b().b(parambs, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public void b(bs parambs)
  {
    ((ca)i.get(parambs.y())).b().a(parambs, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = ay.a(this.j, 0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public boolean d()
  {
    return ay.a(this.j, 0);
  }
  
  public String e()
  {
    return this.c;
  }
  
  public void f()
  {
    if (this.c == null) {
      throw new bt("Required field 'guid' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ImprintValue(");
    int m = 1;
    if (b())
    {
      localStringBuilder.append("value:");
      if (this.a == null)
      {
        localStringBuilder.append("null");
        m = 0;
      }
    }
    else
    {
      if (m == 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("guid:");
      if (this.c != null) {
        break label121;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label121:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends cb<am>
  {
    public void a(bs parambs, am paramam)
    {
      parambs.f();
      bp localbp = parambs.h();
      if (localbp.b == 0)
      {
        parambs.g();
        if (!paramam.d()) {
          throw new bt("Required field 'ts' was not found in serialized data! Struct: " + toString());
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
          if (localbp.b == 11)
          {
            paramam.a = parambs.v();
            paramam.a(true);
          }
          else
          {
            bv.a(parambs, localbp.b);
            continue;
            if (localbp.b == 10)
            {
              paramam.b = parambs.t();
              paramam.b(true);
            }
            else
            {
              bv.a(parambs, localbp.b);
              continue;
              if (localbp.b == 11)
              {
                paramam.c = parambs.v();
                paramam.c(true);
              }
              else
              {
                bv.a(parambs, localbp.b);
              }
            }
          }
        }
      }
      paramam.f();
    }
    
    public void b(bs parambs, am paramam)
    {
      paramam.f();
      parambs.a(am.g());
      if ((paramam.a != null) && (paramam.b()))
      {
        parambs.a(am.h());
        parambs.a(paramam.a);
        parambs.b();
      }
      parambs.a(am.i());
      parambs.a(paramam.b);
      parambs.b();
      if (paramam.c != null)
      {
        parambs.a(am.j());
        parambs.a(paramam.c);
        parambs.b();
      }
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public am.a a()
    {
      return new am.a(null);
    }
  }
  
  private static class c
    extends cc<am>
  {
    public void a(bs parambs, am paramam)
    {
      parambs = (by)parambs;
      parambs.a(paramam.b);
      parambs.a(paramam.c);
      BitSet localBitSet = new BitSet();
      if (paramam.b()) {
        localBitSet.set(0);
      }
      parambs.a(localBitSet, 1);
      if (paramam.b()) {
        parambs.a(paramam.a);
      }
    }
    
    public void b(bs parambs, am paramam)
    {
      parambs = (by)parambs;
      paramam.b = parambs.t();
      paramam.b(true);
      paramam.c = parambs.v();
      paramam.c(true);
      if (parambs.b(1).get(0))
      {
        paramam.a = parambs.v();
        paramam.a(true);
      }
    }
  }
  
  private static class d
    implements ca
  {
    public am.c a()
    {
      return new am.c(null);
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */