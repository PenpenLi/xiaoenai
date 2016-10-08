package com.b.a.a;

class u
{
  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new IllegalArgumentException(paramString + " should not be null!");
    }
    return paramT;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new AssertionError(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\b\a\a\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */