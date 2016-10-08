package com.unionpay.mobile.android.net;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class b
  implements X509TrustManager
{
  private X509TrustManager a = null;
  
  public b()
  {
    Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject).init(null);
    localObject = ((TrustManagerFactory)localObject).getTrustManagers();
    if (localObject.length == 0) {
      throw new NoSuchAlgorithmException("no trust manager found");
    }
    this.a = ((X509TrustManager)localObject[0]);
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    try
    {
      paramString = paramArrayOfX509Certificate[0].getIssuerX500Principal();
      if ((!paramString.getName().equals(HttpNative.a().getIssuer(0))) && (!paramString.getName().equals(HttpNative.a().getIssuer(1))) && (!paramString.getName().equals(HttpNative.a().getIssuer(2)))) {
        throw new CertificateException();
      }
    }
    catch (Exception paramArrayOfX509Certificate)
    {
      throw new CertificateException();
    }
    paramArrayOfX509Certificate = paramArrayOfX509Certificate[0].getSubjectX500Principal();
    if ((!paramArrayOfX509Certificate.getName().equals(HttpNative.a().getSubject(0))) && (!paramArrayOfX509Certificate.getName().equals(HttpNative.a().getSubject(1))) && (!paramArrayOfX509Certificate.getName().equals(HttpNative.a().getSubject(2)))) {
      throw new CertificateException();
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\net\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */