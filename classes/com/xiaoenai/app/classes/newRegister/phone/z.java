package com.xiaoenai.app.classes.newRegister.phone;

import android.graphics.Color;
import android.os.Handler;
import android.widget.TextView;

class z
  implements Runnable
{
  z(PhoneRegisterVerifyActivity paramPhoneRegisterVerifyActivity) {}
  
  public void run()
  {
    if (this.a.regetVerifyCodeText != null)
    {
      PhoneRegisterVerifyActivity.a(this.a);
      this.a.regetVerifyCodeText.setText(String.format(this.a.getString(2131100963), new Object[] { String.valueOf(PhoneRegisterVerifyActivity.b(this.a)) }));
      if (PhoneRegisterVerifyActivity.b(this.a) <= 0)
      {
        this.a.regetVerifyCodeText.setClickable(true);
        this.a.regetVerifyCodeText.setText(this.a.getString(2131100965));
        this.a.regetVerifyCodeText.setTextColor(Color.parseColor("#007AFF"));
        PhoneRegisterVerifyActivity.a(this.a, 60);
      }
    }
    else
    {
      return;
    }
    PhoneRegisterVerifyActivity.c(this.a).postDelayed(this, 1000L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */