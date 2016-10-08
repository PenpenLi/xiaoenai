package com.xiaoenai.app.classes.forum;

import android.content.Context;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

final class dn
  extends m
{
  dn(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt)
  {
    dm.a(f.d());
    if (dm.d() < 3) {
      Xiaoenai.j().a(new do(this), 500L);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    dm.a(new f(paramJSONObject));
    f.b(paramJSONObject);
    dm.a(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */