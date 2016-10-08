package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.i;

public class UTDevice
{
  public static String getUtdid(Context paramContext)
  {
    paramContext = b.b(paramContext);
    if ((paramContext == null) || (i.a(paramContext.f()))) {
      return "ffffffffffffffffffffffff";
    }
    return paramContext.f();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */