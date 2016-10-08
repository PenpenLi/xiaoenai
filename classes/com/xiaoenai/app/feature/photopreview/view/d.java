package com.xiaoenai.app.feature.photopreview.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.utils.d.i;

class d
  implements ViewPager.OnPageChangeListener
{
  d(PreviewActivity paramPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    PreviewActivity.b(this.a).setTitle(paramInt + 1 + " / " + this.a.s.getCount());
    this.a.x = paramInt;
    this.a.s.a(paramInt);
    this.a.k.setSelected(this.a.v);
    long l = 0L;
    if (this.a.v) {
      l = i.a(this.a.t[this.a.x]);
    }
    this.a.b(l);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopreview\view\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */