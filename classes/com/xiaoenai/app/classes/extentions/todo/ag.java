package com.xiaoenai.app.classes.extentions.todo;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.xiaoenai.app.classes.extentions.todo.a.b;

class ag
  extends Handler
{
  ag(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1)
    {
      paramMessage = (String)paramMessage.obj;
      TodoDetailActivity.c(this.a).a(paramMessage);
      TodoDetailActivity.a(this.a).setText(TodoDetailActivity.c(this.a).f());
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */