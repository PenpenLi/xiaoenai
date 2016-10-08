package com.meiqia.core;

import android.content.Context;
import android.content.Intent;
import com.meiqia.core.b.l;
import com.meiqia.core.c.a;
import com.meiqia.core.c.c;
import com.meiqia.core.c.e;
import com.meiqia.core.d.n;
import java.util.List;

class x
  implements as.a
{
  x(ah paramah, e parame, n paramn) {}
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      this.a.g("failed");
      ah.b(this.c).a(this.a);
      if (this.b != null) {
        this.b.a(this.a, paramInt, paramString);
      }
      return;
    }
    this.c.a(null);
    this.c.a(true, this.a, null, this.b);
  }
  
  public void a(boolean paramBoolean, a parama, c paramc, List<e> paramList)
  {
    this.c.a(paramBoolean);
    if (paramBoolean)
    {
      parama = new Intent(ah.c(this.c), MeiQiaService.class);
      parama.setAction("ACTION_OPEN_SOCKET");
      ah.c(this.c).startService(parama);
      this.a.g("failed");
      ah.b(this.c).a(this.a);
      this.b.a(this.a, 20008, null);
      return;
    }
    b.a(ah.c(this.c)).a(parama);
    paramList = new Intent("agent_change_action");
    paramList.putExtra("conversation_id", String.valueOf(paramc.c()));
    l.a(ah.c(this.c), paramList);
    this.c.a(parama);
    ah.b(this.c, this.a, new y(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */