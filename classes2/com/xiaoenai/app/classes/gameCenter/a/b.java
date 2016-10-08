package com.xiaoenai.app.classes.gameCenter.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.gameCenter.WebGameActivity;
import com.xiaoenai.app.classes.gameCenter.model.GameEntry;
import java.util.List;

class b
  implements View.OnClickListener
{
  b(a parama, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = (GameEntry)a.a(this.b).get(this.a);
    if (paramView.getStartType() == 0) {
      if (paramView.getDownload_state() == 1)
      {
        com.xiaoenai.app.widget.remindButton.a.a().b(paramView.getRedHintsInfo());
        a.a(this.b, paramView.getMpackage());
      }
    }
    do
    {
      do
      {
        return;
        a.a(this.b, this.a, paramView.getName());
        return;
      } while (((GameEntry)a.a(this.b).get(this.a)).getStartType() != 1);
      com.xiaoenai.app.widget.remindButton.a.a().b(paramView.getRedHintsInfo());
    } while (((GameEntry)a.a(this.b).get(this.a)).getLoginUrl() == null);
    paramView = new Intent();
    paramView.setClass(a.b(this.b), WebGameActivity.class);
    paramView.putExtra("url", ((GameEntry)a.a(this.b).get(this.a)).getLoginUrl());
    paramView.putExtra("title", ((GameEntry)a.a(this.b).get(this.a)).getName());
    paramView.putExtra("has_refresh_button", false);
    a.b(this.b).startActivity(paramView);
    ((Activity)a.b(this.b)).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\gameCenter\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */