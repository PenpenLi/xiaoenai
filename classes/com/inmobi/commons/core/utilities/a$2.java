package com.inmobi.commons.core.utilities;

import java.util.Iterator;
import java.util.List;

final class a$2
  implements Runnable
{
  a$2(boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = a.e().iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).a(this.a);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\a$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */