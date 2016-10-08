package com.alibaba.sdk.android.webview.feedback;

import android.util.Log;
import com.alibaba.sdk.android.callback.FailureCallback;

class FeedbackActivity$3
  implements FailureCallback
{
  FeedbackActivity$3(FeedbackActivity paramFeedbackActivity) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    Log.i("FeedbackActivity", "saveImageAndGotoNextActivity fail:" + paramInt + "   " + paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\feedback\FeedbackActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */