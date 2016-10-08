package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.dialog.q;
import com.xiaoenai.app.classes.street.d.e;

class be
  implements View.OnClickListener
{
  be(StreetCustomerServiceActivity paramStreetCustomerServiceActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetCustomerServiceActivity.g(this.a) == -1) {
      StreetCustomerServiceActivity.b(this.a, StreetCustomerServiceActivity.h(this.a).a());
    }
    StreetCustomerServiceActivity.b(this.a).n.setText(StreetCustomerServiceActivity.i(this.a)[StreetCustomerServiceActivity.g(this.a)]);
    StreetCustomerServiceActivity.h(this.a).dismiss();
    StreetCustomerServiceActivity.e(this.a).c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */