package com.xiaoenai.app.classes.chat.input.a;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class o
  implements ViewPager.OnPageChangeListener
{
  o(i parami) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int j = i.c(this.a).getChildCount();
    int i = 0;
    if (i < j)
    {
      ImageView localImageView = (ImageView)i.c(this.a).getChildAt(i);
      if (paramInt == i) {
        localImageView.setImageResource(2130837672);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setImageResource(2130837673);
      }
    }
    i.a(this.a, paramInt);
    i.b(this.a, i.d(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */