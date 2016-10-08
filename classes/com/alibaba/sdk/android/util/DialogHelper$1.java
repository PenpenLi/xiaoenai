package com.alibaba.sdk.android.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class DialogHelper$1
  implements DialogInterface.OnClickListener
{
  DialogHelper$1(Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.val$r.run();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\DialogHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */