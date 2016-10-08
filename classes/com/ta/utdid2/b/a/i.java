package com.ta.utdid2.b.a;

public class i
{
  public static int a(String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramString.length() > 0)
    {
      paramString = paramString.toCharArray();
      i = 0;
      while (j < paramString.length)
      {
        i = i * 31 + paramString[j];
        j += 1;
      }
    }
    return i;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\b\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */