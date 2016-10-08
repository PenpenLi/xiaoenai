package com.xiaoenai.app.classes.street.guide;

import android.support.v4.view.ViewPager.OnPageChangeListener;

class d
  implements ViewPager.OnPageChangeListener
{
  d(StreetLifeServiceActivity paramStreetLifeServiceActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StreetLifeServiceActivity.a(this.a, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */