package com.xiaoenai.app.classes.chat.input;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class a
  implements View.OnClickListener
{
  a(InputFragment paramInputFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = InputFragment.a(this.a).getText().toString().trim();
    if (paramView.length() > 0) {
      InputFragment.a(this.a, paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */