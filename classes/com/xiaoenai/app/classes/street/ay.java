package com.xiaoenai.app.classes.street;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaoenai.app.c.a;
import com.xiaoenai.app.classes.street.d.e;
import com.xiaoenai.app.ui.a.h;

class ay
  implements View.OnClickListener
{
  ay(StreetCustomerServiceActivity paramStreetCustomerServiceActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = StreetCustomerServiceActivity.b(this.a).n.getText().toString();
    if ((StreetCustomerServiceActivity.c(this.a) != a.a) && ((paramView == null) || (paramView.length() <= 0) || (paramView == this.a.getResources().getString(2131101476))))
    {
      h.c(this.a, 2131101477, 1500L);
      return;
    }
    StreetCustomerServiceActivity.e(this.a).a(StreetCustomerServiceActivity.d(this.a), StreetCustomerServiceActivity.b(this.a).n.getText().toString(), StreetCustomerServiceActivity.b(this.a).a.getText().toString(), StreetCustomerServiceActivity.e(this.a).d());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */