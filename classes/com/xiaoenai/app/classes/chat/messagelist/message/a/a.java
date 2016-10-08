package com.xiaoenai.app.classes.chat.messagelist.message.a;

import com.xiaoenai.app.d.q;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.socket.d;
import com.xiaoenai.app.net.socket.f;
import com.xiaoenai.app.utils.ak;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
{
  public boolean a = false;
  private long b = -1L;
  private long c = -1L;
  private Integer d = Integer.valueOf(-1);
  private String e = null;
  private String f = null;
  private Integer g = Integer.valueOf(0);
  private long h;
  private boolean i = false;
  private int j = (int)ak.b();
  private boolean k = false;
  
  public static void a(long paramLong1, int paramInt, long paramLong2)
  {
    new q().a(paramLong1, Integer.valueOf(paramInt), paramLong2);
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(Integer paramInteger)
  {
    this.d = paramInteger;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      this.c = paramJSONObject.getInt("id");
      this.d = Integer.valueOf(paramJSONObject.getInt("sender_id"));
      b(paramJSONObject.getString("content"));
      this.g = Integer.valueOf(paramJSONObject.getInt("status"));
      this.j = paramJSONObject.getInt("ts");
      this.e = paramJSONObject.getString("types");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1)
    {
      this.d = Integer.valueOf(AppModel.getInstance().getUserId());
      return;
    }
    this.d = Integer.valueOf(User.getInstance().getLoverId());
  }
  
  public void b(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void b(Integer paramInteger)
  {
    if (this.g.intValue() != 1) {
      this.g = paramInteger;
    }
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public void c(long paramLong)
  {
    this.h = paramLong;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public Integer e()
  {
    return this.d;
  }
  
  public Integer f()
  {
    if (this.g.intValue() >= 1) {
      this.g = Integer.valueOf(1);
    }
    return this.g;
  }
  
  public int g()
  {
    if (this.d.intValue() == AppModel.getInstance().getUserId()) {
      return 1;
    }
    return 2;
  }
  
  public long h()
  {
    return this.c;
  }
  
  public long i()
  {
    return this.h;
  }
  
  public abstract void j();
  
  public void k()
  {
    new q().a(this);
  }
  
  public void l()
  {
    com.xiaoenai.app.utils.f.a.c("updateReadStatusToServer type = {} status = {} content = {}", new Object[] { Integer.valueOf(g()), f(), c() });
    if ((g() == 2) && (f().intValue() == 0)) {
      com.xiaoenai.app.utils.f.a.c("updateReadStatusToServer 发送到服务器", new Object[0]);
    }
    try
    {
      d locald = new d(new b(this));
      locald.a("message");
      locald.b("readMessage");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", h());
      locald.a(localJSONObject);
      locald.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      com.xiaoenai.app.utils.f.a.a(true, "updateReadStatusToServer type = {} status = {}", new Object[] { Integer.valueOf(g()), f() });
    }
  }
  
  public void m()
  {
    new q().a(a());
    com.xiaoenai.app.classes.chat.messagelist.a.a().b(this);
    com.xiaoenai.app.classes.chat.messagelist.a.l();
  }
  
  public void n()
  {
    new q().a(a());
  }
  
  public JSONObject o()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.c);
      localJSONObject.put("sender_id", this.d);
      localJSONObject.put("types", this.e);
      localJSONObject.put("content", c());
      localJSONObject.put("status", this.g);
      localJSONObject.put("ts", this.j);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean p()
  {
    return this.i;
  }
  
  public boolean q()
  {
    return this.k;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */