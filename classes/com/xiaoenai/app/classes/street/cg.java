package com.xiaoenai.app.classes.street;

import android.support.v4.view.ViewPager.OnPageChangeListener;

class cg
  implements ViewPager.OnPageChangeListener
{
  cg(StreetOrderActivity paramStreetOrderActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StreetOrderActivity.c(this.a, paramInt);
    StreetOrderActivity.d(this.a, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */