package com.xiaoenai.app.data.d.c;

import com.xiaoenai.app.net.http.base.a.c.a;
import java.util.HashMap;
import java.util.Map;
import rx.a.a;
import rx.k;

class b
  implements a.a<String>
{
  b(a parama, String paramString) {}
  
  public void a(k<? super String> paramk)
  {
    paramk.b();
    paramk = new c(this, a.a(this.b), paramk);
    HashMap localHashMap = new HashMap();
    localHashMap.put("content", this.a);
    localHashMap.put("tag", "text");
    com.xiaoenai.app.utils.f.a.c("LogMessageSize():", new Object[] { Integer.valueOf(this.a.length()) });
    a.c(this.b).a(a.b(this.b)).a(paramk).b("POST").c("application/json; charset=utf-8").a(localHashMap).c().a(a.d(this.b));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */