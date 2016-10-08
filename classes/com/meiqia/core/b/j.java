package com.meiqia.core.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class j
{
  private SharedPreferences a;
  private SharedPreferences.Editor b;
  
  public j(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("Meiqia", 0);
  }
  
  private void a(String paramString, long paramLong)
  {
    this.b = this.a.edit();
    this.b.putLong(paramString, paramLong);
    this.b.apply();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.b = this.a.edit();
    this.b.putBoolean(paramString, paramBoolean);
    this.b.apply();
  }
  
  private long b(String paramString, long paramLong)
  {
    return this.a.getLong(paramString, paramLong);
  }
  
  private void b(String paramString1, String paramString2)
  {
    this.b = this.a.edit();
    this.b.putString(paramString1, paramString2);
    this.b.apply();
  }
  
  private boolean b(String paramString, boolean paramBoolean)
  {
    return this.a.getBoolean(paramString, paramBoolean);
  }
  
  private String c(String paramString1, String paramString2)
  {
    return this.a.getString(paramString1, paramString2);
  }
  
  public String a()
  {
    return this.a.getString("meiqia_appkey", null);
  }
  
  public void a(long paramLong)
  {
    this.b = this.a.edit();
    this.b.putLong("mq_last_msg_update_time", paramLong);
    this.b.apply();
  }
  
  public void a(String paramString)
  {
    this.b = this.a.edit();
    this.b.putString("meiqia_appkey", paramString);
    this.b.apply();
  }
  
  public void a(String paramString1, String paramString2)
  {
    b(d.a(paramString1), paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    a(n("mq_is_schedulered"), paramBoolean);
  }
  
  public long b()
  {
    return this.a.getLong("mq_last_msg_update_time", System.currentTimeMillis());
  }
  
  public void b(long paramLong)
  {
    this.b = this.a.edit();
    this.b.putLong("mq_last_ticket_msg_update_time", paramLong);
    this.b.apply();
  }
  
  public void b(String paramString)
  {
    b(n("mq_track_id"), paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(o("mq_isFirstRefreshMQInquireForm"), paramBoolean);
  }
  
  public long c()
  {
    return this.a.getLong("mq_last_ticket_msg_update_time", System.currentTimeMillis());
  }
  
  public void c(long paramLong)
  {
    this.b = this.a.edit();
    this.b.putLong("mq_last_msg_id", paramLong);
    this.b.apply();
  }
  
  public void c(String paramString)
  {
    b(n("mq_visit_id"), paramString);
  }
  
  public void d(long paramLong)
  {
    a(o("last_refresh_ent_config"), paramLong);
  }
  
  public void d(String paramString)
  {
    b(n("mq_visit_page_id"), paramString);
  }
  
  public boolean d()
  {
    return b(n("mq_is_schedulered"), false);
  }
  
  public String e()
  {
    return c(n("mq_track_id"), null);
  }
  
  public void e(long paramLong)
  {
    a(n("mq_current_ticket_id"), paramLong);
  }
  
  public void e(String paramString)
  {
    b(n("mq_browser_id"), paramString);
  }
  
  public String f()
  {
    return c(n("mq_visit_id"), null);
  }
  
  public void f(long paramLong)
  {
    this.b = this.a.edit();
    this.b.putLong(n("mq_conversation_onstop_time"), paramLong);
    this.b.apply();
  }
  
  public void f(String paramString)
  {
    b(o("mq_queueing_robot_agent_id"), paramString);
  }
  
  public String g()
  {
    return c(n("mq_visit_page_id"), null);
  }
  
  public void g(String paramString)
  {
    b(n("mq_enterprise_id"), paramString);
  }
  
  public String h()
  {
    return c(n("mq_browser_id"), null);
  }
  
  public void h(String paramString)
  {
    b(o("mq_enterprise_config"), paramString);
  }
  
  public String i()
  {
    return c(o("mq_queueing_robot_agent_id"), null);
  }
  
  public void i(String paramString)
  {
    this.b = this.a.edit();
    this.b.putString(n("mq_aes_key"), paramString);
    this.b.apply();
  }
  
  public String j()
  {
    return c(n("mq_enterprise_id"), "1");
  }
  
  public void j(String paramString)
  {
    this.b = this.a.edit();
    this.b.putString(n("mq_dev_infos"), paramString);
    this.b.apply();
  }
  
  public long k()
  {
    return b(o("last_refresh_ent_config"), 0L);
  }
  
  public void k(String paramString)
  {
    this.b = this.a.edit();
    this.b.putString(n("mq_client_infos"), paramString);
    this.b.apply();
  }
  
  public long l()
  {
    return b(n("mq_current_ticket_id"), -1L);
  }
  
  public void l(String paramString)
  {
    b("mq_user_id", paramString);
  }
  
  public String m()
  {
    return c(o("mq_enterprise_config"), "");
  }
  
  public void m(String paramString)
  {
    b(n("mq_client_avatar_url"), paramString);
  }
  
  public String n(String paramString)
  {
    return d.a(paramString + a() + r());
  }
  
  public boolean n()
  {
    return b(o("mq_isFirstRefreshMQInquireForm"), true);
  }
  
  public String o()
  {
    return this.a.getString(n("mq_aes_key"), null);
  }
  
  public String o(String paramString)
  {
    return d.a(paramString + a());
  }
  
  public String p()
  {
    return this.a.getString(n("mq_dev_infos"), null);
  }
  
  public String p(String paramString)
  {
    return c(d.a(paramString), "");
  }
  
  public String q()
  {
    return this.a.getString(n("mq_client_infos"), "");
  }
  
  public String r()
  {
    return c("mq_user_id", "");
  }
  
  public String s()
  {
    return c(n("mq_client_avatar_url"), "");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */