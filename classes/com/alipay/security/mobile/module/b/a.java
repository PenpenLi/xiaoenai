package com.alipay.security.mobile.module.b;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class a
{
  private static a a = new a();
  
  public static a a()
  {
    return a;
  }
  
  public static String a(Context paramContext)
  {
    Context localContext = null;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getDeviceId();
          localContext = paramContext;
          return localContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      paramContext = null;
    }
  }
  
  /* Error */
  private String a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 42	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: invokestatic 46	com/alipay/security/mobile/module/b/a:o	(Landroid/content/Context;)F
    //   7: fstore_3
    //   8: aconst_null
    //   9: astore_1
    //   10: iload_2
    //   11: invokestatic 52	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 56	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   23: invokevirtual 62	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   26: astore 4
    //   28: aload 4
    //   30: new 6	com/alipay/security/mobile/module/b/a$a
    //   33: dup
    //   34: aload_0
    //   35: iconst_0
    //   36: invokespecial 65	com/alipay/security/mobile/module/b/a$a:<init>	(Lcom/alipay/security/mobile/module/b/a;B)V
    //   39: invokestatic 71	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   42: iconst_0
    //   43: istore 7
    //   45: aload 4
    //   47: invokeinterface 77 1 0
    //   52: astore 5
    //   54: aload 5
    //   56: invokeinterface 83 1 0
    //   61: ifeq +58 -> 119
    //   64: aload 5
    //   66: invokeinterface 87 1 0
    //   71: checkcast 89	android/hardware/Camera$Size
    //   74: astore 6
    //   76: aload 6
    //   78: getfield 93	android/hardware/Camera$Size:width	I
    //   81: sipush 600
    //   84: if_icmplt +214 -> 298
    //   87: aload 6
    //   89: getfield 93	android/hardware/Camera$Size:width	I
    //   92: i2f
    //   93: aload 6
    //   95: getfield 96	android/hardware/Camera$Size:height	I
    //   98: i2f
    //   99: fdiv
    //   100: fload_3
    //   101: fsub
    //   102: invokestatic 102	java/lang/Math:abs	(F)F
    //   105: f2d
    //   106: ldc2_w 103
    //   109: dcmpg
    //   110: ifgt +197 -> 307
    //   113: iconst_1
    //   114: istore 8
    //   116: goto +177 -> 293
    //   119: iload 7
    //   121: aload 4
    //   123: invokeinterface 108 1 0
    //   128: if_icmpne +162 -> 290
    //   131: aload 4
    //   133: invokeinterface 108 1 0
    //   138: iconst_1
    //   139: isub
    //   140: istore 7
    //   142: aload 4
    //   144: iload 7
    //   146: invokeinterface 112 2 0
    //   151: checkcast 89	android/hardware/Camera$Size
    //   154: astore 4
    //   156: aload 4
    //   158: ifnull +125 -> 283
    //   161: getstatic 118	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   164: ldc 120
    //   166: iconst_3
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: iload_2
    //   173: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload 4
    //   181: getfield 93	android/hardware/Camera$Size:width	I
    //   184: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: aload 4
    //   192: getfield 96	android/hardware/Camera$Size:height	I
    //   195: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: invokestatic 132	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: astore 4
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 135	android/hardware/Camera:release	()V
    //   212: aload 4
    //   214: areturn
    //   215: astore 4
    //   217: aload_1
    //   218: ifnull +62 -> 280
    //   221: aload_1
    //   222: invokevirtual 135	android/hardware/Camera:release	()V
    //   225: ldc -119
    //   227: areturn
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +48 -> 280
    //   235: aload_1
    //   236: invokevirtual 135	android/hardware/Camera:release	()V
    //   239: ldc -119
    //   241: areturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore 5
    //   246: aload_1
    //   247: astore 4
    //   249: aload 5
    //   251: ifnull +8 -> 259
    //   254: aload 5
    //   256: invokevirtual 135	android/hardware/Camera:release	()V
    //   259: aload 4
    //   261: athrow
    //   262: astore 4
    //   264: aload_1
    //   265: astore 5
    //   267: goto -18 -> 249
    //   270: astore 4
    //   272: goto -41 -> 231
    //   275: astore 4
    //   277: goto -60 -> 217
    //   280: ldc -119
    //   282: areturn
    //   283: ldc -119
    //   285: astore 4
    //   287: goto -83 -> 204
    //   290: goto -148 -> 142
    //   293: iload 8
    //   295: ifne -176 -> 119
    //   298: iload 7
    //   300: iconst_1
    //   301: iadd
    //   302: istore 7
    //   304: goto -250 -> 54
    //   307: iconst_0
    //   308: istore 8
    //   310: goto -17 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	a
    //   0	313	1	paramContext	Context
    //   0	313	2	paramInt	int
    //   7	94	3	f	float
    //   14	199	4	localObject1	Object
    //   215	1	4	localRuntimeException1	RuntimeException
    //   247	13	4	localContext	Context
    //   262	1	4	localObject2	Object
    //   270	1	4	localException	Exception
    //   275	1	4	localRuntimeException2	RuntimeException
    //   285	1	4	str	String
    //   52	214	5	localObject3	Object
    //   74	20	6	localSize	Camera.Size
    //   43	260	7	i	int
    //   114	195	8	j	int
    // Exception table:
    //   from	to	target	type
    //   10	16	215	java/lang/RuntimeException
    //   10	16	228	java/lang/Exception
    //   10	16	242	finally
    //   19	42	262	finally
    //   45	54	262	finally
    //   54	113	262	finally
    //   119	142	262	finally
    //   142	156	262	finally
    //   161	204	262	finally
    //   19	42	270	java/lang/Exception
    //   45	54	270	java/lang/Exception
    //   54	113	270	java/lang/Exception
    //   119	142	270	java/lang/Exception
    //   142	156	270	java/lang/Exception
    //   161	204	270	java/lang/Exception
    //   19	42	275	java/lang/RuntimeException
    //   45	54	275	java/lang/RuntimeException
    //   54	113	275	java/lang/RuntimeException
    //   119	142	275	java/lang/RuntimeException
    //   142	156	275	java/lang/RuntimeException
    //   161	204	275	java/lang/RuntimeException
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc -114
    //   4: astore_2
    //   5: new 144	java/io/InputStreamReader
    //   8: dup
    //   9: invokestatic 150	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: ldc -104
    //   14: invokevirtual 156	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   17: invokevirtual 162	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   20: invokespecial 165	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: astore_0
    //   24: new 167	java/io/LineNumberReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 170	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_3
    //   33: iconst_1
    //   34: istore 5
    //   36: aload_2
    //   37: astore_1
    //   38: iload 5
    //   40: bipush 100
    //   42: if_icmpge +49 -> 91
    //   45: aload_3
    //   46: invokevirtual 173	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   49: astore 4
    //   51: aload_2
    //   52: astore_1
    //   53: aload 4
    //   55: ifnull +36 -> 91
    //   58: aload 4
    //   60: ldc -81
    //   62: invokevirtual 179	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   65: iflt +36 -> 101
    //   68: aload 4
    //   70: aload 4
    //   72: ldc -75
    //   74: invokevirtual 179	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   77: iconst_1
    //   78: iadd
    //   79: aload 4
    //   81: invokevirtual 184	java/lang/String:length	()I
    //   84: invokevirtual 188	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: invokevirtual 191	java/lang/String:trim	()Ljava/lang/String;
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 194	java/io/LineNumberReader:close	()V
    //   95: aload_0
    //   96: invokevirtual 195	java/io/InputStreamReader:close	()V
    //   99: aload_1
    //   100: areturn
    //   101: iload 5
    //   103: iconst_1
    //   104: iadd
    //   105: istore 5
    //   107: goto -71 -> 36
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_1
    //   114: astore_0
    //   115: aload_3
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 194	java/io/LineNumberReader:close	()V
    //   125: aload_2
    //   126: astore_1
    //   127: aload_0
    //   128: ifnull -29 -> 99
    //   131: aload_0
    //   132: invokevirtual 195	java/io/InputStreamReader:close	()V
    //   135: ldc -114
    //   137: areturn
    //   138: astore_0
    //   139: ldc -114
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 194	java/io/LineNumberReader:close	()V
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 195	java/io/InputStreamReader:close	()V
    //   163: aload_1
    //   164: athrow
    //   165: astore_2
    //   166: goto -71 -> 95
    //   169: astore_0
    //   170: aload_1
    //   171: areturn
    //   172: astore_1
    //   173: goto -48 -> 125
    //   176: astore_2
    //   177: goto -22 -> 155
    //   180: astore_0
    //   181: goto -18 -> 163
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_2
    //   187: goto -40 -> 147
    //   190: astore_1
    //   191: aload_3
    //   192: astore_2
    //   193: goto -46 -> 147
    //   196: astore_1
    //   197: aconst_null
    //   198: astore_1
    //   199: goto -82 -> 117
    //   202: astore_1
    //   203: aload_3
    //   204: astore_1
    //   205: goto -88 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	73	0	localInputStreamReader	java.io.InputStreamReader
    //   110	1	0	localException1	Exception
    //   114	18	0	localObject1	Object
    //   138	1	0	localIOException1	java.io.IOException
    //   146	14	0	localObject2	Object
    //   169	1	0	localIOException2	java.io.IOException
    //   180	1	0	localIOException3	java.io.IOException
    //   1	126	1	localObject3	Object
    //   142	29	1	str1	String
    //   172	1	1	localIOException4	java.io.IOException
    //   184	1	1	localObject4	Object
    //   190	1	1	localObject5	Object
    //   196	1	1	localException2	Exception
    //   198	1	1	localObject6	Object
    //   202	1	1	localException3	Exception
    //   204	1	1	localObject7	Object
    //   4	148	2	str2	String
    //   165	1	2	localIOException5	java.io.IOException
    //   176	1	2	localIOException6	java.io.IOException
    //   186	7	2	localObject8	Object
    //   32	172	3	localLineNumberReader	java.io.LineNumberReader
    //   49	31	4	str3	String
    //   34	72	5	i	int
    // Exception table:
    //   from	to	target	type
    //   5	24	110	java/lang/Exception
    //   131	135	138	java/io/IOException
    //   5	24	142	finally
    //   91	95	165	java/io/IOException
    //   95	99	169	java/io/IOException
    //   121	125	172	java/io/IOException
    //   151	155	176	java/io/IOException
    //   159	163	180	java/io/IOException
    //   24	33	184	finally
    //   45	51	190	finally
    //   58	91	190	finally
    //   24	33	196	java/lang/Exception
    //   45	51	202	java/lang/Exception
    //   58	91	202	java/lang/Exception
  }
  
  public static String b(Context paramContext)
  {
    Context localContext = null;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getSubscriberId();
          localContext = paramContext;
          return localContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      paramContext = null;
    }
  }
  
  public static String c(Context paramContext)
  {
    Context localContext = null;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getLine1Number();
          localContext = paramContext;
          return localContext;
        }
      }
      catch (Exception paramContext)
      {
        return null;
      }
      paramContext = null;
    }
  }
  
  public static String d()
  {
    String str = j();
    if (!com.alipay.security.mobile.module.a.a.a(str)) {
      return str;
    }
    return k();
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext != null)
        {
          Object localObject = paramContext.getSensorList(-1);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            paramContext = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              Sensor localSensor = (Sensor)((Iterator)localObject).next();
              paramContext.append(localSensor.getName());
              paramContext.append(localSensor.getVersion());
              paramContext.append(localSensor.getVendor());
            }
          }
        }
        for (paramContext = com.alipay.security.mobile.module.a.a.b(paramContext.toString());; paramContext = null) {
          return paramContext;
        }
        return null;
      }
      catch (Exception paramContext) {}
    }
  }
  
  /* Error */
  public static String e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: lconst_0
    //   3: lstore 7
    //   5: new 252	java/io/FileReader
    //   8: dup
    //   9: ldc -2
    //   11: invokespecial 257	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: new 259	java/io/BufferedReader
    //   18: dup
    //   19: aload_1
    //   20: sipush 8192
    //   23: invokespecial 262	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_0
    //   32: lload 7
    //   34: lstore 5
    //   36: aload_0
    //   37: ifnull +22 -> 59
    //   40: aload_0
    //   41: ldc_w 265
    //   44: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   47: iconst_1
    //   48: aaload
    //   49: invokestatic 272	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   52: istore 4
    //   54: iload 4
    //   56: i2l
    //   57: lstore 5
    //   59: aload_1
    //   60: invokevirtual 273	java/io/FileReader:close	()V
    //   63: aload_2
    //   64: invokevirtual 274	java/io/BufferedReader:close	()V
    //   67: lload 5
    //   69: invokestatic 277	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   72: areturn
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 273	java/io/FileReader:close	()V
    //   84: lload 7
    //   86: lstore 5
    //   88: aload_0
    //   89: ifnull -22 -> 67
    //   92: aload_0
    //   93: invokevirtual 274	java/io/BufferedReader:close	()V
    //   96: lload 7
    //   98: lstore 5
    //   100: goto -33 -> 67
    //   103: astore_0
    //   104: lload 7
    //   106: lstore 5
    //   108: goto -41 -> 67
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_3
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 273	java/io/FileReader:close	()V
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 274	java/io/BufferedReader:close	()V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: goto -72 -> 63
    //   138: astore_0
    //   139: goto -72 -> 67
    //   142: astore_1
    //   143: goto -59 -> 84
    //   146: astore_2
    //   147: goto -23 -> 124
    //   150: astore_1
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_1
    //   158: astore_3
    //   159: aload_2
    //   160: astore_1
    //   161: goto -45 -> 116
    //   164: astore_0
    //   165: aload_1
    //   166: astore_3
    //   167: aload_2
    //   168: astore_1
    //   169: goto -53 -> 116
    //   172: astore_2
    //   173: goto -97 -> 76
    //   176: astore_0
    //   177: aload_2
    //   178: astore_0
    //   179: goto -103 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	92	0	str	String
    //   103	1	0	localIOException1	java.io.IOException
    //   111	22	0	localObject1	Object
    //   134	1	0	localIOException2	java.io.IOException
    //   138	1	0	localIOException3	java.io.IOException
    //   154	1	0	localObject2	Object
    //   164	1	0	localObject3	Object
    //   176	1	0	localIOException4	java.io.IOException
    //   178	1	0	localObject4	Object
    //   14	46	1	localFileReader	java.io.FileReader
    //   73	1	1	localIOException5	java.io.IOException
    //   75	54	1	localObject5	Object
    //   142	1	1	localIOException6	java.io.IOException
    //   150	8	1	localIOException7	java.io.IOException
    //   160	9	1	localObject6	Object
    //   26	38	2	localBufferedReader	java.io.BufferedReader
    //   146	1	2	localIOException8	java.io.IOException
    //   156	12	2	localObject7	Object
    //   172	6	2	localIOException9	java.io.IOException
    //   113	54	3	localObject8	Object
    //   52	3	4	i	int
    //   34	73	5	l1	long
    //   3	102	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   5	15	73	java/io/IOException
    //   92	96	103	java/io/IOException
    //   5	15	111	finally
    //   59	63	134	java/io/IOException
    //   63	67	138	java/io/IOException
    //   80	84	142	java/io/IOException
    //   120	124	146	java/io/IOException
    //   128	132	150	java/io/IOException
    //   15	27	154	finally
    //   27	32	164	finally
    //   40	54	164	finally
    //   15	27	172	java/io/IOException
    //   27	32	176	java/io/IOException
    //   40	54	176	java/io/IOException
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = Integer.toString(paramContext.widthPixels) + "*" + Integer.toString(paramContext.heightPixels);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String f()
  {
    long l1 = 0L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l1 = i * l2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return String.valueOf(l1);
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = paramContext.widthPixels;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String g()
  {
    l2 = 0L;
    l1 = l2;
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        l1 = localStatFs.getBlockSize();
        int i = localStatFs.getBlockCount();
        l1 = i * l1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    return String.valueOf(l1);
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      paramContext = paramContext.heightPixels;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String h()
  {
    try
    {
      Object localObject = BluetoothAdapter.getDefaultAdapter();
      if ((localObject != null) && (!((BluetoothAdapter)localObject).isEnabled())) {
        return "";
      }
      localObject = ((BluetoothAdapter)localObject).getAddress();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String h(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String i()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      Object localObject2 = ((Class)localObject1).newInstance();
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject2, new Object[] { "gsm.version.baseband", "no message" });
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  private static String j()
  {
    // Byte code:
    //   0: new 252	java/io/FileReader
    //   3: dup
    //   4: ldc_w 392
    //   7: invokespecial 257	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: new 259	java/io/BufferedReader
    //   14: dup
    //   15: aload_2
    //   16: sipush 8192
    //   19: invokespecial 262	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload_0
    //   29: invokestatic 211	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   32: ifne +18 -> 50
    //   35: aload_0
    //   36: invokevirtual 191	java/lang/String:trim	()Ljava/lang/String;
    //   39: astore_0
    //   40: aload_1
    //   41: invokevirtual 274	java/io/BufferedReader:close	()V
    //   44: aload_2
    //   45: invokevirtual 273	java/io/FileReader:close	()V
    //   48: aload_0
    //   49: areturn
    //   50: aload_1
    //   51: invokevirtual 274	java/io/BufferedReader:close	()V
    //   54: aload_2
    //   55: invokevirtual 273	java/io/FileReader:close	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: areturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_0
    //   69: invokevirtual 274	java/io/BufferedReader:close	()V
    //   72: aload_2
    //   73: invokevirtual 273	java/io/FileReader:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 274	java/io/BufferedReader:close	()V
    //   90: aload_2
    //   91: invokevirtual 273	java/io/FileReader:close	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_1
    //   97: goto -53 -> 44
    //   100: astore_1
    //   101: aload_0
    //   102: areturn
    //   103: astore_0
    //   104: goto -50 -> 54
    //   107: astore_0
    //   108: goto -36 -> 72
    //   111: astore_1
    //   112: goto -22 -> 90
    //   115: astore_1
    //   116: goto -22 -> 94
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -36 -> 86
    //   125: astore_0
    //   126: goto -40 -> 86
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_0
    //   132: goto -64 -> 68
    //   135: astore_0
    //   136: aload_1
    //   137: astore_0
    //   138: goto -70 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	22	0	str1	String
    //   60	1	0	localIOException1	java.io.IOException
    //   63	1	0	localIOException2	java.io.IOException
    //   65	4	0	localObject1	Object
    //   78	1	0	localIOException3	java.io.IOException
    //   81	21	0	str2	String
    //   103	1	0	localIOException4	java.io.IOException
    //   107	1	0	localIOException5	java.io.IOException
    //   119	1	0	localObject2	Object
    //   125	1	0	localObject3	Object
    //   129	1	0	localIOException6	java.io.IOException
    //   131	1	0	localObject4	Object
    //   135	1	0	localIOException7	java.io.IOException
    //   137	1	0	localObject5	Object
    //   22	65	1	localBufferedReader	java.io.BufferedReader
    //   96	1	1	localIOException8	java.io.IOException
    //   100	1	1	localIOException9	java.io.IOException
    //   111	1	1	localIOException10	java.io.IOException
    //   115	1	1	localIOException11	java.io.IOException
    //   121	16	1	localObject6	Object
    //   10	81	2	localFileReader	java.io.FileReader
    // Exception table:
    //   from	to	target	type
    //   54	58	60	java/io/IOException
    //   0	11	63	java/io/IOException
    //   72	76	78	java/io/IOException
    //   0	11	81	finally
    //   40	44	96	java/io/IOException
    //   44	48	100	java/io/IOException
    //   50	54	103	java/io/IOException
    //   68	72	107	java/io/IOException
    //   86	90	111	java/io/IOException
    //   90	94	115	java/io/IOException
    //   11	23	119	finally
    //   23	40	125	finally
    //   11	23	129	java/io/IOException
    //   23	40	135	java/io/IOException
  }
  
  public static String j(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  /* Error */
  private static String k()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 252	java/io/FileReader
    //   8: dup
    //   9: ldc_w 406
    //   12: invokespecial 257	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: new 259	java/io/BufferedReader
    //   19: dup
    //   20: aload_2
    //   21: sipush 8192
    //   24: invokespecial 262	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload 4
    //   36: astore_0
    //   37: aload 5
    //   39: ifnull +48 -> 87
    //   42: aload 5
    //   44: invokestatic 211	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
    //   47: ifne -19 -> 28
    //   50: aload 5
    //   52: ldc -75
    //   54: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   57: astore_0
    //   58: aload_0
    //   59: ifnull -31 -> 28
    //   62: aload_0
    //   63: arraylength
    //   64: iconst_1
    //   65: if_icmple -37 -> 28
    //   68: aload_0
    //   69: iconst_0
    //   70: aaload
    //   71: ldc_w 408
    //   74: invokevirtual 412	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   77: ifeq -49 -> 28
    //   80: aload_0
    //   81: iconst_1
    //   82: aaload
    //   83: invokevirtual 191	java/lang/String:trim	()Ljava/lang/String;
    //   86: astore_0
    //   87: aload_2
    //   88: invokevirtual 273	java/io/FileReader:close	()V
    //   91: aload_1
    //   92: invokevirtual 274	java/io/BufferedReader:close	()V
    //   95: aload_0
    //   96: astore_1
    //   97: aload_1
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 273	java/io/FileReader:close	()V
    //   112: aload_3
    //   113: astore_1
    //   114: aload_0
    //   115: ifnull -18 -> 97
    //   118: aload_0
    //   119: invokevirtual 274	java/io/BufferedReader:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 273	java/io/FileReader:close	()V
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 274	java/io/BufferedReader:close	()V
    //   148: aload_0
    //   149: athrow
    //   150: astore_2
    //   151: goto -60 -> 91
    //   154: astore_1
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: goto -46 -> 112
    //   161: astore_2
    //   162: goto -22 -> 140
    //   165: astore_1
    //   166: goto -18 -> 148
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -40 -> 132
    //   175: astore_0
    //   176: goto -44 -> 132
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -78 -> 104
    //   185: astore_0
    //   186: aload_1
    //   187: astore_0
    //   188: goto -84 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	60	0	localObject1	Object
    //   99	1	0	localIOException1	java.io.IOException
    //   101	18	0	localObject2	Object
    //   124	1	0	localIOException2	java.io.IOException
    //   127	29	0	str1	String
    //   169	1	0	localObject3	Object
    //   175	1	0	localObject4	Object
    //   179	1	0	localIOException3	java.io.IOException
    //   181	1	0	localObject5	Object
    //   185	1	0	localIOException4	java.io.IOException
    //   187	1	0	localObject6	Object
    //   27	118	1	localObject7	Object
    //   154	1	1	localIOException5	java.io.IOException
    //   157	1	1	localIOException6	java.io.IOException
    //   165	1	1	localIOException7	java.io.IOException
    //   171	16	1	localObject8	Object
    //   15	122	2	localFileReader	java.io.FileReader
    //   150	1	2	localIOException8	java.io.IOException
    //   161	1	2	localIOException9	java.io.IOException
    //   1	112	3	localObject9	Object
    //   3	32	4	localObject10	Object
    //   32	19	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   5	16	99	java/io/IOException
    //   118	122	124	java/io/IOException
    //   5	16	127	finally
    //   87	91	150	java/io/IOException
    //   91	95	154	java/io/IOException
    //   108	112	157	java/io/IOException
    //   136	140	161	java/io/IOException
    //   144	148	165	java/io/IOException
    //   16	28	169	finally
    //   28	34	175	finally
    //   42	58	175	finally
    //   62	87	175	finally
    //   16	28	179	java/io/IOException
    //   28	34	185	java/io/IOException
    //   42	58	185	java/io/IOException
    //   62	87	185	java/io/IOException
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        int i = paramContext.getNetworkType();
        return String.valueOf(i);
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext.isWifiEnabled())
      {
        paramContext = paramContext.getConnectionInfo().getBSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static Map<String, Integer> m(Context paramContext)
  {
    localHashMap = new HashMap();
    try
    {
      paramContext = paramContext.getPackageManager().getInstalledPackages(0);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          PackageInfo localPackageInfo = (PackageInfo)paramContext.next();
          localHashMap.put(localPackageInfo.packageName, Integer.valueOf(localPackageInfo.applicationInfo.uid));
        }
      }
      return localHashMap;
    }
    catch (Throwable paramContext) {}
  }
  
  private static float o(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext = new Point(paramContext.widthPixels, paramContext.heightPixels);
    return paramContext.y / paramContext.x;
  }
  
  public final String c()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new b(this)).length;
      return String.valueOf(i);
    }
    catch (Exception localException) {}
    return "1";
  }
  
  public final String n(Context paramContext)
  {
    o(paramContext.getApplicationContext());
    int j = -1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = j;
    try
    {
      if (Integer.parseInt(Build.VERSION.SDK) > 8) {
        i = Camera.getNumberOfCameras();
      }
      j = 0;
      if (j < i)
      {
        if (j == 0) {}
        for (String str = String.format(Locale.ENGLISH, "%1$d:%2$s", new Object[] { Integer.valueOf(j), a(paramContext, j) });; str = String.format(Locale.ENGLISH, "#%1$d:%2$s", new Object[] { Integer.valueOf(j), a(paramContext, j) }))
        {
          localStringBuilder.append(str);
          j += 1;
          break;
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private final class a
    implements Comparator<Camera.Size>
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */