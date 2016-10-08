package com.inmobi.rendering.a;

import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class c$4
  implements c.d
{
  c$4(c paramc) {}
  
  public void a(a parama)
  {
    if (parama != null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Processing click (" + parama.a + ") completed");
      c.f().b(parama);
    }
  }
  
  public void a(a parama, NetworkError.ErrorCode paramErrorCode)
  {
    if (parama != null)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Pinging click (" + parama.a + ") failed! Updating retry counts and timestamps ...");
      c.a(this.a, parama);
      this.a.b();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\c$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */