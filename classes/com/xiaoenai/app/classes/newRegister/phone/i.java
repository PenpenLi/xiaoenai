package com.xiaoenai.app.classes.newRegister.phone;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.xiaoenai.app.widget.TitleBarView;

class i
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  i(PhoneRegisterSettingPWActivity paramPhoneRegisterSettingPWActivity) {}
  
  public void onGlobalLayout()
  {
    PhoneRegisterSettingPWActivity.a(this.a, this.a.mAvatarLayout.getHeight());
    PhoneRegisterSettingPWActivity.b(this.a, PhoneRegisterSettingPWActivity.a(this.a).getHeight());
    this.a.mAvatarLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */