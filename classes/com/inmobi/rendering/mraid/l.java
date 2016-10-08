package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class l
{
  private static String e = l.class.getSimpleName();
  public boolean a = true;
  public String b = "none";
  public String c = "right";
  private String d = null;
  
  public static l a(String paramString, l paraml)
  {
    l locall = new l();
    locall.d = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      locall.b = paramString.optString("forceOrientation", paraml.b);
      locall.a = paramString.optBoolean("allowOrientationChange", paraml.a);
      locall.c = paramString.optString("direction", paraml.c);
      if ((!locall.b.equals("portrait")) && (!locall.b.equals("landscape"))) {
        locall.b = "none";
      }
      if ((!locall.c.equals("left")) && (!locall.c.equals("right"))) {
        locall.c = "right";
      }
      return locall;
    }
    catch (JSONException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, e, "Invalid orientation properties string passed.", paramString);
    }
    return null;
  }
  
  public String a()
  {
    return this.d;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */