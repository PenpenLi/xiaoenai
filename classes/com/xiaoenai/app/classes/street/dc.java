package com.xiaoenai.app.classes.street;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.h;

class dc
  implements View.OnClickListener
{
  dc(StreetOrderReviewsActivity paramStreetOrderReviewsActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = StreetOrderReviewsActivity.a(this.a);
    if ((paramView == null) || (paramView.length() == 0))
    {
      StreetOrderReviewsActivity.b(this.a);
      return;
    }
    h.b(this.a, paramView, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */