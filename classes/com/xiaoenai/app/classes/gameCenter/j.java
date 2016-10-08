package com.xiaoenai.app.classes.gameCenter;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

class j
  implements View.OnClickListener
{
  j(WebGameActivity paramWebGameActivity) {}
  
  public void onClick(View paramView)
  {
    WebGameActivity.c(this.a).reload();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */