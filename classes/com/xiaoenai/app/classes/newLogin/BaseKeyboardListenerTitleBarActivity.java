package com.xiaoenai.app.classes.newLogin;

import android.view.View;
import com.c.a.ad;
import com.c.a.l;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.AutoHeightLayout;
import com.xiaoenai.app.widget.ResizeLayout.a;

public abstract class BaseKeyboardListenerTitleBarActivity
  extends TitleBarActivity
  implements ResizeLayout.a
{
  protected AutoHeightLayout a;
  private boolean b = false;
  
  protected void a(int paramInt) {}
  
  protected void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView = l.a(paramView, "translationY", new float[] { paramFloat1, paramFloat2 });
    paramView.b(300L);
    paramView.a(new e(this));
    paramView.a();
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    ad localad = ad.b(new int[] { paramInt1, paramInt2 });
    localad.a(new f(this, paramView));
    localad.a(new g(this));
    localad.c(300L);
    localad.a();
  }
  
  public void b(int paramInt)
  {
    a.c("==========OnSoftPop==========={}", new Object[] { Integer.valueOf(paramInt) });
    a(paramInt);
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    a.c("==========OnSoftClose==========={}", new Object[] { Integer.valueOf(paramInt) });
    c();
  }
  
  protected void d()
  {
    if (this.b) {
      return;
    }
    this.a = ((AutoHeightLayout)findViewById(2131558670));
    this.a.setOnResizeListener(this);
    this.b = true;
  }
  
  public void d(int paramInt)
  {
    a.c("==========OnSoftChanegHeight==========={}", new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void f() {}
  
  protected void g() {}
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\BaseKeyboardListenerTitleBarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */