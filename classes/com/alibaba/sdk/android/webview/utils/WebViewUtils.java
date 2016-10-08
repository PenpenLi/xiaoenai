package com.alibaba.sdk.android.webview.utils;

import com.alibaba.sdk.android.AlibabaSDK;

public class WebViewUtils
{
  public static boolean isLoginDowngraded()
  {
    return ("T".equals(AlibabaSDK.getGlobalProperty("DEGRADE_NOT_LOGIN"))) || ("T".equals(AlibabaSDK.getGlobalProperty("AUTO_DEGRADE_NOT_LOGIN")));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\utils\WebViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */