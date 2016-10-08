package com.mob.tools.a;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class n
  implements X509TrustManager
{
  n(l paraml) {}
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */