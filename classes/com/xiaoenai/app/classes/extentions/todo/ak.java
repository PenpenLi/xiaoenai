package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

class ak
  implements View.OnClickListener
{
  ak(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void onClick(View paramView)
  {
    if (TodoDetailActivity.g(this.a).isEnabled()) {
      TodoDetailActivity.g(this.a).performClick();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */