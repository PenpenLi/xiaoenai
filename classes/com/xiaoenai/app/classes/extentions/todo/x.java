package com.xiaoenai.app.classes.extentions.todo;

import android.content.Context;
import android.widget.ImageButton;
import com.xiaoenai.app.net.m;
import org.json.JSONObject;

class x
  extends m
{
  x(TodoDetailActivity paramTodoDetailActivity, Context paramContext)
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
    TodoDetailActivity.a(this.a, false);
    this.a.l_();
    if (TodoDetailActivity.i(this.a) == ao.a().c() - 1)
    {
      ao.a().e(TodoDetailActivity.c(this.a));
      if (ao.a().c() == 0) {
        this.a.r();
      }
      do
      {
        return;
        TodoDetailActivity.e(this.a);
      } while ((!TodoDetailActivity.g(this.a).isEnabled()) || (ao.a().f()));
      TodoDetailActivity.b(this.a, false);
      return;
    }
    if (TodoDetailActivity.i(this.a) == 0)
    {
      ao.a().e(TodoDetailActivity.c(this.a));
      TodoDetailActivity.a(this.a, ao.a().a(TodoDetailActivity.i(this.a)));
      if (ao.a().c() == 0)
      {
        this.a.r();
        return;
      }
      TodoDetailActivity.c(this.a, false);
      TodoDetailActivity.o(this.a);
      return;
    }
    ao.a().e(TodoDetailActivity.c(this.a));
    TodoDetailActivity.p(this.a);
    TodoDetailActivity.h(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */