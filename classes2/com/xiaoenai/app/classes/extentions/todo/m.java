package com.xiaoenai.app.classes.extentions.todo;

import android.view.View;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.ui.a.k.a;

class m
  implements k.a
{
  m(h paramh) {}
  
  public void a(k paramk, View paramView)
  {
    paramk.dismiss();
    h.c(this.a.getActivity());
    if ((this.a.getActivity() instanceof TodoDetailActivity)) {
      ((TodoDetailActivity)this.a.getActivity()).r();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */