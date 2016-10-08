package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.utils.ab;

class an
  implements View.OnClickListener
{
  an(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a);
    if (-1 == TodoDetailActivity.i(this.a))
    {
      if (TodoDetailActivity.j(this.a).getText().toString().trim().length() > 0)
      {
        TodoDetailActivity.a(this.a, TodoDetailActivity.j(this.a).getText().toString().trim());
        return;
      }
      this.a.r();
      return;
    }
    TodoDetailActivity.m(this.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */