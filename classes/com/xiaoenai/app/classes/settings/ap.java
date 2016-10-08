package com.xiaoenai.app.classes.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.lock.LockSettingCloseActivity;
import com.xiaoenai.app.classes.lock.LockSettingOpenActivity;
import com.xiaoenai.app.utils.as;

class ap
  implements View.OnClickListener
{
  ap(SettingsActivity paramSettingsActivity) {}
  
  public void onClick(View paramView)
  {
    if (as.e())
    {
      this.a.a(LockSettingCloseActivity.class);
      return;
    }
    this.a.a(LockSettingOpenActivity.class);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */