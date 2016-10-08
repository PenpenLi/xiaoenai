package com.xiaoenai.app.utils;

import android.content.res.Resources;
import com.xiaoenai.app.Xiaoenai;

public class aa
{
  private static String a = "drawable";
  private static String b = "string";
  private static String c = "color";
  private static String d = "raw";
  private static String e = "layout";
  
  public static int a(String paramString)
  {
    return a(a, paramString);
  }
  
  private static int a(String paramString1, String paramString2)
  {
    return Xiaoenai.j().getResources().getIdentifier(paramString2, paramString1, Xiaoenai.j().getPackageName());
  }
  
  public static int b(String paramString)
  {
    return a(b, paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */