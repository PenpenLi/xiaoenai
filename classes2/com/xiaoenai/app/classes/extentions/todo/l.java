package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import com.xiaoenai.app.classes.extentions.todo.a.b;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class l
  extends m
{
  l(h paramh, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(false);
  }
  
  public void a(int paramInt)
  {
    this.b.f();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.f();
    b localb = new b();
    localb.c(paramJSONObject.getInt("id"));
    localb.a(paramJSONObject.optLong("created_ts"));
    localb.a(this.a);
    localb.b(true);
    localb.a(false);
    localb.b(User.getInstance().getUserId());
    ao.a().c(localb);
    if (this.b.getActivity() != null)
    {
      h.c(this.b.getActivity());
      if (!(this.b.getActivity() instanceof TodoActivity)) {}
    }
    else
    {
      return;
    }
    ((TodoDetailActivity)this.b.getActivity()).r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */