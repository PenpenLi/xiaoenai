package com.alibaba.mtl.appmonitor.c;

import com.alibaba.fastjson.JSONArray;
import java.util.Iterator;

public class d
  extends JSONArray
  implements b
{
  public void clean()
  {
    Iterator localIterator = iterator();
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */