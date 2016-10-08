package com.alibaba.sdk.android.login.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import com.alibaba.sdk.android.login.impl.LoginContext;
import com.alibaba.sdk.android.login.utils.StringUtil;
import com.alibaba.sdk.android.util.ResourceUtils;

public class QrLoginActivity
  extends Activity
{
  protected LoginWebViewWidget loginWebViewWidget;
  
  private int getLayoutId()
  {
    String str = getIntent().getExtras().getString("userDefLayoutId");
    if (!StringUtil.isBlank(str)) {
      return ResourceUtils.getRLayout(this, str);
    }
    return ResourceUtils.getRLayout(this, "tae_sdk_login_qr_activity_layout");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getLayoutId());
    paramBundle = Typeface.createFromAsset(getAssets(), "tae_sdk_login.ttf");
    Button localButton1 = (Button)findViewById(ResourceUtils.getRId(this, "tae_sdk_qr_login_button_close"));
    localButton1.setOnClickListener(new QrLoginActivity.1(this));
    localButton1.setTypeface(paramBundle);
    ((TextView)findViewById(ResourceUtils.getRId(this, "tae_sdk_login_qr_text_taobao"))).setTypeface(paramBundle);
    this.loginWebViewWidget = ((LoginWebViewWidget)findViewById(ResourceUtils.getRId(this, "login_web_view")));
    localButton1 = (Button)findViewById(ResourceUtils.getRId(this, "tae_sdk_login_qr_button_password"));
    localButton1.setTypeface(paramBundle);
    Button localButton2 = (Button)findViewById(ResourceUtils.getRId(this, "tae_sdk_login_qr_button_scan"));
    localButton1.setOnClickListener(new QrLoginActivity.2(this, localButton1, localButton2));
    localButton2.setTypeface(paramBundle);
    localButton2.setTextColor(getResources().getColor(ResourceUtils.getIdentifier(this, "color", "tae_sdk_login_qr_colors_highlight")));
    localButton2.setOnClickListener(new QrLoginActivity.3(this, localButton2, localButton1));
    this.loginWebViewWidget.loadQrLoginUrl(LoginContext.params);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.loginWebViewWidget.destroyWebView();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setResult(10003);
    finish();
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\login\ui\QrLoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */