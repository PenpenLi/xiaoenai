package com.meiqia.core;

import android.content.Context;
import android.content.Intent;

class s
  implements Runnable
{
  s(ah paramah, as.a parama) {}
  
  public void run()
  {
    if (this.a != null) {
      a.a(ah.c(this.b)).b(Long.MAX_VALUE, 10, new t(this));
    }
    Intent localIntent = new Intent(ah.c(this.b), MeiQiaService.class);
    localIntent.setAction("ACTION_OPEN_SOCKET");
    ah.c(this.b).startService(localIntent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */