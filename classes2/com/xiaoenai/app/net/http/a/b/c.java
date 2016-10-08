package com.xiaoenai.app.net.http.a.b;

import android.os.Handler;
import b.ae;
import b.af;
import b.af.a;
import b.al;
import b.al.a;
import b.an;
import b.w.a;
import b.z;
import com.xiaoenai.app.net.http.a.h;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c
  extends b
{
  protected Handler f;
  private List<com.xiaoenai.app.net.http.base.a.a> g;
  
  public c(Handler paramHandler, com.xiaoenai.app.net.http.base.a.c paramc)
  {
    super(paramc);
    this.g = paramc.e();
    this.f = paramHandler;
  }
  
  private String a(String paramString)
  {
    Object localObject = URLConnection.getFileNameMap();
    try
    {
      paramString = ((FileNameMap)localObject).getContentTypeFor(URLEncoder.encode(paramString, "UTF-8"));
      localObject = paramString;
      if (paramString == null) {
        localObject = "application/octet-stream";
      }
      return (String)localObject;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private void a(af.a parama)
  {
    if ((this.c != null) && (!this.c.isEmpty()))
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        parama.a(z.a(new String[] { "Content-Disposition", "form-data; name=\"" + str + "\"" }), an.a(null, (String)this.c.get(str)));
      }
    }
  }
  
  private void a(w.a parama)
  {
    if (this.c != null)
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        parama.a(str, (String)this.c.get(str));
      }
    }
  }
  
  protected al a(an paraman)
  {
    return this.e.a(paraman).b();
  }
  
  protected an a()
  {
    if ((this.g == null) || (this.g.isEmpty()))
    {
      localObject = new w.a();
      a((w.a)localObject);
      return ((w.a)localObject).a();
    }
    Object localObject = new af.a().a(af.e);
    a((af.a)localObject);
    int i = 0;
    while (i < this.g.size())
    {
      com.xiaoenai.app.net.http.base.a.a locala = (com.xiaoenai.app.net.http.base.a.a)this.g.get(i);
      an localan = an.a(ae.a(a(locala.b)), locala.c);
      ((af.a)localObject).a(locala.a, locala.b, localan);
      i += 1;
    }
    return ((af.a)localObject).a();
  }
  
  protected an a(an paraman, com.xiaoenai.app.net.http.base.b.a parama)
  {
    if ((parama == null) || (this.g == null) || (this.g.isEmpty())) {
      return paraman;
    }
    return new h(paraman, new d(this, parama));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */