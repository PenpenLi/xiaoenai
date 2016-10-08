package com.xiaoenai.app.classes.home;

import com.xiaoenai.app.classes.home.a.o;
import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.d.v;
import java.util.Iterator;
import java.util.List;

class k
  implements Runnable
{
  k(HomeActivity paramHomeActivity, v paramv) {}
  
  public void run()
  {
    Object localObject = this.a.b();
    if ((HomeActivity.d(this.b) != null) && (HomeActivity.d(this.b).isVisible())) {
      HomeActivity.d(this.b).a((List)localObject);
    }
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          DynamicNotification localDynamicNotification = (DynamicNotification)((Iterator)localObject).next();
          if (localDynamicNotification == null) {
            break label115;
          }
          i = localDynamicNotification.getCount() + i;
        }
      }
    }
    label115:
    for (;;)
    {
      break;
      this.b.e(i);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */