package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.utils.ab;

class c
  implements View.OnClickListener
{
  c(a parama) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a.getActivity());
    if ((!this.a.e()) && (a.a(this.a)))
    {
      this.a.b();
      return;
    }
    a.a(this.a.getActivity());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */