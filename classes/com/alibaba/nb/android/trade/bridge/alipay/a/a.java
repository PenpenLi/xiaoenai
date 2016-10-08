package com.alibaba.nb.android.trade.bridge.alipay.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.callback.AliTradeCallbackContext;
import com.alibaba.nb.android.trade.callback.AliTradeProcessCallback;
import com.alibaba.nb.android.trade.ui.activity.AliTradeWebViewActivity;
import com.alibaba.nb.android.trade.utils.e;

public class a
  implements com.alibaba.nb.android.trade.bridge.alipay.a
{
  private static volatile a b = null;
  public final String a = "AliTradeAlipayServiceImp";
  
  public static boolean a()
  {
    try
    {
      Class.forName("com.alipay.sdk.app.PayTask");
      boolean bool = Boolean.TRUE.booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      com.alibaba.nb.android.trade.utils.d.a.b("AliTradeApplinkServiceImp", "ApplinkSDK沒有被依賴");
    }
    return Boolean.FALSE.booleanValue();
  }
  
  public static a b()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new a();
      }
      return b;
    }
    finally {}
  }
  
  private static String b(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2) + paramString2.length();
    if (paramString3 != null) {}
    try
    {
      return paramString1.substring(i, paramString1.indexOf(paramString3));
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    paramString2 = paramString1.substring(i);
    return paramString2;
    return paramString1;
  }
  
  private static String c(WebView paramWebView, String paramString)
  {
    try
    {
      Object localObject = paramWebView.getContext();
      localObject = com.alibaba.nb.android.trade.utils.f.a.a("com.alipay.sdk.app.PayTask", new String[] { "android.app.Activity" }, new Object[] { localObject });
      Boolean localBoolean = Boolean.TRUE;
      paramString = (String)com.alibaba.nb.android.trade.utils.f.a.a("com.alipay.sdk.app.PayTask", "pay", new String[] { "java.lang.String", "boolean" }, localObject, new Object[] { paramString, localBoolean });
      return paramString;
    }
    catch (Exception paramString)
    {
      com.alibaba.nb.android.trade.utils.d.a.d("AliTradeAlipayServiceImp", "调用ApliPaySDK失败" + paramString.getMessage());
      if (AliTradeCallbackContext.tradeProcessCallback != null) {
        AliTradeCallbackContext.tradeProcessCallback.onFailure(809, "使用Apliay SDK调用方法失败，请下载最新的ApliaySDK lib包或者使用H5方式付款");
      }
      if (!(paramWebView.getContext() instanceof AliTradeWebViewActivity)) {
        break label138;
      }
    }
    ((AliTradeWebViewActivity)paramWebView.getContext()).finish();
    for (;;)
    {
      return null;
      label138:
      if ((paramWebView.getContext() instanceof Activity)) {
        ((Activity)paramWebView.getContext()).finish();
      }
    }
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    Object localObject = localUri.getQueryParameter("alipay_trade_no");
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = localUri.getQueryParameter("trade_nos");
    }
    String str = localUri.getQueryParameter("payPhaseId");
    localObject = str;
    if (str == null) {
      localObject = localUri.getQueryParameter("pay_phase_id");
    }
    str = localUri.getQueryParameter("s_id");
    paramString = new StringBuilder("trade_no=\"").append(paramString).append("\"&extern_token=\"").append(str).append("\"&partner=\"PARTNER_TAOBAO_ORDER\"");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.append("&payPhaseId=\"").append((String)localObject).append("\"");
    }
    paramString = paramString.toString();
    AliTradeContext.executorService.a(new b(this, paramWebView, paramString, localUri));
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\bridge\alipay\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */