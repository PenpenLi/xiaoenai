package com.xiaoenai.app.feature.photopicker.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.feature.photopicker.b.c;
import java.util.ArrayList;

class h
  implements View.OnClickListener
{
  h(PhotoPickerActivity paramPhotoPickerActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = PhotoPickerActivity.b(this.a).b();
    if ((paramView != null) && (paramView.size() > 0))
    {
      Intent localIntent = new Intent(this.a, PickerPreviewActivity.class);
      localIntent.putExtra("imageUrls", (String[])paramView.toArray(new String[paramView.size()]));
      localIntent.putExtra("position", 0);
      localIntent.putExtra("max_selected_size", PhotoPickerActivity.e(this.a));
      localIntent.putExtra("selected_count", PhotoPickerActivity.f(this.a));
      localIntent.putExtra("selected_image_url", paramView);
      localIntent.putExtra("image_url_origin", PhotoPickerActivity.g(this.a));
      localIntent.putExtra("show_origin", true);
      this.a.startActivityForResult(localIntent, 1);
      PhotoPickerActivity.a(this.a, true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photopicker\view\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */