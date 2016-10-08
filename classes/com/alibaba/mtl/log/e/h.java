package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class h
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put(LogField.PAGE.toString(), paramString1);
    }
    localHashMap.put(LogField.EVENTID.toString(), paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put(LogField.ARG1.toString(), paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put(LogField.ARG2.toString(), paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put(LogField.ARG3.toString(), paramString5);
    }
    if (!TextUtils.isEmpty(paramString7)) {
      localHashMap.put(LogField.RECORD_TIMESTAMP.toString(), paramString7);
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localHashMap.put(LogField.RESERVE3.toString(), paramString6);
    }
    return b(localHashMap);
  }
  
  public static String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = LogField.values();
    int j = localObject.length;
    int i = 0;
    String str2;
    String str1;
    if (i < j)
    {
      str2 = localObject[i];
      if (str2 != LogField.ARGS) {}
    }
    else
    {
      i = 1;
      if (paramMap.containsKey(LogField.ARGS.toString()))
      {
        localStringBuilder.append(b((String)paramMap.get(LogField.ARGS.toString()) + ""));
        paramMap.remove(LogField.ARGS.toString());
        i = 0;
      }
      localObject = paramMap.keySet().iterator();
      label188:
      label214:
      label217:
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label380;
        }
        str2 = (String)((Iterator)localObject).next();
        if (!paramMap.containsKey(str2)) {
          break label427;
        }
        str1 = (String)paramMap.get(str2) + "";
        if (i == 0) {
          break label324;
        }
        if (!"StackTrace".equals(str2)) {
          break;
        }
        localStringBuilder.append("StackTrace=====>").append(str1);
        i = 0;
      }
    }
    if (paramMap.containsKey(str2.toString()))
    {
      str1 = (String)paramMap.get(str2.toString()) + "";
      paramMap.remove(str2.toString());
    }
    for (;;)
    {
      localStringBuilder.append(b(str1)).append("||");
      i += 1;
      break;
      localStringBuilder.append(b(str2)).append("=").append(str1);
      break label214;
      label324:
      if ("StackTrace".equals(str2))
      {
        localStringBuilder.append(",").append("StackTrace=====>").append(str1);
        break label217;
      }
      localStringBuilder.append(",").append(b(str2)).append("=").append(str1);
      break label217;
      label380:
      str1 = localStringBuilder.toString();
      paramMap = str1;
      if (!TextUtils.isEmpty(str1))
      {
        paramMap = str1;
        if (str1.endsWith("||")) {
          paramMap = str1 + "-";
        }
      }
      return paramMap;
      label427:
      str1 = null;
      break label188;
      str1 = null;
    }
  }
  
  public static Map<String, String> a(Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    try
    {
      paramMap = b.m();
      if ((!TextUtils.isEmpty(paramMap)) && (!((Map)localObject).containsKey(LogField.USERNICK.toString()))) {
        ((Map)localObject).put(LogField.USERNICK.toString(), paramMap);
      }
      paramMap = b.j();
      if ((!TextUtils.isEmpty(paramMap)) && (!((Map)localObject).containsKey(LogField.LL_USERNICK.toString()))) {
        ((Map)localObject).put(LogField.LL_USERNICK.toString(), paramMap);
      }
      paramMap = b.n();
      if ((!TextUtils.isEmpty(paramMap)) && (!((Map)localObject).containsKey(LogField.USERID.toString()))) {
        ((Map)localObject).put(LogField.USERID.toString(), paramMap);
      }
      paramMap = b.k();
      if ((!TextUtils.isEmpty(paramMap)) && (!((Map)localObject).containsKey(LogField.LL_USERID.toString()))) {
        ((Map)localObject).put(LogField.LL_USERID.toString(), paramMap);
      }
      long l = System.currentTimeMillis();
      if (!((Map)localObject).containsKey(LogField.RECORD_TIMESTAMP.toString())) {
        ((Map)localObject).put(LogField.RECORD_TIMESTAMP.toString(), String.valueOf(l));
      }
      if (!((Map)localObject).containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
        ((Map)localObject).put(LogField.START_SESSION_TIMESTAMP.toString(), String.valueOf(a.G));
      }
      paramMap = d.a(a.getContext());
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)paramMap.get(str1);
          if ((!TextUtils.isEmpty(str2)) && (!((Map)localObject).containsKey(str1))) {
            ((Map)localObject).put(str1, str2);
          }
        }
      }
      paramMap = t();
      if ((!TextUtils.isEmpty(paramMap)) && (!((Map)localObject).containsKey(LogField.RESERVES.toString())))
      {
        ((Map)localObject).put(LogField.RESERVES.toString(), paramMap);
        return (Map<String, String>)localObject;
      }
    }
    catch (Throwable paramMap) {}
    return (Map<String, String>)localObject;
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "-";
    }
    return str;
  }
  
  public static String b(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      a(paramMap);
      return a(paramMap);
    }
    return null;
  }
  
  private static String t()
  {
    String str1 = "_ap=1";
    String str2 = l.getWifiAddress(a.getContext());
    if (str2 != null) {
      str1 = "_ap=1" + String.format("%s=%s", new Object[] { "_mac", str2 });
    }
    str2 = str1;
    if (d.k())
    {
      String str3 = d.q();
      str2 = str1;
      if (!TextUtils.isEmpty(str3)) {
        str2 = str1 + ",_did=" + str3;
      }
    }
    return str2;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */