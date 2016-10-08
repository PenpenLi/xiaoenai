package com.taobao.dp.b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import com.taobao.wireless.security.adapter.datacollection.c;
import com.taobao.wireless.security.adapter.datacollection.d;
import com.taobao.wireless.security.adapter.datacollection.f;
import com.taobao.wireless.security.adapter.datacollection.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private Context a;
  private TelephonyManager b;
  private ConnectivityManager c;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    if (paramContext != null) {}
    try
    {
      this.b = ((TelephonyManager)paramContext.getSystemService("phone"));
      g.a(paramContext);
      f.a(paramContext);
      com.taobao.wireless.security.adapter.datacollection.b.a(paramContext);
      d.a(paramContext);
      c.a(paramContext);
      try
      {
        this.c = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
        return;
      }
      catch (Exception paramContext) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean A()
  {
    try
    {
      if ((!Build.HARDWARE.contains("goldfish")) && (!Build.PRODUCT.contains("sdk")))
      {
        boolean bool = Build.FINGERPRINT.contains("generic");
        if (!bool) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String a()
  {
    try
    {
      String str = g.a();
      if ((str == null) || ("".equals(str))) {
        str = SPUtility2.readFromSPUnified("mac_address", "mac_address", null);
      } else {
        SPUtility2.saveToSPUnified("mac_address", "mac_address", str, true);
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    do
    {
      return "";
    } while (localException == null);
    return localException;
  }
  
  /* Error */
  private static String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 104	java/lang/ProcessBuilder
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 107	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 111	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   14: pop
    //   15: aload_0
    //   16: invokevirtual 115	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   19: astore_0
    //   20: new 117	java/io/DataOutputStream
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual 123	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 126	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore_2
    //   32: new 128	java/io/DataInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokevirtual 132	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 135	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: invokevirtual 138	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_2
    //   48: ldc -116
    //   50: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: invokevirtual 147	java/io/DataOutputStream:flush	()V
    //   57: aload_0
    //   58: invokevirtual 151	java/lang/Process:waitFor	()I
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 154	java/lang/Process:destroy	()V
    //   66: aload_1
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: ldc 85
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 154	java/lang/Process:destroy	()V
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 154	java/lang/Process:destroy	()V
    //   90: aload_1
    //   91: athrow
    //   92: astore_0
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: goto -6 -> 90
    //   99: astore_1
    //   100: goto -14 -> 86
    //   103: astore_1
    //   104: ldc 85
    //   106: astore_1
    //   107: goto -33 -> 74
    //   110: astore_2
    //   111: goto -37 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramArrayOfString	String[]
    //   46	36	1	str1	String
    //   83	11	1	str2	String
    //   99	1	1	localObject	Object
    //   103	1	1	localException1	Exception
    //   106	1	1	str3	String
    //   31	23	2	localDataOutputStream	java.io.DataOutputStream
    //   110	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	20	68	java/lang/Exception
    //   74	78	80	java/lang/Exception
    //   0	20	83	finally
    //   62	66	92	java/lang/Exception
    //   86	90	95	java/lang/Exception
    //   20	47	99	finally
    //   47	62	99	finally
    //   20	47	103	java/lang/Exception
    //   47	62	110	java/lang/Exception
  }
  
  public static String b()
  {
    String str = g.c();
    if (str != null) {
      return str.trim();
    }
    return "";
  }
  
  public static String c()
  {
    String str = g.b();
    if (str != null) {
      return str.trim();
    }
    return "";
  }
  
  public static String d()
  {
    String str = f.a();
    if (str != null) {
      return str.trim();
    }
    return "";
  }
  
  public static String e()
  {
    String str = f.b();
    if (str != null) {
      return str.trim();
    }
    return "";
  }
  
  public static String g()
  {
    try
    {
      String str = "android" + Build.VERSION.RELEASE + "," + Build.VERSION.SDK_INT;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String j()
  {
    String str = null;
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null) {
        str = localBluetoothAdapter.getAddress();
      }
      if (str != null) {
        return str.trim();
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    return "";
  }
  
  public static String k()
  {
    String str = null;
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null) {
        str = localBluetoothAdapter.getName();
      }
      if (str != null) {
        return str.trim();
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    return "";
  }
  
  public static String l()
  {
    String str2 = com.taobao.wireless.security.adapter.datacollection.b.b();
    String str1 = str2;
    if (str2 == null) {
      str1 = "100000";
    }
    return str1;
  }
  
  /* Error */
  public static String m()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: lconst_0
    //   3: lstore 6
    //   5: new 216	java/io/BufferedReader
    //   8: dup
    //   9: new 218	java/io/FileReader
    //   12: dup
    //   13: ldc -36
    //   15: invokespecial 221	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: bipush 8
    //   20: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 225	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +5 -> 35
    //   33: aload_2
    //   34: astore_1
    //   35: lload 6
    //   37: lstore 4
    //   39: aload_1
    //   40: ifnull +32 -> 72
    //   43: aload_1
    //   44: aload_1
    //   45: bipush 58
    //   47: invokevirtual 229	java/lang/String:indexOf	(I)I
    //   50: iconst_1
    //   51: iadd
    //   52: aload_1
    //   53: bipush 107
    //   55: invokevirtual 229	java/lang/String:indexOf	(I)I
    //   58: invokevirtual 233	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: invokevirtual 159	java/lang/String:trim	()Ljava/lang/String;
    //   64: invokestatic 239	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   67: istore_3
    //   68: iload_3
    //   69: i2l
    //   70: lstore 4
    //   72: aload_0
    //   73: invokevirtual 242	java/io/BufferedReader:close	()V
    //   76: lload 4
    //   78: invokestatic 246	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   81: areturn
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_0
    //   85: lload 6
    //   87: lstore 4
    //   89: aload_0
    //   90: ifnull -14 -> 76
    //   93: aload_0
    //   94: invokevirtual 242	java/io/BufferedReader:close	()V
    //   97: lload 6
    //   99: lstore 4
    //   101: goto -25 -> 76
    //   104: astore_0
    //   105: lload 6
    //   107: lstore 4
    //   109: goto -33 -> 76
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 242	java/io/BufferedReader:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_0
    //   126: goto -50 -> 76
    //   129: astore_0
    //   130: goto -7 -> 123
    //   133: astore_1
    //   134: goto -19 -> 115
    //   137: astore_1
    //   138: goto -53 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	50	0	localBufferedReader	BufferedReader
    //   82	1	0	localException1	Exception
    //   84	10	0	localObject1	Object
    //   104	1	0	localIOException1	IOException
    //   114	6	0	localObject2	Object
    //   125	1	0	localIOException2	IOException
    //   129	1	0	localIOException3	IOException
    //   1	52	1	localObject3	Object
    //   112	12	1	localObject4	Object
    //   133	1	1	localObject5	Object
    //   137	1	1	localException2	Exception
    //   28	6	2	str	String
    //   67	2	3	i	int
    //   37	71	4	l1	long
    //   3	103	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   5	24	82	java/lang/Exception
    //   93	97	104	java/io/IOException
    //   5	24	112	finally
    //   72	76	125	java/io/IOException
    //   119	123	129	java/io/IOException
    //   24	29	133	finally
    //   43	68	133	finally
    //   24	29	137	java/lang/Exception
    //   43	68	137	java/lang/Exception
  }
  
  public static String n()
  {
    try
    {
      int i = com.taobao.dp.c.a.a();
      if (i != 0) {
        return String.valueOf(i);
      }
      String str = com.taobao.dp.c.a.b();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String o()
  {
    Object localObject = null;
    try
    {
      String str = com.taobao.dp.c.a.c();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (localObject != null) {
      return (String)localObject;
    }
    return "";
  }
  
  public static String p()
  {
    Object localObject = null;
    try
    {
      String str = com.taobao.dp.c.a.d();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (localObject != null) {
      return (String)localObject;
    }
    return "";
  }
  
  public static String q()
  {
    Object localObject = null;
    try
    {
      String str = com.taobao.dp.c.a.e();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (localObject != null) {
      return (String)localObject;
    }
    return "";
  }
  
  public static com.taobao.dp.bean.b r()
  {
    try
    {
      Object localObject = c.a("network");
      if (localObject != null)
      {
        double d1 = ((Location)localObject).getLongitude();
        double d2 = ((Location)localObject).getLatitude();
        float f = ((Location)localObject).getAccuracy();
        long l = ((Location)localObject).getTime();
        localObject = new com.taobao.dp.bean.b();
        ((com.taobao.dp.bean.b)localObject).a(d1);
        ((com.taobao.dp.bean.b)localObject).b(d2);
        ((com.taobao.dp.bean.b)localObject).a(f);
        ((com.taobao.dp.bean.b)localObject).a(l);
        return (com.taobao.dp.bean.b)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String t()
  {
    try
    {
      Object localObject1 = new BufferedReader(new FileReader("/proc/version"), 256);
      try
      {
        String str2 = ((BufferedReader)localObject1).readLine();
        ((BufferedReader)localObject1).close();
        localObject1 = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(str2);
        if (!((Matcher)localObject1).matches()) {
          return "";
        }
      }
      finally
      {
        ((BufferedReader)localObject1).close();
      }
      if (localIOException.groupCount() >= 4) {
        break label73;
      }
    }
    catch (IOException localIOException)
    {
      return "";
    }
    return "";
    label73:
    String str1 = localIOException.group(1) + "\n" + localIOException.group(2) + " " + localIOException.group(3) + "\n" + localIOException.group(4);
    return str1;
  }
  
  public static boolean w()
  {
    boolean bool = true;
    int i = 0;
    while (i < 5) {
      try
      {
        String str = new String[] { "/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/" }[i] + "su";
        if (new File(str).exists())
        {
          str = a(new String[] { "ls", "-l", str });
          if ((str != null) && (str.length() != 0))
          {
            i = str.indexOf("root");
            int j = str.lastIndexOf("root");
            if (i != j) {}
          }
          else
          {
            bool = false;
          }
          return bool;
        }
        i += 1;
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public static String y()
  {
    String str2 = g.d();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String B()
  {
    Object localObject2;
    if (this.a != null) {
      try
      {
        Object localObject1 = (SensorManager)this.a.getSystemService("sensor");
        if (localObject1 != null)
        {
          localObject2 = ((SensorManager)localObject1).getSensorList(-1);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject1 = new StringBuilder();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Sensor localSensor = (Sensor)((Iterator)localObject2).next();
              ((StringBuilder)localObject1).append(localSensor.getName());
              ((StringBuilder)localObject1).append(localSensor.getVersion());
              ((StringBuilder)localObject1).append(localSensor.getVendor());
            }
          }
        }
        str = null;
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      localObject2 = str;
      if (str == null) {
        localObject2 = "";
      }
      return (String)localObject2;
      String str = com.taobao.dp.a.b.a(str.toString());
    }
  }
  
  public final String f()
  {
    try
    {
      String str = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
      if (str != null) {
        return str.trim();
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    return "";
  }
  
  public final String h()
  {
    try
    {
      new DisplayMetrics();
      Object localObject = this.a.getApplicationContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = String.valueOf(Math.min(i, j)) + "*" + String.valueOf(Math.max(i, j));
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public final String i()
  {
    if (this.a == null) {
      return "";
    }
    try
    {
      new DisplayMetrics();
      Object localObject = this.a.getApplicationContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).heightPixels;
      localObject = String.valueOf(i + "*" + j);
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public final String s()
  {
    try
    {
      if (this.b != null)
      {
        String str = this.b.getNetworkType();
        return str;
      }
    }
    catch (Exception localException) {}
    return "";
  }
  
  public final String u()
  {
    if (this.a == null) {
      return "";
    }
    try
    {
      String str = this.a.getResources().getConfiguration().locale.toString();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public final String v()
  {
    if (this.a == null) {
      return "";
    }
    return Float.toString(new Paint().getTextSize());
  }
  
  public final boolean x()
  {
    try
    {
      NetworkInfo localNetworkInfo = this.c.getNetworkInfo(1);
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnected();
        return bool;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final String z()
  {
    try
    {
      Object localObject = this.a.getResources().getDisplayMetrics();
      localObject = ((DisplayMetrics)localObject).densityDpi;
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */