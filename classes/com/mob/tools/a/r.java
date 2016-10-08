package com.mob.tools.a;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class r
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext a = SSLContext.getInstance("TLS");
  
  public r(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    paramKeyStore = new s(this);
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public void a()
  {
    setHostnameVerifier(ALLOW_ALL_HOSTNAME_VERIFIER);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */