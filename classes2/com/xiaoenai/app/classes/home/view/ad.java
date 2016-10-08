package com.xiaoenai.app.classes.home.view;

import android.content.Context;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class ad
  extends m
{
  ad(LoverSearchView paramLoverSearchView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    LoverSearchView.a(this.a, "");
  }
  
  public void a(int paramInt)
  {
    LoverSearchView.c(this.a);
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LoverSearchView.c(this.a);
    String str = paramJSONObject.getString("lover_email");
    UserConfig.setString("home_search_lover_avatar", paramJSONObject.getString("lover_avatar"));
    UserConfig.setString("home_search_lover_email", str);
    LoverSearchView.b(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\view\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */