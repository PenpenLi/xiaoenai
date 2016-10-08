package com.xiaoenai.app.classes.chat.messagelist.message.model;

import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.net.c;
import com.xiaoenai.app.net.socket.e;
import com.xiaoenai.app.net.socket.f;
import com.xiaoenai.app.utils.a.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class o
  extends a
{
  private String b = null;
  private Integer c = null;
  private String d = null;
  private int e = -1;
  private int f = 0;
  private long g = 0L;
  private int h = 0;
  private String i = null;
  
  public o()
  {
    a("voice");
  }
  
  private void B()
  {
    if ((this.i == null) && (this.b != null))
    {
      if (!this.b.startsWith("http://")) {
        break label60;
      }
      String str = this.b.substring(7);
      int j = str.indexOf("/");
      if (j != -1) {
        this.i = str.substring(j + 1);
      }
    }
    return;
    label60:
    this.i = this.b;
  }
  
  private void C()
  {
    e locale = new e(new p(this));
    locale.b("sendMessage");
    locale.a("message");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("types", b());
      localJSONObject.put("content", x());
      locale.a(localJSONObject);
      locale.b();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void D()
  {
    new c(new q(this, Xiaoenai.j())).b(u());
  }
  
  private void a(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split("/");
    if (arrayOfString.length != 0) {
      paramString2 = arrayOfString[(arrayOfString.length - 1)];
    }
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString1.getParent() + File.separator + paramString2);
    if (paramString1.exists())
    {
      paramString1.renameTo(paramString2);
      c(paramString2.getAbsolutePath());
    }
  }
  
  public int A()
  {
    return this.h;
  }
  
  public void b(String paramString)
  {
    str = "";
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("length")) {
        this.c = Integer.valueOf(paramString.getInt("length"));
      }
      if (paramString.has("url")) {
        this.b = paramString.getString("url");
      }
      if (paramString.has("voicePath")) {
        this.d = paramString.getString("voicePath");
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
      if (this.c != null) {
        localJSONObject.put("length", this.c);
      }
      if (this.b != null) {
        localJSONObject.put("url", this.b);
      }
      if (this.d != null) {
        localJSONObject.put("voicePath", this.d);
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
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void c(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
    B();
  }
  
  public void e(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void e(String paramString)
  {
    this.i = paramString;
  }
  
  public void j()
  {
    b(Integer.valueOf(-1));
    if (x() != null)
    {
      C();
      return;
    }
    D();
  }
  
  public int r()
  {
    if (-1 == this.e)
    {
      if ((u() == null) || (!new File(u()).exists())) {
        break label42;
      }
      c(2);
    }
    for (;;)
    {
      return this.e;
      label42:
      if (s())
      {
        c(d.c(t()).getAbsolutePath());
        c(2);
      }
      else
      {
        c(0);
      }
    }
  }
  
  public boolean s()
  {
    return d.d(t());
  }
  
  public String t()
  {
    return "message_voice_" + String.valueOf(h());
  }
  
  public String u()
  {
    return this.d;
  }
  
  public String v()
  {
    return this.b;
  }
  
  public Integer w()
  {
    return this.c;
  }
  
  public String x()
  {
    if ((this.i == null) || (this.c == null)) {
      return null;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("url", this.i);
      ((JSONObject)localObject).put("length", this.c);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public int y()
  {
    return this.f;
  }
  
  public long z()
  {
    return this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\model\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */