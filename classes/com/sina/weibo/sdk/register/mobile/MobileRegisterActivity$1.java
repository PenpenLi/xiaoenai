package com.sina.weibo.sdk.register.mobile;

import android.os.CountDownTimer;
import android.widget.Button;
import com.sina.weibo.sdk.utils.ResourceManager;

class MobileRegisterActivity$1
  extends CountDownTimer
{
  MobileRegisterActivity$1(MobileRegisterActivity paramMobileRegisterActivity, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    MobileRegisterActivity.access$7(this.this$0).setText(ResourceManager.getString(this.this$0.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼"));
    MobileRegisterActivity.access$8(this.this$0);
  }
  
  public void onTick(long paramLong)
  {
    MobileRegisterActivity.access$7(this.this$0).setText(ResourceManager.getString(this.this$0.getApplicationContext(), "Get code", "获取验证码", "獲取驗證碼") + "(" + paramLong / 1000L + "s)");
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\MobileRegisterActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */