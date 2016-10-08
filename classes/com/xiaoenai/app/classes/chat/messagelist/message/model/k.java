package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.chat.messagelist.message.b.o;
import com.xiaoenai.app.net.socket.e;
import com.xiaoenai.app.net.socket.f;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends a
{
  protected String b = null;
  protected String c = null;
  
  public k()
  {
    a("status");
  }
  
  public static k e(String paramString)
  {
    k localk = new k();
    localk.c(o.b(9) + "," + paramString);
    localk.d("009");
    localk.b(1);
    localk.b(Integer.valueOf(-1));
    return localk;
  }
  
  public static k x()
  {
    k localk = new k();
    localk.c(o.b(8));
    localk.d("008");
    localk.b(1);
    localk.b(Integer.valueOf(-1));
    return localk;
  }
  
  public static k y()
  {
    k localk = new k();
    localk.c(o.b(31));
    localk.d("031");
    localk.b(1);
    localk.b(Integer.valueOf(-1));
    return localk;
  }
  
  public void b(String paramString)
  {
    super.b(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("type")) {
        this.c = paramString.getString("type");
      }
      if (paramString.has("content")) {
        this.b = paramString.getString("content");
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String c()
  {
    if (super.c() == null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        if (this.c != null) {
          localJSONObject.put("type", this.c);
        }
        if (this.b != null) {
          localJSONObject.put("content", this.b);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      super.b(localJSONObject.toString());
      return localJSONObject.toString();
    }
    return super.c();
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
    e locale = new e(new l(this));
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
  
  public String w()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */