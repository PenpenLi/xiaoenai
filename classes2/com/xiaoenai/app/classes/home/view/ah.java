package com.xiaoenai.app.classes.home.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.utils.as;

class ah
  implements View.OnClickListener
{
  ah(LoverSearchView paramLoverSearchView) {}
  
  public void onClick(View paramView)
  {
    if (as.b(this.a.getContext(), User.getInstance().getUserName())) {
      as.b(2131100560);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */