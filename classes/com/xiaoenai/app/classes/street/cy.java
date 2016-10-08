package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.a;

class cy
  implements View.OnClickListener
{
  cy(StreetOrderRemindActivity paramStreetOrderRemindActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetOrderRemindActivity.b(this.a) == 0) {
      StreetOrderRemindActivity.d(this.a);
    }
    while (1 != StreetOrderRemindActivity.b(this.a)) {
      return;
    }
    this.a.overridePendingTransition(2130968606, 2130968607);
    this.a.finish();
    a.a().a(StreetProductDetailActivity.class);
    a.a().a(StreetProductOrderActivity.class);
    a.a().a(StreetOrderActivity.class);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */