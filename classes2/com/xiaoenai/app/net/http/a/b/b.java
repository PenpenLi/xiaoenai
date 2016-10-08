package com.xiaoenai.app.net.http.a.b;

import b.al;
import b.al.a;
import b.an;
import b.z.a;
import com.xiaoenai.app.net.http.base.a.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class b
{
  protected String a;
  protected Object b;
  protected Map<String, String> c;
  protected Map<String, String> d;
  protected al.a e = new al.a();
  
  protected b(c paramc)
  {
    this.a = paramc.a();
    this.b = paramc.b();
    this.c = paramc.c();
    this.d = paramc.d();
    if (this.a == null) {
      com.xiaoenai.app.net.http.a.a.a.a("url can not be null.", new Object[0]);
    }
    c();
  }
  
  private void c()
  {
    this.e.a(this.a).a(this.b);
    b();
  }
  
  protected abstract al a(an paraman);
  
  public al a(com.xiaoenai.app.net.http.base.b.a parama)
  {
    return a(a(a(), parama));
  }
  
  protected abstract an a();
  
  protected an a(an paraman, com.xiaoenai.app.net.http.base.b.a parama)
  {
    return paraman;
  }
  
  protected void b()
  {
    z.a locala = new z.a();
    if ((this.d == null) || (this.d.isEmpty())) {
      return;
    }
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      locala.a(str, (String)this.d.get(str));
    }
    this.e.a(locala.a());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */