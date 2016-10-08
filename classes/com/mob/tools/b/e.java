package com.mob.tools.b;

import android.text.TextUtils;
import com.mob.tools.log.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
{
  private ArrayList<Object> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    if (i < j)
    {
      Object localObject2 = paramJSONArray.opt(i);
      Object localObject1;
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = a((JSONObject)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = a((JSONArray)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private HashMap<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.opt(str);
      Object localObject1 = localObject2;
      if (JSONObject.NULL.equals(localObject2)) {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ((localObject1 instanceof JSONObject)) {
          localObject2 = a((JSONObject)localObject1);
        }
        for (;;)
        {
          localHashMap.put(str, localObject2);
          break;
          localObject2 = localObject1;
          if ((localObject1 instanceof JSONArray)) {
            localObject2 = a((JSONArray)localObject1);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private JSONArray a(ArrayList<Object> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof HashMap)) {
        paramArrayList = b((HashMap)localObject);
      }
      for (;;)
      {
        localJSONArray.put(paramArrayList);
        break;
        paramArrayList = (ArrayList<Object>)localObject;
        if ((localObject instanceof ArrayList)) {
          paramArrayList = a((ArrayList)localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private boolean a(Object paramObject)
  {
    return ((paramObject instanceof byte[])) || ((paramObject instanceof short[])) || ((paramObject instanceof int[])) || ((paramObject instanceof long[])) || ((paramObject instanceof float[])) || ((paramObject instanceof double[])) || ((paramObject instanceof char[])) || ((paramObject instanceof boolean[])) || ((paramObject instanceof String[]));
  }
  
  private ArrayList<?> b(Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i = 0;
    ArrayList localArrayList;
    Object localObject;
    if ((paramObject instanceof byte[]))
    {
      localArrayList = new ArrayList();
      localObject = (byte[])paramObject;
      j = localObject.length;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Byte.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof short[]))
    {
      localArrayList = new ArrayList();
      localObject = (short[])paramObject;
      k = localObject.length;
      i = j;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= k) {
          break;
        }
        localArrayList.add(Short.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      localArrayList = new ArrayList();
      localObject = (int[])paramObject;
      j = localObject.length;
      i = k;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Integer.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof long[]))
    {
      localArrayList = new ArrayList();
      localObject = (long[])paramObject;
      j = localObject.length;
      i = m;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Long.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      localArrayList = new ArrayList();
      localObject = (float[])paramObject;
      j = localObject.length;
      i = n;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Float.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      localArrayList = new ArrayList();
      localObject = (double[])paramObject;
      j = localObject.length;
      i = i1;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Double.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof char[]))
    {
      localArrayList = new ArrayList();
      localObject = (char[])paramObject;
      j = localObject.length;
      i = i2;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Character.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      localArrayList = new ArrayList();
      localObject = (boolean[])paramObject;
      j = localObject.length;
      i = i3;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Boolean.valueOf(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof String[]))
    {
      localArrayList = new ArrayList();
      localObject = (String[])paramObject;
      j = localObject.length;
      i = i4;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(localObject[i]);
        i += 1;
      }
    }
    paramObject = null;
    return (ArrayList<?>)paramObject;
  }
  
  private JSONObject b(HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof HashMap)) {
        paramHashMap = b((HashMap)localObject);
      }
      for (;;)
      {
        localJSONObject.put((String)localEntry.getKey(), paramHashMap);
        break;
        if ((localObject instanceof ArrayList))
        {
          paramHashMap = a((ArrayList)localObject);
        }
        else
        {
          paramHashMap = (HashMap<String, Object>)localObject;
          if (a(localObject)) {
            paramHashMap = a(b(localObject));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  public String a(HashMap<String, Object> paramHashMap)
  {
    try
    {
      paramHashMap = b(paramHashMap);
      if (paramHashMap == null) {
        return "";
      }
      paramHashMap = paramHashMap.toString();
      return paramHashMap;
    }
    catch (Throwable paramHashMap)
    {
      com.mob.tools.e.a().w(paramHashMap);
    }
    return "";
  }
  
  public HashMap<String, Object> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap();
    }
    String str1 = paramString;
    String str2 = paramString;
    try
    {
      if (paramString.startsWith("["))
      {
        str1 = paramString;
        str2 = paramString;
        if (paramString.endsWith("]"))
        {
          str2 = paramString;
          str1 = "{\"fakelist\":" + paramString + "}";
        }
      }
      str2 = str1;
      paramString = a(new JSONObject(str1));
      return paramString;
    }
    catch (Throwable paramString)
    {
      com.mob.tools.e.a().w(str2, new Object[0]);
      com.mob.tools.e.a().w(paramString);
    }
    return new HashMap();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\mob\tools\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */