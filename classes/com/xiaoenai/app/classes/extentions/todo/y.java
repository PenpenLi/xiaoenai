package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import com.xiaoenai.app.classes.extentions.todo.a.b;
import com.xiaoenai.app.net.m;
import com.xiaoenai.app.utils.ab;
import org.json.JSONObject;

class y
  extends m
{
  y(TodoDetailActivity paramTodoDetailActivity, Context paramContext, boolean paramBoolean, String paramString)
  {
    super(paramContext);
  }
  
  public void a()
  {
    if (this.a) {
      this.c.a(null, false);
    }
  }
  
  public void a(int paramInt)
  {
    this.c.l_();
    if (this.a) {
      super.a(paramInt);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.c.l_();
    b localb = ao.a().b(paramJSONObject.getInt("id"));
    if (localb != null)
    {
      if (this.b != null) {
        TodoDetailActivity.c(this.c).a(Boolean.valueOf(this.b.equals("1")));
      }
      localb.a(paramJSONObject.optLong("updated_ts"));
      localb.a(false);
      localb.b(true);
      ao.a().d(localb);
      if (localb.e() == TodoDetailActivity.c(this.c).e()) {
        TodoDetailActivity.o(this.c);
      }
    }
    ab.b(this.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */