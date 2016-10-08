package com.xiaoenai.app.classes.settings.account;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class g
  implements TextView.OnEditorActionListener
{
  g(ResetPasswordActivity paramResetPasswordActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6) {
      ResetPasswordActivity.a(this.a);
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */