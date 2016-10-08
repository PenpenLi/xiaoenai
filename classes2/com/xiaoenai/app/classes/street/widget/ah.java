package com.xiaoenai.app.classes.street.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.List;

class ah
  implements ViewPager.OnPageChangeListener
{
  ah(ad paramad) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < ad.f(this.a).size())
    {
      ImageView localImageView = (ImageView)ad.g(this.a).getChildAt(i);
      if (localImageView != null)
      {
        if (i == paramInt) {
          break label54;
        }
        localImageView.setSelected(false);
      }
      for (;;)
      {
        i += 1;
        break;
        label54:
        localImageView.setSelected(true);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\widget\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */