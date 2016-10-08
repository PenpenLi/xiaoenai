package com.xiaoenai.app.classes.gameCenter;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.xiaoenai.app.classes.gameCenter.model.GameInfoEntry;

class d
  implements View.OnClickListener
{
  d(GameItemActivity paramGameItemActivity) {}
  
  public void onClick(View paramView)
  {
    if (GameItemActivity.c(this.a) != null)
    {
      if (GameItemActivity.d(this.a).getText().toString().equals(this.a.getResources().getString(2131100521)))
      {
        paramView = this.a.getPackageManager().getLaunchIntentForPackage(GameItemActivity.c(this.a).getPackageName());
        this.a.startActivity(paramView);
      }
    }
    else {
      return;
    }
    GameItemActivity.a(this.a, GameItemActivity.c(this.a).getName());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */