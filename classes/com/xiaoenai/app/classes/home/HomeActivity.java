package com.xiaoenai.app.classes.home;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.ChatActivity;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.extentions.anniversary.ad;
import com.xiaoenai.app.classes.extentions.menses.t;
import com.xiaoenai.app.classes.home.a.m.a;
import com.xiaoenai.app.classes.home.a.o.a;
import com.xiaoenai.app.classes.home.a.z;
import com.xiaoenai.app.classes.home.mode.ModeSleepActivity;
import com.xiaoenai.app.model.AppModel;
import com.xiaoenai.app.model.AppSettings;
import com.xiaoenai.app.model.ConfigCenter;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.RedHintsInfo;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.service.MessageService;
import com.xiaoenai.app.utils.ae;
import com.xiaoenai.app.utils.ai;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.an;
import com.xiaoenai.app.utils.as;
import java.util.List;
import org.json.JSONObject;

public class HomeActivity
  extends BaseActivity
  implements HomeBottomBar.a, m.a
{
  private HomeBottomBar a;
  private boolean b = false;
  private int c = 0;
  private v f = null;
  private com.xiaoenai.app.classes.home.a.a g = null;
  private com.xiaoenai.app.classes.home.a.o h = null;
  private z i = null;
  private o.a j;
  private com.xiaoenai.app.d.v k = new com.xiaoenai.app.d.v();
  private b l;
  private com.xiaoenai.app.classes.common.p m = new e(this);
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      if ((getSupportFragmentManager().findFragmentById(2131558670) instanceof v)) {
        b(this.f);
      }
    }
    while ((1 != this.c) || (!this.b) || (!User.isSingle()))
    {
      do
      {
        return;
        if ((getSupportFragmentManager().findFragmentById(2131558670) instanceof com.xiaoenai.app.classes.home.a.a))
        {
          b(this.g);
          return;
        }
        if ((getSupportFragmentManager().findFragmentById(2131558670) instanceof com.xiaoenai.app.classes.home.a.o))
        {
          b(this.h);
          return;
        }
      } while (!(getSupportFragmentManager().findFragmentById(2131558670) instanceof z));
      b(this.i);
      return;
    }
    this.a.a(0);
    t.a();
  }
  
  private void a(com.xiaoenai.app.d.v paramv)
  {
    Xiaoenai.j().k().postDelayed(new k(this, paramv), 100L);
  }
  
  private void a(boolean paramBoolean)
  {
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    localNotificationManager.cancel(1001);
    localNotificationManager.cancel(1004);
    localNotificationManager.cancel(1005);
    if (paramBoolean) {
      localNotificationManager.cancel(1000);
    }
  }
  
  private void b(Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      if (paramFragment != this.f) {
        break label40;
      }
      b(true);
    }
    for (;;)
    {
      getSupportFragmentManager().beginTransaction().replace(2131559376, paramFragment).commitAllowingStateLoss();
      a(paramFragment);
      return;
      label40:
      b(false);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.f != null) && (User.isSingle())) {
      this.f.a(paramBoolean);
    }
  }
  
  private void g()
  {
    startActivity(new Intent(this, ModeSleepActivity.class));
  }
  
  private void h()
  {
    this.a = ((HomeBottomBar)findViewById(2131559171));
    this.a.setClickable(false);
    this.a.setOnTabSelectedListener(this);
    this.f = new v();
    d();
    b(this.f);
    this.g = new com.xiaoenai.app.classes.home.a.a();
    this.j = new i(this);
    this.h = new com.xiaoenai.app.classes.home.a.o();
    this.h.a(this.j);
    this.i = new z();
    this.f.a(this);
    this.g.a(this);
    this.h.a(this);
    this.i.a(this);
  }
  
  private void i()
  {
    com.xiaoenai.app.utils.f.a.c("shouldRequestDiscoverList {}", new Object[] { Boolean.valueOf(ai.k()) });
    if (ai.k())
    {
      new com.xiaoenai.app.net.q(new l(this, this)).a();
      return;
    }
    s();
  }
  
  private void j()
  {
    if (!ai.i())
    {
      r();
      return;
    }
    new com.xiaoenai.app.net.e.a(new n(this, this)).a();
  }
  
  private void k()
  {
    if (this.a != null) {
      com.xiaoenai.app.classes.home.a.k.a().a(this.a);
    }
  }
  
  private void o()
  {
    RedHintsInfo localRedHintsInfo = com.xiaoenai.app.widget.remindButton.a.a().a("xiaoenai.mine");
    if (this.a != null)
    {
      if ((localRedHintsInfo != null) && (localRedHintsInfo.getChildren().size() > 0)) {
        this.a.a(localRedHintsInfo.getChildNumSum(), localRedHintsInfo.isShow());
      }
    }
    else {
      return;
    }
    this.a.a(0, false);
  }
  
  private void p()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(2131100555);
    localg.b(2131100085, new o(this));
    localg.a(2131100898, new f(this));
    localg.show();
  }
  
  private void q()
  {
    new com.xiaoenai.app.classes.common.q(this).a();
  }
  
  private void r()
  {
    JSONObject localJSONObject = com.xiaoenai.app.widget.remindButton.a.a().d();
    com.xiaoenai.app.widget.remindButton.b localb = new com.xiaoenai.app.widget.remindButton.b(this.m);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localb.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { localJSONObject });
      return;
    }
    localb.execute(new JSONObject[] { localJSONObject });
  }
  
  private void s()
  {
    JSONObject localJSONObject = com.xiaoenai.app.classes.home.a.k.a().e();
    com.xiaoenai.app.utils.f.a.c("checkLocalDiscoverData {}", new Object[] { localJSONObject });
    com.xiaoenai.app.classes.home.a.l locall = new com.xiaoenai.app.classes.home.a.l(null);
    if (Build.VERSION.SDK_INT >= 11)
    {
      locall.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { localJSONObject });
      return;
    }
    locall.execute(new JSONObject[] { localJSONObject });
  }
  
  public void a()
  {
    String str = ConfigCenter.getHelpPage();
    if (ae.a(str)) {}
    int n;
    do
    {
      int i1;
      int i2;
      int i3;
      long l1;
      do
      {
        return;
        n = AppSettings.getInt("app_id", Integer.valueOf(0)).intValue();
        i1 = AppSettings.getInt("daemon_id", Integer.valueOf(0)).intValue();
        i2 = as.e("com.xiaoenai.app");
        i3 = as.e("com.xiaoenai.app:daemon");
        l1 = z().s().h();
        l1 = System.currentTimeMillis() - l1;
        com.xiaoenai.app.utils.f.a.c("intervalTs = {}", new Object[] { Long.valueOf(l1) });
      } while ((n == 0) || (n == i2) || (i1 == i3) || (l1 <= 60000L));
      n = AppSettings.getInt("exit_abnormaliy_count", Integer.valueOf(0)).intValue();
      AppSettings.setInt("exit_abnormaliy_count", Integer.valueOf(n + 1));
      localObject = AppSettings.getString("abnormaliy_need_tip", Xiaoenai.j().B + ":1").split(":");
    } while ((n % 3 != 0) || ((localObject[0].equals(Xiaoenai.j().B)) && ((!localObject[0].equals(Xiaoenai.j().B)) || (!localObject[1].equals("1")))));
    Object localObject = new com.xiaoenai.app.ui.a.k(this);
    ((com.xiaoenai.app.ui.a.k)localObject).d(com.xiaoenai.app.ui.a.k.i);
    ((com.xiaoenai.app.ui.a.k)localObject).a(2131100340, 2131100892, new g(this), 2131099685, new h(this, str));
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      b(this.f);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        b(this.g);
        return;
      }
      if (paramInt == 2)
      {
        if (User.isSingle())
        {
          as.a();
          return;
        }
        startActivity(new Intent(this, ChatActivity.class));
        overridePendingTransition(2130968608, 2130968609);
        return;
      }
      if (paramInt == 3)
      {
        b(this.h);
        return;
      }
    } while (paramInt != 4);
    b(this.i);
  }
  
  public void a(Fragment paramFragment)
  {
    if (User.getInstance().getLoverId() > 0) {
      if (com.xiaoenai.app.classes.guide.b.b())
      {
        if (paramFragment != this.f) {
          break label38;
        }
        com.xiaoenai.app.classes.guide.b.a(this, (RelativeLayout)findViewById(2131558670), 0);
      }
    }
    label38:
    while (!com.xiaoenai.app.classes.guide.b.a())
    {
      return;
      com.xiaoenai.app.classes.guide.b.a((RelativeLayout)findViewById(2131558670));
      return;
    }
    if (paramFragment == this.f)
    {
      com.xiaoenai.app.classes.guide.b.a(this, (RelativeLayout)findViewById(2131558670));
      return;
    }
    com.xiaoenai.app.classes.guide.b.a((RelativeLayout)findViewById(2131558670));
  }
  
  public void b()
  {
    if (this.f != null) {
      this.f.c();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.a != null) {
      this.a.setCurrentTab(paramInt);
    }
  }
  
  public void c()
  {
    if (!ai.m()) {
      return;
    }
    new com.xiaoenai.app.net.e.a(new j(this, this)).a(UserConfig.getInt("global_notification_id_max", Integer.valueOf(0)).intValue(), UserConfig.getInt("user_notification_id_max", Integer.valueOf(0)).intValue());
  }
  
  public void c(int paramInt)
  {
    if (!User.isSingle())
    {
      com.xiaoenai.app.service.c.a(this);
      ad.c(this);
      switch (this.a.getCurrentTab())
      {
      }
    }
    for (;;)
    {
      if (this.f != null)
      {
        this.f.j();
        if (this.f.getContext() != null) {
          this.f.b(paramInt);
        }
      }
      return;
      ad.b(this);
      this.a.setNewRemindNum(0);
      e(0);
      a(true);
      break;
      if (this.g != null)
      {
        this.g.b(paramInt);
        continue;
        this.a.a(0);
        continue;
        if (!User.isSingle())
        {
          if (this.h != null) {
            this.h.b(paramInt);
          }
        }
        else
        {
          this.a.a(0);
          continue;
          if (this.i != null) {
            this.i.b(paramInt);
          }
        }
      }
    }
  }
  
  public void d()
  {
    if ((this.f != null) && (this.f.isVisible())) {
      this.f.f();
    }
  }
  
  public void d(int paramInt)
  {
    if (this.a != null) {
      this.a.setNewRemindNum(paramInt);
    }
  }
  
  public void e(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public void f()
  {
    this.f.a();
    UserConfig.setLong("key_home_ads_last_req_time", ak.a());
  }
  
  public void f(int paramInt)
  {
    if (this.a == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (this.a.getCurrentTab())
            {
            case 2: 
            default: 
              return;
            }
          } while (this.f == null);
          this.f.a(paramInt);
          return;
        } while (this.g == null);
        this.g.a(paramInt);
        return;
      } while (this.h == null);
      this.h.a(paramInt);
      return;
    } while (this.i == null);
    this.i.a(paramInt);
  }
  
  protected void m()
  {
    super.m();
    if ((this.f != null) && (this.f.isAdded())) {
      this.f.d();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 100)) {
      this.f.e();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("isKillByOs", false)) {
        com.f.a.b.b(this, "HomeKilledByOs");
      }
      this.c = paramBundle.getInt("type", 0);
      this.b = true;
      y();
      super.onCreate(paramBundle);
      setContentView(2130903234);
      h();
      if (User.getInstance().getLoverId() <= 0) {
        break label282;
      }
      com.xiaoenai.app.service.c.a(this);
      ad.c(this);
    }
    for (;;)
    {
      this.l = new b();
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("sleep_state_change_action");
      registerReceiver(this.l, (IntentFilter)localObject);
      a(paramBundle);
      i();
      if ((HomeModeSettings.getMessage("home_mode.msg") != null) && (!HomeModeSettings.isAlreadyOpened))
      {
        g();
        HomeModeSettings.isAlreadyOpened = true;
      }
      return;
      localObject = getIntent().getStringExtra("from");
      if ((localObject == null) || ((!((String)localObject).equals("login")) && (!((String)localObject).equals("register"))))
      {
        y();
        HomeModeSettings.getHomeMode(this);
      }
      if ((localObject == null) || ((!((String)localObject).contains("login")) && (((String)localObject).equals("register")) && (!((String)localObject).equals("launcher")))) {
        break;
      }
      localObject = new a(null);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((a)localObject).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[] { Integer.valueOf(0) });
        break;
      }
      ((a)localObject).execute(new Integer[] { Integer.valueOf(0) });
      break;
      label282:
      MessageService.a = 0;
      UserConfig.setInt("receive_new_msg_count", 0);
      q();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(2131100339);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    AppModel.release();
    User.release();
    if (this.l != null)
    {
      unregisterReceiver(this.l);
      this.l = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      com.xiaoenai.app.classes.common.a.a().d(HomeActivity.class);
      com.xiaoenai.app.utils.e.b.a();
      moveTaskToBack(true);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.b = paramIntent.getBooleanExtra("refreshHome", false);
    this.c = paramIntent.getIntExtra("type", 0);
    paramIntent.getStringExtra("from");
    paramIntent = paramIntent.getAction();
    if (paramIntent != null)
    {
      if (!paramIntent.equals("notification_to_home")) {
        break label97;
      }
      if (this.f != null)
      {
        b(this.h);
        this.h.b();
        this.a.a(3);
      }
    }
    for (;;)
    {
      a(null);
      return;
      label97:
      if ((paramIntent.equals("discover_to_home")) && (this.g != null))
      {
        b(this.g);
        this.a.a(1);
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 0) {
      p();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    AppSettings.setInt("app_id", Integer.valueOf(as.e("com.xiaoenai.app")));
    AppSettings.setInt("daemon_id", Integer.valueOf(as.e("com.xiaoenai.app:daemon")));
  }
  
  protected void onResume()
  {
    super.onResume();
    this.r.c();
    if (this.b)
    {
      c(this.c);
      this.b = false;
      if (this.c == 1)
      {
        b(this.f);
        this.a.a(0);
      }
    }
    int n = UserConfig.getInt("receive_new_msg_count", Integer.valueOf(MessageService.a)).intValue();
    if ((n != MessageService.a) && (MessageService.a == 0)) {
      MessageService.a = n;
    }
    d(n);
    a(false);
    c();
    if (User.isSingle())
    {
      e(0);
      if (UserConfig.getBoolean("home_has_invite", Boolean.valueOf(false)).booleanValue()) {
        q();
      }
    }
    an.a(this);
    if (AppModel.getInstance().isLogined()) {
      com.xiaoenai.app.stat.c.a().b();
    }
    if (this.f != null) {
      this.f.i();
    }
    if (AppModel.getInstance().isLogined()) {
      ConfigCenter.getConfigChanged(this);
    }
    n = UserConfig.getInt("upload_ts", Integer.valueOf(0)).intValue();
    int i1 = (int)ak.b();
    com.xiaoenai.app.utils.f.a.c("curTs:{} {}", new Object[] { Integer.valueOf(i1), Integer.valueOf(n) });
    if (i1 - n > ConfigCenter.getStatTs())
    {
      com.xiaoenai.app.stat.h.a().a(this);
      UserConfig.setInt("upload_ts", i1);
    }
    j();
    a();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("isKillByOs", true);
    paramBundle.putInt("type", this.c);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    com.xiaoenai.app.utils.f.a.c("hasFocus = {}", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void startActivity(Intent paramIntent)
  {
    paramIntent.putExtra("stat_caller", getComponentName().getClassName());
    super.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("stat_caller", getComponentName().getClassName());
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  private class a
    extends AsyncTask<Integer, Void, Integer>
  {
    private a() {}
    
    protected Integer a(Integer... paramVarArgs)
    {
      if (!User.isSingle()) {
        com.xiaoenai.app.classes.extentions.menses.a.a(HomeActivity.this);
      }
      try
      {
        com.xiaoenai.app.classes.street.b.f.a();
        if (!User.isSingle())
        {
          org.cocos2dx.cpp.k.a("xiaoenai.lovepet.index");
          org.cocos2dx.cpp.k.a("xiaoenai.wishtree.index");
        }
        return null;
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
    }
    
    protected void a(Integer paramInteger)
    {
      super.onPostExecute(paramInteger);
    }
    
    protected void onPreExecute()
    {
      super.onPreExecute();
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if ((paramContext != null) && (paramContext.equals("sleep_state_change_action"))) {
          HomeActivity.this.runOnUiThread(new p(this));
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\HomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */