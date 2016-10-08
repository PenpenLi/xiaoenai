package b.a.b;

import b.a.a.d;
import b.ab;
import b.ag;
import b.ai;
import b.al;
import b.aq;
import b.aq.a;
import b.as;
import b.z.a;
import c.aa;
import c.i;
import c.l;
import c.y;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class g
  implements n
{
  private static final i a = i.a("connection");
  private static final i b = i.a("host");
  private static final i c = i.a("keep-alive");
  private static final i d = i.a("proxy-connection");
  private static final i e = i.a("transfer-encoding");
  private static final i f = i.a("te");
  private static final i g = i.a("encoding");
  private static final i h = i.a("upgrade");
  private static final List<i> i = b.a.j.a(new i[] { a, b, c, d, e, b.a.a.r.b, b.a.a.r.c, b.a.a.r.d, b.a.a.r.e, b.a.a.r.f, b.a.a.r.g });
  private static final List<i> j = b.a.j.a(new i[] { a, b, c, d, e });
  private static final List<i> k = b.a.j.a(new i[] { a, b, c, d, f, e, g, h, b.a.a.r.b, b.a.a.r.c, b.a.a.r.d, b.a.a.r.e, b.a.a.r.f, b.a.a.r.g });
  private static final List<i> l = b.a.j.a(new i[] { a, b, c, d, f, e, g, h });
  private final w m;
  private final d n;
  private j o;
  private b.a.a.p p;
  
  public g(w paramw, d paramd)
  {
    this.m = paramw;
    this.n = paramd;
  }
  
  public static aq.a a(List<b.a.a.r> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    z.a locala = new z.a();
    int i5 = paramList.size();
    int i1 = 0;
    while (i1 < i5)
    {
      i locali = ((b.a.a.r)paramList.get(i1)).h;
      String str2 = ((b.a.a.r)paramList.get(i1)).i.a();
      int i2 = 0;
      if (i2 < str2.length())
      {
        int i4 = str2.indexOf(0, i2);
        int i3 = i4;
        if (i4 == -1) {
          i3 = str2.length();
        }
        String str1 = str2.substring(i2, i3);
        if (locali.equals(b.a.a.r.a)) {
          localObject1 = str1;
        }
        for (;;)
        {
          i2 = i3 + 1;
          break;
          if (locali.equals(b.a.a.r.g)) {
            localObject2 = str1;
          } else if (!j.contains(locali)) {
            locala.a(locali.a(), str1);
          }
        }
      }
      i1 += 1;
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = v.a((String)localObject2 + " " + (String)localObject1);
    return new aq.a().a(ai.c).a(paramList.b).a(paramList.c).a(locala.a());
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }
  
  public static aq.a b(List<b.a.a.r> paramList)
  {
    Object localObject = null;
    z.a locala = new z.a();
    int i2 = paramList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      i locali = ((b.a.a.r)paramList.get(i1)).h;
      String str = ((b.a.a.r)paramList.get(i1)).i.a();
      if (locali.equals(b.a.a.r.a)) {
        localObject = str;
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (!l.contains(locali)) {
          locala.a(locali.a(), str);
        }
      }
    }
    if (localObject == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = v.a("HTTP/1.1 " + (String)localObject);
    return new aq.a().a(ai.d).a(paramList.b).a(paramList.c).a(locala.a());
  }
  
  public static List<b.a.a.r> b(al paramal)
  {
    b.z localz = paramal.c();
    ArrayList localArrayList = new ArrayList(localz.a() + 5);
    localArrayList.add(new b.a.a.r(b.a.a.r.b, paramal.b()));
    localArrayList.add(new b.a.a.r(b.a.a.r.c, r.a(paramal.a())));
    localArrayList.add(new b.a.a.r(b.a.a.r.g, "HTTP/1.1"));
    localArrayList.add(new b.a.a.r(b.a.a.r.f, b.a.j.a(paramal.a(), false)));
    localArrayList.add(new b.a.a.r(b.a.a.r.d, paramal.a().b()));
    paramal = new LinkedHashSet();
    int i3 = localz.a();
    int i1 = 0;
    if (i1 < i3)
    {
      i locali = i.a(localz.a(i1).toLowerCase(Locale.US));
      if (i.contains(locali)) {}
      label315:
      for (;;)
      {
        i1 += 1;
        break;
        String str = localz.b(i1);
        if (paramal.add(locali))
        {
          localArrayList.add(new b.a.a.r(locali, str));
        }
        else
        {
          int i2 = 0;
          for (;;)
          {
            if (i2 >= localArrayList.size()) {
              break label315;
            }
            if (((b.a.a.r)localArrayList.get(i2)).h.equals(locali))
            {
              localArrayList.set(i2, new b.a.a.r(locali, a(((b.a.a.r)localArrayList.get(i2)).i.a(), str)));
              break;
            }
            i2 += 1;
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<b.a.a.r> c(al paramal)
  {
    int i1 = 0;
    b.z localz = paramal.c();
    ArrayList localArrayList = new ArrayList(localz.a() + 4);
    localArrayList.add(new b.a.a.r(b.a.a.r.b, paramal.b()));
    localArrayList.add(new b.a.a.r(b.a.a.r.c, r.a(paramal.a())));
    localArrayList.add(new b.a.a.r(b.a.a.r.e, b.a.j.a(paramal.a(), false)));
    localArrayList.add(new b.a.a.r(b.a.a.r.d, paramal.a().b()));
    int i2 = localz.a();
    while (i1 < i2)
    {
      paramal = i.a(localz.a(i1).toLowerCase(Locale.US));
      if (!k.contains(paramal)) {
        localArrayList.add(new b.a.a.r(paramal, localz.b(i1)));
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public aq.a a()
  {
    if (this.n.a() == ai.d) {
      return b(this.p.d());
    }
    return a(this.p.d());
  }
  
  public as a(aq paramaq)
  {
    a locala = new a(this.p.g());
    return new p(paramaq.f(), c.p.a(locala));
  }
  
  public y a(al paramal, long paramLong)
  {
    return this.p.h();
  }
  
  public void a(j paramj)
  {
    this.o = paramj;
  }
  
  public void a(s params)
  {
    params.a(this.p.h());
  }
  
  public void a(al paramal)
  {
    if (this.p != null) {
      return;
    }
    this.o.b();
    boolean bool = this.o.a(paramal);
    if (this.n.a() == ai.d) {}
    for (paramal = c(paramal);; paramal = b(paramal))
    {
      this.p = this.n.a(paramal, bool, true);
      this.p.e().a(this.o.a.b(), TimeUnit.MILLISECONDS);
      this.p.f().a(this.o.a.c(), TimeUnit.MILLISECONDS);
      return;
    }
  }
  
  public void b()
  {
    this.p.h().close();
  }
  
  class a
    extends l
  {
    public a(c.z paramz)
    {
      super();
    }
    
    public void close()
    {
      g.a(g.this).a(false, g.this);
      super.close();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */