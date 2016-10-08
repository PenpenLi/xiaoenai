package com.adhoc;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSession;

public final class az
{
  private final String a;
  private final List<Certificate> b;
  private final List<Certificate> c;
  
  private az(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramString;
    this.b = paramList1;
    this.c = paramList2;
  }
  
  public static az a(SSLSession paramSSLSession)
  {
    String str = paramSSLSession.getCipherSuite();
    if (str == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    try
    {
      Object localObject = paramSSLSession.getPeerCertificates();
      if (localObject != null)
      {
        localObject = cb.a((Object[])localObject);
        paramSSLSession = paramSSLSession.getLocalCertificates();
        if (paramSSLSession == null) {
          break label77;
        }
        paramSSLSession = cb.a(paramSSLSession);
        return new az(str, (List)localObject, paramSSLSession);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        List localList = null;
        continue;
        localList = Collections.emptyList();
        continue;
        label77:
        paramSSLSession = Collections.emptyList();
      }
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public List<Certificate> b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof az)) {}
    do
    {
      return false;
      paramObject = (az)paramObject;
    } while ((!this.a.equals(((az)paramObject).a)) || (!this.b.equals(((az)paramObject).b)) || (!this.c.equals(((az)paramObject).c)));
    return true;
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */