package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.settings.account.ResetPasswordActivity;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.net.ah;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.TitleBarView;

public class PhoneRegisterVerifyActivity
  extends TitleBarActivity
{
  private Handler a = new Handler();
  private int b = 1;
  private String c;
  private String i;
  private int j = 60;
  @BindView(2131558695)
  TextView phoneNumText;
  @BindView(2131558699)
  TextView regetVerifyCodeText;
  @BindView(2131558698)
  Button submitVerifyCodeBtn;
  @BindView(2131558696)
  TextView textHint;
  @BindView(2131558694)
  TextView tipsTxt;
  @BindView(2131558697)
  EditText verifyCodeEdit;
  
  private void a(String paramString1, String paramString2)
  {
    int k = 1;
    ah localah = new ah(new af(this, this, paramString1));
    if (this.b == 1) {}
    for (;;)
    {
      localah.a(paramString2, paramString1, k);
      return;
      k = 2;
    }
  }
  
  private void b(String paramString)
  {
    g localg = new g(this);
    localg.b(paramString);
    localg.a(2131100898, new ab(this));
    localg.show();
  }
  
  private void c()
  {
    this.tipsTxt.setText(Html.fromHtml(String.format(getResources().getString(2131100967), new Object[] { String.format("<font color='#f45595'>%s</font>", new Object[] { getResources().getString(2131100969) }) })));
    f();
    if ((this.b == 2) || (this.b == 3)) {
      this.g.a(getResources().getString(2131100657), null);
    }
    d();
  }
  
  private void c(String paramString)
  {
    int k = 1;
    ah localah = new ah(new ae(this, this));
    if (this.b == 1) {}
    for (;;)
    {
      localah.a(paramString, k);
      return;
      k = 2;
    }
  }
  
  private void d()
  {
    int n = com.xiaoenai.app.utils.ab.a(this.textHint, this.textHint.getText().toString());
    int m = this.verifyCodeEdit.getWidth();
    int k = m;
    if (m == 0) {
      k = com.xiaoenai.app.utils.ab.a(154.0F);
    }
    m = (k - n) / 2 - 1;
    com.xiaoenai.app.utils.f.a.c("hintTextLength {}", new Object[] { Integer.valueOf(n) });
    com.xiaoenai.app.utils.f.a.c("editTextWidth {}", new Object[] { Integer.valueOf(k) });
    com.xiaoenai.app.utils.f.a.c("padding {}", new Object[] { Integer.valueOf(m) });
    this.verifyCodeEdit.setPadding(m, 0, 0, 0);
  }
  
  private void f()
  {
    String str1 = this.c.substring(0, 3);
    String str2 = this.c.substring(3, 7);
    String str3 = this.c.substring(7);
    this.phoneNumText.setText(String.format("+86 %s %s %s", new Object[] { str1, str2, str3 }));
  }
  
  private void g()
  {
    this.regetVerifyCodeText.setClickable(false);
    this.regetVerifyCodeText.setTextColor(Color.parseColor("#6d6d72"));
    this.regetVerifyCodeText.setText(String.format(getString(2131100963), new Object[] { String.valueOf(this.j) }));
    this.a.postDelayed(new z(this), 1000L);
  }
  
  private void h()
  {
    new k(this).a(2131101203, 2131099966, new ac(this), 2131101202, new ad(this));
  }
  
  private void i()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, PhoneRegisterSettingPWActivity.class);
    localIntent.putExtra("phone_register_setting_pw_phone_number", this.c);
    localIntent.putExtra("phone_register_verify_code", this.i);
    startActivity(localIntent);
    finish();
  }
  
  private void j()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, ResetPasswordActivity.class);
    localIntent.putExtra("setting_password_phone_number", this.c);
    localIntent.putExtra("setting_password_verify_code", this.i);
    if (this.b == 3) {
      localIntent.putExtra("from", "findPW");
    }
    for (;;)
    {
      startActivity(localIntent);
      finish();
      return;
      if (this.b == 2) {
        localIntent.putExtra("from", "resetpassword");
      }
    }
  }
  
  @OnTextChanged({2131558697})
  void OnTextChanged(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() > 0)
    {
      w.b(this.submitVerifyCodeBtn);
      this.verifyCodeEdit.setGravity(17);
      this.verifyCodeEdit.setPadding(0, 0, 0, 0);
      return;
    }
    w.a(this.submitVerifyCodeBtn);
    this.verifyCodeEdit.setGravity(16);
    d();
  }
  
  public int a()
  {
    return 2130903074;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new aa(this));
  }
  
  @OnClick({2131558699})
  void doClick()
  {
    c(this.c);
  }
  
  @OnClick({2131558698})
  void next()
  {
    String str = this.verifyCodeEdit.getText().toString();
    if ((str != null) && (str.length() > 0) && (am.e(str)))
    {
      a(str, this.c);
      return;
    }
    b(getString(2131101216));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    if (getIntent() != null)
    {
      this.c = getIntent().getStringExtra("phone_register_verify_phone_number");
      this.b = getIntent().getIntExtra("from", 1);
      if (!TextUtils.isEmpty(getIntent().getStringExtra("alarm_from"))) {
        AppSettings.setBoolean("register_is_remind", Boolean.valueOf(true));
      }
    }
    ButterKnife.bind(this);
    c();
    g();
    w.a(this.submitVerifyCodeBtn);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      h();
      return false;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getStringExtra("alarm_from")))) {
      AppSettings.setBoolean("register_is_remind", Boolean.valueOf(true));
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.b == 1)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("phone_register_verify_phone_number", this.c);
      localIntent.putExtra("from", this.b);
      com.xiaoenai.app.utils.a.a(this, localIntent, "from_register_verify", 1001, ConfigCenter.getRegisterStayTime());
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.b == 1) {
      com.xiaoenai.app.utils.a.a(this, 1001);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\PhoneRegisterVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */