package com.sina.weibo.sdk.component;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;

class WeiboSdkBrowser$1
  implements RequestListener
{
  WeiboSdkBrowser$1(WeiboSdkBrowser paramWeiboSdkBrowser, ShareRequestParam paramShareRequestParam) {}
  
  public void onComplete(String paramString)
  {
    LogUtil.d(WeiboSdkBrowser.access$8(), "post onComplete : " + paramString);
    paramString = ShareRequestParam.UploadPicResult.parse(paramString);
    if ((paramString != null) && (paramString.getCode() == 1) && (!TextUtils.isEmpty(paramString.getPicId())))
    {
      WeiboSdkBrowser.access$9(this.this$0, this.val$req.buildUrl(paramString.getPicId()));
      return;
    }
    this.val$req.sendSdkErrorResponse(this.this$0, "upload pic faild");
    this.this$0.finish();
  }
  
  public void onWeiboException(WeiboException paramWeiboException)
  {
    LogUtil.d(WeiboSdkBrowser.access$8(), "post onWeiboException " + paramWeiboException.getMessage());
    this.val$req.sendSdkErrorResponse(this.this$0, paramWeiboException.getMessage());
    this.this$0.finish();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\component\WeiboSdkBrowser$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */