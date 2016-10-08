package com.taobao.dp.c;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class f
{
  private static String a(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    try
    {
      paramDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate) {}
    return null;
  }
  
  public static Map a(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    HashMap localHashMap = new HashMap();
    Method[] arrayOfMethod = localClass.getDeclaredMethods();
    Field[] arrayOfField = localClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j) {
        localField = arrayOfField[i];
      }
      try
      {
        String str = localField.getType().getSimpleName();
        Object localObject = localField.getName();
        if (localObject != null) {
          if ("".equals(localObject)) {
            break label193;
          }
        }
        for (;;)
        {
          if (!a(arrayOfMethod, (String)localObject))
          {
            break;
            localObject = "get" + ((String)localObject).substring(0, 1).toUpperCase() + ((String)localObject).substring(1);
          }
          else
          {
            localObject = localClass.getMethod((String)localObject, new Class[0]).invoke(paramObject, new Object[0]);
            if ("Date".equals(str)) {}
            for (localObject = a((Date)localObject);; localObject = String.valueOf(localObject))
            {
              localHashMap.put(localField.getName(), localObject);
              break;
              if (localObject == null) {
                break;
              }
            }
            return localHashMap;
            label193:
            localObject = null;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      i += 1;
    }
  }
  
  private static boolean a(Method[] paramArrayOfMethod, String paramString)
  {
    boolean bool2 = false;
    int j = paramArrayOfMethod.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.equals(paramArrayOfMethod[i].getName())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */