package com.alibaba.sdk.android.session.impl;

import java.util.Collections;
import java.util.Map;

public class CredentialManagerPolicy
{
  public Map<String, String> filterProperties = Collections.singletonMap("scope", "Taobao");
  public String internalSessionStoreKey = "internal_session";
  public boolean isUpdateUTUser = true;
  public boolean isUpdateWebCookie = true;
  public String refreshTokenStoreKey = "refresh_token";
  public String seedKey = "seed_key";
  public long sidForceRefreshInterval = 5000L;
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\session\impl\CredentialManagerPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */