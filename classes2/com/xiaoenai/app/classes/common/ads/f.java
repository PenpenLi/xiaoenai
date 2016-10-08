package com.xiaoenai.app.classes.common.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.xiaoenai.app.ui.a.k;

class f
  implements com.xiaoenai.app.utils.e.d.b
{
  f(c paramc, k paramk) {}
  
  public void a(String paramString, View paramView)
  {
    paramString = (AnimationDrawable)this.b.a.getResources().getDrawable(2130838790);
    if (paramString != null) {
      paramString.start();
    }
    if (paramView != null)
    {
      ((ImageView)paramView).setImageDrawable(paramString);
      paramView.setOnClickListener(new g(this));
    }
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    if (paramView != null)
    {
      ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)paramView).setImageBitmap(paramBitmap);
    }
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    if (paramView != null) {
      ((ImageView)paramView).setImageDrawable(null);
    }
  }
  
  public void b(String paramString, View paramView)
  {
    if (paramView != null) {
      ((ImageView)paramView).setImageDrawable(null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\ads\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */