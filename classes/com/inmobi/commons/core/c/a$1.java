package com.inmobi.commons.core.c;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.e.b;
import java.util.concurrent.atomic.AtomicBoolean;

class a$1
  implements e.b
{
  a$1(a parama) {}
  
  public void b(boolean paramBoolean)
  {
    Logger.a(Logger.InternalLogLevel.INTERNAL, a.d(), "Network status changed " + paramBoolean);
    if ((paramBoolean) && (!a.e().get()) && (com.inmobi.commons.a.a.e())) {
      a.a(a.a(), 60);
    }
    a.e().set(paramBoolean);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\c\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */