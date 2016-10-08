package com.xiaoenai.app.classes.chat;

import android.view.View;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import com.xiaoenai.app.utils.h.g;

class ba
  implements k.a
{
  ba(az paramaz) {}
  
  public void a(k paramk, View paramView)
  {
    if ((this.a.a instanceof o))
    {
      paramView = g.a().b();
      if ((paramView != null) && (paramView.h() == this.a.a.h())) {
        g.a().c();
      }
    }
    this.a.a.m();
    paramView = new com.xiaoenai.app.net.d.a(av.a(this.a.c));
    int i = this.a.a.d();
    long l = this.a.a.h();
    paramView.a(new Integer[] { Integer.valueOf(i) }, new Long[] { Long.valueOf(l) });
    paramk.dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */