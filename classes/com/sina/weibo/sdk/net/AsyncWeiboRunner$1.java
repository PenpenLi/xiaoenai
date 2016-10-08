package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.exception.WeiboException;

class AsyncWeiboRunner$1
  extends Thread
{
  AsyncWeiboRunner$1(AsyncWeiboRunner paramAsyncWeiboRunner, String paramString1, String paramString2, WeiboParameters paramWeiboParameters, RequestListener paramRequestListener) {}
  
  public void run()
  {
    try
    {
      String str = HttpManager.openUrl(AsyncWeiboRunner.access$0(this.this$0), this.val$url, this.val$httpMethod, this.val$params);
      if (this.val$listener != null) {
        this.val$listener.onComplete(str);
      }
      return;
    }
    catch (WeiboException localWeiboException)
    {
      while (this.val$listener == null) {}
      this.val$listener.onWeiboException(localWeiboException);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\net\AsyncWeiboRunner$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */