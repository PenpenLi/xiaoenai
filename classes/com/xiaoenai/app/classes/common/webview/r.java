package com.xiaoenai.app.classes.common.webview;

import android.view.View;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class r
  implements k.a
{
  r(WebViewActivity paramWebViewActivity, String paramString) {}
  
  public void a(k paramk, View paramView)
  {
    UserConfig.setBoolean("THIRD_PARTY_CLAIM_" + this.a, Boolean.valueOf(true));
    paramk.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */