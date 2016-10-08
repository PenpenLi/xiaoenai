package com.alibaba.sdk.android.webview;

import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.sdk.android.util.FileUtils;
import java.io.File;

class TaeWebView$1
  implements Runnable
{
  TaeWebView$1(TaeWebView paramTaeWebView) {}
  
  public void run()
  {
    if (TaeWebView.access$000(this.this$0) != null) {}
    try
    {
      FileUtils.delete(new File(TaeWebView.access$000(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      AliSDKLogger.e("ui", "fail to delete cache " + TaeWebView.access$000(this.this$0), localException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\webview\TaeWebView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */