package com.ta.utdid2.device;

import android.content.Context;
import android.provider.Settings.System;
import com.ta.utdid2.b.a.b;
import com.ta.utdid2.b.a.e;
import com.ta.utdid2.b.a.g;
import com.ta.utdid2.b.a.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c
{
  private static c jdField_a_of_type_ComTaUtdid2DeviceC = null;
  private static final Object f = new Object();
  private static final String o = ".UTSystemConfig" + File.separator + "Global";
  private com.ta.utdid2.c.a.c jdField_a_of_type_ComTaUtdid2CAC = null;
  private d jdField_a_of_type_ComTaUtdid2DeviceD = null;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[^0-9a-zA-Z=/+]+");
  private com.ta.utdid2.c.a.c b = null;
  private String l = null;
  private String m = "xx_utdid_key";
  private Context mContext = null;
  private String n = "xx_utdid_domain";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
    this.b = new com.ta.utdid2.c.a.c(paramContext, o, "Alvin2", false, true);
    this.jdField_a_of_type_ComTaUtdid2CAC = new com.ta.utdid2.c.a.c(paramContext, ".DataStorage", "ContextData", false, true);
    this.jdField_a_of_type_ComTaUtdid2DeviceD = new d();
    this.m = String.format("K_%d", new Object[] { Integer.valueOf(i.a(this.m)) });
    this.n = String.format("D_%d", new Object[] { Integer.valueOf(i.a(this.n)) });
  }
  
  public static c a(Context paramContext)
  {
    if ((paramContext != null) && (jdField_a_of_type_ComTaUtdid2DeviceC == null)) {}
    synchronized (f)
    {
      if (jdField_a_of_type_ComTaUtdid2DeviceC == null)
      {
        jdField_a_of_type_ComTaUtdid2DeviceC = new c(paramContext);
        jdField_a_of_type_ComTaUtdid2DeviceC.d();
      }
      return jdField_a_of_type_ComTaUtdid2DeviceC;
    }
  }
  
  private final byte[] a()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = new Random().nextInt();
    Object localObject = e.getBytes(i);
    byte[] arrayOfByte = e.getBytes(j);
    localByteArrayOutputStream.write((byte[])localObject, 0, 4);
    localByteArrayOutputStream.write(arrayOfByte, 0, 4);
    localByteArrayOutputStream.write(3);
    localByteArrayOutputStream.write(0);
    try
    {
      localObject = g.a(this.mContext);
      localByteArrayOutputStream.write(e.getBytes(i.a((String)localObject)), 0, 4);
      localByteArrayOutputStream.write(e.getBytes(i.a(b(localByteArrayOutputStream.toByteArray()))));
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "" + new Random().nextInt();
      }
    }
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), localMac.getAlgorithm()));
    return b.encodeToString(localMac.doFinal(paramArrayOfByte), 2);
  }
  
  private boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      bool1 = bool2;
      if (24 == str.length())
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_JavaUtilRegexPattern.matcher(str).find()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    int j = 1;
    int i;
    if (this.b != null)
    {
      if (i.a(this.b.getString("UTDID2")))
      {
        String str = this.b.getString("UTDID");
        if (!i.a(str)) {
          f(str);
        }
      }
      i = 0;
      if (!i.a(this.b.getString("DID")))
      {
        this.b.remove("DID");
        i = 1;
      }
      if (!i.a(this.b.getString("EI")))
      {
        this.b.remove("EI");
        i = 1;
      }
      if (i.a(this.b.getString("SI"))) {
        break label139;
      }
      this.b.remove("SI");
      i = j;
    }
    label139:
    for (;;)
    {
      if (i != 0) {
        this.b.commit();
      }
      return;
    }
  }
  
  private void f(String paramString)
  {
    if (b(paramString))
    {
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      if ((str.length() == 24) && (this.b != null))
      {
        this.b.putString("UTDID2", str);
        this.b.commit();
      }
    }
  }
  
  private String g()
  {
    if (this.b != null)
    {
      String str = this.b.getString("UTDID2");
      if ((!i.a(str)) && (this.jdField_a_of_type_ComTaUtdid2DeviceD.a(str) != null)) {
        return str;
      }
    }
    return null;
  }
  
  private void g(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_ComTaUtdid2CAC != null) && (!paramString.equals(this.jdField_a_of_type_ComTaUtdid2CAC.getString(this.m))))
    {
      this.jdField_a_of_type_ComTaUtdid2CAC.putString(this.m, paramString);
      this.jdField_a_of_type_ComTaUtdid2CAC.commit();
    }
  }
  
  private void h(String paramString)
  {
    String str1;
    if ((this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) && (b(paramString)))
    {
      str1 = paramString;
      if (paramString.endsWith("\n")) {
        str1 = paramString.substring(0, paramString.length() - 1);
      }
      if (24 == str1.length()) {
        paramString = null;
      }
    }
    try
    {
      String str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
      paramString = str2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!b(paramString)) {}
    try
    {
      Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str1);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void i(String paramString)
  {
    Object localObject = null;
    try
    {
      String str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!paramString.equals(localObject)) {}
    try
    {
      Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void j(String paramString)
  {
    if ((this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) && (paramString != null)) {
      i(paramString);
    }
  }
  
  /* Error */
  public String getValue()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: ldc -85
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 54	com/ta/utdid2/device/c:mContext	Landroid/content/Context;
    //   25: invokevirtual 281	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   28: ldc_w 283
    //   31: invokestatic 288	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_0
    //   40: aload_2
    //   41: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   44: ifne -30 -> 14
    //   47: new 300	com/ta/utdid2/device/e
    //   50: dup
    //   51: invokespecial 301	com/ta/utdid2/device/e:<init>	()V
    //   54: astore_3
    //   55: iconst_0
    //   56: istore 5
    //   58: aload_0
    //   59: getfield 54	com/ta/utdid2/device/c:mContext	Landroid/content/Context;
    //   62: invokevirtual 281	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   65: ldc_w 294
    //   68: invokestatic 288	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 239	com/ta/utdid2/b/a/i:a	(Ljava/lang/String;)Z
    //   76: ifne +373 -> 449
    //   79: aload_3
    //   80: aload_1
    //   81: invokevirtual 304	com/ta/utdid2/device/e:c	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_2
    //   85: aload_0
    //   86: aload_2
    //   87: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   90: ifeq +24 -> 114
    //   93: aload_0
    //   94: aload_2
    //   95: invokespecial 306	com/ta/utdid2/device/c:h	(Ljava/lang/String;)V
    //   98: aload_2
    //   99: astore_1
    //   100: goto -86 -> 14
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_1
    //   111: goto -39 -> 72
    //   114: aload_3
    //   115: aload_1
    //   116: invokevirtual 308	com/ta/utdid2/device/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore_2
    //   120: aload_0
    //   121: aload_2
    //   122: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   125: ifeq +317 -> 442
    //   128: aload_0
    //   129: getfield 58	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2DeviceD	Lcom/ta/utdid2/device/d;
    //   132: aload_2
    //   133: invokevirtual 265	com/ta/utdid2/device/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_2
    //   137: aload_2
    //   138: invokestatic 239	com/ta/utdid2/b/a/i:a	(Ljava/lang/String;)Z
    //   141: ifne +301 -> 442
    //   144: aload_0
    //   145: aload_2
    //   146: invokespecial 310	com/ta/utdid2/device/c:j	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: getfield 54	com/ta/utdid2/device/c:mContext	Landroid/content/Context;
    //   153: invokevirtual 281	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   156: ldc_w 294
    //   159: invokestatic 288	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_2
    //   163: aload_2
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 58	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2DeviceD	Lcom/ta/utdid2/device/d;
    //   169: aload_1
    //   170: invokevirtual 311	com/ta/utdid2/device/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   173: astore_2
    //   174: aload_0
    //   175: aload_2
    //   176: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   179: ifeq +34 -> 213
    //   182: aload_0
    //   183: aload_2
    //   184: putfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   187: aload_0
    //   188: aload_2
    //   189: invokespecial 244	com/ta/utdid2/device/c:f	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: aload_1
    //   194: invokespecial 313	com/ta/utdid2/device/c:g	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   202: invokespecial 306	com/ta/utdid2/device/c:h	(Ljava/lang/String;)V
    //   205: aload_0
    //   206: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   209: astore_1
    //   210: goto -196 -> 14
    //   213: aload_0
    //   214: invokespecial 315	com/ta/utdid2/device/c:g	()Ljava/lang/String;
    //   217: astore_1
    //   218: aload_0
    //   219: aload_1
    //   220: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   223: ifeq +40 -> 263
    //   226: aload_0
    //   227: getfield 58	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2DeviceD	Lcom/ta/utdid2/device/d;
    //   230: aload_1
    //   231: invokevirtual 265	com/ta/utdid2/device/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_2
    //   235: iload 5
    //   237: ifeq +8 -> 245
    //   240: aload_0
    //   241: aload_2
    //   242: invokespecial 310	com/ta/utdid2/device/c:j	(Ljava/lang/String;)V
    //   245: aload_0
    //   246: aload_1
    //   247: invokespecial 306	com/ta/utdid2/device/c:h	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: aload_2
    //   252: invokespecial 313	com/ta/utdid2/device/c:g	(Ljava/lang/String;)V
    //   255: aload_0
    //   256: aload_1
    //   257: putfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   260: goto -246 -> 14
    //   263: aload_0
    //   264: getfield 68	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2CAC	Lcom/ta/utdid2/c/a/c;
    //   267: aload_0
    //   268: getfield 62	com/ta/utdid2/device/c:m	Ljava/lang/String;
    //   271: invokevirtual 237	com/ta/utdid2/c/a/c:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 4
    //   276: aload 4
    //   278: invokestatic 239	com/ta/utdid2/b/a/i:a	(Ljava/lang/String;)Z
    //   281: ifne +85 -> 366
    //   284: aload_3
    //   285: aload 4
    //   287: invokevirtual 308	com/ta/utdid2/device/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   290: astore_2
    //   291: aload_2
    //   292: astore_1
    //   293: aload_0
    //   294: aload_2
    //   295: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   298: ifne +13 -> 311
    //   301: aload_0
    //   302: getfield 58	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2DeviceD	Lcom/ta/utdid2/device/d;
    //   305: aload 4
    //   307: invokevirtual 311	com/ta/utdid2/device/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   310: astore_1
    //   311: aload_0
    //   312: aload_1
    //   313: invokespecial 258	com/ta/utdid2/device/c:b	(Ljava/lang/String;)Z
    //   316: ifeq +50 -> 366
    //   319: aload_0
    //   320: getfield 58	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2DeviceD	Lcom/ta/utdid2/device/d;
    //   323: aload_1
    //   324: invokevirtual 265	com/ta/utdid2/device/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore_2
    //   328: aload_1
    //   329: invokestatic 239	com/ta/utdid2/b/a/i:a	(Ljava/lang/String;)Z
    //   332: ifne +34 -> 366
    //   335: aload_0
    //   336: aload_1
    //   337: putfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   340: iload 5
    //   342: ifeq +8 -> 350
    //   345: aload_0
    //   346: aload_2
    //   347: invokespecial 310	com/ta/utdid2/device/c:j	(Ljava/lang/String;)V
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   355: invokespecial 244	com/ta/utdid2/device/c:f	(Ljava/lang/String;)V
    //   358: aload_0
    //   359: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   362: astore_1
    //   363: goto -349 -> 14
    //   366: aload_0
    //   367: invokespecial 317	com/ta/utdid2/device/c:a	()[B
    //   370: astore_1
    //   371: aload_1
    //   372: ifnull +61 -> 433
    //   375: aload_0
    //   376: aload_1
    //   377: iconst_2
    //   378: invokestatic 208	com/ta/utdid2/b/a/b:encodeToString	([BI)Ljava/lang/String;
    //   381: putfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   384: aload_0
    //   385: aload_0
    //   386: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   389: invokespecial 244	com/ta/utdid2/device/c:f	(Ljava/lang/String;)V
    //   392: aload_0
    //   393: getfield 58	com/ta/utdid2/device/c:jdField_a_of_type_ComTaUtdid2DeviceD	Lcom/ta/utdid2/device/d;
    //   396: aload_1
    //   397: invokevirtual 319	com/ta/utdid2/device/d:c	([B)Ljava/lang/String;
    //   400: astore_1
    //   401: aload_1
    //   402: ifnull +18 -> 420
    //   405: iload 5
    //   407: ifeq +8 -> 415
    //   410: aload_0
    //   411: aload_1
    //   412: invokespecial 310	com/ta/utdid2/device/c:j	(Ljava/lang/String;)V
    //   415: aload_0
    //   416: aload_1
    //   417: invokespecial 313	com/ta/utdid2/device/c:g	(Ljava/lang/String;)V
    //   420: aload_0
    //   421: getfield 56	com/ta/utdid2/device/c:l	Ljava/lang/String;
    //   424: astore_1
    //   425: goto -411 -> 14
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   433: aconst_null
    //   434: astore_1
    //   435: goto -421 -> 14
    //   438: astore_1
    //   439: goto -402 -> 37
    //   442: goto -277 -> 165
    //   445: astore_2
    //   446: goto -281 -> 165
    //   449: iconst_1
    //   450: istore 5
    //   452: goto -239 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	c
    //   13	87	1	localObject1	Object
    //   103	4	1	localObject2	Object
    //   108	1	1	localException1	Exception
    //   110	315	1	localObject3	Object
    //   428	2	1	localException2	Exception
    //   434	1	1	localObject4	Object
    //   438	1	1	localException3	Exception
    //   20	327	2	localObject5	Object
    //   445	1	2	localException4	Exception
    //   54	231	3	locale	e
    //   274	32	4	str	String
    //   56	395	5	i	int
    // Exception table:
    //   from	to	target	type
    //   2	14	103	finally
    //   21	35	103	finally
    //   39	55	103	finally
    //   58	72	103	finally
    //   72	98	103	finally
    //   114	149	103	finally
    //   149	163	103	finally
    //   165	174	103	finally
    //   174	210	103	finally
    //   213	235	103	finally
    //   240	245	103	finally
    //   245	260	103	finally
    //   263	291	103	finally
    //   293	311	103	finally
    //   311	340	103	finally
    //   345	350	103	finally
    //   350	363	103	finally
    //   366	371	103	finally
    //   375	401	103	finally
    //   410	415	103	finally
    //   415	420	103	finally
    //   420	425	103	finally
    //   429	433	103	finally
    //   58	72	108	java/lang/Exception
    //   366	371	428	java/lang/Exception
    //   375	401	428	java/lang/Exception
    //   410	415	428	java/lang/Exception
    //   415	420	428	java/lang/Exception
    //   420	425	428	java/lang/Exception
    //   21	35	438	java/lang/Exception
    //   149	163	445	java/lang/Exception
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\ta\utdid2\device\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */