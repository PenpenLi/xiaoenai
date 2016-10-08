package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.f;
import com.inmobi.signals.activityrecognition.a;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  private static final String a = l.class.getSimpleName();
  private long b;
  private Map<String, Object> c;
  private f d;
  private List<m> e;
  private List<a> f;
  
  public l()
  {
    a(Calendar.getInstance().getTimeInMillis());
  }
  
  public JSONObject a()
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ts", this.b);
      if ((this.c != null) && (!this.c.isEmpty())) {
        localJSONObject.put("l", new JSONObject(this.c));
      }
      if (this.d != null) {
        localJSONObject.put("s", this.d.b());
      }
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < this.e.size())
      {
        localJSONArray.put(((m)this.e.get(i)).b());
        i += 1;
      }
      if (localJSONArray.length() > 0) {
        localJSONObject.put("w", localJSONArray);
      }
      if (this.f != null)
      {
        localJSONArray = new JSONArray();
        i = j;
        while (i < this.f.size())
        {
          localJSONArray.put(((a)this.f.get(i)).a());
          i += 1;
        }
        if (localJSONArray.length() > 0) {
          localJSONObject.put("ar", localJSONArray);
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while converting IceSample to string.", localJSONException);
    }
    return localJSONObject;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(f paramf)
  {
    this.d = paramf;
  }
  
  public void a(List<m> paramList)
  {
    this.e = paramList;
  }
  
  public void a(Map<String, Object> paramMap)
  {
    this.c = paramMap;
  }
  
  public void b(List<a> paramList)
  {
    this.f = paramList;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */