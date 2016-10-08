package com.xiaoenai.app.net.http.a;

import android.text.TextUtils;
import b.ab;
import b.al;
import b.aq;
import b.as;
import b.g;
import b.h;
import com.xiaoenai.app.net.http.a.a.b;
import java.io.IOException;

class c
  implements h
{
  c(a parama, com.xiaoenai.app.net.http.base.b.a parama1, com.xiaoenai.app.net.http.base.a.c paramc) {}
  
  public void a(g paramg, aq paramaq)
  {
    localObject = null;
    for (;;)
    {
      try
      {
        if (!paramaq.c()) {
          continue;
        }
        com.xiaoenai.app.utils.f.a.c("Http requestUrl:{}\n statusCode={}\n responseStr:\n", new Object[] { paramaq.a().a().toString(), Integer.valueOf(paramaq.b()) });
        if ((TextUtils.isEmpty(this.a.b())) || (TextUtils.isEmpty(this.a.a()))) {
          continue;
        }
        paramaq = this.a.a(paramaq);
        paramg = paramaq;
      }
      catch (Exception paramaq)
      {
        paramaq.printStackTrace();
        this.c.a(paramg, paramaq, this.a);
        paramg = (g)localObject;
        continue;
      }
      this.c.a(paramg, this.b, this.a);
      return;
      paramaq = this.a.a(paramaq.g().d());
      paramg = paramaq;
      continue;
      this.c.a(paramaq, new b(paramaq.d()), this.a);
      paramg = (g)localObject;
    }
  }
  
  public void a(g paramg, IOException paramIOException)
  {
    this.c.a(paramg, paramIOException, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\http\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */