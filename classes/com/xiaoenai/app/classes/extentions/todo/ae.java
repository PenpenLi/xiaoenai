package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.widget.EditText;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;
import com.xiaoenai.app.utils.ab;

class ae
  implements k.a
{
  ae(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    ab.b(this.a);
    this.a.r();
    TodoDetailActivity.j(this.a).setText("");
    TodoDetailActivity.d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */