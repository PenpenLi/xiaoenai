package com.alibaba.nb.android.trade.bridge.login.handler;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.nb.a.a.a.a.a;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.bridge.login.AliTradeLoginService;
import com.alibaba.nb.android.trade.bridge.login.callback.AliTradeLoginCallback;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.service.b.b;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.utils.h;
import com.alibaba.nb.android.trade.web.a.c;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerAction;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerContext;
import com.alibaba.nb.android.trade.web.interception.base.handler.AliTradeHandlerInfo;
import com.alibaba.nb.android.trade.web.register.AliTradeServiceRegistry;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.session.CredentialService;
import com.alibaba.sdk.android.session.model.Session;
import java.util.HashMap;
import java.util.Map;

public class AliTradeLoginHandlerAction
  implements AliTradeHandlerAction
{
  private AliTradeHandlerInfo handlerInfo;
  
  public AliTradeLoginHandlerAction(AliTradeHandlerInfo paramAliTradeHandlerInfo)
  {
    this.handlerInfo = paramAliTradeHandlerInfo;
  }
  
  private void sentUserTrack(AliTradeLoginService paramAliTradeLoginService)
  {
    b localb = (b)AliTradeContext.serviceRegistry.getService(b.class, null);
    if (localb != null)
    {
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(AliTradeConfigServiceImpl.getInstance().getAppKey()))
      {
        localHashMap.put("appkey", AliTradeConfigServiceImpl.getInstance().getAppKey());
        localHashMap.put("userId", paramAliTradeLoginService.getSession().getUserId());
        localHashMap.put("utdid", AliTradeContext.getUtdid());
        paramAliTradeLoginService = (com.alibaba.nb.android.trade.service.a.a)AliTradeContext.serviceRegistry.getService(com.alibaba.nb.android.trade.service.a.a.class, null);
        if (paramAliTradeLoginService != null) {
          localHashMap.put("ybhpss", (String)paramAliTradeLoginService.a("trade", "ybhpss"));
        }
      }
      localb.a(AliTradeUTConstants.E_SHOWLOGIN, "", localHashMap);
    }
  }
  
  public boolean execute(AliTradeHandlerContext paramAliTradeHandlerContext)
  {
    if (AliTradeConfigServiceImpl.getInstance().getLoginDegarade(Boolean.FALSE.booleanValue())) {
      return Boolean.FALSE.booleanValue();
    }
    Object localObject = (AliTradeLoginService)AliTradeContext.serviceRegistry.getService(AliTradeLoginService.class, null);
    if ((localObject != null) && (((AliTradeLoginService)localObject).isServiceAvliable()))
    {
      CredentialService localCredentialService = (CredentialService)KernelContext.serviceRegistry.getService(CredentialService.class, null);
      if (localCredentialService.isRefreshTokenExpired())
      {
        ((AliTradeLoginService)localObject).showLogin((Activity)paramAliTradeHandlerContext.webView.getContext(), new a(paramAliTradeHandlerContext, (AliTradeLoginService)localObject));
        return true;
      }
      new a(this, localCredentialService, (AliTradeLoginService)localObject, paramAliTradeHandlerContext).execute(new Void[0]);
      return true;
    }
    if (paramAliTradeHandlerContext.getScenario() != 2) {
      return false;
    }
    localObject = paramAliTradeHandlerContext.webView;
    if (localObject == null) {
      return false;
    }
    ((WebView)localObject).loadUrl(paramAliTradeHandlerContext.getUri());
    return true;
  }
  
  final class a
    implements AliTradeLoginCallback
  {
    private AliTradeHandlerContext b;
    private AliTradeLoginService c;
    
    a(AliTradeHandlerContext paramAliTradeHandlerContext, AliTradeLoginService paramAliTradeLoginService)
    {
      this.b = paramAliTradeHandlerContext;
      this.c = paramAliTradeLoginService;
    }
    
    public final void onFailure(int paramInt, String paramString)
    {
      if ((this.b != null) && (this.b.webViewWrapper != null) && (this.b.webViewWrapper.a() != null) && (!h.a(this.b.webViewWrapper.a().getTag(a.a.e))))
      {
        if (!this.b.webViewWrapper.b()) {
          break label76;
        }
        this.b.webViewWrapper.g();
      }
      label76:
      while (!this.b.webViewWrapper.e()) {
        return;
      }
      this.b.activity.finish();
    }
    
    public final void onSuccess()
    {
      this.b.webViewWrapper.f();
      AliTradeLoginHandlerAction.this.sentUserTrack(this.c);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\login\handler\AliTradeLoginHandlerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */