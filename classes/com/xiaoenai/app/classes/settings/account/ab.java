package com.xiaoenai.app.classes.settings.account;

import android.os.Handler;
import android.widget.Button;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.TitleBarView;

class ab
  implements Runnable
{
  ab(SettingNameOrMailActivity paramSettingNameOrMailActivity) {}
  
  public void run()
  {
    long l = (System.currentTimeMillis() - SettingNameOrMailActivity.a(this.a)) / 1000L;
    if (l < 60L)
    {
      this.a.mBtnSave.setText(this.a.getString(2131101105) + "(" + (60L - l) + ")");
      this.a.a.postDelayed(this, 1000L);
      return;
    }
    w.b(this.a.mBtnSave);
    this.a.mBtnSave.setText(2131101105);
    SettingNameOrMailActivity.b(this.a).setRightButtonVisible(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */