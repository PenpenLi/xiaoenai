package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.view.View;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class bh
  implements k.a
{
  bh(SettingPersonalActivity paramSettingPersonalActivity, int paramInt) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    if (this.a == 1)
    {
      paramk = new Intent(this.b, SettingNameOrMailActivity.class);
      paramk.putExtra("Type", 1);
      this.b.startActivity(paramk);
      this.b.overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */