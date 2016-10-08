package com.xiaoenai.app.classes.chat.messagelist.message.b;

import com.xiaoenai.app.classes.chat.messagelist.view.n;
import com.xiaoenai.app.net.y;
import org.json.JSONObject;

final class g
  extends y
{
  g(com.xiaoenai.app.classes.chat.messagelist.message.model.d paramd, n paramn) {}
  
  public void a()
  {
    super.a();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject.getBoolean("success"))
    {
      this.a.c(1);
      this.a.b(Integer.valueOf(1));
      d.b(this.a, this.b);
      this.a.k();
      com.xiaoenai.app.classes.chat.messagelist.a.a().c(this.a);
      this.a.l();
      com.xiaoenai.app.utils.f.a.c("send {}", new Object[] { Long.valueOf(this.a.h()) });
    }
  }
  
  public void b()
  {
    super.b();
    this.a.c(false);
    this.a.c(-99999.0D);
    d.b(this.a, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */