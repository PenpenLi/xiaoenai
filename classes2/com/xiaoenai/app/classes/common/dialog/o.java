package com.xiaoenai.app.classes.common.dialog;

import android.view.View;
import android.view.View.OnClickListener;

class o
  implements View.OnClickListener
{
  o(EditDialog paramEditDialog) {}
  
  public void onClick(View paramView)
  {
    if (EditDialog.a(this.a) != null) {
      EditDialog.a(this.a).a(paramView, this.a.messageText);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\dialog\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */