package com.alibaba.nb.android.trade.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class AliTradeSortUtils
{
  private static void a(String paramString1, String paramString2, Set<String> paramSet, Map<String, Set<String>> paramMap)
  {
    paramString2 = (Set)paramMap.get(paramString2);
    if ((paramString2 == null) || (paramString2.contains(paramString1))) {}
    for (;;)
    {
      return;
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        String str = (String)paramString2.next();
        if (paramSet.add(str)) {
          a(paramString1, str, paramSet, paramMap);
        }
      }
    }
  }
  
  public static void a(SortInfo[] paramArrayOfSortInfo)
  {
    int k = 0;
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = new HashMap();
    int m = paramArrayOfSortInfo.length;
    int i = 0;
    Object localObject4;
    Object localObject5;
    while (i < m)
    {
      localObject3 = paramArrayOfSortInfo[i];
      if (((SortInfo)localObject3).before != null)
      {
        localObject4 = ((SortInfo)localObject3).before;
        int n = localObject4.length;
        j = 0;
        while (j < n)
        {
          localObject5 = localObject4[j];
          localObject2 = (Set)localHashMap2.get(localObject5);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new HashSet();
            localHashMap2.put(localObject5, localObject1);
          }
          ((Set)localObject1).add(((SortInfo)localObject3).name);
          j += 1;
        }
      }
      localObject2 = (Set)localHashMap2.get(((SortInfo)localObject3).name);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localHashMap2.put(((SortInfo)localObject3).name, localObject1);
      }
      if (((SortInfo)localObject3).after != null) {
        Collections.addAll((Collection)localObject1, ((SortInfo)localObject3).after);
      }
      localHashMap1.put(((SortInfo)localObject3).name, localObject3);
      i += 1;
    }
    Object localObject1 = new HashSet();
    int j = paramArrayOfSortInfo.length;
    i = 0;
    while (i < j)
    {
      localObject2 = paramArrayOfSortInfo[i];
      a(((SortInfo)localObject2).name, ((SortInfo)localObject2).name, (Set)localObject1, localHashMap2);
      ((Set)localHashMap2.get(((SortInfo)localObject2).name)).addAll((Collection)localObject1);
      ((Set)localObject1).clear();
      i += 1;
    }
    Object localObject2 = new HashSet();
    localObject1 = new HashSet();
    j = paramArrayOfSortInfo.length;
    i = 0;
    if (i < j)
    {
      localObject4 = paramArrayOfSortInfo[i];
      localObject3 = ((SortInfo)localObject4).name;
      if ((((SortInfo)localObject4).beforeAll != null) && (((SortInfo)localObject4).beforeAll.booleanValue()))
      {
        ((Set)localObject2).add(localObject3);
        ((Set)localObject2).addAll((Set)localHashMap2.get(localObject3));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((((SortInfo)localObject4).afterAll != null) && (((SortInfo)localObject4).afterAll.booleanValue()))
        {
          ((Set)localObject1).add(localObject3);
          localObject4 = localHashMap2.entrySet().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject4).next();
            if (((Set)((Map.Entry)localObject5).getValue()).contains(localObject3)) {
              ((Set)localObject1).add(((Map.Entry)localObject5).getKey());
            }
          }
        }
      }
    }
    Object localObject3 = localHashMap2.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      if (!((Set)localObject2).contains(((Map.Entry)localObject4).getKey())) {
        ((Set)((Map.Entry)localObject4).getValue()).addAll((Collection)localObject2);
      }
    }
    localObject2 = new HashSet(localHashMap2.keySet());
    ((Set)localObject2).removeAll((Collection)localObject1);
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Set)localHashMap2.get((String)((Iterator)localObject1).next())).addAll((Collection)localObject2);
    }
    localObject1 = new HashSet();
    localObject2 = new HashSet();
    localObject3 = new ArrayList(paramArrayOfSortInfo.length);
    while (localHashMap2.size() > 0)
    {
      localObject4 = localHashMap2.entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        ((Set)((Map.Entry)localObject5).getValue()).removeAll((Collection)localObject2);
        ((Set)((Map.Entry)localObject5).getValue()).retainAll(localHashMap2.keySet());
        if (((Set)((Map.Entry)localObject5).getValue()).size() == 0)
        {
          ((Set)localObject1).add(((Map.Entry)localObject5).getKey());
          ((List)localObject3).add(((Map.Entry)localObject5).getKey());
          ((Iterator)localObject4).remove();
        }
      }
      if (((Set)localObject1).size() == 0) {
        throw new IllegalStateException("Circular found for " + localHashMap2);
      }
      ((Set)localObject2).clear();
      ((Set)localObject2).addAll((Collection)localObject1);
      ((Set)localObject1).clear();
    }
    localObject1 = ((List)localObject3).iterator();
    i = k;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SortInfo)localHashMap1.get((String)((Iterator)localObject1).next());
      if (localObject2 == null) {
        break label924;
      }
      paramArrayOfSortInfo[i] = localObject2;
      i += 1;
    }
    label924:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public static class SortInfo
    implements Serializable
  {
    private static final long serialVersionUID = 3959903664223165585L;
    public String[] after;
    public Boolean afterAll;
    public String[] before;
    public Boolean beforeAll;
    public String name;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\nb\android\trade\utils\AliTradeSortUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */