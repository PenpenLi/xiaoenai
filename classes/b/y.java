package b;

import b.a.j;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class y
{
  private final au a;
  private final k b;
  private final List<Certificate> c;
  private final List<Certificate> d;
  
  private y(au paramau, k paramk, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramau;
    this.b = paramk;
    this.c = paramList1;
    this.d = paramList2;
  }
  
  public static y a(SSLSession paramSSLSession)
  {
    Object localObject = paramSSLSession.getCipherSuite();
    if (localObject == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    k localk = k.a((String)localObject);
    localObject = paramSSLSession.getProtocol();
    if (localObject == null) {
      throw new IllegalStateException("tlsVersion == null");
    }
    au localau = au.a((String)localObject);
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = j.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label109;
        }
        paramSSLSession = j.a(paramSSLSession);
        return new y(localau, localk, (List)localObject, paramSSLSession);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label109:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public k a()
  {
    return this.b;
  }
  
  public List<Certificate> b()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof y)) {}
    do
    {
      return false;
      paramObject = (y)paramObject;
    } while ((!j.a(this.b, ((y)paramObject).b)) || (!this.b.equals(((y)paramObject).b)) || (!this.c.equals(((y)paramObject).c)) || (!this.d.equals(((y)paramObject).d)));
    return true;
  }
  
  public int hashCode()
  {
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0) {
      return (((i + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */