package com.xiaoenai.app.widget;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.Lock;

class j
  implements Runnable
{
  j(i parami) {}
  
  public void run()
  {
    h.a(this.a.a).lock();
    if ((Context)h.b(this.a.a).get() == null)
    {
      this.a.a.b();
      return;
    }
    for (;;)
    {
      try
      {
        ListIterator localListIterator = h.c(this.a.a).listIterator();
        if (!localListIterator.hasNext()) {
          break;
        }
        h.a locala = ((h.b)localListIterator.next()).a();
        if (locala != null) {
          locala.b();
        } else {
          ((Iterator)localObject).remove();
        }
      }
      finally
      {
        h.a(this.a.a).unlock();
      }
    }
    h.a(this.a.a).unlock();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */