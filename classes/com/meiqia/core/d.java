package com.meiqia.core;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.meiqia.core.b.j;
import com.meiqia.core.d.k;
import java.util.Iterator;
import java.util.List;

class d
  implements k
{
  d(ah paramah, k paramk) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramString);
    }
  }
  
  public void a(@NonNull List<com.meiqia.core.c.e> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.meiqia.core.c.e locale = (com.meiqia.core.c.e)localIterator.next();
      if (TextUtils.equals("client", locale.g())) {
        locale.i(ah.a(this.b).s());
      }
    }
    if (this.a != null) {
      ah.a(this.b, new e(this, paramList));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */