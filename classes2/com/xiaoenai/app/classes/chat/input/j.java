package com.xiaoenai.app.classes.chat.input;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class j
  implements View.OnFocusChangeListener
{
  j(InputFragment paramInputFragment) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      InputFragment.a(this.a).setCursorVisible(true);
      return;
    }
    InputFragment.a(this.a).setCursorVisible(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */