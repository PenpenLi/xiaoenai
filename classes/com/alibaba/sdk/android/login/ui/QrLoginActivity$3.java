package com.alibaba.sdk.android.login.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.util.ResourceUtils;

class QrLoginActivity$3
  implements View.OnClickListener
{
  QrLoginActivity$3(QrLoginActivity paramQrLoginActivity, Button paramButton1, Button paramButton2) {}
  
  public void onClick(View paramView)
  {
    this.this$0.loginWebViewWidget.loadQrLoginUrl(LoginContext.params);
    this.val$scan.setTextColor(this.this$0.getResources().getColor(ResourceUtils.getIdentifier(this.this$0, "color", "tae_sdk_login_qr_colors_highlight")));
    this.val$password.setTextColor(this.this$0.getResources().getColor(17170444));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\QrLoginActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */