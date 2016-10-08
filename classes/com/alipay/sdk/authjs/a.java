package com.alipay.sdk.authjs;

import org.json.JSONObject;

public final class a
{
  public static final String a = "CallInfo";
  public static final String b = "call";
  public static final String c = "callback";
  public static final String d = "bundleName";
  public static final String e = "clientId";
  public static final String f = "param";
  public static final String g = "func";
  public static final String h = "msgType";
  public String i;
  public String j;
  public String k;
  public String l;
  public JSONObject m;
  private boolean n = false;
  
  public a(String paramString)
  {
    this.l = paramString;
  }
  
  private static String a(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      return "none";
    case 1: 
      return "function not found";
    case 2: 
      return "invalid parameter";
    }
    return "runtime error";
  }
  
  private void a(String paramString)
  {
    this.i = paramString;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.m = paramJSONObject;
  }
  
  private void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  private boolean a()
  {
    return this.n;
  }
  
  private String b()
  {
    return this.i;
  }
  
  private void b(String paramString)
  {
    this.j = paramString;
  }
  
  private String c()
  {
    return this.j;
  }
  
  private void c(String paramString)
  {
    this.k = paramString;
  }
  
  private String d()
  {
    return this.k;
  }
  
  private void d(String paramString)
  {
    this.l = paramString;
  }
  
  private String e()
  {
    return this.l;
  }
  
  private JSONObject f()
  {
    return this.m;
  }
  
  private String g()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("clientId", this.i);
    localJSONObject.put("func", this.k);
    localJSONObject.put("param", this.m);
    localJSONObject.put("msgType", this.l);
    return localJSONObject.toString();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\authjs\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */