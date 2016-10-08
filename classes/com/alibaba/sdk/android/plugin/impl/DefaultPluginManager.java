package com.alibaba.sdk.android.plugin.impl;

import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.plugin.PluginManager;
import com.alibaba.sdk.android.plugin.PluginState;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import com.alibaba.sdk.android.repository.PluginRepository;
import com.alibaba.sdk.android.repository.impl.SimplePluginRepository;
import com.alibaba.sdk.android.security.AccessController;
import com.alibaba.sdk.android.ut.UserTrackerService;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultPluginManager
  implements PluginManager
{
  private static final String TAG = "kernel";
  private AccessController accessController;
  private ClassLoader classLoader = SimplePluginRepository.class.getClassLoader();
  private Map<String, PluginData> pluginDataEntries = new ConcurrentHashMap();
  
  public DefaultPluginManager(PluginRepository paramPluginRepository)
  {
    paramPluginRepository = paramPluginRepository.getPluginInfos();
    int j = paramPluginRepository.length;
    int i = 0;
    while (i < j)
    {
      PluginInfo localPluginInfo = paramPluginRepository[i];
      PluginData localPluginData = new PluginData();
      localPluginData.pluginInfo = localPluginInfo;
      localPluginData.state = PluginState.LOADED;
      this.pluginDataEntries.put(localPluginInfo.name, localPluginData);
      i += 1;
    }
  }
  
  private void sendPluginHint(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramBoolean) {}
    for (String str = "sdk_plugin_start_success";; str = "sdk_plugin_start_failure")
    {
      UserTrackerService localUserTrackerService = (UserTrackerService)KernelContext.serviceRegistry.getService(UserTrackerService.class, null);
      if (localUserTrackerService != null) {
        localUserTrackerService.sendCustomHit(str, paramLong, paramString, null);
      }
      return;
    }
  }
  
  public String[] getPluginNames()
  {
    return (String[])this.pluginDataEntries.keySet().toArray(new String[this.pluginDataEntries.size()]);
  }
  
  public PluginState getPluginState(String paramString)
  {
    paramString = (PluginData)this.pluginDataEntries.get(paramString);
    if (paramString != null) {
      return paramString.state;
    }
    return PluginState.UNDEFINED;
  }
  
  /* Error */
  public void startPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 13
    //   4: new 135	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   11: ldc -118
    //   13: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_1
    //   17: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 152	com/alibaba/sdk/android/trace/AliSDKLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: getstatic 158	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   29: ifeq +7 -> 36
    //   32: aload_1
    //   33: invokestatic 163	com/taobao/tae/sdk/log/SdkCoreLog:startTimeRecord	(Ljava/lang/String;)V
    //   36: getstatic 169	com/alibaba/sdk/android/trace/TraceLoggerManager:INSTANCE	Lcom/alibaba/sdk/android/trace/TraceLoggerManager;
    //   39: new 135	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   46: aload_1
    //   47: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc -85
    //   52: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 175	com/alibaba/sdk/android/trace/TraceLoggerManager:action	(Ljava/lang/String;)Lcom/alibaba/sdk/android/trace/ActionTraceLogger;
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 30	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:pluginDataEntries	Ljava/util/Map;
    //   66: aload_1
    //   67: invokeinterface 122 2 0
    //   72: checkcast 8	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData
    //   75: astore_2
    //   76: aload_2
    //   77: ifnonnull +49 -> 126
    //   80: aload_3
    //   81: ldc -79
    //   83: ldc -77
    //   85: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   88: new 187	com/alibaba/sdk/android/plugin/PluginNotFoundException
    //   91: dup
    //   92: aload_1
    //   93: new 135	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   100: ldc -67
    //   102: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc -65
    //   111: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 193	com/alibaba/sdk/android/plugin/PluginNotFoundException:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    //   126: aload_0
    //   127: getfield 195	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:accessController	Lcom/alibaba/sdk/android/security/AccessController;
    //   130: ifnonnull +27 -> 157
    //   133: aload_0
    //   134: getstatic 82	com/alibaba/sdk/android/impl/KernelContext:serviceRegistry	Lcom/alibaba/sdk/android/registry/ServiceRegistry;
    //   137: ldc -59
    //   139: ldc -57
    //   141: ldc -55
    //   143: invokestatic 207	java/util/Collections:singletonMap	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;
    //   146: invokeinterface 90 3 0
    //   151: checkcast 197	com/alibaba/sdk/android/security/AccessController
    //   154: putfield 195	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:accessController	Lcom/alibaba/sdk/android/security/AccessController;
    //   157: aload_0
    //   158: getfield 195	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:accessController	Lcom/alibaba/sdk/android/security/AccessController;
    //   161: ifnull +49 -> 210
    //   164: aload_0
    //   165: getfield 195	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:accessController	Lcom/alibaba/sdk/android/security/AccessController;
    //   168: aload_1
    //   169: invokeinterface 211 2 0
    //   174: ifne +36 -> 210
    //   177: aload_3
    //   178: ldc -79
    //   180: new 135	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   187: ldc -43
    //   189: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc -41
    //   198: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   207: aload_0
    //   208: monitorexit
    //   209: return
    //   210: aload_2
    //   211: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   214: getstatic 218	com/alibaba/sdk/android/plugin/PluginState:SYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   217: if_acmpeq +97 -> 314
    //   220: aload_2
    //   221: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   224: getstatic 221	com/alibaba/sdk/android/plugin/PluginState:ASYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   227: if_acmpeq +87 -> 314
    //   230: aload_3
    //   231: ldc -79
    //   233: new 135	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   240: ldc -33
    //   242: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_2
    //   246: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   249: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   252: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   261: invokestatic 229	com/alibaba/sdk/android/trace/AliSDKLogger:isDebugEnabled	()Z
    //   264: ifeq -57 -> 207
    //   267: ldc 13
    //   269: new 135	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   276: ldc -25
    //   278: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc -23
    //   287: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_2
    //   291: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   294: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   297: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc -21
    //   302: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 152	com/alibaba/sdk/android/trace/AliSDKLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: goto -104 -> 207
    //   314: aload_2
    //   315: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   318: getfield 238	com/alibaba/sdk/android/plugin/PluginInfo:after	[Ljava/lang/String;
    //   321: astore 4
    //   323: aload 4
    //   325: arraylength
    //   326: istore 8
    //   328: iconst_0
    //   329: istore 7
    //   331: iload 7
    //   333: iload 8
    //   335: if_icmpge +104 -> 439
    //   338: aload 4
    //   340: iload 7
    //   342: aaload
    //   343: astore 5
    //   345: aload_0
    //   346: aload 5
    //   348: invokevirtual 240	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:getPluginState	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginState;
    //   351: astore 6
    //   353: aload 6
    //   355: getstatic 243	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   358: if_acmpeq +494 -> 852
    //   361: aload 6
    //   363: getstatic 125	com/alibaba/sdk/android/plugin/PluginState:UNDEFINED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   366: if_acmpeq +486 -> 852
    //   369: aload_3
    //   370: ldc -79
    //   372: new 135	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   379: ldc -11
    //   381: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_2
    //   385: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   388: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   391: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc -9
    //   396: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   405: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   408: dup
    //   409: aload_1
    //   410: new 135	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   417: ldc -7
    //   419: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 5
    //   424: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc -5
    //   429: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokespecial 252	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: athrow
    //   439: aload_3
    //   440: ldc -2
    //   442: aload_2
    //   443: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   446: getfield 256	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   449: invokevirtual 260	com/alibaba/sdk/android/trace/ActionTraceLogger:info	(Ljava/lang/String;Ljava/lang/Object;)Lcom/alibaba/sdk/android/trace/ActionTraceLogger;
    //   452: pop
    //   453: ldc 13
    //   455: new 135	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 262
    //   465: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_1
    //   469: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc_w 264
    //   475: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_2
    //   479: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   482: getfield 256	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   485: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 267	com/alibaba/sdk/android/trace/AliSDKLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   497: lstore 9
    //   499: aload_2
    //   500: getstatic 276	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STARTING	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   503: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   506: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   509: aload_1
    //   510: invokevirtual 285	com/alibaba/sdk/android/app/AppContextManager:createAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   513: astore 4
    //   515: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   518: aload_2
    //   519: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   522: invokevirtual 294	com/alibaba/sdk/android/plugin/PluginContextManager:createPluginConext	(Lcom/alibaba/sdk/android/plugin/PluginInfo;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   525: astore 5
    //   527: aload_2
    //   528: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   531: getfield 297	com/alibaba/sdk/android/plugin/PluginInfo:lifecycleAdapterClassName	Ljava/lang/String;
    //   534: ifnonnull +46 -> 580
    //   537: aload_2
    //   538: getstatic 243	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   541: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   544: aload_3
    //   545: invokevirtual 300	com/alibaba/sdk/android/trace/ActionTraceLogger:success	()V
    //   548: getstatic 158	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   551: ifeq -344 -> 207
    //   554: aload_1
    //   555: ldc 13
    //   557: aload_1
    //   558: invokestatic 304	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   561: iconst_1
    //   562: anewarray 108	java/lang/String
    //   565: dup
    //   566: iconst_0
    //   567: ldc_w 305
    //   570: aastore
    //   571: invokestatic 309	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   574: invokestatic 310	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: goto -370 -> 207
    //   580: aload_2
    //   581: getfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   584: instanceof 316
    //   587: ifeq +19 -> 606
    //   590: aload_2
    //   591: getfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   594: checkcast 316	com/alibaba/sdk/android/plugin/PluginLifecycleAdapter
    //   597: aload 4
    //   599: aload 5
    //   601: invokeinterface 320 3 0
    //   606: aload_2
    //   607: getstatic 243	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   610: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   613: aload_0
    //   614: iconst_1
    //   615: aload_1
    //   616: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   619: lload 9
    //   621: lsub
    //   622: invokespecial 322	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:sendPluginHint	(ZLjava/lang/String;J)V
    //   625: aload_3
    //   626: ldc_w 323
    //   629: aload_2
    //   630: getfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   633: invokevirtual 325	com/alibaba/sdk/android/trace/ActionTraceLogger:success	(Ljava/lang/String;Ljava/lang/Object;)V
    //   636: getstatic 158	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   639: ifeq +26 -> 665
    //   642: aload_1
    //   643: ldc 13
    //   645: aload_1
    //   646: invokestatic 304	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   649: iconst_1
    //   650: anewarray 108	java/lang/String
    //   653: dup
    //   654: iconst_0
    //   655: ldc_w 305
    //   658: aastore
    //   659: invokestatic 309	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   662: invokestatic 310	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: aload_2
    //   666: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   669: getstatic 221	com/alibaba/sdk/android/plugin/PluginState:ASYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   672: if_acmpne -465 -> 207
    //   675: aload_2
    //   676: aconst_null
    //   677: putfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   680: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   683: aload_1
    //   684: invokevirtual 329	com/alibaba/sdk/android/plugin/PluginContextManager:destroyPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   687: pop
    //   688: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   691: aload_1
    //   692: invokevirtual 332	com/alibaba/sdk/android/app/AppContextManager:destroyAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   695: pop
    //   696: aload_0
    //   697: iconst_0
    //   698: aload_1
    //   699: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   702: lload 9
    //   704: lsub
    //   705: invokespecial 322	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:sendPluginHint	(ZLjava/lang/String;J)V
    //   708: goto -501 -> 207
    //   711: astore_3
    //   712: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   715: dup
    //   716: aload_1
    //   717: aload_3
    //   718: invokevirtual 335	com/alibaba/sdk/android/AlibabaSDKException:getMessage	()Ljava/lang/String;
    //   721: aload_3
    //   722: invokespecial 338	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   725: astore 4
    //   727: aload_3
    //   728: invokevirtual 342	com/alibaba/sdk/android/AlibabaSDKException:getSDKMessage	()Lcom/alibaba/sdk/android/message/Message;
    //   731: ifnull +15 -> 746
    //   734: aload 4
    //   736: aload_3
    //   737: invokevirtual 342	com/alibaba/sdk/android/AlibabaSDKException:getSDKMessage	()Lcom/alibaba/sdk/android/message/Message;
    //   740: invokestatic 348	com/alibaba/sdk/android/ResultCode:create	(Lcom/alibaba/sdk/android/message/Message;)Lcom/alibaba/sdk/android/ResultCode;
    //   743: invokevirtual 352	com/alibaba/sdk/android/plugin/PluginLifecycleException:setResultCode	(Lcom/alibaba/sdk/android/ResultCode;)V
    //   746: aload 4
    //   748: athrow
    //   749: astore_3
    //   750: aload_2
    //   751: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   754: getstatic 221	com/alibaba/sdk/android/plugin/PluginState:ASYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   757: if_acmpne +36 -> 793
    //   760: aload_2
    //   761: aconst_null
    //   762: putfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   765: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   768: aload_1
    //   769: invokevirtual 329	com/alibaba/sdk/android/plugin/PluginContextManager:destroyPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   772: pop
    //   773: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   776: aload_1
    //   777: invokevirtual 332	com/alibaba/sdk/android/app/AppContextManager:destroyAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   780: pop
    //   781: aload_0
    //   782: iconst_0
    //   783: aload_1
    //   784: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   787: lload 9
    //   789: lsub
    //   790: invokespecial 322	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:sendPluginHint	(ZLjava/lang/String;J)V
    //   793: aload_3
    //   794: athrow
    //   795: astore 4
    //   797: aload 4
    //   799: aload_1
    //   800: invokevirtual 355	com/alibaba/sdk/android/plugin/PluginLifecycleException:setPluginName	(Ljava/lang/String;)V
    //   803: aload_2
    //   804: getstatic 221	com/alibaba/sdk/android/plugin/PluginState:ASYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   807: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   810: aload_3
    //   811: ldc -79
    //   813: aload 4
    //   815: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   818: aload 4
    //   820: athrow
    //   821: astore 4
    //   823: aload_2
    //   824: getstatic 221	com/alibaba/sdk/android/plugin/PluginState:ASYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   827: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   830: aload_3
    //   831: ldc -79
    //   833: aload 4
    //   835: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   838: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   841: dup
    //   842: aload_1
    //   843: ldc_w 357
    //   846: aload 4
    //   848: invokespecial 338	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   851: athrow
    //   852: iload 7
    //   854: iconst_1
    //   855: iadd
    //   856: istore 7
    //   858: goto -527 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	861	0	this	DefaultPluginManager
    //   0	861	1	paramString	String
    //   75	749	2	localPluginData	PluginData
    //   61	565	3	localActionTraceLogger	com.alibaba.sdk.android.trace.ActionTraceLogger
    //   711	26	3	localAlibabaSDKException	com.alibaba.sdk.android.AlibabaSDKException
    //   749	82	3	localObject1	Object
    //   321	426	4	localObject2	Object
    //   795	24	4	localPluginLifecycleException	com.alibaba.sdk.android.plugin.PluginLifecycleException
    //   821	26	4	localThrowable	Throwable
    //   343	257	5	localObject3	Object
    //   351	11	6	localPluginState	PluginState
    //   329	528	7	i	int
    //   326	10	8	j	int
    //   497	291	9	l	long
    // Exception table:
    //   from	to	target	type
    //   2	36	121	finally
    //   36	76	121	finally
    //   80	121	121	finally
    //   126	157	121	finally
    //   157	207	121	finally
    //   210	311	121	finally
    //   314	328	121	finally
    //   345	439	121	finally
    //   439	577	121	finally
    //   665	708	121	finally
    //   750	793	121	finally
    //   793	795	121	finally
    //   580	606	711	com/alibaba/sdk/android/AlibabaSDKException
    //   606	665	711	com/alibaba/sdk/android/AlibabaSDKException
    //   580	606	749	finally
    //   606	665	749	finally
    //   712	746	749	finally
    //   746	749	749	finally
    //   797	821	749	finally
    //   823	852	749	finally
    //   580	606	795	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   606	665	795	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   580	606	821	java/lang/Throwable
    //   606	665	821	java/lang/Throwable
  }
  
  /* Error */
  public void stopPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 169	com/alibaba/sdk/android/trace/TraceLoggerManager:INSTANCE	Lcom/alibaba/sdk/android/trace/TraceLoggerManager;
    //   5: new 135	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 360
    //   19: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 175	com/alibaba/sdk/android/trace/TraceLoggerManager:action	(Ljava/lang/String;)Lcom/alibaba/sdk/android/trace/ActionTraceLogger;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 30	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:pluginDataEntries	Ljava/util/Map;
    //   33: aload_1
    //   34: invokeinterface 122 2 0
    //   39: checkcast 8	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull +50 -> 94
    //   47: aload_2
    //   48: ldc -79
    //   50: ldc -77
    //   52: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   55: new 187	com/alibaba/sdk/android/plugin/PluginNotFoundException
    //   58: dup
    //   59: aload_1
    //   60: new 135	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   67: ldc -67
    //   69: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 362
    //   79: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 193	com/alibaba/sdk/android/plugin/PluginNotFoundException:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: aload_3
    //   95: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   98: getstatic 218	com/alibaba/sdk/android/plugin/PluginState:SYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   101: if_acmpeq +98 -> 199
    //   104: aload_3
    //   105: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   108: getstatic 243	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   111: if_acmpeq +88 -> 199
    //   114: invokestatic 229	com/alibaba/sdk/android/trace/AliSDKLogger:isDebugEnabled	()Z
    //   117: ifeq +48 -> 165
    //   120: ldc 13
    //   122: new 135	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   129: ldc -67
    //   131: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_1
    //   135: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc -23
    //   140: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_3
    //   144: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   147: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   150: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 364
    //   156: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 152	com/alibaba/sdk/android/trace/AliSDKLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_2
    //   166: ldc -79
    //   168: new 135	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   175: ldc -33
    //   177: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_3
    //   181: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   184: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   187: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   196: aload_0
    //   197: monitorexit
    //   198: return
    //   199: aload_2
    //   200: ldc -2
    //   202: aload_3
    //   203: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   206: getfield 256	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   209: invokevirtual 260	com/alibaba/sdk/android/trace/ActionTraceLogger:info	(Ljava/lang/String;Ljava/lang/Object;)Lcom/alibaba/sdk/android/trace/ActionTraceLogger;
    //   212: pop
    //   213: ldc 13
    //   215: new 135	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 366
    //   225: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 264
    //   235: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   242: getfield 256	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   245: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 267	com/alibaba/sdk/android/trace/AliSDKLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_3
    //   255: getstatic 369	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STOPPING	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   258: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   261: aload_3
    //   262: getfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   265: instanceof 316
    //   268: ifeq +37 -> 305
    //   271: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   274: aload_1
    //   275: invokevirtual 372	com/alibaba/sdk/android/app/AppContextManager:getAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   278: astore 4
    //   280: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   283: aload_1
    //   284: invokevirtual 375	com/alibaba/sdk/android/plugin/PluginContextManager:getPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   287: astore 5
    //   289: aload_3
    //   290: getfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   293: checkcast 316	com/alibaba/sdk/android/plugin/PluginLifecycleAdapter
    //   296: aload 4
    //   298: aload 5
    //   300: invokeinterface 378 3 0
    //   305: aload_3
    //   306: aconst_null
    //   307: putfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   310: aload_3
    //   311: getstatic 381	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STOPPED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   314: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   317: aload_2
    //   318: invokevirtual 300	com/alibaba/sdk/android/trace/ActionTraceLogger:success	()V
    //   321: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   324: aload_1
    //   325: invokevirtual 332	com/alibaba/sdk/android/app/AppContextManager:destroyAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   328: pop
    //   329: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   332: aload_1
    //   333: invokevirtual 329	com/alibaba/sdk/android/plugin/PluginContextManager:destroyPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   336: pop
    //   337: goto -141 -> 196
    //   340: astore_2
    //   341: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   344: dup
    //   345: aload_1
    //   346: aload_2
    //   347: invokevirtual 335	com/alibaba/sdk/android/AlibabaSDKException:getMessage	()Ljava/lang/String;
    //   350: aload_2
    //   351: invokespecial 338	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   354: astore_3
    //   355: aload_2
    //   356: invokevirtual 342	com/alibaba/sdk/android/AlibabaSDKException:getSDKMessage	()Lcom/alibaba/sdk/android/message/Message;
    //   359: ifnull +14 -> 373
    //   362: aload_3
    //   363: aload_2
    //   364: invokevirtual 342	com/alibaba/sdk/android/AlibabaSDKException:getSDKMessage	()Lcom/alibaba/sdk/android/message/Message;
    //   367: invokestatic 348	com/alibaba/sdk/android/ResultCode:create	(Lcom/alibaba/sdk/android/message/Message;)Lcom/alibaba/sdk/android/ResultCode;
    //   370: invokevirtual 352	com/alibaba/sdk/android/plugin/PluginLifecycleException:setResultCode	(Lcom/alibaba/sdk/android/ResultCode;)V
    //   373: aload_3
    //   374: athrow
    //   375: astore_2
    //   376: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   379: aload_1
    //   380: invokevirtual 332	com/alibaba/sdk/android/app/AppContextManager:destroyAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   383: pop
    //   384: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   387: aload_1
    //   388: invokevirtual 329	com/alibaba/sdk/android/plugin/PluginContextManager:destroyPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   391: pop
    //   392: aload_2
    //   393: athrow
    //   394: astore 4
    //   396: aload 4
    //   398: aload_1
    //   399: invokevirtual 355	com/alibaba/sdk/android/plugin/PluginLifecycleException:setPluginName	(Ljava/lang/String;)V
    //   402: aload_3
    //   403: getstatic 384	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STOP_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   406: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   409: aload_2
    //   410: ldc -79
    //   412: aload 4
    //   414: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   417: aload 4
    //   419: athrow
    //   420: astore 4
    //   422: aload_3
    //   423: getstatic 384	com/alibaba/sdk/android/plugin/PluginState:ASYNC_STOP_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   426: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   429: aload_2
    //   430: ldc -79
    //   432: aload 4
    //   434: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   437: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   440: dup
    //   441: aload_1
    //   442: ldc_w 386
    //   445: aload 4
    //   447: invokespecial 338	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   450: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	DefaultPluginManager
    //   0	451	1	paramString	String
    //   28	290	2	localActionTraceLogger	com.alibaba.sdk.android.trace.ActionTraceLogger
    //   340	24	2	localAlibabaSDKException	com.alibaba.sdk.android.AlibabaSDKException
    //   375	55	2	localObject1	Object
    //   42	381	3	localObject2	Object
    //   278	19	4	localAppContext	com.alibaba.sdk.android.app.AppContext
    //   394	24	4	localPluginLifecycleException	com.alibaba.sdk.android.plugin.PluginLifecycleException
    //   420	26	4	localThrowable	Throwable
    //   287	12	5	localPluginContext	com.alibaba.sdk.android.plugin.PluginContext
    // Exception table:
    //   from	to	target	type
    //   2	43	89	finally
    //   47	89	89	finally
    //   94	165	89	finally
    //   165	196	89	finally
    //   199	261	89	finally
    //   321	337	89	finally
    //   376	394	89	finally
    //   261	305	340	com/alibaba/sdk/android/AlibabaSDKException
    //   305	321	340	com/alibaba/sdk/android/AlibabaSDKException
    //   261	305	375	finally
    //   305	321	375	finally
    //   341	373	375	finally
    //   373	375	375	finally
    //   396	420	375	finally
    //   422	451	375	finally
    //   261	305	394	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   305	321	394	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   261	305	420	java/lang/Throwable
    //   305	321	420	java/lang/Throwable
  }
  
  /* Error */
  public void syncStartPlugin(String paramString)
  {
    // Byte code:
    //   0: getstatic 158	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   3: ifeq +7 -> 10
    //   6: aload_1
    //   7: invokestatic 163	com/taobao/tae/sdk/log/SdkCoreLog:startTimeRecord	(Ljava/lang/String;)V
    //   10: getstatic 169	com/alibaba/sdk/android/trace/TraceLoggerManager:INSTANCE	Lcom/alibaba/sdk/android/trace/TraceLoggerManager;
    //   13: new 135	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc -85
    //   26: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 175	com/alibaba/sdk/android/trace/TraceLoggerManager:action	(Ljava/lang/String;)Lcom/alibaba/sdk/android/trace/ActionTraceLogger;
    //   35: astore_3
    //   36: aload_0
    //   37: getfield 30	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:pluginDataEntries	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 122 2 0
    //   46: checkcast 8	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData
    //   49: astore_2
    //   50: aload_2
    //   51: ifnonnull +44 -> 95
    //   54: aload_3
    //   55: ldc -79
    //   57: ldc -77
    //   59: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   62: new 187	com/alibaba/sdk/android/plugin/PluginNotFoundException
    //   65: dup
    //   66: aload_1
    //   67: new 135	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   74: ldc -67
    //   76: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc -65
    //   85: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 193	com/alibaba/sdk/android/plugin/PluginNotFoundException:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: athrow
    //   95: aload_2
    //   96: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   99: getstatic 57	com/alibaba/sdk/android/plugin/PluginState:LOADED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   102: if_acmpeq +95 -> 197
    //   105: aload_2
    //   106: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   109: getstatic 394	com/alibaba/sdk/android/plugin/PluginState:SYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   112: if_acmpeq +85 -> 197
    //   115: aload_3
    //   116: ldc -79
    //   118: new 135	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   125: ldc -33
    //   127: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_2
    //   131: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   134: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   137: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   146: invokestatic 229	com/alibaba/sdk/android/trace/AliSDKLogger:isDebugEnabled	()Z
    //   149: ifeq +47 -> 196
    //   152: ldc 13
    //   154: new 135	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   161: ldc -25
    //   163: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc -23
    //   172: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_2
    //   176: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   179: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   182: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc -21
    //   187: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 152	com/alibaba/sdk/android/trace/AliSDKLogger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: return
    //   197: aload_2
    //   198: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   201: getfield 238	com/alibaba/sdk/android/plugin/PluginInfo:after	[Ljava/lang/String;
    //   204: astore 4
    //   206: aload 4
    //   208: arraylength
    //   209: istore 9
    //   211: iconst_0
    //   212: istore 8
    //   214: iload 8
    //   216: iload 9
    //   218: if_icmpge +113 -> 331
    //   221: aload 4
    //   223: iload 8
    //   225: aaload
    //   226: astore 5
    //   228: aload_0
    //   229: aload 5
    //   231: invokevirtual 240	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:getPluginState	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginState;
    //   234: astore 6
    //   236: aload 6
    //   238: getstatic 218	com/alibaba/sdk/android/plugin/PluginState:SYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   241: if_acmpeq +81 -> 322
    //   244: aload 6
    //   246: getstatic 125	com/alibaba/sdk/android/plugin/PluginState:UNDEFINED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   249: if_acmpeq +73 -> 322
    //   252: aload_3
    //   253: ldc -79
    //   255: new 135	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   262: ldc -11
    //   264: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   271: invokevirtual 225	com/alibaba/sdk/android/plugin/PluginState:name	()Ljava/lang/String;
    //   274: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc -9
    //   279: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   288: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   291: dup
    //   292: aload_1
    //   293: new 135	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   300: ldc -7
    //   302: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 5
    //   307: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc -5
    //   312: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokespecial 252	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: athrow
    //   322: iload 8
    //   324: iconst_1
    //   325: iadd
    //   326: istore 8
    //   328: goto -114 -> 214
    //   331: aload_3
    //   332: ldc -2
    //   334: aload_2
    //   335: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   338: getfield 256	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   341: invokevirtual 260	com/alibaba/sdk/android/trace/ActionTraceLogger:info	(Ljava/lang/String;Ljava/lang/Object;)Lcom/alibaba/sdk/android/trace/ActionTraceLogger;
    //   344: pop
    //   345: ldc 13
    //   347: new 135	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 396
    //   357: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_1
    //   361: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 264
    //   367: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_2
    //   371: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   374: getfield 256	com/alibaba/sdk/android/plugin/PluginInfo:version	Ljava/lang/String;
    //   377: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 267	com/alibaba/sdk/android/trace/AliSDKLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   386: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   389: lstore 10
    //   391: aload_2
    //   392: getstatic 399	com/alibaba/sdk/android/plugin/PluginState:SYNC_STARTING	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   395: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   398: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   401: aload_1
    //   402: invokevirtual 285	com/alibaba/sdk/android/app/AppContextManager:createAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   405: astore 4
    //   407: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   410: aload_2
    //   411: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   414: invokevirtual 294	com/alibaba/sdk/android/plugin/PluginContextManager:createPluginConext	(Lcom/alibaba/sdk/android/plugin/PluginInfo;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   417: astore 5
    //   419: aload_2
    //   420: getfield 51	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:pluginInfo	Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   423: getfield 297	com/alibaba/sdk/android/plugin/PluginInfo:lifecycleAdapterClassName	Ljava/lang/String;
    //   426: astore 6
    //   428: aload 6
    //   430: ifnonnull +44 -> 474
    //   433: aload_2
    //   434: getstatic 218	com/alibaba/sdk/android/plugin/PluginState:SYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   437: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   440: aload_3
    //   441: invokevirtual 300	com/alibaba/sdk/android/trace/ActionTraceLogger:success	()V
    //   444: getstatic 158	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   447: ifeq -251 -> 196
    //   450: aload_1
    //   451: ldc 13
    //   453: aload_1
    //   454: invokestatic 304	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   457: iconst_1
    //   458: anewarray 108	java/lang/String
    //   461: dup
    //   462: iconst_0
    //   463: ldc_w 305
    //   466: aastore
    //   467: invokestatic 309	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   470: invokestatic 310	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: return
    //   474: aload_0
    //   475: getfield 40	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:classLoader	Ljava/lang/ClassLoader;
    //   478: aload 6
    //   480: invokevirtual 405	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   483: astore 6
    //   485: aload 6
    //   487: invokevirtual 409	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   490: astore 7
    //   492: aload_2
    //   493: aload 7
    //   495: putfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   498: aload 7
    //   500: instanceof 411
    //   503: ifeq +17 -> 520
    //   506: aload 7
    //   508: checkcast 411	com/alibaba/sdk/android/plugin/PluginSyncLifecycleAdapter
    //   511: aload 4
    //   513: aload 5
    //   515: invokeinterface 414 3 0
    //   520: aload_2
    //   521: getstatic 218	com/alibaba/sdk/android/plugin/PluginState:SYNC_STARTED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   524: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   527: aload_0
    //   528: iconst_1
    //   529: aload_1
    //   530: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   533: lload 10
    //   535: lsub
    //   536: invokespecial 322	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:sendPluginHint	(ZLjava/lang/String;J)V
    //   539: aload_3
    //   540: ldc_w 323
    //   543: aload 6
    //   545: invokevirtual 325	com/alibaba/sdk/android/trace/ActionTraceLogger:success	(Ljava/lang/String;Ljava/lang/Object;)V
    //   548: getstatic 158	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   551: ifeq +26 -> 577
    //   554: aload_1
    //   555: ldc 13
    //   557: aload_1
    //   558: invokestatic 304	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   561: iconst_1
    //   562: anewarray 108	java/lang/String
    //   565: dup
    //   566: iconst_0
    //   567: ldc_w 305
    //   570: aastore
    //   571: invokestatic 309	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   574: invokestatic 310	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload_2
    //   578: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   581: getstatic 394	com/alibaba/sdk/android/plugin/PluginState:SYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   584: if_acmpne -388 -> 196
    //   587: aload_2
    //   588: aconst_null
    //   589: putfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   592: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   595: aload_1
    //   596: invokevirtual 329	com/alibaba/sdk/android/plugin/PluginContextManager:destroyPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   599: pop
    //   600: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   603: aload_1
    //   604: invokevirtual 332	com/alibaba/sdk/android/app/AppContextManager:destroyAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   607: pop
    //   608: aload_0
    //   609: iconst_0
    //   610: aload_1
    //   611: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   614: lload 10
    //   616: lsub
    //   617: invokespecial 322	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:sendPluginHint	(ZLjava/lang/String;J)V
    //   620: return
    //   621: astore_3
    //   622: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   625: dup
    //   626: bipush 16
    //   628: iconst_1
    //   629: anewarray 4	java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload_3
    //   635: invokevirtual 415	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   638: aastore
    //   639: invokestatic 420	com/alibaba/sdk/android/message/Message:create	(I[Ljava/lang/Object;)Lcom/alibaba/sdk/android/message/Message;
    //   642: aload_3
    //   643: invokespecial 423	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Lcom/alibaba/sdk/android/message/Message;Ljava/lang/Throwable;)V
    //   646: athrow
    //   647: astore_3
    //   648: aload_2
    //   649: getfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   652: getstatic 394	com/alibaba/sdk/android/plugin/PluginState:SYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   655: if_acmpne +36 -> 691
    //   658: aload_2
    //   659: aconst_null
    //   660: putfield 314	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:lifecycleAdapter	Ljava/lang/Object;
    //   663: getstatic 290	com/alibaba/sdk/android/plugin/PluginContextManager:INSTANCE	Lcom/alibaba/sdk/android/plugin/PluginContextManager;
    //   666: aload_1
    //   667: invokevirtual 329	com/alibaba/sdk/android/plugin/PluginContextManager:destroyPluginContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/plugin/PluginContext;
    //   670: pop
    //   671: getstatic 281	com/alibaba/sdk/android/app/AppContextManager:INSTANCE	Lcom/alibaba/sdk/android/app/AppContextManager;
    //   674: aload_1
    //   675: invokevirtual 332	com/alibaba/sdk/android/app/AppContextManager:destroyAppContext	(Ljava/lang/String;)Lcom/alibaba/sdk/android/app/AppContext;
    //   678: pop
    //   679: aload_0
    //   680: iconst_0
    //   681: aload_1
    //   682: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   685: lload 10
    //   687: lsub
    //   688: invokespecial 322	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager:sendPluginHint	(ZLjava/lang/String;J)V
    //   691: aload_3
    //   692: athrow
    //   693: astore_3
    //   694: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   697: dup
    //   698: bipush 16
    //   700: iconst_1
    //   701: anewarray 4	java/lang/Object
    //   704: dup
    //   705: iconst_0
    //   706: aload_3
    //   707: invokevirtual 424	java/lang/NoClassDefFoundError:getMessage	()Ljava/lang/String;
    //   710: aastore
    //   711: invokestatic 420	com/alibaba/sdk/android/message/Message:create	(I[Ljava/lang/Object;)Lcom/alibaba/sdk/android/message/Message;
    //   714: aload_3
    //   715: invokespecial 423	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Lcom/alibaba/sdk/android/message/Message;Ljava/lang/Throwable;)V
    //   718: athrow
    //   719: astore_3
    //   720: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   723: dup
    //   724: aload_1
    //   725: aload_3
    //   726: invokevirtual 335	com/alibaba/sdk/android/AlibabaSDKException:getMessage	()Ljava/lang/String;
    //   729: aload_3
    //   730: invokespecial 338	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   733: astore 4
    //   735: aload_3
    //   736: invokevirtual 342	com/alibaba/sdk/android/AlibabaSDKException:getSDKMessage	()Lcom/alibaba/sdk/android/message/Message;
    //   739: ifnull +15 -> 754
    //   742: aload 4
    //   744: aload_3
    //   745: invokevirtual 342	com/alibaba/sdk/android/AlibabaSDKException:getSDKMessage	()Lcom/alibaba/sdk/android/message/Message;
    //   748: invokestatic 348	com/alibaba/sdk/android/ResultCode:create	(Lcom/alibaba/sdk/android/message/Message;)Lcom/alibaba/sdk/android/ResultCode;
    //   751: invokevirtual 352	com/alibaba/sdk/android/plugin/PluginLifecycleException:setResultCode	(Lcom/alibaba/sdk/android/ResultCode;)V
    //   754: aload 4
    //   756: athrow
    //   757: astore 4
    //   759: aload 4
    //   761: aload_1
    //   762: invokevirtual 355	com/alibaba/sdk/android/plugin/PluginLifecycleException:setPluginName	(Ljava/lang/String;)V
    //   765: aload_2
    //   766: getstatic 394	com/alibaba/sdk/android/plugin/PluginState:SYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   769: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   772: aload_3
    //   773: ldc -79
    //   775: aload 4
    //   777: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   780: aload 4
    //   782: athrow
    //   783: astore 4
    //   785: aload_2
    //   786: getstatic 394	com/alibaba/sdk/android/plugin/PluginState:SYNC_START_FAILED	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   789: putfield 60	com/alibaba/sdk/android/plugin/impl/DefaultPluginManager$PluginData:state	Lcom/alibaba/sdk/android/plugin/PluginState;
    //   792: aload_3
    //   793: ldc -79
    //   795: aload 4
    //   797: invokevirtual 185	com/alibaba/sdk/android/trace/ActionTraceLogger:failed	(Ljava/lang/String;Ljava/lang/Object;)V
    //   800: new 131	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   803: dup
    //   804: aload_1
    //   805: ldc_w 357
    //   808: aload 4
    //   810: invokespecial 338	com/alibaba/sdk/android/plugin/PluginLifecycleException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   813: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	814	0	this	DefaultPluginManager
    //   0	814	1	paramString	String
    //   49	737	2	localPluginData	PluginData
    //   35	505	3	localActionTraceLogger	com.alibaba.sdk.android.trace.ActionTraceLogger
    //   621	22	3	localClassNotFoundException	ClassNotFoundException
    //   647	45	3	localObject1	Object
    //   693	22	3	localNoClassDefFoundError	NoClassDefFoundError
    //   719	74	3	localAlibabaSDKException	com.alibaba.sdk.android.AlibabaSDKException
    //   204	551	4	localObject2	Object
    //   757	24	4	localPluginLifecycleException	com.alibaba.sdk.android.plugin.PluginLifecycleException
    //   783	26	4	localThrowable	Throwable
    //   226	288	5	localObject3	Object
    //   234	310	6	localObject4	Object
    //   490	17	7	localObject5	Object
    //   212	115	8	i	int
    //   209	10	9	j	int
    //   389	297	10	l	long
    // Exception table:
    //   from	to	target	type
    //   474	520	621	java/lang/ClassNotFoundException
    //   520	577	621	java/lang/ClassNotFoundException
    //   474	520	647	finally
    //   520	577	647	finally
    //   622	647	647	finally
    //   694	719	647	finally
    //   720	754	647	finally
    //   754	757	647	finally
    //   759	783	647	finally
    //   785	814	647	finally
    //   474	520	693	java/lang/NoClassDefFoundError
    //   520	577	693	java/lang/NoClassDefFoundError
    //   474	520	719	com/alibaba/sdk/android/AlibabaSDKException
    //   520	577	719	com/alibaba/sdk/android/AlibabaSDKException
    //   474	520	757	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   520	577	757	com/alibaba/sdk/android/plugin/PluginLifecycleException
    //   474	520	783	java/lang/Throwable
    //   520	577	783	java/lang/Throwable
  }
  
  static class PluginData
  {
    public Object lifecycleAdapter;
    public PluginInfo pluginInfo;
    public volatile PluginState state;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\impl\DefaultPluginManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */