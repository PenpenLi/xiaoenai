package com.alibaba.sdk.android.security.utils;

import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.security.impl.CertificateManager;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.HttpHelper;
import com.alibaba.sdk.android.util.JSONUtils;
import java.util.Map;

public class SecurityUtils
{
  private static final String TAG = SecurityUtils.class.getSimpleName();
  
  public static Result<String> requestInitServer(Map<String, String> paramMap, String paramString)
  {
    paramMap.put("certName", "201506");
    Result localResult = JSONUtils.toStringResult(HttpHelper.post(paramMap, paramString));
    Object localObject = localResult;
    if (localResult.code == 203)
    {
      CertificateManager.INSTANCE.refreshCer();
      paramString = HttpHelper.post(paramMap, paramString);
      paramMap = JSONUtils.toStringResult(paramString);
      localObject = paramMap;
      if (AliSDKLogger.isDebugEnabled())
      {
        AliSDKLogger.d(TAG, "request init server after cer invalid, response: " + paramString);
        localObject = paramMap;
      }
    }
    return (Result<String>)localObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\utils\SecurityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */