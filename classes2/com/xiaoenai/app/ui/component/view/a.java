package com.xiaoenai.app.ui.component.view;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  a(MaskableFrameLayout paramMaskableFrameLayout, ViewTreeObserver paramViewTreeObserver) {}
  
  public void onGlobalLayout()
  {
    ViewTreeObserver localViewTreeObserver2 = this.a;
    ViewTreeObserver localViewTreeObserver1 = localViewTreeObserver2;
    if (!localViewTreeObserver2.isAlive()) {
      localViewTreeObserver1 = this.b.getViewTreeObserver();
    }
    if (localViewTreeObserver1 != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        localViewTreeObserver1.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      MaskableFrameLayout.a(this.b, MaskableFrameLayout.a(this.b, MaskableFrameLayout.a(this.b)));
      return;
      localViewTreeObserver1.removeGlobalOnLayoutListener(this);
      continue;
      com.xiaoenai.app.utils.f.a.c("GlobalLayoutListener not removed as ViewTreeObserver is not valid", new Object[0]);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\ui\component\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */