package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import android.view.View.OnClickListener;

class j
  implements View.OnClickListener
{
  j(h paramh) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.e()) {
      this.a.b();
    }
    do
    {
      return;
      h.c(this.a.getActivity());
    } while (!(this.a.getActivity() instanceof TodoDetailActivity));
    ((TodoDetailActivity)this.a.getActivity()).r();
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */