package com.alibaba.sdk.android.util;

import android.widget.Toast;
import com.alibaba.sdk.android.impl.KernelContext;

final class CommonUtils$4
  implements Runnable
{
  CommonUtils$4(String paramString) {}
  
  public void run()
  {
    Toast.makeText(KernelContext.context, ResourceUtils.getString(this.val$strId), 0).show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\util\CommonUtils$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */