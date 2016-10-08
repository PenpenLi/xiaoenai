package com.meiqia.core;

import com.meiqia.core.b.i;
import com.meiqia.core.b.j;
import com.meiqia.core.c.b;
import com.meiqia.core.c.e;
import com.meiqia.core.d.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class f
  implements k
{
  f(ah paramah, List paramList, k paramk) {}
  
  public void a(int paramInt, String paramString)
  {
    this.b.a(paramInt, paramString);
  }
  
  public void a(List<e> paramList)
  {
    Object localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      ah.a(this.c, locale, i);
      locale.e(ah.a.b());
      i += 1;
    }
    if (paramList.size() > 0)
    {
      localObject = (e)paramList.get(paramList.size() - 1);
      ah.a(this.c).b(((e)localObject).e());
    }
    this.a.addAll(paramList);
    paramList = new i();
    Collections.sort(this.a, paramList);
    this.b.a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\meiqia\core\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */