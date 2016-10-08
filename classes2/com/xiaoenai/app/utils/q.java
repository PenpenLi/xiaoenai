package com.xiaoenai.app.utils;

import android.content.Context;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import com.xiaoenai.app.utils.f.a;

final class q
  implements AliTradeProcessCallback
{
  q(Context paramContext) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    a.a(true, "onFailure code = {} msg = {}", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 806) {
      p.a(this.a, false);
    }
  }
  
  public void onTradeSuccess(AliTradeResult paramAliTradeResult)
  {
    a.c(true, "onPaySuccess", new Object[0]);
    p.a(this.a, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */