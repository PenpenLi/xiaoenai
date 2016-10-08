package com.xiaoenai.app.classes.extentions.menses;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class g
  implements DialogInterface.OnDismissListener
{
  g(f paramf) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MensesActivity.a(this.a.b.a, ac.a.c);
    MensesActivity.a(this.a.b.a, "comming");
    ac.a(System.currentTimeMillis());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */