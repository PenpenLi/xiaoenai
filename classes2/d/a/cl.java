package d.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class cl
  implements Serializable
{
  private List<String> a = new ArrayList();
  private List<String> b = new ArrayList();
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private String f = null;
  
  public String a()
  {
    return cd.a(this.a);
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(String paramString)
  {
    int i = 0;
    try
    {
      if (this.b.size() < cy.a().b()) {
        this.b.add(paramString);
      }
      while (this.b.size() > cy.a().b())
      {
        while (i < this.b.size() - cy.a().b())
        {
          this.b.remove(this.b.get(0));
          i += 1;
        }
        this.b.remove(this.b.get(0));
        this.b.add(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public String b()
  {
    return cd.a(this.b);
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public List<String> c()
  {
    return this.b;
  }
  
  public void c(long paramLong)
  {
    this.e = paramLong;
  }
  
  public long d()
  {
    return this.c;
  }
  
  public long e()
  {
    return this.d;
  }
  
  public long f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[key: ").append(this.a).append("] [label: ").append(this.b).append("][ totalTimeStamp").append(this.f).append("][ value").append(this.d).append("][ count").append(this.e).append("][ timeWindowNum").append(this.f).append("]");
    return localStringBuffer.toString();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */