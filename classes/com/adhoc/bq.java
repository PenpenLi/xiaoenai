package com.adhoc;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class bq
{
  final ag a;
  final Proxy b;
  final InetSocketAddress c;
  
  public bq(ag paramag, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramag == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    this.a = paramag;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
  }
  
  public ag a()
  {
    return this.a;
  }
  
  public Proxy b()
  {
    return this.b;
  }
  
  public InetSocketAddress c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.a.e != null) && (this.b.type() == Proxy.Type.HTTP);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bq))
    {
      paramObject = (bq)paramObject;
      bool1 = bool2;
      if (this.a.equals(((bq)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((bq)paramObject).b))
        {
          bool1 = bool2;
          if (this.c.equals(((bq)paramObject).c)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return ((this.a.hashCode() + 527) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */