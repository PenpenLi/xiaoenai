package com.xiaoenai.app.feature.photoalbum.b;

import com.xiaoenai.app.domain.PhotoAlbum;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
{
  public static List<com.xiaoenai.app.feature.photopreview.b.a> a(List<PhotoAlbum> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a locala = new a();
      locala.a(((PhotoAlbum)paramList.get(i)).getFeeling());
      locala.b(((PhotoAlbum)paramList.get(i)).getUrl());
      locala.a(((PhotoAlbum)paramList.get(i)).getGroupId());
      locala.a(((PhotoAlbum)paramList.get(i)).getWidth());
      locala.b(((PhotoAlbum)paramList.get(i)).getCreatedTs());
      locala.c(((PhotoAlbum)paramList.get(i)).getHeight());
      locala.b(Integer.valueOf(((PhotoAlbum)paramList.get(i)).getId().intValue()));
      locala.a(((PhotoAlbum)paramList.get(i)).getIsOrigin().booleanValue());
      locala.d(((PhotoAlbum)paramList.get(i)).getSize());
      locala.a(i);
      localArrayList.add(locala);
      i += 1;
    }
    return localArrayList;
  }
  
  private long b(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar1.set(14, 0);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    paramLong1 = Math.abs((localCalendar2.getTime().getTime() - localCalendar1.getTime().getTime()) / 86400000L);
    com.xiaoenai.app.utils.f.a.c("days = {}", new Object[] { Long.valueOf(paramLong1) });
    return paramLong1;
  }
  
  private int c(long paramLong1, long paramLong2)
  {
    int j = -1;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(paramLong2);
    int k = localCalendar.get(1);
    int m = localCalendar.get(2);
    int n = localCalendar.get(5);
    localCalendar = Calendar.getInstance();
    localCalendar.clear();
    localCalendar.setTimeInMillis(paramLong1);
    int i1 = localCalendar.get(1);
    int i2 = localCalendar.get(2);
    int i3 = localCalendar.get(5);
    int i = j;
    if (m == i2)
    {
      i = j;
      if (i3 == n) {
        i = k - i1;
      }
    }
    return i;
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    String str = "";
    int m = (int)b(paramLong1, paramLong2);
    if (m <= 0) {
      return "";
    }
    int i;
    int j;
    label43:
    int k;
    if (m % 100 == 0)
    {
      i = 1;
      if (m != 520) {
        break label124;
      }
      j = 1;
      if (m != 1314) {
        break label130;
      }
      k = 1;
      label54:
      if ((k | i | j) == 0) {
        break label136;
      }
      str = m + "天";
    }
    for (;;)
    {
      com.xiaoenai.app.utils.f.a.c("getAniversary {} {} {}", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), str });
      return str;
      i = 0;
      break;
      label124:
      j = 0;
      break label43;
      label130:
      k = 0;
      break label54;
      label136:
      i = c(paramLong2, paramLong1);
      if (-1 != i) {
        if (i == 0) {
          str = "";
        } else {
          str = i + "周年";
        }
      }
    }
  }
  
  public List<d> a(List<PhotoAlbum> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList.size() == 0) {
      return localArrayList;
    }
    int j = 0;
    Object localObject2 = new ArrayList();
    Object localObject1 = new HashMap();
    long l = -1L;
    int i = 1;
    int m = paramList.size();
    int k = 0;
    if (k < m) {
      if (!((PhotoAlbum)paramList.get(k)).getIsDelete().booleanValue()) {}
    }
    label705:
    label740:
    for (;;)
    {
      k += 1;
      break;
      if (-1L == l)
      {
        ((List)localObject2).add(paramList.get(k));
        ((Map)localObject1).put(((PhotoAlbum)paramList.get(k)).getGroupId(), localObject2);
        l = ((PhotoAlbum)paramList.get(k)).getGroupId().longValue();
      }
      else if (l == ((PhotoAlbum)paramList.get(k)).getGroupId().longValue())
      {
        ((List)((Map)localObject1).get(((PhotoAlbum)paramList.get(k)).getGroupId())).add(paramList.get(k));
      }
      else
      {
        Object localObject3 = new ArrayList();
        ((List)localObject3).add(paramList.get(k));
        ((Map)localObject1).put(((PhotoAlbum)paramList.get(k)).getGroupId(), localObject3);
        if (localArrayList.size() > 0) {}
        for (j = ((d)localArrayList.get(localArrayList.size() - 1)).d().size() + j;; j = 0)
        {
          localObject3 = new d();
          List localList = (List)((Map)localObject1).get(((PhotoAlbum)paramList.get(j)).getGroupId());
          if ((localList == null) || (localList.size() <= 0)) {
            break label740;
          }
          ((d)localObject3).a(localList);
          ((d)localObject3).a(((PhotoAlbum)paramList.get(j)).getGroupId());
          ((d)localObject3).a(((PhotoAlbum)paramList.get(j)).getFeeling());
          ((d)localObject3).b(((PhotoAlbum)paramList.get(j)).getCreatedTs());
          ((d)localObject3).b(a(((PhotoAlbum)paramList.get(j)).getCreatedTs().longValue(), paramLong));
          ((d)localObject3).a(j);
          localArrayList.add(localObject3);
          l = ((PhotoAlbum)paramList.get(k)).getGroupId().longValue();
          i = 0;
          break;
        }
        if (!((PhotoAlbum)paramList.get(m - 1)).getIsDelete().booleanValue()) {
          if (i == 0) {
            break label705;
          }
        }
        for (i = 0;; i = ((d)localArrayList.get(localArrayList.size() - 1)).d().size() + j)
        {
          localObject2 = new d();
          localObject1 = (List)((Map)localObject1).get(((PhotoAlbum)paramList.get(m - 1)).getGroupId());
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            ((d)localObject2).a((List)localObject1);
            ((d)localObject2).a(((PhotoAlbum)paramList.get(i)).getGroupId());
            ((d)localObject2).a(((PhotoAlbum)paramList.get(i)).getFeeling());
            ((d)localObject2).b(((PhotoAlbum)paramList.get(i)).getCreatedTs());
            ((d)localObject2).a(i);
            ((d)localObject2).b(a(((PhotoAlbum)paramList.get(i)).getCreatedTs().longValue(), paramLong));
            localArrayList.add(localObject2);
          }
          return localArrayList;
        }
      }
    }
  }
  
  public List<c> b(List<PhotoAlbum> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramList.size() == 0) {
      return localArrayList1;
    }
    int i = 0;
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Calendar localCalendar = Calendar.getInstance();
    Object localObject1 = "";
    Object localObject2 = "";
    int j = 1;
    int n = paramList.size();
    int k = 0;
    if (k < n)
    {
      int m;
      Object localObject3;
      if (((PhotoAlbum)paramList.get(k)).getIsDelete().booleanValue())
      {
        m = j;
        localObject3 = localObject2;
        j = i;
        localObject2 = localObject1;
        localObject1 = localObject3;
        i = m;
      }
      String str1;
      for (;;)
      {
        m = k + 1;
        k = j;
        localObject3 = localObject2;
        j = i;
        localObject2 = localObject1;
        localObject1 = localObject3;
        i = k;
        k = m;
        break;
        localCalendar.setTimeInMillis(((PhotoAlbum)paramList.get(k)).getCreatedTs().longValue());
        str1 = com.xiaoenai.app.utils.d.d.j(localCalendar);
        localObject3 = com.xiaoenai.app.utils.d.d.h(localCalendar);
        if ("".equals(localObject1))
        {
          localArrayList2.add(paramList.get(k));
          localHashMap.put(str1 + "," + (String)localObject3, localArrayList2);
          localObject2 = str1;
          localObject1 = localObject3;
          m = i;
          i = j;
          j = m;
        }
        else
        {
          if ((!((String)localObject1).equals(str1)) || (!((String)localObject2).equals(localObject3))) {
            break label354;
          }
          ((List)localHashMap.get(str1 + "," + (String)localObject3)).add(paramList.get(k));
          m = i;
          localObject3 = localObject1;
          i = j;
          localObject1 = localObject2;
          localObject2 = localObject3;
          j = m;
        }
      }
      label354:
      localObject1 = new ArrayList();
      ((List)localObject1).add(paramList.get(k));
      localHashMap.put(str1 + "," + (String)localObject3, localObject1);
      if (localArrayList1.size() > 0) {
        i += ((c)localArrayList1.get(localArrayList1.size() - 1)).d().size();
      }
      for (;;)
      {
        localObject1 = new c();
        ((c)localObject1).a(((PhotoAlbum)paramList.get(i)).getCreatedTs());
        localCalendar.setTimeInMillis(((PhotoAlbum)paramList.get(i)).getCreatedTs().longValue());
        localObject2 = com.xiaoenai.app.utils.d.d.j(localCalendar);
        String str2 = com.xiaoenai.app.utils.d.d.h(localCalendar);
        ((c)localObject1).a((String)localObject2);
        ((c)localObject1).b(str2);
        ((c)localObject1).b(i);
        ((c)localObject1).a((List)localHashMap.get((String)localObject2 + "," + str2));
        localArrayList1.add(localObject1);
        m = 0;
        localObject2 = str1;
        j = i;
        localObject1 = localObject3;
        i = m;
        break;
        i = 0;
      }
    }
    if (!((PhotoAlbum)paramList.get(n - 1)).getIsDelete().booleanValue()) {
      if (j == 0) {
        break label761;
      }
    }
    label761:
    for (i = 0;; i = ((c)localArrayList1.get(localArrayList1.size() - 1)).d().size() + i)
    {
      localObject1 = new c();
      ((c)localObject1).a(((PhotoAlbum)paramList.get(i)).getCreatedTs());
      localCalendar.setTimeInMillis(((PhotoAlbum)paramList.get(n - 1)).getCreatedTs().longValue());
      paramList = com.xiaoenai.app.utils.d.d.j(localCalendar);
      localObject2 = com.xiaoenai.app.utils.d.d.h(localCalendar);
      ((c)localObject1).a(paramList);
      ((c)localObject1).b((String)localObject2);
      ((c)localObject1).b(i);
      ((c)localObject1).a((List)localHashMap.get(paramList + "," + (String)localObject2));
      localArrayList1.add(localObject1);
      return localArrayList1;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\feature\photoalbum\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */