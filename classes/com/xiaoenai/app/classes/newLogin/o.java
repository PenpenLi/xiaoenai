package com.xiaoenai.app.classes.newLogin;

import android.graphics.Bitmap;
import android.view.View;
import com.xiaoenai.app.utils.f.a;

class o
  implements com.xiaoenai.app.utils.e.d.b
{
  o(LoginActivity paramLoginActivity) {}
  
  public void a(String paramString, View paramView)
  {
    if (!this.a.isFinishing()) {
      this.a.a(null);
    }
  }
  
  public void a(String paramString, View paramView, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramString.equals(LoginActivity.k(this.a))))
    {
      paramString = com.xiaoenai.app.utils.e.b.a(paramString);
      a.a(" uploadHeadIcon localPath = {}", new Object[] { paramString });
      LoginActivity.b(this.a, paramString);
    }
  }
  
  public void a(String paramString, View paramView, com.xiaoenai.app.utils.e.a.b paramb)
  {
    if (!this.a.isFinishing())
    {
      this.a.l_();
      LoginActivity.j(this.a);
    }
  }
  
  public void b(String paramString, View paramView) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */