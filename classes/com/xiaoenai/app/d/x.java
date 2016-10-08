package com.xiaoenai.app.d;

import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import java.util.List;

class x
  implements Runnable
{
  x(v paramv, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      DynamicNotification localDynamicNotification = (DynamicNotification)this.a.get(i);
      v.a(this.b, localDynamicNotification);
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\d\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */