package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.net.ah;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class PhoneRegisterActivity
  extends TitleBarActivity
{
  private String a;
  @BindView(2131558687)
  CleanableEditText phoneNumEditTxt;
  @BindView(2131558688)
  Button registerBtn;
  
  private void b(String paramString)
  {
    if ((am.e(paramString)) && (paramString.length() == 11))
    {
      c(paramString);
      return;
    }
    h.c(this, 2131101212, 1500L);
  }
  
  private void c()
  {
    this.phoneNumEditTxt.setmIsPhoneFormat(true);
    AppModel localAppModel = AppModel.getInstance();
    String str = "";
    if (localAppModel != null) {
      str = localAppModel.getLastRegisterPhoneNumber();
    }
    if (!TextUtils.isEmpty(str))
    {
      this.phoneNumEditTxt.setText(str);
      this.phoneNumEditTxt.setSelection(this.phoneNumEditTxt.getText().length());
      return;
    }
    w.a(this.registerBtn);
  }
  
  private void c(String paramString)
  {
    new k(this).a(2131101206, String.format(getString(2131101207), new Object[] { paramString }), 2131099973, new b(this), 2131100898, new c(this, paramString));
  }
  
  private void d()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, PhoneRegisterVerifyActivity.class);
    localIntent.putExtra("phone_register_verify_phone_number", this.a);
    localIntent.putExtra("from", 1);
    startActivityForResult(localIntent, 1000);
  }
  
  private void d(String paramString)
  {
    new ah(new d(this, this, paramString)).a(paramString, 1);
  }
  
  public int a()
  {
    return 2130903072;
  }
  
  protected void b()
  {
    super.b();
    if (this.g != null) {
      this.g.setLeftButtonClickListener(new a(this));
    }
  }
  
  @OnClick({2131558688})
  void doClick(View paramView)
  {
    ab.b(this);
    b(this.phoneNumEditTxt.getText().toString().replace(" ", ""));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    this.f = 1;
    ButterKnife.bind(this);
    c();
    if (getIntent() != null)
    {
      paramBundle = getIntent();
      String str = paramBundle.getStringExtra("phoneNumberText");
      if (!TextUtils.isEmpty(str)) {
        this.phoneNumEditTxt.setText(str);
      }
      if (!TextUtils.isEmpty(paramBundle.getStringExtra("alarm_from"))) {
        AppSettings.setBoolean("register_is_remind", Boolean.valueOf(true));
      }
    }
  }
  
  @OnEditorAction({2131558687})
  boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 5)
    {
      ab.b(this);
      b(this.phoneNumEditTxt.getFormatText());
    }
    return false;
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
    Intent localIntent = new Intent();
    localIntent.putExtra("phoneNumberText", this.phoneNumEditTxt.getText().toString());
    com.xiaoenai.app.utils.a.a(this, localIntent, "from_register_one", 1001, ConfigCenter.getRegisterStayTime());
  }
  
  protected void onResume()
  {
    super.onResume();
    com.xiaoenai.app.utils.a.a(this, 1001);
  }
  
  @OnTextChanged({2131558687})
  void onTextChanged(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() > 0)
    {
      w.b(this.registerBtn);
      return;
    }
    w.a(this.registerBtn);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\PhoneRegisterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */