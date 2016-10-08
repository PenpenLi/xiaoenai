package com.xiaoenai.app.classes.chat.input;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class i
  implements TextView.OnEditorActionListener
{
  i(InputFragment paramInputFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = InputFragment.a(this.a).getText().toString().trim();
    if (paramTextView.length() > 0) {
      InputFragment.a(this.a, paramTextView);
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */