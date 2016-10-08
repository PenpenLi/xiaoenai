package com.xiaoenai.app.widget.imagepicker;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.image.imagePreview.ImageViewPager;

class f
  implements View.OnClickListener
{
  f(BaseImagePickerActivity paramBaseImagePickerActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = BaseImagePickerActivity.a(this.a).b();
    if ((paramView == null) || (paramView.length <= 0))
    {
      paramView = new com.xiaoenai.app.ui.a.g(this.a);
      paramView.setTitle(2131100989);
      paramView.a(2131100898, new g(this));
      paramView.show();
      return;
    }
    Intent localIntent = new Intent(this.a, ImageViewPager.class);
    localIntent.putExtra("imageUrls", paramView);
    localIntent.putExtra("position", 0);
    localIntent.putExtra("image_select_map", BaseImagePickerActivity.c(this.a));
    localIntent.putExtra("image_index_list", BaseImagePickerActivity.d(this.a));
    localIntent.putExtra("image_origin_flag", BaseImagePickerActivity.a(this.a).f());
    localIntent.putExtra("from_text", BaseImagePickerActivity.e(this.a));
    localIntent.putExtra("from", 3);
    localIntent.putExtra("image_picker_mode", BaseImagePickerActivity.f(this.a));
    localIntent.putExtra("original_flag", BaseImagePickerActivity.g(this.a));
    this.a.startActivity(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\imagepicker\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */