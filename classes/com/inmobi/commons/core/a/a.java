package com.inmobi.commons.core.a;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.inmobi.commons.core.configs.a
{
  private static final String a = a.class.getSimpleName();
  private JSONObject b;
  
  public a()
  {
    try
    {
      this.b = f();
      return;
    }
    catch (Exception localException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error in default telemetry config");
    }
  }
  
  private JSONObject f()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("enabled", false);
    localJSONObject.put("samplingFactor", 0);
    localJSONObject.put("metricEnabled", false);
    return localJSONObject;
  }
  
  public String a()
  {
    return "crashReporting";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      super.a(paramJSONObject);
      this.b = paramJSONObject.getJSONObject("telemetry");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing Crash Config " + paramJSONObject.toString());
    }
  }
  
  public JSONObject b()
  {
    try
    {
      JSONObject localJSONObject = super.b();
      localJSONObject.put("telemetry", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Error parsing Crash Config " + localJSONException.toString());
    }
    return null;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public com.inmobi.commons.core.configs.a d()
  {
    return new a();
  }
  
  public JSONObject e()
  {
    return this.b;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */