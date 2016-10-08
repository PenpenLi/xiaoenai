package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import android.content.Intent;

class q
  implements Runnable
{
  q(p paramp) {}
  
  public void run()
  {
    Intent localIntent = new Intent("send_location_action");
    this.a.a.b.getContext().sendBroadcast(localIntent, this.a.a.b.getContext().getString(2131101650));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */