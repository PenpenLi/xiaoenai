package com.alipay.apmobilesecuritysdk.face;

import com.alipay.security.mobile.module.a.a;
import com.taobao.dp.client.IInitResultListener;

class APSecuritySdk$RunningTask$1
  implements IInitResultListener
{
  APSecuritySdk$RunningTask$1(APSecuritySdk.RunningTask paramRunningTask) {}
  
  public void onInitFinished(String paramString, int paramInt)
  {
    APSecuritySdk.b(this.a.a, true);
    if (!a.a(paramString)) {
      APSecuritySdk.a(this.a.a, paramString);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\face\APSecuritySdk$RunningTask$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */