package com.xiaoenai.app.classes.home.a;

import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import java.util.Comparator;

class w
  implements Comparator<DynamicNotification>
{
  w(o paramo) {}
  
  public int a(DynamicNotification paramDynamicNotification1, DynamicNotification paramDynamicNotification2)
  {
    if (paramDynamicNotification1.getUpdated_at() > paramDynamicNotification2.getUpdated_at()) {
      return -1;
    }
    if (paramDynamicNotification1.getUpdated_at() < paramDynamicNotification2.getUpdated_at()) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */