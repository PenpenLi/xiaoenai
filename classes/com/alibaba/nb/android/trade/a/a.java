package com.alibaba.nb.android.trade.a;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.nb.android.trade.AliTradeContext;
import com.alibaba.nb.android.trade.ui.activity.AliTradeWebViewActivity;
import com.alibaba.nb.android.trade.utils.e;
import java.io.Serializable;
import java.util.Map;

public class a
{
  public static final a a = new a();
  private static final String b = a.class.getSimpleName();
  
  public static void a(Activity paramActivity, String paramString, Serializable paramSerializable)
  {
    Intent localIntent = new Intent(paramActivity, AliTradeWebViewActivity.class);
    localIntent.putExtra("url", paramString);
    if (paramSerializable != null) {
      localIntent.putExtra("ui_contextParams", paramSerializable);
    }
    paramActivity.startActivityForResult(localIntent, com.alibaba.nb.android.trade.utils.e.b.d);
  }
  
  public final void a(String paramString, WebView paramWebView, WebViewClient paramWebViewClient, Map<String, Object> paramMap)
  {
    AliTradeContext.executorService.b(new b(this, paramWebView, paramMap, paramWebViewClient, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */