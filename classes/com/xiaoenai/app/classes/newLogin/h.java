package com.xiaoenai.app.classes.newLogin;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.xiaoenai.app.widget.TitleBarView;

class h
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  h(LoginActivity paramLoginActivity) {}
  
  public void onGlobalLayout()
  {
    LoginActivity.a(this.a, this.a.mTopLayout.getHeight());
    LoginActivity.b(this.a, this.a.mTitleBar.getHeight());
    this.a.mTitleBar.setVisibility(8);
    this.a.mTopLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */