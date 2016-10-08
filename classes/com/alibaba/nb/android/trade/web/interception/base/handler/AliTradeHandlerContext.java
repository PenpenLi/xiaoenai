package com.alibaba.nb.android.trade.web.interception.base.handler;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebView;
import com.alibaba.nb.android.trade.ui.a.b;
import java.util.Map;

public class AliTradeHandlerContext
  extends com.alibaba.nb.android.trade.web.interception.base.c
{
  public b NBTWebViewProxy;
  public Activity activity;
  public WebView webView;
  public com.alibaba.nb.android.trade.web.a.c webViewWrapper;
  
  public AliTradeHandlerContext(int paramInt, Uri paramUri, Map<String, Object> paramMap)
  {
    super(paramInt, paramUri, paramMap);
  }
  
  public AliTradeHandlerContext(int paramInt, String paramString, Map<String, Object> paramMap)
  {
    super(paramInt, paramString, paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\web\interception\base\handler\AliTradeHandlerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */