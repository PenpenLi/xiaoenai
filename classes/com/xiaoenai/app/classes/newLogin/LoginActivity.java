package com.xiaoenai.app.classes.newLogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import com.c.a.ad;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.guide.NewVersionIntroActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.newRegister.phone.PhoneRegisterActivity;
import com.xiaoenai.app.classes.settings.AboutActivity;
import com.xiaoenai.app.classes.settings.account.ResetByEmailActivity;
import com.xiaoenai.app.classes.settings.account.ResetPasswordByPhoneNumActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ShareSDKSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.am;
import com.xiaoenai.app.utils.am.a;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.e.b;
import com.xiaoenai.app.widget.CleanableEditText;
import com.xiaoenai.app.widget.TitleBarView;
import org.json.JSONObject;

public class LoginActivity
  extends BaseKeyboardListenerActivity
{
  private a b;
  private String c = null;
  private int f = 0;
  private int g = -1;
  private int h = -1;
  private boolean i;
  private boolean j = false;
  private boolean k = false;
  @BindView(2131558673)
  ImageButton mAboutBtn;
  @BindView(2131558677)
  CleanableEditText mAccountEditText;
  @BindView(2131558679)
  Button mLoginBtn;
  @BindView(2131558671)
  View mMainLayout;
  @BindView(2131558683)
  LinearLayout mOtherLoginLayout;
  @BindView(2131558678)
  CleanableEditText mPasswordEditText;
  @BindView(2131558684)
  ImageButton mQQLoginBtn;
  @BindView(2131558682)
  TitleBarView mTitleBar;
  @BindView(2131558672)
  RelativeLayout mTopLayout;
  @BindView(2131558685)
  ImageButton mWechatLoginBtn;
  @BindView(2131558686)
  ImageButton mWeiboLoginBtn;
  
  private void C()
  {
    b.a(new ImageView(this), this.c, new o(this));
  }
  
  private void D()
  {
    if (UserConfig.getString("cur_version", "").equals("v5.6.0"))
    {
      p();
      return;
    }
    q();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (!isFinishing())
    {
      com.xiaoenai.app.utils.n.a().a(paramJSONObject, null, this, "LoginSuccess");
      com.xiaoenai.app.utils.f.a.a(" avatar = {}", new Object[] { this.c });
      com.xiaoenai.app.utils.f.a.a(" getAvatar = {}", new Object[] { User.getInstance().getAvatar() });
      if (((User.getInstance().getAvatar() != null) && (User.getInstance().getAvatar().length() != 0) && (!User.getInstance().getAvatar().contains("http://a1.cdn.xiaoenai.com/default_avatar.png"))) || (this.c == null) || (this.c.length() <= 0)) {
        break label116;
      }
      C();
    }
    for (;;)
    {
      this.r.d();
      return;
      label116:
      l_();
      D();
    }
  }
  
  private void b(String paramString)
  {
    g localg = new g(this);
    localg.a(paramString);
    localg.a(2131100898, new l(this));
    localg.show();
  }
  
  private void b(String paramString1, String paramString2)
  {
    new com.xiaoenai.app.net.l(new u(this, this)).a(paramString1, paramString2);
  }
  
  private void c(String paramString)
  {
    new com.xiaoenai.app.net.n(new p(this, this, paramString)).d(paramString);
  }
  
  private void c(String paramString1, String paramString2)
  {
    new com.xiaoenai.app.net.l(new v(this, this)).b(paramString1, paramString2);
  }
  
  private void d(String paramString1, String paramString2)
  {
    new com.xiaoenai.app.net.l(new w(this, this)).c(paramString1, paramString2);
  }
  
  private void f()
  {
    this.mTitleBar.setLeftButtonClickListener(new q(this));
  }
  
  private void g()
  {
    AppModel localAppModel = AppModel.getInstance();
    String str = "";
    if (localAppModel != null) {
      str = localAppModel.getLastLoginAccount();
    }
    if (!TextUtils.isEmpty(str))
    {
      this.mAccountEditText.setText(str);
      this.mAccountEditText.setSelection(str.length());
      this.mPasswordEditText.requestFocus();
    }
    com.xiaoenai.app.utils.d.w.a(this.mLoginBtn);
  }
  
  private void h()
  {
    if (this.i)
    {
      this.k = true;
      ab.b(this);
      return;
    }
    i();
  }
  
  private void i()
  {
    String str1 = this.mAccountEditText.getText().toString().trim();
    String str2 = this.mPasswordEditText.getText().toString().trim();
    am.a locala = am.c(str1);
    if (!locala.a.booleanValue()) {
      b(locala.b);
    }
    do
    {
      return;
      locala = am.a(str2);
      if (!locala.a.booleanValue())
      {
        b(locala.b);
        return;
      }
      this.mLoginBtn.setEnabled(false);
    } while (AppModel.getInstance().isLogined());
    a(str1, str2);
  }
  
  private void j()
  {
    if (!as.a(this, "com.tencent.mm"))
    {
      com.xiaoenai.app.ui.a.h.b(this, 2131101149, 1500L);
      return;
    }
    if (!isFinishing()) {
      a(null);
    }
    ShareSDKSettings.initShareSDK(this);
    Platform localPlatform = ShareSDK.getPlatform(this, Wechat.NAME);
    localPlatform.setPlatformActionListener(new r(this));
    localPlatform.authorize();
  }
  
  private void k()
  {
    if (!isFinishing()) {
      a(null, false);
    }
    ShareSDKSettings.initShareSDK(this);
    Platform localPlatform = ShareSDK.getPlatform(this, QZone.NAME);
    localPlatform.setPlatformActionListener(new s(this));
    localPlatform.authorize();
  }
  
  private void o()
  {
    if (!isFinishing()) {
      a(null, false);
    }
    ShareSDKSettings.initShareSDK(this);
    Platform localPlatform = ShareSDK.getPlatform(this, SinaWeibo.NAME);
    localPlatform.setPlatformActionListener(new t(this));
    localPlatform.authorize();
  }
  
  private void p()
  {
    sendBroadcast(new Intent("kill_action"), getString(2131101650));
    Intent localIntent = new Intent(this, HomeActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "login");
    startActivity(localIntent);
    com.xiaoenai.app.classes.common.a.a().a(this);
    setResult(-1);
    finish();
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this, NewVersionIntroActivity.class);
    localIntent.putExtra("from", "login");
    startActivity(localIntent);
    finish();
  }
  
  private void r()
  {
    AppSettings.remove("register_is_remind");
    Intent localIntent = new Intent();
    localIntent.setClass(this, PhoneRegisterActivity.class);
    startActivity(localIntent);
    overridePendingTransition(2130968608, 2130968609);
  }
  
  private void s()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, AboutActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("from", 1);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void t()
  {
    e locale = new e(this);
    locale.setTitle(2131100657);
    locale.a(new i(this));
    locale.a(2131100658, 1, new j(this));
    locale.a(2131100653, 1, new k(this));
    locale.show();
  }
  
  private void u()
  {
    g localg = new g(this);
    localg.setTitle(2131100165);
    localg.a(2131100656);
    localg.a(2131100898, new m(this));
    localg.b(2131099973, new n(this));
    localg.show();
  }
  
  private void v()
  {
    Intent localIntent = new Intent(this, ResetByEmailActivity.class);
    localIntent.putExtra("from", "resetpassword");
    String str = this.mAccountEditText.getText().toString().trim();
    if (str.contains("@"))
    {
      localIntent.setAction("resetPwdAction");
      localIntent.putExtra("email", str);
    }
    for (;;)
    {
      startActivity(localIntent);
      overridePendingTransition(2130968608, 2130968609);
      return;
      str = User.getInstance().getEmail();
      if ((str != null) && (!"".equals(str)))
      {
        localIntent.setAction("resetPwdAction");
        localIntent.putExtra("email", str);
      }
    }
  }
  
  private void w()
  {
    startActivity(new Intent(this, ResetPasswordByPhoneNumActivity.class));
    overridePendingTransition(2130968608, 2130968609);
  }
  
  private void x()
  {
    if (!isFinishing()) {
      com.xiaoenai.app.ui.a.h.c(this, 2131100335, 1500L);
    }
  }
  
  @OnEditorAction({2131558677, 2131558678})
  boolean OnEditorAction(TextView paramTextView)
  {
    if (paramTextView == this.mAccountEditText) {
      this.mPasswordEditText.requestFocus();
    }
    for (;;)
    {
      return true;
      h();
    }
  }
  
  @OnTextChanged({2131558677, 2131558678})
  void OnTextChanged()
  {
    if ((this.mAccountEditText.getFormatText().length() > 0) && (this.mPasswordEditText.getFormatText().length() > 0))
    {
      com.xiaoenai.app.utils.d.w.b(this.mLoginBtn);
      return;
    }
    com.xiaoenai.app.utils.d.w.a(this.mLoginBtn);
  }
  
  protected void a()
  {
    if (!this.i) {
      return;
    }
    this.i = false;
    ad.n();
    a(this.mTitleBar, new float[] { 1.0F, 0.0F });
    b(this.mTopLayout, getResources().getColor(2131492962), getResources().getColor(2131492906));
    if (Build.VERSION.SDK_INT >= 11)
    {
      a(this.mMainLayout, this.h - this.g, 0.0F);
      return;
    }
    a(this.mTopLayout, this.h, this.g);
  }
  
  protected void a(int paramInt)
  {
    if (this.i) {
      return;
    }
    this.i = true;
    ad.n();
    if (Build.VERSION.SDK_INT > 11) {
      a(this.mMainLayout, 0.0F, this.h - this.g);
    }
    for (;;)
    {
      b(this.mTopLayout, getResources().getColor(2131492906), getResources().getColor(2131492962));
      a(this.mTitleBar, new float[] { 0.0F, 1.0F });
      return;
      a(this.mTopLayout, this.g, this.h);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(null, false);
    new com.xiaoenai.app.net.p(new x(this, this, paramString1)).m(paramString1, paramString2);
  }
  
  @OnClick({2131558673})
  void about()
  {
    s();
  }
  
  protected void c()
  {
    if (!this.i)
    {
      this.mOtherLoginLayout.setVisibility(0);
      this.mTitleBar.setVisibility(8);
      if (this.k)
      {
        this.k = false;
        i();
      }
    }
    if (this.j)
    {
      this.j = false;
      t();
    }
  }
  
  protected void d()
  {
    if (this.mTitleBar.getVisibility() == 8) {
      this.mTitleBar.setVisibility(0);
    }
    if (this.i) {
      this.mOtherLoginLayout.setVisibility(8);
    }
  }
  
  @OnClick({2131558681})
  void forgot()
  {
    if (this.i)
    {
      this.j = true;
      ab.b(this);
      return;
    }
    t();
  }
  
  @OnClick({2131558670})
  void hideIme()
  {
    if (this.i) {
      ab.b(this);
    }
  }
  
  @OnClick({2131558679})
  void login()
  {
    h();
  }
  
  @OnClick({2131558684})
  void mQqLogin()
  {
    k();
  }
  
  @OnClick({2131558685})
  void mWechatLoginBtn()
  {
    j();
  }
  
  @OnClick({2131558686})
  void mWeiboLogin()
  {
    o();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.i = paramBundle.getBoolean("isImeShowing");
    }
    super.onCreate(paramBundle);
    setContentView(2130903071);
    this.d = false;
    ButterKnife.bind(this);
    b();
    this.b = new a();
    paramBundle = new IntentFilter("kill_action");
    registerReceiver(this.b, paramBundle, getString(2131101650), null);
    this.mTopLayout.getViewTreeObserver().addOnGlobalLayoutListener(new h(this));
    this.mTopLayout.setVisibility(0);
    g();
    f();
    this.k = false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.b);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      com.xiaoenai.app.classes.common.a.a().a(this);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    ab.b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mAccountEditText.setClearDrawableVisible(false);
    if (this.i)
    {
      if (this.mAccountEditText.getText().toString().length() > 0) {
        ab.a(this, this.mPasswordEditText);
      }
    }
    else {
      return;
    }
    ab.a(this, this.mAccountEditText);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("isImeShowing", this.i);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  @OnClick({2131558680})
  void register()
  {
    r();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      LoginActivity.this.finish();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\newLogin\LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */