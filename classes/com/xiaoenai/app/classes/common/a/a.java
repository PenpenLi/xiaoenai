package com.xiaoenai.app.classes.common.a;

import java.util.HashMap;
import java.util.Map;

public class a
{
  private static Map<Long, c> a;
  private static a b;
  private static Object c = new Object();
  
  public static a a()
  {
    synchronized (c)
    {
      if (b == null)
      {
        b = new a();
        a = new HashMap();
      }
      a locala = b;
      return locala;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      a.remove(Long.valueOf(paramLong));
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, b paramb)
  {
    try
    {
      c localc = (c)a.get(Long.valueOf(paramLong));
      if (localc != null) {
        localc.a(paramb);
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, c paramc)
  {
    try
    {
      a.put(Long.valueOf(paramLong), paramc);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\common\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */