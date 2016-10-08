package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.net.y;
import org.json.JSONObject;

class b
  extends y
{
  b(a parama) {}
  
  public void a()
  {
    super.a();
    this.a.b(Integer.valueOf(-1));
    this.a.k();
    com.xiaoenai.app.classes.chat.messagelist.a.a().a(this.a);
    com.xiaoenai.app.classes.chat.messagelist.a.k();
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
      com.xiaoenai.app.classes.chat.messagelist.a.l();
      return;
    }
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  public void b()
  {
    super.b();
    this.a.b(Integer.valueOf(-2));
    this.a.k();
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */