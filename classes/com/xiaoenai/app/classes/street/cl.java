package com.xiaoenai.app.classes.street;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

class cl
  implements View.OnClickListener
{
  cl(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetOrderActivity.g(this.a).getCurrentItem() != 4) {
      StreetOrderActivity.g(this.a).setCurrentItem(4, true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */