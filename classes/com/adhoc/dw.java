package com.adhoc;

public final class dw
{
  public static boolean a(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE"));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH"));
  }
  
  public static boolean c(String paramString)
  {
    return (b(paramString)) || (paramString.equals("DELETE"));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */