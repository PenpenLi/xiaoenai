package com.alibaba.sdk.android.initialization.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.event.EventBus;
import com.alibaba.sdk.android.initialization.InitializationHandler;
import com.alibaba.sdk.android.initialization.InitializationServiceClient;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.security.SecRuntimeException;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.system.SystemContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.HttpHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class DefaultInitializationServiceClientImpl
  implements InitializationServiceClient
{
  private static final boolean DEBUG = false;
  private static final String TAG = "DefaultInitializationServiceClientImpl";
  private AppContext appContext;
  private String cachedEncryptedSeedKey;
  private byte[] cachedSeedKey;
  private volatile boolean initDegrageEventSent = false;
  private String initSeedKey = "initialization_key";
  private AtomicInteger initTimeoutCount = new AtomicInteger();
  private String lastInitTime;
  private long lastSeedKeyGenerationTimeStampMill;
  
  public DefaultInitializationServiceClientImpl(AppContext paramAppContext)
  {
    this.appContext = paramAppContext;
    paramAppContext = CommonUtils.getCurrentProcessName();
    if (paramAppContext != null)
    {
      int i = paramAppContext.lastIndexOf(":");
      if ((i != -1) && (i < paramAppContext.length() - 1)) {
        this.initSeedKey = ("initialization_key_" + paramAppContext.substring(i + 1));
      }
    }
    if (SystemContext.pluginConfigurations.getStringValue("ENABLE_CACHE_SEED_KEY", "F").equals("T"))
    {
      this.cachedSeedKey = SystemContext.securityGuardService.getByteArrayFromDynamicDataStore("cached_seedKey_" + this.initSeedKey);
      this.cachedEncryptedSeedKey = SystemContext.securityGuardService.getValueFromDynamicDataStore("cached_encryptedSeedKey_" + this.initSeedKey);
      paramAppContext = SystemContext.securityGuardService.getValueFromDynamicDataStore("cached_seedKey_expireIn_" + this.initSeedKey);
      if (paramAppContext == null) {}
    }
    try
    {
      this.lastSeedKeyGenerationTimeStampMill = Long.parseLong(paramAppContext);
      if ((this.cachedSeedKey == null) || (this.cachedEncryptedSeedKey == null) || (this.lastSeedKeyGenerationTimeStampMill < System.currentTimeMillis())) {
        initializeCachedSeedKey();
      }
      return;
    }
    catch (Exception paramAppContext)
    {
      for (;;)
      {
        this.lastSeedKeyGenerationTimeStampMill = 0L;
      }
    }
  }
  
  public DefaultInitializationServiceClientImpl(AppContext paramAppContext, String paramString)
  {
    this.appContext = paramAppContext;
    this.initSeedKey = paramString;
  }
  
  /* Error */
  private JSONObject _request(List<InitializationHandler> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   6: ldc 109
    //   8: invokeinterface 154 2 0
    //   13: checkcast 109	com/alibaba/sdk/android/security/SecurityGuardService
    //   16: astore 6
    //   18: getstatic 85	com/alibaba/sdk/android/system/SystemContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   21: ldc 87
    //   23: ldc 89
    //   25: invokeinterface 95 3 0
    //   30: ldc 97
    //   32: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: istore 12
    //   37: iload 12
    //   39: ifeq +79 -> 118
    //   42: aload_0
    //   43: getfield 115	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:cachedSeedKey	[B
    //   46: ifnull +21 -> 67
    //   49: aload_0
    //   50: getfield 123	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:cachedEncryptedSeedKey	Ljava/lang/String;
    //   53: ifnull +14 -> 67
    //   56: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   59: aload_0
    //   60: getfield 133	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:lastSeedKeyGenerationTimeStampMill	J
    //   63: lcmp
    //   64: ifle +7 -> 71
    //   67: aload_0
    //   68: invokespecial 142	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:initializeCachedSeedKey	()V
    //   71: aload_0
    //   72: getfield 115	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:cachedSeedKey	[B
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 123	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:cachedEncryptedSeedKey	Ljava/lang/String;
    //   80: astore 4
    //   82: aload 6
    //   84: aload_0
    //   85: getfield 36	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:initSeedKey	Ljava/lang/String;
    //   88: aload_3
    //   89: invokeinterface 158 3 0
    //   94: aload_0
    //   95: aload_1
    //   96: iload_2
    //   97: aload_3
    //   98: aload 4
    //   100: iload 12
    //   102: invokespecial 162	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:sendRequest	(Ljava/util/List;I[BLjava/lang/String;Z)Lorg/json/JSONObject;
    //   105: astore 5
    //   107: aload 5
    //   109: ifnonnull +30 -> 139
    //   112: aconst_null
    //   113: astore_3
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: areturn
    //   118: aload 6
    //   120: invokeinterface 166 1 0
    //   125: astore_3
    //   126: aload 6
    //   128: aload_3
    //   129: invokeinterface 170 2 0
    //   134: astore 4
    //   136: goto -54 -> 82
    //   139: aload 5
    //   141: ldc -84
    //   143: iconst_m1
    //   144: invokevirtual 178	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   147: istore 9
    //   149: iload 9
    //   151: istore 8
    //   153: iload 9
    //   155: sipush 203
    //   158: if_icmpne +55 -> 213
    //   161: aload_0
    //   162: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   165: ldc -76
    //   167: invokeinterface 154 2 0
    //   172: checkcast 180	com/alibaba/sdk/android/security/CertificateService
    //   175: invokeinterface 183 1 0
    //   180: aload_0
    //   181: aload_1
    //   182: iload_2
    //   183: aload_3
    //   184: aload 4
    //   186: iload 12
    //   188: invokespecial 162	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:sendRequest	(Ljava/util/List;I[BLjava/lang/String;Z)Lorg/json/JSONObject;
    //   191: astore 5
    //   193: aload 5
    //   195: ifnonnull +8 -> 203
    //   198: aconst_null
    //   199: astore_3
    //   200: goto -86 -> 114
    //   203: aload 5
    //   205: ldc -84
    //   207: iconst_m1
    //   208: invokevirtual 178	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   211: istore 8
    //   213: iload 8
    //   215: iconst_1
    //   216: if_icmpne +223 -> 439
    //   219: aload 5
    //   221: ldc -71
    //   223: invokevirtual 188	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 7
    //   228: aload 7
    //   230: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +38 -> 271
    //   236: ldc 13
    //   238: new 65	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   245: ldc -60
    //   247: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 5
    //   252: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: ldc -55
    //   257: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 207	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aconst_null
    //   267: astore_3
    //   268: goto -154 -> 114
    //   271: new 174	org/json/JSONObject
    //   274: dup
    //   275: aload 6
    //   277: aload 7
    //   279: aload_0
    //   280: getfield 36	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:initSeedKey	Ljava/lang/String;
    //   283: invokeinterface 210 3 0
    //   288: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   291: astore 4
    //   293: aload 4
    //   295: ldc -41
    //   297: invokevirtual 218	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   300: lstore 10
    //   302: aload 4
    //   304: astore_3
    //   305: lload 10
    //   307: lconst_0
    //   308: lcmp
    //   309: ifeq -195 -> 114
    //   312: getstatic 224	com/alibaba/sdk/android/time/impl/TimeServiceImpl:INSTANCE	Lcom/alibaba/sdk/android/time/impl/TimeServiceImpl;
    //   315: lload 10
    //   317: invokevirtual 228	com/alibaba/sdk/android/time/impl/TimeServiceImpl:update	(J)V
    //   320: aload 4
    //   322: astore_3
    //   323: goto -209 -> 114
    //   326: astore_3
    //   327: aload_0
    //   328: iconst_m1
    //   329: aload_3
    //   330: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   333: aload_1
    //   334: invokespecial 235	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:handleResponseError	(ILjava/lang/String;Ljava/util/List;)V
    //   337: ldc 13
    //   339: new 65	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   346: ldc -19
    //   348: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_3
    //   352: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   355: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: aload_3
    //   362: invokestatic 240	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   365: aconst_null
    //   366: astore_3
    //   367: goto -253 -> 114
    //   370: astore 4
    //   372: aload 4
    //   374: invokevirtual 243	com/alibaba/sdk/android/security/SecRuntimeException:getErrorCode	()I
    //   377: sipush 703
    //   380: if_icmpeq +14 -> 394
    //   383: aload 4
    //   385: invokevirtual 243	com/alibaba/sdk/android/security/SecRuntimeException:getErrorCode	()I
    //   388: sipush 705
    //   391: if_icmpne +45 -> 436
    //   394: aload 6
    //   396: aload_0
    //   397: getfield 36	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:initSeedKey	Ljava/lang/String;
    //   400: aload_3
    //   401: invokeinterface 158 3 0
    //   406: new 174	org/json/JSONObject
    //   409: dup
    //   410: aload 6
    //   412: aload 7
    //   414: aload_0
    //   415: getfield 36	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:initSeedKey	Ljava/lang/String;
    //   418: invokeinterface 210 3 0
    //   423: invokespecial 213	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   426: astore 4
    //   428: goto -135 -> 293
    //   431: astore_1
    //   432: aload_0
    //   433: monitorexit
    //   434: aload_1
    //   435: athrow
    //   436: aload 4
    //   438: athrow
    //   439: iload 8
    //   441: bipush 101
    //   443: if_icmpne +7 -> 450
    //   446: aload_0
    //   447: invokespecial 246	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:updateDegradeCount	()V
    //   450: aload_0
    //   451: iload 8
    //   453: aload 5
    //   455: ldc -8
    //   457: invokevirtual 188	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   460: aload_1
    //   461: invokespecial 235	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:handleResponseError	(ILjava/lang/String;Ljava/util/List;)V
    //   464: ldc 13
    //   466: new 65	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   473: ldc -6
    //   475: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload 8
    //   480: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 207	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aconst_null
    //   490: astore_3
    //   491: goto -377 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	DefaultInitializationServiceClientImpl
    //   0	494	1	paramList	List<InitializationHandler>
    //   0	494	2	paramInt	int
    //   75	248	3	localObject1	Object
    //   326	36	3	localException	Exception
    //   366	125	3	arrayOfByte	byte[]
    //   80	241	4	localObject2	Object
    //   370	14	4	localSecRuntimeException	SecRuntimeException
    //   426	11	4	localJSONObject1	JSONObject
    //   105	349	5	localJSONObject2	JSONObject
    //   16	395	6	localSecurityGuardService	SecurityGuardService
    //   226	187	7	str	String
    //   151	328	8	i	int
    //   147	12	9	j	int
    //   300	16	10	l	long
    //   35	152	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	37	326	java/lang/Exception
    //   42	67	326	java/lang/Exception
    //   67	71	326	java/lang/Exception
    //   71	82	326	java/lang/Exception
    //   82	107	326	java/lang/Exception
    //   118	136	326	java/lang/Exception
    //   139	149	326	java/lang/Exception
    //   161	193	326	java/lang/Exception
    //   203	213	326	java/lang/Exception
    //   219	266	326	java/lang/Exception
    //   271	293	326	java/lang/Exception
    //   293	302	326	java/lang/Exception
    //   312	320	326	java/lang/Exception
    //   372	394	326	java/lang/Exception
    //   394	428	326	java/lang/Exception
    //   436	439	326	java/lang/Exception
    //   446	450	326	java/lang/Exception
    //   450	489	326	java/lang/Exception
    //   271	293	370	com/alibaba/sdk/android/security/SecRuntimeException
    //   2	37	431	finally
    //   42	67	431	finally
    //   67	71	431	finally
    //   71	82	431	finally
    //   82	107	431	finally
    //   118	136	431	finally
    //   139	149	431	finally
    //   161	193	431	finally
    //   203	213	431	finally
    //   219	266	431	finally
    //   271	293	431	finally
    //   293	302	431	finally
    //   312	320	431	finally
    //   327	365	431	finally
    //   372	394	431	finally
    //   394	428	431	finally
    //   436	439	431	finally
    //   446	450	431	finally
    //   450	489	431	finally
  }
  
  /* Error */
  private JSONObject getSysInfo(int paramInt)
  {
    // Byte code:
    //   0: new 174	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 260	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   13: invokeinterface 264 1 0
    //   18: astore 5
    //   20: aload 4
    //   22: ldc_w 266
    //   25: ldc_w 268
    //   28: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload 4
    //   34: ldc_w 274
    //   37: iload_1
    //   38: invokestatic 277	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   41: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 4
    //   47: ldc_w 279
    //   50: invokestatic 285	com/alibaba/sdk/android/AlibabaSDK:getVersion	()Lcom/alibaba/sdk/android/Version;
    //   53: invokevirtual 288	com/alibaba/sdk/android/Version:toString	()Ljava/lang/String;
    //   56: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   59: pop
    //   60: aload_0
    //   61: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   64: ldc_w 290
    //   67: invokeinterface 154 2 0
    //   72: checkcast 290	com/alibaba/sdk/android/repository/PluginRepository
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +99 -> 176
    //   80: new 292	org/json/JSONArray
    //   83: dup
    //   84: invokespecial 293	org/json/JSONArray:<init>	()V
    //   87: astore_2
    //   88: aload_3
    //   89: invokeinterface 297 1 0
    //   94: astore_3
    //   95: aload_3
    //   96: arraylength
    //   97: istore 8
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: iload 8
    //   104: if_icmpge +62 -> 166
    //   107: aload_3
    //   108: iload_1
    //   109: aaload
    //   110: astore 6
    //   112: new 174	org/json/JSONObject
    //   115: dup
    //   116: invokespecial 260	org/json/JSONObject:<init>	()V
    //   119: astore 7
    //   121: aload 7
    //   123: ldc_w 299
    //   126: aload 6
    //   128: getfield 304	com/alibaba/sdk/android/plugin/PluginInfo:name	Ljava/lang/String;
    //   131: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   134: pop
    //   135: aload 7
    //   137: ldc_w 306
    //   140: aload 6
    //   142: getfield 308	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   145: invokestatic 311	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   148: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_2
    //   153: aload 7
    //   155: invokevirtual 314	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   158: pop
    //   159: iload_1
    //   160: iconst_1
    //   161: iadd
    //   162: istore_1
    //   163: goto -62 -> 101
    //   166: aload 4
    //   168: ldc_w 316
    //   171: aload_2
    //   172: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   175: pop
    //   176: aload 4
    //   178: ldc_w 318
    //   181: aload_0
    //   182: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   185: invokeinterface 321 1 0
    //   190: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 4
    //   196: ldc_w 323
    //   199: ldc_w 325
    //   202: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload 4
    //   208: ldc_w 327
    //   211: getstatic 333	android/os/Build$VERSION:SDK_INT	I
    //   214: invokestatic 277	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   217: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload 4
    //   223: ldc_w 335
    //   226: getstatic 340	android/os/Build:MODEL	Ljava/lang/String;
    //   229: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload 4
    //   235: ldc_w 342
    //   238: aload 5
    //   240: invokevirtual 347	android/content/Context:getPackageName	()Ljava/lang/String;
    //   243: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload 4
    //   249: ldc_w 349
    //   252: getstatic 352	android/os/Build:BRAND	Ljava/lang/String;
    //   255: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 4
    //   261: ldc_w 354
    //   264: getstatic 357	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   267: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   270: pop
    //   271: ldc_w 359
    //   274: astore_3
    //   275: aload 5
    //   277: invokestatic 365	com/alibaba/sdk/android/util/NetworkUtils:getConnectType	(Landroid/content/Context;)Lcom/alibaba/sdk/android/network/ConnectType;
    //   280: astore 6
    //   282: aload 6
    //   284: getstatic 371	com/alibaba/sdk/android/network/ConnectType:CONNECT_TYPE_WIFI	Lcom/alibaba/sdk/android/network/ConnectType;
    //   287: if_acmpne +241 -> 528
    //   290: ldc_w 373
    //   293: astore_2
    //   294: aload 4
    //   296: ldc_w 375
    //   299: aload_2
    //   300: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload 5
    //   306: ldc_w 377
    //   309: invokevirtual 381	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   312: checkcast 383	android/telephony/TelephonyManager
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull +62 -> 379
    //   320: aload 4
    //   322: ldc_w 385
    //   325: aload_2
    //   326: invokevirtual 388	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   329: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   332: pop
    //   333: getstatic 85	com/alibaba/sdk/android/system/SystemContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   336: ldc_w 390
    //   339: iconst_0
    //   340: invokeinterface 394 3 0
    //   345: ifne +34 -> 379
    //   348: aload_2
    //   349: invokevirtual 398	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   352: astore_2
    //   353: aload_2
    //   354: instanceof 400
    //   357: ifeq +235 -> 592
    //   360: aload 4
    //   362: ldc_w 402
    //   365: aload_2
    //   366: checkcast 400	android/telephony/gsm/GsmCellLocation
    //   369: invokevirtual 405	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   372: invokestatic 277	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   375: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   378: pop
    //   379: aload 4
    //   381: ldc_w 407
    //   384: aload 5
    //   386: invokestatic 411	com/alibaba/sdk/android/util/NetworkUtils:getLocalMacAddress	(Landroid/content/Context;)Ljava/lang/String;
    //   389: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   392: pop
    //   393: aload 4
    //   395: ldc_w 413
    //   398: aload_0
    //   399: getfield 415	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:lastInitTime	Ljava/lang/String;
    //   402: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   405: pop
    //   406: aload 4
    //   408: ldc_w 417
    //   411: aload_0
    //   412: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   415: invokeinterface 420 1 0
    //   420: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   423: pop
    //   424: ldc_w 422
    //   427: invokestatic 425	com/alibaba/sdk/android/AlibabaSDK:getGlobalProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   430: astore_2
    //   431: aload_2
    //   432: astore_3
    //   433: aload_2
    //   434: ifnonnull +21 -> 455
    //   437: aload 5
    //   439: invokevirtual 429	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   442: aload 5
    //   444: invokevirtual 347	android/content/Context:getPackageName	()Ljava/lang/String;
    //   447: iconst_0
    //   448: invokevirtual 435	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   451: getfield 440	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   454: astore_3
    //   455: aload 4
    //   457: ldc_w 422
    //   460: aload_3
    //   461: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   464: pop
    //   465: aload_0
    //   466: getfield 45	com/alibaba/sdk/android/initialization/impl/DefaultInitializationServiceClientImpl:appContext	Lcom/alibaba/sdk/android/app/AppContext;
    //   469: ldc 109
    //   471: invokeinterface 154 2 0
    //   476: checkcast 109	com/alibaba/sdk/android/security/SecurityGuardService
    //   479: astore_2
    //   480: aload 4
    //   482: ldc_w 442
    //   485: aload_2
    //   486: invokeinterface 445 1 0
    //   491: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   494: pop
    //   495: aload 4
    //   497: ldc_w 447
    //   500: aload_2
    //   501: invokeinterface 450 1 0
    //   506: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   509: pop
    //   510: aload 4
    //   512: ldc_w 452
    //   515: aload_2
    //   516: invokeinterface 450 1 0
    //   521: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   524: pop
    //   525: aload 4
    //   527: areturn
    //   528: aload_3
    //   529: astore_2
    //   530: aload 6
    //   532: getstatic 455	com/alibaba/sdk/android/network/ConnectType:CONNECT_TYPE_MOBILE	Lcom/alibaba/sdk/android/network/ConnectType;
    //   535: if_acmpne -241 -> 294
    //   538: aload 5
    //   540: invokestatic 459	com/alibaba/sdk/android/util/NetworkUtils:getMobileNetworkType	(Landroid/content/Context;)Lcom/alibaba/sdk/android/network/MobileNetworkType;
    //   543: astore 6
    //   545: aload 6
    //   547: getstatic 465	com/alibaba/sdk/android/network/MobileNetworkType:MOBILE_NETWORK_TYPE_2G	Lcom/alibaba/sdk/android/network/MobileNetworkType;
    //   550: if_acmpne +10 -> 560
    //   553: ldc_w 467
    //   556: astore_2
    //   557: goto -263 -> 294
    //   560: aload 6
    //   562: getstatic 470	com/alibaba/sdk/android/network/MobileNetworkType:MOBILE_NETWORK_TYPE_3G	Lcom/alibaba/sdk/android/network/MobileNetworkType;
    //   565: if_acmpne +10 -> 575
    //   568: ldc_w 472
    //   571: astore_2
    //   572: goto -278 -> 294
    //   575: aload_3
    //   576: astore_2
    //   577: aload 6
    //   579: getstatic 475	com/alibaba/sdk/android/network/MobileNetworkType:MOBILE_NETWORK_TYPE_4G	Lcom/alibaba/sdk/android/network/MobileNetworkType;
    //   582: if_acmpne -288 -> 294
    //   585: ldc_w 477
    //   588: astore_2
    //   589: goto -295 -> 294
    //   592: aload_2
    //   593: instanceof 479
    //   596: ifeq -217 -> 379
    //   599: aload 4
    //   601: ldc_w 402
    //   604: aload_2
    //   605: checkcast 479	android/telephony/cdma/CdmaCellLocation
    //   608: invokevirtual 482	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   611: invokestatic 277	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   614: invokevirtual 272	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   617: pop
    //   618: goto -239 -> 379
    //   621: astore_2
    //   622: goto -243 -> 379
    //   625: astore_2
    //   626: ldc 13
    //   628: new 65	java/lang/StringBuilder
    //   631: dup
    //   632: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   635: ldc_w 484
    //   638: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_2
    //   642: invokevirtual 485	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   645: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: aload_2
    //   652: invokestatic 240	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   655: aconst_null
    //   656: areturn
    //   657: astore_3
    //   658: aload_2
    //   659: astore_3
    //   660: goto -205 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	DefaultInitializationServiceClientImpl
    //   0	663	1	paramInt	int
    //   87	518	2	localObject1	Object
    //   621	1	2	localException1	Exception
    //   625	34	2	localThrowable	Throwable
    //   75	501	3	localObject2	Object
    //   657	1	3	localException2	Exception
    //   659	1	3	localObject3	Object
    //   7	593	4	localJSONObject1	JSONObject
    //   18	521	5	localContext	android.content.Context
    //   110	468	6	localObject4	Object
    //   119	35	7	localJSONObject2	JSONObject
    //   97	8	8	i	int
    // Exception table:
    //   from	to	target	type
    //   304	316	621	java/lang/Exception
    //   320	379	621	java/lang/Exception
    //   592	618	621	java/lang/Exception
    //   0	76	625	java/lang/Throwable
    //   80	99	625	java/lang/Throwable
    //   112	159	625	java/lang/Throwable
    //   166	176	625	java/lang/Throwable
    //   176	271	625	java/lang/Throwable
    //   275	290	625	java/lang/Throwable
    //   294	304	625	java/lang/Throwable
    //   304	316	625	java/lang/Throwable
    //   320	379	625	java/lang/Throwable
    //   379	431	625	java/lang/Throwable
    //   437	455	625	java/lang/Throwable
    //   455	525	625	java/lang/Throwable
    //   530	553	625	java/lang/Throwable
    //   560	568	625	java/lang/Throwable
    //   577	585	625	java/lang/Throwable
    //   592	618	625	java/lang/Throwable
    //   437	455	657	java/lang/Exception
  }
  
  private void handleResponseError(int paramInt, String paramString, List<InitializationHandler> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      InitializationHandler localInitializationHandler = (InitializationHandler)paramList.next();
      try
      {
        localInitializationHandler.handleResponseError(paramInt, paramString);
      }
      catch (Exception localException) {}
    }
  }
  
  private void initializeCachedSeedKey()
  {
    this.cachedSeedKey = SystemContext.securityGuardService.genSeedKey();
    this.cachedEncryptedSeedKey = SystemContext.securityGuardService.rsaEncrypt(this.cachedSeedKey);
    String str = SystemContext.pluginConfigurations.getStringValue("CACHE_SEED_KEY_EXPIREIN");
    l2 = 86400L;
    l1 = l2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      int i = Integer.parseInt(str);
      l1 = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    this.lastSeedKeyGenerationTimeStampMill = (l1 * 1000L + System.currentTimeMillis());
    SystemContext.securityGuardService.putValueInDynamicDataStore("cached_encryptedSeedKey_" + this.initSeedKey, this.cachedEncryptedSeedKey);
    SystemContext.securityGuardService.putValueInDynamicDataStore("cached_seedKey_" + this.initSeedKey, this.cachedSeedKey);
    SystemContext.securityGuardService.putValueInDynamicDataStore("cached_seedKey_expireIn_" + this.initSeedKey, String.valueOf(this.lastSeedKeyGenerationTimeStampMill));
  }
  
  private JSONObject sendRequest(List<InitializationHandler> paramList, int paramInt, byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("appKey", AlibabaSDK.getGlobalProperty("com.alibaba.app.appkey"));
      ((JSONObject)localObject1).put("clientTimestamp", System.currentTimeMillis());
      localObject2 = getSysInfo(paramInt);
      if (localObject2 == null) {
        return null;
      }
      ((JSONObject)localObject1).put("sys", localObject2);
      ((JSONObject)localObject1).put("cacheSeedKey", String.valueOf(paramBoolean));
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (InitializationHandler)((Iterator)localObject2).next();
        Object localObject4 = ((InitializationHandler)localObject3).createRequestParameters();
        if (localObject4 != null) {
          ((JSONObject)localObject1).put(((InitializationHandler)localObject3).getRequestParameterKey(), localObject4);
        }
      }
      localObject2 = ((JSONObject)localObject1).toString();
    }
    catch (Throwable paramArrayOfByte)
    {
      if (CommonUtils.isConnectionTimeout(paramArrayOfByte)) {
        updateDegradeCount();
      }
      AliSDKLogger.e("DefaultInitializationServiceClientImpl", paramArrayOfByte);
      handleResponseError(-1, paramArrayOfByte.getMessage(), paramList);
      this.lastInitTime = String.valueOf(System.currentTimeMillis());
      return null;
    }
    localObject3 = (SecurityGuardService)this.appContext.getService(SecurityGuardService.class);
    localObject1 = new HashMap();
    ((Map)localObject1).put("seedKey", paramString);
    try
    {
      ((Map)localObject1).put("cacheSeedKey", String.valueOf(paramBoolean));
      ((Map)localObject1).put("data", ((SecurityGuardService)localObject3).symEncrypt((String)localObject2, this.initSeedKey));
      try
      {
        paramString = ((SecurityGuardService)localObject3).sign((String)localObject2, this.initSeedKey);
        paramArrayOfByte = paramString;
      }
      catch (SecRuntimeException paramString)
      {
        while (paramString.getErrorCode() == 606)
        {
          ((SecurityGuardService)localObject3).saveSecret(this.initSeedKey, paramArrayOfByte);
          paramArrayOfByte = ((SecurityGuardService)localObject3).sign((String)localObject2, this.initSeedKey);
        }
        throw paramString;
      }
      if (paramArrayOfByte != null) {
        ((Map)localObject1).put("sign", paramArrayOfByte);
      }
      this.lastInitTime = String.valueOf(System.currentTimeMillis());
      return new JSONObject(HttpHelper.post((Map)localObject1, SystemContext.initUrl));
    }
    catch (SecRuntimeException paramString)
    {
      while (paramString.getErrorCode() == 703)
      {
        ((SecurityGuardService)localObject3).saveSecret(this.initSeedKey, paramArrayOfByte);
        ((Map)localObject1).put("data", ((SecurityGuardService)localObject3).symEncrypt((String)localObject2, this.initSeedKey));
      }
      throw paramString;
    }
  }
  
  private void updateDegradeCount()
  {
    if (!CommonUtils.isNetworkAvailable()) {}
    int i;
    do
    {
      return;
      i = this.initTimeoutCount.incrementAndGet();
    } while ((this.initDegrageEventSent) || (!"T".equals(SystemContext.pluginConfigurations.getStringValue("ENABLE_CLIENT_AUTO_DEGRAGE", "F"))) || (i < SystemContext.pluginConfigurations.getIntValue("CLIENT_AUTO_DEGRAGE_INIT_FAILED_TIMES", 3)));
    EventBus.getDefault().sendEvent("init-degrade");
  }
  
  public <T> T request(InitializationHandler<T> paramInitializationHandler, Class<T> paramClass)
  {
    int i = paramInitializationHandler.getRequestServiceType();
    if (i == 0) {}
    do
    {
      return null;
      paramClass = _request(Collections.singletonList(paramInitializationHandler), i);
    } while (paramClass == null);
    try
    {
      paramClass = paramInitializationHandler.handleResponseValue(paramClass.optJSONObject(paramInitializationHandler.getResponseValueKey()));
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AliSDKLogger.e("DefaultInitializationServiceClientImpl", "Fail to invoke the handler " + paramInitializationHandler + ", the error message is " + paramClass.getMessage(), paramClass);
    }
    return null;
  }
  
  public void request()
  {
    if (this.appContext == null) {}
    InitializationHandler[] arrayOfInitializationHandler;
    do
    {
      return;
      arrayOfInitializationHandler = (InitializationHandler[])this.appContext.getServices(InitializationHandler.class);
    } while (arrayOfInitializationHandler.length == 0);
    request(arrayOfInitializationHandler);
  }
  
  public void request(InitializationHandler... paramVarArgs)
  {
    int i = 0;
    Object localObject = new ArrayList(paramVarArgs.length);
    int i1 = paramVarArgs.length;
    int k = 0;
    int m = 0;
    InitializationHandler localInitializationHandler;
    if (k < i1)
    {
      localInitializationHandler = paramVarArgs[k];
      int i3 = localInitializationHandler.getRequestRequirement();
      int n;
      int j;
      if (i3 == 2)
      {
        n = m;
        j = i;
      }
      for (;;)
      {
        k += 1;
        i = j;
        m = n;
        break;
        int i2 = localInitializationHandler.getRequestServiceType();
        j = i;
        n = m;
        if (i2 != 0)
        {
          j = i;
          if (i == 0)
          {
            j = i;
            if (i3 == 1) {
              j = 1;
            }
          }
          n = m | i2;
          ((List)localObject).add(localInitializationHandler);
        }
      }
    }
    if ((((List)localObject).size() == 0) || (i == 0)) {}
    for (;;)
    {
      return;
      paramVarArgs = _request((List)localObject, m);
      if (paramVarArgs != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localInitializationHandler = (InitializationHandler)((Iterator)localObject).next();
          try
          {
            localInitializationHandler.handleResponseValue(paramVarArgs.optJSONObject(localInitializationHandler.getResponseValueKey()));
          }
          catch (Exception localException)
          {
            AliSDKLogger.e("DefaultInitializationServiceClientImpl", "Fail to execute the handler " + localInitializationHandler + ", the error message is " + localException.getMessage(), localException);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\initialization\impl\DefaultInitializationServiceClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */