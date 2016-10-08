package com.xiaoenai.app.classes.auth;

import android.view.View;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import com.xiaoenai.app.utils.as;

class x
  implements k.a
{
  x(SimpleLoginView paramSimpleLoginView) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    as.d(SimpleLoginView.g(this.a), SimpleLoginView.g(this.a).getPackageName());
    if (SimpleLoginView.c(this.a) != null) {
      SimpleLoginView.c(this.a).d();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */