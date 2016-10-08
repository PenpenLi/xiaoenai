package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.classes.chat.messagelist.a;
import com.xiaoenai.app.net.y;
import org.json.JSONObject;

class l
  extends y
{
  l(k paramk) {}
  
  public void a()
  {
    super.a();
    this.a.b(Integer.valueOf(-1));
    this.a.k();
    a.a().a(this.a);
    a.k();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject.getBoolean("success"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      this.a.b(paramJSONObject.getLong("id"));
      this.a.a(paramJSONObject.getInt("ts"));
      this.a.b(Integer.valueOf(0));
      this.a.k();
      a.l();
      return;
    }
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    a.l();
  }
  
  public void b()
  {
    super.b();
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    a.l();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */