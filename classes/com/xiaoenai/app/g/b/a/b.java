package com.xiaoenai.app.g.b.a;

import android.app.Activity;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.data.e.o;
import com.xiaoenai.app.domain.e.e;
import com.xiaoenai.app.net.c.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.v;

public class b
  implements com.xiaoenai.app.common.application.a.a.a
{
  private final BaseApplication a;
  
  public b(BaseApplication paramBaseApplication)
  {
    this.a = paramBaseApplication;
  }
  
  public void a() {}
  
  public void a(com.xiaoenai.app.domain.d.a.a parama)
  {
    Activity localActivity = this.a.z().c().a();
    if ((localActivity != null) && (!(localActivity instanceof BaseActivity)) && (!localActivity.isFinishing()))
    {
      if (parama.e() != 0) {
        break label65;
      }
      h.c(localActivity, 2131100887, 1000L).show();
    }
    for (;;)
    {
      v.b(this.a, parama.b());
      return;
      label65:
      g localg = new g();
      if (parama.c() == 1) {
        localg.a(localActivity, parama.d(), parama.a());
      } else if (parama.c() == 2) {
        localg.b(localActivity, parama.d(), parama.a());
      } else if (parama.c() == 3) {
        localg.c(localActivity, parama.d(), parama.a());
      }
    }
  }
  
  public void a(String paramString)
  {
    Activity localActivity = this.a.z().c().a();
    if ((localActivity != null) && (!(localActivity instanceof BaseActivity)) && (!localActivity.isFinishing())) {
      new g().a(localActivity, paramString);
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.a.z().o().a("uploaddata", "");
  }
  
  public void e()
  {
    this.a.z().o().a("uploaddata", "");
    this.a.z().k().b();
  }
  
  public void f()
  {
    this.a.z().m().b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\g\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */