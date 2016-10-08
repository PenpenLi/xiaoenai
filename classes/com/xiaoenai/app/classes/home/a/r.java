package com.xiaoenai.app.classes.home.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.home.a;
import com.xiaoenai.app.classes.home.a.b;
import com.xiaoenai.app.model.UserConfig;

class r
  implements View.OnClickListener
{
  r(o paramo) {}
  
  public void onClick(View paramView)
  {
    paramView = a.a().a("noti");
    paramView.a(false);
    o.a(this.a).setVisibility(8);
    UserConfig.setLong("ads_noti", paramView.e);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */