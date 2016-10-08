package com.xiaoenai.app.classes.street.guide;

import com.alibaba.nb.android.trade.bridge.login.callback.AliTradeLoginCallback;
import com.xiaoenai.app.utils.f.a;

class j
  implements AliTradeLoginCallback
{
  j(StreetTaeAuthorizationActivity paramStreetTaeAuthorizationActivity) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    a.a("loginTaobao onFailure code = {} msg = {} ", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void onSuccess()
  {
    StreetTaeAuthorizationActivity.a(this.a);
    a.c(true, "loginTaobao onSuccess", new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */