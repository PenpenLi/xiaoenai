package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.xiaoenai.app.classes.extentions.todo.a.b;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import org.json.JSONObject;

class g
  extends m
{
  g(a parama, Context paramContext, boolean paramBoolean, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a) {
      this.c.a(false);
    }
  }
  
  public void a(int paramInt)
  {
    this.c.f();
    if (this.a) {
      super.a(paramInt);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.c.f();
    h.a(b(), "修改成功", 1000L);
    a.c().b(User.getInstance().getUserId());
    a.c().a(paramJSONObject.optLong("updated_ts"));
    a.c().a(this.b);
    a.c().a(false);
    a.c().b(true);
    ao.a().d(a.c());
    paramJSONObject = new Message();
    paramJSONObject.what = 1;
    paramJSONObject.obj = a.c().f();
    a.d().sendMessage(paramJSONObject);
    a.a(this.c.getActivity());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */