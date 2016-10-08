package com.xiaoenai.app.classes.guide;

import android.content.Context;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.utils.e.d.h;
import org.json.JSONObject;

class k
  extends m
{
  k(NewVersionIntroActivity paramNewVersionIntroActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.a = paramJSONObject;
    b.a(this.a.a.getString("image_url"), new h(), true, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\guide\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */