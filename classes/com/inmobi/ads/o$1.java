package com.inmobi.ads;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.HashMap;
import java.util.Map;

class o$1
  implements Runnable
{
  o$1(o paramo) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    String str = this.a.j();
    if (str != null) {
      localHashMap.put("impId", str);
    }
    a.a().a("ads", "ShowInt", localHashMap);
    if (!this.a.z())
    {
      Logger.a(Logger.InternalLogLevel.ERROR, o.B(), "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
      this.a.d("ShowIntBeforeReady");
      return;
    }
    localHashMap.put("type", this.a.a());
    a.a().a("ads", "AdRendered", localHashMap);
    this.a.a(AdUnit.AdState.STATE_RENDERED);
    this.a.y();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\o$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */