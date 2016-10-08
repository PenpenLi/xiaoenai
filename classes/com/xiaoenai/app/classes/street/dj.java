package com.xiaoenai.app.classes.street;

import android.view.View;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class dj
  implements k.a
{
  dj(StreetProductOrderActivity paramStreetProductOrderActivity, boolean paramBoolean) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    if (this.a)
    {
      StreetProductOrderActivity.a(this.b, false, false, null);
      return;
    }
    StreetProductOrderActivity.a(this.b, false, false, new long[1]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */