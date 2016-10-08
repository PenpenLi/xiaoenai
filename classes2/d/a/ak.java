package d.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ak
  implements ba<ak, e>, Serializable, Cloneable
{
  public static final Map<e, bi> d;
  private static final bx e = new bx("Imprint");
  private static final bp f = new bp("property", (byte)13, (short)1);
  private static final bp g = new bp("version", (byte)8, (short)2);
  private static final bp h = new bp("checksum", (byte)11, (short)3);
  private static final Map<Class<? extends bz>, ca> i = new HashMap();
  public Map<String, am> a;
  public int b;
  public String c;
  private byte j = 0;
  
  static
  {
    i.put(cb.class, new b(null));
    i.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("property", (byte)1, new bl((byte)13, new bj((byte)11), new bm((byte)12, am.class))));
    localEnumMap.put(e.b, new bi("version", (byte)1, new bj((byte)8)));
    localEnumMap.put(e.c, new bi("checksum", (byte)1, new bj((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    bi.a(ak.class, d);
  }
  
  public ak a(int paramInt)
  {
    this.b = paramInt;
    b(true);
    return this;
  }
  
  public ak a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Map<String, am> a()
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
  
  public int c()
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
    if (this.a == null) {
      throw new bt("Required field 'property' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new bt("Required field 'checksum' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Imprint(");
    localStringBuilder.append("property:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("version:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append("checksum:");
      if (this.c != null) {
        break label106;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label106:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends cb<ak>
  {
    public void a(bs parambs, ak paramak)
    {
      parambs.f();
      Object localObject = parambs.h();
      if (((bp)localObject).b == 0)
      {
        parambs.g();
        if (!paramak.d()) {
          throw new bt("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
      }
      else
      {
        switch (((bp)localObject).c)
        {
        default: 
          bv.a(parambs, ((bp)localObject).b);
        }
        for (;;)
        {
          parambs.i();
          break;
          if (((bp)localObject).b == 13)
          {
            localObject = parambs.j();
            paramak.a = new HashMap(((br)localObject).c * 2);
            int i = 0;
            while (i < ((br)localObject).c)
            {
              String str = parambs.v();
              am localam = new am();
              localam.a(parambs);
              paramak.a.put(str, localam);
              i += 1;
            }
            parambs.k();
            paramak.a(true);
          }
          else
          {
            bv.a(parambs, ((bp)localObject).b);
            continue;
            if (((bp)localObject).b == 8)
            {
              paramak.b = parambs.s();
              paramak.b(true);
            }
            else
            {
              bv.a(parambs, ((bp)localObject).b);
              continue;
              if (((bp)localObject).b == 11)
              {
                paramak.c = parambs.v();
                paramak.c(true);
              }
              else
              {
                bv.a(parambs, ((bp)localObject).b);
              }
            }
          }
        }
      }
      paramak.f();
    }
    
    public void b(bs parambs, ak paramak)
    {
      paramak.f();
      parambs.a(ak.g());
      if (paramak.a != null)
      {
        parambs.a(ak.h());
        parambs.a(new br((byte)11, (byte)12, paramak.a.size()));
        Iterator localIterator = paramak.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          parambs.a((String)localEntry.getKey());
          ((am)localEntry.getValue()).b(parambs);
        }
        parambs.d();
        parambs.b();
      }
      parambs.a(ak.i());
      parambs.a(paramak.b);
      parambs.b();
      if (paramak.c != null)
      {
        parambs.a(ak.j());
        parambs.a(paramak.c);
        parambs.b();
      }
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public ak.a a()
    {
      return new ak.a(null);
    }
  }
  
  private static class c
    extends cc<ak>
  {
    public void a(bs parambs, ak paramak)
    {
      parambs = (by)parambs;
      parambs.a(paramak.a.size());
      Iterator localIterator = paramak.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        parambs.a((String)localEntry.getKey());
        ((am)localEntry.getValue()).b(parambs);
      }
      parambs.a(paramak.b);
      parambs.a(paramak.c);
    }
    
    public void b(bs parambs, ak paramak)
    {
      parambs = (by)parambs;
      br localbr = new br((byte)11, (byte)12, parambs.s());
      paramak.a = new HashMap(localbr.c * 2);
      int i = 0;
      while (i < localbr.c)
      {
        String str = parambs.v();
        am localam = new am();
        localam.a(parambs);
        paramak.a.put(str, localam);
        i += 1;
      }
      paramak.a(true);
      paramak.b = parambs.s();
      paramak.b(true);
      paramak.c = parambs.v();
      paramak.c(true);
    }
  }
  
  private static class d
    implements ca
  {
    public ak.c a()
    {
      return new ak.c(null);
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */