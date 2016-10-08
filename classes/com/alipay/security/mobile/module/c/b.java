package com.alipay.security.mobile.module.c;

import android.os.Environment;
import com.alipay.security.mobile.module.c.a.a;
import java.io.File;

public final class b
{
  public static String a(String paramString)
  {
    try
    {
      if (a())
      {
        paramString = new File(Environment.getExternalStorageDirectory(), paramString);
        if (paramString.exists())
        {
          paramString = a.b(paramString.getAbsolutePath());
          return paramString;
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static boolean a()
  {
    String str = Environment.getExternalStorageState();
    return (str != null) && (str.length() > 0) && ((str.equals("mounted")) || (str.equals("mounted_ro"))) && (Environment.getExternalStorageDirectory() != null);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */