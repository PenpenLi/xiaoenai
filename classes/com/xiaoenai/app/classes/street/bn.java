package com.xiaoenai.app.classes.street;

import android.view.View;
import android.widget.EditText;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class bn
  implements k.a
{
  bn(StreetFeedbackActivity paramStreetFeedbackActivity, String paramString) {}
  
  public void a(k paramk, View paramView)
  {
    if (this.a != null) {
      StreetFeedbackActivity.b(this.b).setText(this.a);
    }
    paramk.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */