package com.xiaoenai.app.classes.common;

import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class y
  extends m
{
  y(q paramq, Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject.has("img_key")) && (!paramJSONObject.isNull("img_key"))) {
      AppModel.getInstance().setImageKey(paramJSONObject.getString("img_key"));
    }
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (paramJSONObject.has("aud_key"))
      {
        j = i;
        if (!paramJSONObject.isNull("aud_key"))
        {
          AppModel.getInstance().setAudioKey(paramJSONObject.getString("aud_key"));
          j = 1;
        }
      }
      if (j != 0) {
        AppModel.getInstance().save();
      }
      paramJSONObject = new User(paramJSONObject.getJSONObject("user_info"));
      paramJSONObject.save();
      User.release();
      if ((this.a <= 0) && (paramJSONObject.getLoverId() > 0))
      {
        UserConfig.remove("home_search_lover_avatar");
        UserConfig.remove("home_search_lover_email");
        this.b.b(0);
        q.a(this.b, paramJSONObject.getLoverId());
        return;
      }
      if ((this.a > 0) && (paramJSONObject.getLoverId() <= 0))
      {
        this.b.b();
        this.b.a(1);
        q.a(this.b, 0);
        paramJSONObject = new Intent("com.xiaoenai.app.COCOS_ON_PUSH_RECIEVED");
        paramJSONObject.putExtra("Command", "single");
        q.d(this.b).sendBroadcast(paramJSONObject, q.d(this.b).getString(2131101650));
        return;
      }
      paramJSONObject = new Intent("com.xiaoenai.onProfileUpdate");
      Xiaoenai.j().sendBroadcast(paramJSONObject, Xiaoenai.j().getString(2131101650));
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */