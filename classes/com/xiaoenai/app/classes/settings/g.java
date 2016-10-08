package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.DebugActivity;

class g
  implements View.OnClickListener
{
  g(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent(this.a, DebugActivity.class));
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */