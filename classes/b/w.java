package b;

import b.a.j;
import c.e;
import c.g;
import java.util.ArrayList;
import java.util.List;

public final class w
  extends an
{
  private static final ae a = ae.a("application/x-www-form-urlencoded");
  private final List<String> b;
  private final List<String> c;
  
  private w(List<String> paramList1, List<String> paramList2)
  {
    this.b = j.a(paramList1);
    this.c = j.a(paramList2);
  }
  
  private long a(g paramg, boolean paramBoolean)
  {
    long l = 0L;
    if (paramBoolean) {}
    for (paramg = new e();; paramg = paramg.c())
    {
      int j = this.b.size();
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          paramg.b(38);
        }
        paramg.a((String)this.b.get(i));
        paramg.b(61);
        paramg.a((String)this.c.get(i));
        i += 1;
      }
    }
    if (paramBoolean)
    {
      l = paramg.b();
      paramg.s();
    }
    return l;
  }
  
  public ae a()
  {
    return a;
  }
  
  public void a(g paramg)
  {
    a(paramg, false);
  }
  
  public long b()
  {
    return a(null, true);
  }
  
  public static final class a
  {
    private final List<String> a = new ArrayList();
    private final List<String> b = new ArrayList();
    
    public a a(String paramString1, String paramString2)
    {
      this.a.add(ab.a(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
      this.b.add(ab.a(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
      return this;
    }
    
    public w a()
    {
      return new w(this.a, this.b, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */