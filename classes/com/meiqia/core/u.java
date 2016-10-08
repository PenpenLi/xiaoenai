package com.meiqia.core;

import com.meiqia.core.c.e;
import com.meiqia.core.d.k;
import java.util.Iterator;
import java.util.List;

class u
  implements k
{
  u(ah paramah) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(List<e> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e locale = (e)paramList.next();
      n.a(ah.c(this.a)).a(locale);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */