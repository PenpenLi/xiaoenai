package com.xiaoenai.app.classes.auth;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class am
  implements View.OnClickListener
{
  am(XeaAuthActivity paramXeaAuthActivity) {}
  
  public void onClick(View paramView)
  {
    if (XeaAuthActivity.d(this.a) != null) {
      XeaAuthActivity.d(this.a).setVisibility(0);
    }
    XeaAuthActivity.a(this.a, XeaAuthActivity.f(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */