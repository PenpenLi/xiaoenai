package com.xiaoenai.app.classes.home;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.e.b;
import org.json.JSONException;
import org.json.JSONObject;

class ag
  extends m
{
  h a = h.a(this.b.a.getActivity());
  
  ag(ae paramae, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.a.show();
    super.a();
  }
  
  public void a(int paramInt)
  {
    this.a.dismiss();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a.dismiss();
    try
    {
      new User(paramJSONObject.getJSONObject("user_info")).save();
      User.release();
      ((HomeActivity)this.b.a.getActivity()).d();
      b.b(User.getInstance().getCouplePhotoUrl(), paramJSONObject.optString("url"));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\home\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */