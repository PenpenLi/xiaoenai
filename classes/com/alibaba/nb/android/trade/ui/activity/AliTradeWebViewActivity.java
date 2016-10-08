package com.alibaba.nb.android.trade.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.model.AliTradeResult;
import com.alibaba.nb.android.trade.utils.d.a;
import com.alibaba.nb.android.trade.utils.e;
import com.alibaba.sdk.android.web.impl.CookieManagerWrapper;

public class AliTradeWebViewActivity
  extends AliTradeBaseWebViewActivity
{
  private static final String e = AliTradeWebViewActivity.class.getSimpleName();
  
  public final void a(AliTradeResult paramAliTradeResult)
  {
    if (AliTradeCallbackContext.tradeProcessCallback != null) {
      AliTradeContext.executorService.b(new d(this, paramAliTradeResult));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (a.a()) {
      a.b(e, "remove cookies");
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null)) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("url");
    } while (paramIntent == null);
    CookieManagerWrapper.INSTANCE.refreshCookie(paramIntent);
    this.a.loadUrl(paramIntent);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("caller", getIntent().getStringExtra("caller"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\ui\activity\AliTradeWebViewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */