package com.xiaoenai.app.classes.common.image.imagePreview;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xiaoenai.app.widget.TitleBarView;

class ao
  implements ViewPager.OnPageChangeListener
{
  ao(ak paramak) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (!ak.k(this.a)) {
      ak.d(this.a).setTitle(paramInt + 1 + " / " + this.a.getCount());
    }
    this.a.a(paramInt);
    ak.a(this.a, ak.a(this.a)[paramInt], ak.a(this.a, ak.g(this.a)[paramInt]));
    ak.e(this.a, ak.c(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */