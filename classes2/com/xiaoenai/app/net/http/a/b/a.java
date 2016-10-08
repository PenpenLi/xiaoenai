package com.xiaoenai.app.net.http.a.b;

import b.ab;
import b.ab.a;
import b.al;
import b.al.a;
import b.an;
import com.xiaoenai.app.net.http.base.a.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a
  extends b
{
  public a(c paramc)
  {
    super(paramc);
    a(this.c);
  }
  
  private void a(Map<String, String> paramMap)
  {
    ab.a locala = ab.e(this.a).m();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        locala.a(str, (String)paramMap.get(str));
      }
    }
    this.e.a(locala.c());
  }
  
  protected al a(an paraman)
  {
    return this.e.a().b();
  }
  
  protected an a()
  {
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */