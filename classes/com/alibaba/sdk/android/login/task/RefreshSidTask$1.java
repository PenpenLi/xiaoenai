package com.alibaba.sdk.android.login.task;

import com.alibaba.sdk.android.ui.support.WebViewActivitySupport;

class RefreshSidTask$1
  implements Runnable
{
  RefreshSidTask$1(RefreshSidTask paramRefreshSidTask) {}
  
  public void run()
  {
    WebViewActivitySupport.getInstance().safeReload(RefreshSidTask.access$000(this.this$0));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\task\RefreshSidTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */