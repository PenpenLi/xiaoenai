package com.alibaba.sdk.android.util;

import android.app.ProgressDialog;
import com.alibaba.sdk.android.trace.AliSDKLogger;

class DialogHelper$3
  implements Runnable
{
  DialogHelper$3(DialogHelper paramDialogHelper) {}
  
  public void run()
  {
    if ((DialogHelper.access$000(this.this$0) != null) && (DialogHelper.access$000(this.this$0).isShowing())) {}
    try
    {
      DialogHelper.access$000(this.this$0).dismiss();
      return;
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("kernel", localException.getMessage(), localException);
      return;
    }
    finally
    {
      DialogHelper.access$002(this.this$0, null);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\DialogHelper$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */