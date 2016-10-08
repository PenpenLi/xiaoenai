package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.ColorPickerActivity;

class n
  implements View.OnClickListener
{
  n(SettingAppConfigActivity paramSettingAppConfigActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, ColorPickerActivity.class);
    paramView.putExtra("mode", "chat");
    this.a.startActivityForResult(paramView, 126);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */