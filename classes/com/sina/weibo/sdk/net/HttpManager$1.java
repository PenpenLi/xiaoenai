package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.utils.LogUtil;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

class HttpManager$1
  implements RedirectHandler
{
  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    LogUtil.d("HttpManager", "openUrl4RdirectURL getLocationURI method");
    return null;
  }
  
  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    LogUtil.d("HttpManager", "openUrl4RdirectURL isRedirectRequested method");
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\net\HttpManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */