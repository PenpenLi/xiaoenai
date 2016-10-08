package com.xiaoenai.app.classes.chat.messagelist.view;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.f.a;

class k
  implements com.xiaoenai.app.utils.e.d.b
{
  k(j paramj) {}
  
  public void a(String paramString, View paramView)
  {
    j.a(this.a).setVisibility(0);
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    j.c(this.a);
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    if (paramb == null) {}
    for (paramView = "null";; paramView = paramb.a())
    {
      a.a("photo view load fail reason code = {}", new Object[] { paramView });
      j.a(this.a).setVisibility(8);
      this.a.c.setImageResource(2131492898);
      j.b(this.a).setVisibility(0);
      j.a(this.a, false);
      j.a(this.a, paramString, this.a.c, paramb);
      return;
    }
  }
  
  public void b(String paramString, View paramView)
  {
    j.a(this.a).setVisibility(8);
    this.a.c.setImageResource(2131492898);
    j.a(this.a, false);
    j.a(this.a, paramString, this.a.c, null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\view\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */