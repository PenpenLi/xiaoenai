package com.xiaoenai.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaoenai.app.classes.chat.input.InputFragment;
import com.xiaoenai.app.utils.ab;

public class AutoHeightLayout
  extends ResizeLayout
  implements ResizeLayout.a
{
  protected Context a;
  protected int b;
  private InputFragment c;
  
  public AutoHeightLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    this.b = ab.d();
    setOnResizeListener(this);
  }
  
  private void setAutoViewHeight(int paramInt)
  {
    if ((paramInt > 0) && (paramInt != this.b))
    {
      this.b = paramInt;
      ab.a(this.b);
    }
    if ((this.c != null) && (paramInt > 0)) {
      this.c.c(paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("==========OnSoftPop==========={}", new Object[] { Integer.valueOf(paramInt) });
    post(new a(this, paramInt));
  }
  
  public void c(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("==========OnSoftClose==========={}", new Object[] { Integer.valueOf(paramInt) });
    if (this.c != null) {
      this.c.f();
    }
  }
  
  public void d(int paramInt)
  {
    com.xiaoenai.app.utils.f.a.c("==========OnSoftChanegHeight==========={}", new Object[] { Integer.valueOf(paramInt) });
    post(new b(this, paramInt));
  }
  
  public void setInputFragment(InputFragment paramInputFragment)
  {
    this.c = paramInputFragment;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\widget\AutoHeightLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */