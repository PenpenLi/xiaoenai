package com.xiaoenai.app.classes.common.share;

import android.os.Bundle;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;

class n
  implements WeiboAuthListener
{
  n(l paraml) {}
  
  public void onCancel() {}
  
  public void onComplete(Bundle paramBundle)
  {
    a.a(Oauth2AccessToken.parseAccessToken(paramBundle));
  }
  
  public void onWeiboException(WeiboException paramWeiboException) {}
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */