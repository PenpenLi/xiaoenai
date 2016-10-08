package com.xiaoenai.app.classes.lock;

import android.widget.ImageView;

class k
  implements Runnable
{
  k(LockSettingOpenActivity paramLockSettingOpenActivity) {}
  
  public void run()
  {
    LockSettingOpenActivity.b(this.a).setImageResource(0);
    LockSettingOpenActivity.c(this.a).setImageResource(0);
    LockSettingOpenActivity.d(this.a).setImageResource(0);
    LockSettingOpenActivity.e(this.a).setImageResource(0);
    LockSettingOpenActivity.a(this.a, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\lock\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */