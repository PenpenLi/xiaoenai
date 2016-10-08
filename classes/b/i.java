package b;

import b.a.d.b;
import b.a.d.f;
import b.a.j;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class i
{
  public static final i a = new a().a();
  private final List<b> b;
  private final f c;
  
  private i(a parama)
  {
    this.b = j.a(a.a(parama));
    this.c = a.b(parama);
  }
  
  static c.i a(X509Certificate paramX509Certificate)
  {
    return j.a(c.i.a(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  public static String a(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
    return "sha256/" + b((X509Certificate)paramCertificate).b();
  }
  
  static c.i b(X509Certificate paramX509Certificate)
  {
    return j.b(c.i.a(paramX509Certificate.getPublicKey().getEncoded()));
  }
  
  a a()
  {
    return new a(this);
  }
  
  List<b> a(String paramString)
  {
    Object localObject1 = Collections.emptyList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.a(paramString))
      {
        Object localObject2 = localObject1;
        if (((List)localObject1).isEmpty()) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).add(localb);
        localObject1 = localObject2;
      }
    }
    return (List<b>)localObject1;
  }
  
  public void a(String paramString, List<Certificate> paramList)
  {
    List localList = a(paramString);
    if (localList.isEmpty()) {
      return;
    }
    Object localObject3 = paramList;
    if (this.c != null) {
      localObject3 = new b(this.c).a(paramList);
    }
    int k = ((List)localObject3).size();
    int i = 0;
    Object localObject1;
    for (;;)
    {
      if (i >= k) {
        break label228;
      }
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject3).get(i);
      int m = localList.size();
      j = 0;
      paramList = null;
      localObject1 = null;
      if (j < m)
      {
        b localb = (b)localList.get(j);
        Object localObject2;
        if (localb.b.equals("sha256/"))
        {
          localObject2 = paramList;
          if (paramList == null) {
            localObject2 = b(localX509Certificate);
          }
          if (localb.c.equals(localObject2)) {
            break;
          }
          paramList = (List<Certificate>)localObject2;
        }
        do
        {
          j += 1;
          break;
          if (!localb.b.equals("sha1/")) {
            break label211;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(localX509Certificate);
          }
          localObject1 = localObject2;
        } while (!localb.c.equals(localObject2));
        return;
        label211:
        throw new AssertionError();
      }
      i += 1;
    }
    label228:
    paramList = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
    int j = ((List)localObject3).size();
    i = 0;
    while (i < j)
    {
      localObject1 = (X509Certificate)((List)localObject3).get(i);
      paramList.append("\n    ").append(a((Certificate)localObject1)).append(": ").append(((X509Certificate)localObject1).getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ").append(paramString).append(":");
    j = localList.size();
    i = 0;
    while (i < j)
    {
      paramString = (b)localList.get(i);
      paramList.append("\n    ").append(paramString);
      i += 1;
    }
    throw new SSLPeerUnverifiedException(paramList.toString());
  }
  
  public static final class a
  {
    private final List<i.b> a = new ArrayList();
    private f b;
    
    public a() {}
    
    a(i parami)
    {
      this.a.addAll(i.a(parami));
      this.b = i.b(parami);
    }
    
    public a a(f paramf)
    {
      this.b = paramf;
      return this;
    }
    
    public i a()
    {
      return new i(this, null);
    }
  }
  
  static final class b
  {
    final String a;
    final String b;
    final c.i c;
    
    boolean a(String paramString)
    {
      boolean bool2 = false;
      if (this.a.equals(paramString)) {
        return true;
      }
      int i = paramString.indexOf('.');
      boolean bool1 = bool2;
      if (this.a.startsWith("*."))
      {
        bool1 = bool2;
        if (paramString.regionMatches(false, i + 1, this.a, 2, this.a.length() - 2)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof b)) && (this.a.equals(((b)paramObject).a)) && (this.b.equals(((b)paramObject).b)) && (this.c.equals(((b)paramObject).c));
    }
    
    public int hashCode()
    {
      return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
    }
    
    public String toString()
    {
      return this.b + this.c.b();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */