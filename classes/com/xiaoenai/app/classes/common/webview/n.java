package com.xiaoenai.app.classes.common.webview;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.component.view.webview.XeaWebView;
import org.json.JSONObject;

class n
  extends m
{
  n(WebViewActivity paramWebViewActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    this.a.a(null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.a.l_();
    WebViewActivity.e(this.a).loadUrl("javascript:uploadCallback(error)");
  }
  
  public void a(k paramk)
  {
    super.a(paramk);
    this.a.l_();
    WebViewActivity.e(this.a).loadUrl("javascript:uploadCallback(error)");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.l_();
    if (paramJSONObject != null) {
      WebViewActivity.e(this.a).loadUrl("javascript:uploadCallback('" + paramJSONObject.optString("url") + "')");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\webview\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */