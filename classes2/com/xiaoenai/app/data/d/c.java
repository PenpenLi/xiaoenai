package com.xiaoenai.app.data.d;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.domain.d.a.a;
import com.xiaoenai.app.net.http.base.a.c.a;
import com.xiaoenai.app.net.http.base.b;
import com.xiaoenai.app.net.http.base.b.a;
import com.xiaoenai.app.net.http.base.e.a;
import org.json.JSONObject;

public abstract class c
{
  protected String a;
  protected Context b;
  protected final j c;
  protected final m d;
  protected final f e;
  protected final Handler f;
  
  public c(Context paramContext, j paramj, m paramm, f paramf, Handler paramHandler)
  {
    this.b = paramContext;
    this.c = paramj;
    this.d = paramm;
    this.e = paramf;
    this.f = paramHandler;
  }
  
  protected a a(com.xiaoenai.app.net.http.base.e parame)
  {
    a locala = new a();
    locala.a(parame.b());
    locala.c(parame.f());
    locala.a(parame.a());
    locala.c(parame.e());
    locala.b(parame.d());
    locala.b(parame.c());
    this.f.post(e.a(this, parame, locala));
    return locala;
  }
  
  protected c.a a()
  {
    return new c.a().a(this.d).c("application/json; charset=utf-8");
  }
  
  protected abstract void a(String paramString);
  
  protected boolean a(JSONObject paramJSONObject)
  {
    return (paramJSONObject.optBoolean("success")) && (paramJSONObject.has("data")) && (paramJSONObject.optJSONObject("data") != null);
  }
  
  protected a b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("error");
    int i = paramJSONObject.optInt("type");
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("message");
    String str3 = paramJSONObject.optString("params");
    int j = paramJSONObject.optInt("code", 0);
    paramJSONObject = a(new e.a().b(j).a(i).a(str1).b(str2).c(str3).a());
    this.f.post(d.a(this, j, paramJSONObject));
    return paramJSONObject;
  }
  
  protected b b()
  {
    return new b.a().a(true).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\data\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */