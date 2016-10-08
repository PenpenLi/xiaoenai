package com.meiqia.core;

import android.content.Context;
import android.content.Intent;
import com.meiqia.core.b.g;
import com.meiqia.core.b.j;
import com.meiqia.core.b.l;
import com.meiqia.core.c.e;
import java.util.ArrayList;
import java.util.List;

class n
{
  private static n a;
  private final j b;
  private final ab c;
  private final b d;
  private Context e;
  private List<String> f;
  
  private n(Context paramContext)
  {
    this.e = paramContext;
    this.b = new j(paramContext);
    this.c = new ab(paramContext);
    this.d = b.a(paramContext);
    this.f = new ArrayList();
  }
  
  public static n a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new n(paramContext.getApplicationContext());
      }
      return a;
    }
    finally {}
  }
  
  private void b(e parame)
  {
    this.c.a(parame);
    this.b.a(parame.e());
    this.b.c(parame.h());
  }
  
  private boolean c(e parame)
  {
    return (parame != null) && (!this.c.b(parame)) && (!d(parame));
  }
  
  private boolean d(e parame)
  {
    parame = String.valueOf(parame.h());
    if (this.f.contains(parame)) {
      return true;
    }
    this.f.add(parame);
    if (this.f.size() > 5) {
      this.f.remove(this.f.size() - 1);
    }
    return false;
  }
  
  private void e(e parame)
  {
    this.d.a(parame);
    Intent localIntent = new Intent("new_msg_received_action");
    localIntent.putExtra("msgId", String.valueOf(parame.h()));
    l.a(this.e, localIntent);
    g.b("newMsg received : type = " + parame.c() + "  content = " + parame.b());
  }
  
  public void a(e parame)
  {
    if (!c(parame)) {
      return;
    }
    b(parame);
    e(parame);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */