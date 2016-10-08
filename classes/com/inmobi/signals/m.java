package com.inmobi.signals;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.signals.b.a;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private static final String a = m.class.getSimpleName();
  private long b;
  private a c;
  private List<a> d;
  private Map<String, String> e;
  
  public m()
  {
    a(Calendar.getInstance().getTimeInMillis());
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(a parama)
  {
    this.c = parama;
  }
  
  public void a(List<a> paramList)
  {
    this.d = paramList;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.e = paramMap;
  }
  
  public boolean a()
  {
    return (this.c != null) || (this.d != null);
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    label131:
    JSONArray localJSONArray;
    do
    {
      do
      {
        try
        {
          localJSONObject.put("ts", this.b);
          if ((this.e != null) && (!this.e.isEmpty()))
          {
            Iterator localIterator = this.e.entrySet().iterator();
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
            }
          }
          if (this.c == null) {
            break label131;
          }
        }
        catch (JSONException localJSONException)
        {
          Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while converting IceWifiCellSample to string.", localJSONException);
          return localJSONObject;
        }
        localJSONObject.put("c-ap", this.c.b());
        localJSONArray = new JSONArray();
      } while (this.d == null);
      int i = 0;
      while (i < this.d.size())
      {
        localJSONArray.put(((a)this.d.get(i)).b());
        i += 1;
      }
    } while (localJSONArray.length() <= 0);
    localJSONObject.put("v-ap", localJSONArray);
    return localJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */