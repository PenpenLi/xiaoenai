package com.xiaoenai.app.classes.common.image.imagePreview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.e.a.b.a;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.k;

class s
  implements com.xiaoenai.app.utils.e.d.b
{
  s(m paramm, ProgressView paramProgressView, Activity paramActivity) {}
  
  public void a(String paramString, View paramView)
  {
    this.a.a();
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    this.a.b();
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    a.c("LoadingFailed FailType = {}", new Object[] { paramb.a() });
    this.a.b();
    if (paramb.a() == b.a.d)
    {
      h.c(this.b, 2131100900, 1000L).show();
      com.xiaoenai.app.utils.e.b.a();
    }
    do
    {
      do
      {
        do
        {
          try
          {
            System.gc();
            Runtime.getRuntime().gc();
            return;
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (paramb.a() != b.a.c) {
            break;
          }
        } while (this.b == null);
        h.c(this.b, 2131100887, 1000L).show();
        return;
        if (paramb.a() != b.a.b) {
          break;
        }
        paramb = k.a(paramString);
      } while ((paramView == null) || (!(paramView instanceof ImageView)));
      if (paramb != null)
      {
        ((ImageView)paramView).setImageBitmap(paramb);
        return;
      }
      com.xiaoenai.app.utils.e.b.d(paramString);
      com.xiaoenai.app.utils.e.b.e(paramString);
      com.xiaoenai.app.utils.e.b.a((ImageView)paramView, paramString);
      return;
      if (paramb.a() == b.a.a)
      {
        com.xiaoenai.app.utils.e.b.a((ImageView)paramView, paramString);
        return;
      }
    } while (this.b == null);
    h.c(this.b, 2131100621, 1000L).show();
  }
  
  public void b(String paramString, View paramView)
  {
    this.a.b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\image\imagePreview\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */