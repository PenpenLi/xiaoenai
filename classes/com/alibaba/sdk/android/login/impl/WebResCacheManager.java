package com.alibaba.sdk.android.login.impl;

import android.content.Context;
import android.content.SharedPreferences;

public class WebResCacheManager
{
  private static final String ENCODING = "encoding";
  public static final WebResCacheManager INSTANCE = new WebResCacheManager();
  private static final String LAST_UPDATE_TS = "lastUpdateTs";
  private static final String MIME_TYPE = "mimeType";
  private static final String TAG = WebResCacheManager.class.getSimpleName();
  private Context context;
  private SharedPreferences webResCacheSp;
  
  private boolean isCahceable(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = new String[6];
      arrayOfString[0] = ".png";
      arrayOfString[1] = ".jpg";
      arrayOfString[2] = ".js";
      arrayOfString[3] = ".css";
      arrayOfString[4] = ".htm";
      arrayOfString[5] = ".html";
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.endsWith(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private android.webkit.WebResourceResponse loadFromCache(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/alibaba/sdk/android/login/impl/WebResCacheManager:context	Landroid/content/Context;
    //   4: aload_1
    //   5: invokevirtual 74	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 76	com/alibaba/sdk/android/login/impl/WebResCacheManager:webResCacheSp	Landroid/content/SharedPreferences;
    //   15: aload_1
    //   16: aconst_null
    //   17: invokeinterface 82 3 0
    //   22: astore_1
    //   23: aload_1
    //   24: ifnonnull +9 -> 33
    //   27: aload_3
    //   28: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_3
    //   34: astore_2
    //   35: new 90	org/json/JSONObject
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_3
    //   45: astore_2
    //   46: new 95	android/webkit/WebResourceResponse
    //   49: dup
    //   50: aload_1
    //   51: ldc 16
    //   53: invokevirtual 99	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: aload_1
    //   57: ldc 8
    //   59: invokevirtual 99	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: new 101	java/io/ByteArrayInputStream
    //   65: dup
    //   66: aload_3
    //   67: invokestatic 105	com/alibaba/sdk/android/util/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   70: invokespecial 108	java/io/ByteArrayInputStream:<init>	([B)V
    //   73: invokespecial 111	android/webkit/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   76: astore_1
    //   77: aload_3
    //   78: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_3
    //   86: aload_3
    //   87: astore_2
    //   88: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   91: aconst_null
    //   92: aload_1
    //   93: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: aload_3
    //   98: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_3
    //   107: astore_2
    //   108: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   111: aconst_null
    //   112: aload_1
    //   113: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   116: pop
    //   117: aload_3
    //   118: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: goto -7 -> 126
    //   136: astore_1
    //   137: goto -31 -> 106
    //   140: astore_1
    //   141: goto -55 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	WebResCacheManager
    //   0	144	1	paramString	String
    //   10	117	2	localFileInputStream1	java.io.FileInputStream
    //   8	110	3	localFileInputStream2	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	9	83	java/io/FileNotFoundException
    //   0	9	103	org/json/JSONException
    //   0	9	123	finally
    //   11	23	132	finally
    //   35	44	132	finally
    //   46	77	132	finally
    //   88	97	132	finally
    //   108	117	132	finally
    //   11	23	136	org/json/JSONException
    //   35	44	136	org/json/JSONException
    //   46	77	136	org/json/JSONException
    //   11	23	140	java/io/FileNotFoundException
    //   35	44	140	java/io/FileNotFoundException
    //   46	77	140	java/io/FileNotFoundException
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this.webResCacheSp = this.context.getSharedPreferences("tae_sdk_h5_cache", 0);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  public android.webkit.WebResourceResponse shouldCache(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc -116
    //   3: invokevirtual 144	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   6: invokestatic 150	com/alibaba/sdk/android/login/utils/Md5Utils:md5Digest	([B)Ljava/lang/String;
    //   9: astore 7
    //   11: aload_0
    //   12: getfield 68	com/alibaba/sdk/android/login/impl/WebResCacheManager:context	Landroid/content/Context;
    //   15: invokestatic 156	com/alibaba/sdk/android/util/NetworkUtils:isNetworkAvaiable	(Landroid/content/Context;)Z
    //   18: ifeq +16 -> 34
    //   21: aload_0
    //   22: getfield 68	com/alibaba/sdk/android/login/impl/WebResCacheManager:context	Landroid/content/Context;
    //   25: invokestatic 160	com/alibaba/sdk/android/util/NetworkUtils:getMobileNetworkType	(Landroid/content/Context;)Lcom/alibaba/sdk/android/network/MobileNetworkType;
    //   28: getstatic 166	com/alibaba/sdk/android/network/MobileNetworkType:MOBILE_NETWORK_TYPE_2G	Lcom/alibaba/sdk/android/network/MobileNetworkType;
    //   31: if_acmpne +20 -> 51
    //   34: aload_0
    //   35: aload 7
    //   37: invokespecial 168	com/alibaba/sdk/android/login/impl/WebResCacheManager:loadFromCache	(Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   40: areturn
    //   41: astore_1
    //   42: new 170	java/lang/RuntimeException
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 173	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   50: athrow
    //   51: aload_0
    //   52: getfield 76	com/alibaba/sdk/android/login/impl/WebResCacheManager:webResCacheSp	Landroid/content/SharedPreferences;
    //   55: aload 7
    //   57: aconst_null
    //   58: invokeinterface 82 3 0
    //   63: astore 4
    //   65: lconst_0
    //   66: lstore 13
    //   68: lload 13
    //   70: lstore 11
    //   72: aload 4
    //   74: ifnull +19 -> 93
    //   77: new 90	org/json/JSONObject
    //   80: dup
    //   81: aload 4
    //   83: invokespecial 93	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   86: ldc 13
    //   88: invokevirtual 177	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   91: lstore 11
    //   93: invokestatic 183	java/lang/System:currentTimeMillis	()J
    //   96: lload 11
    //   98: lsub
    //   99: getstatic 189	com/alibaba/sdk/android/login/impl/LoginContext:cacheExpireTime	J
    //   102: lcmp
    //   103: ifge +29 -> 132
    //   106: aload_0
    //   107: aload 7
    //   109: invokespecial 168	com/alibaba/sdk/android/login/impl/WebResCacheManager:loadFromCache	(Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
    //   112: areturn
    //   113: astore 4
    //   115: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   118: aconst_null
    //   119: aload 4
    //   121: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   124: pop
    //   125: lload 13
    //   127: lstore 11
    //   129: goto -36 -> 93
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 195	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   137: invokevirtual 198	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   140: invokespecial 200	com/alibaba/sdk/android/login/impl/WebResCacheManager:isCahceable	(Ljava/lang/String;)Z
    //   143: ifne +5 -> 148
    //   146: aconst_null
    //   147: areturn
    //   148: new 202	java/net/URL
    //   151: dup
    //   152: aload_1
    //   153: invokespecial 203	java/net/URL:<init>	(Ljava/lang/String;)V
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 207	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   161: checkcast 209	java/net/HttpURLConnection
    //   164: astore_1
    //   165: aload_1
    //   166: sipush 3000
    //   169: invokevirtual 213	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   172: aload_1
    //   173: invokevirtual 217	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   176: astore 5
    //   178: aload 5
    //   180: astore 6
    //   182: aload_1
    //   183: invokevirtual 220	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +356 -> 544
    //   191: aload 5
    //   193: astore 6
    //   195: aload_1
    //   196: ldc -34
    //   198: invokevirtual 226	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   201: astore_1
    //   202: aload 5
    //   204: astore 6
    //   206: aload_1
    //   207: arraylength
    //   208: iconst_1
    //   209: if_icmpne +156 -> 365
    //   212: aload_1
    //   213: iconst_0
    //   214: aaload
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_1
    //   219: aload 5
    //   221: astore 6
    //   223: new 90	org/json/JSONObject
    //   226: dup
    //   227: invokespecial 227	org/json/JSONObject:<init>	()V
    //   230: astore 8
    //   232: aload 5
    //   234: astore 6
    //   236: aload 8
    //   238: ldc 16
    //   240: aload 4
    //   242: invokevirtual 231	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 5
    //   248: astore 6
    //   250: aload 8
    //   252: ldc 8
    //   254: aload_1
    //   255: invokevirtual 231	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 5
    //   261: astore 6
    //   263: aload 8
    //   265: ldc 13
    //   267: lload_2
    //   268: invokevirtual 234	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   271: pop
    //   272: aload 5
    //   274: astore 6
    //   276: aload_0
    //   277: getfield 76	com/alibaba/sdk/android/login/impl/WebResCacheManager:webResCacheSp	Landroid/content/SharedPreferences;
    //   280: invokeinterface 238 1 0
    //   285: astore 9
    //   287: aload 5
    //   289: astore 6
    //   291: aload 9
    //   293: aload 7
    //   295: aload 8
    //   297: invokevirtual 241	org/json/JSONObject:toString	()Ljava/lang/String;
    //   300: invokeinterface 247 3 0
    //   305: pop
    //   306: aload 5
    //   308: astore 6
    //   310: aload 9
    //   312: invokeinterface 251 1 0
    //   317: pop
    //   318: aload 5
    //   320: astore 6
    //   322: aload 5
    //   324: invokestatic 105	com/alibaba/sdk/android/util/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   327: astore 8
    //   329: aload 8
    //   331: ifnonnull +131 -> 462
    //   334: aload 5
    //   336: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   339: aconst_null
    //   340: areturn
    //   341: astore_1
    //   342: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   345: aconst_null
    //   346: aload_1
    //   347: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   350: pop
    //   351: aconst_null
    //   352: areturn
    //   353: astore_1
    //   354: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   357: aconst_null
    //   358: aload_1
    //   359: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   362: pop
    //   363: aconst_null
    //   364: areturn
    //   365: aload 5
    //   367: astore 6
    //   369: aload_1
    //   370: arraylength
    //   371: iconst_2
    //   372: if_icmpne +164 -> 536
    //   375: aload_1
    //   376: iconst_0
    //   377: aaload
    //   378: astore 4
    //   380: aload_1
    //   381: iconst_1
    //   382: aaload
    //   383: astore_1
    //   384: aload 5
    //   386: astore 6
    //   388: aload_1
    //   389: ldc -3
    //   391: invokevirtual 257	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   394: istore 10
    //   396: iload 10
    //   398: iconst_m1
    //   399: if_icmpeq +132 -> 531
    //   402: aload 5
    //   404: astore 6
    //   406: aload_1
    //   407: ldc -3
    //   409: invokevirtual 261	java/lang/String:length	()I
    //   412: iload 10
    //   414: iadd
    //   415: invokevirtual 265	java/lang/String:substring	(I)Ljava/lang/String;
    //   418: astore_1
    //   419: goto -200 -> 219
    //   422: astore 8
    //   424: aload 5
    //   426: astore 6
    //   428: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   431: aconst_null
    //   432: aload 8
    //   434: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   437: pop
    //   438: goto -120 -> 318
    //   441: astore_1
    //   442: aload 5
    //   444: astore 6
    //   446: getstatic 31	com/alibaba/sdk/android/login/impl/WebResCacheManager:TAG	Ljava/lang/String;
    //   449: aconst_null
    //   450: aload_1
    //   451: invokestatic 117	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   454: pop
    //   455: aload 5
    //   457: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   460: aconst_null
    //   461: areturn
    //   462: aload 5
    //   464: astore 6
    //   466: aload 7
    //   468: aload_0
    //   469: getfield 68	com/alibaba/sdk/android/login/impl/WebResCacheManager:context	Landroid/content/Context;
    //   472: aload 8
    //   474: invokestatic 271	com/alibaba/sdk/android/login/utils/FileUtils:write2File	(Ljava/lang/String;Landroid/content/Context;[B)Z
    //   477: pop
    //   478: aload 5
    //   480: astore 6
    //   482: new 95	android/webkit/WebResourceResponse
    //   485: dup
    //   486: aload 4
    //   488: aload_1
    //   489: new 101	java/io/ByteArrayInputStream
    //   492: dup
    //   493: aload 8
    //   495: invokespecial 108	java/io/ByteArrayInputStream:<init>	([B)V
    //   498: invokespecial 111	android/webkit/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   501: astore_1
    //   502: aload 5
    //   504: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   507: aload_1
    //   508: areturn
    //   509: astore_1
    //   510: aconst_null
    //   511: astore 6
    //   513: aload 6
    //   515: invokestatic 88	com/alibaba/sdk/android/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   518: aload_1
    //   519: athrow
    //   520: astore_1
    //   521: goto -8 -> 513
    //   524: astore_1
    //   525: aconst_null
    //   526: astore 5
    //   528: goto -86 -> 442
    //   531: aconst_null
    //   532: astore_1
    //   533: goto -314 -> 219
    //   536: aconst_null
    //   537: astore_1
    //   538: aconst_null
    //   539: astore 4
    //   541: goto -322 -> 219
    //   544: aconst_null
    //   545: astore_1
    //   546: aconst_null
    //   547: astore 4
    //   549: goto -231 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	WebResCacheManager
    //   0	552	1	paramString	String
    //   0	552	2	paramLong	long
    //   63	19	4	str1	String
    //   113	7	4	localJSONException1	org.json.JSONException
    //   215	333	4	localObject1	Object
    //   176	351	5	localInputStream1	java.io.InputStream
    //   180	334	6	localInputStream2	java.io.InputStream
    //   9	458	7	str2	String
    //   230	100	8	localObject2	Object
    //   422	72	8	localJSONException2	org.json.JSONException
    //   285	26	9	localEditor	android.content.SharedPreferences.Editor
    //   394	21	10	i	int
    //   70	58	11	l1	long
    //   66	60	13	l2	long
    // Exception table:
    //   from	to	target	type
    //   0	11	41	java/io/UnsupportedEncodingException
    //   77	93	113	org/json/JSONException
    //   148	157	341	java/net/MalformedURLException
    //   157	165	353	java/io/IOException
    //   223	232	422	org/json/JSONException
    //   236	246	422	org/json/JSONException
    //   250	259	422	org/json/JSONException
    //   263	272	422	org/json/JSONException
    //   276	287	422	org/json/JSONException
    //   291	306	422	org/json/JSONException
    //   310	318	422	org/json/JSONException
    //   182	187	441	java/io/IOException
    //   195	202	441	java/io/IOException
    //   206	212	441	java/io/IOException
    //   223	232	441	java/io/IOException
    //   236	246	441	java/io/IOException
    //   250	259	441	java/io/IOException
    //   263	272	441	java/io/IOException
    //   276	287	441	java/io/IOException
    //   291	306	441	java/io/IOException
    //   310	318	441	java/io/IOException
    //   322	329	441	java/io/IOException
    //   369	375	441	java/io/IOException
    //   388	396	441	java/io/IOException
    //   406	419	441	java/io/IOException
    //   428	438	441	java/io/IOException
    //   466	478	441	java/io/IOException
    //   482	502	441	java/io/IOException
    //   172	178	509	finally
    //   182	187	520	finally
    //   195	202	520	finally
    //   206	212	520	finally
    //   223	232	520	finally
    //   236	246	520	finally
    //   250	259	520	finally
    //   263	272	520	finally
    //   276	287	520	finally
    //   291	306	520	finally
    //   310	318	520	finally
    //   322	329	520	finally
    //   369	375	520	finally
    //   388	396	520	finally
    //   406	419	520	finally
    //   428	438	520	finally
    //   446	455	520	finally
    //   466	478	520	finally
    //   482	502	520	finally
    //   172	178	524	java/io/IOException
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\impl\WebResCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */