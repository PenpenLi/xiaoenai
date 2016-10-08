package com.alibaba.sdk.android.repository.impl;

import android.content.Context;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.plugin.PluginInfo;
import com.alibaba.sdk.android.repository.PluginRepository;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SimplePluginRepository
  implements PluginRepository
{
  private static final String TAG = "kernel";
  private BinaryPersistencePluginFinder binaryPersistencePluginFinder = new BinaryPersistencePluginFinder();
  private Map<String, PluginInfo> namePluginInfos = new LinkedHashMap();
  private PropertiesFilePluginFinder propertiesFilePluginFinder = new PropertiesFilePluginFinder(KernelContext.context.getAssets());
  
  public SimplePluginRepository()
  {
    initialize();
  }
  
  /* Error */
  private void initialize()
  {
    // Byte code:
    //   0: getstatic 64	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   3: ifeq +8 -> 11
    //   6: ldc 66
    //   8: invokestatic 72	com/taobao/tae/sdk/log/SdkCoreLog:startTimeRecord	(Ljava/lang/String;)V
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 50	com/alibaba/sdk/android/repository/impl/SimplePluginRepository:binaryPersistencePluginFinder	Lcom/alibaba/sdk/android/repository/impl/BinaryPersistencePluginFinder;
    //   17: invokevirtual 76	com/alibaba/sdk/android/repository/impl/BinaryPersistencePluginFinder:findPlugins	()[Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: getstatic 64	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   26: ifeq +27 -> 53
    //   29: ldc 77
    //   31: ldc 66
    //   33: ldc 66
    //   35: invokestatic 81	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   38: iconst_1
    //   39: anewarray 83	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 85
    //   46: aastore
    //   47: invokestatic 89	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 93	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_1
    //   54: ifnonnull +199 -> 253
    //   57: getstatic 64	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   60: ifeq +8 -> 68
    //   63: ldc 95
    //   65: invokestatic 72	com/taobao/tae/sdk/log/SdkCoreLog:startTimeRecord	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 45	com/alibaba/sdk/android/repository/impl/SimplePluginRepository:propertiesFilePluginFinder	Lcom/alibaba/sdk/android/repository/impl/PropertiesFilePluginFinder;
    //   72: invokevirtual 96	com/alibaba/sdk/android/repository/impl/PropertiesFilePluginFinder:findPlugins	()[Lcom/alibaba/sdk/android/plugin/PluginInfo;
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: getstatic 64	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   81: ifeq +27 -> 108
    //   84: ldc 77
    //   86: ldc 95
    //   88: ldc 95
    //   90: invokestatic 81	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   93: iconst_1
    //   94: anewarray 83	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc 85
    //   101: aastore
    //   102: invokestatic 89	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 93	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: getstatic 64	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   111: ifeq +8 -> 119
    //   114: ldc 98
    //   116: invokestatic 72	com/taobao/tae/sdk/log/SdkCoreLog:startTimeRecord	(Ljava/lang/String;)V
    //   119: aload_1
    //   120: arraylength
    //   121: iconst_2
    //   122: if_icmple +7 -> 129
    //   125: aload_1
    //   126: invokestatic 104	com/alibaba/sdk/android/util/SortUtils:sorts	([Lcom/alibaba/sdk/android/util/SortUtils$SortInfo;)V
    //   129: aload_1
    //   130: astore_2
    //   131: getstatic 64	com/alibaba/sdk/android/ConfigManager:DEBUG	Z
    //   134: ifeq +29 -> 163
    //   137: ldc 98
    //   139: ldc 106
    //   141: ldc 98
    //   143: invokestatic 81	com/taobao/tae/sdk/log/SdkCoreLog:getTimeUsed	(Ljava/lang/String;)J
    //   146: iconst_1
    //   147: anewarray 83	java/lang/String
    //   150: dup
    //   151: iconst_0
    //   152: ldc 85
    //   154: aastore
    //   155: invokestatic 89	com/taobao/tae/sdk/log/SdkCoreLog:content	(Ljava/lang/String;J[Ljava/lang/String;)Ljava/lang/String;
    //   158: invokestatic 93	com/taobao/tae/sdk/log/SdkCoreLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_1
    //   162: astore_2
    //   163: aload_2
    //   164: ifnull +84 -> 248
    //   167: aload_2
    //   168: arraylength
    //   169: istore 4
    //   171: iconst_0
    //   172: istore_3
    //   173: iload_3
    //   174: iload 4
    //   176: if_icmpge +55 -> 231
    //   179: aload_2
    //   180: iload_3
    //   181: aaload
    //   182: astore_1
    //   183: aload_0
    //   184: getfield 26	com/alibaba/sdk/android/repository/impl/SimplePluginRepository:namePluginInfos	Ljava/util/Map;
    //   187: aload_1
    //   188: getfield 111	com/alibaba/sdk/android/plugin/PluginInfo:name	Ljava/lang/String;
    //   191: aload_1
    //   192: invokeinterface 117 3 0
    //   197: pop
    //   198: iload_3
    //   199: iconst_1
    //   200: iadd
    //   201: istore_3
    //   202: goto -29 -> 173
    //   205: astore_2
    //   206: ldc 10
    //   208: ldc 119
    //   210: aload_2
    //   211: invokestatic 125	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: goto -191 -> 23
    //   217: astore_2
    //   218: ldc 10
    //   220: ldc 127
    //   222: aload_2
    //   223: invokestatic 125	com/alibaba/sdk/android/trace/AliSDKLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: astore_2
    //   228: goto -65 -> 163
    //   231: getstatic 131	com/alibaba/sdk/android/impl/KernelContext:executorService	Lcom/alibaba/sdk/android/executor/ExecutorService;
    //   234: new 133	com/alibaba/sdk/android/repository/impl/SimplePluginRepository$1
    //   237: dup
    //   238: aload_0
    //   239: aload_2
    //   240: invokespecial 136	com/alibaba/sdk/android/repository/impl/SimplePluginRepository$1:<init>	(Lcom/alibaba/sdk/android/repository/impl/SimplePluginRepository;[Lcom/alibaba/sdk/android/plugin/PluginInfo;)V
    //   243: invokeinterface 142 2 0
    //   248: return
    //   249: astore_2
    //   250: goto -32 -> 218
    //   253: aload_1
    //   254: astore_2
    //   255: goto -92 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	SimplePluginRepository
    //   12	242	1	localObject1	Object
    //   20	160	2	localObject2	Object
    //   205	6	2	localException1	Exception
    //   217	6	2	localException2	Exception
    //   227	13	2	localObject3	Object
    //   249	1	2	localException3	Exception
    //   254	1	2	localObject4	Object
    //   172	30	3	i	int
    //   169	8	4	j	int
    // Exception table:
    //   from	to	target	type
    //   13	21	205	java/lang/Exception
    //   57	68	217	java/lang/Exception
    //   68	76	217	java/lang/Exception
    //   78	108	249	java/lang/Exception
    //   108	119	249	java/lang/Exception
    //   119	129	249	java/lang/Exception
    //   131	161	249	java/lang/Exception
  }
  
  public PluginInfo getPluginInfo(String paramString)
  {
    return (PluginInfo)this.namePluginInfos.get(paramString);
  }
  
  public PluginInfo[] getPluginInfos()
  {
    return (PluginInfo[])this.namePluginInfos.values().toArray(new PluginInfo[this.namePluginInfos.size()]);
  }
  
  public String[] getPluginNames()
  {
    return (String[])this.namePluginInfos.keySet().toArray(new String[this.namePluginInfos.size()]);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\repository\impl\SimplePluginRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */