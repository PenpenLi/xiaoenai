package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class bp
  implements View.OnClickListener
{
  bp(StreetFeedbackActivity paramStreetFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    StreetFeedbackActivity.b(this.a).setCursorVisible(true);
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(StreetFeedbackActivity.b(this.a), 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */