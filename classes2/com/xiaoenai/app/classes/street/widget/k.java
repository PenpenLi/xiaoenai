package com.xiaoenai.app.classes.street.widget;

import com.xiaoenai.app.widget.LoopViewPager;

class k
  implements Runnable
{
  k(StreetImageViewPager paramStreetImageViewPager) {}
  
  public void run()
  {
    StreetImageViewPager.a(this.a, StreetImageViewPager.e(this.a).getCurrentItem() + 1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */