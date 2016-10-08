package com.alibaba.sdk.android.session.impl;

import com.alibaba.sdk.android.session.SessionListener;
import com.alibaba.sdk.android.trace.AliSDKLogger;

class CredentialManager$1
  implements Runnable
{
  CredentialManager$1(CredentialManager paramCredentialManager, SessionListener paramSessionListener) {}
  
  public void run()
  {
    try
    {
      this.val$listener.onStateChanged(this.this$0.getSession());
      return;
    }
    catch (Exception localException)
    {
      AliSDKLogger.e(CredentialManager.access$100(), "Fail to post the session changes to the registered listener", localException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\impl\CredentialManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */