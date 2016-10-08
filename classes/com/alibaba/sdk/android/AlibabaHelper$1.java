package com.alibaba.sdk.android;

import com.alibaba.nb.android.trade.AliTradeSDK;
import com.alibaba.nb.android.trade.callback.AliTradeInitCallback;
import com.xiaoenai.app.utils.f.a;

final class AlibabaHelper$1
  implements AliTradeInitCallback
{
  public void onFailure(int paramInt, String paramString)
  {
    a.c("code = {} msg = {}", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void onSuccess()
  {
    AliTradeSDK.setForceH5(true);
    AliTradeSDK.setSyncForTaoke(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\AlibabaHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */