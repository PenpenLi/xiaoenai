package com.inmobi.commons.core.utilities.uid;

import android.content.Context;
import com.inmobi.commons.core.b.c;

class b
{
  private c a;
  
  public b()
  {
    this.a = c.b("uid_store");
  }
  
  public b(Context paramContext)
  {
    this.a = c.a(paramContext, "uid_store");
  }
  
  public String a()
  {
    return this.a.b("adv_id", null);
  }
  
  public void a(long paramLong)
  {
    this.a.a("imid_timestamp", paramLong);
  }
  
  public void a(String paramString)
  {
    this.a.a("adv_id", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a("limit_ad_tracking", paramBoolean);
  }
  
  public void b(String paramString)
  {
    this.a.a("app_id", paramString);
  }
  
  public boolean b()
  {
    return this.a.b("limit_ad_tracking", true);
  }
  
  public String c()
  {
    return this.a.b("app_id", null);
  }
  
  public void c(String paramString)
  {
    this.a.a("im_id", paramString);
  }
  
  public String d()
  {
    return this.a.b("im_id", null);
  }
  
  public void d(String paramString)
  {
    this.a.a("appended_id", paramString);
  }
  
  public long e()
  {
    return this.a.b("imid_timestamp", 0L);
  }
  
  public String f()
  {
    return this.a.b("appended_id", null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\uid\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */