package com.alibaba.mtl.appmonitor.b;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.d;
import com.alibaba.mtl.appmonitor.c.e;
import com.alibaba.mtl.appmonitor.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
{
  private static JSONObject a(Context paramContext, Throwable paramThrowable)
  {
    JSONObject localJSONObject1 = (JSONObject)a.a().a(e.class, new Object[0]);
    if (paramContext != null) {
      localJSONObject1.put("pname", com.alibaba.mtl.log.e.b.a(paramContext));
    }
    localJSONObject1.put("page", "APPMONITOR");
    localJSONObject1.put("monitorPoint", "sdk-exception");
    localJSONObject1.put("arg", paramThrowable.getClass().getSimpleName());
    localJSONObject1.put("successCount", Integer.valueOf(0));
    localJSONObject1.put("failCount", Integer.valueOf(1));
    paramContext = new ArrayList();
    paramThrowable = a(paramThrowable);
    if (paramThrowable != null)
    {
      JSONObject localJSONObject2 = (JSONObject)a.a().a(e.class, new Object[0]);
      localJSONObject2.put("errorCode", paramThrowable);
      localJSONObject2.put("errorCount", Integer.valueOf(1));
      paramContext.add(localJSONObject2);
    }
    localJSONObject1.put("errors", paramContext);
    return localJSONObject1;
  }
  
  private static String a(Throwable paramThrowable)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramThrowable.getClass().getName());
    Object localObject2 = paramThrowable.getStackTrace();
    if (localObject2 != null)
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject1).append(localObject2[i].toString());
        i += 1;
      }
    }
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (com.alibaba.mtl.appmonitor.f.b.isBlank((String)localObject2)) {
      localObject1 = paramThrowable.toString();
    }
    return (String)localObject1;
  }
  
  public static void a(Context paramContext, Throwable paramThrowable)
  {
    if (paramThrowable != null) {}
    try
    {
      h localh = (h)a.a().a(h.class, new Object[0]);
      localh.e = f.a.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("meta", SdkMeta.getSDKMetaData());
      d locald = (d)a.a().a(d.class, new Object[0]);
      locald.add(a(paramContext, paramThrowable));
      localHashMap.put("data", locald);
      paramContext = f.a.a();
      localh.k.put(paramContext, JSON.toJSONString(localHashMap));
      localh.v = "APPMONITOR";
      localh.w = "sdk-exception";
      c.a(localh);
      a.a().a(locald);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    a(null, paramThrowable);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\appmonitor\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */