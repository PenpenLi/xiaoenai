package com.xiaoenai.app.classes.common.webview;

import com.xiaoenai.app.classes.street.pay.a.a.a;
import com.xiaoenai.app.ui.component.view.webview.XeaWebView;
import com.xiaoenai.app.utils.d.ac;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

class i
  implements a.a
{
  i(WebViewActivity paramWebViewActivity) {}
  
  public void a()
  {
    this.a.a(null);
  }
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean)
    {
      this.a.l_();
      return;
    }
    a.c("data = {}", new Object[] { paramJSONObject });
  }
  
  public void c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void d(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      this.a.l_();
    }
  }
  
  public void e(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.a.l_();
    paramJSONObject = paramJSONObject.optString("data");
    WebViewActivity.e(this.a).loadUrl("javascript:payCallback('" + ac.a(paramJSONObject) + "')");
  }
  
  public void f(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.a.l_();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */