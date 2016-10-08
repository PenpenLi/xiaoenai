package org.cocos2dx.cpp;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.f.a;
import org.json.JSONObject;

final class l
  extends m
{
  l(Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(com.xiaoenai.app.net.k paramk) {}
  
  public void a(JSONObject paramJSONObject)
  {
    a.c("{}", new Object[] { this.a });
    a.a(paramJSONObject);
    if ("xiaoenai.wishtree.index".equals(this.a))
    {
      i.a().a(this.a, paramJSONObject);
      UserConfig.setString("game_wishtree", paramJSONObject.toString());
      k.a(this.a);
    }
    while (!"xiaoenai.lovepet.index".equals(this.a)) {
      return;
    }
    i.a().a(this.a, paramJSONObject);
    UserConfig.setString("game_lovepet", paramJSONObject.toString());
    k.a(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\org\cocos2dx\cpp\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */