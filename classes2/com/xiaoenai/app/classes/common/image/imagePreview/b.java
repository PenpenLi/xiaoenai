package com.xiaoenai.app.classes.common.image.imagePreview;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xiaoenai.app.widget.TitleBarView;

class b
  implements ViewPager.OnPageChangeListener
{
  b(a parama) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    a.a(this.a).setTitle(paramInt + 1 + " / " + this.a.getCount());
    this.a.a(paramInt);
    a.a(this.a, paramInt);
    a.b(this.a, paramInt);
    a.c(this.a, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */