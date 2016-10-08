package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.classes.a.c.a;
import com.xiaoenai.app.classes.common.a;
import org.json.JSONException;
import org.json.JSONObject;

class e
  implements c.a
{
  e(d paramd) {}
  
  public void a() {}
  
  public void a(double paramDouble1, double paramDouble2, float paramFloat)
  {
    this.a.a(paramDouble1);
    this.a.b(paramDouble2);
    this.a.a(paramFloat);
    com.xiaoenai.app.net.socket.e locale = new com.xiaoenai.app.net.socket.e(new f(this));
    locale.b("sendMessage");
    locale.a("message");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("types", this.a.b());
      localJSONObject.put("content", this.a.c());
      locale.a(localJSONObject);
      locale.b();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void b()
  {
    d.a(this.a);
    com.xiaoenai.app.classes.chat.messagelist.message.b.d.a(a.a().c());
  }
  
  public void c()
  {
    d.a(this.a);
    com.xiaoenai.app.classes.chat.messagelist.message.b.d.b(a.a().c());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */