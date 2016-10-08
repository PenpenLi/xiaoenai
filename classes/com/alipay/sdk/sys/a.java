package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private String a;
  private String b;
  
  public a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.a = paramContext.versionName;
      this.b = paramContext.packageName;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appkey", "2014052600006128");
      localJSONObject.put("ty", "and_lite");
      localJSONObject.put("sv", "h.a.3.0.1");
      localJSONObject.put("an", this.b);
      localJSONObject.put("av", this.a);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException) {}
    return "";
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\sdk\sys\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */