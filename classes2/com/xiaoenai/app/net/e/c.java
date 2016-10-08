package com.xiaoenai.app.net.e;

import com.xiaoenai.app.classes.home.notification.DynamicNotification;
import com.xiaoenai.app.d.v;
import java.util.List;

public class c
{
  private static c a = null;
  private v b = new v();
  
  public static c a()
  {
    if (a == null) {}
    try
    {
      a = new c();
      return a;
    }
    finally {}
  }
  
  public void a(DynamicNotification paramDynamicNotification)
  {
    if (this.b != null) {
      this.b.a(paramDynamicNotification);
    }
  }
  
  public void a(List<DynamicNotification> paramList)
  {
    if (this.b != null) {
      this.b.a(paramList);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\net\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */