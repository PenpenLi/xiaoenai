package com.xiaoenai.app.classes.common;

import android.view.View;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class s
  implements k.a
{
  s(q paramq) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    q.a(this.a);
    UserConfig.remove("is_getting_invite");
    this.a.a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */