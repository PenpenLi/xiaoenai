package com.inmobi.commons.core.configs;

import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private com.inmobi.commons.core.b.c a = com.inmobi.commons.core.b.c.b("config_store");
  
  public static String a()
  {
    return com.inmobi.commons.core.b.c.a("config_store");
  }
  
  public void a(a parama)
  {
    try
    {
      this.a.a(parama.a() + "_config", parama.b().toString());
      a(parama.a(), System.currentTimeMillis());
      return;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.a.a(paramString + "_config_update_ts", paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.a.b(paramString + "_config", null) != null;
  }
  
  public long b(String paramString)
  {
    return this.a.b(paramString + "_config_update_ts", 0L);
  }
  
  public void b(a parama)
  {
    String str = this.a.b(parama.a() + "_config", null);
    if (str == null) {
      return;
    }
    try
    {
      parama.a(new JSONObject(str));
      return;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */