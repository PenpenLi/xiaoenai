package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.street.widget.StreetPayListItemView;
import com.xiaoenai.app.model.User;

class do
  implements View.OnClickListener
{
  do(StreetProductOrderActivity paramStreetProductOrderActivity) {}
  
  public void onClick(View paramView)
  {
    if (User.isSingle())
    {
      StreetProductOrderActivity.a(this.a, false);
      return;
    }
    StreetProductOrderActivity.a(this.a, StreetProductOrderActivity.a(this.a).getState());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */