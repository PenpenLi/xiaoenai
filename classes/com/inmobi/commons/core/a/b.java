package com.inmobi.commons.core.a;

import android.util.Log;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends e
{
  private static final String a = b.class.getSimpleName();
  
  public b(Thread paramThread, Throwable paramThrowable)
  {
    super("crashReporting", "CrashEvent");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", paramThrowable.getClass().getSimpleName());
      localJSONObject.put("message", paramThrowable.getMessage());
      localJSONObject.put("stack", Log.getStackTraceString(paramThrowable));
      localJSONObject.put("thread", paramThread.getName());
      a(localJSONObject.toString());
      return;
    }
    catch (JSONException paramThread)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "JSONException: " + paramThread);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */