package com.xiaoenai.app.classes.street.guide;

import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import com.xiaoenai.app.utils.f.a;

class e
  implements AliTradeProcessCallback
{
  e(StreetLifeServiceActivity paramStreetLifeServiceActivity) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    a.c("i = {} s = {}", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void onTradeSuccess(AliTradeResult paramAliTradeResult)
  {
    a.c(true, "showCart onPaySuccess", new Object[0]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\guide\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */