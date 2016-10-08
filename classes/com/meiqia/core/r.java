package com.meiqia.core;

import android.content.Context;
import android.content.Intent;
import com.meiqia.core.b.j;
import com.meiqia.core.c.a;
import com.meiqia.core.c.c;
import com.meiqia.core.c.e;
import java.util.List;

class r
  implements as.a
{
  r(ah paramah, List paramList, as.a parama) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 20004) || (paramInt == 19998))
    {
      Intent localIntent = new Intent(ah.c(this.c), MeiQiaService.class);
      localIntent.setAction("ACTION_OPEN_SOCKET");
      ah.c(this.c).startService(localIntent);
      if (paramInt == 19998) {
        this.c.a(false);
      }
    }
    if (this.b != null) {
      this.b.a(paramInt, paramString);
    }
  }
  
  public void a(boolean paramBoolean, a parama, c paramc, List<e> paramList)
  {
    if ((paramList != null) && (this.a != null)) {
      paramList.addAll(0, this.a);
    }
    this.c.a(paramBoolean);
    if (!paramBoolean)
    {
      ah.a(this.c).a(true);
      this.c.a(parama);
      ah.a(this.c, paramc);
      ah.b(this.c).b(paramList);
    }
    ah.a(this.c, this.b);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */