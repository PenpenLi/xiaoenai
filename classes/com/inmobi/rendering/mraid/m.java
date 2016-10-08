package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private static final String g = m.class.getSimpleName();
  String a = "top-right";
  int b;
  int c;
  int d = 0;
  int e = 0;
  boolean f = true;
  
  public static m a(String paramString, m paramm)
  {
    m localm = new m();
    try
    {
      paramString = new JSONObject(paramString);
      localm.b = paramString.getInt("width");
      localm.c = paramString.getInt("height");
      localm.d = paramString.getInt("offsetX");
      localm.e = paramString.getInt("offsetY");
      if (paramm != null)
      {
        localm.a = paramString.optString("customClosePosition", paramm.a);
        localm.f = paramString.optBoolean("allowOffscreen", paramm.f);
      }
      return localm;
    }
    catch (JSONException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, g, "Invalid resize properties string passed.", paramString);
    }
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("width", this.b);
      ((JSONObject)localObject).put("height", this.c);
      ((JSONObject)localObject).put("customClosePosition", this.a);
      ((JSONObject)localObject).put("offsetX", this.d);
      ((JSONObject)localObject).put("offsetY", this.e);
      ((JSONObject)localObject).put("allowOffscreen", this.f);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, g, "Invalid resize properties string passed.", localJSONException);
    }
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */