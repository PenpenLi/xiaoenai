package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

class b
  implements Runnable
{
  private static long jdField_a_of_type_Long = 300000L;
  private static b jdField_a_of_type_ComAlibabaMtlAppmonitorB;
  private static boolean j = false;
  
  static void destroy()
  {
    r.a().f(5);
    j = false;
    jdField_a_of_type_ComAlibabaMtlAppmonitorB = null;
  }
  
  static void init()
  {
    if (!j)
    {
      i.a("CleanTask", new Object[] { "init TimeoutEventManager" });
      jdField_a_of_type_ComAlibabaMtlAppmonitorB = new b();
      r.a().a(5, jdField_a_of_type_ComAlibabaMtlAppmonitorB, jdField_a_of_type_Long);
      j = true;
    }
  }
  
  public void run()
  {
    i.a("CleanTask", new Object[] { "clean TimeoutEvent" });
    e.a().h();
    r.a().a(5, jdField_a_of_type_ComAlibabaMtlAppmonitorB, jdField_a_of_type_Long);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */