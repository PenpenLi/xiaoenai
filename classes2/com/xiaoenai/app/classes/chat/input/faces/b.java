package com.xiaoenai.app.classes.chat.input.faces;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.HashMap;

class b
  implements ViewPager.OnPageChangeListener
{
  b(a parama) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int j = a.a(this.a).getChildCount();
    int i = 0;
    if (i < j)
    {
      ImageView localImageView = (ImageView)a.a(this.a).getChildAt(i);
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
    a.a(this.a, paramInt);
    a.d.put(this.a.c, Integer.valueOf(a.b(this.a)));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\input\faces\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */