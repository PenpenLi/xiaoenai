package com.xiaoenai.app.classes.common.webview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.ui.component.view.webview.XeaWebView;

class q
  implements View.OnClickListener
{
  q(WebViewActivity paramWebViewActivity) {}
  
  public void onClick(View paramView)
  {
    WebViewActivity.e(this.a).loadUrl(this.a.mDebugEdit.getText().toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */