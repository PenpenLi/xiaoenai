package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.WeiboAppManager.WeiboInfo;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

public class SendMultiMessageToWeiboRequest
  extends BaseRequest
{
  public WeiboMultiMessage multiMessage;
  
  public SendMultiMessageToWeiboRequest() {}
  
  public SendMultiMessageToWeiboRequest(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  final boolean check(Context paramContext, WeiboAppManager.WeiboInfo paramWeiboInfo, VersionCheckHandler paramVersionCheckHandler)
  {
    if ((this.multiMessage == null) || (paramWeiboInfo == null) || (!paramWeiboInfo.isLegal())) {}
    while ((paramVersionCheckHandler != null) && (!paramVersionCheckHandler.checkRequest(paramContext, paramWeiboInfo, this.multiMessage))) {
      return false;
    }
    return this.multiMessage.checkArgs();
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.multiMessage = new WeiboMultiMessage(paramBundle);
  }
  
  public int getType()
  {
    return 1;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(this.multiMessage.toBundle(paramBundle));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\api\share\SendMultiMessageToWeiboRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */