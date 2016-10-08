package com.adhoc.adhocsdk;

import com.adhoc.fl;
import com.adhoc.q;
import org.json.JSONException;
import org.json.JSONObject;

public class ExperimentFlags
{
  private String flagState;
  private JSONObject mFlags = new JSONObject();
  
  public ExperimentFlags(JSONObject paramJSONObject)
  {
    this.mFlags = paramJSONObject;
  }
  
  public boolean getBooleanFlag(String paramString, boolean paramBoolean)
  {
    try
    {
      q.a().a(this.mFlags, paramString);
      JSONObject localJSONObject = this.mFlags.optJSONObject("flags");
      boolean bool = paramBoolean;
      if (localJSONObject != null) {
        bool = localJSONObject.optBoolean(paramString, paramBoolean);
      }
      return bool;
    }
    catch (Throwable paramString)
    {
      fl.a(paramString);
    }
    return paramBoolean;
  }
  
  public double getDoubleFlag(String paramString, double paramDouble)
  {
    try
    {
      q.a().a(this.mFlags, paramString);
      JSONObject localJSONObject = this.mFlags.optJSONObject("flags");
      double d = paramDouble;
      if (localJSONObject != null) {
        d = localJSONObject.optDouble(paramString, paramDouble);
      }
      return d;
    }
    catch (Throwable paramString)
    {
      fl.a(paramString);
    }
    return paramDouble;
  }
  
  public String getFlagState()
  {
    return this.flagState;
  }
  
  public double getFloatFlag(String paramString, float paramFloat)
  {
    try
    {
      q.a().a(this.mFlags, paramString);
      JSONObject localJSONObject = this.mFlags.optJSONObject("flags");
      if (localJSONObject != null)
      {
        double d = localJSONObject.optDouble(paramString, paramFloat);
        return d;
      }
      return paramFloat;
    }
    catch (Throwable paramString)
    {
      fl.a(paramString);
    }
    return paramFloat;
  }
  
  public int getIntegerFlag(String paramString, int paramInt)
  {
    try
    {
      q.a().a(this.mFlags, paramString);
      JSONObject localJSONObject = this.mFlags.optJSONObject("flags");
      int i = paramInt;
      if (localJSONObject != null) {
        i = localJSONObject.optInt(paramString, paramInt);
      }
      return i;
    }
    catch (Throwable paramString)
    {
      fl.a(paramString);
    }
    return paramInt;
  }
  
  public long getLongFlag(String paramString, long paramLong)
  {
    try
    {
      q.a().a(this.mFlags, paramString);
      JSONObject localJSONObject = this.mFlags.optJSONObject("flags");
      long l = paramLong;
      if (localJSONObject != null) {
        l = localJSONObject.optLong(paramString, paramLong);
      }
      return l;
    }
    catch (Throwable paramString)
    {
      fl.a(paramString);
    }
    return paramLong;
  }
  
  public JSONObject getRawFlags()
  {
    return this.mFlags;
  }
  
  public String getStringFlag(String paramString1, String paramString2)
  {
    try
    {
      q.a().a(this.mFlags, paramString1);
      JSONObject localJSONObject = this.mFlags.optJSONObject("flags");
      String str = paramString2;
      if (localJSONObject != null) {
        str = localJSONObject.optString(paramString1, paramString2);
      }
      return str;
    }
    catch (Throwable paramString1)
    {
      fl.a(paramString1);
    }
    return paramString2;
  }
  
  public boolean has(String paramString)
  {
    if (this.mFlags == null) {}
    for (;;)
    {
      return false;
      try
      {
        JSONObject localJSONObject = this.mFlags.getJSONObject("flags");
        if (localJSONObject != null)
        {
          boolean bool = localJSONObject.has(paramString);
          return bool;
        }
      }
      catch (JSONException paramString)
      {
        fl.a(paramString);
      }
    }
    return false;
  }
  
  public void setFlagState(String paramString)
  {
    this.flagState = paramString;
  }
  
  public String toString()
  {
    if (this.mFlags == null) {
      return "";
    }
    return this.mFlags.toString();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\adhocsdk\ExperimentFlags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */