package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.ah;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class SettingPhoneInputActivity
  extends TitleBarActivity
{
  private boolean a;
  private String b;
  private Handler c = new Handler();
  private int i = 60;
  @BindView(2131559713)
  Button mBtnRegetCode;
  @BindView(2131559715)
  Button mBtnSubmit;
  @BindView(2131559714)
  Button mBtnUnbind;
  @BindView(2131559712)
  EditText mEtvCode;
  @BindView(2131559710)
  CleanableEditText mEtvPhone;
  @BindView(2131559711)
  LinearLayout mLlCodeLayout;
  @BindView(2131559709)
  LinearLayout mLlPhoneLayout;
  
  private void a(int paramInt)
  {
    setResult(paramInt);
    r();
  }
  
  private void a(String paramString1, String paramString2)
  {
    new l(new ct(this, this, paramString2)).g(paramString1, paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBtnRegetCode.setClickable(true);
      this.mBtnRegetCode.setBackgroundResource(2130837629);
      this.mBtnRegetCode.setTextColor(getResources().getColor(2131492906));
      return;
    }
    this.mBtnRegetCode.setClickable(false);
    this.mBtnRegetCode.setBackgroundResource(2130837633);
    this.mBtnRegetCode.setTextColor(getResources().getColor(2131492912));
  }
  
  private String b(String paramString)
  {
    return String.format("%s %s %s", new Object[] { paramString.substring(0, 3), paramString.substring(3, 7), paramString.substring(7) });
  }
  
  private void c()
  {
    if (this.a)
    {
      this.g.setTitle(2131101084);
      this.mEtvPhone.setHint(b(User.getInstance().getPhoneNum()));
      this.mEtvPhone.setHintTextColor(getResources().getColor(2131492885));
      this.mEtvPhone.setEnabled(false);
      getWindow().setSoftInputMode(3);
      this.mBtnUnbind.setVisibility(0);
      this.mBtnSubmit.setVisibility(8);
      this.mLlCodeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.mEtvPhone.setmIsPhoneFormat(true);
      w.a(this.mBtnSubmit);
      return;
      String str = UserConfig.getString("phone_code_num", null);
      a(false);
      if ((str != null) && (!this.a))
      {
        this.mEtvPhone.setText(b(str));
        a(true);
        this.b = str;
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((am.e(paramString)) && (paramString.length() == 11))
    {
      f(paramString);
      return;
    }
    h.c(this, 2131101212, 1500L);
  }
  
  private void d()
  {
    this.b = this.mEtvPhone.getFormatText();
    String str = this.mEtvCode.getText().toString();
    if ((str != null) && (str.length() > 0) && (am.e(str))) {
      a(str, this.b);
    }
    for (;;)
    {
      this.mEtvCode.getText().clear();
      return;
      h.c(this, 2131101216, 1500L);
    }
  }
  
  private void d(String paramString)
  {
    new ah(new cp(this, this, paramString)).b(paramString);
  }
  
  private void f()
  {
    a(false);
    this.mBtnRegetCode.setText(String.valueOf(this.i) + getString(2131101070));
    this.c.postDelayed(new cl(this), 1000L);
  }
  
  private void f(String paramString)
  {
    new k(this).a(2131101206, String.format(getString(2131101207), new Object[] { paramString }), 2131099973, new cr(this), 2131100898, new cs(this, paramString));
  }
  
  private void g()
  {
    new l(new cq(this, this)).a(false, true, false, false, false);
  }
  
  private void h()
  {
    k localk = new k(this);
    localk.d(k.i);
    localk.a(2131101195, 2131101202, new cu(this), 2131100898, new cv(this));
  }
  
  private void i()
  {
    new k(this).a(2131101208, 2131100898, new cm(this), 2131099973, new cn(this));
  }
  
  public int a()
  {
    return 2130903312;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new co(this));
  }
  
  @OnClick({2131559714, 2131559715, 2131559713})
  void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131559715) {
      d();
    }
    do
    {
      return;
      if (j == 2131559714)
      {
        i();
        return;
      }
    } while (j != 2131559713);
    c(this.mEtvPhone.getFormatText());
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131559712})
  void onCodeTextChange(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      w.b(this.mBtnSubmit);
      return;
    }
    w.a(this.mBtnSubmit);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    this.f = 2;
    this.a = getIntent().getBooleanExtra("isPhoneVerify", false);
    c();
  }
  
  @OnEditorAction({2131559710})
  boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = paramTextView.getText().toString().trim();
    if ((paramInt == 5) && (am.d(paramTextView))) {
      c(paramTextView);
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((!this.a) && (this.b != null)) {
        h();
      }
      for (;;)
      {
        return false;
        r();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131559710})
  void onPhoneTextChange(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      a(true);
      return;
    }
    a(false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\SettingPhoneInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */