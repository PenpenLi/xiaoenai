package com.alibaba.mtl.appmonitor;

final class AppMonitor$7
  implements Runnable
{
  AppMonitor$7(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      AppMonitor.a.setRequestAuthInfo(this.d, this.e, this.f, this.g);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\AppMonitor$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */