package com.inmobi.signals.activityrecognition;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String a = a.class.getSimpleName();
  private int b;
  private long c;
  
  public a(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.c = paramLong;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("a", this.b);
      localJSONObject.put("ts", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error while converting WifiInfo to string.", localJSONException);
    }
    return localJSONObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\signals\activityrecognition\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */