package com.ta.utdid2.b.a;

import android.util.Log;

public class j
{
  public static final String TAG = j.class.getName();
  
  public static boolean a(long paramLong, int paramInt)
  {
    if ((System.currentTimeMillis() - paramLong) / 86400000L < paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      if (d.e) {
        Log.d(TAG, "isUpToDate: " + bool + "; oldTimestamp: " + paramLong + "; currentTimestamp" + System.currentTimeMillis());
      }
      return bool;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */