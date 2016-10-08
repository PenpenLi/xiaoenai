package com.xiaoenai.app.classes.auth;

import android.webkit.WebView;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONException;
import org.json.JSONObject;

class aj
  implements e
{
  aj(XeaAuthActivity paramXeaAuthActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.l_();
    as.a(paramString);
    XeaAuthActivity.a(this.a).setRightButtonEnable(true);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("server_msg", paramString);
      XeaAuthActivity.a(this.a, paramInt, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, JSONObject paramJSONObject)
  {
    XeaAuthActivity.a(this.a, paramInt, paramJSONObject);
  }
  
  public void a(String paramString)
  {
    a.c("onPageFinished", new Object[0]);
    if (!paramString.startsWith("xiaoenaiapi://")) {
      if (!this.a.isFinishing()) {
        this.a.l_();
      }
    }
    while (XeaAuthActivity.b(this.a) == null) {
      return;
    }
    XeaAuthActivity.c(this.a).setRightButtonEnable(true);
  }
  
  public void b(int paramInt, JSONObject paramJSONObject)
  {
    XeaAuthActivity.a(this.a, -5, null);
  }
  
  public void b(String paramString)
  {
    a.c("url={}", new Object[] { paramString });
    if (paramString.startsWith("xiaoenaiapi://"))
    {
      if (XeaAuthActivity.d(this.a) != null) {
        XeaAuthActivity.d(this.a).setVisibility(8);
      }
      return;
    }
    this.a.a(this.a.getString(2131100622), false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\auth\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */