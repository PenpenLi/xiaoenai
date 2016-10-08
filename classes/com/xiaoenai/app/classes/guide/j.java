package com.xiaoenai.app.classes.guide;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class j
  implements ViewPager.OnPageChangeListener
{
  j(NewVersionIntroActivity paramNewVersionIntroActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((NewVersionIntroActivity.a(this.a) == 3) && (paramInt1 == 3) && (paramFloat == 0.0F) && (paramInt2 == 0))
    {
      this.a.a();
      Fragment localFragment = ((NewVersionIntroActivity.a)NewVersionIntroActivity.b(this.a)).a();
      if (localFragment != null) {
        ((f)localFragment).a();
      }
    }
    NewVersionIntroActivity.a(this.a, paramInt1);
  }
  
  public void onPageSelected(int paramInt)
  {
    int i = 0;
    if (i < 4)
    {
      ImageView localImageView = (ImageView)NewVersionIntroActivity.c(this.a).getChildAt(i);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\guide\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */