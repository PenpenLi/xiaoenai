package com.alibaba.sdk.android.initialization.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.Version;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.initialization.InitializationHandler;
import com.alibaba.sdk.android.initialization.InitializationServiceClient;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.plugin.config.PluginSystemConfigurations;
import com.alibaba.sdk.android.system.SystemContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.HttpHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicConfigInitHandler
  implements InitializationHandler<Void>
{
  private static final String CONFIG = "config";
  private static final String INTERVAL = "expireIn";
  private static final String LAST_MODIFY = "lastModify";
  private static final String TAG = DynamicConfigInitHandler.class.getSimpleName();
  private static final String TIMESTAMP = "timestamp";
  private static final String VERSION = "version";
  private volatile Timer configPollTimer;
  private volatile long currentConfigPollInterval;
  private volatile boolean forceQueryConfigOnce = false;
  private SharedPreferences sp = SystemContext.appContext.getAndroidContext().getSharedPreferences("ALIBABA_SDK_DYNAMIC_CONFIG", 0);
  
  public DynamicConfigInitHandler(PluginConfigurations paramPluginConfigurations)
  {
    startConfigFetchThread();
    paramPluginConfigurations.registerGlobalPropertyChangeListener(new DynamicConfigInitHandler.1(this));
  }
  
  private boolean isNeedRequest()
  {
    if (this.forceQueryConfigOnce) {
      this.forceQueryConfigOnce = false;
    }
    long l;
    do
    {
      return true;
      l = this.sp.getLong("expireIn", 0L);
    } while (System.currentTimeMillis() - this.sp.getLong("timestamp", 0L) > l);
    return false;
  }
  
  public JSONObject createRequestParameters()
  {
    JSONObject localJSONObject = new JSONObject();
    if (isNeedRequest()) {}
    try
    {
      localJSONObject.putOpt("version", Integer.valueOf(this.sp.getInt("version", 0)));
      localJSONObject.putOpt("lastModify", Long.valueOf(this.sp.getLong("lastModify", 0L)));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AliSDKLogger.e(TAG, localJSONException);
    }
    return localJSONObject;
  }
  
  public String getRequestParameterKey()
  {
    return "config";
  }
  
  public int getRequestRequirement()
  {
    if (isNeedRequest()) {
      return 1;
    }
    return 3;
  }
  
  public int getRequestServiceType()
  {
    return 8;
  }
  
  public String getResponseValueKey()
  {
    return "config";
  }
  
  public void handleResponseError(int paramInt, String paramString) {}
  
  public Void handleResponseValue(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1;
    if (paramJSONObject.optInt("code") == 1)
    {
      localJSONObject1 = paramJSONObject.optJSONObject("data");
      int i = localJSONObject1.optInt("version");
      int j = localJSONObject1.optInt("status");
      long l = localJSONObject1.optLong("lastModify");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("items");
      paramJSONObject = this.sp.edit();
      if ((localJSONObject2 != null) && (j == 200))
      {
        SystemContext.pluginSystemConfigurations.setDynamicProperties(localJSONObject2.toString());
        paramJSONObject.putInt("version", i);
        paramJSONObject.putLong("lastModify", l);
      }
    }
    try
    {
      paramJSONObject.putLong("expireIn", localJSONObject1.getLong("expireIn"));
      paramJSONObject.putLong("timestamp", System.currentTimeMillis());
      paramJSONObject.commit();
      return null;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void startConfigFetchThread()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 222	com/alibaba/sdk/android/util/CommonUtils:isApplicationDefaultProcess	()I
    //   5: iconst_1
    //   6: if_icmpne +25 -> 31
    //   9: ldc -32
    //   11: getstatic 228	com/alibaba/sdk/android/system/SystemContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   14: ldc -26
    //   16: ldc -24
    //   18: invokeinterface 236 3 0
    //   23: invokevirtual 242	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +6 -> 34
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getstatic 228	com/alibaba/sdk/android/system/SystemContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   38: ldc -12
    //   40: ldc2_w 245
    //   43: invokeinterface 249 4 0
    //   48: putfield 98	com/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler:currentConfigPollInterval	J
    //   51: aload_0
    //   52: new 251	java/util/Timer
    //   55: dup
    //   56: invokespecial 252	java/util/Timer:<init>	()V
    //   59: putfield 92	com/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler:configPollTimer	Ljava/util/Timer;
    //   62: aload_0
    //   63: getfield 92	com/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler:configPollTimer	Ljava/util/Timer;
    //   66: new 9	com/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler$ConfigPollTimerTask
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 253	com/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler$ConfigPollTimerTask:<init>	(Lcom/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler;)V
    //   74: ldc2_w 254
    //   77: aload_0
    //   78: getfield 98	com/alibaba/sdk/android/initialization/impl/DynamicConfigInitHandler:currentConfigPollInterval	J
    //   81: ldc2_w 256
    //   84: lmul
    //   85: invokevirtual 261	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   88: goto -57 -> 31
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	DynamicConfigInitHandler
    //   91	4	1	localObject	Object
    //   26	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	27	91	finally
    //   34	88	91	finally
  }
  
  private class ConfigPollTimerTask
    extends TimerTask
  {
    private Map<String, String> pollParameters = new HashMap();
    
    public ConfigPollTimerTask()
    {
      this.pollParameters.put("platformName", "android");
      this.pollParameters.put("sdkVersion", ConfigManager.TAE_SDK_VERSION.toString());
    }
    
    public void run()
    {
      for (int i = 1;; i = 0)
      {
        try
        {
          int j = Integer.parseInt(HttpHelper.get(SystemContext.configPollUrl, this.pollParameters));
          int k = DynamicConfigInitHandler.this.sp.getInt("version", 0);
          if (j <= k) {
            continue;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              DynamicConfigInitHandler.access$302(DynamicConfigInitHandler.this, true);
              InitializationServiceClient localInitializationServiceClient = (InitializationServiceClient)SystemContext.appContext.getService(InitializationServiceClient.class);
              Object localObject = localInitializationServiceClient;
              if (localInitializationServiceClient == null) {
                localObject = new DefaultInitializationServiceClientImpl(SystemContext.appContext);
              }
              ((InitializationServiceClient)localObject).request(new InitializationHandler[] { DynamicConfigInitHandler.this });
              return;
            }
            catch (Exception localException2)
            {
              AliSDKLogger.e("system", "Fail to post the config query, the error message is " + localException2.getMessage(), localException2);
              return;
            }
            localException1 = localException1;
            i = 0;
          }
        }
        if (i == 0) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\initialization\impl\DynamicConfigInitHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */