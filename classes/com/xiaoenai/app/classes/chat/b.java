package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class b
  implements View.OnClickListener
{
  b(AddStatusActivity paramAddStatusActivity) {}
  
  public void onClick(View paramView)
  {
    if (AddStatusActivity.a(this.a).getText().toString().trim().length() == 0) {
      return;
    }
    AddStatusActivity.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */