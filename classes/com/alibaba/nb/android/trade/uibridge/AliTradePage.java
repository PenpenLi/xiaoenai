package com.alibaba.nb.android.trade.uibridge;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.a.c;
import com.alibaba.nb.android.trade.a.d;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeTaokeTraceCallback;
import com.alibaba.nb.android.trade.constants.AliTradeUTConstants;
import com.alibaba.nb.android.trade.model.AliTradeShowParams;
import com.alibaba.nb.android.trade.model.AliTradeTaokeParams;
import com.alibaba.nb.android.trade.model.inner.AliTradeApplinkOpenType;
import com.alibaba.nb.android.trade.service.config.impl.AliTradeConfigServiceImpl;
import com.alibaba.nb.android.trade.ui.activity.AliTradeNativeTaobaoClientActivity;
import com.alibaba.nb.android.trade.utils.a.a;
import com.alibaba.nb.android.trade.utils.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AliTradePage
  extends AliTradeBasePage
{
  public AliTradePage(String paramString)
  {
    this.a = paramString;
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.a != null)
    {
      arrayOfString = AliTradeContext.detailPatterns;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (this.a.trim().matches(str)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected final boolean a(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeShowParams paramAliTradeShowParams, Map<String, String> paramMap, Activity paramActivity)
  {
    String str = null;
    if (a())
    {
      localObject = Pattern.compile("(\\?|&)id=([^&?]*)").matcher(this.a);
      if (!((Matcher)localObject).find()) {
        break label204;
      }
      localObject = ((Matcher)localObject).group();
    }
    label204:
    for (Object localObject = ((String)localObject).substring(((String)localObject).indexOf('=') + 1);; localObject = null)
    {
      if (paramAliTradeTaokeParams != null) {}
      for (paramAliTradeTaokeParams = paramAliTradeTaokeParams.pid;; paramAliTradeTaokeParams = null)
      {
        if (paramAliTradeShowParams != null) {
          str = paramAliTradeShowParams.getBackUrl();
        }
        if ((str == null) || (TextUtils.isEmpty(str)))
        {
          paramAliTradeShowParams = new Intent(paramActivity, AliTradeNativeTaobaoClientActivity.class);
          paramAliTradeShowParams.putExtra("actionParameters", (Serializable)paramMap);
          paramAliTradeShowParams.putExtra("actionName", "showNative");
          paramAliTradeShowParams.putExtra("type", AliTradeApplinkOpenType.SHOWITEM);
          if (localObject != null) {
            paramAliTradeShowParams.putExtra("id", (String)localObject);
          }
          if (paramAliTradeTaokeParams != null) {
            paramAliTradeShowParams.putExtra("pid", paramAliTradeTaokeParams);
          }
          paramActivity.startActivity(paramAliTradeShowParams);
          return Boolean.TRUE.booleanValue();
        }
        return c.a(paramActivity, AliTradeApplinkOpenType.SHOWITEM, (String)localObject, AliTradeConfigServiceImpl.getInstance().getIsvCode(), paramAliTradeTaokeParams, str, paramMap);
        return super.a(paramAliTradeTaokeParams, paramAliTradeShowParams, paramMap, paramActivity);
      }
    }
  }
  
  protected boolean checkParams()
  {
    if ((getClass().getSuperclass() != null) && (getClass().getSuperclass().getName().equals(AliTradePage.class.getName()))) {}
    while (this.a != null) {
      return true;
    }
    if (AliTradeCallbackContext.tradeProcessCallback != null) {
      b.a(AliTradeCallbackContext.tradeProcessCallback, a.a(14, new Object[] { "url" }));
    }
    return false;
  }
  
  protected String genOpenUrl()
  {
    if (URLUtil.isNetworkUrl(this.a)) {
      return this.a.trim();
    }
    return null;
  }
  
  public String getApi()
  {
    return AliTradeUTConstants.E_SHOWPAGE;
  }
  
  public boolean needTaoke(AliTradeTaokeParams paramAliTradeTaokeParams)
  {
    return (a()) && (paramAliTradeTaokeParams != null);
  }
  
  public void taokeTraceAndGenUrl(AliTradeTaokeParams paramAliTradeTaokeParams, AliTradeTaokeTraceCallback paramAliTradeTaokeTraceCallback)
  {
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.a)))
    {
      Object localObject1 = AliTradeContext.detailPatterns;
      int k = localObject1.length;
      int j = -1;
      int i = 0;
      Object localObject2;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (this.a.matches((String)localObject2)) {
          j = 1;
        }
        i += 1;
      }
      if (1 == j)
      {
        localObject2 = Pattern.compile("(\\?|&)id=([^&?]*)").matcher(this.a);
        localObject1 = null;
        if (((Matcher)localObject2).find())
        {
          localObject1 = ((Matcher)localObject2).group();
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf('=') + 1);
        }
        localObject2 = new HashMap();
        ((Map)localObject2).put("itemId", localObject1);
        if (AliTradeCallbackContext.tradeProcessCallback != null) {
          d.a.a((Map)localObject2, genOpenUrl(), true, paramAliTradeTaokeParams, getApi(), paramAliTradeTaokeTraceCallback, AliTradeCallbackContext.tradeProcessCallback);
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\uibridge\AliTradePage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */