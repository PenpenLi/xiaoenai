package com.alibaba.sdk.android.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import com.alibaba.sdk.android.widget.TaeProgressDialog;

class DialogHelper$2
  implements Runnable
{
  DialogHelper$2(DialogHelper paramDialogHelper, String paramString, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void run()
  {
    if ((this.this$0.activity == null) || (this.this$0.activity.isFinishing())) {
      return;
    }
    DialogHelper.access$002(this.this$0, new TaeProgressDialog(this.this$0.activity));
    DialogHelper.access$000(this.this$0).setMessage(this.val$msg);
    ((TaeProgressDialog)DialogHelper.access$000(this.this$0)).setProgressVisiable(this.val$showProgressBar);
    DialogHelper.access$000(this.this$0).setCancelable(this.val$cancelable);
    DialogHelper.access$000(this.this$0).setOnCancelListener(this.val$cancelListener);
    DialogHelper.access$000(this.this$0).show();
    DialogHelper.access$000(this.this$0).setCanceledOnTouchOutside(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\DialogHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */