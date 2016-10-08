package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.view.View.OnClickListener;

class e
  implements View.OnClickListener
{
  e(MensesActivity paramMensesActivity) {}
  
  public void onClick(View paramView)
  {
    switch (q.a[MensesActivity.a(this.a).ordinal()])
    {
    default: 
      return;
    case 1: 
      paramView = new com.xiaoenai.app.classes.common.dialog.e(this.a);
      paramView.a(2131100864, 1, new f(this, paramView));
      paramView.show();
      return;
    case 2: 
      paramView = new com.xiaoenai.app.classes.common.dialog.e(this.a);
      paramView.a(2131100864, 1, new h(this, paramView));
      paramView.show();
      return;
    }
    paramView = new com.xiaoenai.app.classes.common.dialog.e(this.a);
    paramView.a(2131100864, 1, new j(this, paramView));
    paramView.show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */