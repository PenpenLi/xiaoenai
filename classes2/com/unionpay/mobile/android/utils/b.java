package com.unionpay.mobile.android.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyyMMddhhmmss");
  
  public static String a()
  {
    return a.format(new Date(System.currentTimeMillis()));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\unionpay\mobile\android\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */