package com.xiaoenai.app.classes.gameCenter;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.xiaoenai.app.classes.gameCenter.model.GameInfoEntry;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class h
  implements k.a
{
  h(GameItemActivity paramGameItemActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    paramk = GameItemActivity.c(this.a).getDownload_url();
    if (paramk != null)
    {
      paramk = new Intent("android.intent.action.VIEW", Uri.parse(paramk));
      this.a.startActivity(paramk);
      return;
    }
    com.xiaoenai.app.ui.a.h.c(this.a, 2131100139, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */