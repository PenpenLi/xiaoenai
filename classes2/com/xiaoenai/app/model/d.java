package com.xiaoenai.app.model;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

final class d
  extends m
{
  d(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    Xiaoenai.j().a(new e(this));
  }
  
  public void a(int paramInt)
  {
    HomeModeSettings.access$002(false);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    HomeModeSettings.handleFunStatus(paramJSONObject);
    Xiaoenai.j().a(new f(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\model\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */