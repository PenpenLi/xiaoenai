package com.inmobi.commons.core.configs;

import org.json.JSONObject;

public class f
  extends a
{
  private String a = "010001";
  private String b = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";
  private String c = "rsa";
  private String d = "1";
  
  public String a()
  {
    return "pk";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a = paramJSONObject.getString("e");
    this.b = paramJSONObject.getString("m");
    this.c = paramJSONObject.getString("alg");
    this.d = paramJSONObject.getString("ver");
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = super.b();
    localJSONObject.put("e", this.a);
    localJSONObject.put("m", this.b);
    localJSONObject.put("alg", this.c);
    localJSONObject.put("ver", this.d);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return (this.a.trim().length() != 0) && (this.b.trim().length() != 0) && (this.c.trim().length() != 0) && (this.d.trim().length() != 0);
  }
  
  public a d()
  {
    return new f();
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */