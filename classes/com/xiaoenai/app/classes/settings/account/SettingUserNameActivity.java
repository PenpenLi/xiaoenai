package com.xiaoenai.app.classes.settings.account;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;

public class SettingUserNameActivity
  extends TitleBarActivity
{
  @BindView(2131559707)
  Button mBtnSave;
  @BindView(2131559719)
  CleanableEditText mEtvUsername;
  
  private boolean b(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString.length() < 6) || (paramString.length() > 20))
    {
      f();
      bool1 = false;
      return bool1;
    }
    int i = paramString.charAt(0);
    if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
    {
      i = 1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= paramString.length()) {
          break;
        }
        int j = paramString.charAt(i);
        if (((j < 97) || (j > 122)) && ((j < 65) || (j > 90)) && ((j < 48) || (j > 57)) && (j != 95) && (j != 45)) {
          break label136;
        }
        i += 1;
      }
      label136:
      f();
      return false;
    }
    f();
    return false;
  }
  
  private void c(String paramString)
  {
    g localg = new g(this);
    localg.a(2131100898, new df(this, paramString));
    localg.b(2131099973, new dg(this));
    localg.b(17);
    localg.setTitle(2131101535);
    localg.a(String.format(getString(2131101241), new Object[] { paramString }));
    localg.setCancelable(true);
    localg.setCanceledOnTouchOutside(true);
    localg.show();
  }
  
  private void d()
  {
    String str = this.mEtvUsername.getText().toString().trim();
    if ((str != null) && (str.length() > 0) && (b(str))) {
      c(str);
    }
  }
  
  private void d(String paramString)
  {
    new l(new dh(this, this, paramString)).a(0L, null, paramString, null, null, null);
  }
  
  private void f()
  {
    g localg = new g(this);
    localg.a(2131100898, new de(this));
    localg.setTitle(2131101246);
    localg.a(2131101247);
    localg.setCancelable(true);
    localg.setCanceledOnTouchOutside(true);
    localg.show();
  }
  
  public int a()
  {
    return 2130903314;
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131559719})
  void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().trim().length() > 0)
    {
      w.b(this.mBtnSave);
      return;
    }
    w.a(this.mBtnSave);
  }
  
  public void c()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.mEtvUsername, 1);
  }
  
  @OnClick({2131559707})
  public void onClick()
  {
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    this.mEtvUsername.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    w.a(this.mBtnSave);
  }
  
  @OnEditorAction({2131559719})
  boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6) {
      d();
    }
    return false;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mEtvUsername.postDelayed(new dd(this), 300L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\SettingUserNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */