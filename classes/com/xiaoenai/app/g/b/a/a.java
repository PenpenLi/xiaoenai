package com.xiaoenai.app.g.b.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.o;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.classes.home.mode.ModeWakeActivity;
import com.xiaoenai.app.classes.lock.LockScreenActivity;
import com.xiaoenai.app.classes.startup.LauncherActivity;
import com.xiaoenai.app.common.application.BaseApplication;
import com.xiaoenai.app.common.view.activity.BaseActivity;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.stat.StatEntry;
import com.xiaoenai.app.stat.h;
import com.xiaoenai.app.stat.j;
import com.xiaoenai.app.utils.as;

public class a
  implements com.xiaoenai.app.common.view.b.a.a
{
  private final BaseApplication a;
  
  public a(BaseApplication paramBaseApplication)
  {
    this.a = paramBaseApplication;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramView.getBackground() != null) {
          paramView.getBackground().setCallback(null);
        }
        paramView.setBackgroundDrawable(null);
        if ((paramView instanceof ImageView))
        {
          ((ImageView)paramView).setImageDrawable(null);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
        if (!(paramView instanceof ViewGroup)) {
          continue;
        }
        if (paramInt1 <= paramInt2)
        {
          int i = 0;
          while (i < ((ViewGroup)paramView).getChildCount())
          {
            a(((ViewGroup)paramView).getChildAt(i), paramInt1 + 1, paramInt2);
            i += 1;
          }
        }
        if ((paramView instanceof AdapterView)) {
          continue;
        }
        ((ViewGroup)paramView).removeAllViews();
        return;
      }
      catch (Error paramView)
      {
        for (;;) {}
      }
    }
  }
  
  private void h(BaseActivity paramBaseActivity)
  {
    paramBaseActivity.setVolumeControlStream(5);
  }
  
  public void a(BaseActivity paramBaseActivity) {}
  
  public void a(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    paramIntent.putExtra("stat_caller", paramBaseActivity.getComponentName().getClassName());
  }
  
  public void a(BaseActivity paramBaseActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramIntent.putExtra("stat_caller", paramBaseActivity.getComponentName().getClassName());
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      com.xiaoenai.app.utils.f.a.c("savedInstanceState = {}", new Object[] { paramBundle });
      if ((this.a.z().k().a().d()) && (as.f()))
      {
        Xiaoenai.j().a(UserConfig.getBoolean("lock_show_lock", Boolean.valueOf(false)).booleanValue());
        UserConfig.setBoolean("lock_show_lock", Boolean.valueOf(Xiaoenai.j().q()));
      }
    }
    if ((paramBaseActivity instanceof HomeActivity))
    {
      paramBundle = paramBaseActivity.getIntent().getStringExtra("from");
      if ((paramBundle != null) && (paramBundle.equals("launcher")) && (as.e())) {
        LockScreenActivity.a(paramBaseActivity);
      }
    }
    h(paramBaseActivity);
    paramBundle = paramBaseActivity.getIntent();
    if (paramBundle != null)
    {
      int i = h.c();
      h.a().a(i);
      paramBundle = paramBundle.getStringExtra("stat_caller");
      StatEntry localStatEntry = new StatEntry();
      j.a().a(localStatEntry, paramBaseActivity, paramBundle, paramBaseActivity.getComponentName().getClassName());
      if ((paramBaseActivity instanceof o)) {
        ((o)paramBaseActivity).a(localStatEntry);
      }
      h.a().a(localStatEntry);
    }
  }
  
  public void b(BaseActivity paramBaseActivity)
  {
    boolean bool = as.e(paramBaseActivity);
    if (!bool) {
      Xiaoenai.j().c();
    }
    if ((!bool) && (this.a.z().k().a().d()) && (as.e()))
    {
      UserConfig.setBoolean("lock_show_lock", Boolean.valueOf(true));
      Xiaoenai.j().a(true);
    }
  }
  
  public void c(BaseActivity paramBaseActivity)
  {
    com.f.a.b.b(paramBaseActivity);
    if (Xiaoenai.j().d()) {
      Xiaoenai.j().b();
    }
    com.xiaoenai.app.utils.f.a.c("hasScreenLock {} {} {}", new Object[] { Boolean.valueOf(Xiaoenai.j().q()), Boolean.valueOf(as.e()), paramBaseActivity });
    if ((Xiaoenai.j().q()) && (this.a.z().k().a().d()) && (as.f()) && (as.e()))
    {
      Activity localActivity = this.a.z().c().a();
      if ((!(paramBaseActivity instanceof LockScreenActivity)) && (!(localActivity instanceof LockScreenActivity)) && (!(paramBaseActivity instanceof LauncherActivity)) && (!(paramBaseActivity instanceof ModeWakeActivity))) {
        LockScreenActivity.a(paramBaseActivity);
      }
    }
  }
  
  public void d(BaseActivity paramBaseActivity)
  {
    com.f.a.b.a(paramBaseActivity);
  }
  
  public void e(BaseActivity paramBaseActivity)
  {
    a(paramBaseActivity.getWindow().getDecorView(), 0, 20);
    System.gc();
    Runtime.getRuntime().gc();
  }
  
  public void f(BaseActivity paramBaseActivity)
  {
    System.gc();
    Runtime.getRuntime().gc();
  }
  
  public void g(BaseActivity paramBaseActivity) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\g\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */