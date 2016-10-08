package com.alibaba.mtl.appmonitor.c;

import java.util.HashMap;
import java.util.Map;

public class a
{
  private static a a = new a();
  private Map<Class<? extends b>, c<? extends b>> m = new HashMap();
  
  public static a a()
  {
    return a;
  }
  
  private <T extends b> c<T> a(Class<T> paramClass)
  {
    try
    {
      c localc2 = (c)this.m.get(paramClass);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c();
        this.m.put(paramClass, localc1);
      }
      return localc1;
    }
    finally {}
  }
  
  public <T extends b> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    b localb = a(paramClass).a();
    if (localb == null) {}
    for (;;)
    {
      try
      {
        paramClass = (b)paramClass.newInstance();
        if (paramClass != null) {
          paramClass.fill(paramVarArgs);
        }
        return paramClass;
      }
      catch (Exception paramClass)
      {
        com.alibaba.mtl.appmonitor.b.b.a(paramClass);
      }
      paramClass = localb;
    }
  }
  
  public <T extends b> void a(T paramT)
  {
    if (paramT != null) {
      a(paramT.getClass()).a(paramT);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */