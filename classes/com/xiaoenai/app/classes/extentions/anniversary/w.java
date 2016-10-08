package com.xiaoenai.app.classes.extentions.anniversary;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.utils.ab;

class w
  implements View.OnClickListener
{
  w(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void onClick(View paramView)
  {
    ab.b((Activity)paramView.getContext());
    paramView = new e(this.a);
    paramView.a(2131099925, 2, new x(this, paramView));
    paramView.show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */