package com.adhoc;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class av
{
  public static final av a = new a(true).a(f).a(new br[] { br.a, br.b, br.c }).a(true).a();
  public static final av b = new a(a).a(new br[] { br.c }).a(true).a();
  public static final av c = new a(false).a();
  private static final ar[] f = { ar.aK, ar.aO, ar.W, ar.am, ar.al, ar.av, ar.aw, ar.F, ar.E, ar.J, ar.U, ar.D, ar.H, ar.h };
  final boolean d;
  final boolean e;
  private final String[] g;
  private final String[] h;
  
  private av(a parama)
  {
    this.d = a.a(parama);
    this.g = a.b(parama);
    this.h = a.c(parama);
    this.e = a.d(parama);
  }
  
  private static <T> boolean a(T[] paramArrayOfT, T paramT)
  {
    boolean bool2 = false;
    int j = paramArrayOfT.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (cb.a(paramT, paramArrayOfT[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
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
        if (a(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private av b(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.g != null)
    {
      localObject = paramSSLSocket.getEnabledCipherSuites();
      localObject = (String[])cb.a(String.class, this.g, (Object[])localObject);
    }
    if ((paramBoolean) && (Arrays.asList(paramSSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV"))) {
      if (localObject != null)
      {
        String[] arrayOfString = new String[localObject.length + 1];
        System.arraycopy(localObject, 0, arrayOfString, 0, localObject.length);
        arrayOfString[(arrayOfString.length - 1)] = "TLS_FALLBACK_SCSV";
        localObject = arrayOfString;
      }
    }
    for (;;)
    {
      paramSSLSocket = paramSSLSocket.getEnabledProtocols();
      paramSSLSocket = (String[])cb.a(String.class, this.h, paramSSLSocket);
      return new a(this).a((String[])localObject).b(paramSSLSocket).a();
      localObject = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  public List<ar> a()
  {
    if (this.g == null) {
      return null;
    }
    ar[] arrayOfar = new ar[this.g.length];
    int i = 0;
    while (i < this.g.length)
    {
      arrayOfar[i] = ar.a(this.g[i]);
      i += 1;
    }
    return cb.a(arrayOfar);
  }
  
  void a(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Object localObject = b(paramSSLSocket, paramBoolean);
    paramSSLSocket.setEnabledProtocols(((av)localObject).h);
    localObject = ((av)localObject).g;
    if (localObject != null) {
      paramSSLSocket.setEnabledCipherSuites((String[])localObject);
    }
  }
  
  public boolean a(SSLSocket paramSSLSocket)
  {
    if (!this.d) {}
    do
    {
      String[] arrayOfString;
      do
      {
        return false;
        arrayOfString = paramSSLSocket.getEnabledProtocols();
      } while (!a(this.h, arrayOfString));
      if (this.g != null) {
        break;
      }
    } while (paramSSLSocket.getEnabledCipherSuites().length <= 0);
    return true;
    paramSSLSocket = paramSSLSocket.getEnabledCipherSuites();
    return a(this.g, paramSSLSocket);
  }
  
  public List<br> b()
  {
    br[] arrayOfbr = new br[this.h.length];
    int i = 0;
    while (i < this.h.length)
    {
      arrayOfbr[i] = br.a(this.h[i]);
      i += 1;
    }
    return cb.a(arrayOfbr);
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof av)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (av)paramObject;
    } while ((this.d != ((av)paramObject).d) || ((this.d) && ((!Arrays.equals(this.g, ((av)paramObject).g)) || (!Arrays.equals(this.h, ((av)paramObject).h)) || (this.e != ((av)paramObject).e))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (this.d)
    {
      j = Arrays.hashCode(this.g);
      k = Arrays.hashCode(this.h);
      if (!this.e) {
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
    if (this.d)
    {
      Object localObject = a();
      if (localObject == null) {}
      for (localObject = "[use default]";; localObject = localObject.toString()) {
        return "ConnectionSpec(cipherSuites=" + (String)localObject + ", tlsVersions=" + b() + ", supportsTlsExtensions=" + this.e + ")";
      }
    }
    return "ConnectionSpec()";
  }
  
  public static final class a
  {
    private boolean a;
    private String[] b;
    private String[] c;
    private boolean d;
    
    public a(av paramav)
    {
      this.a = paramav.d;
      this.b = av.a(paramav);
      this.c = av.b(paramav);
      this.d = paramav.e;
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
    
    public a a(ar... paramVarArgs)
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
      this.b = arrayOfString;
      return this;
    }
    
    public a a(br... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one TlsVersion is required");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].e;
        i += 1;
      }
      this.c = arrayOfString;
      return this;
    }
    
    public a a(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      if (paramVarArgs == null)
      {
        this.b = null;
        return this;
      }
      this.b = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public av a()
    {
      return new av(this, null);
    }
    
    public a b(String... paramVarArgs)
    {
      if (!this.a) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs == null)
      {
        this.c = null;
        return this;
      }
      this.c = ((String[])paramVarArgs.clone());
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */