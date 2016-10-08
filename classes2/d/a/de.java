package d.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class de
{
  private final int a = 10;
  private final int b = 20;
  private final String c;
  private List<ae> d;
  private ag e;
  
  public de(String paramString)
  {
    this.c = paramString;
  }
  
  private boolean g()
  {
    boolean bool2 = false;
    Object localObject3 = this.e;
    Object localObject1;
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject3 != null) {
        break label204;
      }
    }
    label204:
    for (int i = 0;; i = ((ag)localObject3).d())
    {
      String str = a(a());
      boolean bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(localObject1))
        {
          Object localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new ag();
          }
          ((ag)localObject2).a(str);
          ((ag)localObject2).a(System.currentTimeMillis());
          ((ag)localObject2).a(i + 1);
          localObject3 = new ae();
          ((ae)localObject3).a(this.c);
          ((ae)localObject3).c(str);
          ((ae)localObject3).b((String)localObject1);
          ((ae)localObject3).a(((ag)localObject2).b());
          if (this.d == null) {
            this.d = new ArrayList(2);
          }
          this.d.add(localObject3);
          if (this.d.size() > 10) {
            this.d.remove(0);
          }
          this.e = ((ag)localObject2);
          bool1 = true;
        }
      }
      return bool1;
      localObject1 = ((ag)localObject3).a();
      break;
    }
  }
  
  public abstract String a();
  
  public String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.trim();
    } while ((paramString.length() == 0) || ("0".equals(paramString)) || ("unknown".equals(paramString.toLowerCase(Locale.US))));
    return paramString;
  }
  
  public void a(ai paramai)
  {
    this.e = ((ag)paramai.a().get(this.c));
    paramai = paramai.b();
    if ((paramai != null) && (paramai.size() > 0))
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      paramai = paramai.iterator();
      while (paramai.hasNext())
      {
        ae localae = (ae)paramai.next();
        if (this.c.equals(localae.a)) {
          this.d.add(localae);
        }
      }
    }
  }
  
  public void a(List<ae> paramList)
  {
    this.d = paramList;
  }
  
  public boolean b()
  {
    return g();
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.e == null) || (this.e.d() <= 20);
  }
  
  public ag e()
  {
    return this.e;
  }
  
  public List<ae> f()
  {
    return this.d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */