package com.alibaba.nb.android.trade.utils.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static com.alibaba.nb.android.trade.model.inner.a<String> a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    com.alibaba.nb.android.trade.model.inner.a locala = new com.alibaba.nb.android.trade.model.inner.a();
    try
    {
      paramString = new JSONObject(paramString);
      locala.a = paramString.optInt("code");
      locala.c = a(paramString, "data");
      locala.b = a(paramString, "message");
      return locala;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String a(String paramString, Object paramObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static String a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return paramJSONObject.optString(paramString);
    }
    return null;
  }
  
  private static List<Object> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject = paramJSONArray.get(i);
      if ((localObject instanceof JSONObject)) {
        localArrayList.add(a((JSONObject)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof JSONArray)) {
          localArrayList.add(a((JSONArray)localObject));
        } else {
          localArrayList.add(paramJSONArray.get(i));
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      if ((localObject instanceof JSONObject)) {
        localHashMap.put(str, a((JSONObject)localObject));
      } else if ((localObject instanceof JSONArray)) {
        localHashMap.put(str, a((JSONArray)localObject));
      } else {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */