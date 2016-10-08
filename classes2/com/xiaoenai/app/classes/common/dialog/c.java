package com.xiaoenai.app.classes.common.dialog;

import android.view.View;
import android.view.View.OnClickListener;

class c
  implements View.OnClickListener
{
  c(b paramb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isShowing()) {
      this.a.cancel();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */