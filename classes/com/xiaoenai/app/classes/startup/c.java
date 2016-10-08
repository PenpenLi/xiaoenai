package com.xiaoenai.app.classes.startup;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

class c
  implements View.OnClickListener
{
  c(LauncherActivity paramLauncherActivity) {}
  
  public void onClick(View paramView)
  {
    LauncherActivity.e(this.a).removeCallbacks(this.a.b);
    LauncherActivity.e(this.a).removeCallbacks(this.a.a);
    LauncherActivity.e(this.a).post(this.a.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\startup\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */