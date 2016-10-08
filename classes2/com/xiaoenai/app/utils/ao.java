package com.xiaoenai.app.utils;

import android.content.Context;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

final class ao
  extends m
{
  ao(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getBoolean("new_ver")) {
      an.a(b(), paramJSONObject.getString("content"), paramJSONObject.getString("url"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */