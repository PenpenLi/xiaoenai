package com.xiaoenai.app.classes.common;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.h;

class m
  implements View.OnClickListener
{
  m(DebugActivity paramDebugActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.mDevEdt.getText().toString();
    if (paramView != null)
    {
      UserConfig.setString("dev_env_ip", paramView);
      h.a(this.a, 2131100898, 1500L);
      this.a.mDevEdt.getText().clear();
      DebugActivity.e(this.a);
      return;
    }
    h.c(this.a, "ip == null", 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */