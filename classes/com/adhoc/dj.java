package com.adhoc;

import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;

public final class dj
  implements ah
{
  public static final ah a = new dj();
  
  private InetAddress a(Proxy paramProxy, bc parambc)
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT)) {
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    }
    return InetAddress.getByName(parambc.g());
  }
  
  public bj a(Proxy paramProxy, bn parambn)
  {
    List localList = parambn.j();
    parambn = parambn.a();
    bc localbc = parambn.a();
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (aq)localList.get(i);
      if (!"Basic".equalsIgnoreCase(((aq)localObject).a())) {}
      do
      {
        i += 1;
        break;
        localObject = Authenticator.requestPasswordAuthentication(localbc.g(), a(paramProxy, localbc), localbc.h(), localbc.c(), ((aq)localObject).b(), ((aq)localObject).a(), localbc.a(), Authenticator.RequestorType.SERVER);
      } while (localObject == null);
      paramProxy = ax.a(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
      return parambn.g().a("Authorization", paramProxy).a();
    }
    return null;
  }
  
  public bj b(Proxy paramProxy, bn parambn)
  {
    List localList = parambn.j();
    parambn = parambn.a();
    bc localbc = parambn.a();
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (aq)localList.get(i);
      if (!"Basic".equalsIgnoreCase(((aq)localObject).a())) {}
      do
      {
        i += 1;
        break;
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramProxy.address();
        localObject = Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), a(paramProxy, localbc), localInetSocketAddress.getPort(), localbc.c(), ((aq)localObject).b(), ((aq)localObject).a(), localbc.a(), Authenticator.RequestorType.PROXY);
      } while (localObject == null);
      paramProxy = ax.a(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
      return parambn.g().a("Proxy-Authorization", paramProxy).a();
    }
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */