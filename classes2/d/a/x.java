package d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class x
  implements o
{
  public int a;
  public int b;
  public long c;
  private final int d = 3600000;
  private int e;
  private long f = 0L;
  private long g = 0L;
  private Context h;
  
  public x(Context paramContext)
  {
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    paramContext = t.a(paramContext);
    this.a = paramContext.getInt("successful_request", 0);
    this.b = paramContext.getInt("failed_requests ", 0);
    this.e = paramContext.getInt("last_request_spent_ms", 0);
    this.c = paramContext.getLong("last_request_time", 0L);
    this.f = paramContext.getLong("last_req", 0L);
  }
  
  public static void a(Context paramContext, z paramz)
  {
    paramContext = t.a(paramContext);
    paramz.a.L = paramContext.getInt("failed_requests ", 0);
    paramz.a.K = paramContext.getInt("successful_request", 0);
    paramz.a.M = paramContext.getInt("last_request_spent_ms", 0);
  }
  
  public void a()
  {
    h();
  }
  
  public void b()
  {
    i();
  }
  
  public void c()
  {
    f();
  }
  
  public void d()
  {
    g();
  }
  
  public boolean e()
  {
    int i;
    if (this.c == 0L)
    {
      i = 1;
      if (com.f.a.o.a(this.h).g()) {
        break label41;
      }
    }
    label41:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label46;
      }
      return true;
      i = 0;
      break;
    }
    label46:
    return false;
  }
  
  public void f()
  {
    this.a += 1;
    this.c = this.f;
  }
  
  public void g()
  {
    this.b += 1;
  }
  
  public void h()
  {
    this.f = System.currentTimeMillis();
  }
  
  public void i()
  {
    this.e = ((int)(System.currentTimeMillis() - this.f));
  }
  
  public void j()
  {
    t.a(this.h).edit().putInt("successful_request", this.a).putInt("failed_requests ", this.b).putInt("last_request_spent_ms", this.e).putLong("last_request_time", this.c).putLong("last_req", this.f).commit();
  }
  
  public void k()
  {
    t.a(this.h).edit().putLong("first_activate_time", System.currentTimeMillis()).commit();
  }
  
  public boolean l()
  {
    if (this.g == 0L) {
      this.g = t.a(this.h).getLong("first_activate_time", 0L);
    }
    return this.g == 0L;
  }
  
  public long m()
  {
    if (l()) {
      return System.currentTimeMillis();
    }
    return this.g;
  }
  
  public long n()
  {
    return this.f;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */