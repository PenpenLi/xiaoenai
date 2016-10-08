package com.xiaoenai.app.classes.common.webview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.common.image.ImagePicker;

class j
  implements View.OnClickListener
{
  j(WebViewActivity paramWebViewActivity, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    new ImagePicker(this.b).a(this.b, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */