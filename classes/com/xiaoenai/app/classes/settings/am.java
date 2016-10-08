package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.view.View;
import com.xiaoenai.app.classes.settings.account.ResetPasswordActivity;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class am
  implements k.a
{
  am(SettingReleaseActivity paramSettingReleaseActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramView = new Intent(this.a, ResetPasswordActivity.class);
    paramView.putExtra("from", "release");
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
    paramk.dismiss();
    this.a.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */