package cn.sharesdk.framework.statistics.a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.tools.b.i;

public class e
{
  private static e c;
  private Context a;
  private i b;
  
  private e(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new i(this.a);
    this.b.a("share_sdk", 1);
  }
  
  public static e a(Context paramContext)
  {
    if (c == null) {
      c = new e(paramContext.getApplicationContext());
    }
    return c;
  }
  
  public long a()
  {
    return this.b.c("service_time");
  }
  
  public void a(long paramLong)
  {
    this.b.a("device_time", Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    this.b.a("trans_short_link", paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.a(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, Long paramLong)
  {
    this.b.a(paramString, paramLong);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.b.a(paramString, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.b.a("buffered_snsconf_" + paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a("connect_server", Boolean.valueOf(paramBoolean));
  }
  
  public void b(long paramLong)
  {
    this.b.a("connect_server_time", Long.valueOf(paramLong));
  }
  
  public void b(String paramString)
  {
    this.b.a("upload_device_info", paramString);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.b.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    String str = this.b.a("upload_device_info");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.parseBoolean(str);
  }
  
  public void c(String paramString)
  {
    this.b.a("upload_user_info", paramString);
  }
  
  public boolean c()
  {
    String str = this.b.a("upload_user_info");
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    return Boolean.parseBoolean(str);
  }
  
  public void d(String paramString)
  {
    this.b.a("upload_share_content", paramString);
  }
  
  public boolean d()
  {
    String str = this.b.a("trans_short_link");
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return Boolean.parseBoolean(str);
  }
  
  public int e()
  {
    String str = this.b.a("upload_share_content");
    if ("true".equals(str)) {
      return 1;
    }
    if ("false".equals(str)) {
      return -1;
    }
    return 0;
  }
  
  public String e(String paramString)
  {
    return this.b.a("buffered_snsconf_" + paramString);
  }
  
  public String f()
  {
    return this.b.a("device_data");
  }
  
  public void f(String paramString)
  {
    this.b.a("device_data", paramString);
  }
  
  public String g()
  {
    return this.b.a("device_ext_data");
  }
  
  public void g(String paramString)
  {
    this.b.a("device_ext_data", paramString);
  }
  
  public Long h()
  {
    return Long.valueOf(this.b.c("device_time"));
  }
  
  public String h(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public long i(String paramString)
  {
    return this.b.c(paramString);
  }
  
  public boolean i()
  {
    return this.b.b("connect_server");
  }
  
  public int j(String paramString)
  {
    return this.b.d(paramString);
  }
  
  public Long j()
  {
    return Long.valueOf(this.b.c("connect_server_time"));
  }
  
  public Object k(String paramString)
  {
    return this.b.e(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\cn\sharesdk\framework\statistics\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */