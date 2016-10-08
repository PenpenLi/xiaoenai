package com.alibaba.sdk.android.login.ui.handler;

import com.alibaba.sdk.android.AlibabaSDK;
import com.alibaba.sdk.android.ui.bus.handler.HandlerContext;
import com.alibaba.sdk.android.ui.bus.handler.HandlerInfo;
import com.alibaba.sdk.android.ui.bus.handler.impl.HandlerImpl;

public class LoginHandlerImpl
  extends HandlerImpl
{
  public LoginHandlerImpl(HandlerInfo paramHandlerInfo)
  {
    super(paramHandlerInfo);
  }
  
  public boolean doHandle(HandlerContext paramHandlerContext)
  {
    if (("T".equals(AlibabaSDK.getGlobalProperty("DEGRADE_NOT_LOGIN"))) || ("T".equals(AlibabaSDK.getGlobalProperty("AUTO_DEGRADE_NOT_LOGIN")))) {
      return false;
    }
    return super.doHandle(paramHandlerContext);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\handler\LoginHandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */