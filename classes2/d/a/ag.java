package d.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ag
  implements ba<ag, e>, Serializable, Cloneable
{
  public static final Map<e, bi> d;
  private static final bx e = new bx("IdSnapshot");
  private static final bp f = new bp("identity", (byte)11, (short)1);
  private static final bp g = new bp("ts", (byte)10, (short)2);
  private static final bp h = new bp("version", (byte)8, (short)3);
  private static final Map<Class<? extends bz>, ca> i = new HashMap();
  public String a;
  public long b;
  public int c;
  private byte j = 0;
  
  static
  {
    i.put(cb.class, new b(null));
    i.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("identity", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.b, new bi("ts", (byte)1, new bj((byte)10)));
    localEnumMap.put(e.c, new bi("version", (byte)1, new bj((byte)8)));
    d = Collections.unmodifiableMap(localEnumMap);
    bi.a(ag.class, d);
  }
  
  public ag a(int paramInt)
  {
    this.c = paramInt;
    c(true);
    return this;
  }
  
  public ag a(long paramLong)
  {
    this.b = paramLong;
    b(true);
    return this;
  }
  
  public ag a(String paramString)
  {
    this.a = paramString;
    return this;
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
  
  public long b()
  {
    return this.b;
  }
  
  public void b(bs parambs)
  {
    ((ca)i.get(parambs.y())).b().a(parambs, this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = ay.a(this.j, 0, paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = ay.a(this.j, 1, paramBoolean);
  }
  
  public boolean c()
  {
    return ay.a(this.j, 0);
  }
  
  public int d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return ay.a(this.j, 1);
  }
  
  public void f()
  {
    if (this.a == null) {
      throw new bt("Required field 'identity' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdSnapshot(");
    localStringBuilder.append("identity:");
    if (this.a == null) {
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
    }
  }
  
  private static class a
    extends cb<ag>
  {
    public void a(bs parambs, ag paramag)
    {
      parambs.f();
      bp localbp = parambs.h();
      if (localbp.b == 0)
      {
        parambs.g();
        if (!paramag.c()) {
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
            paramag.a = parambs.v();
            paramag.a(true);
          }
          else
          {
            bv.a(parambs, localbp.b);
            continue;
            if (localbp.b == 10)
            {
              paramag.b = parambs.t();
              paramag.b(true);
            }
            else
            {
              bv.a(parambs, localbp.b);
              continue;
              if (localbp.b == 8)
              {
                paramag.c = parambs.s();
                paramag.c(true);
              }
              else
              {
                bv.a(parambs, localbp.b);
              }
            }
          }
        }
      }
      if (!paramag.e()) {
        throw new bt("Required field 'version' was not found in serialized data! Struct: " + toString());
      }
      paramag.f();
    }
    
    public void b(bs parambs, ag paramag)
    {
      paramag.f();
      parambs.a(ag.g());
      if (paramag.a != null)
      {
        parambs.a(ag.h());
        parambs.a(paramag.a);
        parambs.b();
      }
      parambs.a(ag.i());
      parambs.a(paramag.b);
      parambs.b();
      parambs.a(ag.j());
      parambs.a(paramag.c);
      parambs.b();
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public ag.a a()
    {
      return new ag.a(null);
    }
  }
  
  private static class c
    extends cc<ag>
  {
    public void a(bs parambs, ag paramag)
    {
      parambs = (by)parambs;
      parambs.a(paramag.a);
      parambs.a(paramag.b);
      parambs.a(paramag.c);
    }
    
    public void b(bs parambs, ag paramag)
    {
      parambs = (by)parambs;
      paramag.a = parambs.v();
      paramag.a(true);
      paramag.b = parambs.t();
      paramag.b(true);
      paramag.c = parambs.s();
      paramag.c(true);
    }
  }
  
  private static class d
    implements ca
  {
    public ag.c a()
    {
      return new ag.c(null);
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */