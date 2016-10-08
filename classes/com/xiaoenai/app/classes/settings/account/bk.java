package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import com.xiaoenai.app.classes.common.dialog.e;

class bk
  implements View.OnClickListener
{
  bk(SettingPersonalActivity paramSettingPersonalActivity, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (SettingPersonalActivity.f(this.b) != null)
    {
      if (SettingPersonalActivity.k(this.b))
      {
        SettingPersonalActivity.q(this.b);
        return;
      }
      SettingPersonalActivity.l(this.b);
      return;
    }
    paramView = ShareSDK.getPlatform(this.b, QQ.NAME);
    paramView.authorize();
    paramView.setPlatformActionListener(new bl(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */