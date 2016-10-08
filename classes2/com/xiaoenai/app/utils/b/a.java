package com.xiaoenai.app.utils.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.mzd.crypto.CryptoJNI;

public final class a
{
  public static String a(String paramString)
  {
    return CryptoJNI.encryptToServer(paramString);
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    String str = "";
    if (paramJSONObject != null) {}
    try
    {
      if (!paramJSONObject.has("ver")) {
        paramJSONObject.put("ver", "1.0");
      }
      str = CryptoJNI.decryptFromJson(paramJSONObject.toString());
      return str;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    return CryptoJNI.encryptToLocal(paramString);
  }
  
  public static JSONObject b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if (!paramJSONObject.has("ver")) {
          paramJSONObject.put("ver", "1.0");
        }
        paramJSONObject = new JSONObject(CryptoJNI.decryptFromJson(paramJSONObject.toString()));
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    String str = "";
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("ver")) {
        paramString.put("ver", "1.0");
      }
      str = CryptoJNI.decryptFromJson(paramString.toString());
      return str;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramString != null)
    {
      localObject2 = localObject3;
      if (paramString.startsWith("{\"data\":"))
      {
        localObject2 = localObject3;
        if (!paramString.endsWith("}")) {}
      }
    }
    try
    {
      localJSONObject = new JSONObject(paramString);
      localObject2 = localObject3;
      if (localJSONObject != null)
      {
        localObject2 = localObject3;
        if (localJSONObject.has("data"))
        {
          localObject2 = localObject3;
          if (!localJSONObject.has("ver")) {}
        }
      }
    }
    catch (JSONException localJSONException)
    {
      try
      {
        JSONObject localJSONObject;
        localObject2 = a(localJSONObject);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          return paramString;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
          Object localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
        }
      }
    }
    return (String)localObject2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */