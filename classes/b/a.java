package b;

import b.a.j;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a
{
  final ab a;
  final u b;
  final SocketFactory c;
  final b d;
  final List<ai> e;
  final List<o> f;
  final ProxySelector g;
  final Proxy h;
  final SSLSocketFactory i;
  final HostnameVerifier j;
  final i k;
  
  public a(String paramString, int paramInt, u paramu, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, i parami, b paramb, Proxy paramProxy, List<ai> paramList, List<o> paramList1, ProxySelector paramProxySelector)
  {
    ab.a locala = new ab.a();
    if (paramSSLSocketFactory != null) {}
    for (String str = "https";; str = "http")
    {
      this.a = locala.a(str).b(paramString).a(paramInt).c();
      if (paramu != null) {
        break;
      }
      throw new IllegalArgumentException("dns == null");
    }
    this.b = paramu;
    if (paramSocketFactory == null) {
      throw new IllegalArgumentException("socketFactory == null");
    }
    this.c = paramSocketFactory;
    if (paramb == null) {
      throw new IllegalArgumentException("proxyAuthenticator == null");
    }
    this.d = paramb;
    if (paramList == null) {
      throw new IllegalArgumentException("protocols == null");
    }
    this.e = j.a(paramList);
    if (paramList1 == null) {
      throw new IllegalArgumentException("connectionSpecs == null");
    }
    this.f = j.a(paramList1);
    if (paramProxySelector == null) {
      throw new IllegalArgumentException("proxySelector == null");
    }
    this.g = paramProxySelector;
    this.h = paramProxy;
    this.i = paramSSLSocketFactory;
    this.j = paramHostnameVerifier;
    this.k = parami;
  }
  
  public ab a()
  {
    return this.a;
  }
  
  public u b()
  {
    return this.b;
  }
  
  public SocketFactory c()
  {
    return this.c;
  }
  
  public b d()
  {
    return this.d;
  }
  
  public List<ai> e()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (this.a.equals(((a)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((a)paramObject).b))
        {
          bool1 = bool2;
          if (this.d.equals(((a)paramObject).d))
          {
            bool1 = bool2;
            if (this.e.equals(((a)paramObject).e))
            {
              bool1 = bool2;
              if (this.f.equals(((a)paramObject).f))
              {
                bool1 = bool2;
                if (this.g.equals(((a)paramObject).g))
                {
                  bool1 = bool2;
                  if (j.a(this.h, ((a)paramObject).h))
                  {
                    bool1 = bool2;
                    if (j.a(this.i, ((a)paramObject).i))
                    {
                      bool1 = bool2;
                      if (j.a(this.j, ((a)paramObject).j))
                      {
                        bool1 = bool2;
                        if (j.a(this.k, ((a)paramObject).k)) {
                          bool1 = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public List<o> f()
  {
    return this.f;
  }
  
  public ProxySelector g()
  {
    return this.g;
  }
  
  public Proxy h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    int i3 = this.a.hashCode();
    int i4 = this.b.hashCode();
    int i5 = this.d.hashCode();
    int i6 = this.e.hashCode();
    int i7 = this.f.hashCode();
    int i8 = this.g.hashCode();
    int m;
    int n;
    if (this.h != null)
    {
      m = this.h.hashCode();
      if (this.i == null) {
        break label185;
      }
      n = this.i.hashCode();
      label91:
      if (this.j == null) {
        break label190;
      }
    }
    label185:
    label190:
    for (int i1 = this.j.hashCode();; i1 = 0)
    {
      if (this.k != null) {
        i2 = this.k.hashCode();
      }
      return (i1 + (n + (m + ((((((i3 + 527) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31) * 31) * 31 + i2;
      m = 0;
      break;
      n = 0;
      break label91;
    }
  }
  
  public SSLSocketFactory i()
  {
    return this.i;
  }
  
  public HostnameVerifier j()
  {
    return this.j;
  }
  
  public i k()
  {
    return this.k;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */