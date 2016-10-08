package com.xiaoenai.app.classes.lock;

import android.view.View;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import com.xiaoenai.app.utils.n;

class d
  implements k.a
{
  d(LockScreenActivity paramLockScreenActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    UserConfig.remove("lock_password_v2");
    n.a().a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\lock\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */