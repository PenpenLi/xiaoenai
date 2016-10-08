package com.alipay.apmobilesecuritysdk.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static Map<String, String> a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      HashMap localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, (String)paramString.get(str));
      }
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      return null;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */