package com.xiaoenai.app.classes.common.webview;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.xiaoenai.app.ui.component.view.webview.a.a;

class o
  implements a.a
{
  o(WebViewActivity paramWebViewActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLayoutParams = this.a.getWindow().getAttributes();
      localLayoutParams.flags |= 0x400;
      localLayoutParams.flags |= 0x80;
      this.a.getWindow().setAttributes(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 14) {
        this.a.getWindow().getDecorView().setSystemUiVisibility(1);
      }
      this.a.setRequestedOrientation(-1);
      return;
    }
    WindowManager.LayoutParams localLayoutParams = this.a.getWindow().getAttributes();
    localLayoutParams.flags &= 0xFBFF;
    localLayoutParams.flags &= 0xFF7F;
    this.a.getWindow().setAttributes(localLayoutParams);
    if (Build.VERSION.SDK_INT >= 14) {
      this.a.getWindow().getDecorView().setSystemUiVisibility(0);
    }
    this.a.setRequestedOrientation(1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */