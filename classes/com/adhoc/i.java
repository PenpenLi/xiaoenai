package com.adhoc;

import android.content.Context;
import com.adhoc.adhocsdk.AdhocTracker;

public final class i
  implements Runnable
{
  public i(Context paramContext, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = a.a(this.a).b();
      if (!AdhocTracker.client_id.equals(str)) {
        a.a(this.a).a(this.b);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */