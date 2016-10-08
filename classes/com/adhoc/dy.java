package com.adhoc;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class dy
{
  static final String a = bz.a().b();
  public static final String b = a + "-Sent-Millis";
  public static final String c = a + "-Received-Millis";
  public static final String d = a + "-Selected-Protocol";
  private static final Comparator<String> e = new dz();
  
  public static long a(ba paramba)
  {
    return b(paramba.a("Content-Length"));
  }
  
  public static long a(bj parambj)
  {
    return a(parambj.e());
  }
  
  public static long a(bn parambn)
  {
    return a(parambn.g());
  }
  
  public static bj a(ah paramah, bn parambn, Proxy paramProxy)
  {
    if (parambn.c() == 407) {
      return paramah.b(paramProxy, parambn);
    }
    return paramah.a(paramProxy, parambn);
  }
  
  private static String a(List<String> paramList)
  {
    if (paramList.size() == 1) {
      return (String)paramList.get(0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static Map<String, List<String>> a(ba paramba, String paramString)
  {
    TreeMap localTreeMap = new TreeMap(e);
    int j = paramba.a();
    int i = 0;
    while (i < j)
    {
      String str1 = paramba.a(i);
      String str2 = paramba.b(i);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
      i += 1;
    }
    if (paramString != null) {
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString)));
    }
    return Collections.unmodifiableMap(localTreeMap);
  }
  
  public static void a(bj.a parama, Map<String, List<String>> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((("Cookie".equalsIgnoreCase(str)) || ("Cookie2".equalsIgnoreCase(str))) && (!((List)localEntry.getValue()).isEmpty())) {
        parama.b(str, a((List)localEntry.getValue()));
      }
    }
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private static long b(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static List<aq> b(ba paramba, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramba.a();
    int i = 0;
    if (i < k)
    {
      if (!paramString.equalsIgnoreCase(paramba.a(i))) {}
      label183:
      for (;;)
      {
        i += 1;
        break;
        String str1 = paramba.b(i);
        int j = 0;
        for (;;)
        {
          if (j >= str1.length()) {
            break label183;
          }
          int m = do.a(str1, j, " ");
          String str2 = str1.substring(j, m).trim();
          j = do.a(str1, m);
          if (!str1.regionMatches(true, j, "realm=\"", 0, "realm=\"".length())) {
            break;
          }
          j = "realm=\"".length() + j;
          m = do.a(str1, j, "\"");
          String str3 = str1.substring(j, m);
          j = do.a(str1, do.a(str1, m + 1, ",") + 1);
          localArrayList.add(new aq(str2, str3));
        }
      }
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */