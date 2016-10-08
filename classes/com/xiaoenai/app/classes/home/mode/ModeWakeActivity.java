package com.xiaoenai.app.classes.home.mode;

import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.c.a.c;
import com.c.a.c.b;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.ui.component.view.AvatarView;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.d.w;
import com.xiaoenai.app.widget.DigitalClock;
import java.util.Date;

public class ModeWakeActivity
  extends BaseActivity
{
  final Handler a = new Handler();
  Runnable b = new k(this);
  private Button c = null;
  private com.xiaoenai.app.classes.chat.messagelist.message.a.a f = null;
  private Date g = new Date(ak.a());
  private ImageView h = null;
  private AnimationDrawable i = null;
  private ImageView j = null;
  private ImageView k = null;
  private c l = null;
  private ImageView m = null;
  private c n = null;
  private ImageView o = null;
  private c s = null;
  
  private void a(ImageView paramImageView, c paramc)
  {
    com.c.a.l locall4;
    com.c.a.l locall3;
    com.c.a.l locall2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      locall4 = com.c.a.l.a(paramImageView, "translationX", new float[] { -100.0F }).b(5000L);
      locall3 = com.c.a.l.a(paramImageView, "alpha", new float[] { 0.0F, 1.0F });
      locall2 = com.c.a.l.a(paramImageView, "alpha", new float[] { 1.0F, 0.0F });
      locall3.b(2500L);
      locall2.b(2500L);
    }
    for (com.c.a.l locall1 = com.c.a.l.a(paramImageView, "translationX", new float[] { 0.0F }).b(100L);; locall1 = com.c.a.l.a(paramImageView, "translationX", new float[] { 0.0F }).b(2000L))
    {
      paramc.a(locall4).b(locall3);
      paramc.a(locall2).b(locall4);
      paramc.a(locall1).b(locall2);
      paramc.a(new n(this, paramc));
      paramImageView.setVisibility(0);
      paramc.a();
      return;
      locall4 = com.c.a.l.a(paramImageView, "translationX", new float[] { -70.0F }).b(5000L);
      locall3 = com.c.a.l.a(paramImageView, "alpha", new float[] { 0.8F, 1.0F });
      locall2 = com.c.a.l.a(paramImageView, "alpha", new float[] { 0.8F, 0.0F });
      locall3.b(500L);
      locall2.b(500L);
    }
  }
  
  private String f()
  {
    long l1 = 0L;
    long l2 = ak.a() - this.g.getTime();
    long l3 = l2 / 3600000L;
    long l4 = l2 / 60000L - l3 * 60L;
    if (l3 <= 0L) {
      if (l4 <= 0L)
      {
        l2 = l2 / 1000L % 60L;
        if (l2 >= 0L) {
          break label150;
        }
      }
    }
    for (;;)
    {
      return getString(2131100585) + l1 + getString(2131101070);
      return String.format(getString(2131100583), new Object[] { Long.valueOf(l4) });
      return String.format(getString(2131100582), new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
      label150:
      l1 = l2;
    }
  }
  
  private void g()
  {
    ((NotificationManager)getSystemService("notification")).cancel(1002);
  }
  
  public void a()
  {
    if (this.f != null)
    {
      long l1 = this.f.d();
      this.g.setTime(l1 * 1000L);
      return;
    }
    com.xiaoenai.app.utils.f.a.a("the sleepMessage is null", new Object[0]);
  }
  
  public void b()
  {
    this.c = ((Button)findViewById(2131559500));
    Object localObject1 = (AvatarView)findViewById(2131559496);
    Object localObject2 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    int i1 = (int)(((DisplayMetrics)localObject2).widthPixels * 0.22D);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((AvatarView)localObject1).getLayoutParams();
    localLayoutParams.width = i1;
    localLayoutParams.height = i1;
    ((AvatarView)localObject1).setLayoutParams(localLayoutParams);
    ((AvatarView)localObject1).a(User.getInstance().getAvatar(), false);
    this.h = ((ImageView)findViewById(2131559501));
    this.h.setImageResource(2130838535);
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    i1 = (int)(((DisplayMetrics)localObject2).widthPixels * 0.8D);
    localObject1 = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).height *= i1 / ((RelativeLayout.LayoutParams)localObject1).width;
    ((RelativeLayout.LayoutParams)localObject1).width = i1;
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.i = ((AnimationDrawable)this.h.getDrawable());
    this.j = ((ImageView)findViewById(2131559493));
    localObject2 = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).height = ((RelativeLayout.LayoutParams)localObject1).height;
    ((RelativeLayout.LayoutParams)localObject2).width = i1;
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((DigitalClock)findViewById(2131559502)).setFormat("HH:mm");
    this.k = ((ImageView)findViewById(2131559495));
    this.l = new c();
    a(this.k, this.l);
    this.m = ((ImageView)findViewById(2131559497));
    this.n = new c();
    Xiaoenai.j().a(new l(this), 2000L);
    this.o = ((ImageView)findViewById(2131559499));
    this.s = new c();
    Xiaoenai.j().a(new m(this), 3000L);
  }
  
  public void c()
  {
    this.c.setOnTouchListener(w.a);
    this.c.setOnClickListener(new p(this));
  }
  
  public void d()
  {
    g();
    com.xiaoenai.app.utils.h.a.a().d(1);
    new com.xiaoenai.app.net.l(new q(this, this)).i();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    this.f = HomeModeSettings.getMessage("home_mode.msg");
    setContentView(2130903249);
    a();
    b();
    c();
    if (!com.xiaoenai.app.utils.h.a.a().b()) {
      com.xiaoenai.app.utils.h.a.a().c(1);
    }
    this.a.postDelayed(this.b, 120000L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.removeCallbacks(this.b);
    com.xiaoenai.app.utils.h.a.a().d(1);
    this.l.c();
    this.n.c();
    this.s.c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      com.xiaoenai.app.utils.h.a.a().d(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.a.postDelayed(this.b, 120000L);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.i != null) {
      this.i.stop();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    com.xiaoenai.app.classes.common.a.a().a(ModeSleepActivity.class);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.i.start();
      return;
    }
    this.h.post(new o(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\ModeWakeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */