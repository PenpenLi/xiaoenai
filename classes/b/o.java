package b;

import b.a.j;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class o
{
  public static final o a = new a(true).a(d).a(new au[] { au.a, au.b, au.c }).a(true).a();
  public static final o b = new a(a).a(new au[] { au.c }).a(true).a();
  public static final o c = new a(false).a();
  private static final k[] d = { k.aK, k.aO, k.W, k.am, k.al, k.av, k.aw, k.F, k.J, k.U, k.D, k.H, k.h };
  private final boolean e;
  private final boolean f;
  private final String[] g;
  private final String[] h;
  
  private o(a parama)
  {
    this.e = a.a(parama);
    this.g = a.b(parama);
    this.h = a.c(parama);
    this.f = a.d(parama);
  }
  
  private static boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (j.a(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private o b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (this.g != null)
    {
      arrayOfString1 = (String[])j.a(String.class, this.g, paramSSLSocket.getEnabledCipherSuites());
      if (this.h == null) {
        break label109;
      }
    }
    label109:
    for (String[] arrayOfString2 = (String[])j.a(String.class, this.h, paramSSLSocket.getEnabledProtocols());; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (j.a(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
          arrayOfString3 = j.b(arrayOfString1, "TLS_FALLBACK_SCSV");
        }
      }
      return new a(this).a(arrayOfString3).b(arrayOfString2).a();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    o localo = b(paramSSLSocket, paramBoolean);
    if (localo.h != null) {
      paramSSLSocket.setEnabledProtocols(localo.h);
    }
    if (localo.g != null) {
      paramSSLSocket.setEnabledCipherSuites(localo.g);
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.e) {}
    while (((this.h != null) && (!a(this.h, paramSSLSocket.getEnabledProtocols()))) || ((this.g != null) && (!a(this.g, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public List<k> b()
  {
    if (this.g == null) {
      return null;
    }
    k[] arrayOfk = new k[this.g.length];
    int i = 0;
    while (i < this.g.length)
    {
      arrayOfk[i] = k.a(this.g[i]);
      i += 1;
    }
    return j.a(arrayOfk);
  }
  
  public List<au> c()
  {
    if (this.h == null) {
      return null;
    }
    au[] arrayOfau = new au[this.h.length];
    int i = 0;
    while (i < this.h.length)
    {
      arrayOfau[i] = au.a(this.h[i]);
      i += 1;
    }
    return j.a(arrayOfau);
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof o)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (o)paramObject;
    } while ((this.e != ((o)paramObject).e) || ((this.e) && ((!Arrays.equals(this.g, ((o)paramObject).g)) || (!Arrays.equals(this.h, ((o)paramObject).h)) || (this.f != ((o)paramObject).f))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.e)
    {
      j = Arrays.hashCode(this.g);
      k = Arrays.hashCode(this.h);
      if (!this.f) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i += ((j + 527) * 31 + k) * 31;
      return i;
    }
  }
  
  public String toString()
  {
    if (!this.e) {
      return "ConnectionSpec()";
    }
    String str1;
    if (this.g != null)
    {
      str1 = b().toString();
      if (this.h == null) {
        break label92;
      }
    }
    label92:
    for (String str2 = c().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f + ")";
      str1 = "[all enabled]";
      break;
    }
  }
  
  public static final class a
  {
    private boolean a;
    private String[] b;
    private String[] c;
    private boolean d;
    
    public a(o paramo)
    {
      this.a = o.a(paramo);
      this.b = o.b(paramo);
      this.c = o.c(paramo);
      this.d = o.d(paramo);
    }
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public a a(boolean paramBoolean)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      }
      this.d = paramBoolean;
      return this;
    }
    
    public a a(au... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].e;
        i += 1;
      }
      return b(arrayOfString);
    }
    
    public a a(k... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].aS;
        i += 1;
      }
      return a(arrayOfString);
    }
    
    public a a(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      this.b = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public o a()
    {
      return new o(this, null);
    }
    
    public a b(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      this.c = ((String[])paramVarArgs.clone());
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */