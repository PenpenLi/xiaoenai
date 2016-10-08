package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.net.socket.e;
import com.xiaoenai.app.net.socket.f;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.xiaoenai.app.classes.chat.messagelist.message.a.a
{
  private String b;
  private String c;
  
  public a()
  {
    a("emotion");
  }
  
  public void b(String paramString)
  {
    str = "";
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("type")) {
        this.b = paramString.getString("type");
      }
      if (paramString.has("url")) {
        this.c = paramString.getString("url");
      }
      paramString = paramString.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    super.b(paramString);
  }
  
  public String c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.b != null) {
        localJSONObject.put("type", this.b);
      }
      if (this.c != null) {
        localJSONObject.put("url", this.c);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public void j()
  {
    e locale = new e(new b(this));
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
  
  public String r()
  {
    return this.b;
  }
  
  public String s()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */