package com.xiaoenai.app.classes.extentions.todo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.extentions.todo.a.b;

class p
  implements View.OnClickListener
{
  p(o paramo, b paramb, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    ao.a().d(this.a);
    paramView = new Intent(o.a(this.c), TodoDetailActivity.class);
    paramView.putExtra("index", o.a(this.c, this.b));
    paramView.putExtra("id", this.a.e());
    o.a(this.c).startActivity(paramView);
    o.a(this.c).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */