package com.alibaba.mtl.appmonitor.c;

import com.alibaba.fastjson.JSONObject;
import java.util.Collection;
import java.util.Iterator;

public class e
  extends JSONObject
  implements b
{
  public void clean()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof b)) {
        a.a().a((b)localObject);
      }
    }
    super.clear();
  }
  
  public void fill(Object... paramVarArgs) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */