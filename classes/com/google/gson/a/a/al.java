package com.google.gson.a.a;

import com.google.gson.af;
import com.google.gson.c.a;
import com.google.gson.c.c;
import com.google.gson.c.d;
import java.net.InetAddress;

final class al
  extends af<InetAddress>
{
  public InetAddress a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return InetAddress.getByName(parama.h());
  }
  
  public void a(d paramd, InetAddress paramInetAddress)
  {
    if (paramInetAddress == null) {}
    for (paramInetAddress = null;; paramInetAddress = paramInetAddress.getHostAddress())
    {
      paramd.b(paramInetAddress);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\google\gson\a\a\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */