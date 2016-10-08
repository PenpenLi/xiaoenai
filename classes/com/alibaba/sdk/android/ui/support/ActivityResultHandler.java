package com.alibaba.sdk.android.ui.support;

import android.app.Activity;
import android.content.Intent;
import java.util.Map;

public abstract interface ActivityResultHandler
{
  public static final int CALLBACK_CONTEXT = 1;
  public static final String REQUEST_CODE_KEY = "requestCodeKey";
  public static final int TAE_SDK_ACTIVITY = 2;
  public static final int WEB_VIEW_ACTIVITY_SUPPORT = 3;
  public static final int WEB_VIEW_PROXY_ACTIVITY_SUPPORT = 4;
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, Activity paramActivity, Map<Class<?>, Object> paramMap);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\ui\support\ActivityResultHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */