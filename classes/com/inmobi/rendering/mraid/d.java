package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static final String c = d.class.getSimpleName();
  public int a = DisplayInfo.a().b();
  public int b = DisplayInfo.a().a();
  private boolean d = false;
  private boolean e;
  private boolean f = true;
  private String g;
  
  public d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("width", this.a);
      localJSONObject.put("height", this.b);
      localJSONObject.put("useCustomClose", this.d);
      localJSONObject.put("isModal", this.f);
      this.g = localJSONObject.toString();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Logger.a(Logger.InternalLogLevel.INTERNAL, c, "Exception in composing ExpandProperties: " + localJSONException.getMessage());
      }
    }
  }
  
  public static d a(String paramString, d paramd, l paraml)
  {
    paramd = new d();
    paramd.g = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      paramd.f = true;
      if (paramString.has("useCustomClose")) {
        paramd.e = true;
      }
      paramd.d = paramString.optBoolean("useCustomClose", false);
      return paramd;
    }
    catch (JSONException paramString)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, c, "Invalid expand properties string passed.", paramString);
    }
    return paramd;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\rendering\mraid\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */