package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.g;
import org.json.JSONObject;

public final class d
{
  static e cw;
  private static b cx = ;
  private static JSONObject cz = new JSONObject();
  String c = null;
  Integer cy = null;
  
  public d(Context paramContext)
  {
    try
    {
      u(paramContext);
      this.cy = l.F(paramContext.getApplicationContext());
      this.c = g.r(paramContext).b();
      return;
    }
    catch (Throwable paramContext)
    {
      cx.b(paramContext);
    }
  }
  
  private static e u(Context paramContext)
  {
    try
    {
      if (cw == null) {
        cw = new e(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = cw;
      return paramContext;
    }
    finally {}
  }
  
  public final void a(JSONObject paramJSONObject, Thread paramThread)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (cw != null) {
        cw.a(localJSONObject, paramThread);
      }
      r.a(localJSONObject, "cn", this.c);
      if (this.cy != null) {
        localJSONObject.put("tn", this.cy);
      }
      if (paramThread == null) {
        paramJSONObject.put("ev", localJSONObject);
      }
      while ((cz != null) && (cz.length() > 0))
      {
        paramJSONObject.put("eva", cz);
        return;
        paramJSONObject.put("errkv", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      cx.b(paramJSONObject);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\tencent\wxop\stat\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */