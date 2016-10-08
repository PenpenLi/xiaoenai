package com.xiaoenai.app.classes.lock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.BaseActivity;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.a.g;

public class LockScreenActivity
  extends BaseActivity
{
  private ImageView a = null;
  private ImageView b = null;
  private ImageView c = null;
  private ImageView f = null;
  private StringBuffer g = new StringBuffer();
  private String h = null;
  private Button i;
  private int j = 0;
  private LinearLayout k;
  private View.OnClickListener l = new b(this);
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.a.getTag() == null)
    {
      this.a.setImageResource(paramInt1);
      this.a.setTag("1");
    }
    for (;;)
    {
      this.g.append(paramInt2);
      if (this.g.length() == 4)
      {
        com.xiaoenai.app.utils.f.a.c("{} {}", new Object[] { this.g, this.h });
        if (!this.g.toString().equals(this.h)) {
          break;
        }
        Xiaoenai.j().a(false);
        UserConfig.setBoolean("lock_show_lock", Boolean.valueOf(false));
        com.xiaoenai.app.classes.common.a.a().a(LockScreenActivity.class);
      }
      return;
      if (this.b.getTag() == null)
      {
        this.b.setImageResource(paramInt1);
        this.b.setTag("1");
      }
      else if (this.c.getTag() == null)
      {
        this.c.setImageResource(paramInt1);
        this.c.setTag("1");
      }
      else if (this.f.getTag() == null)
      {
        this.f.setImageResource(paramInt1);
        this.f.setTag("1");
      }
    }
    this.g.delete(0, this.g.length());
    h();
    a(this.k);
    this.j += 1;
    if (this.j >= 3)
    {
      g();
      this.j = 0;
    }
    d();
    b();
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LockScreenActivity.class);
    localIntent.addFlags(65536);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(View paramView)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 30.0F, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setInterpolator(new CycleInterpolator(3.0F));
    paramView.startAnimation(localTranslateAnimation);
  }
  
  private static void b(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setFlags(268435456);
    localIntent.addCategory("android.intent.category.HOME");
    paramActivity.startActivity(localIntent);
  }
  
  private void c()
  {
    this.h = UserConfig.getStringWithDecypt("lock_password_v2");
    this.a = ((ImageView)findViewById(2131559582));
    this.b = ((ImageView)findViewById(2131559583));
    this.c = ((ImageView)findViewById(2131559584));
    this.f = ((ImageView)findViewById(2131559585));
    this.k = ((LinearLayout)findViewById(2131559581));
    findViewById(2131559586).setOnClickListener(this.l);
    findViewById(2131559587).setOnClickListener(this.l);
    findViewById(2131559588).setOnClickListener(this.l);
    findViewById(2131559589).setOnClickListener(this.l);
    findViewById(2131559590).setOnClickListener(this.l);
    findViewById(2131559591).setOnClickListener(this.l);
    findViewById(2131559592).setOnClickListener(this.l);
    findViewById(2131559593).setOnClickListener(this.l);
    findViewById(2131559594).setOnClickListener(this.l);
    findViewById(2131559596).setOnClickListener(this.l);
    this.i = ((Button)findViewById(2131559597));
    this.i.setOnClickListener(this.l);
    Button localButton = (Button)findViewById(2131559595);
    localButton.setOnClickListener(new a(this));
    localButton.setVisibility(0);
  }
  
  private void d()
  {
    this.f.postDelayed(new c(this), 100L);
  }
  
  private void f()
  {
    if (this.f.getTag() != null)
    {
      this.f.setImageResource(2130838653);
      this.f.setTag(null);
    }
    for (;;)
    {
      if (this.g.length() > 0) {
        this.g.deleteCharAt(this.g.length() - 1);
      }
      if (this.g.length() <= 0) {
        b();
      }
      return;
      if (this.c.getTag() != null)
      {
        this.c.setImageResource(2130838653);
        this.c.setTag(null);
      }
      else if (this.b.getTag() != null)
      {
        this.b.setImageResource(2130838653);
        this.b.setTag(null);
      }
      else if (this.a.getTag() != null)
      {
        this.a.setImageResource(2130838653);
        this.a.setTag(null);
      }
    }
  }
  
  private void g()
  {
    g localg = new g(this);
    localg.a(2131100626);
    localg.a(2131100898, new d(this));
    localg.b(2131099973, new e(this));
    localg.show();
  }
  
  private void h()
  {
    ((Vibrator)getSystemService("vibrator")).vibrate(new long[] { 100L, 300L }, -1);
  }
  
  public void a()
  {
    this.i.setVisibility(0);
  }
  
  public void b()
  {
    this.i.setVisibility(4);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    setContentView(2130903268);
    c();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      b(this);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Xiaoenai.j().a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\lock\LockScreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */