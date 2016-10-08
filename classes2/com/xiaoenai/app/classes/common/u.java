package com.xiaoenai.app.classes.common;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class u
  extends m
{
  u(q paramq, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    q.b(this.a, "");
    q.b(this.a).setCancelable(false);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    q.c(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    q.c(this.a);
    UserConfig.remove("home_inviter");
    UserConfig.remove("is_getting_invite");
    JSONObject localJSONObject = paramJSONObject.getJSONObject("user_info");
    UserConfig.setInt("im_history_ts", paramJSONObject.optInt("im_history_ts"));
    paramJSONObject = new User(localJSONObject);
    if (paramJSONObject.getLoverId() > 0)
    {
      UserConfig.remove("home_search_lover_avatar");
      UserConfig.remove("home_search_lover_email");
      paramJSONObject.save();
      User.release();
      this.a.a(0);
      return;
    }
    h.c(q.d(this.a), 2131100899, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */