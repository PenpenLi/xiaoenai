package com.xiaoenai.app.classes.extentions.todo;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import android.widget.TextView;

class v
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  v(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void onGlobalLayout()
  {
    TodoDetailActivity.a(this.a).setMinHeight(this.a.b.getHeight());
    TodoDetailActivity.b(this.a);
    this.a.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */