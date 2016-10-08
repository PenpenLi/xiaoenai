package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class AidTask
{
  private static final String AID_FILE_NAME = "weibo_sdk_aid";
  private static final int MAX_RETRY_NUM = 3;
  private static final String TAG = "AidTask";
  private static final int VERSION = 1;
  public static final int WHAT_LOAD_AID_ERR = 1002;
  public static final int WHAT_LOAD_AID_SUC = 1001;
  private static AidTask sInstance;
  private AidInfo mAidInfo;
  private String mAppKey;
  private Context mContext;
  private CallbackHandler mHandler;
  private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
  
  private AidTask(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
    new Thread(new AidTask.1(this)).start();
  }
  
  /* Error */
  private void cacheAidInfo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aconst_null
    //   17: astore_3
    //   18: new 127	java/io/FileOutputStream
    //   21: dup
    //   22: aload_0
    //   23: iconst_1
    //   24: invokespecial 89	com/sina/weibo/sdk/utils/AidTask:getAidInfoFile	(I)Ljava/io/File;
    //   27: invokespecial 130	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 136	java/lang/String:getBytes	()[B
    //   36: invokevirtual 140	java/io/FileOutputStream:write	([B)V
    //   39: aload_2
    //   40: ifnull -27 -> 13
    //   43: aload_2
    //   44: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   47: goto -34 -> 13
    //   50: astore_1
    //   51: goto -38 -> 13
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull -45 -> 13
    //   61: aload_2
    //   62: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   65: goto -52 -> 13
    //   68: astore_1
    //   69: goto -56 -> 13
    //   72: astore_1
    //   73: aload_3
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 143	java/io/FileOutputStream:close	()V
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    //   90: astore_2
    //   91: goto -8 -> 83
    //   94: astore_1
    //   95: goto -20 -> 75
    //   98: astore_1
    //   99: goto -42 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	AidTask
    //   0	102	1	paramString	String
    //   30	50	2	localObject1	Object
    //   90	1	2	localIOException	java.io.IOException
    //   17	57	3	localObject2	Object
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/io/IOException
    //   18	31	54	java/lang/Exception
    //   61	65	68	java/io/IOException
    //   18	31	72	finally
    //   2	8	85	finally
    //   43	47	85	finally
    //   61	65	85	finally
    //   79	83	85	finally
    //   83	85	85	finally
    //   79	83	90	java/io/IOException
    //   31	39	94	finally
    //   31	39	98	java/lang/Exception
  }
  
  /* Error */
  private static String encryptRsa(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc -109
    //   2: invokestatic 153	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_2
    //   6: aload_2
    //   7: iconst_1
    //   8: aload_1
    //   9: invokestatic 157	com/sina/weibo/sdk/utils/AidTask:getPublicKey	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   12: invokevirtual 161	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   15: aload_0
    //   16: ldc -93
    //   18: invokevirtual 166	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   21: astore_0
    //   22: new 168	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore_1
    //   30: iconst_0
    //   31: istore 4
    //   33: aload_0
    //   34: iload 4
    //   36: bipush 117
    //   38: invokestatic 173	com/sina/weibo/sdk/utils/AidTask:splite	([BII)I
    //   41: istore 5
    //   43: iload 5
    //   45: iconst_m1
    //   46: if_icmpne +120 -> 166
    //   49: aload_1
    //   50: invokevirtual 176	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_1
    //   54: invokevirtual 179	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   57: astore_0
    //   58: ldc 23
    //   60: new 181	java/lang/StringBuilder
    //   63: dup
    //   64: ldc -73
    //   66: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: arraylength
    //   71: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 198	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload_0
    //   81: invokestatic 204	com/sina/weibo/sdk/utils/Base64:encodebyte	([B)[B
    //   84: astore_0
    //   85: ldc 23
    //   87: new 181	java/lang/StringBuilder
    //   90: dup
    //   91: ldc -50
    //   93: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: arraylength
    //   98: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 198	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: new 132	java/lang/String
    //   110: dup
    //   111: aload_0
    //   112: ldc -93
    //   114: invokespecial 209	java/lang/String:<init>	([BLjava/lang/String;)V
    //   117: astore_0
    //   118: new 181	java/lang/StringBuilder
    //   121: dup
    //   122: ldc -45
    //   124: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore_0
    //   135: ldc 23
    //   137: new 181	java/lang/StringBuilder
    //   140: dup
    //   141: ldc -40
    //   143: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 198	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   164: aload_0
    //   165: areturn
    //   166: aload_2
    //   167: aload_0
    //   168: iload 4
    //   170: iload 5
    //   172: invokevirtual 221	javax/crypto/Cipher:doFinal	([BII)[B
    //   175: astore_3
    //   176: aload_1
    //   177: aload_3
    //   178: invokevirtual 222	java/io/ByteArrayOutputStream:write	([B)V
    //   181: ldc 23
    //   183: new 181	java/lang/StringBuilder
    //   186: dup
    //   187: ldc -32
    //   189: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: iload 4
    //   194: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc -30
    //   199: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 5
    //   204: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: ldc -28
    //   209: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_3
    //   213: arraylength
    //   214: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 198	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: iload 4
    //   225: iload 5
    //   227: iadd
    //   228: istore 4
    //   230: goto -197 -> 33
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 217	java/io/ByteArrayOutputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_1
    //   247: aload_0
    //   248: areturn
    //   249: astore_1
    //   250: goto -6 -> 244
    //   253: astore_0
    //   254: goto -18 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString1	String
    //   0	257	1	paramString2	String
    //   5	162	2	localCipher	javax.crypto.Cipher
    //   175	38	3	arrayOfByte	byte[]
    //   31	198	4	i	int
    //   41	187	5	j	int
    // Exception table:
    //   from	to	target	type
    //   22	30	233	finally
    //   160	164	246	java/io/IOException
    //   240	244	249	java/io/IOException
    //   33	43	253	finally
    //   49	156	253	finally
    //   166	223	253	finally
  }
  
  private static String genMfpString(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str = getOS();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("1", str);
      }
      str = getImei(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("2", str);
      }
      str = getMeid(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("3", str);
      }
      str = getImsi(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("4", str);
      }
      str = getMac(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("5", str);
      }
      str = getIccid(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("6", str);
      }
      str = getSerialNo();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("7", str);
      }
      str = getAndroidId(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("10", str);
      }
      str = getCpu();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("13", str);
      }
      str = getModel();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("14", str);
      }
      str = getSdSize();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("15", str);
      }
      str = getResolution(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("16", str);
      }
      str = getSsid(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("17", str);
      }
      str = getDeviceName();
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("18", str);
      }
      str = getConnectType(paramContext);
      if (!TextUtils.isEmpty(str)) {
        localJSONObject.put("19", str);
      }
      str = "";
      try
      {
        paramContext = Utility.generateUAAid(paramContext);
        if (!TextUtils.isEmpty(paramContext)) {
          localJSONObject.put("20", paramContext);
        }
        return localJSONObject.toString();
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = str;
        }
      }
      return "";
    }
    catch (JSONException paramContext) {}
  }
  
  private void generateAid(String paramString, AidResultCallBack paramAidResultCallBack)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mAppKey = paramString;
    new Thread(new AidTask.3(this, paramAidResultCallBack)).start();
  }
  
  private File getAidInfoFile(int paramInt)
  {
    return new File(this.mContext.getFilesDir(), "weibo_sdk_aid" + paramInt);
  }
  
  private static String getAndroidId(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getConnectType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        if (paramContext.getType() == 0) {}
        switch (paramContext.getSubtype())
        {
        default: 
          if (paramContext.getType() == 1) {
            return "wifi";
          }
          break;
        }
      }
    }
    catch (Exception paramContext)
    {
      return "none";
    }
    return "none";
    return "none";
    return "2G";
    return "3G";
    return "4G";
  }
  
  private static String getCpu()
  {
    try
    {
      String str = Build.CPU_ABI;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getDeviceName()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getIccid(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getImei(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getImsi(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static AidTask getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new AidTask(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private static String getMac(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getMacAddress();
      }
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getMeid(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getMfp(Context paramContext)
  {
    paramContext = genMfpString(paramContext);
    try
    {
      paramContext = new String(paramContext.getBytes(), "UTF-8");
      LogUtil.d("AidTask", "genMfpString() utf-8 string : " + paramContext);
    }
    catch (UnsupportedEncodingException paramContext)
    {
      for (;;)
      {
        try
        {
          paramContext = encryptRsa(paramContext, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
          LogUtil.d("AidTask", "encryptRsa() string : " + paramContext);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          LogUtil.e("AidTask", paramContext.getMessage());
        }
        paramContext = paramContext;
        paramContext = "";
      }
    }
    return "";
  }
  
  private static String getModel()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getOS()
  {
    try
    {
      String str = "Android " + Build.VERSION.RELEASE;
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static PublicKey getPublicKey(String paramString)
  {
    paramString = new X509EncodedKeySpec(Base64.decode(paramString.getBytes()));
    return KeyFactory.getInstance("RSA").generatePublic(paramString);
  }
  
  private static String getResolution(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      paramContext = String.valueOf(localDisplayMetrics.widthPixels) + "*" + String.valueOf(localDisplayMetrics.heightPixels);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private static String getSdSize()
  {
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = ((StatFs)localObject).getBlockSize();
      localObject = Long.toString(((StatFs)localObject).getBlockCount() * l);
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getSerialNo()
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { "ro.serialno", "unknown" });
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String getSsid(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  private void initAidInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mAppKey = paramString;
    new Thread(new AidTask.2(this)).start();
  }
  
  private String loadAidFromNet()
  {
    String str1 = this.mContext.getPackageName();
    String str2 = Utility.getSign(this.mContext, str1);
    String str3 = getMfp(this.mContext);
    WeiboParameters localWeiboParameters = new WeiboParameters(this.mAppKey);
    localWeiboParameters.put("appkey", this.mAppKey);
    localWeiboParameters.put("mfp", str3);
    localWeiboParameters.put("packagename", str1);
    localWeiboParameters.put("key_hash", str2);
    try
    {
      str1 = NetUtils.internalHttpRequest(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", localWeiboParameters);
      LogUtil.d("AidTask", "loadAidFromNet response : " + str1);
      return str1;
    }
    catch (WeiboException localWeiboException)
    {
      LogUtil.d("AidTask", "loadAidFromNet WeiboException Msg : " + localWeiboException.getMessage());
      throw localWeiboException;
    }
  }
  
  /* Error */
  private AidInfo loadAidInfoFromCache()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 598	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: iconst_1
    //   10: invokespecial 89	com/sina/weibo/sdk/utils/AidTask:getAidInfoFile	(I)Ljava/io/File;
    //   13: invokespecial 599	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 602	java/io/FileInputStream:available	()I
    //   21: newarray <illegal type>
    //   23: astore_2
    //   24: aload_1
    //   25: aload_2
    //   26: invokevirtual 606	java/io/FileInputStream:read	([B)I
    //   29: pop
    //   30: new 132	java/lang/String
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 607	java/lang/String:<init>	([B)V
    //   38: invokestatic 611	com/sina/weibo/sdk/utils/AidTask$AidInfo:parseJson	(Ljava/lang/String;)Lcom/sina/weibo/sdk/utils/AidTask$AidInfo;
    //   41: astore_2
    //   42: aload_2
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_1
    //   51: invokevirtual 612	java/io/FileInputStream:close	()V
    //   54: aload_3
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: areturn
    //   60: astore_1
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_3
    //   64: astore_2
    //   65: aload_1
    //   66: ifnull -10 -> 56
    //   69: aload_1
    //   70: invokevirtual 612	java/io/FileInputStream:close	()V
    //   73: aload_3
    //   74: astore_2
    //   75: goto -19 -> 56
    //   78: astore_1
    //   79: aload_3
    //   80: astore_2
    //   81: goto -25 -> 56
    //   84: astore_2
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 612	java/io/FileInputStream:close	()V
    //   95: aload_2
    //   96: athrow
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: aload_3
    //   104: astore_2
    //   105: goto -49 -> 56
    //   108: astore_1
    //   109: goto -14 -> 95
    //   112: astore_2
    //   113: goto -26 -> 87
    //   116: astore_2
    //   117: goto -54 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	AidTask
    //   16	35	1	localFileInputStream	java.io.FileInputStream
    //   60	1	1	localException1	Exception
    //   62	8	1	localObject1	Object
    //   78	1	1	localIOException1	java.io.IOException
    //   86	6	1	localObject2	Object
    //   97	4	1	localObject3	Object
    //   102	1	1	localIOException2	java.io.IOException
    //   108	1	1	localIOException3	java.io.IOException
    //   23	58	2	localObject4	Object
    //   84	12	2	localObject5	Object
    //   104	1	2	localObject6	Object
    //   112	1	2	localObject7	Object
    //   116	1	2	localException2	Exception
    //   1	103	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   4	17	60	java/lang/Exception
    //   69	73	78	java/io/IOException
    //   4	17	84	finally
    //   50	54	97	finally
    //   69	73	97	finally
    //   91	95	97	finally
    //   95	97	97	finally
    //   50	54	102	java/io/IOException
    //   91	95	108	java/io/IOException
    //   17	42	112	finally
    //   17	42	116	java/lang/Exception
  }
  
  private static int splite(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramArrayOfByte.length) {
      return -1;
    }
    return Math.min(paramArrayOfByte.length - paramInt1, paramInt2);
  }
  
  public void aidTaskInit(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    LogUtil.e("AidTask", "aidTaskInit ");
    initAidInfo(paramString);
  }
  
  public void getAidAsync(String paramString, AidResultCallBack paramAidResultCallBack)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((this.mAidInfo != null) && (paramAidResultCallBack != null))
    {
      paramAidResultCallBack.onAidGenSuccessed(this.mAidInfo.cloneAidInfo());
      return;
    }
    generateAid(paramString, paramAidResultCallBack);
  }
  
  public AidInfo getAidSync(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LogUtil.e("AidTask", "getAidSync ");
    if (this.mAidInfo == null) {
      aidTaskInit(paramString);
    }
    return this.mAidInfo;
  }
  
  public static final class AidInfo
  {
    private String mAid;
    private String mSubCookie;
    
    public static AidInfo parseJson(String paramString)
    {
      AidInfo localAidInfo = new AidInfo();
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("error")) || (paramString.has("error_code")))
        {
          LogUtil.d("AidTask", "loadAidFromNet has error !!!");
          throw new WeiboException("loadAidFromNet has error !!!");
        }
      }
      catch (JSONException paramString)
      {
        LogUtil.d("AidTask", "loadAidFromNet JSONException Msg : " + paramString.getMessage());
        throw new WeiboException("loadAidFromNet has error !!!");
      }
      localAidInfo.mAid = paramString.optString("aid", "");
      localAidInfo.mSubCookie = paramString.optString("sub", "");
      return localAidInfo;
    }
    
    AidInfo cloneAidInfo()
    {
      AidInfo localAidInfo = new AidInfo();
      localAidInfo.mAid = this.mAid;
      localAidInfo.mSubCookie = this.mSubCookie;
      return localAidInfo;
    }
    
    public String getAid()
    {
      return this.mAid;
    }
    
    public String getSubCookie()
    {
      return this.mSubCookie;
    }
  }
  
  public static abstract interface AidResultCallBack
  {
    public abstract void onAidGenFailed(Exception paramException);
    
    public abstract void onAidGenSuccessed(AidTask.AidInfo paramAidInfo);
  }
  
  private static class CallbackHandler
    extends Handler
  {
    private WeakReference<AidTask.AidResultCallBack> callBackReference;
    
    public CallbackHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      AidTask.AidResultCallBack localAidResultCallBack = (AidTask.AidResultCallBack)this.callBackReference.get();
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (localAidResultCallBack == null);
        localAidResultCallBack.onAidGenSuccessed(((AidTask.AidInfo)paramMessage.obj).cloneAidInfo());
        return;
      } while (localAidResultCallBack == null);
      localAidResultCallBack.onAidGenFailed((WeiboException)paramMessage.obj);
    }
    
    public void setCallback(AidTask.AidResultCallBack paramAidResultCallBack)
    {
      if (this.callBackReference != null)
      {
        if ((AidTask.AidResultCallBack)this.callBackReference.get() == paramAidResultCallBack) {
          return;
        }
        this.callBackReference = new WeakReference(paramAidResultCallBack);
        return;
      }
      this.callBackReference = new WeakReference(paramAidResultCallBack);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\utils\AidTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */