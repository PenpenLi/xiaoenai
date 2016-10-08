package com.xiaoenai.app.classes.home;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.utils.e.d.g;

class aj
  extends g
{
  aj(v paramv, String paramString) {}
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    super.a(paramString, paramView, paramBitmap);
    if (v.e(this.b) != null) {
      v.e(this.b).setImageBitmap(paramBitmap);
    }
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    super.a(paramString, paramView, paramb);
    com.xiaoenai.app.utils.e.b.a(v.e(this.b), this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */