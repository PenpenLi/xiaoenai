package com.xiaoenai.app.classes.newLogin;

import android.view.View;
import com.c.a.ad;
import com.c.a.e;
import com.c.a.l;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.widget.AutoHeightLayout;
import com.xiaoenai.app.widget.ResizeLayout.a;

public abstract class BaseKeyboardListenerActivity
  extends BaseActivity
  implements ResizeLayout.a
{
  protected AutoHeightLayout a;
  private boolean b = false;
  private int c = 1;
  
  protected void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView = l.a(paramView, "translationY", new float[] { paramFloat1, paramFloat2 });
    paramView.b(300L);
    paramView.a(new a(this));
    paramView.a();
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2)
  {
    ad localad = ad.b(new int[] { paramInt1, paramInt2 });
    localad.a(new b(this, paramView));
    localad.a(new c(this));
    localad.c(300L);
    localad.a();
  }
  
  protected void a(View paramView, float... paramVarArgs)
  {
    paramView = l.a(paramView, "alpha", paramVarArgs);
    paramView.b(250L);
    paramView.a();
  }
  
  protected void b()
  {
    if (this.b) {
      return;
    }
    this.a = ((AutoHeightLayout)findViewById(2131558670));
    this.a.setOnResizeListener(this);
    this.b = true;
  }
  
  public void b(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("==========OnSoftPop==========={}", new Object[] { Integer.valueOf(paramInt) });
    a(paramInt);
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2)
  {
    ad localad = ad.a(new e(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localad.c(250L);
    localad.a(new d(this, paramView));
    localad.a();
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("==========OnSoftClose==========={}", new Object[] { Integer.valueOf(paramInt) });
    a();
  }
  
  protected void d() {}
  
  public void d(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("==========OnSoftChanegHeight==========={}", new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\BaseKeyboardListenerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */