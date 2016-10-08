package com.xiaoenai.app.classes.extentions.todo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class s
  implements View.OnClickListener
{
  s(TodoActivity paramTodoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, TodoDetailActivity.class);
    paramView.putExtra("index", -1);
    this.a.startActivity(paramView);
    this.a.overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */