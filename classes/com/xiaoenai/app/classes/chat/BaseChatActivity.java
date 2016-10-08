package com.xiaoenai.app.classes.chat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.b;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.af;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.utils.h.c.a;
import com.xiaoenai.app.widget.AutoHeightLayout;
import com.xiaoenai.app.widget.TitleBarView;

public abstract class BaseChatActivity
  extends TitleBarActivity
  implements SensorEventListener, c.a
{
  protected AutoHeightLayout a;
  private View b;
  private ImageView c;
  private TextView i;
  private AudioManager j = null;
  private SensorManager k = null;
  private Sensor l = null;
  private boolean m = false;
  private long n = 0L;
  private boolean o = false;
  private b s;
  private af t;
  
  private void o()
  {
    com.xiaoenai.app.utils.h.g.a().c();
    d();
    this.j.setMode(0);
    k();
  }
  
  private void p()
  {
    this.c.setImageResource(2130838607);
    this.i.setText(2131100036);
    this.b.setVisibility(0);
    this.b.postDelayed(new k(this), 1500L);
  }
  
  private void q()
  {
    this.c.setImageResource(2130838600);
    this.i.setText(2131100035);
    this.b.setVisibility(0);
    this.b.postDelayed(new l(this), 1500L);
  }
  
  private void s()
  {
    this.t.a(3);
    setVolumeControlStream(3);
  }
  
  private void t()
  {
    this.t.a(0);
    setVolumeControlStream(0);
  }
  
  protected void a(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo)
  {
    boolean bool = true;
    a.c("message = {}", new Object[] { paramo.c() });
    a.c("status = {}", new Object[] { paramo.f() });
    a.c("voiceStatus = {}", new Object[] { Integer.valueOf(paramo.r()) });
    if (paramo.r() == 1) {
      return;
    }
    if (com.xiaoenai.app.utils.h.g.a().b() == null) {
      as.a(Xiaoenai.j(), true);
    }
    com.xiaoenai.app.utils.h.g localg = com.xiaoenai.app.utils.h.g.a();
    if (!UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue()) {}
    for (;;)
    {
      localg.a(paramo, this, bool);
      if ((paramo.f().intValue() == 0) && (paramo.g() == 2)) {
        paramo.l();
      }
      if (com.xiaoenai.app.utils.h.g.a().b() == null) {
        break;
      }
      j();
      c();
      return;
      bool = false;
    }
    k();
    d();
  }
  
  public void a(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo, int paramInt)
  {
    a.c("message = {}", new Object[] { paramo });
    if (paramo == null) {
      return;
    }
    runOnUiThread(new p(this, paramo));
  }
  
  public void a(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo, int paramInt1, int paramInt2)
  {
    a.c("message = {}", new Object[] { paramo });
    if (paramo == null) {
      return;
    }
    if (paramInt1 == paramInt2) {
      paramo.e(paramInt2);
    }
    runOnUiThread(new h(this, paramo));
  }
  
  public void b(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo)
  {
    a.c("message = {}", new Object[] { paramo });
    if (paramo == null) {}
    do
    {
      return;
      runOnUiThread(new n(this, paramo));
      this.t.a();
      paramo.d(System.currentTimeMillis());
    } while ((this.t == null) || (1 < this.t.b()));
    this.s = b.a(this, paramo.w().intValue() * 1000 + 2000);
  }
  
  public void c()
  {
    if ((this.l != null) && (!this.m))
    {
      this.m = this.k.registerListener(this, this.l, 2);
      this.n = System.currentTimeMillis();
      if (UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue()) {
        q();
      }
    }
  }
  
  public void c(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo)
  {
    a.c("message = {}", new Object[] { paramo });
    if (paramo == null) {
      return;
    }
    d();
    runOnUiThread(new o(this, paramo));
  }
  
  public void d()
  {
    if (this.m)
    {
      this.k.unregisterListener(this, this.l);
      this.m = false;
    }
  }
  
  public void d(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo)
  {
    a.c("message = {}", new Object[] { paramo });
    if (paramo == null) {
      return;
    }
    runOnUiThread(new q(this, paramo));
  }
  
  public void e(com.xiaoenai.app.classes.chat.messagelist.message.model.o paramo)
  {
    a.c("message = {}", new Object[] { paramo });
    if (paramo == null) {
      return;
    }
    runOnUiThread(new i(this, paramo));
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.g == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = this.g.getTitleTextView();
    } while (localTextView == null);
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)getResources().getDrawable(2130838790);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(localAnimationDrawable, null, null, null);
    localTextView.setCompoundDrawablePadding(ab.a(2.0F));
    localTextView.post(new m(this, localAnimationDrawable));
  }
  
  public void h()
  {
    if (this.g == null) {}
    TextView localTextView;
    do
    {
      return;
      localTextView = this.g.getTitleTextView();
    } while (localTextView == null);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  protected abstract void i();
  
  protected void j()
  {
    a.c("startWakeLock {}", new Object[] { Boolean.valueOf(Xiaoenai.j().o()) });
    if (!Xiaoenai.j().o())
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, ScreenManagerService.class);
      startService(localIntent);
    }
  }
  
  public void k()
  {
    a.c("stopWakeLock", new Object[0]);
    Intent localIntent = new Intent();
    localIntent.setClass(this, ScreenManagerService.class);
    stopService(localIntent);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = ((AudioManager)Xiaoenai.j().getSystemService("audio"));
    this.k = ((SensorManager)getSystemService("sensor"));
    this.l = this.k.getDefaultSensor(8);
    this.a = ((AutoHeightLayout)findViewById(2131558670));
    this.b = findViewById(2131558758);
    this.c = ((ImageView)findViewById(2131558759));
    this.i = ((TextView)findViewById(2131558760));
    this.t = new af(this);
    this.t.a(new g(this));
    if (!UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue()) {
      s();
    }
    for (;;)
    {
      a.c("onCreate StreamType {}", new Object[] { Integer.valueOf(this.t.c()) });
      return;
      t();
    }
  }
  
  protected void onDestroy()
  {
    com.xiaoenai.app.utils.h.g.a().g();
    super.onDestroy();
    d();
    if (this.t != null) {
      this.t.d();
    }
    k();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    a.c("onKeyDown StreamType {}", new Object[] { Integer.valueOf(this.t.c()) });
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 24: 
      this.j.adjustStreamVolume(this.t.c(), 1, 5);
      return true;
    }
    this.j.adjustStreamVolume(this.t.c(), -1, 5);
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if (!this.o) {
      o();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f = paramSensorEvent.values[0];
    a.c("-->  {}  | {} ", new Object[] { Float.valueOf(f), Float.valueOf(this.l.getMaximumRange()) });
    a.c("old {}", new Object[] { Long.valueOf(this.n) });
    a.c("new {}", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (System.currentTimeMillis() - this.n < 800L) {
      return;
    }
    a.c("onSensorChanged before StreamType {}", new Object[] { Integer.valueOf(this.t.c()) });
    if (f >= this.l.getMaximumRange()) {
      if (com.xiaoenai.app.utils.h.g.a().d())
      {
        runOnUiThread(new j(this));
        if (!UserConfig.getBoolean("Audio_mode", Boolean.valueOf(false)).booleanValue())
        {
          com.xiaoenai.app.utils.h.g.a().f();
          s();
        }
      }
    }
    for (this.o = false;; this.o = true)
    {
      a.c("onSensorChanged after StreamType {}", new Object[] { Integer.valueOf(this.t.c()) });
      return;
      this.b.setVisibility(8);
      this.j.setMode(0);
      this.t.a(3);
      setVolumeControlStream(3);
      break;
      if (com.xiaoenai.app.utils.h.g.a().d())
      {
        this.b.setVisibility(8);
        com.xiaoenai.app.utils.h.g.a().e();
        t();
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\BaseChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */