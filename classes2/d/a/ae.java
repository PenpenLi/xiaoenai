package d.a;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ae
  implements ba<ae, e>, Serializable, Cloneable
{
  public static final Map<e, bi> e;
  private static final bx f = new bx("IdJournal");
  private static final bp g = new bp("domain", (byte)11, (short)1);
  private static final bp h = new bp("old_id", (byte)11, (short)2);
  private static final bp i = new bp("new_id", (byte)11, (short)3);
  private static final bp j = new bp("ts", (byte)10, (short)4);
  private static final Map<Class<? extends bz>, ca> k = new HashMap();
  public String a;
  public String b;
  public String c;
  public long d;
  private byte l = 0;
  private e[] m = { e.b };
  
  static
  {
    k.put(cb.class, new b(null));
    k.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("domain", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.b, new bi("old_id", (byte)2, new bj((byte)11)));
    localEnumMap.put(e.c, new bi("new_id", (byte)1, new bj((byte)11)));
    localEnumMap.put(e.d, new bi("ts", (byte)1, new bj((byte)10)));
    e = Collections.unmodifiableMap(localEnumMap);
    bi.a(ae.class, e);
  }
  
  public ae a(long paramLong)
  {
    this.d = paramLong;
    d(true);
    return this;
  }
  
  public ae a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public void a(bs parambs)
  {
    ((ca)k.get(parambs.y())).b().b(parambs, this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    return this.b != null;
  }
  
  public ae b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public void b(bs parambs)
  {
    ((ca)k.get(parambs.y())).b().a(parambs, this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.b = null;
    }
  }
  
  public boolean b()
  {
    return ay.a(this.l, 0);
  }
  
  public ae c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void c()
  {
    if (this.a == null) {
      throw new bt("Required field 'domain' was not present! Struct: " + toString());
    }
    if (this.c == null) {
      throw new bt("Required field 'new_id' was not present! Struct: " + toString());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c = null;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.l = ay.a(this.l, 0, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdJournal(");
    localStringBuilder.append("domain:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (a())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("old_id:");
        if (this.b != null) {
          break label141;
        }
        localStringBuilder.append("null");
      }
      label66:
      localStringBuilder.append(", ");
      localStringBuilder.append("new_id:");
      if (this.c != null) {
        break label153;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label141:
      localStringBuilder.append(this.b);
      break label66;
      label153:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends cb<ae>
  {
    public void a(bs parambs, ae paramae)
    {
      parambs.f();
      bp localbp = parambs.h();
      if (localbp.b == 0)
      {
        parambs.g();
        if (!paramae.b()) {
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
            paramae.a = parambs.v();
            paramae.a(true);
          }
          else
          {
            bv.a(parambs, localbp.b);
            continue;
            if (localbp.b == 11)
            {
              paramae.b = parambs.v();
              paramae.b(true);
            }
            else
            {
              bv.a(parambs, localbp.b);
              continue;
              if (localbp.b == 11)
              {
                paramae.c = parambs.v();
                paramae.c(true);
              }
              else
              {
                bv.a(parambs, localbp.b);
                continue;
                if (localbp.b == 10)
                {
                  paramae.d = parambs.t();
                  paramae.d(true);
                }
                else
                {
                  bv.a(parambs, localbp.b);
                }
              }
            }
          }
        }
      }
      paramae.c();
    }
    
    public void b(bs parambs, ae paramae)
    {
      paramae.c();
      parambs.a(ae.d());
      if (paramae.a != null)
      {
        parambs.a(ae.e());
        parambs.a(paramae.a);
        parambs.b();
      }
      if ((paramae.b != null) && (paramae.a()))
      {
        parambs.a(ae.f());
        parambs.a(paramae.b);
        parambs.b();
      }
      if (paramae.c != null)
      {
        parambs.a(ae.g());
        parambs.a(paramae.c);
        parambs.b();
      }
      parambs.a(ae.h());
      parambs.a(paramae.d);
      parambs.b();
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public ae.a a()
    {
      return new ae.a(null);
    }
  }
  
  private static class c
    extends cc<ae>
  {
    public void a(bs parambs, ae paramae)
    {
      parambs = (by)parambs;
      parambs.a(paramae.a);
      parambs.a(paramae.c);
      parambs.a(paramae.d);
      BitSet localBitSet = new BitSet();
      if (paramae.a()) {
        localBitSet.set(0);
      }
      parambs.a(localBitSet, 1);
      if (paramae.a()) {
        parambs.a(paramae.b);
      }
    }
    
    public void b(bs parambs, ae paramae)
    {
      parambs = (by)parambs;
      paramae.a = parambs.v();
      paramae.a(true);
      paramae.c = parambs.v();
      paramae.c(true);
      paramae.d = parambs.t();
      paramae.d(true);
      if (parambs.b(1).get(0))
      {
        paramae.b = parambs.v();
        paramae.b(true);
      }
    }
  }
  
  private static class d
    implements ca
  {
    public ae.c a()
    {
      return new ae.c(null);
    }
  }
  
  public static enum e
  {
    private static final Map<String, e> e;
    private final short f;
    private final String g;
    
    static
    {
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        e.put(locale.a(), locale);
      }
    }
    
    private e(short paramShort, String paramString)
    {
      this.f = paramShort;
      this.g = paramString;
    }
    
    public String a()
    {
      return this.g;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */