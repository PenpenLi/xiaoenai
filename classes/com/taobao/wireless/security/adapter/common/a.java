package com.taobao.wireless.security.adapter.common;

public final class a
{
  public static boolean a(String... paramVarArgs)
  {
    boolean bool2 = false;
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = paramVarArgs[i];
        if ((str == null) || ("".equals(str))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b(String... paramVarArgs)
  {
    return !a(paramVarArgs);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\wireless\security\adapter\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */