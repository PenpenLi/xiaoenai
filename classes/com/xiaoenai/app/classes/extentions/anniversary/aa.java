package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aa
  implements View.OnClickListener
{
  aa(AnniversaryAddActivity paramAnniversaryAddActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("repeat", AnniversaryAddActivity.j(this.a));
    paramView.setClass(this.a, AnniversaryRepeatActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */