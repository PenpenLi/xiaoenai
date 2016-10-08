package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.classes.chat.messagelist.a;
import com.xiaoenai.app.net.y;
import org.json.JSONObject;

class f
  extends y
{
  f(e parame) {}
  
  public void a()
  {
    super.a();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (paramJSONObject.getBoolean("success"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("data");
      this.a.a.b(paramJSONObject.getLong("id"));
      this.a.a.a(paramJSONObject.getInt("ts"));
      this.a.a.b(Integer.valueOf(0));
      this.a.a.k();
      a.l();
      return;
    }
    this.a.a.b(Integer.valueOf(-2));
    this.a.a.k();
    a.l();
  }
  
  public void b()
  {
    super.b();
    d.a(this.a.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */