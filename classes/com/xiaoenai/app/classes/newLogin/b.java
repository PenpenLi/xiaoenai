package com.xiaoenai.app.classes.newLogin;

import android.view.View;
import android.view.ViewParent;
import com.c.a.ad;
import com.c.a.ad.b;

class b
  implements ad.b
{
  b(BaseKeyboardListenerActivity paramBaseKeyboardListenerActivity, View paramView) {}
  
  public void a(ad paramad)
  {
    this.a.getLayoutParams().height = ((Integer)paramad.l()).intValue();
    this.a.requestLayout();
    this.a.getParent().requestLayout();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */