package b.a;

import b.o;
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

public final class a
{
  private final List<o> a;
  private int b = 0;
  private boolean c;
  private boolean d;
  
  public a(List<o> paramList)
  {
    this.a = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    while (i < this.a.size())
    {
      if (((o)this.a.get(i)).a(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public o a(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    int j = this.a.size();
    o localo;
    if (i < j)
    {
      localo = (o)this.a.get(i);
      if (localo.a(paramSSLSocket)) {
        this.b = (i + 1);
      }
    }
    for (;;)
    {
      if (localo == null)
      {
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        i += 1;
        break;
      }
      this.c = b(paramSSLSocket);
      d.b.a(localo, paramSSLSocket, this.d);
      return localo;
      localo = null;
    }
  }
  
  public boolean a(IOException paramIOException)
  {
    this.d = true;
    if (!this.c) {}
    while (((paramIOException instanceof ProtocolException)) || ((paramIOException instanceof InterruptedIOException)) || (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) || ((paramIOException instanceof SSLPeerUnverifiedException)) || ((!(paramIOException instanceof SSLHandshakeException)) && (!(paramIOException instanceof SSLProtocolException)))) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */