package com.xiaoenai.app.stat;

class d
  implements Runnable
{
  d(c paramc) {}
  
  public void run()
  {
    try
    {
      String str1 = g.a();
      String str2 = g.b();
      if (((str1 != null) && (str1.length() > 0)) || ((str2 != null) && (str2.length() > 0))) {
        c.a(this.a, str1, str2);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\stat\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */