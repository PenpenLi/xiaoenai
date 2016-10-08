package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LogReport
{
  private static final int CONNECTION_TIMEOUT = 25000;
  private static final String PRIVATE_CODE = "dqwef1864il4c9m6";
  private static final int SOCKET_TIMEOUT = 20000;
  private static String UPLOADTIME = "uploadtime";
  private static String mAid;
  private static String mAppkey;
  private static String mBaseUrl = "https://api.weibo.com/2/proxy/sdk/statistic.json";
  private static String mChannel;
  private static String mKeyHash;
  public static LogReport mLogReport;
  private static String mPackageName;
  private static JSONObject mParams;
  private static String mVersionName;
  
  public LogReport(Context paramContext)
  {
    try
    {
      if (mPackageName == null) {
        mPackageName = paramContext.getPackageName();
      }
      mAppkey = StatisticConfig.getAppkey(paramContext);
      checkAid(paramContext);
      mKeyHash = Utility.getSign(paramContext, mPackageName);
      mVersionName = LogBuilder.getVersion(paramContext);
      mChannel = StatisticConfig.getChannel(paramContext);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        LogUtil.e("WBAgent", paramContext.toString());
      }
    }
    initCommonParams();
  }
  
  private static void checkAid(Context paramContext)
  {
    if (TextUtils.isEmpty(mAid)) {
      mAid = Utility.getAid(paramContext, mAppkey);
    }
    if (mParams == null) {
      mParams = new JSONObject();
    }
    try
    {
      mParams.put("aid", mAid);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  /* Error */
  private static org.apache.http.client.methods.HttpPost getNewHttpPost(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 127	org/apache/http/client/methods/HttpPost
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 130	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: ldc -124
    //   15: ldc -122
    //   17: invokevirtual 137	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_1
    //   21: ldc -117
    //   23: ldc -115
    //   25: invokevirtual 137	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: invokestatic 145	com/sina/weibo/sdk/statistic/StatisticConfig:isNeedGizp	()Z
    //   31: ifeq +42 -> 73
    //   34: ldc -109
    //   36: astore_0
    //   37: aload_1
    //   38: ldc -107
    //   40: aload_0
    //   41: invokevirtual 152	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_1
    //   45: ldc -102
    //   47: ldc -100
    //   49: invokevirtual 152	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc -98
    //   55: ldc -96
    //   57: invokevirtual 152	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_1
    //   61: ldc -94
    //   63: ldc -109
    //   65: invokevirtual 152	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_1
    //   72: areturn
    //   73: ldc -92
    //   75: astore_0
    //   76: goto -39 -> 37
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramString	String
    //   0	85	1	paramJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	34	79	finally
    //   37	68	79	finally
  }
  
  public static String getPackageName()
  {
    return mPackageName;
  }
  
  private static String getSign(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    localStringBuilder.append(paramString2).append("dqwef1864il4c9m6").append(paramLong);
    paramString1 = MD5.hexdigest(localStringBuilder.toString());
    paramString1 = paramString1.substring(paramString1.length() - 6);
    paramString2 = MD5.hexdigest(paramString1 + paramString1.substring(0, 4));
    return paramString1 + paramString2.substring(paramString2.length() - 1);
  }
  
  public static long getTime(Context paramContext)
  {
    return paramContext.getSharedPreferences(UPLOADTIME, 0).getLong("lasttime", 0L);
  }
  
  private static byte[] gzipLogs(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = paramString.getBytes("utf-8");
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString);
      localGZIPOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static JSONObject initCommonParams()
  {
    if (mParams == null) {
      mParams = new JSONObject();
    }
    try
    {
      mParams.put("appkey", mAppkey);
      mParams.put("platform", "Android");
      mParams.put("packagename", mPackageName);
      mParams.put("key_hash", mKeyHash);
      mParams.put("version", mVersionName);
      mParams.put("channel", mChannel);
      return mParams;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext == null)
    {
      LogUtil.e("WBAgent", "unexpected null context in isNetworkConnected");
      return false;
    }
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isAvailable())) {
        return false;
      }
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return true;
  }
  
  /* Error */
  private static HttpResponse requestHttpExecute(String paramString1, String paramString2, JSONObject paramJSONObject, JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 12
    //   12: aconst_null
    //   13: astore 13
    //   15: aconst_null
    //   16: astore 8
    //   18: invokestatic 304	com/sina/weibo/sdk/net/HttpManager:getNewHttpClient	()Lorg/apache/http/client/HttpClient;
    //   21: astore 4
    //   23: aload_2
    //   24: astore 10
    //   26: aload_2
    //   27: ifnonnull +8 -> 35
    //   30: invokestatic 85	com/sina/weibo/sdk/statistic/LogReport:initCommonParams	()Lorg/json/JSONObject;
    //   33: astore 10
    //   35: aload 10
    //   37: ldc_w 306
    //   40: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   43: ldc2_w 313
    //   46: ldiv
    //   47: invokevirtual 317	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload 10
    //   53: ldc_w 318
    //   56: aload_3
    //   57: invokevirtual 321	org/json/JSONArray:length	()I
    //   60: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload 10
    //   66: ldc_w 326
    //   69: aload 10
    //   71: ldc 116
    //   73: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: aload 10
    //   78: ldc -11
    //   80: invokevirtual 329	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: aload 10
    //   85: ldc_w 306
    //   88: invokevirtual 332	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   91: invokestatic 334	com/sina/weibo/sdk/statistic/LogReport:getSign	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   94: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload 10
    //   100: ldc_w 336
    //   103: aload_3
    //   104: invokevirtual 120	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   107: pop
    //   108: ldc 87
    //   110: new 167	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 338
    //   117: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload 10
    //   122: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   125: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 342	com/sina/weibo/sdk/utils/LogUtil:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_1
    //   135: ldc_w 344
    //   138: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +188 -> 329
    //   144: new 350	org/apache/http/client/methods/HttpGet
    //   147: dup
    //   148: new 167	java/lang/StringBuilder
    //   151: dup
    //   152: aload_0
    //   153: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: ldc_w 352
    //   162: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 10
    //   167: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   170: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 353	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   179: astore 10
    //   181: aconst_null
    //   182: astore_0
    //   183: aload 11
    //   185: astore_3
    //   186: aload_0
    //   187: astore 7
    //   189: aload_0
    //   190: astore_1
    //   191: aload 4
    //   193: astore_2
    //   194: aload 12
    //   196: astore 9
    //   198: aload_0
    //   199: astore 5
    //   201: aload 13
    //   203: astore 8
    //   205: aload_0
    //   206: astore 6
    //   208: aload 4
    //   210: aload 10
    //   212: invokeinterface 359 2 0
    //   217: astore 10
    //   219: aload 10
    //   221: astore_3
    //   222: aload_0
    //   223: astore 7
    //   225: aload_0
    //   226: astore_1
    //   227: aload 4
    //   229: astore_2
    //   230: aload 10
    //   232: astore 9
    //   234: aload_0
    //   235: astore 5
    //   237: aload 10
    //   239: astore 8
    //   241: aload_0
    //   242: astore 6
    //   244: ldc 87
    //   246: new 167	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 361
    //   253: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload 10
    //   258: invokeinterface 367 1 0
    //   263: invokeinterface 372 1 0
    //   268: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 378	com/sina/weibo/sdk/utils/LogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   285: aload 4
    //   287: invokestatic 383	com/sina/weibo/sdk/statistic/LogReport:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   290: aload 10
    //   292: areturn
    //   293: astore_2
    //   294: aload_2
    //   295: invokevirtual 123	org/json/JSONException:printStackTrace	()V
    //   298: goto -164 -> 134
    //   301: astore_3
    //   302: aconst_null
    //   303: astore_0
    //   304: aload_0
    //   305: astore_1
    //   306: aload 4
    //   308: astore_2
    //   309: aload_3
    //   310: invokevirtual 384	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   321: aload 4
    //   323: invokestatic 383	com/sina/weibo/sdk/statistic/LogReport:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   326: aload 8
    //   328: areturn
    //   329: aload_1
    //   330: ldc_w 386
    //   333: invokevirtual 348	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   336: ifeq +408 -> 744
    //   339: getstatic 58	com/sina/weibo/sdk/statistic/LogReport:mAppkey	Ljava/lang/String;
    //   342: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   345: ifeq +30 -> 375
    //   348: ldc 87
    //   350: ldc_w 388
    //   353: invokestatic 96	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: iconst_0
    //   357: ifeq +11 -> 368
    //   360: new 261	java/lang/NullPointerException
    //   363: dup
    //   364: invokespecial 389	java/lang/NullPointerException:<init>	()V
    //   367: athrow
    //   368: aload 4
    //   370: invokestatic 383	com/sina/weibo/sdk/statistic/LogReport:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   373: aconst_null
    //   374: areturn
    //   375: new 167	java/lang/StringBuilder
    //   378: dup
    //   379: aload_0
    //   380: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   383: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: ldc_w 352
    //   389: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 391
    //   395: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: getstatic 58	com/sina/weibo/sdk/statistic/LogReport:mAppkey	Ljava/lang/String;
    //   401: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: aload 10
    //   409: invokestatic 393	com/sina/weibo/sdk/statistic/LogReport:getNewHttpPost	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/apache/http/client/methods/HttpPost;
    //   412: astore 14
    //   414: new 220	java/io/ByteArrayOutputStream
    //   417: dup
    //   418: invokespecial 221	java/io/ByteArrayOutputStream:<init>	()V
    //   421: astore_0
    //   422: aload 11
    //   424: astore_3
    //   425: aload_0
    //   426: astore 7
    //   428: aload_0
    //   429: astore_1
    //   430: aload 4
    //   432: astore_2
    //   433: aload 12
    //   435: astore 9
    //   437: aload_0
    //   438: astore 5
    //   440: aload 13
    //   442: astore 8
    //   444: aload_0
    //   445: astore 6
    //   447: invokestatic 145	com/sina/weibo/sdk/statistic/StatisticConfig:isNeedGizp	()Z
    //   450: ifeq +88 -> 538
    //   453: aload 11
    //   455: astore_3
    //   456: aload_0
    //   457: astore 7
    //   459: aload_0
    //   460: astore_1
    //   461: aload 4
    //   463: astore_2
    //   464: aload 12
    //   466: astore 9
    //   468: aload_0
    //   469: astore 5
    //   471: aload 13
    //   473: astore 8
    //   475: aload_0
    //   476: astore 6
    //   478: aload_0
    //   479: aload 10
    //   481: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   484: invokestatic 395	com/sina/weibo/sdk/statistic/LogReport:gzipLogs	(Ljava/lang/String;)[B
    //   487: invokevirtual 396	java/io/ByteArrayOutputStream:write	([B)V
    //   490: aload 11
    //   492: astore_3
    //   493: aload_0
    //   494: astore 7
    //   496: aload_0
    //   497: astore_1
    //   498: aload 4
    //   500: astore_2
    //   501: aload 12
    //   503: astore 9
    //   505: aload_0
    //   506: astore 5
    //   508: aload 13
    //   510: astore 8
    //   512: aload_0
    //   513: astore 6
    //   515: aload 14
    //   517: new 398	org/apache/http/entity/ByteArrayEntity
    //   520: dup
    //   521: aload_0
    //   522: invokevirtual 242	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   525: invokespecial 400	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   528: invokevirtual 404	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   531: aload 14
    //   533: astore 10
    //   535: goto -352 -> 183
    //   538: aload 11
    //   540: astore_3
    //   541: aload_0
    //   542: astore 7
    //   544: aload_0
    //   545: astore_1
    //   546: aload 4
    //   548: astore_2
    //   549: aload 12
    //   551: astore 9
    //   553: aload_0
    //   554: astore 5
    //   556: aload 13
    //   558: astore 8
    //   560: aload_0
    //   561: astore 6
    //   563: aload_0
    //   564: aload 10
    //   566: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   569: invokevirtual 406	java/lang/String:getBytes	()[B
    //   572: invokevirtual 396	java/io/ByteArrayOutputStream:write	([B)V
    //   575: goto -85 -> 490
    //   578: astore 5
    //   580: aload 7
    //   582: astore_0
    //   583: aload_0
    //   584: astore_1
    //   585: aload 4
    //   587: astore_2
    //   588: aload 5
    //   590: invokevirtual 407	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   593: aload_0
    //   594: ifnull +7 -> 601
    //   597: aload_0
    //   598: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   601: aload 4
    //   603: invokestatic 383	com/sina/weibo/sdk/statistic/LogReport:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   606: aload_3
    //   607: areturn
    //   608: astore_3
    //   609: aconst_null
    //   610: astore_0
    //   611: aconst_null
    //   612: astore 4
    //   614: aload_0
    //   615: astore_1
    //   616: aload 4
    //   618: astore_2
    //   619: aload_3
    //   620: invokevirtual 243	java/io/IOException:printStackTrace	()V
    //   623: aload_0
    //   624: ifnull +7 -> 631
    //   627: aload_0
    //   628: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   631: aload 4
    //   633: invokestatic 383	com/sina/weibo/sdk/statistic/LogReport:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   636: aload 9
    //   638: areturn
    //   639: astore_0
    //   640: aconst_null
    //   641: astore_1
    //   642: aconst_null
    //   643: astore_2
    //   644: aload_1
    //   645: ifnull +7 -> 652
    //   648: aload_1
    //   649: invokevirtual 379	java/io/ByteArrayOutputStream:close	()V
    //   652: aload_2
    //   653: invokestatic 383	com/sina/weibo/sdk/statistic/LogReport:shutdownHttpClient	(Lorg/apache/http/client/HttpClient;)V
    //   656: aload_0
    //   657: athrow
    //   658: astore_0
    //   659: goto -291 -> 368
    //   662: astore_0
    //   663: goto -342 -> 321
    //   666: astore_0
    //   667: goto -66 -> 601
    //   670: astore_0
    //   671: goto -40 -> 631
    //   674: astore_1
    //   675: goto -23 -> 652
    //   678: astore_0
    //   679: goto -394 -> 285
    //   682: astore_0
    //   683: aconst_null
    //   684: astore_1
    //   685: aload 4
    //   687: astore_2
    //   688: goto -44 -> 644
    //   691: astore_0
    //   692: goto -48 -> 644
    //   695: astore_3
    //   696: aconst_null
    //   697: astore_0
    //   698: goto -84 -> 614
    //   701: astore_3
    //   702: aload 5
    //   704: astore_0
    //   705: goto -91 -> 614
    //   708: astore_1
    //   709: aconst_null
    //   710: astore_0
    //   711: aconst_null
    //   712: astore 4
    //   714: aload 5
    //   716: astore_3
    //   717: aload_1
    //   718: astore 5
    //   720: goto -137 -> 583
    //   723: astore_1
    //   724: aconst_null
    //   725: astore_0
    //   726: aload 5
    //   728: astore_3
    //   729: aload_1
    //   730: astore 5
    //   732: goto -149 -> 583
    //   735: astore_3
    //   736: aconst_null
    //   737: astore_0
    //   738: aconst_null
    //   739: astore 4
    //   741: goto -437 -> 304
    //   744: aconst_null
    //   745: astore 10
    //   747: aconst_null
    //   748: astore_0
    //   749: goto -566 -> 183
    //   752: astore_3
    //   753: aload 6
    //   755: astore_0
    //   756: goto -452 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	759	0	paramString1	String
    //   0	759	1	paramString2	String
    //   0	759	2	paramJSONObject	JSONObject
    //   0	759	3	paramJSONArray	JSONArray
    //   21	719	4	localHttpClient	HttpClient
    //   4	551	5	str1	String
    //   578	137	5	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   718	13	5	str2	String
    //   206	548	6	str3	String
    //   187	394	7	str4	String
    //   16	543	8	localObject1	Object
    //   7	630	9	localObject2	Object
    //   24	722	10	localObject3	Object
    //   1	538	11	localObject4	Object
    //   10	540	12	localObject5	Object
    //   13	544	13	localObject6	Object
    //   412	120	14	localHttpPost	org.apache.http.client.methods.HttpPost
    // Exception table:
    //   from	to	target	type
    //   35	134	293	org/json/JSONException
    //   30	35	301	java/io/UnsupportedEncodingException
    //   35	134	301	java/io/UnsupportedEncodingException
    //   134	181	301	java/io/UnsupportedEncodingException
    //   294	298	301	java/io/UnsupportedEncodingException
    //   329	356	301	java/io/UnsupportedEncodingException
    //   375	422	301	java/io/UnsupportedEncodingException
    //   208	219	578	org/apache/http/client/ClientProtocolException
    //   244	277	578	org/apache/http/client/ClientProtocolException
    //   447	453	578	org/apache/http/client/ClientProtocolException
    //   478	490	578	org/apache/http/client/ClientProtocolException
    //   515	531	578	org/apache/http/client/ClientProtocolException
    //   563	575	578	org/apache/http/client/ClientProtocolException
    //   18	23	608	java/io/IOException
    //   18	23	639	finally
    //   360	368	658	java/io/IOException
    //   317	321	662	java/io/IOException
    //   597	601	666	java/io/IOException
    //   627	631	670	java/io/IOException
    //   648	652	674	java/io/IOException
    //   281	285	678	java/io/IOException
    //   30	35	682	finally
    //   35	134	682	finally
    //   134	181	682	finally
    //   294	298	682	finally
    //   329	356	682	finally
    //   375	422	682	finally
    //   208	219	691	finally
    //   244	277	691	finally
    //   309	313	691	finally
    //   447	453	691	finally
    //   478	490	691	finally
    //   515	531	691	finally
    //   563	575	691	finally
    //   588	593	691	finally
    //   619	623	691	finally
    //   30	35	695	java/io/IOException
    //   35	134	695	java/io/IOException
    //   134	181	695	java/io/IOException
    //   294	298	695	java/io/IOException
    //   329	356	695	java/io/IOException
    //   375	422	695	java/io/IOException
    //   208	219	701	java/io/IOException
    //   244	277	701	java/io/IOException
    //   447	453	701	java/io/IOException
    //   478	490	701	java/io/IOException
    //   515	531	701	java/io/IOException
    //   563	575	701	java/io/IOException
    //   18	23	708	org/apache/http/client/ClientProtocolException
    //   30	35	723	org/apache/http/client/ClientProtocolException
    //   35	134	723	org/apache/http/client/ClientProtocolException
    //   134	181	723	org/apache/http/client/ClientProtocolException
    //   294	298	723	org/apache/http/client/ClientProtocolException
    //   329	356	723	org/apache/http/client/ClientProtocolException
    //   375	422	723	org/apache/http/client/ClientProtocolException
    //   18	23	735	java/io/UnsupportedEncodingException
    //   208	219	752	java/io/UnsupportedEncodingException
    //   244	277	752	java/io/UnsupportedEncodingException
    //   447	453	752	java/io/UnsupportedEncodingException
    //   478	490	752	java/io/UnsupportedEncodingException
    //   515	531	752	java/io/UnsupportedEncodingException
    //   563	575	752	java/io/UnsupportedEncodingException
  }
  
  public static void setPackageName(String paramString)
  {
    mPackageName = paramString;
  }
  
  private static void shutdownHttpClient(HttpClient paramHttpClient)
  {
    if (paramHttpClient != null) {}
    try
    {
      paramHttpClient.getConnectionManager().closeExpiredConnections();
      return;
    }
    catch (Exception paramHttpClient) {}
  }
  
  private static void updateTime(Context paramContext, Long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(UPLOADTIME, 0).edit();
    paramContext.putLong("lasttime", paramLong.longValue());
    paramContext.commit();
  }
  
  public static void uploadAppLogs(Context paramContext, String paramString)
  {
    try
    {
      if (mLogReport == null) {
        mLogReport = new LogReport(paramContext);
      }
      if (!isNetworkConnected(paramContext))
      {
        LogUtil.i("WBAgent", "network is not connected");
        LogFileUtil.writeToFile(LogFileUtil.getAppLogPath("app_logs"), paramString, true);
      }
      for (;;)
      {
        return;
        localObject = LogBuilder.getValidUploadLogs(paramString);
        if (localObject != null) {
          break;
        }
        LogUtil.i("WBAgent", "applogs is null");
      }
      paramString = new ArrayList();
    }
    finally {}
    checkAid(paramContext);
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        LogFileUtil.delete(LogFileUtil.getAppLogPath("app_logs"));
        if (paramString.size() <= 0) {
          break;
        }
        paramContext = paramString.iterator();
        while (paramContext.hasNext())
        {
          paramString = (JSONArray)paramContext.next();
          LogFileUtil.writeToFile(LogFileUtil.getAppLogPath("app_logs"), paramString.toString(), true);
          LogUtil.d("WBAgent", "save failed_log");
        }
        break;
      }
      JSONArray localJSONArray = (JSONArray)((Iterator)localObject).next();
      HttpResponse localHttpResponse = requestHttpExecute(mBaseUrl, "POST", mParams, localJSONArray);
      if (localHttpResponse == null) {}
      while (localHttpResponse.getStatusLine().getStatusCode() != 200)
      {
        paramString.add(localJSONArray);
        LogUtil.e("WBAgent", "upload applogs error");
        break;
      }
      updateTime(paramContext, Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\statistic\LogReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */