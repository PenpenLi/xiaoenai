package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.utils.ab;

class d
  implements View.OnClickListener
{
  d(a parama) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a.getActivity());
    paramView = this.a.h().getText().toString().trim();
    if ((paramView != null) && (!"".equals(paramView))) {
      a.a(this.a, true, paramView);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */