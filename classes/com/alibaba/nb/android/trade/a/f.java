package com.alibaba.nb.android.trade.a;

import com.alibaba.nb.android.trade.callback.AliTradeFailureCallback;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.utils.b;
import java.util.Map;

final class f
  implements Runnable
{
  f(d paramd, Map paramMap, String paramString1, AliTradeTaokeParams paramAliTradeTaokeParams, String paramString2, AliTradeFailureCallback paramAliTradeFailureCallback) {}
  
  public final void run()
  {
    Object localObject1 = this.f;
    localObject1 = this.a;
    Object localObject2 = this.b;
    localObject2 = this.c;
    Object localObject3 = this.d;
    localObject3 = d.a((Map)localObject1, (AliTradeTaokeParams)localObject2);
    if ((localObject3 == null) || (((com.alibaba.nb.android.trade.model.inner.a)localObject3).a != 2))
    {
      if (localObject3 == null)
      {
        localObject1 = "null taokeTrace response";
        if (localObject1 == null) {
          break label146;
        }
        localObject2 = localObject1;
        label56:
        com.alibaba.nb.android.trade.utils.d.a.d("taoke", (String)localObject2);
        if (this.e != null)
        {
          localObject2 = this.e;
          if (localObject3 != null) {
            break label151;
          }
        }
      }
      label146:
      label151:
      for (int i = 0;; i = ((com.alibaba.nb.android.trade.model.inner.a)localObject3).a)
      {
        b.a((AliTradeFailureCallback)localObject2, i, "淘客打点失败，错误信息:" + (String)localObject1);
        com.alibaba.nb.android.trade.utils.d.a.b("taoke", "taoke异步打点失败");
        return;
        localObject1 = "code: " + ((com.alibaba.nb.android.trade.model.inner.a)localObject3).a + " msg: " + ((com.alibaba.nb.android.trade.model.inner.a)localObject3).b;
        break;
        localObject2 = null;
        break label56;
      }
    }
    com.alibaba.nb.android.trade.utils.d.a.b("taoke", "taoke异步打点成功");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */