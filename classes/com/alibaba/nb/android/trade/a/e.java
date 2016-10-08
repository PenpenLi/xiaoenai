package com.alibaba.nb.android.trade.a;

import android.text.TextUtils;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.callback.AliTradeFailureCallback;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import java.util.Map;

final class e
  implements Runnable
{
  e(d paramd, Map paramMap, AliTradeTaokeTraceCallback paramAliTradeTaokeTraceCallback, String paramString1, AliTradeTaokeParams paramAliTradeTaokeParams, String paramString2, AliTradeFailureCallback paramAliTradeFailureCallback) {}
  
  public final void run()
  {
    boolean bool;
    Object localObject;
    if ((com.alibaba.nb.android.trade.service.config.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.service.config.a.class, null) != null)
    {
      bool = AliTradeConfigServiceImpl.getInstance().getIsSyncForTaoke();
      localObject = (AliTradeLoginService)AliTradeContext.serviceRegistry.getService(AliTradeLoginService.class, null);
      if ((bool) || ((!AliTradeConfigServiceImpl.getInstance().getLoginDegarade(Boolean.FALSE.booleanValue())) && (((AliTradeLoginService)localObject).isServiceAvliable()))) {
        break label221;
      }
      bool = true;
    }
    label221:
    for (;;)
    {
      if (bool)
      {
        com.alibaba.nb.android.trade.utils.d.a.a("taoke", "taoke同步打点");
        localObject = this.g;
        localObject = d.a(this.a);
        if (localObject != null)
        {
          if (((com.alibaba.nb.android.trade.model.inner.a)localObject).a < 1000) {}
          for (int i = 1; (i != 0) && (!TextUtils.isEmpty((CharSequence)((com.alibaba.nb.android.trade.model.inner.a)localObject).c)); i = 0)
          {
            com.alibaba.nb.android.trade.utils.d.a.a("taoke", "taoke同步打点成,sclickUrl：" + (String)((com.alibaba.nb.android.trade.model.inner.a)localObject).c);
            this.b.genTaokeUrl((String)((com.alibaba.nb.android.trade.model.inner.a)localObject).c);
            return;
          }
        }
        com.alibaba.nb.android.trade.utils.d.a.a("taoke", "taoke同步打点失败");
      }
      this.g.a(this.a, this.c, this.d, this.e, this.f);
      this.b.genTaokeUrl(null);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */