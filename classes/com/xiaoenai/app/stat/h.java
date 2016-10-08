package com.xiaoenai.app.stat;

import android.content.Context;
import android.text.TextUtils;
import com.xiaoenai.app.d.ak;
import com.xiaoenai.app.net.ac;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
{
  private static h a;
  private static Object b = new Object();
  private static ak d = null;
  private int c;
  
  private h()
  {
    if (d == null) {
      d = new ak();
    }
  }
  
  public static h a()
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new h();
      }
      return a;
    }
  }
  
  public static int c()
  {
    return new Random(System.currentTimeMillis()).nextInt(1073741823) + 1;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Context paramContext)
  {
    List localList = d.a(100);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = localList.iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        StatEntry localStatEntry = (StatEntry)localIterator.next();
        try
        {
          localJSONArray.put(i, localStatEntry.toJson(localStatEntry, StatEntry.class));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    a(localJSONArray, paramContext, localList);
  }
  
  public void a(StatEntry paramStatEntry)
  {
    d.a(paramStatEntry);
  }
  
  public void a(List<StatEntry> paramList)
  {
    d.a(paramList);
  }
  
  public void a(JSONArray paramJSONArray, Context paramContext, List<StatEntry> paramList)
  {
    paramList = new ac(new i(this, paramContext, paramList));
    try
    {
      paramContext = new JSONObject(com.xiaoenai.app.utils.b.a.a(paramJSONArray.toString()));
      if (paramContext != null)
      {
        String str = paramContext.optString("data");
        if (!TextUtils.isEmpty(str))
        {
          paramList.a(1, str);
          com.xiaoenai.app.utils.f.a.c("stat = {}", new Object[] { paramContext });
          return;
        }
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
        continue;
        com.xiaoenai.app.utils.f.a.a("uploadToServer = {}", new Object[] { paramJSONArray.toString() });
        continue;
        com.xiaoenai.app.utils.f.a.a("uploadToServer = {}", new Object[] { paramJSONArray.toString() });
      }
    }
  }
  
  public int b()
  {
    return this.c;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\stat\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */