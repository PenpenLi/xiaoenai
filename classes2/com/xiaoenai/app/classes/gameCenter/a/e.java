package com.xiaoenai.app.classes.gameCenter.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import java.util.List;

class e
  implements k.a
{
  e(a parama, int paramInt) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    com.xiaoenai.app.widget.remindButton.a.a().b(((GameEntry)a.a(this.b).get(this.a)).getRedHintsInfo());
    paramk = ((GameEntry)a.a(this.b).get(this.a)).getDownloadUrl();
    if (paramk != null)
    {
      paramk = new Intent("android.intent.action.VIEW", Uri.parse(paramk));
      a.b(this.b).startActivity(paramk);
      return;
    }
    h.c(a.b(this.b), 2131100139, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */