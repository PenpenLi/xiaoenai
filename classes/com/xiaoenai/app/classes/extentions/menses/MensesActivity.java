package com.xiaoenai.app.classes.extentions.menses;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.extentions.menses.view.gif.GifView;
import com.xiaoenai.app.net.b;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.ak;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.Locale;
import java.util.Timer;

public class MensesActivity
  extends TitleBarActivity
{
  private RelativeLayout a = null;
  private View b = null;
  private View c = null;
  private View i = null;
  private RelativeLayout j = null;
  private View k = null;
  private View l = null;
  private Fragment m = null;
  @BindView(2131559084)
  ImageView mCloseIcon;
  @BindView(2131559094)
  RelativeLayout mColseTip;
  @BindView(2131559099)
  TextView mLastMensesTme;
  @BindView(2131559098)
  LinearLayout mLayoutNotify;
  private TextView n = null;
  private GifView o = null;
  private Button s = null;
  private ac.a t = ac.a.a;
  private Handler u = new Handler();
  private Timer v = null;
  private long w = 0L;
  private String x = null;
  
  private void a(int paramInt, Fragment paramFragment)
  {
    if (paramFragment != null) {
      getSupportFragmentManager().beginTransaction().replace(paramInt, paramFragment).commitAllowingStateLoss();
    }
  }
  
  private void a(ac.a parama)
  {
    if (ac.c()) {
      return;
    }
    this.mCloseIcon.setVisibility(8);
    this.mColseTip.setVisibility(8);
    switch (q.a[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.mLayoutNotify.setVisibility(0);
      b(parama);
      return;
      this.i.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      this.a.setBackgroundResource(2131493060);
      this.s.setText(as.a(2131100865));
      if (this.v == null) {}
      for (this.v = new Timer(true);; this.v = new Timer(true))
      {
        this.w = (ac.k() - ak.b());
        this.v.schedule(new l(this), 0L, 1000L);
        break;
        this.v.cancel();
        this.v = null;
      }
      this.i.setVisibility(8);
      this.b.setVisibility(8);
      this.c.setVisibility(0);
      this.a.setBackgroundResource(2131493060);
      this.s.setText(as.a(2131100866));
      continue;
      this.i.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.a.setBackgroundResource(2131493060);
      if (as.k().equals(Locale.ENGLISH)) {
        this.s.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
      }
      this.s.setText(as.a(2131100867));
      if (this.o.getVisibility() != 0)
      {
        this.o.a();
        this.o.setVisibility(0);
      }
    }
  }
  
  private void a(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    localIntent.putExtra("type", 1);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  private void b(ac.a parama)
  {
    long l1 = ac.m();
    long l4 = System.currentTimeMillis();
    long l3 = ac.e() * 24L * 3600L * 1000L;
    long l2 = l1;
    if (l4 - l1 > l3) {
      do
      {
        l2 = l1 + l3;
        l1 = l2;
      } while (System.currentTimeMillis() - l2 > l3);
    }
    ac.a(l2);
    this.mLastMensesTme.setText(com.xiaoenai.app.utils.d.d.b(l2));
  }
  
  private void b(String paramString)
  {
    this.e = h.a(this);
    this.e.setCancelable(false);
    if (!this.e.isShowing()) {
      this.e.show();
    }
    if (paramString.equals("comming")) {
      ac.a(ac.b(), ac.d(), ac.e(), ak.b(), ac.g(), ac.h());
    }
    for (;;)
    {
      new b(new n(this, getApplicationContext())).d(paramString);
      return;
      if (paramString.equals("leaving")) {
        ac.a(ac.b(), ac.d(), ac.e(), ac.f(), ak.b(), ac.h());
      }
    }
  }
  
  private void c()
  {
    ButterKnife.bind(this);
    this.mCloseIcon.setVisibility(8);
    this.mColseTip.setVisibility(8);
    this.o = ((GifView)findViewById(2131559093));
    this.o.setGifImage(2130838726);
    this.a = ((RelativeLayout)findViewById(2131559081));
    this.b = findViewById(2131559085);
    this.c = findViewById(2131559089);
    this.i = findViewById(2131559092);
    this.o.getLayoutParams().height = (ab.b() * 200 / 320);
    this.o.a(ab.b(), this.o.getLayoutParams().height);
    this.j = new RelativeLayout(this);
    this.j.setBackgroundColor(-872415232);
    this.j.setFocusable(true);
    this.j.setClickable(true);
    this.n = ((TextView)findViewById(2131559088));
    this.s = ((Button)findViewById(2131559100));
    this.s.setOnClickListener(new e(this));
  }
  
  private void d()
  {
    new com.xiaoenai.app.net.l(new o(this, this)).w();
  }
  
  private void f()
  {
    new b(new p(this, this)).c();
  }
  
  private void g()
  {
    if (ac.l() == 0)
    {
      this.k.setVisibility(0);
      this.l.setVisibility(8);
      if (ac.c())
      {
        this.mCloseIcon.setVisibility(0);
        this.mColseTip.setVisibility(0);
        this.mLayoutNotify.setVisibility(8);
        this.b.setVisibility(8);
        this.i.setVisibility(8);
        this.c.setVisibility(8);
        this.g.setRightButtonVisible(8);
      }
    }
    while (ac.l() != 1)
    {
      return;
      this.mCloseIcon.setVisibility(8);
      this.mColseTip.setVisibility(8);
      this.mLayoutNotify.setVisibility(0);
      this.g.setRightButtonVisible(0);
      this.b.setVisibility(8);
      this.i.setVisibility(8);
      this.c.setVisibility(8);
      return;
    }
    this.k.setVisibility(8);
    this.l.setVisibility(0);
    a(2131559082, this.m);
  }
  
  private void h()
  {
    if (ac.l() == 0) {
      a(this.t);
    }
    while ((this.m == null) || (!this.m.isAdded()) || (!ac.p())) {
      return;
    }
    this.m.onResume();
  }
  
  public int a()
  {
    return 2130903174;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.t != ac.n()))
    {
      this.t = ac.n();
      a(this.t);
    }
  }
  
  protected void b()
  {
    super.b();
    if ((this.x != null) && (this.x.equals("notification"))) {
      this.g.a(2130839000, 2131100897);
    }
    this.g.setRightButtonClickListener(new d(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    String str = getIntent().getStringExtra("from");
    this.x = getIntent().getStringExtra("back");
    super.onCreate(paramBundle);
    c();
    this.k = findViewById(2131559083);
    this.l = findViewById(2131559082);
    this.m = new MensesMaleFragment();
    if ((str != null) && (str.equals(MensesEditSexActivity.class.getName())))
    {
      f();
      return;
    }
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.v != null)
    {
      this.v.cancel();
      this.v = null;
    }
    if (this.o != null) {
      this.o.b();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    g();
    this.t = ac.n();
    if (ac.p()) {
      a(this.t);
    }
  }
  
  @OnClick({2131559097})
  void start()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, MensesSettingActivity.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("isStart", true);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\MensesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */