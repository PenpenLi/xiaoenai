package com.xiaoenai.app.classes.common.share;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.xiaoenai.app.model.UserConfig;

public class a
{
  public static Oauth2AccessToken a()
  {
    Oauth2AccessToken localOauth2AccessToken = new Oauth2AccessToken();
    localOauth2AccessToken.setUid(UserConfig.getString("weibo_key_uid", ""));
    localOauth2AccessToken.setToken(UserConfig.getString("weibo_access_token", ""));
    localOauth2AccessToken.setExpiresTime(UserConfig.getLong("weibo_expires_in", 0L));
    return localOauth2AccessToken;
  }
  
  public static void a(Oauth2AccessToken paramOauth2AccessToken)
  {
    if (paramOauth2AccessToken == null) {
      return;
    }
    UserConfig.setString("weibo_key_uid", paramOauth2AccessToken.getUid());
    UserConfig.setString("weibo_access_token", paramOauth2AccessToken.getToken());
    UserConfig.setLong("weibo_expires_in", paramOauth2AccessToken.getExpiresTime());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\share\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */