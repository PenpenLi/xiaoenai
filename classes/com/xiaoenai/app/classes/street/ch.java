package com.xiaoenai.app.classes.street;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

class ch
  implements View.OnClickListener
{
  ch(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void onClick(View paramView)
  {
    if (StreetOrderActivity.g(this.a).getCurrentItem() != 0) {
      StreetOrderActivity.g(this.a).setCurrentItem(0, true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */