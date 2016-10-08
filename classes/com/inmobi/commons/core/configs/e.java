package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.NetworkRequest.RequestType;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.uid.d;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class e
  extends NetworkRequest
{
  private static final String d = e.class.getSimpleName();
  private static String h = "http://config.inmobi.com/config-server/v1/config/secure.cfg";
  private int e;
  private int f;
  private Map<String, a> g;
  
  public e(Map<String, a> paramMap, d paramd, String paramString, int paramInt1, int paramInt2)
  {
    super(localRequestType, str, true, paramd);
    this.g = paramMap;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  private String e()
  {
    c localc = new c();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("n", localEntry.getKey());
        localJSONObject.put("t", localc.b((String)localEntry.getKey()));
        localJSONArray.put(localJSONObject);
      }
      str = localJSONArray.toString();
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, d, "Problem while creating config network request's payload.", localJSONException);
      return "";
    }
    String str;
    return str;
  }
  
  public void a()
  {
    super.a();
    this.c.put("p", e());
    this.c.put("im-accid", com.inmobi.commons.a.a.c());
  }
  
  public void a(String paramString)
  {
    this.g.remove(paramString);
  }
  
  public Map<String, a> b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */