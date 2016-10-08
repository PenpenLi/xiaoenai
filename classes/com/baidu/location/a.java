package com.baidu.location;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class a
  implements b
{
  private static String kR;
  private static Boolean kS;
  private static char kT;
  private static String kU;
  private static SimpleDateFormat kV = new SimpleDateFormat("yyyy-MM-dd");
  private static int kW;
  private static Boolean kX = Boolean.valueOf(true);
  private static SimpleDateFormat kY;
  
  static
  {
    kS = Boolean.valueOf(true);
    kT = 'v';
    kU = "/sdcard/baidu";
    kW = 0;
    kR = "LocLog.txt";
    kY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }
  
  public static void jdMethod_byte(String paramString1, String paramString2)
  {
    jdMethod_if(paramString1, paramString2, 'd');
  }
  
  public static void c0()
  {
    Object localObject = kV.format(c1());
    localObject = new File(kU, (String)localObject + kR);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  private static Date c1()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.set(5, localCalendar.get(5) - kW);
    return localCalendar.getTime();
  }
  
  public static void jdMethod_case(String paramString1, String paramString2)
  {
    jdMethod_if(paramString1, paramString2, 'w');
  }
  
  public static void jdMethod_char(String paramString1, String paramString2)
  {
    jdMethod_if(paramString1, paramString2, 'i');
  }
  
  public static void jdMethod_do(String paramString, Object paramObject)
  {
    jdMethod_if(paramString, paramObject.toString(), 'i');
  }
  
  public static void jdMethod_else(String paramString1, String paramString2)
  {
    jdMethod_if(paramString1, paramString2, 'v');
  }
  
  public static void jdMethod_for(String paramString, Object paramObject)
  {
    jdMethod_if(paramString, paramObject.toString(), 'v');
  }
  
  public static void jdMethod_goto(String paramString1, String paramString2)
  {
    jdMethod_if(paramString1, paramString2, 'e');
  }
  
  public static void jdMethod_if(String paramString, Object paramObject)
  {
    jdMethod_if(paramString, paramObject.toString(), 'w');
  }
  
  private static void jdMethod_if(String paramString1, String paramString2, char paramChar) {}
  
  public static void jdMethod_int(String paramString, Object paramObject)
  {
    jdMethod_if(paramString, paramObject.toString(), 'e');
  }
  
  private static void jdMethod_int(String paramString1, String paramString2, String paramString3)
  {
    Date localDate = new Date();
    String str = kV.format(localDate);
    paramString1 = kY.format(localDate) + "    " + paramString1 + "    " + paramString2 + "    " + paramString3;
    paramString2 = new File(kU, str + kR);
    try
    {
      paramString2 = new FileWriter(paramString2, true);
      paramString3 = new BufferedWriter(paramString2);
      paramString3.write(paramString1);
      paramString3.newLine();
      paramString3.close();
      paramString2.close();
      return;
    }
    catch (IOException paramString1) {}
  }
  
  public static void jdMethod_new(String paramString, Object paramObject)
  {
    jdMethod_if(paramString, paramObject.toString(), 'd');
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */