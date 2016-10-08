package com.alibaba.nb.android.trade.utils.g;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;

public final class a
{
  private static String[] a = { "awp/base/order.htm", "/awp/base/bag.htm", "a.m.tmall.com" };
  
  public static boolean a(WebView paramWebView)
  {
    if (paramWebView == null) {}
    while ((!paramWebView.canGoBack()) || (1 == c(paramWebView))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString != null) {
      return paramString.contains(".taobao.com");
    }
    return false;
  }
  
  public static void b(WebView paramWebView)
  {
    paramWebView.goBackOrForward(c(paramWebView));
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if (!paramString.contains(".tmall.com"))
      {
        bool1 = bool2;
        if (!paramString.contains(".tmall.hk")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int c(WebView paramWebView)
  {
    int k = 1;
    paramWebView = paramWebView.copyBackForwardList();
    int i = paramWebView.getCurrentIndex() - 1;
    for (;;)
    {
      int j = k;
      if (i >= 0)
      {
        String str = paramWebView.getItemAtIndex(i).getUrl();
        String[] arrayOfString = a;
        int m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label89;
        }
        if (!str.contains(arrayOfString[j])) {
          break label80;
        }
      }
      label80:
      label89:
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label95;
        }
        j = i - paramWebView.getCurrentIndex();
        return j;
        j += 1;
        break;
      }
      label95:
      i -= 1;
    }
  }
  
  public static boolean c(String paramString)
  {
    if (paramString != null) {
      return paramString.contains(".alipay.com");
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    if (paramString != null) {
      return paramString.contains(".etao.com");
    }
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */