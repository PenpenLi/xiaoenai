package com.sina.weibo.sdk.api.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WeiboDownloader$2
  implements DialogInterface.OnClickListener
{
  WeiboDownloader$2(IWeiboDownloadListener paramIWeiboDownloadListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$listener != null) {
      this.val$listener.onCancel();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\share\WeiboDownloader$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */