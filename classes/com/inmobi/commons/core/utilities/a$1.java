package com.inmobi.commons.core.utilities;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class a$1
  implements InvocationHandler
{
  private final Handler b = new a.a(a.d().getLooper());
  
  a$1(a parama) {}
  
  public void a(Activity paramActivity)
  {
    this.b.sendEmptyMessageDelayed(1001, 3000L);
  }
  
  public void b(Activity paramActivity)
  {
    this.b.removeMessages(1001);
    this.b.sendEmptyMessage(1002);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (!paramMethod.getName().equals("onActivityPaused")) {
        break label28;
      }
      a((Activity)paramArrayOfObject[0]);
    }
    label28:
    while (!paramMethod.getName().equals("onActivityResumed")) {
      return null;
    }
    b((Activity)paramArrayOfObject[0]);
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */