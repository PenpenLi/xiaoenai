package com.xiaoenai.app.utils;

import android.app.Activity;
import android.content.Context;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.e.b;
import org.json.JSONException;
import org.json.JSONObject;

class j
  extends m
{
  j(g paramg, Context paramContext, Activity paramActivity, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    ((HomeActivity)this.a).a(this.a.getString(2131101606), false);
  }
  
  public void a(int paramInt)
  {
    ((HomeActivity)this.a).l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      ((HomeActivity)this.a).l_();
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          new User(paramJSONObject.getJSONObject("user_info")).save();
          User.release();
          ((HomeActivity)this.a).d();
          b.b(User.getInstance().getCouplePhotoUrl(), this.b);
          return;
          localException = localException;
          localException.printStackTrace();
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\utils\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */