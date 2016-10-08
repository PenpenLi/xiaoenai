package com.adhoc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class w
{
  private static w b = new w();
  private static boolean c = false;
  BroadcastReceiver a = new y(this);
  private long d = 1000L;
  private boolean e;
  
  public static w a()
  {
    return b;
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      r.a().a(paramContext, "increment_cache_file", paramJSONObject.toString() + "\n");
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  private void a(JSONObject paramJSONObject, Context paramContext)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      Object localObject = bl.a(bf.a("application/json; charset=utf-8"), paramJSONObject.toString());
      localObject = new bj.a().a("https://tracker.appadhoc.com/tracker").a((bl)localObject).a();
      fl.a("发送json :" + paramJSONObject.toString());
      fk.a().a((bj)localObject, new z(this, paramContext, paramJSONObject));
      return;
    }
    catch (Throwable paramJSONObject)
    {
      fl.a(paramJSONObject);
    }
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      paramContext.registerReceiver(this.a, localIntentFilter);
      return;
    }
    catch (Throwable paramContext)
    {
      fl.b("init reg receiver error!");
    }
  }
  
  public void a(Context paramContext, String paramString, Object paramObject, long paramLong, JSONArray paramJSONArray)
  {
    if (paramLong == 0L) {}
    try
    {
      for (paramLong = System.currentTimeMillis() / 1000L;; paramLong /= 1000L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("timestamp", Long.valueOf(paramLong));
        localHashMap.put("key", paramString);
        localHashMap.put("value", paramObject);
        localHashMap.put("experiment_ids", paramJSONArray);
        fl.a("send key - value :" + paramString + " " + paramObject + " experiments " + paramJSONArray);
        paramString = m.a(paramContext).a();
        paramString = m.a(paramContext).a(paramContext, paramString, localHashMap);
        paramObject = fm.b(paramContext);
        switch (aa.a[paramObject.ordinal()])
        {
        }
      }
      fl.a("report message..");
      a(paramString, paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
      return;
    }
    fl.a("mobile net type");
    if (c)
    {
      a(paramContext, paramString);
      return;
    }
    a(paramString, paramContext);
    return;
    fl.a("unknow net workstate");
    a(paramContext, paramString);
    return;
  }
  
  public void a(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public void b(Context paramContext)
  {
    try
    {
      if (this.e) {
        return;
      }
      new Thread(new x(this, paramContext)).start();
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */