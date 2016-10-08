package com.adhoc;

import java.io.IOException;
import java.net.URI;

public final class bj
{
  private final bc a;
  private final String b;
  private final ba c;
  private final bl d;
  private final Object e;
  private volatile URI f;
  private volatile aj g;
  
  private bj(a parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama).a();
    this.d = a.d(parama);
    if (a.e(parama) != null) {}
    for (parama = a.e(parama);; parama = this)
    {
      this.e = parama;
      return;
    }
  }
  
  public bc a()
  {
    return this.a;
  }
  
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public URI b()
  {
    try
    {
      URI localURI = this.f;
      if (localURI != null) {
        return localURI;
      }
      localURI = this.a.b();
      this.f = localURI;
      return localURI;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      throw new IOException(localIllegalStateException.getMessage());
    }
  }
  
  public String c()
  {
    return this.a.toString();
  }
  
  public String d()
  {
    return this.b;
  }
  
  public ba e()
  {
    return this.c;
  }
  
  public bl f()
  {
    return this.d;
  }
  
  public a g()
  {
    return new a(this, null);
  }
  
  public aj h()
  {
    aj localaj = this.g;
    if (localaj != null) {
      return localaj;
    }
    localaj = aj.a(this.c);
    this.g = localaj;
    return localaj;
  }
  
  public boolean i()
  {
    return this.a.d();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append(this.a).append(", tag=");
    if (this.e != this) {}
    for (Object localObject = this.e;; localObject = null) {
      return localObject + '}';
    }
  }
  
  public static class a
  {
    private bc a;
    private String b;
    private ba.a c;
    private bl d;
    private Object e;
    
    public a()
    {
      this.b = "GET";
      this.c = new ba.a();
    }
    
    private a(bj parambj)
    {
      this.a = bj.a(parambj);
      this.b = bj.b(parambj);
      this.d = bj.c(parambj);
      this.e = bj.d(parambj);
      this.c = bj.e(parambj).b();
    }
    
    public a a(bc parambc)
    {
      if (parambc == null) {
        throw new IllegalArgumentException("url == null");
      }
      this.a = parambc;
      return this;
    }
    
    public a a(bl parambl)
    {
      return a("POST", parambl);
    }
    
    public a a(String paramString)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("url == null");
      }
      String str;
      if (paramString.regionMatches(true, 0, "ws:", 0, 3)) {
        str = "http:" + paramString.substring(3);
      }
      for (;;)
      {
        paramString = bc.d(str);
        if (paramString != null) {
          break;
        }
        throw new IllegalArgumentException("unexpected url: " + str);
        str = paramString;
        if (paramString.regionMatches(true, 0, "wss:", 0, 4)) {
          str = "https:" + paramString.substring(4);
        }
      }
      return a(paramString);
    }
    
    public a a(String paramString, bl parambl)
    {
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IllegalArgumentException("method == null || method.length() == 0");
      }
      if ((parambl != null) && (!dw.c(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      }
      if ((parambl == null) && (dw.b(paramString))) {
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      }
      this.b = paramString;
      this.d = parambl;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public bj a()
    {
      if (this.a == null) {
        throw new IllegalStateException("url == null");
      }
      return new bj(this, null);
    }
    
    public a b(String paramString)
    {
      this.c.b(paramString);
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.c.a(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */