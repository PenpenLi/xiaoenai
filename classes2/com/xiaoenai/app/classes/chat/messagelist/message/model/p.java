package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.classes.chat.messagelist.a;
import com.xiaoenai.app.net.y;
import org.json.JSONObject;

class p
  extends y
{
  p(o paramo) {}
  
  public void a(JSONObject paramJSONObject)
  {
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


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */