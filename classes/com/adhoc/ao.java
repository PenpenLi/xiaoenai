package com.adhoc;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class ao
{
  public static final ao a = new a().a();
  private final Map<String, Set<er>> b;
  
  private ao(a parama)
  {
    this.b = cb.a(a.a(parama));
  }
  
  private static er a(X509Certificate paramX509Certificate)
  {
    return cb.a(er.a(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha1/" + a((X509Certificate)paramCertificate).b();
  }
  
  Set<er> a(String paramString)
  {
    Set localSet = (Set)this.b.get(paramString);
    int i = paramString.indexOf('.');
    if (i != paramString.lastIndexOf('.')) {}
    for (paramString = (Set)this.b.get("*." + paramString.substring(i + 1));; paramString = null)
    {
      Object localObject;
      if ((localSet == null) && (paramString == null)) {
        localObject = null;
      }
      do
      {
        return (Set<er>)localObject;
        if ((localSet != null) && (paramString != null))
        {
          localObject = new LinkedHashSet();
          ((Set)localObject).addAll(localSet);
          ((Set)localObject).addAll(paramString);
          return (Set<er>)localObject;
        }
        localObject = localSet;
      } while (localSet != null);
      return paramString;
    }
  }
  
  public void a(String paramString, List<Certificate> paramList)
  {
    int j = 0;
    Set localSet = a(paramString);
    if (localSet == null) {
      return;
    }
    int k = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label67;
      }
      if (localSet.contains(a((X509Certificate)paramList.get(i)))) {
        break;
      }
      i += 1;
    }
    label67:
    StringBuilder localStringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    k = paramList.size();
    i = j;
    while (i < k)
    {
      X509Certificate localX509Certificate = (X509Certificate)paramList.get(i);
      localStringBuilder.append("\n    ").append(a(localX509Certificate)).append(": ").append(localX509Certificate.getSubjectDN().getName());
      i += 1;
    }
    localStringBuilder.append("\n  Pinned certificates for ").append(paramString).append(":");
    paramString = localSet.iterator();
    while (paramString.hasNext())
    {
      paramList = (er)paramString.next();
      localStringBuilder.append("\n    sha1/").append(paramList.b());
    }
    throw new SSLPeerUnverifiedException(localStringBuilder.toString());
  }
  
  public static final class a
  {
    private final Map<String, Set<er>> a = new LinkedHashMap();
    
    public ao a()
    {
      return new ao(this, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */