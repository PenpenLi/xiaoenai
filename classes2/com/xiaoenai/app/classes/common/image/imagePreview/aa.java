package com.xiaoenai.app.classes.common.image.imagePreview;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.ui.photoview.PhotoView;
import com.xiaoenai.app.utils.ab;

class aa
  implements com.xiaoenai.app.utils.e.d.b
{
  aa(z paramz, ProgressView paramProgressView) {}
  
  public void a(String paramString, View paramView)
  {
    this.a.a();
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    this.a.b();
    int i;
    if (ab.a() / ab.b() < paramBitmap.getHeight() / paramBitmap.getWidth())
    {
      i = 1;
      if (i == 0) {
        break label59;
      }
      ((PhotoView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      ((PhotoView)paramView).setImageBitmap(paramBitmap);
      return;
      i = 0;
      break;
      label59:
      ((PhotoView)paramView).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    this.a.b();
  }
  
  public void b(String paramString, View paramView)
  {
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */