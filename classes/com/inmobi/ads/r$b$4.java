package com.inmobi.ads;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Iterator;
import java.util.List;

 enum r$b$4
{
  r$b$4(String paramString1)
  {
    super(paramString, paramInt, paramString1, null);
  }
  
  void a(r paramr)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, r.k(), "Entering state:" + this);
    r.a(paramr, r.b.d);
    r.l(paramr);
    paramr.j();
    r.c(paramr).y();
    Iterator localIterator = r.b(paramr).iterator();
    while (localIterator.hasNext()) {
      ((q)localIterator.next()).c();
    }
    r.b(paramr).clear();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\r$b$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */