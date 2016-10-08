package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class k
  implements View.OnClickListener
{
  k(h paramh) {}
  
  public void onClick(View paramView)
  {
    paramView = h.a(this.a).getText().toString().trim();
    if ((paramView != null) && (!"".equals(paramView))) {
      h.a(this.a, paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */