package com.xiaoenai.app.classes.extentions.menses;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class k
  implements DialogInterface.OnDismissListener
{
  k(j paramj) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MensesActivity.a(this.a.b.a, ac.a.a);
    MensesActivity.a(this.a.b.a, "leaving");
    MensesActivity.b(this.a.b.a, ac.a.a);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */