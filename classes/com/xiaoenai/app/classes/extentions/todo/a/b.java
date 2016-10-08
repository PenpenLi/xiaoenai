package com.xiaoenai.app.classes.extentions.todo.a;

import org.json.JSONObject;

public class b
  extends a
{
  private int b;
  private String c;
  private int d;
  private long e;
  private boolean f = true;
  private Boolean g = Boolean.valueOf(false);
  private boolean h = false;
  
  public static b a(JSONObject paramJSONObject)
  {
    b localb = new b();
    localb.c(paramJSONObject.getInt("id"));
    localb.a(paramJSONObject.getString("content"));
    if (paramJSONObject.has("sender_id")) {
      localb.b(paramJSONObject.getInt("sender_id"));
    }
    if (paramJSONObject.has("updated_ts")) {
      localb.a(paramJSONObject.getLong("updated_ts"));
    }
    if ((paramJSONObject.has("finished")) && (!paramJSONObject.isNull("finished"))) {
      localb.a(Boolean.valueOf(paramJSONObject.getString("finished").equals("1")));
    }
    return localb;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(b paramb)
  {
    a(paramb.h());
    a(paramb.c());
    a(paramb.f());
    b(paramb.d());
    a(paramb.b());
  }
  
  public void a(Boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public long b()
  {
    return this.e;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public boolean g()
  {
    return this.f;
  }
  
  public Boolean h()
  {
    return this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */