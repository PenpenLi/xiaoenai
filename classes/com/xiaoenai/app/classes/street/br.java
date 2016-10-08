package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class br
  implements View.OnClickListener
{
  br(StreetFeedbackActivity paramStreetFeedbackActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.h())
    {
      paramView = StreetFeedbackActivity.b(this.a).getText().toString();
      this.a.b(paramView);
      StreetFeedbackActivity.b(this.a).setText("");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */