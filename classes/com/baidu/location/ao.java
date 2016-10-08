package com.baidu.location;

import android.os.HandlerThread;

class ao
{
  private static HandlerThread a = null;
  
  static HandlerThread a()
  {
    if (a == null)
    {
      a = new HandlerThread("ServiceStartArguments", 10);
      a.start();
    }
    return a;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */