package com.alibaba.mtl.log.e;

import android.os.Process;
import android.util.Log;

public class i
{
  private static boolean I = false;
  private static boolean J = false;
  private static String ag = "AppMonitor:";
  
  public static void a(String paramString, Object paramObject)
  {
    if ((n()) || (m())) {
      Log.w(paramString + ag, paramObject + "");
    }
  }
  
  public static void a(String paramString, Object paramObject, Throwable paramThrowable)
  {
    if ((n()) || (m())) {
      Log.w(paramString + ag, paramObject + "", paramThrowable);
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (J)
    {
      paramString = ag + paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pid:").append(Process.myPid()).append(" ");
      if (paramVarArgs != null)
      {
        int i = 0;
        if (i < paramVarArgs.length)
        {
          String str;
          if (paramVarArgs[i] != null)
          {
            str = paramVarArgs[i].toString();
            if ((!str.endsWith(":")) && (!str.endsWith(": "))) {
              break label115;
            }
            localStringBuilder.append(str);
          }
          for (;;)
          {
            i += 1;
            break;
            label115:
            localStringBuilder.append(str).append(",");
          }
        }
      }
      Log.d(paramString, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    if (J)
    {
      paramString = ag + paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pid:").append(Process.myPid()).append(" ");
      if (paramVarArgs != null)
      {
        int i = 0;
        if (i < paramVarArgs.length)
        {
          String str;
          if (paramVarArgs[i] != null)
          {
            str = paramVarArgs[i];
            if ((!str.endsWith(":")) && (!str.endsWith(": "))) {
              break label112;
            }
            localStringBuilder.append(str);
          }
          for (;;)
          {
            i += 1;
            break;
            label112:
            localStringBuilder.append(str).append(",");
          }
        }
      }
      Log.i(paramString, localStringBuilder.toString());
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    J = paramBoolean;
  }
  
  public static boolean m()
  {
    return I;
  }
  
  public static boolean n()
  {
    return J;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */