package com.alibaba.sdk.android.login.utils;

import android.text.TextUtils;
import com.alibaba.sdk.android.model.Result;
import com.alibaba.sdk.android.session.model.LoginResultData;
import com.alibaba.sdk.android.util.JSONUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginUtils
{
  public static Result<LoginResultData> toLoginResultData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Result localResult = new Result();
    JSONArray localJSONArray;
    try
    {
      paramString = new JSONObject(paramString);
      localResult.code = paramString.optInt("code");
      localResult.message = JSONUtils.optString(paramString, "message");
      paramString = paramString.optJSONObject("data");
      if (paramString == null) {
        return localResult;
      }
      LoginResultData localLoginResultData = new LoginResultData();
      localResult.data = localLoginResultData;
      localLoginResultData.avatarUrl = JSONUtils.optString(paramString, "avatarUrl");
      localLoginResultData.openId = JSONUtils.optString(paramString, "openId");
      localLoginResultData.refreshToken = JSONUtils.optString(paramString, "refreshToken");
      localLoginResultData.refreshTokenExpireTime = JSONUtils.optInteger(paramString, "refreshTokenExpireTime");
      localLoginResultData.sessionExpireTime = JSONUtils.optInteger(paramString, "sessionExpireTime");
      localLoginResultData.taobaoNick = JSONUtils.optString(paramString, "taobaoNick");
      localLoginResultData.tempLoginToken = JSONUtils.optString(paramString, "tempLoginToken");
      localLoginResultData.authCode = JSONUtils.optString(paramString, "authCode");
      localLoginResultData.cookiesMap = new LinkedHashMap();
      JSONObject localJSONObject = paramString.optJSONObject("cookiesMap");
      if (localJSONObject == null) {
        return localResult;
      }
      Iterator localIterator = localJSONObject.keys();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return localResult;
        }
        String str = (String)localIterator.next();
        localJSONArray = localJSONObject.optJSONArray(str);
        if (localJSONArray != null) {
          break;
        }
        paramString = new String[0];
        localLoginResultData.cookiesMap.put(str, paramString);
      }
      arrayOfString = new String[localJSONArray.length()];
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
    String[] arrayOfString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = arrayOfString;
      if (i >= j) {
        break;
      }
      arrayOfString[i] = localJSONArray.getString(i);
      i += 1;
    }
    return localResult;
  }
  
  public static String urlParamsFormat(String paramString)
  {
    if (StringUtil.isBlank(paramString)) {
      return "";
    }
    localStringBuilder = new StringBuilder("");
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = ((String)localIterator.next()).toString();
        if ((!StringUtil.isBlank(str)) && (!StringUtil.isBlank(paramString.getString(str))))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(str);
          localStringBuilder.append("=");
          localStringBuilder.append(paramString.getString(str));
        }
      }
      return localStringBuilder.toString();
    }
    catch (JSONException paramString) {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\utils\LoginUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */