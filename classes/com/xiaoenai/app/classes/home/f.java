package com.xiaoenai.app.classes.home;

import android.view.View;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.a;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.service.c;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import com.xiaoenai.app.utils.e.d;
import com.xiaoenai.app.utils.w;

class f
  implements k.a
{
  f(HomeActivity paramHomeActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    Xiaoenai.F = true;
    w.b(paramk.getContext());
    c.b(this.a);
    AppModel.release();
    User.release();
    HomeActivity.a(this.a, true);
    com.f.a.b.b(this.a, "UserExitApp");
    Xiaoenai.j().c();
    Xiaoenai.j().h();
    Xiaoenai.j().f();
    Xiaoenai.j().g();
    Xiaoenai.j().i();
    d.a();
    com.xiaoenai.app.utils.e.b.a();
    a.a().a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */