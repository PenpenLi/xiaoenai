package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import com.xiaoenai.app.classes.extentions.todo.a.b;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONObject;

class ad
  extends m
{
  ad(TodoDetailActivity paramTodoDetailActivity, Context paramContext, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    this.b.a(null, false);
  }
  
  public void a(int paramInt)
  {
    this.b.l_();
    super.a(paramInt);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.b.l_();
    b localb = new b();
    localb.c(paramJSONObject.getInt("id"));
    localb.a(paramJSONObject.optLong("created_ts"));
    localb.a(this.a);
    localb.b(true);
    localb.a(false);
    localb.b(User.getInstance().getUserId());
    ao.a().c(localb);
    TodoDetailActivity.a(this.b, 0);
    TodoDetailActivity.a(this.b, localb);
    TodoDetailActivity.a(this.b, false);
    TodoDetailActivity.s(this.b).b(2130839004, 0);
    h.a(this.b, "保存成功", 1000L);
    TodoDetailActivity.o(this.b);
    TodoDetailActivity.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */