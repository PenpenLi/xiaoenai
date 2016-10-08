package com.xiaoenai.app.utils.d;

import android.content.Context;
import android.content.res.Resources;

public class s
{
  private static String a = "drawable";
  private static String b = "string";
  private static String c = "color";
  private static String d = "raw";
  private static String e = "layout";
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, c, paramString);
  }
  
  private static int a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\utils\d\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */