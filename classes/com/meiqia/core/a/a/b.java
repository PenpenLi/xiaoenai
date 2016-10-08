package com.meiqia.core.a.a;

import com.meiqia.core.a.a.d.d.a;
import com.meiqia.core.a.a.e.h;
import com.meiqia.core.a.a.e.i;
import java.net.InetSocketAddress;

public abstract class b
  implements d
{
  public i a(a parama, com.meiqia.core.a.a.b.a parama1, com.meiqia.core.a.a.e.a parama2)
  {
    return new com.meiqia.core.a.a.e.e();
  }
  
  public void a(a parama, com.meiqia.core.a.a.d.d paramd) {}
  
  public void a(a parama, com.meiqia.core.a.a.e.a parama1) {}
  
  public void a(a parama, com.meiqia.core.a.a.e.a parama1, h paramh) {}
  
  public void b(a parama, com.meiqia.core.a.a.d.d paramd)
  {
    paramd = new com.meiqia.core.a.a.d.e(paramd);
    paramd.a(d.a.e);
    parama.a(paramd);
  }
  
  public String c(a parama)
  {
    parama = parama.a();
    if (parama == null) {
      throw new com.meiqia.core.a.a.c.d("socket not bound");
    }
    StringBuffer localStringBuffer = new StringBuffer(90);
    localStringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
    localStringBuffer.append(parama.getPort());
    localStringBuffer.append("\" /></cross-domain-policy>\000");
    return localStringBuffer.toString();
  }
  
  public void c(a parama, com.meiqia.core.a.a.d.d paramd) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */