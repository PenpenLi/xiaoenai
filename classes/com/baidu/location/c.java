package com.baidu.location;

import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Calendar;
import java.util.Locale;

class c
  implements ax, n
{
  public static int W = 0;
  public static int X = 0;
  public static String Y;
  public static float Z = 0.0F;
  public static float a0 = 0.0F;
  private static String a1;
  public static float a2 = 0.0F;
  public static boolean a3 = false;
  public static int a4 = 0;
  public static int a5 = 0;
  public static int a6 = 0;
  public static boolean a7 = false;
  public static int a8 = 0;
  public static double a9 = 0.0D;
  private static boolean aA = false;
  public static byte[] aB;
  private static boolean aC = false;
  public static long aD = 0L;
  private static String aE;
  public static int aF = 70;
  public static final boolean aG = true;
  public static double aH;
  public static int aI;
  public static int aJ;
  public static long aK;
  private static String aL;
  public static int aM;
  private static String aN;
  public static int aO;
  private static Process aP;
  public static long aQ;
  public static float aR;
  public static long aS;
  public static float aT;
  public static float aU;
  public static int aV;
  public static int aW;
  public static int aX;
  private static String aY;
  public static boolean aZ;
  public static int aa;
  public static float ab;
  public static double ac;
  public static long ad;
  public static float ae;
  public static float af;
  public static float ag;
  public static boolean ah;
  public static int ai;
  public static int aj;
  public static int ak;
  public static int al;
  public static boolean am = false;
  public static double an;
  public static long ao;
  public static float ap;
  public static int aq;
  public static boolean ar;
  public static int as;
  public static int at;
  public static int au = 6;
  public static int av;
  public static String aw;
  public static int ax;
  public static int ay;
  public static boolean az;
  public static float ba;
  public static float bb;
  public static String bc;
  public static float bd;
  public static float be;
  
  static
  {
    ah = false;
    al = 0;
    aN = "http://loc.map.baidu.com/sdk.php";
    Y = "http://loc.map.baidu.com/sdk_ep.php";
    a1 = "http://loc.map.baidu.com/user_err.php";
    aY = "http://loc.map.baidu.com/oqur.php";
    aE = "http://loc.map.baidu.com/tcu.php";
    aA = false;
    aC = false;
    aL = "[baidu_location_service]";
    aP = null;
    aw = "no";
    bc = "gcj02";
    a7 = true;
    aM = 3;
    a9 = 0.0D;
    an = 0.0D;
    aH = 0.0D;
    ac = 0.0D;
    ak = 0;
    aB = null;
    ar = false;
    ai = 0;
    ae = 1.1F;
    aR = 2.2F;
    ag = 2.3F;
    aT = 3.8F;
    aI = 3;
    W = 10;
    aJ = 2;
    X = 7;
    aa = 20;
    ax = 70;
    a4 = 120;
    be = 2.0F;
    bb = 10.0F;
    ap = 50.0F;
    a0 = 200.0F;
    aX = 16;
    ab = 0.9F;
    at = 10000;
    aU = 0.5F;
    bd = 0.0F;
    ba = 0.1F;
    a8 = 30;
    a6 = 100;
    aj = 420000;
    az = true;
    aZ = true;
    av = 20;
    as = 300;
    ay = 1000;
    aQ = 900000L;
    aK = 420000L;
    ad = 180000L;
    ao = 180000L;
    aS = 15L;
    aD = 300000L;
    a5 = 100;
    aV = 0;
    aW = 30000;
    aO = 30000;
    a2 = 10.0F;
    af = 6.0F;
    Z = 10.0F;
    aq = 60;
  }
  
  public static String jdMethod_byte()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    try
    {
      String str = Environment.getExternalStorageDirectory().getPath();
      File localFile = new File(str + "/baidu/tempdata");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
    return null;
  }
  
  public static void jdMethod_case() {}
  
  public static void jdMethod_char()
  {
    try
    {
      if (aP != null)
      {
        aP.destroy();
        aP = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  static int jdMethod_do(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    int i;
    do
    {
      int j;
      do
      {
        do
        {
          return Integer.MIN_VALUE;
          i = paramString1.indexOf(paramString2);
        } while (i == -1);
        i += paramString2.length();
        j = paramString1.indexOf(paramString3, i);
      } while (j == -1);
      paramString1 = paramString1.substring(i, j);
    } while ((paramString1 == null) || (paramString1.equals("")));
    try
    {
      i = Integer.parseInt(paramString1);
      return i;
    }
    catch (NumberFormatException paramString1) {}
    return Integer.MIN_VALUE;
  }
  
  public static String jdMethod_do()
  {
    return aY;
  }
  
  public static void jdMethod_do(String paramString)
  {
    if (paramString != null) {
      aN = paramString;
    }
  }
  
  public static void jdMethod_do(String paramString1, String paramString2) {}
  
  public static String jdMethod_else()
  {
    String str = jdMethod_byte();
    if (str == null) {
      return null;
    }
    return str + "/baidu/tempdata";
  }
  
  static double jdMethod_for(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          return Double.MIN_VALUE;
          i = paramString1.indexOf(paramString2);
        } while (i == -1);
        i += paramString2.length();
        j = paramString1.indexOf(paramString3, i);
      } while (j == -1);
      paramString1 = paramString1.substring(i, j);
    } while ((paramString1 == null) || (paramString1.equals("")));
    try
    {
      double d = Double.parseDouble(paramString1);
      return d;
    }
    catch (NumberFormatException paramString1) {}
    return Double.MIN_VALUE;
  }
  
  public static String jdMethod_for()
  {
    return aN;
  }
  
  public static String jdMethod_goto()
  {
    try
    {
      Object localObject = new File(f.getServiceContext().getFilesDir() + File.separator + "lldt");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  static float jdMethod_if(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          return Float.MIN_VALUE;
          i = paramString1.indexOf(paramString2);
        } while (i == -1);
        i += paramString2.length();
        j = paramString1.indexOf(paramString3, i);
      } while (j == -1);
      paramString1 = paramString1.substring(i, j);
    } while ((paramString1 == null) || (paramString1.equals("")));
    try
    {
      float f = Float.parseFloat(paramString1);
      return f;
    }
    catch (NumberFormatException paramString1) {}
    return Float.MIN_VALUE;
  }
  
  static String jdMethod_if()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(5);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(13);
    return String.format(Locale.CHINA, "%d_%d_%d_%d_%d_%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
  }
  
  public static String jdMethod_if(t.a parama, ar.b paramb, Location paramLocation, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (parama != null)
    {
      String str = parama.toString();
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (paramb != null) {}
    try
    {
      paramb = paramb.a(5);
      if (paramb != null) {
        localStringBuffer.append(paramb);
      }
      if (paramLocation != null)
      {
        if (al == 0) {
          break label157;
        }
        paramb = x.jdMethod_new(paramLocation);
        if (paramb != null) {
          localStringBuffer.append(paramb);
        }
      }
      paramb = az.cn().jdMethod_char(false);
      if (paramb != null) {
        localStringBuffer.append(paramb);
      }
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      if (parama != null)
      {
        parama = parama.jdMethod_int();
        if ((parama != null) && (parama.length() + localStringBuffer.length() < 750)) {
          localStringBuffer.append(parama);
        }
      }
      return localStringBuffer.toString();
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb = null;
        continue;
        label157:
        paramb = x.jdMethod_byte(paramLocation);
      }
    }
  }
  
  public static String jdMethod_if(t.a parama, ar.b paramb, Location paramLocation, String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    if (parama != null)
    {
      str = parama.toString();
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (paramb != null)
    {
      if (paramInt != 0) {
        break label285;
      }
      str = paramb.jdMethod_char();
    }
    for (;;)
    {
      if (str != null) {
        localStringBuffer.append(str);
      }
      if (paramLocation != null)
      {
        if ((al == 0) || (paramInt == 0)) {
          break label294;
        }
        str = x.jdMethod_new(paramLocation);
        label81:
        if (str != null) {
          localStringBuffer.append(str);
        }
      }
      boolean bool = false;
      if (paramInt == 0) {
        bool = true;
      }
      str = az.cn().jdMethod_char(bool);
      if (str != null) {
        localStringBuffer.append(str);
      }
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      paramString = aw.jdMethod_do().a();
      if (!TextUtils.isEmpty(paramString)) {
        localStringBuffer.append("&bc=").append(paramString);
      }
      if (parama != null)
      {
        parama = parama.jdMethod_int();
        if ((parama != null) && (parama.length() + localStringBuffer.length() < 750)) {
          localStringBuffer.append(parama);
        }
      }
      parama = localStringBuffer.toString();
      if ((paramLocation == null) || (paramb == null)) {
        break label364;
      }
      try
      {
        float f = paramLocation.getSpeed();
        paramInt = al;
        int i = paramb.jdMethod_do();
        int j = paramb.jdMethod_try();
        bool = paramb.jdMethod_case();
        if ((f < af) && ((paramInt == 1) || (paramInt == 0)) && ((i < aq) || (bool == true)))
        {
          aM = 1;
          return parama;
          label285:
          str = paramb.jdMethod_byte();
          continue;
          label294:
          str = x.jdMethod_byte(paramLocation);
          break label81;
        }
        else if ((f < Z) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 3)) && ((i < aF) || (j > au)))
        {
          aM = 2;
          return parama;
        }
      }
      catch (Exception paramb)
      {
        aM = 3;
        return parama;
      }
    }
    aM = 3;
    return parama;
    label364:
    aM = 3;
    return parama;
  }
  
  static String jdMethod_if(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        i = paramString1.indexOf(paramString2);
      } while (i == -1);
      i += paramString2.length();
      j = paramString1.indexOf(paramString3, i);
    } while (j == -1);
    paramString2 = paramString1.substring(0, i);
    paramString1 = paramString1.substring(j);
    paramString3 = String.format(Locale.CHINA, "%.7f", new Object[] { Double.valueOf(paramDouble) });
    return paramString2 + paramString3 + paramString1;
  }
  
  public static void jdMethod_if(String paramString)
  {
    if (aC) {
      Log.d(aL, paramString);
    }
  }
  
  public static void jdMethod_if(String paramString1, String paramString2)
  {
    if (aA) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static boolean jdMethod_if(BDLocation paramBDLocation)
  {
    int i = paramBDLocation.getLocType();
    return (i > 100) && (i < 200);
  }
  
  public static String jdMethod_int()
  {
    return aE;
  }
  
  static String jdMethod_new()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(5);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(13);
    return String.format(Locale.CHINA, "%d-%d-%d %d:%d:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
  }
  
  public static String jdMethod_try()
  {
    return a1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */