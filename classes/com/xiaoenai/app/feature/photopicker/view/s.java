package com.xiaoenai.app.feature.photopicker.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.common.view.widget.TitleBarView;
import com.xiaoenai.app.feature.photopicker.a.b;
import com.xiaoenai.app.feature.photopicker.a.f;
import java.util.ArrayList;
import java.util.List;

class s
  implements View.OnClickListener
{
  s(PickerPreviewActivity paramPickerPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    if ((PickerPreviewActivity.h(this.a) != null) && (PickerPreviewActivity.h(this.a).size() > 0))
    {
      paramView.putExtra("selected_image_url", PickerPreviewActivity.h(this.a));
      int[] arrayOfInt = new int[PickerPreviewActivity.i(this.a).size()];
      int i = 0;
      while (i < PickerPreviewActivity.i(this.a).size())
      {
        arrayOfInt[i] = ((Integer)PickerPreviewActivity.i(this.a).get(i)).intValue();
        i += 1;
      }
      paramView.putExtra("image_url_origin", arrayOfInt);
      paramView.putExtra("action_back", false);
    }
    for (;;)
    {
      this.a.setResult(-1, paramView);
      this.a.finish();
      return;
      PickerPreviewActivity.j(this.a).b(a.b.album_item_selected, 0);
      PickerPreviewActivity.a(this.a, new ArrayList());
      PickerPreviewActivity.h(this.a).add(((f)PickerPreviewActivity.e(this.a).get(PickerPreviewActivity.k(this.a))).b());
      paramView.putExtra("selected_image_url", PickerPreviewActivity.h(this.a));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */