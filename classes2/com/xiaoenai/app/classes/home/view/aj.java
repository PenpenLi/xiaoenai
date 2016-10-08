package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.UserConfig;

class aj
  implements View.OnClickListener
{
  aj(LoverSearchView paramLoverSearchView) {}
  
  public void onClick(View paramView)
  {
    UserConfig.remove("home_search_lover_avatar");
    UserConfig.remove("home_search_lover_email");
    LoverSearchView.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */