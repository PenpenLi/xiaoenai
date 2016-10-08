package com.alibaba.sdk.android.util;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.httpdns.HttpdnsMini;
import com.alibaba.sdk.android.httpdns.HttpdnsMini.HttpdnsQueryPolicy;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDNSUtils
{
  public static boolean detectIfProxyExist(Context paramContext)
  {
    int i;
    String str;
    if (Build.VERSION.SDK_INT >= 14)
    {
      i = 1;
      if (i == 0) {
        break label59;
      }
      str = System.getProperty("http.proxyHost");
      paramContext = System.getProperty("http.proxyPort");
      if (paramContext == null) {
        break label53;
      }
      label30:
      i = Integer.parseInt(paramContext);
    }
    for (paramContext = str;; paramContext = str)
    {
      if ((paramContext == null) || (i == -1)) {
        break label74;
      }
      return true;
      i = 0;
      break;
      label53:
      paramContext = "-1";
      break label30;
      label59:
      str = Proxy.getHost(paramContext);
      i = Proxy.getPort(paramContext);
    }
    label74:
    return false;
  }
  
  public static HttpURLConnection getHttpURLConnection(String paramString, Context paramContext)
  {
    URL localURL = new URL(paramString);
    if (("true".equals(AlibabaSDK.getProperty("kernel", "disableHttpDNS"))) || (detectIfProxyExist(paramContext)) || ("https".equals(localURL.getProtocol()))) {
      return (HttpURLConnection)localURL.openConnection();
    }
    paramContext = new HttpdnsMini.HttpdnsQueryPolicy();
    paramContext.connectionTimeout = HttpHelper.getConnectionTimeout(3000);
    paramContext.readTimeout = HttpHelper.getReadTimeout(3000);
    paramContext.retryOnFailure = "true".equalsIgnoreCase(AlibabaSDK.getProperty("kernel", "httpDNSRetryOnFailed"));
    paramContext = HttpdnsMini.getInstance().getIpByHost(localURL.getHost(), paramContext);
    if (paramContext != null)
    {
      paramString = (HttpURLConnection)new URL(paramString.replaceFirst(localURL.getHost(), paramContext)).openConnection();
      paramString.setRequestProperty("Host", localURL.getHost());
      return paramString;
    }
    return (HttpURLConnection)localURL.openConnection();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\HttpDNSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */