package com.alibaba.sdk.android.el;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.system.SystemContext;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.TraceHelper;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ELResolver
{
  private static Pattern PLACE_HOLDER_PATTERN = Pattern.compile("\\$\\{([\\d\\w\\._\\-]+)\\}");
  
  public static String resolve(String paramString, Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer;
    try
    {
      Matcher localMatcher = PLACE_HOLDER_PATTERN.matcher(paramString);
      localStringBuffer = new StringBuffer();
      while (localMatcher.find())
      {
        String str2 = resolveKey(localMatcher.group(1), paramMap);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localMatcher.appendReplacement(localStringBuffer, str1);
      }
      localMatcher.appendTail(localStringBuffer);
    }
    catch (Exception paramMap)
    {
      AliSDKLogger.e("ELResolver", "Fail to parse the " + paramString, paramMap);
      return "";
    }
    paramMap = localStringBuffer.toString();
    return paramMap;
  }
  
  public static String resolveKey(String paramString, Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get(paramString);
    if (paramMap != null) {}
    String str;
    do
    {
      do
      {
        return paramMap;
        if ("ttid".equals(paramString)) {
          return TraceHelper.webTTID;
        }
        if ("appKey".equals(paramString)) {
          return SystemContext.appContext.getAppKey();
        }
        if ("sdkVersion".equals(paramString)) {
          return ConfigManager.SDK_INTERNAL_VERSION;
        }
        if ("timestamp".equals(paramString)) {
          return String.valueOf(System.currentTimeMillis());
        }
        if ("utdid".equals(paramString)) {
          return SystemContext.appContext.getUserTrackerId();
        }
        paramMap = (ELResolverProvider)SystemContext.appContext.getService(ELResolverProvider.class, Collections.singletonMap("key", paramString));
        if (paramMap == null) {
          break;
        }
        str = paramMap.getValue(paramString);
        paramMap = str;
      } while (str != null);
      int i = paramString.indexOf(".");
      if ((i == -1) || (i + 1 >= paramString.length())) {
        break;
      }
      str = AlibabaSDK.getProperty(paramString.substring(0, i), paramString.substring(i + 1));
      paramMap = str;
    } while (str != null);
    return AlibabaSDK.getGlobalProperty(paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\el\ELResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */