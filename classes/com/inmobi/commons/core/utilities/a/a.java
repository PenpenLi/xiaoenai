package com.inmobi.commons.core.utilities.a;

import com.inmobi.commons.core.b.c;

public class a
{
  private c a = c.b("aes_key_store");
  
  public static String a()
  {
    return c.a("aes_key_store");
  }
  
  public void a(String paramString)
  {
    this.a.a("aes_public_key", paramString);
    this.a.a("last_generated_ts", System.currentTimeMillis() / 1000L);
  }
  
  public String b()
  {
    return this.a.b("aes_public_key", null);
  }
  
  public long c()
  {
    return this.a.b("last_generated_ts", 0L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */