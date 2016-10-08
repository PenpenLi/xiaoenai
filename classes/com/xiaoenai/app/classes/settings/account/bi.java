package com.xiaoenai.app.classes.settings.account;

import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.utils.as;

class bi
  implements View.OnClickListener
{
  bi(SettingPersonalActivity paramSettingPersonalActivity, e parame) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (SettingPersonalActivity.d(this.b) != null)
    {
      if (SettingPersonalActivity.k(this.b))
      {
        SettingPersonalActivity.p(this.b);
        return;
      }
      SettingPersonalActivity.l(this.b);
      return;
    }
    if (!as.a(this.b, "com.tencent.mm"))
    {
      as.b(2131101149);
      return;
    }
    paramView = ShareSDK.getPlatform(this.b, Wechat.NAME);
    paramView.setPlatformActionListener(new bj(this));
    paramView.authorize();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */