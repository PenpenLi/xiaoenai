package com.alibaba.nb.android.trade.bridge.alipay.a;

import android.app.Activity;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.ui.activity.AliTradeWebViewActivity;

final class c
  implements Runnable
{
  c(a parama, String paramString, WebView paramWebView) {}
  
  public final void run()
  {
    com.alibaba.nb.android.trade.utils.a.a locala = com.alibaba.nb.android.trade.utils.a.c.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder("alipay支付失败，信息为：");
    String str;
    if (locala != null)
    {
      str = locala.c;
      com.alibaba.nb.android.trade.utils.d.a.a("AliTradeAlipayServiceImp", str);
      if (AliTradeCallbackContext.tradeProcessCallback != null) {
        AliTradeCallbackContext.tradeProcessCallback.onFailure(10010, "alipay支付失败，信息为：" + locala.c);
      }
      if (!(this.b.getContext() instanceof AliTradeWebViewActivity)) {
        break label108;
      }
      ((AliTradeWebViewActivity)this.b.getContext()).finish();
    }
    label108:
    while (!(this.b.getContext() instanceof Activity))
    {
      return;
      str = null;
      break;
    }
    ((Activity)this.b.getContext()).finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */