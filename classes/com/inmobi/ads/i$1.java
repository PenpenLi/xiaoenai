package com.inmobi.ads;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

class i$1
  implements ComponentCallbacks2
{
  i$1(i parami) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt == 80) || (paramInt == 15)) {
      i.a(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\i$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */