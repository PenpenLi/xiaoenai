package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.xiaoenai.app.classes.home.a;
import com.xiaoenai.app.classes.home.a.b;
import com.xiaoenai.app.model.UserConfig;

class x
  implements View.OnClickListener
{
  x(HomeDiscoverHeadLayoutView paramHomeDiscoverHeadLayoutView) {}
  
  public void onClick(View paramView)
  {
    paramView = a.a().a("discover");
    paramView.a(false);
    HomeDiscoverHeadLayoutView.a(this.a).setVisibility(8);
    UserConfig.setLong("ads_discover", paramView.e);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */