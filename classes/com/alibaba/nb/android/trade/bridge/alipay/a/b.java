package com.alibaba.nb.android.trade.bridge.alipay.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.model.AliPayResult;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import java.util.List;

final class b
  implements Runnable
{
  b(a parama, WebView paramWebView, String paramString, Uri paramUri) {}
  
  public final void run()
  {
    Object localObject1;
    if ((this.a.getContext() instanceof Activity))
    {
      localObject1 = this.d;
      localObject1 = a.b(this.a, this.b);
      if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        break label42;
      }
    }
    label42:
    Object localObject2;
    do
    {
      return;
      localObject1 = ((String)localObject1).replace("{", "").replace("}", "");
      localObject2 = this.d;
      localObject1 = a.a((String)localObject1, "resultStatus=", ";memo");
      if (!TextUtils.equals("9000", (CharSequence)localObject1)) {
        break label189;
      }
      localObject1 = this.d;
      localObject1 = a.a(this.c);
      localObject2 = this.d;
      localObject2 = a.a((List)localObject1);
      if ((localObject2 != null) && ((((AliTradeResult)localObject2).payResult.payFailedOrders != null) || (((AliTradeResult)localObject2).payResult.paySuccessOrders != null))) {
        break;
      }
      com.alibaba.nb.android.trade.utils.d.a.a("AliTradeAlipayServiceImp", "QueryOrderResultTask.asyncExecute()--pay success but empty order： message:为空的订单");
    } while (AliTradeCallbackContext.tradeProcessCallback == null);
    AliTradeCallbackContext.tradeProcessCallback.onFailure(10009, "alipay支付失败，信息为:empty orders");
    return;
    com.alibaba.nb.android.trade.utils.d.a.a("AliTradeAlipayServiceImp", "QueryOrderResultTask.asyncExecute()--pay success" + localObject1);
    a.a(this.d, this.a, (AliTradeResult)localObject2);
    return;
    label189:
    a.a(this.d, (String)localObject1, this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */