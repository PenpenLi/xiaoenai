package com.xiaoenai.app.classes.common.b;

import com.d.a.a.f;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.utils.g.a;
import java.util.Queue;
import org.json.JSONObject;

class e
  implements g.a
{
  e(d paramd) {}
  
  public void a()
  {
    c.a(1, 1, null, this.a.a, 0, this.a.d.d(), 0);
  }
  
  public void a(int paramInt)
  {
    this.a.d.b(true);
    c.a(1, -1, null, null, c.h().size() + 1, this.a.d.d(), 0);
    c.h().clear();
    c.a(this.a.d);
  }
  
  public void a(com.xiaoenai.app.net.k paramk)
  {
    this.a.d.b(true);
    c.a(1, -1, null, null, c.h().size() + 1, this.a.d.d(), 0);
    c.h().clear();
    c.a(this.a.d);
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = new com.d.a.a.k(0);
    ((com.d.a.a.k)localObject).b(false);
    localObject = new c.a(this.a.d, (com.d.a.a.k)localObject, this.a.a, paramString);
    Xiaoenai.j().a().a((com.d.a.a.d)localObject);
    c.a(1, 2, paramJSONObject, paramString, c.h().size(), this.a.d.d(), this.a.c);
    a.a().a(this.a.a);
    c.a(this.a.d);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */