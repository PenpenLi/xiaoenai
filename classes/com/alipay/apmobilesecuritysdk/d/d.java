package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class d
{
  private static Map<String, String> a = null;
  private static Map<String, String> b = null;
  
  private static String a(Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      paramMap = null;
      return paramMap;
    }
    for (;;)
    {
      int i;
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        ArrayList localArrayList = new ArrayList(paramMap.keySet());
        Collections.sort(localArrayList);
        i = 0;
        if (i < localArrayList.size())
        {
          String str2 = (String)localArrayList.get(i);
          if ((str2 == null) || (!str2.equals("AC3")))
          {
            String str3 = (String)paramMap.get(str2);
            StringBuilder localStringBuilder = new StringBuilder();
            if (i != 0) {
              break label167;
            }
            str1 = "";
            localStringBuffer.append(str1 + str2 + "=" + str3);
          }
        }
        else
        {
          paramMap = localStringBuffer.toString();
          break;
        }
      }
      finally {}
      i += 1;
      continue;
      label167:
      String str1 = "&";
    }
  }
  
  public static Map<String, String> a(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      if (a == null) {
        c(paramContext, paramMap);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      a = null;
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String b(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      a(paramContext, paramMap);
      paramContext = com.alipay.security.mobile.module.a.a.b.a(a(a));
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void c(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      b = new TreeMap();
      a = new TreeMap();
      b.putAll(b.a(paramContext, paramMap));
      b.putAll(c.a(paramContext));
      paramMap = b;
      com.alipay.security.mobile.module.b.a locala = com.alipay.security.mobile.module.b.a.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("AD1", com.alipay.security.mobile.module.b.a.a(paramContext));
      localHashMap.put("AD2", com.alipay.security.mobile.module.b.a.b(paramContext));
      localHashMap.put("AD3", com.alipay.security.mobile.module.b.a.d(paramContext));
      localHashMap.put("AD5", com.alipay.security.mobile.module.b.a.e(paramContext));
      localHashMap.put("AD6", com.alipay.security.mobile.module.b.a.f(paramContext));
      localHashMap.put("AD7", com.alipay.security.mobile.module.b.a.g(paramContext));
      localHashMap.put("AD8", com.alipay.security.mobile.module.b.a.h(paramContext));
      localHashMap.put("AD9", com.alipay.security.mobile.module.b.a.i(paramContext));
      localHashMap.put("AD10", com.alipay.security.mobile.module.b.a.j(paramContext));
      localHashMap.put("AD11", com.alipay.security.mobile.module.b.a.b());
      localHashMap.put("AD12", locala.c());
      localHashMap.put("AD13", com.alipay.security.mobile.module.b.a.d());
      localHashMap.put("AD14", com.alipay.security.mobile.module.b.a.e());
      localHashMap.put("AD15", com.alipay.security.mobile.module.b.a.f());
      localHashMap.put("AD16", com.alipay.security.mobile.module.b.a.g());
      localHashMap.put("AD17", "");
      localHashMap.put("AD18", com.alipay.security.mobile.module.b.a.h());
      localHashMap.put("AD19", com.alipay.security.mobile.module.b.a.k(paramContext));
      localHashMap.put("AD20", com.alipay.security.mobile.module.b.a.i());
      localHashMap.put("AD21", com.alipay.security.mobile.module.b.a.c(paramContext));
      localHashMap.put("AD22", locala.n(paramContext));
      paramMap.putAll(localHashMap);
      a.putAll(b);
      a.putAll(a.a(paramContext));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */