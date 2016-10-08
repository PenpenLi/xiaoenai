package com.alibaba.mtl.log.e;

import android.util.Log;
import java.lang.reflect.Method;

public class q
{
  private static final String TAG = q.class.getSimpleName();
  
  public static String get(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString = (String)localClass.getMethod("get", new Class[] { String.class }).invoke(localClass.newInstance(), new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e(TAG, "get() ERROR!!! Exception!", paramString);
    }
    return "";
  }
  
  public static String get(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass.newInstance(), new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e(TAG, "get() ERROR!!! Exception!", paramString1);
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */