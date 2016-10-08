package com.inmobi.commons.core.utilities.info;

import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static final String a = f.class.getSimpleName();
  private static f b;
  private static Object c = new Object();
  private String d;
  private long e;
  private long f;
  private boolean g;
  
  public static f a()
  {
    Object localObject1 = b;
    if (localObject1 == null) {
      synchronized (c)
      {
        f localf2 = b;
        localObject1 = localf2;
        if (localf2 == null)
        {
          b = new f();
          localObject1 = b;
        }
        return (f)localObject1;
      }
    }
    return localf1;
  }
  
  private void d()
  {
    this.d = null;
    this.e = 0L;
    this.f = 0L;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (!this.g) {
      d();
    }
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sid", this.d);
      localJSONObject.put("s-ts", this.e);
      localJSONObject.put("e-ts", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Problem converting session object to Json.", localJSONException);
    }
    return localJSONObject;
  }
  
  public void b(long paramLong)
  {
    this.f = paramLong;
  }
  
  public HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    if ((this.g) && (this.d != null)) {
      localHashMap.put("u-s-id", this.d);
    }
    return localHashMap;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\utilities\info\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */