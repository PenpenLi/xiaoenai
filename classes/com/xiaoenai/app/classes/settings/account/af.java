package com.xiaoenai.app.classes.settings.account;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.CleanableEditText;
import org.json.JSONObject;

class af
  extends m
{
  af(SettingNameOrMailActivity paramSettingNameOrMailActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.a.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.a.l_();
    User.getInstance().setEmail(null);
    User.getInstance().save();
    this.a.mEtvEmailOrNickname.setText("");
    h.a(this.a, 2131101177, 1500L, new ag(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */