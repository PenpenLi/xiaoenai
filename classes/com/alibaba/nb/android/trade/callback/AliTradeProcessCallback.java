package com.alibaba.nb.android.trade.callback;

import com.alibaba.nb.android.trade.model.AliTradeResult;

public abstract interface AliTradeProcessCallback
  extends AliTradeFailureCallback
{
  public abstract void onTradeSuccess(AliTradeResult paramAliTradeResult);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\callback\AliTradeProcessCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */