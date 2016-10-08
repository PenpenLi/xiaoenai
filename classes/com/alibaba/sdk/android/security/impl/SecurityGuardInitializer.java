package com.alibaba.sdk.android.security.impl;

import android.text.TextUtils;
import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ConfigManager;
import com.alibaba.sdk.android.ResultCode;
import com.alibaba.sdk.android.app.AppContext;
import com.alibaba.sdk.android.message.Message;
import com.alibaba.sdk.android.message.MessageUtils;
import com.alibaba.sdk.android.security.SecRuntimeException;
import com.alibaba.sdk.android.trace.AliSDKLogger;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;

public class SecurityGuardInitializer
{
  private ResultCode createResultCode(int paramInt, Exception paramException)
  {
    Object localObject;
    if (TextUtils.isEmpty(ConfigManager.POSTFIX_OF_SECURITY_JPG))
    {
      localObject = "";
      switch (paramInt)
      {
      default: 
        localObject = MessageUtils.createMessage(10010, new Object[] { paramException.getMessage() + " sec code " + paramInt });
      }
    }
    for (;;)
    {
      AliSDKLogger.log("security", (Message)localObject, paramException);
      return ResultCode.create((Message)localObject);
      localObject = "_" + ConfigManager.POSTFIX_OF_SECURITY_JPG;
      break;
      localObject = MessageUtils.createMessage(704, new Object[0]);
      continue;
      localObject = MessageUtils.createMessage(701, new Object[] { localObject });
      continue;
      localObject = MessageUtils.createMessage(702, new Object[] { localObject });
      continue;
      localObject = MessageUtils.createMessage(705, new Object[] { localObject });
    }
  }
  
  public ResultCode init(AppContext paramAppContext)
  {
    try
    {
      SecurityGuardManager.getInitializer().initialize(paramAppContext.getAndroidContext());
      if (SecurityGuardManager.getInstance(paramAppContext.getAndroidContext()) == null) {
        return ResultCode.SECURITY_GUARD_INIT_EXCEPTION;
      }
      if (AlibabaSDK.getGlobalProperty("com.alibaba.app.appkey") == null) {
        AlibabaSDK.setGlobalProperty("com.alibaba.app.appkey", SecurityGuardWrapper.INSTANCE.getAppKey());
      }
      return ResultCode.SUCCESS;
    }
    catch (SecException paramAppContext)
    {
      return createResultCode(paramAppContext.getErrorCode(), paramAppContext);
    }
    catch (SecRuntimeException paramAppContext) {}
    return createResultCode(paramAppContext.getErrorCode(), paramAppContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\security\impl\SecurityGuardInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */