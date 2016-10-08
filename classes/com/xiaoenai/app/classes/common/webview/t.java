package com.xiaoenai.app.classes.common.webview;

import android.view.View;
import android.view.View.OnClickListener;

class t
  implements View.OnClickListener
{
  t(WebViewActivity paramWebViewActivity) {}
  
  public void onClick(View paramView)
  {
    if (WebViewActivity.g(this.a).booleanValue())
    {
      WebViewActivity.h(this.a);
      return;
    }
    this.a.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */