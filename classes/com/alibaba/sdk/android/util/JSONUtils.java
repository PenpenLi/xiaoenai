package com.alibaba.sdk.android.util;

import android.util.Base64;
import com.alibaba.sdk.android.model.Result;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils
{
  public static Boolean optBoolean(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {}
    for (boolean bool = paramJSONObject.optBoolean(paramString);; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static Integer optInteger(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return Integer.valueOf(paramJSONObject.optInt(paramString));
    }
    return null;
  }
  
  public static Long optLong(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return Long.valueOf(paramJSONObject.optLong(paramString));
    }
    return null;
  }
  
  public static String optString(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return paramJSONObject.optString(paramString);
    }
    return null;
  }
  
  public static <T> T parseStringValue(String paramString, Class<T> paramClass)
  {
    int j = 0;
    int i = 0;
    Object localObject;
    if ((paramString == null) || (paramClass == null)) {
      localObject = null;
    }
    do
    {
      do
      {
        return (T)localObject;
        localObject = paramString;
      } while (String.class.equals(paramClass));
      if ((Short.TYPE.equals(paramClass)) || (Short.class.equals(paramClass))) {
        return Short.valueOf(paramString);
      }
      if ((Integer.TYPE.equals(paramClass)) || (Integer.class.equals(paramClass))) {
        return Integer.valueOf(paramString);
      }
      if ((Long.TYPE.equals(paramClass)) || (Long.class.equals(paramClass))) {
        return Long.valueOf(paramString);
      }
      if ((Boolean.TYPE.equals(paramClass)) || (Boolean.class.equals(paramClass))) {
        return Boolean.valueOf(paramString);
      }
      if ((Float.TYPE.equals(paramClass)) || (Float.class.equals(paramClass))) {
        return Float.valueOf(paramString);
      }
      if ((Double.TYPE.equals(paramClass)) || (Double.class.equals(paramClass))) {
        return Double.valueOf(paramString);
      }
      if ((Byte.TYPE.equals(paramClass)) || (Byte.class.equals(paramClass))) {
        return Byte.valueOf(paramString);
      }
      if ((Character.TYPE.equals(paramClass)) || (Character.class.equals(paramClass))) {
        return Character.valueOf(paramString.charAt(0));
      }
      if (Date.class.isAssignableFrom(paramClass)) {
        try
        {
          paramString = new SimpleDateFormat("yyyyMMddHHmmssSSSZ", Locale.US).parse(paramString);
          return paramString;
        }
        catch (ParseException paramString)
        {
          throw new RuntimeException("Parse Date error", paramString);
        }
      }
      int k = paramString.charAt(0);
      if (paramClass.isArray())
      {
        paramClass = paramClass.getComponentType();
        if (k == 91) {
          try
          {
            paramString = toPOJOArray(new JSONArray(paramString), paramClass);
            return paramString;
          }
          catch (Exception paramString)
          {
            throw new RuntimeException(paramString);
          }
        }
        if (String.class.equals(paramClass)) {
          return paramString.split(",");
        }
        if (Character.TYPE.equals(paramClass)) {
          return paramString.toCharArray();
        }
        if (Character.class.equals(paramClass))
        {
          paramClass = paramString.toCharArray();
          paramString = new Character[paramClass.length];
          for (;;)
          {
            localObject = paramString;
            if (i >= paramString.length) {
              break;
            }
            paramString[i] = Character.valueOf(paramClass[i]);
            i += 1;
          }
        }
        if (Byte.TYPE.equals(paramClass)) {
          return Base64.decode(paramString, 0);
        }
        if (Byte.class.equals(paramClass))
        {
          paramClass = Base64.decode(paramString, 0);
          paramString = new Byte[paramClass.length];
          i = j;
          for (;;)
          {
            localObject = paramString;
            if (i >= paramString.length) {
              break;
            }
            paramString[i] = Byte.valueOf(paramClass[i]);
            i += 1;
          }
        }
        return null;
      }
      if (k == 123) {
        try
        {
          paramString = new JSONObject(paramString);
          if (Map.class.isAssignableFrom(paramClass)) {
            return toMap(paramString);
          }
          paramString = toPOJO(paramString, paramClass);
          return paramString;
        }
        catch (Exception paramString)
        {
          throw new RuntimeException(paramString);
        }
      }
      localObject = paramString;
    } while (paramClass.isAssignableFrom(String.class));
    return null;
  }
  
  public static String toJSONString(Result<String> paramResult)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", paramResult.code);
      localJSONObject.put("message", paramResult.message);
      localJSONObject.put("data", paramResult.data);
      return localJSONObject.toString();
    }
    catch (JSONException paramResult)
    {
      throw new RuntimeException(paramResult);
    }
  }
  
  public static String toJson(Map<String, Object> paramMap)
  {
    return toJsonObject(paramMap).toString();
  }
  
  public static JSONArray toJsonArray(List<Object> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof Map)) {
        localJSONArray.put(toJsonObject((Map)localObject));
      } else {
        localJSONArray.put(localObject);
      }
    }
    return localJSONArray;
  }
  
  public static JSONArray toJsonArray(Object[] paramArrayOfObject)
  {
    JSONArray localJSONArray = new JSONArray();
    int j = paramArrayOfObject.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof Map)) {
        localJSONArray.put(toJsonObject((Map)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        localJSONArray.put(localObject);
      }
    }
    return localJSONArray;
  }
  
  public static JSONObject toJsonObject(Map<String, ? extends Object> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      Map.Entry localEntry;
      Object localObject;
      try
      {
        paramMap = paramMap.entrySet().iterator();
        if (!paramMap.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)paramMap.next();
        localObject = localEntry.getValue();
        if (localObject == null) {
          continue;
        }
        if ((localObject instanceof Map))
        {
          localJSONObject.put((String)localEntry.getKey(), toJsonObject((Map)localObject));
          continue;
        }
        if (!(localObject instanceof List)) {
          break label122;
        }
      }
      catch (JSONException paramMap)
      {
        throw new RuntimeException(paramMap);
      }
      localJSONObject.put((String)localEntry.getKey(), toJsonArray((List)localObject));
      continue;
      label122:
      if (localObject.getClass().isArray()) {
        localJSONObject.put((String)localEntry.getKey(), toJsonArray((Object[])localObject));
      } else {
        localJSONObject.put((String)localEntry.getKey(), localObject);
      }
    }
    return localJSONObject;
  }
  
  public static List<Object> toList(JSONArray paramJSONArray)
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
        localArrayList.add(toMap((JSONObject)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof JSONArray)) {
          localArrayList.add(toList((JSONArray)localObject));
        } else {
          localArrayList.add(paramJSONArray.get(i));
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, Object> toMap(JSONObject paramJSONObject)
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
        localHashMap.put(str, toMap((JSONObject)localObject));
      } else if ((localObject instanceof JSONArray)) {
        localHashMap.put(str, toList((JSONArray)localObject));
      } else {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  public static <T> T toPOJO(JSONObject paramJSONObject, Class<T> paramClass)
  {
    if ((paramJSONObject == null) || (paramClass == null) || (paramClass == Void.TYPE))
    {
      paramClass = null;
      return paramClass;
    }
    Object localObject;
    int i;
    Field localField;
    String str;
    for (;;)
    {
      try
      {
        localObject = paramClass.newInstance();
        Field[] arrayOfField = paramClass.getFields();
        int j = arrayOfField.length;
        i = 0;
        paramClass = (Class<T>)localObject;
        if (i >= j) {
          break;
        }
        localField = arrayOfField[i];
        paramClass = localField.getType();
        str = localField.getName();
        if (!paramJSONObject.has(str)) {
          break label420;
        }
        if (paramClass.isPrimitive()) {
          break label219;
        }
        if (paramClass == String.class)
        {
          paramClass = paramJSONObject.getString(str);
          localField.set(localObject, paramClass);
        }
      }
      catch (Exception paramJSONObject)
      {
        throw new RuntimeException(paramJSONObject);
      }
      if ((paramClass == Boolean.class) || (paramClass == Integer.class) || (paramClass == Short.class) || (paramClass == Long.class) || (paramClass == Double.class)) {
        paramClass = paramJSONObject.get(str);
      } else if (paramClass.isArray()) {
        paramClass = toPOJOArray(paramJSONObject.getJSONArray(str), paramClass.getComponentType());
      } else if (Map.class.isAssignableFrom(paramClass)) {
        paramClass = toMap(paramJSONObject.getJSONObject(str));
      } else {
        paramClass = toPOJO(paramJSONObject.getJSONObject(str), paramClass);
      }
    }
    label219:
    if (paramClass == Boolean.TYPE)
    {
      localField.setBoolean(localObject, paramJSONObject.getBoolean(str));
    }
    else if (paramClass == Byte.TYPE)
    {
      localField.setByte(localObject, (byte)paramJSONObject.getInt(str));
    }
    else if (paramClass == Character.TYPE)
    {
      paramClass = paramJSONObject.getString(str);
      if (paramClass == null) {
        break label429;
      }
      if (paramClass.length() == 0) {
        break label429;
      }
    }
    for (;;)
    {
      localField.setChar(localObject, c);
      break label420;
      char c = paramClass.charAt(0);
      continue;
      if (paramClass == Short.TYPE) {
        localField.setShort(localObject, (short)paramJSONObject.getInt(str));
      } else if (paramClass == Integer.TYPE) {
        localField.setInt(localObject, paramJSONObject.getInt(str));
      } else if (paramClass == Long.TYPE) {
        localField.setLong(localObject, paramJSONObject.getLong(str));
      } else if (paramClass == Float.TYPE) {
        localField.setFloat(localObject, (float)paramJSONObject.getDouble(str));
      } else if (paramClass == Double.TYPE) {
        localField.setDouble(localObject, paramJSONObject.getDouble(str));
      }
      label420:
      i += 1;
      break;
      label429:
      c = '\000';
    }
  }
  
  public static <T> T[] toPOJOArray(JSONArray paramJSONArray, Class<T> paramClass)
  {
    if ((paramJSONArray == null) || (paramClass == null) || (paramClass == Void.TYPE)) {
      return null;
    }
    Object localObject2 = Array.newInstance(paramClass, paramJSONArray.length());
    int i = 0;
    Object localObject1;
    try
    {
      if (i >= paramJSONArray.length()) {
        break label362;
      }
      if (!paramClass.isPrimitive())
      {
        if (paramClass != String.class) {
          break label380;
        }
        localObject1 = paramJSONArray.getString(i);
        for (;;)
        {
          Array.set(localObject2, i, localObject1);
          break;
          label70:
          localObject1 = paramJSONArray.get(i);
          continue;
          label80:
          if (paramClass.isArray()) {
            localObject1 = toPOJOArray(paramJSONArray.getJSONArray(i), paramClass.getComponentType());
          } else if (Map.class.isAssignableFrom(paramClass)) {
            localObject1 = toMap(paramJSONArray.getJSONObject(i));
          } else {
            localObject1 = toPOJO(paramJSONArray.getJSONObject(i), paramClass);
          }
        }
      }
      if (paramClass == Boolean.TYPE) {
        Array.setBoolean(localObject2, i, paramJSONArray.getBoolean(i));
      }
    }
    catch (JSONException paramJSONArray)
    {
      throw new RuntimeException(paramJSONArray);
    }
    if (paramClass == Byte.TYPE)
    {
      Array.setByte(localObject2, i, (byte)paramJSONArray.getInt(i));
    }
    else if (paramClass == Character.TYPE)
    {
      localObject1 = paramJSONArray.getString(i);
      if (localObject1 == null) {
        break label413;
      }
      if (((String)localObject1).length() == 0) {
        break label413;
      }
    }
    for (;;)
    {
      Array.setChar(localObject2, i, c);
      break label371;
      char c = ((String)localObject1).charAt(0);
      continue;
      if (paramClass == Short.TYPE)
      {
        Array.setShort(localObject2, i, (short)paramJSONArray.getInt(i));
      }
      else if (paramClass == Integer.TYPE)
      {
        Array.setInt(localObject2, i, paramJSONArray.getInt(i));
      }
      else if (paramClass == Long.TYPE)
      {
        Array.setLong(localObject2, i, paramJSONArray.getLong(i));
      }
      else if (paramClass == Float.TYPE)
      {
        Array.setFloat(localObject2, i, (float)paramJSONArray.getDouble(i));
      }
      else if (paramClass == Double.TYPE)
      {
        Array.setDouble(localObject2, i, paramJSONArray.getDouble(i));
        break label371;
        label362:
        return (Object[])localObject2;
      }
      label371:
      i += 1;
      break;
      label380:
      if ((paramClass == Boolean.class) || (paramClass == Integer.class) || (paramClass == Short.class) || (paramClass == Long.class)) {
        break label70;
      }
      if (paramClass != Double.class) {
        break label80;
      }
      break label70;
      label413:
      c = '\000';
    }
  }
  
  public static String[] toStringArray(JSONArray paramJSONArray)
  {
    int i = 0;
    Object localObject;
    if (paramJSONArray == null)
    {
      localObject = new String[0];
      return (String[])localObject;
    }
    String[] arrayOfString = new String[paramJSONArray.length()];
    int j = paramJSONArray.length();
    for (;;)
    {
      localObject = arrayOfString;
      if (i >= j) {
        break;
      }
      arrayOfString[i] = paramJSONArray.optString(i);
      i += 1;
    }
  }
  
  public static Result<String> toStringResult(String paramString)
  {
    Result localResult = new Result();
    try
    {
      paramString = new JSONObject(paramString);
      localResult.code = paramString.optInt("code");
      localResult.data = optString(paramString, "data");
      localResult.message = optString(paramString, "message");
      return localResult;
    }
    catch (JSONException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\JSONUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */