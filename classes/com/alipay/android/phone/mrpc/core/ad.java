package com.alipay.android.phone.mrpc.core;

import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class ad
  implements HttpRequestRetryHandler
{
  static final String a = ad.class.getSimpleName();
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    if (paramInt >= 3) {}
    do
    {
      return false;
      if ((paramIOException instanceof NoHttpResponseException))
      {
        paramIOException = a;
        return true;
      }
    } while (((!(paramIOException instanceof SocketException)) && (!(paramIOException instanceof SSLException))) || (paramIOException.getMessage() == null) || (!paramIOException.getMessage().contains("Broken pipe")));
    paramIOException = a;
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\android\phone\mrpc\core\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */