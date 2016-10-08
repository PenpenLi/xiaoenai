package com.xiaoenai.app.classes.street.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.xiaoenai.app.classes.street.pay.a.i.a;

class c
  implements DialogInterface.OnDismissListener
{
  c(b paramb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (b.a(this.a) != null) {
      b.a(this.a).a("invalid");
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */