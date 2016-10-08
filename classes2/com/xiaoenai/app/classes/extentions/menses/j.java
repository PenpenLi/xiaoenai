package com.xiaoenai.app.classes.extentions.menses;

import android.view.View;
import android.view.View.OnClickListener;

class j
  implements View.OnClickListener
{
  j(e parame, com.xiaoenai.app.classes.common.dialog.e parame1) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    this.a.setOnDismissListener(new k(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */