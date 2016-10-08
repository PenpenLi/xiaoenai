package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.ab;

class w
  implements View.OnClickListener
{
  w(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a);
    if ((-1 == TodoDetailActivity.i(this.a)) && (TodoDetailActivity.n(this.a)))
    {
      this.a.c();
      return;
    }
    if (TodoDetailActivity.n(this.a)) {
      TodoDetailActivity.a(this.a, false, null, null);
    }
    this.a.r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */