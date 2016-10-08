package com.alibaba.sdk.android.session.impl;

import com.alibaba.sdk.android.session.model.InternalSession;
import com.alibaba.sdk.android.session.model.RefreshToken;
import com.alibaba.sdk.android.session.model.Session;
import com.alibaba.sdk.android.session.model.User;
import java.util.Map;

class CredentialManager$2
  implements Session
{
  CredentialManager$2(CredentialManager paramCredentialManager) {}
  
  public String getAuthorizationCode()
  {
    return CredentialManager.access$500(this.this$0);
  }
  
  public Long getLoginTime()
  {
    if (CredentialManager.access$300(this.this$0) == null) {
      return null;
    }
    return CredentialManager.access$300(this.this$0).createTime;
  }
  
  public Map<String, Object> getOtherInfo()
  {
    if (CredentialManager.access$400(this.this$0) == null) {
      return null;
    }
    return CredentialManager.access$400(this.this$0).otherInfo;
  }
  
  public User getUser()
  {
    if (!isLogin().booleanValue()) {}
    while (CredentialManager.access$400(this.this$0) == null) {
      return null;
    }
    return CredentialManager.access$400(this.this$0).user;
  }
  
  public String getUserId()
  {
    if (!isLogin().booleanValue()) {}
    while ((CredentialManager.access$400(this.this$0) == null) || (CredentialManager.access$400(this.this$0).user == null)) {
      return null;
    }
    return CredentialManager.access$400(this.this$0).user.id;
  }
  
  public Boolean isLogin()
  {
    if (!this.this$0.isRefreshTokenExpired()) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\impl\CredentialManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */