package com.alibaba.nb.android.trade.bridge.login.a;

import com.alibaba.nb.android.trade.bridge.login.callback.AliTradeLoginCallback;
import com.alibaba.sdk.android.login.callback.LoginCallback;
import com.alibaba.sdk.android.session.model.Session;

final class b
  implements LoginCallback
{
  b(a parama, AliTradeLoginCallback paramAliTradeLoginCallback) {}
  
  public final void onFailure(int paramInt, String paramString)
  {
    this.a.onFailure(paramInt, paramString);
  }
  
  public final void onSuccess(Session paramSession)
  {
    this.a.onSuccess();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\login\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */