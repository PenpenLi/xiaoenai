package com.xiaoenai.app.classes.newRegister.phone;

import com.xiaoenai.app.classes.common.image.ImagePicker.b;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.e.b;

class k
  implements ImagePicker.b
{
  k(PhoneRegisterSettingPWActivity paramPhoneRegisterSettingPWActivity) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    PhoneRegisterSettingPWActivity.a(this.a, paramString);
    b.b(this.a.mAvatarImageView, "file://" + paramString, ab.a(62.0F));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */