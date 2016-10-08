package com.alibaba.sdk.android.system.util;

import com.alibaba.sdk.android.session.model.InternalSession;
import com.alibaba.sdk.android.session.model.RefreshToken;
import com.alibaba.sdk.android.session.model.User;
import com.alibaba.sdk.android.util.JSONUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SystemUtils
{
  public static InternalSession toInternalSession(String paramString)
  {
    localInternalSession = new InternalSession();
    try
    {
      paramString = new JSONObject(paramString);
      localInternalSession.createTime = JSONUtils.optLong(paramString, "createTime");
      localInternalSession.expireIn = JSONUtils.optInteger(paramString, "expireIn");
      localInternalSession.sid = JSONUtils.optString(paramString, "sid");
      Object localObject1 = paramString.optJSONObject("user");
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = new User();
        localInternalSession.user = ((User)localObject2);
        ((User)localObject2).avatarUrl = JSONUtils.optString((JSONObject)localObject1, "avatarUrl");
        ((User)localObject2).id = JSONUtils.optString((JSONObject)localObject1, "id");
        ((User)localObject2).nick = JSONUtils.optString((JSONObject)localObject1, "nick");
      }
      localObject1 = paramString.optJSONObject("otherInfo");
      if (localObject1 != null) {
        localInternalSession.otherInfo = JSONUtils.toMap((JSONObject)localObject1);
      }
      paramString = paramString.optJSONObject("cookies");
      if (paramString != null)
      {
        localInternalSession.cookies = new HashMap();
        localObject1 = paramString.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          JSONArray localJSONArray = paramString.optJSONArray((String)localObject2);
          if (localJSONArray != null) {
            localInternalSession.cookies.put(localObject2, JSONUtils.toStringArray(localJSONArray));
          }
        }
      }
      return localInternalSession;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String toInternalSessionJSON(InternalSession paramInternalSession)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("createTime", paramInternalSession.createTime);
      localJSONObject1.put("expireIn", paramInternalSession.expireIn);
      localJSONObject1.put("sid", paramInternalSession.sid);
      User localUser = paramInternalSession.user;
      if (localUser != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("avatarUrl", localUser.avatarUrl);
        localJSONObject2.put("id", localUser.id);
        localJSONObject2.put("nick", localUser.nick);
        localJSONObject1.put("user", localJSONObject2);
      }
      if (paramInternalSession.otherInfo != null) {
        localJSONObject1.put("otherInfo", JSONUtils.toJsonObject(paramInternalSession.otherInfo));
      }
      if (paramInternalSession.cookies != null) {
        localJSONObject1.put("cookies", JSONUtils.toJsonObject(paramInternalSession.cookies));
      }
      return localJSONObject1.toString();
    }
    catch (JSONException paramInternalSession)
    {
      throw new RuntimeException(paramInternalSession);
    }
  }
  
  public static RefreshToken toRefreshToken(String paramString)
  {
    RefreshToken localRefreshToken = new RefreshToken();
    try
    {
      paramString = new JSONObject(paramString);
      localRefreshToken.createTime = JSONUtils.optLong(paramString, "createTime");
      localRefreshToken.expireIn = JSONUtils.optInteger(paramString, "expireIn");
      localRefreshToken.token = JSONUtils.optString(paramString, "token");
      return localRefreshToken;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String toRefreshTokenJSON(RefreshToken paramRefreshToken)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("createTime", paramRefreshToken.createTime);
      localJSONObject.put("expireIn", paramRefreshToken.expireIn);
      localJSONObject.put("token", paramRefreshToken.token);
      return localJSONObject.toString();
    }
    catch (JSONException paramRefreshToken)
    {
      throw new RuntimeException(paramRefreshToken);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\system\util\SystemUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */