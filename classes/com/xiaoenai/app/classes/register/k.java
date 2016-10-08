package com.xiaoenai.app.classes.register;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.ScrollView;

class k
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  k(RegisterActivity paramRegisterActivity) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a.getRootView().getHeight() - this.a.a.getHeight() > 100)
    {
      RegisterActivity.e(this.a).scrollTo(0, this.a.a.getBottom());
      RegisterActivity.b(this.a).setCursorVisible(true);
      RegisterActivity.c(this.a).setCursorVisible(true);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\register\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */