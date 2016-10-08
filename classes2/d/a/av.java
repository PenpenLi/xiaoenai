package d.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.f.a.a;
import com.f.a.b.a;
import com.f.a.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

public class av
{
  protected static final String a = av.class.getName();
  
  private static String A(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    String str2;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 23)
    {
      str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      ax.a(a, new Object[] { "getDeviceId, android_id: " + str2 });
      localObject = str2;
      if (TextUtils.isEmpty(str2))
      {
        str2 = b();
        ax.a(a, new Object[] { "getDeviceId, mc: " + str2 });
        localObject = str2;
        if ((TextUtils.isEmpty(str2)) && (localTelephonyManager == null)) {
          break label359;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!a(paramContext, "android.permission.READ_PHONE_STATE")) {
          break label359;
        }
        paramContext = localTelephonyManager.getDeviceId();
        ax.c(a, "No IMEI.", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          ax.a(a, new Object[] { "getDeviceId, IMEI: " + paramContext });
          if (!TextUtils.isEmpty(paramContext)) {
            break label357;
          }
          if (Build.VERSION.SDK_INT >= 9) {
            paramContext = Build.SERIAL;
          }
          ax.a(a, new Object[] { "getDeviceId, serial no: " + paramContext });
          localObject = paramContext;
          return (String)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            String str1;
            continue;
            paramContext = str2;
          }
        }
        localException1 = localException1;
        paramContext = str2;
      }
      continue;
      str2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      ax.a(a, new Object[] { "getDeviceId: Secure.ANDROID_ID: " + str2 });
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        ax.c(a, new Object[] { "No IMEI." });
        str2 = o(paramContext);
        str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (localTelephonyManager != null)
          {
            try
            {
              if (a(paramContext, "android.permission.READ_PHONE_STATE"))
              {
                paramContext = localTelephonyManager.getDeviceId();
                return paramContext;
              }
            }
            catch (Exception paramContext)
            {
              ax.c(a, "No IMEI.", paramContext);
              return str2;
            }
            label357:
            return paramContext;
            label359:
            paramContext = str2;
          }
        }
      }
    }
  }
  
  private static int a(Object paramObject, String paramString)
  {
    try
    {
      paramString = DisplayMetrics.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      int i = paramString.getInt(paramObject);
      return i;
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return -1;
  }
  
  public static String a()
  {
    String str = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        FileReader localFileReader = new FileReader("/proc/cpuinfo");
        if (localFileReader != null) {
          localObject1 = str;
        }
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(localFileReader, 1024);
          localObject1 = str;
          str = localBufferedReader.readLine();
          localObject1 = str;
          Object localObject2 = str;
          ax.d(a, "Could not open file /proc/cpuinfo", localFileNotFoundException1);
        }
        catch (IOException localIOException)
        {
          try
          {
            localBufferedReader.close();
            localObject1 = str;
            localObject2 = str;
            localFileReader.close();
            localObject1 = str;
            if (localObject1 == null) {
              continue;
            }
            return ((String)localObject1).substring(((String)localObject1).indexOf(':') + 1).trim();
          }
          catch (FileNotFoundException localFileNotFoundException1)
          {
            localObject1 = localObject2;
          }
          localIOException = localIOException;
          localObject2 = localObject1;
          ax.d(a, "Could not read from file /proc/cpuinfo", localIOException);
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        localObject1 = null;
      }
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return String.valueOf(i);
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 136	java/io/FileReader
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 141	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   11: astore 5
    //   13: aload 4
    //   15: astore_1
    //   16: aload 5
    //   18: ifnull +47 -> 65
    //   21: new 143	java/io/BufferedReader
    //   24: dup
    //   25: aload 5
    //   27: sipush 1024
    //   30: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_2
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: astore_0
    //   43: aload 5
    //   45: ifnull +8 -> 53
    //   48: aload 5
    //   50: invokevirtual 153	java/io/FileReader:close	()V
    //   53: aload_0
    //   54: astore_1
    //   55: aload_2
    //   56: ifnull +9 -> 65
    //   59: aload_2
    //   60: invokevirtual 152	java/io/BufferedReader:close	()V
    //   63: aload_0
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   72: goto -19 -> 53
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   80: aload_0
    //   81: areturn
    //   82: astore_3
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: getstatic 16	d/a/av:a	Ljava/lang/String;
    //   90: new 54	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   97: ldc -54
    //   99: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: aload_3
    //   110: invokestatic 171	d/a/ax:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload 5
    //   115: ifnull +8 -> 123
    //   118: aload 5
    //   120: invokevirtual 153	java/io/FileReader:close	()V
    //   123: aload 4
    //   125: astore_1
    //   126: aload_2
    //   127: ifnull -62 -> 65
    //   130: aload_2
    //   131: invokevirtual 152	java/io/BufferedReader:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   148: goto -25 -> 123
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_1
    //   154: aload 5
    //   156: ifnull +8 -> 164
    //   159: aload 5
    //   161: invokevirtual 153	java/io/FileReader:close	()V
    //   164: aload_1
    //   165: ifnull +7 -> 172
    //   168: aload_1
    //   169: invokevirtual 152	java/io/BufferedReader:close	()V
    //   172: aload_0
    //   173: athrow
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   179: goto -15 -> 164
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   187: goto -15 -> 172
    //   190: astore_0
    //   191: goto -37 -> 154
    //   194: astore_3
    //   195: goto -110 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   15	51	1	localObject1	Object
    //   67	2	1	localIOException1	IOException
    //   75	2	1	localIOException2	IOException
    //   86	83	1	localObject2	Object
    //   182	2	1	localIOException3	IOException
    //   33	98	2	localBufferedReader	BufferedReader
    //   174	2	2	localIOException4	IOException
    //   40	2	3	str	String
    //   82	28	3	localIOException5	IOException
    //   194	1	3	localIOException6	IOException
    //   1	123	4	localObject3	Object
    //   11	149	5	localFileReader	FileReader
    // Exception table:
    //   from	to	target	type
    //   48	53	67	java/io/IOException
    //   59	63	75	java/io/IOException
    //   21	34	82	java/io/IOException
    //   130	134	136	java/io/IOException
    //   118	123	143	java/io/IOException
    //   21	34	151	finally
    //   159	164	174	java/io/IOException
    //   168	172	182	java/io/IOException
    //   36	41	190	finally
    //   87	113	190	finally
    //   36	41	194	java/io/IOException
  }
  
  private static String a(Properties paramProperties)
  {
    paramProperties = paramProperties.getProperty("ro.yunos.version");
    if (!TextUtils.isEmpty(paramProperties)) {
      return paramProperties;
    }
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i]);
      int j = ((String)localObject2).length();
      Object localObject1 = localObject2;
      if (j == 1) {
        localObject1 = "0" + (String)localObject2;
      }
      localObject2 = localObject1;
      if (j > 2) {
        localObject2 = ((String)localObject1).substring(j - 2, j);
      }
      localStringBuilder.append(((String)localObject2).toUpperCase());
      if (i < paramArrayOfByte.length - 1) {
        localStringBuilder.append(':');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      int i = ((Integer)Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[] { String.class }).invoke(paramContext, new Object[] { paramString })).intValue();
      if (i == 0) {
        bool = true;
      }
      do
      {
        for (;;)
        {
          return bool;
          bool = false;
        }
      } while (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) != 0);
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private static String b()
  {
    int i = 0;
    if (d.a)
    {
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "/sys/class/net/wlan0/address";
      arrayOfString[1] = "/sys/class/net/eth0/address";
      arrayOfString[2] = "/sys/devices/virtual/net/wlan0/address";
      while (i < arrayOfString.length) {
        try
        {
          String str = a(arrayOfString[i]);
          if (str != null) {
            return str;
          }
        }
        catch (Exception localException)
        {
          ax.d(a, "open file  Failed", localException);
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return "";
  }
  
  private static String b(Properties paramProperties)
  {
    try
    {
      paramProperties = paramProperties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
      if (paramProperties.contains("flyme os"))
      {
        paramProperties = paramProperties.split(" ")[2];
        return paramProperties;
      }
    }
    catch (Exception paramProperties) {}
    return null;
  }
  
  public static String c(Context paramContext)
  {
    if ((b.a.c.a() == a.d(paramContext)) || (b.a.d.a() == a.d(paramContext))) {
      return A(paramContext);
    }
    return z(paramContext);
  }
  
  /* Error */
  private static Properties c()
  {
    // Byte code:
    //   0: new 207	java/util/Properties
    //   3: dup
    //   4: invokespecial 321	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_0
    //   10: new 323	java/io/FileInputStream
    //   13: dup
    //   14: new 325	java/io/File
    //   17: dup
    //   18: invokestatic 331	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   21: ldc_w 333
    //   24: invokespecial 336	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: invokespecial 339	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 343	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 344	java/io/FileInputStream:close	()V
    //   46: aload_3
    //   47: areturn
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   53: aload_3
    //   54: areturn
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_2
    //   61: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   64: aload_1
    //   65: ifnull -19 -> 46
    //   68: aload_1
    //   69: invokevirtual 344	java/io/FileInputStream:close	()V
    //   72: aload_3
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   79: aload_3
    //   80: areturn
    //   81: astore_2
    //   82: aload_0
    //   83: astore_1
    //   84: aload_2
    //   85: astore_0
    //   86: aload_1
    //   87: ifnull +7 -> 94
    //   90: aload_1
    //   91: invokevirtual 344	java/io/FileInputStream:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   101: goto -7 -> 94
    //   104: astore_2
    //   105: aload_0
    //   106: astore_1
    //   107: aload_2
    //   108: astore_0
    //   109: goto -23 -> 86
    //   112: astore_2
    //   113: goto -55 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	24	0	localObject1	Object
    //   48	2	0	localIOException1	IOException
    //   59	1	0	localObject2	Object
    //   74	9	0	localIOException2	IOException
    //   85	24	0	localObject3	Object
    //   30	61	1	localObject4	Object
    //   96	2	1	localIOException3	IOException
    //   106	1	1	localObject5	Object
    //   55	6	2	localIOException4	IOException
    //   81	4	2	localObject6	Object
    //   104	4	2	localObject7	Object
    //   112	1	2	localIOException5	IOException
    //   7	73	3	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   42	46	48	java/io/IOException
    //   10	31	55	java/io/IOException
    //   68	72	74	java/io/IOException
    //   10	31	81	finally
    //   90	94	96	java/io/IOException
    //   33	38	104	finally
    //   60	64	104	finally
    //   33	38	112	java/io/IOException
  }
  
  public static String d(Context paramContext)
  {
    return aw.b(c(paramContext));
  }
  
  private static boolean d()
  {
    try
    {
      Build.class.getMethod("hasSmartBar", new Class[0]);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String e(Context paramContext)
  {
    if (f(paramContext) == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramContext.getResources().getConfiguration().mcc;
      j = paramContext.getResources().getConfiguration().mnc;
    } while (i == 0);
    paramContext = String.valueOf(j);
    if (j < 10) {
      paramContext = String.format("%02d", new Object[] { Integer.valueOf(j) });
    }
    return String.valueOf(i) + paramContext;
  }
  
  public static String f(Context paramContext)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      return localTelephonyManager.getSubscriberId();
    }
    return null;
  }
  
  public static String g(Context paramContext)
  {
    TelephonyManager localTelephonyManager;
    do
    {
      try
      {
        localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
          continue;
        }
        return "";
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return "";
      }
      paramContext = localTelephonyManager.getNetworkOperatorName();
      return paramContext;
    } while (localTelephonyManager != null);
    return "";
  }
  
  public static String[] h(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    try
    {
      if (!a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        arrayOfString[0] = "";
        return arrayOfString;
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        arrayOfString[0] = "";
        return arrayOfString;
      }
      if (paramContext.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED)
      {
        arrayOfString[0] = "Wi-Fi";
        return arrayOfString;
      }
      paramContext = paramContext.getNetworkInfo(0);
      if (paramContext.getState() == NetworkInfo.State.CONNECTED)
      {
        arrayOfString[0] = "2G/3G";
        arrayOfString[1] = paramContext.getSubtypeName();
        return arrayOfString;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return arrayOfString;
  }
  
  public static boolean i(Context paramContext)
  {
    return "Wi-Fi".equals(h(paramContext)[0]);
  }
  
  public static boolean j(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        boolean bool = paramContext.isConnectedOrConnecting();
        return bool;
      }
      return false;
    }
    catch (Exception paramContext) {}
    return true;
  }
  
  public static int k(Context paramContext)
  {
    try
    {
      paramContext = Calendar.getInstance(x(paramContext));
      if (paramContext != null)
      {
        int i = paramContext.getTimeZone().getRawOffset() / 3600000;
        return i;
      }
    }
    catch (Exception paramContext)
    {
      ax.b(a, "error in getTimeZone", paramContext);
    }
    return 8;
  }
  
  public static boolean l(Context paramContext)
  {
    String str = dk.a(paramContext).b().a("");
    if (!TextUtils.isEmpty(str)) {
      if (!str.equals("cn")) {}
    }
    do
    {
      return true;
      return false;
      if (f(paramContext) != null) {
        break;
      }
      paramContext = m(paramContext)[0];
    } while ((!TextUtils.isEmpty(paramContext)) && (paramContext.equalsIgnoreCase("cn")));
    do
    {
      int i;
      do
      {
        return false;
        i = paramContext.getResources().getConfiguration().mcc;
        if ((i == 460) || (i == 461)) {
          break;
        }
      } while (i != 0);
      paramContext = m(paramContext)[0];
    } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equalsIgnoreCase("cn")));
    return true;
  }
  
  public static String[] m(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    try
    {
      paramContext = x(paramContext);
      if (paramContext != null)
      {
        arrayOfString[0] = paramContext.getCountry();
        arrayOfString[1] = paramContext.getLanguage();
      }
      if (TextUtils.isEmpty(arrayOfString[0])) {
        arrayOfString[0] = "Unknown";
      }
      if (TextUtils.isEmpty(arrayOfString[1])) {
        arrayOfString[1] = "Unknown";
      }
      return arrayOfString;
    }
    catch (Exception paramContext)
    {
      ax.d(a, "error in getLocaleInfo", paramContext);
    }
    return arrayOfString;
  }
  
  public static String n(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.getString("UMENG_APPKEY");
        if (paramContext != null) {
          return paramContext.trim();
        }
        ax.b(a, new Object[] { "getAppkey failed. the applicationinfo is null!" });
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ax.d(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", paramContext);
      }
    }
    return null;
  }
  
  public static String o(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      String str2 = b();
      String str1 = str2;
      if (str2 == null) {
        str1 = y(paramContext);
      }
      return str1;
    }
    return y(paramContext);
  }
  
  public static int[] p(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((paramContext.getApplicationInfo().flags & 0x2000) != 0) {
          break label129;
        }
        j = a(localDisplayMetrics, "noncompatWidthPixels");
        i = a(localDisplayMetrics, "noncompatHeightPixels");
      }
      catch (Exception paramContext)
      {
        DisplayMetrics localDisplayMetrics;
        label78:
        ax.d(a, "read resolution fail", paramContext);
        return null;
      }
      int i = localDisplayMetrics.widthPixels;
      int j = localDisplayMetrics.heightPixels;
      int k = i;
      i = j;
      paramContext = new int[2];
      if (k > i)
      {
        paramContext[0] = i;
        paramContext[1] = k;
        return paramContext;
      }
      paramContext[0] = k;
      paramContext[1] = i;
      return paramContext;
      label129:
      do
      {
        k = j;
        break label78;
        i = -1;
        j = -1;
        if (j == -1) {
          break;
        }
      } while (i != -1);
    }
  }
  
  public static String q(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("UMENG_CHANNEL");
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          if (paramContext != null) {
            return paramContext;
          }
          ax.a(a, new Object[] { "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml." });
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ax.a(a, new Object[] { "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml." });
        paramContext.printStackTrace();
      }
    }
    return "Unknown";
  }
  
  public static String r(Context paramContext)
  {
    return paramContext.getPackageName();
  }
  
  public static String s(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(r(paramContext), 64);
      localObject = new ByteArrayInputStream(paramContext.signatures[0].toByteArray());
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      try
      {
        paramContext = CertificateFactory.getInstance("X509");
      }
      catch (CertificateException paramContext)
      {
        try
        {
          for (;;)
          {
            paramContext = (X509Certificate)paramContext.generateCertificate((InputStream)localObject);
            try
            {
              paramContext = a(MessageDigest.getInstance("MD5").digest(paramContext.getEncoded()));
              return paramContext;
            }
            catch (NoSuchAlgorithmException paramContext)
            {
              paramContext.printStackTrace();
              return null;
            }
            catch (CertificateEncodingException paramContext)
            {
              paramContext.printStackTrace();
            }
            paramContext = paramContext;
            paramContext.printStackTrace();
            paramContext = null;
            continue;
            paramContext = paramContext;
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
        catch (CertificateException paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
      }
    }
    return null;
  }
  
  public static String t(Context paramContext)
  {
    return paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo()).toString();
  }
  
  public static String u(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ax.a(a, paramContext);
    }
    return null;
  }
  
  public static String v(Context paramContext)
  {
    Properties localProperties = c();
    try
    {
      paramContext = localProperties.getProperty("ro.miui.ui.version.name");
      if (TextUtils.isEmpty(paramContext))
      {
        if (d()) {
          return "Flyme";
        }
        if (!TextUtils.isEmpty(a(localProperties))) {
          return "YunOS";
        }
      }
      else
      {
        return "MIUI";
      }
    }
    catch (Exception localException)
    {
      paramContext = null;
      localException.printStackTrace();
    }
    return paramContext;
  }
  
  public static String w(Context paramContext)
  {
    Properties localProperties = c();
    try
    {
      String str = localProperties.getProperty("ro.miui.ui.version.name");
      paramContext = str;
      if (TextUtils.isEmpty(str))
      {
        boolean bool = d();
        if (!bool) {
          break label36;
        }
      }
      label36:
      return str;
    }
    catch (Exception paramContext)
    {
      try
      {
        paramContext = b(localProperties);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        return str;
      }
      try
      {
        paramContext = a(localProperties);
        return paramContext;
      }
      catch (Exception paramContext) {}
      paramContext = paramContext;
      paramContext.printStackTrace();
      return null;
    }
  }
  
  private static Locale x(Context paramContext)
  {
    localObject = null;
    try
    {
      Configuration localConfiguration = new Configuration();
      localConfiguration.setToDefaults();
      Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
      paramContext = (Context)localObject;
      if (localConfiguration != null) {
        paramContext = localConfiguration.locale;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ax.b(a, new Object[] { "fail to read user config locale" });
        paramContext = (Context)localObject;
      }
    }
    localObject = paramContext;
    if (paramContext == null) {
      localObject = Locale.getDefault();
    }
    return (Locale)localObject;
  }
  
  private static String y(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        return localWifiManager.getConnectionInfo().getMacAddress();
      }
      ax.c(a, new Object[] { "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE" });
      return "";
    }
    catch (Exception paramContext)
    {
      ax.c(a, new Object[] { "Could not get mac address." + paramContext.toString() });
    }
    return "";
  }
  
  private static String z(Context paramContext)
  {
    String str3 = "";
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (Build.VERSION.SDK_INT >= 23) {
      if (localTelephonyManager == null) {
        break label379;
      }
    }
    for (;;)
    {
      try
      {
        if (!a(paramContext, "android.permission.READ_PHONE_STATE")) {
          break label379;
        }
        str3 = localTelephonyManager.getDeviceId();
        Object localObject;
        ax.c(a, "No IMEI.", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          ax.a(a, new Object[] { "getDeviceId, IMEI: " + str3 });
          localObject = str3;
          if (TextUtils.isEmpty(str3))
          {
            str3 = b();
            ax.a(a, new Object[] { "getDeviceId, mc: " + str3 });
            localObject = str3;
            if (TextUtils.isEmpty(str3))
            {
              paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
              ax.a(a, new Object[] { "getDeviceId, android_id: " + paramContext });
              localObject = paramContext;
              if (TextUtils.isEmpty(paramContext))
              {
                localObject = paramContext;
                if (Build.VERSION.SDK_INT >= 9) {
                  localObject = Build.SERIAL;
                }
                ax.a(a, new Object[] { "getDeviceId, serial no: " + (String)localObject });
              }
            }
          }
          return (String)localObject;
        }
        catch (Exception localException3)
        {
          String str1;
          for (;;) {}
          return localException3;
        }
        localException1 = localException1;
        str3 = "";
      }
      continue;
      str1 = str3;
      if (localTelephonyManager != null) {
        str1 = str3;
      }
      try
      {
        if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
          str1 = localTelephonyManager.getDeviceId();
        }
        if (TextUtils.isEmpty(str1))
        {
          ax.c(a, new Object[] { "No IMEI." });
          str3 = o(paramContext);
          str1 = str3;
          if (!TextUtils.isEmpty(str3)) {
            continue;
          }
          ax.c(a, new Object[] { "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead." });
          paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
          ax.a(a, new Object[] { "getDeviceId: Secure.ANDROID_ID: " + paramContext });
          return paramContext;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ax.c(a, "No IMEI.", localException2);
          String str2 = str3;
        }
      }
      label379:
      str3 = "";
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\d\a\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */