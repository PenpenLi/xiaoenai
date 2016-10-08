package com.xiaoenai.app.classes.extentions.todo;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.xiaoenai.app.widget.TitleBarView;

class am
  implements TextWatcher
{
  am(TodoDetailActivity paramTodoDetailActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (-1 == TodoDetailActivity.i(this.a))
    {
      if (TodoDetailActivity.j(this.a).getText().toString().trim().length() > 0)
      {
        TodoDetailActivity.a(this.a, true);
        TodoDetailActivity.k(this.a).setRightButtonVisible(0);
      }
    }
    else {
      return;
    }
    TodoDetailActivity.a(this.a, false);
    TodoDetailActivity.l(this.a).setRightButtonVisible(8);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */