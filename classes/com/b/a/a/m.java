package com.b.a.a;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class m
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext a = SSLContext.getInstance("TLS");
  
  public m(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    paramKeyStore = new n(this);
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public static KeyStore a()
  {
    try
    {
      localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localKeyStore.load(null, null);
        return localKeyStore;
      }
      catch (Throwable localThrowable2)
      {
        KeyStore localKeyStore;
        for (;;) {}
      }
      localThrowable1 = localThrowable1;
      localKeyStore = null;
    }
    return localKeyStore;
  }
  
  public static org.apache.http.conn.ssl.SSLSocketFactory b()
  {
    try
    {
      m localm = new m(a());
      localm.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      return localm;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
  }
  
  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */