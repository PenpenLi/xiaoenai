package com.xiaoenai.app.classes.settings.account;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;
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
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.k;
import com.xiaoenai.app.utils.am.a;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class SettingNameOrMailActivity
  extends TitleBarActivity
{
  final Handler a = new Handler();
  Runnable b = new ab(this);
  private int c;
  private boolean i = false;
  private boolean j = false;
  private long k = 0L;
  private String l;
  @BindView(2131559707)
  Button mBtnSave;
  @BindView(2131559705)
  CleanableEditText mEtvEmailOrNickname;
  @BindView(2131559706)
  TextView mTvTip;
  
  private boolean b(String paramString)
  {
    paramString = com.xiaoenai.app.utils.am.b(paramString);
    if (!paramString.a.booleanValue())
    {
      c(paramString.b);
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (this.c == 1)
    {
      d();
      return;
    }
    this.mEtvEmailOrNickname.setFilters(new InputFilter[] { new InputFilter.LengthFilter(12) });
    this.mTvTip.setVisibility(8);
  }
  
  private void c(String paramString)
  {
    g localg = new g(this);
    localg.a(paramString);
    localg.a(2131100898, new an(this));
    localg.show();
  }
  
  private void d()
  {
    this.mTvTip.setTextColor(getResources().getColor(2131492911));
    if ((TextUtils.isEmpty(User.getInstance().getEmail())) || (this.j))
    {
      this.mEtvEmailOrNickname.setEnabled(true);
      this.mEtvEmailOrNickname.requestFocus();
      com.xiaoenai.app.utils.ab.a(this.mEtvEmailOrNickname.getContext(), this.mEtvEmailOrNickname);
      if (this.j)
      {
        this.mEtvEmailOrNickname.setText(User.getInstance().getEmail());
        this.mEtvEmailOrNickname.setSelection(User.getInstance().getEmail().length());
        this.mTvTip.setText(2131101104);
      }
      for (;;)
      {
        this.mBtnSave.setText(2131101063);
        this.mBtnSave.setBackgroundResource(2130837623);
        this.mBtnSave.setOnClickListener(new ah(this));
        return;
        this.mEtvEmailOrNickname.setText("");
        this.mEtvEmailOrNickname.setHint(2131101101);
        this.mTvTip.setText(2131101102);
      }
    }
    this.mEtvEmailOrNickname.setText("");
    this.mEtvEmailOrNickname.setHint(User.getInstance().getEmail());
    this.mEtvEmailOrNickname.setEnabled(false);
    if (this.i)
    {
      this.mTvTip.setText(2131101109);
      this.mBtnSave.setBackgroundResource(2130837630);
      this.mBtnSave.setText(2131101178);
      this.mBtnSave.setOnClickListener(new ai(this));
      return;
    }
    this.mTvTip.setText(2131101108);
    this.mTvTip.setTextColor(getResources().getColor(2131492913));
    this.mBtnSave.setText(2131101105);
    this.mBtnSave.setOnClickListener(new aj(this));
    w.b(this.mBtnSave);
    this.k = UserConfig.getLong("last_verify_email_time", 0L);
    long l1 = (System.currentTimeMillis() - this.k) / 1000L;
    if (l1 < 60L)
    {
      this.mBtnSave.setText(getString(2131101105) + "(" + (60L - l1) + ")");
      w.a(this.mBtnSave);
      this.a.post(this.b);
      this.g.setRightButtonVisible(4);
      return;
    }
    w.b(this.mBtnSave);
    this.g.setRightButtonVisible(0);
  }
  
  private void d(String paramString)
  {
    com.xiaoenai.app.utils.ab.b(this);
    l locall = new l(new ao(this, this, paramString));
    if (this.c == 0) {
      locall.a(0L, paramString, null, null, null, null);
    }
    while (this.c != 1) {
      return;
    }
    locall.a(0L, null, null, paramString, null, null);
  }
  
  private void f()
  {
    if (this.i)
    {
      this.g.setTitle(2131101106);
      if ((User.getInstance().getEmail() == null) || (User.getInstance().getEmail().equals("")) || (this.i)) {
        break label123;
      }
      this.g.setRightButtonVisible(0);
      this.g.b(0, 2131100145);
      this.g.a(2130839000, 2131101183);
      this.g.setRightButtonClickListener(new ak(this));
    }
    for (;;)
    {
      this.g.setLeftButtonClickListener(new am(this));
      return;
      this.g.setTitle(2131101110);
      break;
      label123:
      this.g.b(0, 0);
      this.g.setRightButtonVisible(8);
      this.g.a(2130839000, 2131101183);
    }
  }
  
  private void f(String paramString)
  {
    g localg = new g(this);
    localg.a(Html.fromHtml(String.format(getString(2131101099), new Object[] { "<font color=\"#0000ff\"> " + paramString + " </font>" })));
    localg.a(2131100898, new ac(this));
    localg.show();
  }
  
  private void g()
  {
    String str = this.mEtvEmailOrNickname.getText().toString().trim();
    if ((str != null) && (str.length() > 0))
    {
      if (this.c != 0) {
        break label38;
      }
      d(str);
    }
    label38:
    while ((this.c != 1) || (!b(str))) {
      return;
    }
    d(str);
  }
  
  private void h()
  {
    new l(new aq(this, this)).e();
  }
  
  private void i()
  {
    g localg = new g(this);
    localg.a(2131101107);
    localg.d(k.j);
    localg.b(2131099973, new ad(this));
    localg.a(2131100898, new ae(this));
    localg.show();
  }
  
  private void j()
  {
    new l(new af(this, this)).a(true, false, false, false, false);
  }
  
  public int a()
  {
    return 2130903311;
  }
  
  protected void b()
  {
    super.b();
    if (this.c == 0)
    {
      this.g.setTitle(2131101159);
      this.g.a(2130839000, 2131101183);
    }
    while (this.c != 1) {
      return;
    }
    f();
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131559705})
  void onAfterTextChange()
  {
    if (this.mEtvEmailOrNickname.getFormatText().length() > 0)
    {
      w.b(this.mBtnSave);
      return;
    }
    w.a(this.mBtnSave);
  }
  
  @OnClick({2131559707})
  void onClick()
  {
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.c = getIntent().getIntExtra("Type", 0);
    this.i = getIntent().getBooleanExtra("isEmailVerify", false);
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    this.f = 2;
    c();
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getCharSequenceExtra("preText");
      if (this.c != 0) {
        break label140;
      }
      this.mEtvEmailOrNickname.setHint(2131101167);
      if ((paramBundle != null) && (paramBundle.length() > 0))
      {
        this.l = paramBundle.toString();
        this.mEtvEmailOrNickname.setText(this.l);
        this.mEtvEmailOrNickname.setSelection(this.l.length());
      }
    }
    else
    {
      return;
    }
    w.a(this.mBtnSave);
    return;
    label140:
    if ((paramBundle != null) && (paramBundle.length() > 0))
    {
      this.l = paramBundle.toString();
      this.mEtvEmailOrNickname.setHint(this.l);
      return;
    }
    this.mEtvEmailOrNickname.setHint(2131101100);
    w.a(this.mBtnSave);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.removeCallbacks(this.b);
  }
  
  @OnEditorAction({2131559705})
  boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6) {
      g();
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.j))
    {
      this.j = false;
      d();
      f();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.c == 0) {
      com.xiaoenai.app.utils.ab.b(this);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.c == 0)
    {
      this.mEtvEmailOrNickname.requestFocus();
      com.xiaoenai.app.utils.ab.a(this.mEtvEmailOrNickname.getContext(), this.mEtvEmailOrNickname);
    }
    while (this.c != 1) {
      return;
    }
    if ((!this.i) && ((User.getInstance().getEmail() == null) || (this.j)))
    {
      this.mEtvEmailOrNickname.requestFocus();
      com.xiaoenai.app.utils.ab.a(this.mEtvEmailOrNickname.getContext(), this.mEtvEmailOrNickname);
      return;
    }
    com.xiaoenai.app.utils.ab.b(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\SettingNameOrMailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */