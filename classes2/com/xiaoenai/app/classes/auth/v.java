package com.xiaoenai.app.classes.auth;

import android.content.Context;
import android.content.res.Resources;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.model.status.StatusList;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.b.a;
import org.json.JSONObject;

class v
  extends m
{
  v(SimpleLoginView paramSimpleLoginView, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    SimpleLoginView.g(this.b).a(this.b.getResources().getString(2131099962), false);
  }
  
  public void a(int paramInt)
  {
    SimpleLoginView.g(this.b).l_();
    SimpleLoginView.r(this.b);
    if (SimpleLoginView.s(this.b) >= 3)
    {
      SimpleLoginView.t(this.b);
      return;
    }
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    SimpleLoginView.g(this.b).l_();
    paramJSONObject = a.b(paramJSONObject);
    if (paramJSONObject == null) {}
    do
    {
      return;
      JSONObject localJSONObject = paramJSONObject.getJSONObject("user_info");
      if (paramJSONObject.has("im_history_ts")) {
        UserConfig.setInt("im_history_ts", paramJSONObject.optInt("im_history_ts"));
      }
      AppModel.getInstance().loadFromJson(paramJSONObject);
      AppModel.getInstance().setLastLoginAccount(this.a);
      AppModel.getInstance().save();
      new User(localJSONObject).save();
      User.release();
      if (paramJSONObject.has("onekey_status")) {
        StatusList.getInstance().getStatusFromJson(paramJSONObject);
      }
    } while (SimpleLoginView.c(this.b) == null);
    SimpleLoginView.c(this.b).c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\auth\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */