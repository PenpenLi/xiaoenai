package com.alibaba.sdk.android.ui.support;

import android.app.Activity;
import android.content.Intent;
import java.util.Map;

public abstract interface UserActivityResultHandler
{
  public static final String REQUEST_CODE_KEY = "requestCodeKey";
  
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, Map paramMap);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\support\UserActivityResultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */