package com.alibaba.sdk.android.ui.util;

import android.text.TextUtils;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.security.SecurityGuardService;
import com.alibaba.sdk.android.session.SessionService;
import com.alibaba.sdk.android.session.impl.SessionServiceImpl;
import com.alibaba.sdk.android.ui.UIContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class SignUtil
{
  private static final String URL_SID = "__sid";
  private static final String URL_SIGN = "__sign";
  private static final String URL_SIGN_KEY = "__url";
  private static final String URL_TIMESTAMP = "__timestamp";
  
  public static String sign(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    SessionService localSessionService = (SessionService)UIContext.appContext.getService(SessionService.class);
    if (localSessionService != null) {
      localStringBuilder.append(paramString).append((String)localSessionService.getSId().data);
    }
    return UIContext.securityGuardService.sign(localStringBuilder.toString());
  }
  
  public static String sign(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf("?");
    char c;
    Object localObject;
    if (i == -1)
    {
      c = '?';
      localObject = null;
    }
    TreeMap localTreeMap;
    for (String str = paramString;; str = paramString.substring(0, i))
    {
      localTreeMap = new TreeMap();
      if (paramMap != null) {
        localTreeMap.putAll(paramMap);
      }
      if (localObject == null) {
        break;
      }
      paramMap = ((String)localObject).split("&");
      int j = paramMap.length;
      i = 0;
      while (i < j)
      {
        localObject = paramMap[i].split("=");
        localTreeMap.put(localObject[0], localObject[1]);
        i += 1;
      }
      c = '&';
      localObject = paramString.substring(i + 1);
    }
    localTreeMap.put("__url", str);
    localTreeMap.put("__sid", SessionServiceImpl.INSTANCE.getSId().data);
    localTreeMap.put("__timestamp", System.currentTimeMillis() + "");
    if (paramBoolean)
    {
      paramString = new HashMap();
      paramString.put("__sid", localTreeMap.get("__sid"));
      paramString.put("__timestamp", localTreeMap.get("__timestamp"));
      paramString.put("__sign", sign(localTreeMap));
      return new JSONObject(paramString).toString();
    }
    return paramString + c + "__sid" + "=" + (String)localTreeMap.get("__sid") + "&" + "__timestamp" + "=" + (String)localTreeMap.get("__timestamp") + "&" + "__sign" + "=" + sign(localTreeMap);
  }
  
  private static String sign(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append((String)localEntry.getKey()).append((String)localEntry.getValue());
    }
    return UIContext.securityGuardService.sign(localStringBuilder.toString());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\util\SignUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */