package com.xiaoenai.app.classes.common;

import android.content.Context;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class x
  extends m
{
  x(q paramq, Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    q.b(this.a, null);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    q.c(this.a);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    q.c(this.a);
    new User(paramJSONObject.getJSONObject("user_info")).save();
    User.release();
    this.a.b();
    this.a.a(1);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */