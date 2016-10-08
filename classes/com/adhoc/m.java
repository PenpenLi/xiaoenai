package com.adhoc;

import android.content.Context;
import com.adhoc.adhocsdk.AdhocTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private static m a;
  private String b;
  private Context c;
  private JSONObject d;
  private JSONObject e;
  
  private m(Context paramContext)
  {
    try
    {
      this.c = paramContext;
      b();
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  public static m a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new m(paramContext);
      }
      return a;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        fl.a(paramContext);
      }
    }
  }
  
  private void b()
  {
    try
    {
      this.b = a.a(this.c).a();
      this.d = ac.a(this.c);
      fl.c(" aptext id : " + AdhocTracker.APPKEY);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        this.d = null;
        fl.b("json mSummary is error!");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        fl.a(localThrowable);
      }
    }
  }
  
  public JSONObject a()
  {
    localJSONObject = new JSONObject();
    try
    {
      if (this.b == null) {
        this.b = a.a(this.c).a();
      }
      try
      {
        localJSONObject.put("client_id", this.b);
        localJSONObject.put("app_key", AdhocTracker.APPKEY);
        if (this.d != null) {
          localJSONObject.put("summary", this.d);
        }
        if (this.e == null) {
          this.e = new JSONObject();
        }
        localJSONObject.put("custom", this.e);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        fl.b("JSONException when filling basic key-value parameters.");
        return null;
      }
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
  
  public JSONObject a(Context paramContext, JSONObject paramJSONObject, HashMap paramHashMap)
  {
    if (paramJSONObject == null) {}
    try
    {
      fl.b("adhoc basic request para is null");
      paramJSONObject = null;
      return paramJSONObject;
    }
    finally {}
    String str1 = (String)paramHashMap.get("key");
    Object localObject = paramHashMap.get("value");
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = (JSONArray)paramHashMap.get("experiment_ids");
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray2.length())
      {
        JSONObject localJSONObject = new JSONObject();
        String str2 = localJSONArray2.optString(i);
        Double localDouble = q.a().a(paramContext, str1, str2);
        localDouble = q.a().a(paramContext, str1, str2, localObject, localDouble);
        try
        {
          localJSONObject.put("key", str1);
          localJSONObject.put("value", localObject);
          localJSONObject.put("timestamp", paramHashMap.get("timestamp"));
          localJSONObject.put("acc_value", localDouble);
          localJSONObject.put("experiment_ids", new JSONArray().put(str2));
          localJSONArray1.put(localJSONObject);
        }
        catch (Throwable localThrowable)
        {
          fl.a(localThrowable);
        }
      }
      else
      {
        try
        {
          paramJSONObject.put("stats", localJSONArray1);
        }
        catch (JSONException paramContext)
        {
          fl.a(paramContext);
        }
        catch (Throwable paramContext)
        {
          fl.a(paramContext);
        }
        break;
      }
      i += 1;
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.e = new JSONObject();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      try
      {
        this.e.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        fl.b("custormPara error");
      }
      catch (Throwable localThrowable)
      {
        fl.a(localThrowable);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */