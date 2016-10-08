package com.inmobi.rendering.a;

import android.os.Handler;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.network.e;

class c$b$1
  implements Runnable
{
  c$b$1(c.b paramb, a parama, Handler paramHandler) {}
  
  public void run()
  {
    new e(new NetworkRequest(NetworkRequest.RequestType.GET, this.a.b, false, null), new c.b.1.1(this)).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\a\c$b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */