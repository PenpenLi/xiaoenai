package com.xiaoenai.app.utils;

import android.content.Context;
import com.xiaoenai.app.net.k;
import com.xiaoenai.app.net.m;
import org.cocos2dx.cpp.GameBaseActivity;
import org.json.JSONObject;

final class ap
  extends m
{
  ap(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    super.a();
    ((GameBaseActivity)b()).a(null, true);
  }
  
  public void a(int paramInt)
  {
    ((GameBaseActivity)b()).b();
  }
  
  public void a(k paramk)
  {
    ((GameBaseActivity)b()).b();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    ((GameBaseActivity)b()).b();
    if (paramJSONObject.getBoolean("new_ver")) {
      an.a(b(), paramJSONObject.getString("content"), paramJSONObject.getString("url"));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */