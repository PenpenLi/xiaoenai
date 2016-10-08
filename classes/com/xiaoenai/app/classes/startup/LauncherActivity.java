package com.xiaoenai.app.classes.startup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.sdk.android.AlibabaHelper;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.guide.NewVersionIntroActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.home.a.a;
import com.xiaoenai.app.classes.home.a.c;
import com.xiaoenai.app.classes.newLogin.LoginActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.ShareSDKSettings;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.o;
import java.io.File;
import java.net.URLEncoder;
import org.mzd.socket.SocketJNI;

public class LauncherActivity
  extends BaseActivity
{
  a a = new a(false);
  Runnable b = new a(this);
  private Handler c = new Handler();
  private ImageView f;
  private ImageView g;
  private Button h;
  private TextView i;
  private final long j = 1000L;
  
  private void a()
  {
    a.a[] arrayOfa = com.xiaoenai.app.classes.home.a.a().c();
    if ((AppModel.getInstance().isLogined()) && (arrayOfa != null) && (arrayOfa.length > 0) && (arrayOfa[0].f != null) && (arrayOfa[0].f[0].c != null) && (ConfigCenter.isShowLauncher()))
    {
      int k = UserConfig.getInt("launcher_ads_display_count", Integer.valueOf(0)).intValue();
      com.xiaoenai.app.utils.f.a.c("count = {}", new Object[] { Integer.valueOf(k) });
      if (k > 0)
      {
        k -= 1;
        UserConfig.setInt("launcher_ads_display_count", k);
        if (k > arrayOfa[0].k) {
          UserConfig.setInt("launcher_ads_display_count", arrayOfa[0].k);
        }
        a(arrayOfa);
        com.xiaoenai.app.utils.f.a.c("count = {}", new Object[] { Integer.valueOf(k) });
        return;
      }
      b();
      return;
    }
    b();
  }
  
  private void a(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.h.getLayoutParams();
    if (paramInt == 0) {
      if (localLayoutParams == null) {}
    }
    for (localLayoutParams.gravity = 5;; localLayoutParams.gravity = 85) {
      do
      {
        this.h.setLayoutParams(localLayoutParams);
        return;
      } while ((paramInt != 1) || (localLayoutParams == null));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.g.setOnClickListener(new b(this, paramString1, paramString2));
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.h.setVisibility(8);
    }
  }
  
  private void a(a.a[] paramArrayOfa)
  {
    int k = 5000;
    if (o.c(this))
    {
      if (!c(paramArrayOfa[0].f[0].c)) {
        this.c.postDelayed(this.a, 1000L);
      }
    }
    else
    {
      b(paramArrayOfa[0].f[0].c);
      com.xiaoenai.app.classes.home.a.a().a(paramArrayOfa[0].h, this, "show");
    }
    a(paramArrayOfa[0].a);
    a(paramArrayOfa[0].i);
    a(paramArrayOfa[0].b, paramArrayOfa[0].h);
    this.c.post(this.b);
    int m = paramArrayOfa[0].d * 1000;
    if (m > 5000) {}
    for (;;)
    {
      this.a.a(true);
      this.c.postDelayed(this.a, k);
      return;
      k = m;
    }
  }
  
  private void b()
  {
    this.c.postDelayed(this.a, 1000L);
  }
  
  private void b(String paramString)
  {
    this.i.setVisibility(8);
    this.g.setVisibility(0);
    com.xiaoenai.app.utils.e.b.a(this.g, paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    this.c.removeCallbacks(this.a);
    AppModel localAppModel = AppModel.getInstance();
    if ((localAppModel.isLogined()) && (localAppModel.getToken() != null) && (!localAppModel.getToken().equals("")))
    {
      Xiaoenai.j().e();
      new l(this).a(false);
      com.xiaoenai.app.classes.chat.messagelist.a.a();
      if (UserConfig.getString("cur_version", "").equals("v5.6.0"))
      {
        c(paramBoolean);
        return;
      }
      i();
      return;
    }
    new l(this).v();
    g();
  }
  
  private void c()
  {
    this.f.setVisibility(8);
  }
  
  private void c(boolean paramBoolean)
  {
    Intent localIntent = new Intent(this, HomeActivity.class);
    localIntent.putExtra("from", "launcher");
    startActivity(localIntent);
    finish();
    if (paramBoolean) {
      overridePendingTransition(2130968595, 2130968596);
    }
  }
  
  private boolean c(String paramString)
  {
    boolean bool2 = false;
    File localFile = com.xiaoenai.app.utils.e.b.b(paramString);
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists())
      {
        this.i.setVisibility(8);
        this.g.setVisibility(0);
        com.xiaoenai.app.utils.e.b.a(this.g, paramString);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d()
  {
    this.h.setOnClickListener(new c(this));
  }
  
  private void f()
  {
    this.c.removeCallbacks(this.a);
  }
  
  private void g()
  {
    h();
  }
  
  private void h()
  {
    startActivity(new Intent(this, LoginActivity.class));
    finish();
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this, NewVersionIntroActivity.class);
    localIntent.putExtra("from", "launcher");
    startActivity(localIntent);
    finish();
  }
  
  private void j()
  {
    new l(new d(this, this)).n();
  }
  
  private void k()
  {
    g localg = new g(this);
    localg.a(2131100895);
    localg.setCancelable(false);
    localg.a(2131100898, new e(this));
    localg.show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((getIntent().getFlags() & 0x400000) != 0)
    {
      finish();
      return;
    }
    this.d = false;
    j();
    setContentView(2130903326);
    this.f = ((ImageView)findViewById(2131559785));
    this.g = ((ImageView)findViewById(2131559783));
    this.h = ((Button)findViewById(2131559784));
    this.i = ((TextView)findViewById(2131559786));
    ab.a(this);
    com.f.a.b.b(this, "StartUp");
    paramBundle = as.m();
    if ((AppModel.getInstance().isLogined()) && (ConfigCenter.isShowLauncher()) && (!o.c(this))) {
      com.xiaoenai.app.classes.home.a.a().a(this);
    }
    if (!SocketJNI.checkHashKey(paramBundle)) {
      k();
    }
    for (;;)
    {
      d();
      UserConfig.setLong("key_home_ads_last_req_time", 0L);
      UserConfig.setLong("key_discover_ads_last_req_time", 0L);
      UserConfig.setLong("key_notification_ads_last_req_time", 0L);
      if (!ConfigCenter.getAdhocSwitch()) {
        ConfigCenter.getConfigChanged(this);
      }
      if (AlibabaHelper.isInited) {
        break;
      }
      AlibabaHelper.initSDK(Xiaoenai.j(), URLEncoder.encode(Xiaoenai.j().D));
      return;
      paramBundle = AppSettings.getString("token", null);
      if ((AppSettings.getBoolean("is_logined", Boolean.valueOf(false)).booleanValue()) && (paramBundle != null) && (!paramBundle.equals("")))
      {
        AppModel.getInstance().setToken(paramBundle);
        AppModel.getInstance().setUserId(AppSettings.getInt("user_id", Integer.valueOf(-1)).intValue());
        AppModel.getInstance().setLastLoginAccount(AppSettings.getString("Last_login_account", ""));
        AppModel.getInstance().save();
        ShareSDKSettings.loadShareSDK(this);
      }
      else
      {
        a();
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.removeCallbacks(this.a);
    this.c.removeCallbacks(this.b);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.r.a();
  }
  
  public class a
    implements Runnable
  {
    private boolean b = false;
    
    public a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public void a(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public void run()
    {
      LauncherActivity.a(LauncherActivity.this, this.b);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\startup\LauncherActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */