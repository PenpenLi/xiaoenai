package com.mob.tools.b;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.e;
import com.mob.tools.log.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class c
{
  private static c b;
  private Context a;
  
  private c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private String I()
  {
    Object localObject1 = NetworkInterface.getNetworkInterfaces();
    if (localObject1 == null) {
      return null;
    }
    Object localObject3;
    do
    {
      NetworkInterface localNetworkInterface;
      do
      {
        localObject1 = Collections.list((Enumeration)localObject1).iterator();
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localNetworkInterface = (NetworkInterface)((Iterator)localObject1).next();
            localObject2 = localNetworkInterface.getInetAddresses();
          } while (localObject2 == null);
          localObject2 = Collections.list((Enumeration)localObject2).iterator();
        }
        localObject3 = (InetAddress)((Iterator)localObject2).next();
      } while ((((InetAddress)localObject3).isLoopbackAddress()) || (!(localObject3 instanceof Inet4Address)));
      localObject3 = localNetworkInterface.getHardwareAddress();
    } while (localObject3 == null);
    localObject1 = new StringBuilder();
    int j = localObject3.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject1).append(String.format("%02x:", new Object[] { Byte.valueOf(localObject3[i]) }));
      i += 1;
    }
    if (((StringBuilder)localObject1).length() > 0) {
      ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    }
    return ((StringBuilder)localObject1).toString();
    return null;
  }
  
  private String[] J()
  {
    int j = 0;
    Object localObject1 = NetworkInterface.getNetworkInterfaces();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = Collections.list((Enumeration)localObject1);
    localObject1 = new HashMap();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (NetworkInterface)((Iterator)localObject2).next();
      localObject4 = ((NetworkInterface)localObject3).getHardwareAddress();
      if (localObject4 != null)
      {
        localObject5 = new StringBuilder();
        int k = localObject4.length;
        i = 0;
        while (i < k)
        {
          ((StringBuilder)localObject5).append(String.format("%02x:", new Object[] { Byte.valueOf(localObject4[i]) }));
          i += 1;
        }
        if (((StringBuilder)localObject5).length() > 0) {
          ((StringBuilder)localObject5).deleteCharAt(((StringBuilder)localObject5).length() - 1);
        }
        ((HashMap)localObject1).put(((NetworkInterface)localObject3).getName(), ((StringBuilder)localObject5).toString());
      }
    }
    localObject2 = new ArrayList(((HashMap)localObject1).keySet());
    Object localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    Object localObject5 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    while (((ArrayList)localObject2).size() > 0)
    {
      String str = (String)((ArrayList)localObject2).remove(0);
      if (str.startsWith("wlan")) {
        ((ArrayList)localObject3).add(str);
      } else if (str.startsWith("eth")) {
        ((ArrayList)localObject4).add(str);
      } else if (str.startsWith("rev_rmnet")) {
        ((ArrayList)localObject5).add(str);
      } else if (str.startsWith("dummy")) {
        localArrayList1.add(str);
      } else if (str.startsWith("usbnet")) {
        localArrayList2.add(str);
      } else if (str.startsWith("rmnet_usb")) {
        localArrayList3.add(str);
      } else {
        localArrayList4.add(str);
      }
    }
    Collections.sort((List)localObject3);
    Collections.sort((List)localObject4);
    Collections.sort((List)localObject5);
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    Collections.sort(localArrayList3);
    Collections.sort(localArrayList4);
    ((ArrayList)localObject2).addAll((Collection)localObject3);
    ((ArrayList)localObject2).addAll((Collection)localObject4);
    ((ArrayList)localObject2).addAll((Collection)localObject5);
    ((ArrayList)localObject2).addAll(localArrayList1);
    ((ArrayList)localObject2).addAll(localArrayList2);
    ((ArrayList)localObject2).addAll(localArrayList3);
    ((ArrayList)localObject2).addAll(localArrayList4);
    localObject3 = new String[((ArrayList)localObject2).size()];
    int i = j;
    while (i < localObject3.length)
    {
      localObject3[i] = ((String)((HashMap)localObject1).get(((ArrayList)localObject2).get(i)));
      i += 1;
    }
    return (String[])localObject3;
  }
  
  private boolean K()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)c("phone");
    if (localTelephonyManager == null) {
      return false;
    }
    if (localTelephonyManager.getNetworkType() == 13) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean L()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)c("phone");
    if (localTelephonyManager == null) {
      return false;
    }
    switch (localTelephonyManager.getNetworkType())
    {
    default: 
      return false;
    case 7: 
      return false;
    case 4: 
      return false;
    case 2: 
      return false;
    case 5: 
      return true;
    case 6: 
      return true;
    case 1: 
      return false;
    case 8: 
      return true;
    case 10: 
      return true;
    case 9: 
      return true;
    case 3: 
      return true;
    case 14: 
      return true;
    case 12: 
      return true;
    case 15: 
      return true;
    case 11: 
      return false;
    case 13: 
      return true;
    }
    return false;
  }
  
  private String M()
  {
    if (!C()) {}
    do
    {
      return null;
      localObject = new File(D(), "ShareSDK");
      if (((File)localObject).exists())
      {
        localObject = new File((File)localObject, ".dk");
        if ((((File)localObject).exists()) && (((File)localObject).renameTo(new File(g.b(this.a), ".dk")))) {
          ((File)localObject).delete();
        }
      }
      localObject = new File(g.b(this.a), ".dk");
    } while (!((File)localObject).exists());
    ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream((File)localObject));
    Object localObject = localObjectInputStream.readObject();
    if ((localObject != null) && ((localObject instanceof char[]))) {}
    for (localObject = String.valueOf((char[])localObject);; localObject = null)
    {
      localObjectInputStream.close();
      return (String)localObject;
    }
  }
  
  public static c a(Context paramContext)
  {
    if ((b == null) && (paramContext != null)) {
      b = new c(paramContext);
    }
    return b;
  }
  
  private boolean a(PackageInfo paramPackageInfo)
  {
    boolean bool = false;
    int i;
    if ((paramPackageInfo.applicationInfo.flags & 0x1) == 1)
    {
      i = 1;
      if ((paramPackageInfo.applicationInfo.flags & 0x80) != 1) {
        break label54;
      }
    }
    label54:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 255	java/io/BufferedReader
    //   5: dup
    //   6: new 257	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 263	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 72	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 265
    //   23: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 267
    //   33: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokevirtual 271	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   42: invokevirtual 277	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   45: invokespecial 278	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: invokespecial 281	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 284	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: astore_3
    //   59: aload_3
    //   60: astore_1
    //   61: aload_2
    //   62: ifnull +9 -> 71
    //   65: aload_2
    //   66: invokevirtual 285	java/io/BufferedReader:close	()V
    //   69: aload_3
    //   70: astore_1
    //   71: aload_1
    //   72: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +50 -> 125
    //   78: aconst_null
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: invokestatic 296	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   88: aload_3
    //   89: invokevirtual 302	com/mob/tools/log/d:d	(Ljava/lang/Throwable;)I
    //   92: pop
    //   93: aload_2
    //   94: ifnull +55 -> 149
    //   97: aload_2
    //   98: invokevirtual 285	java/io/BufferedReader:close	()V
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -32 -> 71
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -38 -> 71
    //   112: astore_1
    //   113: aload_3
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 285	java/io/BufferedReader:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: aload_1
    //   126: areturn
    //   127: astore_1
    //   128: aload_3
    //   129: astore_1
    //   130: goto -59 -> 71
    //   133: astore_2
    //   134: goto -11 -> 123
    //   137: astore_3
    //   138: aload_1
    //   139: astore_2
    //   140: aload_3
    //   141: astore_1
    //   142: goto -27 -> 115
    //   145: astore_3
    //   146: goto -63 -> 83
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -80 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	c
    //   0	154	1	paramString	String
    //   51	69	2	localObject1	Object
    //   133	1	2	localThrowable1	Throwable
    //   139	1	2	str1	String
    //   1	69	3	str2	String
    //   80	49	3	localThrowable2	Throwable
    //   137	4	3	localObject2	Object
    //   145	1	3	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	52	80	java/lang/Throwable
    //   97	101	106	java/lang/Throwable
    //   2	52	112	finally
    //   65	69	127	java/lang/Throwable
    //   119	123	133	java/lang/Throwable
    //   54	59	137	finally
    //   85	93	137	finally
    //   54	59	145	java/lang/Throwable
  }
  
  private Object c(String paramString)
  {
    try
    {
      paramString = this.a.getSystemService(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      e.a().w(paramString);
    }
    return null;
  }
  
  private void d(String paramString)
  {
    if (!C()) {
      return;
    }
    Object localObject = new File(g.b(this.a), ".dk");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = new ObjectOutputStream(new FileOutputStream((File)localObject));
    ((ObjectOutputStream)localObject).writeObject(paramString.toCharArray());
    ((ObjectOutputStream)localObject).flush();
    ((ObjectOutputStream)localObject).close();
  }
  
  public String A()
  {
    try
    {
      String str = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionName;
      return str;
    }
    catch (Throwable localThrowable)
    {
      e.a().d(localThrowable);
    }
    return "1.0";
  }
  
  /* Error */
  public String B()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 352
    //   4: invokevirtual 354	com/mob/tools/b/c:a	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +99 -> 108
    //   12: aload_0
    //   13: ldc_w 356
    //   16: invokespecial 172	com/mob/tools/b/c:c	(Ljava/lang/String;)Ljava/lang/Object;
    //   19: checkcast 358	android/app/ActivityManager
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +19 -> 43
    //   27: aconst_null
    //   28: areturn
    //   29: astore_1
    //   30: invokestatic 296	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   33: aload_1
    //   34: invokevirtual 308	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
    //   37: pop
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -32 -> 8
    //   43: getstatic 363	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 20
    //   48: if_icmpgt +24 -> 72
    //   51: aload_1
    //   52: iconst_1
    //   53: invokevirtual 367	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   56: iconst_0
    //   57: invokeinterface 368 2 0
    //   62: checkcast 370	android/app/ActivityManager$RunningTaskInfo
    //   65: getfield 374	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   68: invokevirtual 377	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   71: areturn
    //   72: aload_1
    //   73: invokevirtual 381	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   76: iconst_0
    //   77: invokeinterface 368 2 0
    //   82: checkcast 383	android/app/ActivityManager$RunningAppProcessInfo
    //   85: getfield 386	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   88: ldc_w 388
    //   91: invokevirtual 392	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   94: iconst_0
    //   95: aaload
    //   96: astore_1
    //   97: aload_1
    //   98: areturn
    //   99: astore_1
    //   100: invokestatic 296	com/mob/tools/e:a	()Lcom/mob/tools/log/d;
    //   103: aload_1
    //   104: invokevirtual 308	com/mob/tools/log/d:w	(Ljava/lang/Throwable;)I
    //   107: pop
    //   108: aconst_null
    //   109: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	c
    //   22	2	1	localActivityManager	android.app.ActivityManager
    //   29	44	1	localThrowable1	Throwable
    //   96	2	1	str	String
    //   99	5	1	localThrowable2	Throwable
    //   7	33	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	8	29	java/lang/Throwable
    //   12	23	99	java/lang/Throwable
    //   43	72	99	java/lang/Throwable
    //   72	97	99	java/lang/Throwable
  }
  
  public boolean C()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (a("android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        boolean bool3 = "mounted".equals(Environment.getExternalStorageState());
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      e.a().w(localThrowable);
    }
    return false;
  }
  
  public String D()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }
  
  public String E()
  {
    String str = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
    e.a().i("getAndroidID === " + str, new Object[0]);
    return str;
  }
  
  public String F()
  {
    try
    {
      Object localObject1 = new Intent("com.google.android.gms.ads.identifier.service.START");
      ((Intent)localObject1).setPackage("com.google.android.gms");
      Object localObject2 = new a(null);
      this.a.bindService((Intent)localObject1, (ServiceConnection)localObject2, 1);
      Object localObject3 = ((a)localObject2).a();
      localObject1 = Parcel.obtain();
      localObject2 = Parcel.obtain();
      ((Parcel)localObject1).writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
      ((IBinder)localObject3).transact(1, (Parcel)localObject1, (Parcel)localObject2, 0);
      ((Parcel)localObject2).readException();
      localObject3 = ((Parcel)localObject2).readString();
      ((Parcel)localObject2).recycle();
      ((Parcel)localObject1).recycle();
      e.a().i("getAdvertisingID === " + (String)localObject3, new Object[0]);
      return (String)localObject3;
    }
    catch (Throwable localThrowable)
    {
      e.a().d(localThrowable);
    }
    return null;
  }
  
  public int G()
  {
    try
    {
      if (a("android.permission.ACCESS_COARSE_LOCATION"))
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)c("phone");
        if (localTelephonyManager != null)
        {
          int i = ((GsmCellLocation)localTelephonyManager.getCellLocation()).getCid();
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().d(localThrowable);
    }
    return -1;
  }
  
  public int H()
  {
    try
    {
      if (a("android.permission.ACCESS_COARSE_LOCATION"))
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)c("phone");
        if (localTelephonyManager != null)
        {
          int i = ((GsmCellLocation)localTelephonyManager.getCellLocation()).getLac();
          return i;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().d(localThrowable);
    }
    return -1;
  }
  
  public String a()
  {
    Object localObject = (WifiManager)c("wifi");
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((WifiManager)localObject).getConnectionInfo();
    } while (localObject == null);
    String str = ((WifiInfo)localObject).getSSID().replace("\"", "");
    localObject = str;
    if (str == null) {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String a(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = SystemClock.elapsedRealtime();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(l1 ^ l2);
    Random localRandom = new Random();
    int i = 0;
    if (i < paramInt)
    {
      String str;
      if (localRandom.nextInt(2) % 2 == 0)
      {
        str = "char";
        label61:
        if (!"char".equalsIgnoreCase(str)) {
          break label107;
        }
        localStringBuffer.insert(i + 1, (char)(localRandom.nextInt(26) + 97));
      }
      for (;;)
      {
        i += 1;
        break;
        str = "num";
        break label61;
        label107:
        localStringBuffer.insert(localStringBuffer.length(), localRandom.nextInt(10));
      }
    }
    return localStringBuffer.toString().substring(0, 40);
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Base64.encodeToString(b.a(paramString2, paramString1), 0);
      paramString2 = paramString1;
      e.a().w(paramString2);
    }
    catch (Throwable paramString2)
    {
      try
      {
        if (paramString1.contains("\n")) {
          paramString2 = paramString1.replace("\n", "");
        }
        return paramString2;
      }
      catch (Throwable paramString2)
      {
        for (;;) {}
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    return paramString1;
  }
  
  public ArrayList<HashMap<String, String>> a(boolean paramBoolean)
  {
    try
    {
      PackageManager localPackageManager = this.a.getPackageManager();
      Object localObject = localPackageManager.getInstalledPackages(0);
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if ((paramBoolean) || (!a(localPackageInfo)))
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("pkg", localPackageInfo.packageName);
          localHashMap.put("name", localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString());
          localHashMap.put("version", localPackageInfo.versionName);
          localArrayList.add(localHashMap);
        }
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      e.a().w(localThrowable);
      return new ArrayList();
    }
  }
  
  public boolean a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      try
      {
        h.a("android.content.Context");
        paramString = (Integer)h.a(this.a, "checkSelfPermission", new Object[] { paramString });
        if (paramString == null) {
          i = -1;
        } else {
          i = paramString.intValue();
        }
      }
      catch (Throwable paramString)
      {
        e.a().w(paramString);
        i = -1;
      }
    }
    this.a.checkPermission(paramString, Process.myPid(), Process.myUid());
    int i = this.a.getPackageManager().checkPermission(paramString, x());
    while (i != 0) {
      return false;
    }
    return true;
  }
  
  public String b()
  {
    Object localObject = (WifiManager)c("wifi");
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((WifiManager)localObject).getConnectionInfo();
    } while (localObject == null);
    String str = ((WifiInfo)localObject).getBSSID();
    localObject = str;
    if (str == null) {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String c()
  {
    Object localObject5 = null;
    if (Build.VERSION.SDK_INT >= 23) {}
    do
    {
      do
      {
        try
        {
          localObject4 = b("wlan0");
          localObject1 = localObject4;
          if (localObject4 != null) {}
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            Object localObject1 = I();
            localObject4 = localObject1;
            if (localObject1 == null) {}
            try
            {
              String[] arrayOfString = J();
              localObject4 = localObject1;
              if (arrayOfString.length > 0) {
                localObject4 = arrayOfString[0];
              }
            }
            catch (Throwable localThrowable3)
            {
              for (;;)
              {
                Object localObject2;
                e.a().d(localThrowable3);
                localObject4 = null;
              }
            }
            if (localObject4 != null)
            {
              localObject1 = localObject4;
              return (String)localObject1;
              localThrowable1 = localThrowable1;
              e.a().d(localThrowable1);
              localObject4 = null;
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              e.a().d(localThrowable2);
              localObject2 = null;
            }
          }
        }
        localObject4 = (WifiManager)c("wifi");
        localObject3 = localObject5;
      } while (localObject4 == null);
      localObject4 = ((WifiManager)localObject4).getConnectionInfo();
      localObject3 = localObject5;
    } while (localObject4 == null);
    Object localObject4 = ((WifiInfo)localObject4).getMacAddress();
    Object localObject3 = localObject4;
    if (localObject4 == null) {
      localObject3 = null;
    }
    return (String)localObject3;
  }
  
  public String d()
  {
    return Build.MODEL;
  }
  
  public String e()
  {
    return Build.MANUFACTURER;
  }
  
  public String f()
  {
    String str2 = g();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 9) {
        str1 = h();
      }
    }
    return str1;
  }
  
  public String g()
  {
    Object localObject1 = (TelephonyManager)c("phone");
    if (localObject1 == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (a("android.permission.READ_PHONE_STATE"))
        {
          localObject1 = ((TelephonyManager)localObject1).getDeviceId();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          return (String)localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          e.a().w(localThrowable);
          Object localObject2 = null;
        }
      }
    }
  }
  
  public String h()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      try
      {
        Object localObject = Class.forName("android.os.SystemProperties");
        localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.serialno", "unknown" });
        return (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        e.a().d(localThrowable);
        return null;
      }
    }
    return null;
  }
  
  public String i()
  {
    return a(d() + "|" + l() + "|" + e() + "|" + p() + "|" + o(), w().substring(0, 16));
  }
  
  public String j()
  {
    return d() + "|" + k() + "|" + e() + "|" + p() + "|" + o();
  }
  
  public String k()
  {
    return String.valueOf(l());
  }
  
  public int l()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public String m()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String n()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public String o()
  {
    int[] arrayOfInt = g.a(this.a);
    if (this.a.getResources().getConfiguration().orientation == 1) {
      return arrayOfInt[0] + "x" + arrayOfInt[1];
    }
    return arrayOfInt[1] + "x" + arrayOfInt[0];
  }
  
  public String p()
  {
    Object localObject = (TelephonyManager)c("phone");
    if (localObject == null) {
      localObject = "-1";
    }
    String str;
    do
    {
      return (String)localObject;
      str = ((TelephonyManager)localObject).getSimOperator();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "-1";
  }
  
  public String q()
  {
    Object localObject = (TelephonyManager)c("phone");
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (a("android.permission.READ_PHONE_STATE"))
        {
          localObject = ((TelephonyManager)localObject).getSimOperatorName();
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool) {
            localObject = null;
          }
          return (String)localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        e.a().w(localThrowable);
      }
    }
    return null;
  }
  
  public String r()
  {
    try
    {
      Object localObject = BluetoothAdapter.getDefaultAdapter();
      if ((localObject != null) && (a("android.permission.BLUETOOTH")))
      {
        localObject = ((BluetoothAdapter)localObject).getName();
        return (String)localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().d(localThrowable);
    }
    return null;
  }
  
  public String s()
  {
    try
    {
      String str = b.c(this.a.getPackageManager().getPackageInfo(x(), 64).signatures[0].toByteArray());
      return str;
    }
    catch (Exception localException)
    {
      e.a().w(localException);
    }
    return null;
  }
  
  public String t()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)c("connectivity");
    if (localConnectivityManager == null) {
      return "none";
    }
    try
    {
      if (!a("android.permission.ACCESS_NETWORK_STATE")) {
        return "none";
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().w(localThrowable);
      return "none";
    }
    NetworkInfo localNetworkInfo = localThrowable.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable())) {
      return "none";
    }
    int i = localNetworkInfo.getType();
    switch (i)
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      return String.valueOf(i);
    case 1: 
      return "wifi";
    case 0: 
      if (K()) {
        return "4G";
      }
      if (L()) {
        return "3G";
      }
      return "2G";
    case 7: 
      return "bluetooth";
    case 8: 
      return "dummy";
    case 9: 
      return "ethernet";
    }
    return "wimax";
  }
  
  public String u()
  {
    String str2 = t().toLowerCase();
    String str1;
    if ((TextUtils.isEmpty(str2)) || ("none".equals(str2))) {
      str1 = "none";
    }
    do
    {
      return str1;
      if (str2.startsWith("wifi")) {
        return "wifi";
      }
      if (str2.startsWith("4g")) {
        return "4g";
      }
      if (str2.startsWith("3g")) {
        return "3g";
      }
      if (str2.startsWith("2g")) {
        return "2g";
      }
      str1 = str2;
    } while (!str2.startsWith("bluetooth"));
    return "bluetooth";
  }
  
  public int v()
  {
    return 1;
  }
  
  public String w()
  {
    Object localObject = null;
    for (;;)
    {
      String str2;
      try
      {
        String str1 = M();
        if ((!TextUtils.isEmpty(str1)) && (str1.length() >= 40))
        {
          localObject = str1;
          return (String)localObject;
        }
      }
      catch (Throwable localThrowable1)
      {
        e.a().w(localThrowable1);
        str2 = null;
        continue;
      }
      try
      {
        str2 = c();
        String str3 = f();
        String str4 = d();
        str2 = b.b(b.a(str2 + ":" + str3 + ":" + str4));
        if ((TextUtils.isEmpty(str2)) || (str2.length() < 40))
        {
          str2 = a(40);
          localObject = str2;
          if (str2 == null) {
            continue;
          }
          try
          {
            d(str2);
            return str2;
          }
          catch (Throwable localThrowable4)
          {
            e.a().w(localThrowable4);
            return str2;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          e.a().d(localThrowable2);
          Throwable localThrowable3 = localThrowable4;
        }
      }
    }
  }
  
  public String x()
  {
    return this.a.getPackageName();
  }
  
  public String y()
  {
    String str = this.a.getApplicationInfo().name;
    if (str != null) {
      return str;
    }
    int i = this.a.getApplicationInfo().labelRes;
    if (i > 0) {
      return this.a.getString(i);
    }
    return String.valueOf(this.a.getApplicationInfo().nonLocalizedLabel);
  }
  
  public int z()
  {
    try
    {
      int i = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Throwable localThrowable)
    {
      e.a().d(localThrowable);
    }
    return 0;
  }
  
  private class a
    implements ServiceConnection
  {
    boolean a = false;
    private final BlockingQueue<IBinder> c = new LinkedBlockingQueue();
    
    private a() {}
    
    public IBinder a()
    {
      if (this.a) {
        throw new IllegalStateException();
      }
      this.a = true;
      return (IBinder)this.c.poll(1500L, TimeUnit.MILLISECONDS);
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.c.put(paramIBinder);
        return;
      }
      catch (Throwable paramComponentName)
      {
        e.a().w(paramComponentName);
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */