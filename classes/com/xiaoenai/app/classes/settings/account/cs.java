package com.xiaoenai.app.classes.settings.account;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class cs
  implements k.a
{
  cs(SettingPhoneInputActivity paramSettingPhoneInputActivity, String paramString) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    this.b.mEtvCode.getText().clear();
    SettingPhoneInputActivity.b(this.b, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */