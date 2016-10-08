package com.xiaoenai.app.classes.store;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;

final class c
  implements DialogInterface.OnDismissListener
{
  c(String paramString1, String paramString2, int paramInt, Context paramContext) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    a.a = false;
    paramDialogInterface = new Intent();
    paramDialogInterface.setAction(this.a);
    paramDialogInterface.putExtra(this.b, this.c);
    paramDialogInterface.setClass(this.d, StickerDetailActivity.class);
    this.d.startActivity(paramDialogInterface);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\store\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */