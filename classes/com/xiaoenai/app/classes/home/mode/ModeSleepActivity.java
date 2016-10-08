package com.xiaoenai.app.classes.home.mode;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.classes.home.HomeActivity;
import com.xiaoenai.app.model.HomeModeSettings;
import com.xiaoenai.app.net.l;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.widget.DigitalClock;

public class ModeSleepActivity
  extends BaseActivity
{
  final Handler a = new Handler();
  Runnable b = new e(this);
  final Handler c = new Handler();
  Runnable f = new f(this);
  private Button g = null;
  private TextView h = null;
  private com.xiaoenai.app.classes.chat.messagelist.message.a.a i = null;
  private int j = 0;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private AbsoluteLayout o;
  private ImageView s = null;
  private ImageView t = null;
  private AnimationDrawable u;
  private int v = 218;
  
  private void d()
  {
    if (this.i != null)
    {
      this.j = this.i.d();
      return;
    }
    this.j = ((int)ak.b());
  }
  
  private String f()
  {
    long l1 = 0L;
    long l2 = ak.b() - this.j;
    long l3 = l2 / 3600L;
    long l4 = l2 / 60L - l3 * 60L;
    if (l3 <= 0L) {
      if (l4 <= 0L)
      {
        l2 %= 60L;
        if (l2 >= 0L) {
          break label144;
        }
      }
    }
    for (;;)
    {
      return getString(2131100585) + l1 + getString(2131101070);
      return String.format(getString(2131100583), new Object[] { Long.valueOf(l4) });
      return String.format(getString(2131100582), new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
      label144:
      l1 = l2;
    }
  }
  
  private void g()
  {
    if (com.xiaoenai.app.classes.common.a.a().b(HomeActivity.class) == null) {
      startActivity(new Intent(this, HomeActivity.class));
    }
    finish();
    overridePendingTransition(2130968602, 2130968603);
  }
  
  public void a()
  {
    this.g = ((Button)findViewById(2131559500));
    if (this.g.getBackground() != null) {
      this.g.getBackground().setAlpha(this.v);
    }
    this.k = new ImageView(this);
    this.k.setImageResource(2130838332);
    this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.l = new ImageView(this);
    this.l.setImageResource(2130838333);
    this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.m = new ImageView(this);
    this.m.setImageResource(2130838334);
    this.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.n = new ImageView(this);
    this.n.setImageResource(2130838335);
    this.n.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.o = ((AbsoluteLayout)findViewById(2131559507));
    this.o.addView(this.k);
    this.o.addView(this.l);
    this.o.addView(this.m);
    this.o.addView(this.n);
    this.h = ((TextView)findViewById(2131559505));
    this.h.setText(f());
    this.t = ((ImageView)findViewById(2131559508));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = (int)(localDisplayMetrics.widthPixels * 0.8D);
    Object localObject = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height *= i1 / ((RelativeLayout.LayoutParams)localObject).width;
    ((RelativeLayout.LayoutParams)localObject).width = i1;
    this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.t.getBackground() != null) {
      this.t.getBackground().setAlpha(this.v);
    }
    this.s = ((ImageView)findViewById(2131559509));
    this.s.setImageResource(2130838527);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
    localLayoutParams.height = ((RelativeLayout.LayoutParams)localObject).height;
    localLayoutParams.width = i1;
    this.s.setLayoutParams(localLayoutParams);
    if (this.s.getDrawable() != null) {
      this.s.getDrawable().setAlpha(this.v);
    }
    this.u = ((AnimationDrawable)this.s.getDrawable());
    this.u.setAlpha(this.v);
    this.s.getDrawable().setAlpha(this.v);
    localObject = (DigitalClock)findViewById(2131559502);
    float f1 = localDisplayMetrics.widthPixels / 7;
    ((DigitalClock)localObject).setTextSize(ab.b(this, f1));
    this.h.setTextSize(ab.b(this, f1) / 3);
    ((DigitalClock)localObject).setFormat("HH:mm");
  }
  
  public void b()
  {
    this.g.setOnClickListener(new g(this));
    ImageView localImageView = (ImageView)findViewById(2131559504);
    if (localImageView.getDrawable() != null) {
      localImageView.getDrawable().setAlpha(this.v);
    }
    localImageView.setOnClickListener(new h(this));
  }
  
  public void b(String paramString)
  {
    sendBroadcast(new Intent(paramString));
  }
  
  public void c()
  {
    new l(new j(this, this)).i();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = HomeModeSettings.getMessage("home_mode.msg");
    setContentView(2130903250);
    d();
    a();
    b();
    c.a().a(116);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.a.removeCallbacks(this.b);
    this.c.removeCallbacks(this.f);
    if (this.u != null) {
      this.u.stop();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.postDelayed(this.b, 1000L);
    this.c.post(this.f);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.u.start();
      return;
    }
    this.s.post(new i(this));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\home\mode\ModeSleepActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */