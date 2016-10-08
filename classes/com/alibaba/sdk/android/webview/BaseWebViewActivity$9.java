package com.alibaba.sdk.android.webview;

import android.util.Log;
import com.alibaba.sdk.android.callback.FailureCallback;

class BaseWebViewActivity$9
  implements FailureCallback
{
  BaseWebViewActivity$9(BaseWebViewActivity paramBaseWebViewActivity) {}
  
  public void onFailure(int paramInt, String paramString)
  {
    Log.i("BaseWebViewActivity", "showFeedback fail:" + paramInt + "   " + paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\BaseWebViewActivity$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */