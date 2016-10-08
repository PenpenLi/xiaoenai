package com.xiaoenai.app.classes.extentions.todo;

import com.xiaoenai.app.classes.extentions.todo.a.b;
import java.util.Comparator;

class u
  implements Comparator<b>
{
  u(TodoActivity paramTodoActivity) {}
  
  public int a(b paramb1, b paramb2)
  {
    if (paramb1.b() - paramb2.b() > 0L) {
      return -1;
    }
    return 1;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */