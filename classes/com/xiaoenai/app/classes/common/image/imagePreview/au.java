package com.xiaoenai.app.classes.common.image.imagePreview;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xiaoenai.app.widget.TitleBarView;

class au
  implements ViewPager.OnPageChangeListener
{
  au(ImageViewPager paramImageViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ImageViewPager.b(this.a).setTitle(paramInt + 1 + " / " + ImageViewPager.a(this.a).getCount());
    ImageViewPager.a(this.a).a(paramInt);
    ImageViewPager.a(this.a, paramInt);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */