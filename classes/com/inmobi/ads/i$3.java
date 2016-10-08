package com.inmobi.ads;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  public void run()
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, i.d(), "Flushing ad unit cache due to low memory.");
    Iterator localIterator = i.e().entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((AdUnit)((Map.Entry)localIterator.next()).getValue()).t();
      localIterator.remove();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\i$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */