package com.alibaba.mtl.appmonitor.f;

public class b
{
  public static boolean d(String paramString)
  {
    return !isBlank(paramString);
  }
  
  public static boolean isBlank(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label48;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label48:
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */