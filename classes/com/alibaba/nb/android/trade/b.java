package com.alibaba.nb.android.trade;

import com.alibaba.nb.android.trade.callback.AliTradeInitCallback;
import com.alibaba.nb.android.trade.utils.d.a;
import com.alibaba.sdk.android.callback.InitResultCallback;

final class b
  implements InitResultCallback
{
  b(AliTradeInitCallback paramAliTradeInitCallback) {}
  
  public final void onFailure(int paramInt, String paramString)
  {
    a.a(AliTradeSDK.c(), "OneSdk初始化失败 ：" + paramString);
    this.a.onFailure(paramInt, "OneSdk初始化失败:" + paramString);
    AliTradeSDK.a(false);
  }
  
  public final void onSuccess()
  {
    a.a(AliTradeSDK.c(), "OneSdk初始化成功");
    AliTradeSDK.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */