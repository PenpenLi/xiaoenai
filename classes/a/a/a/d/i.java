package a.a.a.d;

import a.a.a.a;
import a.a.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class i<T>
{
  public static boolean a;
  public static boolean b;
  private final j<T> c;
  private StringBuilder d;
  private final List<Object> e;
  private final List<f<T, ?>> f;
  private final a<T, ?> g;
  private final String h;
  private Integer i;
  private Integer j;
  private boolean k;
  
  protected i(a<T, ?> parama)
  {
    this(parama, "T");
  }
  
  protected i(a<T, ?> parama, String paramString)
  {
    this.g = parama;
    this.h = paramString;
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.c = new j(parama, paramString);
  }
  
  private int a(StringBuilder paramStringBuilder)
  {
    int m = -1;
    if (this.i != null)
    {
      paramStringBuilder.append(" LIMIT ?");
      this.e.add(this.i);
      m = this.e.size() - 1;
    }
    return m;
  }
  
  public static <T2> i<T2> a(a<T2, ?> parama)
  {
    return new i(parama);
  }
  
  private void a(String paramString)
  {
    if (a) {
      e.a("Built SQL for query: " + paramString);
    }
    if (b) {
      e.a("Values for query: " + this.e);
    }
  }
  
  private void a(String paramString, a.a.a.g... paramVarArgs)
  {
    int n = paramVarArgs.length;
    int m = 0;
    while (m < n)
    {
      a.a.a.g localg = paramVarArgs[m];
      d();
      a(this.d, localg);
      if (String.class.equals(localg.b)) {
        this.d.append(" COLLATE LOCALIZED");
      }
      this.d.append(paramString);
      m += 1;
    }
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString)
  {
    this.e.clear();
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      paramStringBuilder.append(" JOIN ").append(localf.b.getTablename()).append(' ');
      paramStringBuilder.append(localf.e).append(" ON ");
      a.a.a.c.d.a(paramStringBuilder, localf.a, localf.c).append('=');
      a.a.a.c.d.a(paramStringBuilder, localf.e, localf.d);
    }
    int m;
    label163:
    int n;
    if (!this.c.a())
    {
      m = 1;
      if (m != 0)
      {
        paramStringBuilder.append(" WHERE ");
        this.c.a(paramStringBuilder, paramString, this.e);
      }
      paramString = this.f.iterator();
      if (!paramString.hasNext()) {
        return;
      }
      localObject = (f)paramString.next();
      n = m;
      if (!((f)localObject).f.a())
      {
        if (m != 0) {
          break label244;
        }
        paramStringBuilder.append(" WHERE ");
        m = 1;
      }
    }
    for (;;)
    {
      ((f)localObject).f.a(paramStringBuilder, ((f)localObject).e, this.e);
      n = m;
      m = n;
      break label163;
      m = 0;
      break;
      label244:
      paramStringBuilder.append(" AND ");
    }
  }
  
  private int b(StringBuilder paramStringBuilder)
  {
    int m = -1;
    if (this.j != null)
    {
      if (this.i == null) {
        throw new IllegalStateException("Offset cannot be set without limit");
      }
      paramStringBuilder.append(" OFFSET ?");
      this.e.add(this.j);
      m = this.e.size() - 1;
    }
    return m;
  }
  
  private void d()
  {
    if (this.d == null) {
      this.d = new StringBuilder();
    }
    while (this.d.length() <= 0) {
      return;
    }
    this.d.append(",");
  }
  
  private StringBuilder e()
  {
    StringBuilder localStringBuilder = new StringBuilder(a.a.a.c.d.a(this.g.getTablename(), this.h, this.g.getAllColumns(), this.k));
    a(localStringBuilder, this.h);
    if ((this.d != null) && (this.d.length() > 0)) {
      localStringBuilder.append(" ORDER BY ").append(this.d);
    }
    return localStringBuilder;
  }
  
  public g<T> a()
  {
    Object localObject = e();
    int m = a((StringBuilder)localObject);
    int n = b((StringBuilder)localObject);
    localObject = ((StringBuilder)localObject).toString();
    a((String)localObject);
    return g.a(this.g, (String)localObject, this.e.toArray(), m, n);
  }
  
  public i<T> a(int paramInt)
  {
    this.i = Integer.valueOf(paramInt);
    return this;
  }
  
  public i<T> a(k paramk, k... paramVarArgs)
  {
    this.c.a(paramk, paramVarArgs);
    return this;
  }
  
  public i<T> a(a.a.a.g... paramVarArgs)
  {
    a(" DESC", paramVarArgs);
    return this;
  }
  
  protected StringBuilder a(StringBuilder paramStringBuilder, a.a.a.g paramg)
  {
    this.c.a(paramg);
    paramStringBuilder.append(this.h).append('.').append('\'').append(paramg.e).append('\'');
    return paramStringBuilder;
  }
  
  public d<T> b()
  {
    if (!this.f.isEmpty()) {
      throw new a.a.a.d("JOINs are not supported for DELETE queries");
    }
    String str = this.g.getTablename();
    StringBuilder localStringBuilder = new StringBuilder(a.a.a.c.d.a(str, null));
    a(localStringBuilder, this.h);
    str = localStringBuilder.toString().replace(this.h + ".\"", '"' + str + "\".\"");
    a(str);
    return d.a(this.g, str, this.e.toArray());
  }
  
  public List<T> c()
  {
    return a().c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\a\a\a\d\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */