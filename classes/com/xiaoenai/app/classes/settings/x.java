package com.xiaoenai.app.classes.settings;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class x
  implements View.OnClickListener
{
  x(SettingFeedbackActivity paramSettingFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    SettingFeedbackActivity.b(this.a).setCursorVisible(true);
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(SettingFeedbackActivity.b(this.a), 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */