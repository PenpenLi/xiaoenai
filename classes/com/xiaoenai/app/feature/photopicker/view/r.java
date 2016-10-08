package com.xiaoenai.app.feature.photopicker.view;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photopicker.a.b;
import com.xiaoenai.app.feature.photopicker.a.f;
import java.util.List;

class r
  implements ViewPager.OnPageChangeListener
{
  r(PickerPreviewActivity paramPickerPreviewActivity) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ((f)PickerPreviewActivity.e(this.a).get(paramInt)).a(PickerPreviewActivity.d(this.a));
    PickerPreviewActivity.b(this.a, ((f)PickerPreviewActivity.e(this.a).get(paramInt)).a());
    if (PickerPreviewActivity.c(this.a))
    {
      PickerPreviewActivity.f(this.a).b(a.b.album_item_selected, 0);
      return;
    }
    PickerPreviewActivity.g(this.a).b(a.b.album_item_unselected, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */