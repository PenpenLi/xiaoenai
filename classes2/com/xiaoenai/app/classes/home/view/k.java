package com.xiaoenai.app.classes.home.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class k
  implements ViewPager.OnPageChangeListener
{
  k(ContentView paramContentView, int paramInt) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < this.a)
    {
      ImageView localImageView = (ImageView)ContentView.b(this.b).getChildAt(i);
      if (i != paramInt) {
        localImageView.setSelected(false);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setSelected(true);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */