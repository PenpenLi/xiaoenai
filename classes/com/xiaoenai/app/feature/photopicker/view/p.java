package com.xiaoenai.app.feature.photopicker.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.photopicker.a.e;
import com.xiaoenai.app.ui.a.h;

class p
  implements View.OnClickListener
{
  p(PickerPreviewActivity paramPickerPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if ((PickerPreviewActivity.a(this.a) + 1 > PickerPreviewActivity.b(this.a)) && (!PickerPreviewActivity.c(this.a)))
    {
      h.c(this.a, String.format(this.a.getString(a.e.photopicker_image_max_selected), new Object[] { Integer.valueOf(PickerPreviewActivity.b(this.a)) }), 1500L);
      return;
    }
    paramView = this.a;
    if (!PickerPreviewActivity.c(this.a)) {}
    for (;;)
    {
      PickerPreviewActivity.b(paramView, bool);
      PickerPreviewActivity.a(this.a, PickerPreviewActivity.c(this.a), false);
      return;
      bool = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */