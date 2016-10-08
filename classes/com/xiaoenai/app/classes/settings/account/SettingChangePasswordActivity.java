package com.xiaoenai.app.classes.settings.account;

import android.os.Bundle;
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
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.CleanableEditText;

public class SettingChangePasswordActivity
  extends TitleBarActivity
{
  private h a = null;
  @BindView(2131559707)
  Button btnSave;
  @BindView(2131559612)
  CleanableEditText editTextNewPass;
  @BindView(2131559613)
  CleanableEditText editTextNewPassConfirm;
  @BindView(2131559738)
  CleanableEditText editTextOldPass;
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals("")))
    {
      b(getString(2131099975));
      return;
    }
    if ((paramString2 == null) || (paramString2.equals("")))
    {
      b(getString(2131099976));
      return;
    }
    if ((paramString2 == null) || (paramString2.length() < 6))
    {
      b(getString(2131099977));
      return;
    }
    if (!paramString2.equals(paramString3))
    {
      b(getString(2131099978));
      return;
    }
    ab.b(this);
    new l(new t(this, this)).e(paramString1, paramString2);
  }
  
  private void b(String paramString)
  {
    g localg = new g(this);
    localg.a(paramString);
    localg.a(2131100898, new s(this));
    localg.show();
  }
  
  public int a()
  {
    return 2130903318;
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131559738, 2131559612, 2131559613})
  void onAfterChange()
  {
    if ((this.editTextOldPass.getFormatText().length() > 0) && (this.editTextNewPass.getFormatText().length() > 0) && (this.editTextNewPassConfirm.getFormatText().length() > 0))
    {
      w.b(this.btnSave);
      return;
    }
    w.a(this.btnSave);
  }
  
  @OnClick({2131559707})
  public void onClick()
  {
    a(this.editTextOldPass.getText().toString().trim(), this.editTextNewPass.getText().toString().trim(), this.editTextNewPassConfirm.getText().toString().trim());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    w.a(this.btnSave);
  }
  
  @OnEditorAction({2131559613})
  boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6) {
      a(this.editTextOldPass.getText().toString().trim(), this.editTextNewPass.getText().toString().trim(), this.editTextNewPassConfirm.getText().toString().trim());
    }
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      overridePendingTransition(2130968606, 2130968607);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\account\SettingChangePasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */