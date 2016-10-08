package com.xiaoenai.app.classes.chat.input.faces;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class i
  implements ViewPager.OnPageChangeListener
{
  i(f paramf) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < f.c(this.a).getChildCount())
    {
      ImageView localImageView = (ImageView)f.c(this.a).getChildAt(i);
      if (i == paramInt) {
        localImageView.setImageResource(2130837672);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130837673);
      }
    }
    f.b(paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */