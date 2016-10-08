package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class a
  implements View.OnClickListener
{
  a(AddStatusActivity paramAddStatusActivity) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(AddStatusActivity.a(this.a).getWindowToken(), 0);
    this.a.setResult(0);
    this.a.finish();
    this.a.overridePendingTransition(2130968606, 2130968607);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */