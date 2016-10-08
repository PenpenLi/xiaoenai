package com.alibaba.sdk.android.webview;

import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;

public class DefaultTaeWebViewHistoryHelper
  implements PropertyChangeListener
{
  private static final String WEBVIEW_HISTORY_CAN_GO_BACK_IGNORE_URLS = "historyCanGoBackIgnoreUrls";
  private static final String WEBVIEW_HISTORY_GO_BACK_IGNORE_URLS = "historyGoBackIgnoreUrls";
  private String[] ignoreHistoryCanGoBackUrls = new String[0];
  private String[] ignoreHistoryGoBackUrls = new String[0];
  private int maxLoopProtectedCount = 5;
  
  public DefaultTaeWebViewHistoryHelper(PluginConfigurations paramPluginConfigurations)
  {
    String str = paramPluginConfigurations.getStringValue("historyGoBackIgnoreUrls", "");
    if (!TextUtils.isEmpty(str)) {
      this.ignoreHistoryGoBackUrls = str.split("[,]");
    }
    str = paramPluginConfigurations.getStringValue("historyCanGoBackIgnoreUrls", "");
    if (!TextUtils.isEmpty(str)) {
      this.ignoreHistoryCanGoBackUrls = str.split("[,]");
    }
    this.maxLoopProtectedCount = paramPluginConfigurations.getIntValue("historyHelperMaxLoopProtectedCount", 5);
    paramPluginConfigurations.registerPropertyChangeListener(this);
  }
  
  private int goBack(WebBackForwardList paramWebBackForwardList, int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    if (paramInt1 <= 0) {}
    label74:
    for (;;)
    {
      return paramInt1;
      int i;
      if (paramInt2 == 1)
      {
        paramInt2 = paramInt1 - 1;
        paramWebBackForwardList = paramWebBackForwardList.getItemAtIndex(paramInt2).getUrl();
        if (paramWebBackForwardList != null)
        {
          i = paramArrayOfString.length;
          paramInt2 = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (paramInt2 >= i) {
            break label74;
          }
          if (paramWebBackForwardList.indexOf(paramArrayOfString[paramInt2]) != -1)
          {
            return paramInt1 - 1;
            paramInt2 = paramInt1;
            break;
          }
          paramInt2 += 1;
        }
      }
    }
  }
  
  public int getNextGoBackIndex(TaeWebView paramTaeWebView, WebBackForwardList paramWebBackForwardList)
  {
    int i = paramWebBackForwardList.getCurrentIndex();
    if (i <= 0) {
      return -1;
    }
    int m = 1;
    int j = 1;
    int n = 1;
    label32:
    int k;
    if (n > this.maxLoopProtectedCount)
    {
      m = i;
      if (m <= 0) {
        return -1;
      }
    }
    else
    {
      if (m == 0) {
        break label177;
      }
      m = goBack(paramWebBackForwardList, i, this.ignoreHistoryGoBackUrls, 1);
      if (m == i) {
        break label163;
      }
      j = 0;
      k = 1;
      i = m;
    }
    for (;;)
    {
      m = i;
      if (i <= 0) {
        break label32;
      }
      if (k != 0)
      {
        k = goBack(paramWebBackForwardList, i, this.ignoreHistoryCanGoBackUrls, 2);
        if (k != i)
        {
          i = k;
          k = 0;
          j = 1;
        }
      }
      for (;;)
      {
        m = i;
        if (i <= 0) {
          break label32;
        }
        if (k == 0)
        {
          m = i;
          if (j == 0) {
            break label32;
          }
        }
        n += 1;
        m = j;
        j = k;
        break;
        return m - 1;
        k = 0;
      }
      label163:
      m = 0;
      k = j;
      j = m;
      continue;
      label177:
      k = j;
      j = m;
    }
  }
  
  public boolean goBack(TaeWebView paramTaeWebView)
  {
    WebBackForwardList localWebBackForwardList = paramTaeWebView.copyBackForwardList();
    int i = getNextGoBackIndex(paramTaeWebView, localWebBackForwardList);
    if (i < 0) {
      return false;
    }
    paramTaeWebView.goBackOrForward(i - localWebBackForwardList.getCurrentIndex());
    return true;
  }
  
  public void propertyChanged(String paramString1, String paramString2, String paramString3)
  {
    if ("historyGoBackIgnoreUrls".equals(paramString1)) {
      if (TextUtils.isEmpty(paramString3))
      {
        paramString1 = new String[0];
        this.ignoreHistoryGoBackUrls = paramString1;
      }
    }
    while (!"historyCanGoBackIgnoreUrls".equals(paramString1)) {
      for (;;)
      {
        return;
        paramString1 = paramString3.split("[,]");
      }
    }
    if (TextUtils.isEmpty(paramString3)) {}
    for (paramString1 = new String[0];; paramString1 = paramString3.split("[,]"))
    {
      this.ignoreHistoryCanGoBackUrls = paramString1;
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\DefaultTaeWebViewHistoryHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */