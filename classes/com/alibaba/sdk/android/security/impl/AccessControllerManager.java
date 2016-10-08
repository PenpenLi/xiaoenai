package com.alibaba.sdk.android.security.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.executor.ExecutorService;
import com.alibaba.sdk.android.initialization.InitializationHandler;
import com.alibaba.sdk.android.plugin.config.PluginConfigurations;
import com.alibaba.sdk.android.security.AccessController;
import com.alibaba.sdk.android.security.WebAccessPermission;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.CommonUtils;
import com.alibaba.sdk.android.util.JSONUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class AccessControllerManager
  implements InitializationHandler<Void>, AccessController
{
  private static final String ACCESS_PERMISSIONS_KEY = "alisdk.sdk_access_permissions";
  public static final AccessControllerManager INSTANCE = new AccessControllerManager();
  private static final String LAST_ACCESS_PERMISSIONS_QUERY_TIMESTAMP_KEY = "alisdk.last_sdk_access_permissions_timestamp";
  private static final String NEXT_ACCESS_PERMISSIONS_QUERY_TIMESTAMP_KEY = "alisdk.next_sdk_access_permissions_timestamp";
  private static final String TAG = AccessControllerManager.class.getSimpleName();
  private volatile JSONObject configs;
  private boolean ignoreAclInterval;
  private volatile boolean initialized = false;
  private volatile long lastQueryTimestamp;
  private volatile long nextQueryTimestamp;
  private volatile Set<String> prohibitedPlugins = Collections.emptySet();
  private volatile List<? extends WebAccessPermission> webAccessPermissions = Collections.singletonList(new GrantAllWebAccessPermission());
  
  private void updateAccessPermissions(String paramString)
  {
    int j = 0;
    for (;;)
    {
      Object localObject1;
      int k;
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        localObject1 = new HashSet();
        localObject2 = paramString.optJSONObject("plugins");
        if (localObject2 != null)
        {
          localObject2 = ((JSONObject)localObject2).optJSONArray("prohibited_list");
          if (localObject2 != null)
          {
            k = ((JSONArray)localObject2).length();
            i = 0;
            if (i < k)
            {
              ((Set)localObject1).add(((JSONArray)localObject2).getString(i));
              i += 1;
              continue;
            }
          }
        }
        this.prohibitedPlugins = ((Set)localObject1);
        localObject1 = new ArrayList();
        localObject2 = paramString.optJSONObject("webpages");
        if (localObject2 != null) {
          continue;
        }
        ((List)localObject1).add(new GrantAllWebAccessPermission());
        this.webAccessPermissions = ((List)localObject1);
        this.configs = paramString.optJSONObject("configs");
      }
      catch (Exception paramString)
      {
        AliSDKLogger.e(TAG, "Fail to update the access controller, the error message is " + paramString.getMessage());
        continue;
      }
      finally {}
      return;
      Object localObject2 = ((JSONObject)localObject2).optJSONArray("grant_list");
      if (localObject2 == null)
      {
        ((List)localObject1).add(new GrantAllWebAccessPermission());
      }
      else
      {
        k = ((JSONArray)localObject2).length();
        i = j;
        while (i < k)
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
          String str1 = localJSONObject.optString("value");
          String str2 = localJSONObject.optString("type");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
            AliSDKLogger.w(TAG, "Empty type/value for the current web access permission " + localJSONObject);
          } else if ("prefix".equals(str2)) {
            ((List)localObject1).add(new PrefixWebAccessPermission(str1));
          } else if ("regexp".equals(str2)) {
            ((List)localObject1).add(new RegexpWebAccessPermission(str1));
          } else if ("strict".equals(str2)) {
            ((List)localObject1).add(new StrictWebAccessPermission(str1));
          } else {
            AliSDKLogger.w(TAG, "Unrecognized url permssion " + localJSONObject);
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean checkPluginLoadPermission(String paramString)
  {
    return !this.prohibitedPlugins.contains(paramString);
  }
  
  public boolean checkWebPageAccessPermission(String paramString)
  {
    Iterator localIterator = this.webAccessPermissions.iterator();
    while (localIterator.hasNext()) {
      if (((WebAccessPermission)localIterator.next()).checkPermission(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public Object createRequestParameters()
  {
    return null;
  }
  
  public String getConfigProperty(String paramString)
  {
    if (this.configs == null) {
      return null;
    }
    return JSONUtils.optString(this.configs, paramString);
  }
  
  public String getRequestParameterKey()
  {
    return "acl";
  }
  
  public int getRequestRequirement()
  {
    int j = 1;
    int i;
    if ((CommonUtils.isApplicationDefaultProcess() == 0) && (SecurityContext.pluginConfigurations.getBooleanValue("refreshInMainProcess", true))) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (this.ignoreAclInterval);
      i = j;
    } while (System.currentTimeMillis() > this.nextQueryTimestamp);
    return 3;
  }
  
  public int getRequestServiceType()
  {
    return 16;
  }
  
  public String getResponseValueKey()
  {
    return "acl";
  }
  
  public void handleResponseError(int paramInt, String paramString) {}
  
  public Void handleResponseValue(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      AliSDKLogger.e(TAG, "Null response returned for acl");
    }
    do
    {
      return null;
      int i = paramJSONObject.optInt("code", -1);
      if (i == -1)
      {
        AliSDKLogger.e(TAG, "Failed to query acl info, the error code = " + i + " message = " + paramJSONObject.optString("message"));
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("data");
      if (paramJSONObject == null)
      {
        AliSDKLogger.e(TAG, "Failed to query acl info, no data in the response");
        return null;
      }
      long l = paramJSONObject.optLong("expireIn", 86400000L);
      this.lastQueryTimestamp = System.currentTimeMillis();
      this.nextQueryTimestamp = (l + this.lastQueryTimestamp);
      SecurityGuardWrapper.INSTANCE.putValueInDynamicDataStore("alisdk.next_sdk_access_permissions_timestamp", String.valueOf(this.nextQueryTimestamp));
      SecurityGuardWrapper.INSTANCE.putValueInDynamicDataStore("alisdk.last_sdk_access_permissions_timestamp", String.valueOf(this.lastQueryTimestamp));
      paramJSONObject = paramJSONObject.optString("authData");
      if (TextUtils.isEmpty(paramJSONObject))
      {
        AliSDKLogger.e(TAG, "Failed to query acl info, no auth data in the response");
        return null;
      }
      updateAccessPermissions(paramJSONObject);
      SecurityGuardWrapper.INSTANCE.putValueInDynamicDataStore("alisdk.sdk_access_permissions", paramJSONObject);
    } while (this.prohibitedPlugins.size() <= 0);
    SecurityContext.executorService.postTask(new AccessControllerManager.2(this));
    return null;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/alibaba/sdk/android/security/impl/AccessControllerManager:initialized	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 311	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:INSTANCE	Lcom/alibaba/sdk/android/security/impl/SecurityGuardWrapper;
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 13
    //   21: invokevirtual 346	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getValueFromDynamicDataStore	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +8 -> 34
    //   29: aload_0
    //   30: aload_2
    //   31: invokespecial 324	com/alibaba/sdk/android/security/impl/AccessControllerManager:updateAccessPermissions	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: ldc 21
    //   37: invokevirtual 346	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getValueFromDynamicDataStore	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +11 -> 53
    //   45: aload_0
    //   46: aload_2
    //   47: invokestatic 352	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   50: putfield 76	com/alibaba/sdk/android/security/impl/AccessControllerManager:nextQueryTimestamp	J
    //   53: aload_1
    //   54: ldc 18
    //   56: invokevirtual 346	com/alibaba/sdk/android/security/impl/SecurityGuardWrapper:getValueFromDynamicDataStore	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +11 -> 72
    //   64: aload_0
    //   65: aload_1
    //   66: invokestatic 352	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: putfield 81	com/alibaba/sdk/android/security/impl/AccessControllerManager:lastQueryTimestamp	J
    //   72: aload_0
    //   73: getstatic 252	com/alibaba/sdk/android/security/impl/SecurityContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   76: ldc_w 354
    //   79: iconst_0
    //   80: invokeinterface 260 3 0
    //   85: putfield 262	com/alibaba/sdk/android/security/impl/AccessControllerManager:ignoreAclInterval	Z
    //   88: getstatic 252	com/alibaba/sdk/android/security/impl/SecurityContext:pluginConfigurations	Lcom/alibaba/sdk/android/plugin/config/PluginConfigurations;
    //   91: new 356	com/alibaba/sdk/android/security/impl/AccessControllerManager$1
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 357	com/alibaba/sdk/android/security/impl/AccessControllerManager$1:<init>	(Lcom/alibaba/sdk/android/security/impl/AccessControllerManager;)V
    //   99: invokeinterface 361 2 0
    //   104: pop
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 72	com/alibaba/sdk/android/security/impl/AccessControllerManager:initialized	Z
    //   110: goto -99 -> 11
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: astore_2
    //   119: aload_0
    //   120: lconst_0
    //   121: putfield 76	com/alibaba/sdk/android/security/impl/AccessControllerManager:nextQueryTimestamp	J
    //   124: goto -71 -> 53
    //   127: astore_1
    //   128: aload_0
    //   129: lconst_0
    //   130: putfield 81	com/alibaba/sdk/android/security/impl/AccessControllerManager:lastQueryTimestamp	J
    //   133: goto -61 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	AccessControllerManager
    //   17	49	1	localObject1	Object
    //   113	4	1	localObject2	Object
    //   127	1	1	localException1	Exception
    //   24	23	2	str	String
    //   118	1	2	localException2	Exception
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	113	finally
    //   14	25	113	finally
    //   29	34	113	finally
    //   34	41	113	finally
    //   45	53	113	finally
    //   53	60	113	finally
    //   64	72	113	finally
    //   72	110	113	finally
    //   119	124	113	finally
    //   128	133	113	finally
    //   45	53	118	java/lang/Exception
    //   64	72	127	java/lang/Exception
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\AccessControllerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */