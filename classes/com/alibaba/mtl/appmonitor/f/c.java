package com.alibaba.mtl.appmonitor.f;

import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.c.b;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
{
  public static void a(h paramh)
  {
    if (paramh == null) {
      return;
    }
    com.alibaba.mtl.log.a.a(paramh.u, String.valueOf(paramh.e), paramh.v, paramh.w, paramh.x, paramh.k);
    com.alibaba.mtl.appmonitor.c.a.a().a(paramh);
  }
  
  public static void a(UTDimensionValueSet paramUTDimensionValueSet, com.alibaba.mtl.appmonitor.a.d paramd)
  {
    Object localObject = paramUTDimensionValueSet.getEventId();
    if (localObject != null)
    {
      f localf = f.a(((Integer)localObject).intValue());
      h localh = (h)com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
      localh.e = 6699;
      if (paramUTDimensionValueSet.getMap() != null) {
        localh.k.putAll(paramUTDimensionValueSet.getMap());
      }
      paramUTDimensionValueSet = new HashMap();
      paramUTDimensionValueSet.put("meta", SdkMeta.getSDKMetaData());
      paramUTDimensionValueSet.put("_event_id", localObject);
      localObject = (com.alibaba.mtl.appmonitor.c.d)com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
      ((com.alibaba.mtl.appmonitor.c.d)localObject).add(paramd.a());
      com.alibaba.mtl.appmonitor.c.a.a().a(paramd);
      paramUTDimensionValueSet.put("data", localObject);
      localh.k.put(localf.a(), JSON.toJSONString(paramUTDimensionValueSet));
      localh.k.put(LogField.EVENTID.toString(), String.valueOf(6699));
      b(localh);
      com.alibaba.mtl.appmonitor.c.a.a().a((b)localObject);
    }
  }
  
  public static void b(h paramh)
  {
    i.a("UTUtil", new Object[] { "upload without flowback. args:", paramh.k });
    com.alibaba.mtl.appmonitor.e.a.a().c(paramh.k);
    com.alibaba.mtl.appmonitor.c.a.a().a(paramh);
  }
  
  public static void d(Map<UTDimensionValueSet, List<com.alibaba.mtl.appmonitor.a.d>> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramMap.next();
      UTDimensionValueSet localUTDimensionValueSet = (UTDimensionValueSet)((Map.Entry)localObject1).getKey();
      Object localObject5 = (List)((Map.Entry)localObject1).getValue();
      if (((List)localObject5).size() != 0)
      {
        Object localObject2 = localUTDimensionValueSet.getEventId();
        if (localObject2 != null)
        {
          Object localObject3 = f.a(((Integer)localObject2).intValue());
          localObject1 = (h)com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
          ((h)localObject1).e = ((Integer)localObject2).intValue();
          if (localUTDimensionValueSet.getMap() != null) {
            ((h)localObject1).k.putAll(localUTDimensionValueSet.getMap());
          }
          Object localObject4 = new HashMap();
          ((Map)localObject4).put("meta", SdkMeta.getSDKMetaData());
          localObject2 = (com.alibaba.mtl.appmonitor.c.d)com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
          localObject5 = ((List)localObject5).iterator();
          int i = 0;
          if (((Iterator)localObject5).hasNext())
          {
            com.alibaba.mtl.appmonitor.a.d locald = (com.alibaba.mtl.appmonitor.a.d)((Iterator)localObject5).next();
            ((com.alibaba.mtl.appmonitor.c.d)localObject2).add(locald.a());
            if (i == 0)
            {
              localStringBuilder1.append(locald.o);
              localStringBuilder2.append(locald.p);
            }
            for (;;)
            {
              i += 1;
              com.alibaba.mtl.appmonitor.c.a.a().a(locald);
              break;
              localStringBuilder1.append(",");
              localStringBuilder1.append(locald.o);
              localStringBuilder2.append(",");
              localStringBuilder2.append(locald.p);
            }
          }
          ((Map)localObject4).put("data", localObject2);
          ((h)localObject1).k.put(((f)localObject3).a(), JSON.toJSONString(localObject4));
          localObject3 = localStringBuilder1.toString();
          localObject4 = localStringBuilder2.toString();
          ((h)localObject1).k.put(LogField.ARG1.toString(), localObject3);
          ((h)localObject1).k.put(LogField.ARG2.toString(), localObject4);
          ((h)localObject1).v = ((String)localObject3);
          ((h)localObject1).w = ((String)localObject4);
          b((h)localObject1);
          com.alibaba.mtl.appmonitor.c.a.a().a((b)localObject2);
        }
      }
      com.alibaba.mtl.appmonitor.c.a.a().a(localUTDimensionValueSet);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */