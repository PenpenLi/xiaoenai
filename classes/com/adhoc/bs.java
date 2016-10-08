package com.adhoc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class bs
{
  private final List<av> a;
  private int b = 0;
  private boolean c;
  private boolean d;
  
  public bs(List<av> paramList)
  {
    this.a = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    while (i < this.a.size())
    {
      if (((av)this.a.get(i)).a(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public av a(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    int j = this.a.size();
    av localav;
    if (i < j)
    {
      localav = (av)this.a.get(i);
      if (localav.a(paramSSLSocket)) {
        this.b = (i + 1);
      }
    }
    for (;;)
    {
      if (localav == null)
      {
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        i += 1;
        break;
      }
      this.c = b(paramSSLSocket);
      bt.b.a(localav, paramSSLSocket, this.d);
      return localav;
      localav = null;
    }
  }
  
  public boolean a(IOException paramIOException)
  {
    boolean bool = true;
    this.d = true;
    if ((paramIOException instanceof ProtocolException)) {}
    while (((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException))) {
      return false;
    }
    if ((((paramIOException instanceof SSLHandshakeException)) || ((paramIOException instanceof SSLProtocolException))) && (this.c)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */