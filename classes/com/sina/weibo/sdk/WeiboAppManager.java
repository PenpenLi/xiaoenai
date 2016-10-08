package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class WeiboAppManager
{
  private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
  private static final String TAG = WeiboAppManager.class.getName();
  private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
  private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
  private static WeiboAppManager sInstance;
  private Context mContext;
  
  private WeiboAppManager(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static WeiboAppManager getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new WeiboAppManager(paramContext);
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private WeiboInfo queryWeiboInfoByAsset(Context paramContext)
  {
    Object localObject = new Intent("com.sina.weibo.action.sdkidentity");
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    paramContext = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((paramContext == null) || (paramContext.isEmpty()))
    {
      localObject = null;
      return (WeiboInfo)localObject;
    }
    Iterator localIterator = paramContext.iterator();
    paramContext = null;
    for (;;)
    {
      localObject = paramContext;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (ResolveInfo)localIterator.next();
      if ((((ResolveInfo)localObject).serviceInfo != null) && (((ResolveInfo)localObject).serviceInfo.applicationInfo != null) && (!TextUtils.isEmpty(((ResolveInfo)localObject).serviceInfo.applicationInfo.packageName)))
      {
        localObject = parseWeiboInfoByAsset(((ResolveInfo)localObject).serviceInfo.applicationInfo.packageName);
        if (localObject != null) {
          if (paramContext == null) {
            paramContext = (Context)localObject;
          } else if (paramContext.getSupportApi() < ((WeiboInfo)localObject).getSupportApi()) {
            paramContext = (Context)localObject;
          }
        }
      }
    }
  }
  
  /* Error */
  private WeiboInfo queryWeiboInfoByProvider(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: aload_2
    //   6: getstatic 41	com/sina/weibo/sdk/WeiboAppManager:WEIBO_NAME_URI	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 147	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +17 -> 35
    //   21: aload_3
    //   22: ifnull +9 -> 31
    //   25: aload_3
    //   26: invokeinterface 152 1 0
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: ldc -102
    //   40: invokeinterface 158 2 0
    //   45: istore 6
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: ldc -96
    //   52: invokeinterface 158 2 0
    //   57: istore 7
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: invokeinterface 163 1 0
    //   67: ifeq +159 -> 226
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: iload 6
    //   75: invokeinterface 167 2 0
    //   80: astore 4
    //   82: aload_3
    //   83: astore_2
    //   84: aload 4
    //   86: invokestatic 172	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   89: istore 6
    //   91: aload_3
    //   92: astore_2
    //   93: aload_3
    //   94: iload 7
    //   96: invokeinterface 167 2 0
    //   101: astore 5
    //   103: aload_3
    //   104: astore_2
    //   105: aload 5
    //   107: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +116 -> 226
    //   113: aload_3
    //   114: astore_2
    //   115: aload_1
    //   116: aload 5
    //   118: invokestatic 178	com/sina/weibo/sdk/ApiUtils:validateWeiboSign	(Landroid/content/Context;Ljava/lang/String;)Z
    //   121: ifeq +105 -> 226
    //   124: aload_3
    //   125: astore_2
    //   126: new 6	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo
    //   129: dup
    //   130: invokespecial 179	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo:<init>	()V
    //   133: astore 4
    //   135: aload_3
    //   136: astore_2
    //   137: aload 4
    //   139: aload 5
    //   141: invokestatic 183	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo:access$0	(Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;Ljava/lang/String;)V
    //   144: aload_3
    //   145: astore_2
    //   146: aload 4
    //   148: iload 6
    //   150: invokestatic 187	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo:access$1	(Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;I)V
    //   153: aload 4
    //   155: astore_1
    //   156: aload_3
    //   157: ifnull -124 -> 33
    //   160: aload_3
    //   161: invokeinterface 152 1 0
    //   166: aload 4
    //   168: areturn
    //   169: astore 4
    //   171: aload_3
    //   172: astore_2
    //   173: aload 4
    //   175: invokevirtual 190	java/lang/NumberFormatException:printStackTrace	()V
    //   178: iconst_m1
    //   179: istore 6
    //   181: goto -90 -> 91
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: astore_2
    //   189: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   192: aload_1
    //   193: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   196: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload_3
    //   200: ifnull +9 -> 209
    //   203: aload_3
    //   204: invokeinterface 152 1 0
    //   209: aconst_null
    //   210: areturn
    //   211: astore_1
    //   212: aconst_null
    //   213: astore_2
    //   214: aload_2
    //   215: ifnull +9 -> 224
    //   218: aload_2
    //   219: invokeinterface 152 1 0
    //   224: aload_1
    //   225: athrow
    //   226: aload_3
    //   227: ifnull -18 -> 209
    //   230: aload_3
    //   231: invokeinterface 152 1 0
    //   236: goto -27 -> 209
    //   239: astore_1
    //   240: goto -26 -> 214
    //   243: astore_1
    //   244: goto -57 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	WeiboAppManager
    //   0	247	1	paramContext	Context
    //   4	215	2	localObject1	Object
    //   16	215	3	localCursor	android.database.Cursor
    //   80	87	4	localObject2	Object
    //   169	5	4	localNumberFormatException	NumberFormatException
    //   101	39	5	str	String
    //   45	135	6	i	int
    //   57	38	7	j	int
    // Exception table:
    //   from	to	target	type
    //   84	91	169	java/lang/NumberFormatException
    //   5	17	184	java/lang/Exception
    //   5	17	211	finally
    //   37	47	239	finally
    //   49	59	239	finally
    //   61	70	239	finally
    //   72	82	239	finally
    //   84	91	239	finally
    //   93	103	239	finally
    //   105	113	239	finally
    //   115	124	239	finally
    //   126	135	239	finally
    //   137	144	239	finally
    //   146	153	239	finally
    //   173	178	239	finally
    //   189	199	239	finally
    //   37	47	243	java/lang/Exception
    //   49	59	243	java/lang/Exception
    //   61	70	243	java/lang/Exception
    //   72	82	243	java/lang/Exception
    //   84	91	243	java/lang/Exception
    //   93	103	243	java/lang/Exception
    //   105	113	243	java/lang/Exception
    //   115	124	243	java/lang/Exception
    //   126	135	243	java/lang/Exception
    //   137	144	243	java/lang/Exception
    //   146	153	243	java/lang/Exception
    //   173	178	243	java/lang/Exception
  }
  
  private WeiboInfo queryWeiboInfoInternal(Context paramContext)
  {
    int j = 1;
    WeiboInfo localWeiboInfo = queryWeiboInfoByProvider(paramContext);
    paramContext = queryWeiboInfoByAsset(paramContext);
    int i;
    if (localWeiboInfo != null)
    {
      i = 1;
      if (paramContext == null) {
        break label52;
      }
      label25:
      if ((i == 0) || (j == 0)) {
        break label60;
      }
      if (localWeiboInfo.getSupportApi() < paramContext.getSupportApi()) {
        break label58;
      }
    }
    label52:
    label58:
    label60:
    while (i != 0)
    {
      return localWeiboInfo;
      i = 0;
      break;
      j = 0;
      break label25;
      return paramContext;
    }
    if (j != 0) {
      return paramContext;
    }
    return null;
  }
  
  public WeiboInfo getWeiboInfo()
  {
    try
    {
      WeiboInfo localWeiboInfo = queryWeiboInfoInternal(this.mContext);
      return localWeiboInfo;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public WeiboInfo parseWeiboInfoByAsset(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 54	com/sina/weibo/sdk/WeiboAppManager:mContext	Landroid/content/Context;
    //   13: aload_1
    //   14: iconst_2
    //   15: invokevirtual 218	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   18: astore_2
    //   19: sipush 4096
    //   22: newarray <illegal type>
    //   24: astore 4
    //   26: aload_2
    //   27: invokevirtual 222	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   30: ldc 11
    //   32: invokevirtual 228	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: new 230	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 231	java/lang/StringBuilder:<init>	()V
    //   45: astore 5
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: aload 4
    //   52: iconst_0
    //   53: sipush 4096
    //   56: invokevirtual 237	java/io/InputStream:read	([BII)I
    //   59: istore 6
    //   61: iload 6
    //   63: iconst_m1
    //   64: if_icmpne +56 -> 120
    //   67: aload_3
    //   68: astore_2
    //   69: aload 5
    //   71: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +20 -> 97
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: getfield 54	com/sina/weibo/sdk/WeiboAppManager:mContext	Landroid/content/Context;
    //   86: aload_1
    //   87: invokestatic 178	com/sina/weibo/sdk/ApiUtils:validateWeiboSign	(Landroid/content/Context;Ljava/lang/String;)Z
    //   90: istore 7
    //   92: iload 7
    //   94: ifne +85 -> 179
    //   97: aload_3
    //   98: ifnull -91 -> 7
    //   101: aload_3
    //   102: invokevirtual 241	java/io/InputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_1
    //   108: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   111: aload_1
    //   112: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   115: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aconst_null
    //   119: areturn
    //   120: aload_3
    //   121: astore_2
    //   122: aload 5
    //   124: new 244	java/lang/String
    //   127: dup
    //   128: aload 4
    //   130: iconst_0
    //   131: iload 6
    //   133: invokespecial 247	java/lang/String:<init>	([BII)V
    //   136: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: goto -93 -> 47
    //   143: astore_1
    //   144: aload_3
    //   145: astore_2
    //   146: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   149: aload_1
    //   150: invokevirtual 252	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   153: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_3
    //   157: ifnull -150 -> 7
    //   160: aload_3
    //   161: invokevirtual 241	java/io/InputStream:close	()V
    //   164: aconst_null
    //   165: areturn
    //   166: astore_1
    //   167: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   170: aload_1
    //   171: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   174: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aconst_null
    //   178: areturn
    //   179: aload_3
    //   180: astore_2
    //   181: new 254	org/json/JSONObject
    //   184: dup
    //   185: aload 5
    //   187: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 255	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   193: ldc -102
    //   195: iconst_m1
    //   196: invokevirtual 259	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   199: istore 6
    //   201: aload_3
    //   202: astore_2
    //   203: new 6	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo
    //   206: dup
    //   207: invokespecial 179	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo:<init>	()V
    //   210: astore 4
    //   212: aload_3
    //   213: astore_2
    //   214: aload 4
    //   216: aload_1
    //   217: invokestatic 183	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo:access$0	(Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;Ljava/lang/String;)V
    //   220: aload_3
    //   221: astore_2
    //   222: aload 4
    //   224: iload 6
    //   226: invokestatic 187	com/sina/weibo/sdk/WeiboAppManager$WeiboInfo:access$1	(Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;I)V
    //   229: aload_3
    //   230: ifnull +7 -> 237
    //   233: aload_3
    //   234: invokevirtual 241	java/io/InputStream:close	()V
    //   237: aload 4
    //   239: areturn
    //   240: astore_1
    //   241: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   244: aload_1
    //   245: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   248: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: goto -14 -> 237
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_3
    //   257: aload_3
    //   258: astore_2
    //   259: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   262: aload_1
    //   263: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   266: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload_3
    //   270: ifnull -263 -> 7
    //   273: aload_3
    //   274: invokevirtual 241	java/io/InputStream:close	()V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_1
    //   280: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   283: aload_1
    //   284: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   287: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aconst_null
    //   291: areturn
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_3
    //   295: aload_3
    //   296: astore_2
    //   297: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   300: aload_1
    //   301: invokevirtual 260	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   304: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload_3
    //   308: ifnull -301 -> 7
    //   311: aload_3
    //   312: invokevirtual 241	java/io/InputStream:close	()V
    //   315: aconst_null
    //   316: areturn
    //   317: astore_1
    //   318: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   321: aload_1
    //   322: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   325: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aconst_null
    //   329: areturn
    //   330: astore_1
    //   331: aconst_null
    //   332: astore_3
    //   333: aload_3
    //   334: astore_2
    //   335: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   338: aload_1
    //   339: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_3
    //   346: ifnull -339 -> 7
    //   349: aload_3
    //   350: invokevirtual 241	java/io/InputStream:close	()V
    //   353: aconst_null
    //   354: areturn
    //   355: astore_1
    //   356: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   359: aload_1
    //   360: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   363: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aconst_null
    //   367: areturn
    //   368: astore_1
    //   369: aconst_null
    //   370: astore_2
    //   371: aload_2
    //   372: ifnull +7 -> 379
    //   375: aload_2
    //   376: invokevirtual 241	java/io/InputStream:close	()V
    //   379: aload_1
    //   380: athrow
    //   381: astore_2
    //   382: getstatic 31	com/sina/weibo/sdk/WeiboAppManager:TAG	Ljava/lang/String;
    //   385: aload_2
    //   386: invokevirtual 242	java/io/IOException:getMessage	()Ljava/lang/String;
    //   389: invokestatic 199	com/sina/weibo/sdk/utils/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: goto -13 -> 379
    //   395: astore_1
    //   396: goto -25 -> 371
    //   399: astore_1
    //   400: goto -67 -> 333
    //   403: astore_1
    //   404: goto -109 -> 295
    //   407: astore_1
    //   408: goto -151 -> 257
    //   411: astore_1
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -270 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	this	WeiboAppManager
    //   0	417	1	paramString	String
    //   18	358	2	localObject1	Object
    //   381	5	2	localIOException	java.io.IOException
    //   35	379	3	localInputStream	java.io.InputStream
    //   24	214	4	localObject2	Object
    //   45	141	5	localStringBuilder	StringBuilder
    //   59	166	6	i	int
    //   90	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   101	105	107	java/io/IOException
    //   38	47	143	android/content/pm/PackageManager$NameNotFoundException
    //   49	61	143	android/content/pm/PackageManager$NameNotFoundException
    //   69	80	143	android/content/pm/PackageManager$NameNotFoundException
    //   82	92	143	android/content/pm/PackageManager$NameNotFoundException
    //   122	140	143	android/content/pm/PackageManager$NameNotFoundException
    //   181	201	143	android/content/pm/PackageManager$NameNotFoundException
    //   203	212	143	android/content/pm/PackageManager$NameNotFoundException
    //   214	220	143	android/content/pm/PackageManager$NameNotFoundException
    //   222	229	143	android/content/pm/PackageManager$NameNotFoundException
    //   160	164	166	java/io/IOException
    //   233	237	240	java/io/IOException
    //   9	36	254	java/io/IOException
    //   273	277	279	java/io/IOException
    //   9	36	292	org/json/JSONException
    //   311	315	317	java/io/IOException
    //   9	36	330	java/lang/Exception
    //   349	353	355	java/io/IOException
    //   9	36	368	finally
    //   375	379	381	java/io/IOException
    //   38	47	395	finally
    //   49	61	395	finally
    //   69	80	395	finally
    //   82	92	395	finally
    //   122	140	395	finally
    //   146	156	395	finally
    //   181	201	395	finally
    //   203	212	395	finally
    //   214	220	395	finally
    //   222	229	395	finally
    //   259	269	395	finally
    //   297	307	395	finally
    //   335	345	395	finally
    //   38	47	399	java/lang/Exception
    //   49	61	399	java/lang/Exception
    //   69	80	399	java/lang/Exception
    //   82	92	399	java/lang/Exception
    //   122	140	399	java/lang/Exception
    //   181	201	399	java/lang/Exception
    //   203	212	399	java/lang/Exception
    //   214	220	399	java/lang/Exception
    //   222	229	399	java/lang/Exception
    //   38	47	403	org/json/JSONException
    //   49	61	403	org/json/JSONException
    //   69	80	403	org/json/JSONException
    //   82	92	403	org/json/JSONException
    //   122	140	403	org/json/JSONException
    //   181	201	403	org/json/JSONException
    //   203	212	403	org/json/JSONException
    //   214	220	403	org/json/JSONException
    //   222	229	403	org/json/JSONException
    //   38	47	407	java/io/IOException
    //   49	61	407	java/io/IOException
    //   69	80	407	java/io/IOException
    //   82	92	407	java/io/IOException
    //   122	140	407	java/io/IOException
    //   181	201	407	java/io/IOException
    //   203	212	407	java/io/IOException
    //   214	220	407	java/io/IOException
    //   222	229	407	java/io/IOException
    //   9	36	411	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static class WeiboInfo
  {
    private String mPackageName;
    private int mSupportApi;
    
    private void setPackageName(String paramString)
    {
      this.mPackageName = paramString;
    }
    
    private void setSupportApi(int paramInt)
    {
      this.mSupportApi = paramInt;
    }
    
    public String getPackageName()
    {
      return this.mPackageName;
    }
    
    public int getSupportApi()
    {
      return this.mSupportApi;
    }
    
    public boolean isLegal()
    {
      return (!TextUtils.isEmpty(this.mPackageName)) && (this.mSupportApi > 0);
    }
    
    public String toString()
    {
      return "WeiboInfo: PackageName = " + this.mPackageName + ", supportApi = " + this.mSupportApi;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\WeiboAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */