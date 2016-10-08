package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class an
  implements View.OnClickListener
{
  an(SettingTheOtherActivity paramSettingTheOtherActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.a, SettingReleaseActivity.class);
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */