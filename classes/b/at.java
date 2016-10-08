package b;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class at
{
  final a a;
  final Proxy b;
  final InetSocketAddress c;
  
  public at(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (parama == null) {
      throw new NullPointerException("address == null");
    }
    if (paramProxy == null) {
      throw new NullPointerException("proxy == null");
    }
    if (paramInetSocketAddress == null) {
      throw new NullPointerException("inetSocketAddress == null");
    }
    this.a = parama;
    this.b = paramProxy;
    this.c = paramInetSocketAddress;
  }
  
  public a a()
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
    return (this.a.i != null) && (this.b.type() == Proxy.Type.HTTP);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof at))
    {
      paramObject = (at)paramObject;
      bool1 = bool2;
      if (this.a.equals(((at)paramObject).a))
      {
        bool1 = bool2;
        if (this.b.equals(((at)paramObject).b))
        {
          bool1 = bool2;
          if (this.c.equals(((at)paramObject).c)) {
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\b\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */