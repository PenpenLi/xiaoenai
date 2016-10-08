package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.b.c;

public class i
{
  private c a = c.b("mraid_js_store");
  
  public static String a()
  {
    return c.a("mraid_js_store");
  }
  
  public void a(String paramString)
  {
    this.a.a("mraid_js_string", paramString);
    this.a.a("last_updated_ts", System.currentTimeMillis() / 1000L);
  }
  
  public String b()
  {
    return this.a.b("mraid_js_string", null);
  }
  
  public long c()
  {
    return this.a.b("last_updated_ts", 0L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */