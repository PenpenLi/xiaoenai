package com.meiqia.core;

import android.content.Context;
import android.content.Intent;
import com.meiqia.core.c.e;
import com.meiqia.core.d.n;

class y
  implements n
{
  y(x paramx) {}
  
  public void a(e parame, int paramInt)
  {
    Intent localIntent = new Intent(ah.c(this.a.c), MeiQiaService.class);
    localIntent.setAction("ACTION_OPEN_SOCKET");
    ah.c(this.a.c).startService(localIntent);
    this.a.b.a(parame, paramInt);
  }
  
  public void a(e parame, int paramInt, String paramString)
  {
    this.a.b.a(parame, paramInt, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */