package d.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ai
  implements ba<ai, e>, Serializable, Cloneable
{
  public static final Map<e, bi> d;
  private static final bx e = new bx("IdTracking");
  private static final bp f = new bp("snapshots", (byte)13, (short)1);
  private static final bp g = new bp("journals", (byte)15, (short)2);
  private static final bp h = new bp("checksum", (byte)11, (short)3);
  private static final Map<Class<? extends bz>, ca> i = new HashMap();
  public Map<String, ag> a;
  public List<ae> b;
  public String c;
  private e[] j = { e.b, e.c };
  
  static
  {
    i.put(cb.class, new b(null));
    i.put(cc.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new bi("snapshots", (byte)1, new bl((byte)13, new bj((byte)11), new bm((byte)12, ag.class))));
    localEnumMap.put(e.b, new bi("journals", (byte)2, new bk((byte)15, new bm((byte)12, ae.class))));
    localEnumMap.put(e.c, new bi("checksum", (byte)2, new bj((byte)11)));
    d = Collections.unmodifiableMap(localEnumMap);
    bi.a(ai.class, d);
  }
  
  public ai a(List<ae> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public ai a(Map<String, ag> paramMap)
  {
    this.a = paramMap;
    return this;
  }
  
  public Map<String, ag> a()
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
  
  public List<ae> b()
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
  
  public boolean d()
  {
    return this.c != null;
  }
  
  public void e()
  {
    if (this.a == null) {
      throw new bt("Required field 'snapshots' was not present! Struct: " + toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("IdTracking(");
    localStringBuilder.append("snapshots:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (c())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("journals:");
        if (this.b != null) {
          break label125;
        }
        localStringBuilder.append("null");
      }
      label66:
      if (d())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("checksum:");
        if (this.c != null) {
          break label137;
        }
        localStringBuilder.append("null");
      }
    }
    for (;;)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label125:
      localStringBuilder.append(this.b);
      break label66;
      label137:
      localStringBuilder.append(this.c);
    }
  }
  
  private static class a
    extends cb<ai>
  {
    public void a(bs parambs, ai paramai)
    {
      parambs.f();
      Object localObject1 = parambs.h();
      if (((bp)localObject1).b == 0)
      {
        parambs.g();
        paramai.e();
        return;
      }
      switch (((bp)localObject1).c)
      {
      default: 
        bv.a(parambs, ((bp)localObject1).b);
      }
      for (;;)
      {
        parambs.i();
        break;
        int i;
        Object localObject2;
        if (((bp)localObject1).b == 13)
        {
          localObject1 = parambs.j();
          paramai.a = new HashMap(((br)localObject1).c * 2);
          i = 0;
          while (i < ((br)localObject1).c)
          {
            localObject2 = parambs.v();
            ag localag = new ag();
            localag.a(parambs);
            paramai.a.put(localObject2, localag);
            i += 1;
          }
          parambs.k();
          paramai.a(true);
        }
        else
        {
          bv.a(parambs, ((bp)localObject1).b);
          continue;
          if (((bp)localObject1).b == 15)
          {
            localObject1 = parambs.l();
            paramai.b = new ArrayList(((bq)localObject1).b);
            i = 0;
            while (i < ((bq)localObject1).b)
            {
              localObject2 = new ae();
              ((ae)localObject2).a(parambs);
              paramai.b.add(localObject2);
              i += 1;
            }
            parambs.m();
            paramai.b(true);
          }
          else
          {
            bv.a(parambs, ((bp)localObject1).b);
            continue;
            if (((bp)localObject1).b == 11)
            {
              paramai.c = parambs.v();
              paramai.c(true);
            }
            else
            {
              bv.a(parambs, ((bp)localObject1).b);
            }
          }
        }
      }
    }
    
    public void b(bs parambs, ai paramai)
    {
      paramai.e();
      parambs.a(ai.f());
      Iterator localIterator;
      if (paramai.a != null)
      {
        parambs.a(ai.g());
        parambs.a(new br((byte)11, (byte)12, paramai.a.size()));
        localIterator = paramai.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          parambs.a((String)localEntry.getKey());
          ((ag)localEntry.getValue()).b(parambs);
        }
        parambs.d();
        parambs.b();
      }
      if ((paramai.b != null) && (paramai.c()))
      {
        parambs.a(ai.h());
        parambs.a(new bq((byte)12, paramai.b.size()));
        localIterator = paramai.b.iterator();
        while (localIterator.hasNext()) {
          ((ae)localIterator.next()).b(parambs);
        }
        parambs.e();
        parambs.b();
      }
      if ((paramai.c != null) && (paramai.d()))
      {
        parambs.a(ai.i());
        parambs.a(paramai.c);
        parambs.b();
      }
      parambs.c();
      parambs.a();
    }
  }
  
  private static class b
    implements ca
  {
    public ai.a a()
    {
      return new ai.a(null);
    }
  }
  
  private static class c
    extends cc<ai>
  {
    public void a(bs parambs, ai paramai)
    {
      parambs = (by)parambs;
      parambs.a(paramai.a.size());
      Object localObject = paramai.a.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        parambs.a((String)localEntry.getKey());
        ((ag)localEntry.getValue()).b(parambs);
      }
      localObject = new BitSet();
      if (paramai.c()) {
        ((BitSet)localObject).set(0);
      }
      if (paramai.d()) {
        ((BitSet)localObject).set(1);
      }
      parambs.a((BitSet)localObject, 2);
      if (paramai.c())
      {
        parambs.a(paramai.b.size());
        localObject = paramai.b.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ae)((Iterator)localObject).next()).b(parambs);
        }
      }
      if (paramai.d()) {
        parambs.a(paramai.c);
      }
    }
    
    public void b(bs parambs, ai paramai)
    {
      int j = 0;
      parambs = (by)parambs;
      Object localObject1 = new br((byte)11, (byte)12, parambs.s());
      paramai.a = new HashMap(((br)localObject1).c * 2);
      int i = 0;
      Object localObject2;
      Object localObject3;
      while (i < ((br)localObject1).c)
      {
        localObject2 = parambs.v();
        localObject3 = new ag();
        ((ag)localObject3).a(parambs);
        paramai.a.put(localObject2, localObject3);
        i += 1;
      }
      paramai.a(true);
      localObject1 = parambs.b(2);
      if (((BitSet)localObject1).get(0))
      {
        localObject2 = new bq((byte)12, parambs.s());
        paramai.b = new ArrayList(((bq)localObject2).b);
        i = j;
        while (i < ((bq)localObject2).b)
        {
          localObject3 = new ae();
          ((ae)localObject3).a(parambs);
          paramai.b.add(localObject3);
          i += 1;
        }
        paramai.b(true);
      }
      if (((BitSet)localObject1).get(1))
      {
        paramai.c = parambs.v();
        paramai.c(true);
      }
    }
  }
  
  private static class d
    implements ca
  {
    public ai.c a()
    {
      return new ai.c(null);
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */