package com.xiaoenai.app.classes.auth;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class f
  implements TextView.OnEditorActionListener
{
  f(SimpleLoginView paramSimpleLoginView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramTextView == SimpleLoginView.a(this.a))
    {
      SimpleLoginView.b(this.a).requestFocus();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */