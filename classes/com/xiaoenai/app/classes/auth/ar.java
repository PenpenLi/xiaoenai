package com.xiaoenai.app.classes.auth;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class ar
  implements View.OnClickListener
{
  ar(XeaBrowserAuthActivity paramXeaBrowserAuthActivity) {}
  
  public void onClick(View paramView)
  {
    if (XeaBrowserAuthActivity.a(this.a) != null) {
      XeaBrowserAuthActivity.a(this.a).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */