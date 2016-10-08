package b;

import b.a.j;
import c.e;
import c.g;
import c.i;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class af
  extends an
{
  public static final ae a = ae.a("multipart/mixed");
  public static final ae b = ae.a("multipart/alternative");
  public static final ae c = ae.a("multipart/digest");
  public static final ae d = ae.a("multipart/parallel");
  public static final ae e = ae.a("multipart/form-data");
  private static final byte[] f = { 58, 32 };
  private static final byte[] g = { 13, 10 };
  private static final byte[] h = { 45, 45 };
  private final i i;
  private final ae j;
  private final ae k;
  private final List<b> l;
  private long m = -1L;
  
  af(i parami, ae paramae, List<b> paramList)
  {
    this.i = parami;
    this.j = paramae;
    this.k = ae.a(paramae + "; boundary=" + parami.a());
    this.l = j.a(paramList);
  }
  
  private long a(g paramg, boolean paramBoolean)
  {
    long l1 = 0L;
    if (paramBoolean) {
      paramg = new e();
    }
    for (g localg = paramg;; localg = null)
    {
      int i2 = this.l.size();
      int n = 0;
      Object localObject2;
      if (n < i2)
      {
        localObject2 = (b)this.l.get(n);
        Object localObject1 = b.a((b)localObject2);
        localObject2 = b.b((b)localObject2);
        paramg.c(h);
        paramg.b(this.i);
        paramg.c(g);
        if (localObject1 != null)
        {
          int i1 = 0;
          int i3 = ((z)localObject1).a();
          while (i1 < i3)
          {
            paramg.b(((z)localObject1).a(i1)).c(f).b(((z)localObject1).b(i1)).c(g);
            i1 += 1;
          }
        }
        localObject1 = ((an)localObject2).a();
        if (localObject1 != null) {
          paramg.b("Content-Type: ").b(((ae)localObject1).toString()).c(g);
        }
        l2 = ((an)localObject2).b();
        if (l2 != -1L) {
          paramg.b("Content-Length: ").k(l2).c(g);
        }
        while (!paramBoolean)
        {
          paramg.c(g);
          if (!paramBoolean) {
            break label307;
          }
          l1 += l2;
          paramg.c(g);
          n += 1;
          break;
        }
        localg.s();
        l2 = -1L;
      }
      label307:
      do
      {
        return l2;
        ((an)localObject2).a(paramg);
        break;
        paramg.c(h);
        paramg.b(this.i);
        paramg.c(h);
        paramg.c(g);
        l2 = l1;
      } while (!paramBoolean);
      long l2 = localg.b();
      localg.s();
      return l1 + l2;
    }
  }
  
  static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int n = 0;
    int i1 = paramString.length();
    if (n < i1)
    {
      char c1 = paramString.charAt(n);
      switch (c1)
      {
      default: 
        paramStringBuilder.append(c1);
      }
      for (;;)
      {
        n += 1;
        break;
        paramStringBuilder.append("%0A");
        continue;
        paramStringBuilder.append("%0D");
        continue;
        paramStringBuilder.append("%22");
      }
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public ae a()
  {
    return this.k;
  }
  
  public void a(g paramg)
  {
    a(paramg, false);
  }
  
  public long b()
  {
    long l1 = this.m;
    if (l1 != -1L) {
      return l1;
    }
    l1 = a(null, true);
    this.m = l1;
    return l1;
  }
  
  public static final class a
  {
    private final i a;
    private ae b = af.a;
    private final List<af.b> c = new ArrayList();
    
    public a()
    {
      this(UUID.randomUUID().toString());
    }
    
    public a(String paramString)
    {
      this.a = i.a(paramString);
    }
    
    public a a(ae paramae)
    {
      if (paramae == null) {
        throw new NullPointerException("type == null");
      }
      if (!paramae.a().equals("multipart")) {
        throw new IllegalArgumentException("multipart != " + paramae);
      }
      this.b = paramae;
      return this;
    }
    
    public a a(af.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException("part == null");
      }
      this.c.add(paramb);
      return this;
    }
    
    public a a(z paramz, an paraman)
    {
      return a(af.b.a(paramz, paraman));
    }
    
    public a a(String paramString1, String paramString2, an paraman)
    {
      return a(af.b.a(paramString1, paramString2, paraman));
    }
    
    public af a()
    {
      if (this.c.isEmpty()) {
        throw new IllegalStateException("Multipart body must have at least one part.");
      }
      return new af(this.a, this.b, this.c);
    }
  }
  
  public static final class b
  {
    private final z a;
    private final an b;
    
    private b(z paramz, an paraman)
    {
      this.a = paramz;
      this.b = paraman;
    }
    
    public static b a(z paramz, an paraman)
    {
      if (paraman == null) {
        throw new NullPointerException("body == null");
      }
      if ((paramz != null) && (paramz.a("Content-Type") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Type");
      }
      if ((paramz != null) && (paramz.a("Content-Length") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Length");
      }
      return new b(paramz, paraman);
    }
    
    public static b a(String paramString1, String paramString2, an paraman)
    {
      if (paramString1 == null) {
        throw new NullPointerException("name == null");
      }
      StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
      af.a(localStringBuilder, paramString1);
      if (paramString2 != null)
      {
        localStringBuilder.append("; filename=");
        af.a(localStringBuilder, paramString2);
      }
      return a(z.a(new String[] { "Content-Disposition", localStringBuilder.toString() }), paraman);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */