package com.inmobi.signals.b;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();
  private long b;
  private String c;
  private int d;
  private int e;
  
  public long a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bssid", this.b);
      localJSONObject.put("essid", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while converting WifiInfo to string.", localJSONException);
    }
    return localJSONObject;
  }
  
  public void b(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */