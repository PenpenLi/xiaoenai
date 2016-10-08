package com.inmobi.rendering.a;

import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;

class c$a$2
  implements c.d
{
  c$a$2(c.a parama) {}
  
  public void a(a parama)
  {
    c.a.a(this.a, parama);
  }
  
  public void a(a parama, NetworkError.ErrorCode paramErrorCode)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, c.e(), "Pinging click (" + parama.a + ") via WebView failed ...");
    c.a(this.a.a, parama);
    c.a.b(this.a, parama);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\c$a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */