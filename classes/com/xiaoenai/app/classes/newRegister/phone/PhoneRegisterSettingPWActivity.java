package com.xiaoenai.app.classes.newRegister.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import com.c.a.ad;
import com.xiaoenai.app.classes.common.image.ImagePicker;
import com.xiaoenai.app.classes.guide.NewVersionIntroActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.newLogin.BaseKeyboardListenerTitleBarActivity;
import com.xiaoenai.app.classes.newLogin.LoginActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.r;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.am.a;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;

public class PhoneRegisterSettingPWActivity
  extends BaseKeyboardListenerTitleBarActivity
{
  private String b = null;
  private String c = null;
  private String i = null;
  private int j = -1;
  private int k = -1;
  private boolean l;
  private boolean m;
  @BindView(2131558675)
  ImageView mAvatarImageView;
  @BindView(2131558690)
  View mAvatarLayout;
  @BindView(2131558693)
  Button mLoginBtn;
  @BindView(2131558671)
  View mMainLayout;
  @BindView(2131558692)
  CleanableEditText mNewPasswordConfirmEditText;
  @BindView(2131558691)
  CleanableEditText mNewPasswordEditText;
  
  private void b(String paramString)
  {
    h.c(this, paramString, 1500L);
  }
  
  private void c(String paramString)
  {
    r localr = new r(new p(this, this));
    com.xiaoenai.app.utils.f.a.c("phoneNumber {}", new Object[] { this.b });
    com.xiaoenai.app.utils.f.a.c("verifyCode {}", new Object[] { this.c });
    localr.a(this.b, paramString, this.c);
  }
  
  private void h()
  {
    ImagePicker localImagePicker = new ImagePicker(this);
    localImagePicker.a(new k(this));
    localImagePicker.a(640, 640);
    localImagePicker.a(getString(2131101044));
  }
  
  private void i()
  {
    new com.xiaoenai.app.ui.a.k(this).a(2131100948, 2131101666, new l(this), 2131100891, new m(this));
  }
  
  private void j()
  {
    com.xiaoenai.app.utils.w.a(this, Integer.valueOf(getString(2131101646)).intValue());
    AppModel.getInstance().setLastRegisterPhoneNumber(this.b);
    AppModel.getInstance().save();
    com.xiaoenai.app.classes.common.a.a().d(LoginActivity.class);
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    startActivity(localIntent);
  }
  
  private void k()
  {
    String str = this.mNewPasswordEditText.getText().toString().trim();
    Object localObject1 = this.mNewPasswordConfirmEditText.getText().toString().trim();
    if (this.mNewPasswordEditText.hasFocus())
    {
      localObject2 = am.a(str);
      if (!((am.a)localObject2).a.booleanValue())
      {
        b(((am.a)localObject2).b);
        return;
      }
      if (((String)localObject1).length() == 0) {
        this.mNewPasswordConfirmEditText.requestFocus();
      }
    }
    else if (this.mNewPasswordConfirmEditText.hasFocus())
    {
      localObject2 = am.a(str, (String)localObject1);
      if (!((am.a)localObject2).a.booleanValue())
      {
        b(((am.a)localObject2).b);
        return;
      }
    }
    Object localObject2 = am.a(str);
    if (!((am.a)localObject2).a.booleanValue())
    {
      b(((am.a)localObject2).b);
      return;
    }
    localObject1 = am.a(str, (String)localObject1);
    if (!((am.a)localObject1).a.booleanValue())
    {
      b(((am.a)localObject1).b);
      return;
    }
    if (this.i == null)
    {
      localObject1 = new com.xiaoenai.app.ui.a.k(this);
      localObject2 = getResources().getString(2131101040);
      ((com.xiaoenai.app.ui.a.k)localObject1).d(com.xiaoenai.app.ui.a.k.i);
      ((com.xiaoenai.app.ui.a.k)localObject1).a(2131101039, (String)localObject2, 2131101041, new n(this, str), 2131101047, new o(this));
      return;
    }
    if (this.l)
    {
      this.m = true;
      hideIme();
      return;
    }
    c(str);
  }
  
  private void o()
  {
    if (UserConfig.getString("cur_version", "").equals("v5.6.0"))
    {
      p();
      return;
    }
    q();
  }
  
  private void p()
  {
    ab.b(this);
    sendBroadcast(new Intent("kill_action"), getString(2131101650));
    Intent localIntent = new Intent(this, HomeActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "register");
    startActivity(localIntent);
    com.xiaoenai.app.classes.common.a.a().a(this);
    overridePendingTransition(2130968604, 2130968605);
    finish();
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this, NewVersionIntroActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "register");
    startActivity(localIntent);
    finish();
  }
  
  private void s()
  {
    com.xiaoenai.app.net.n localn = new com.xiaoenai.app.net.n(new q(this, this));
    com.xiaoenai.app.utils.f.a.c("upload avatar 2", new Object[0]);
    localn.d(this.i);
  }
  
  @OnTextChanged({2131558691, 2131558692})
  void OnTextChanged()
  {
    if ((this.mNewPasswordEditText.getFormatText().length() > 0) && (this.mNewPasswordConfirmEditText.getFormatText().length() > 0))
    {
      com.xiaoenai.app.utils.d.w.b(this.mLoginBtn);
      return;
    }
    com.xiaoenai.app.utils.d.w.a(this.mLoginBtn);
  }
  
  public int a()
  {
    return 2130903073;
  }
  
  protected void a(int paramInt)
  {
    if (this.l) {
      return;
    }
    this.l = true;
    if (Build.VERSION.SDK_INT >= 11)
    {
      a(this.mMainLayout, 0.0F, -this.j);
      return;
    }
    ad.n();
    a(this.mAvatarLayout, this.j, 0);
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new j(this));
  }
  
  protected void c()
  {
    if (!this.l) {
      return;
    }
    this.l = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      a(this.mMainLayout, -this.j, 0.0F);
      return;
    }
    ad.n();
    a(this.mAvatarLayout, 0, this.j);
  }
  
  @OnClick({2131558675})
  void chooseAvatar()
  {
    h();
  }
  
  @OnEditorAction({2131558691})
  boolean editorAction(TextView paramTextView)
  {
    k();
    return true;
  }
  
  @OnEditorAction({2131558692})
  boolean editorAction1(TextView paramTextView)
  {
    this.mNewPasswordConfirmEditText.requestFocus();
    return true;
  }
  
  protected void f()
  {
    if ((this.m) && (!this.l))
    {
      c(this.mNewPasswordEditText.getText().toString().trim());
      this.m = false;
    }
  }
  
  @OnClick({2131558693})
  void finishRegister()
  {
    k();
  }
  
  @OnClick({2131558670})
  void hideIme()
  {
    if (this.l) {
      ab.b(this);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        break label77;
      }
      if ((paramIntent != null) && (paramIntent.getData() != null))
      {
        this.i = paramIntent.getData().getPath();
        b.b(this.mAvatarImageView, "file://" + this.i, ab.a(62.0F));
      }
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt1 != 5) {
          break;
        }
        com.xiaoenai.app.utils.f.a.c("data = {}", new Object[] { paramIntent });
      } while ((paramIntent == null) || (paramIntent.getData() == null));
      this.i = paramIntent.getData().getPath();
      b.b(this.mAvatarImageView, "file://" + this.i, ab.a(62.0F));
      return;
    } while ((paramInt1 != 0) || (paramIntent == null) || (paramIntent.getData() == null));
    this.i = paramIntent.getData().getPath();
    b.b(this.mAvatarImageView, "file://" + this.i, ab.a(62.0F));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ButterKnife.bind(this);
    this.d = false;
    if (getIntent() != null)
    {
      this.b = getIntent().getStringExtra("phone_register_setting_pw_phone_number");
      this.c = getIntent().getStringExtra("phone_register_verify_code");
      if (!TextUtils.isEmpty(getIntent().getStringExtra("alarm_from"))) {
        AppSettings.setBoolean("register_is_remind", Boolean.valueOf(true));
      }
    }
    this.mAvatarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new i(this));
    com.xiaoenai.app.utils.d.w.a(this.mLoginBtn);
    d();
    this.m = false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      i();
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
    Intent localIntent = new Intent();
    localIntent.putExtra("phone_register_setting_pw_phone_number", this.b);
    localIntent.putExtra("phone_register_verify_code", this.c);
    com.xiaoenai.app.utils.a.a(this, localIntent, "from_register_last", 1001, ConfigCenter.getRegisterStayTime());
  }
  
  protected void onResume()
  {
    super.onResume();
    com.xiaoenai.app.utils.a.a(this, 1001);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newRegister\phone\PhoneRegisterSettingPWActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */