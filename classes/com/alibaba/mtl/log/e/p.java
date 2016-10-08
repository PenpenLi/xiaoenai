package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p
{
  public static Map<String, String> b(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap != null)
    {
      localObject = new HashMap();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if ((str1 instanceof String))
        {
          String str2 = (String)paramMap.get(str1);
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            try
            {
              ((Map)localObject).put(URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              localUnsupportedEncodingException.printStackTrace();
            }
          }
        }
      }
    }
    return (Map<String, String>)localObject;
  }
  
  public static String c(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = paramMap.keySet().iterator();
      int i = 1;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = convertObjectToString(paramMap.get(str2));
        str2 = convertObjectToString(str2);
        if ((str1 != null) && (str2 != null)) {
          if (i != 0)
          {
            localStringBuffer.append(str2 + "=" + str1);
            i = 0;
          }
        }
        for (;;)
        {
          break;
          localStringBuffer.append(",").append(str2 + "=" + str1);
        }
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  public static String convertObjectToString(Object paramObject)
  {
    if (paramObject != null)
    {
      if ((paramObject instanceof String)) {
        return ((String)paramObject).toString();
      }
      if ((paramObject instanceof Integer)) {
        return "" + ((Integer)paramObject).intValue();
      }
      if ((paramObject instanceof Long)) {
        return "" + ((Long)paramObject).longValue();
      }
      if ((paramObject instanceof Double)) {
        return "" + ((Double)paramObject).doubleValue();
      }
      if ((paramObject instanceof Float)) {
        return "" + ((Float)paramObject).floatValue();
      }
      if ((paramObject instanceof Short)) {
        return "" + ((Short)paramObject).shortValue();
      }
      if ((paramObject instanceof Byte)) {
        return "" + ((Byte)paramObject).byteValue();
      }
      if ((paramObject instanceof Boolean)) {
        return ((Boolean)paramObject).toString();
      }
      if ((paramObject instanceof Character)) {
        return ((Character)paramObject).toString();
      }
      return paramObject.toString();
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */