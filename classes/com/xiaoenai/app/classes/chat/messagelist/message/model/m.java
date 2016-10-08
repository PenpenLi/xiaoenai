package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.net.socket.e;
import com.xiaoenai.app.net.socket.f;
import org.json.JSONException;
import org.json.JSONObject;

public class m
  extends a
{
  public m()
  {
    a("text");
  }
  
  public void j()
  {
    e locale = new e(new n(this));
    locale.b("sendMessage");
    locale.a("message");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("types", b());
      localJSONObject.put("content", c());
      locale.a(localJSONObject);
      locale.b();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */