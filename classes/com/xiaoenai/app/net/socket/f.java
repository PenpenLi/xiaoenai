package com.xiaoenai.app.net.socket;

import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.net.y;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONException;
import org.json.JSONObject;
import org.mzd.socket.MessageCallback;

public class f
  implements c
{
  protected transient y a = null;
  protected MessageCallback b = null;
  private JSONObject c = null;
  private String d = null;
  private String e = null;
  
  public f()
  {
    this.a = new y();
    this.b = new MessageCallback(this);
  }
  
  public f(y paramy)
  {
    this.a = paramy;
    this.b = new MessageCallback(this);
  }
  
  public void a()
  {
    a.c(" SocketPackage send {} {}", new Object[] { d(), this.e });
    a.b(" size = {} {}", new Object[] { Integer.valueOf(d().length()), this.e });
    if (this.a != null)
    {
      this.a.c();
      if ("confirmMessageReceive".equals(this.e)) {
        this.a.b(new JSONObject());
      }
    }
  }
  
  public void a(y paramy)
  {
    this.a = paramy;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.c = paramJSONObject;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    a.c(" onMessageCallback {} {}", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (!paramBoolean)
    {
      c().d();
      a.a(true, "recv fault! send msg = {} {}", new Object[] { d(), this.e });
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if ((localJSONObject.has("auth")) && (!localJSONObject.getBoolean("auth")))
      {
        Intent localIntent = new Intent(SocketManager.c);
        SocketManager.a().d().sendBroadcast(localIntent, SocketManager.a().d().getString(2131101650));
      }
      c().b(localJSONObject);
      a.c(true, "recv send = {} recv = {}", new Object[] { d(), paramString });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b()
  {
    a.c(" SocketPackage sendOnQueue {} {}", new Object[] { d(), this.e });
    a.b(" size = {} {}", new Object[] { Integer.valueOf(d().length()), this.e });
    if (this.a != null)
    {
      this.a.c();
      if ("confirmMessageReceive".equals(this.e)) {
        this.a.b(new JSONObject());
      }
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public y c()
  {
    return this.a;
  }
  
  public void c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.d = paramString.getString("controller");
      this.e = paramString.getString("action");
      this.c = paramString.getJSONObject("data");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String d()
  {
    if (("message".equals(this.d)) && (("sendMessage".equals(this.e)) || ("readMessage".equals(this.e)) || ("updateMessage".equals(this.e)))) {
      return this.c.toString().replaceAll("\n", "");
    }
    String str2 = "";
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      localJSONObject.put("access_token", AppModel.getInstance().getToken());
      str1 = str2;
      if (this.d != null)
      {
        str1 = str2;
        localJSONObject.put("controller", this.d);
      }
      str1 = str2;
      if (this.e != null)
      {
        str1 = str2;
        localJSONObject.put("action", this.e);
      }
      str1 = str2;
      if (this.c != null)
      {
        str1 = str2;
        localJSONObject.put("data", this.c);
      }
      str1 = str2;
      str2 = localJSONObject.toString();
      str1 = str2;
      str2 = str2.replaceAll("\n", "");
      return str2;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return str1;
  }
  
  public String e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("controller", this.d);
      localJSONObject.put("action", this.e);
      localJSONObject.put("data", this.c);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\socket\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */