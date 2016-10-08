package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

class bk
  implements View.OnClickListener
{
  bk(UpdateActivity paramUpdateActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131559778: 
    default: 
      return;
    case 2131559779: 
      try
      {
        paramView = new Intent();
        paramView.setAction("android.intent.action.VIEW");
        paramView.setFlags(268435456);
        paramView.setData(Uri.parse("http://xiaoenai.com/"));
        this.a.startActivity(paramView);
        this.a.overridePendingTransition(2130968604, 2130968605);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    UpdateActivity.a(this.a, UpdateActivity.a(this.a));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */