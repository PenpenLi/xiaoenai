package com.xiaoenai.app.classes.extentions.menses;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.extentions.anniversary.DatePickerView;
import com.xiaoenai.app.model.User;
import com.xiaoenai.app.net.b;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.TitleBarView;
import com.xiaoenai.app.widget.wheel.WheelView;

public class MensesSettingActivity
  extends TitleBarActivity
{
  private ScrollView A = null;
  private ImageView B = null;
  private int C = 0;
  private boolean D = false;
  private Handler E = new Handler();
  private Runnable F = new ad(this);
  private Runnable G = new ao(this);
  private long a = 31536000000L;
  private boolean b = true;
  private final int c = 6;
  private final int i = 15;
  private final int j = 5;
  private final int k = 15;
  private final int l = 90;
  private final int m = 28;
  @BindView(2131559131)
  TextView mScrollStopView;
  @BindView(2131559133)
  TextView mStopView;
  private View n = null;
  private View o = null;
  private View s = null;
  private TextView t = null;
  private TextView u = null;
  private TextView v = null;
  private Button w = null;
  private DatePickerView x = null;
  private WheelView y = null;
  private WheelView z = null;
  
  private void a(int paramInt)
  {
    new b(new am(this, this, paramInt)).b(paramInt);
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ac.a(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3, paramString);
  }
  
  private void a(Context paramContext, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString)
  {
    ac.a(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3, paramString);
    t.b(paramContext);
  }
  
  private void a(Class<?> paramClass)
  {
    if (this.C == 0)
    {
      ab.b(this);
      Intent localIntent = new Intent();
      localIntent.setClass(this, paramClass);
      localIntent.putExtra("type", 1);
      startActivity(localIntent);
      finish();
      overridePendingTransition(2130968604, 2130968605);
      return;
    }
    r();
  }
  
  private void b(boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      this.x.setVisibility(0);
      this.mStopView.setVisibility(8);
      TextView localTextView = this.mScrollStopView;
      if (this.b) {}
      for (;;)
      {
        localTextView.setVisibility(i1);
        f();
        return;
        i1 = 8;
      }
    }
    this.x.setVisibility(8);
    d();
  }
  
  private void c()
  {
    ButterKnife.bind(this);
    this.A = ((ScrollView)findViewById(2131558587));
    long l1;
    if (ac.l() == 0)
    {
      ((TextView)findViewById(2131559116)).setText(2131100839);
      ((TextView)findViewById(2131559117)).setText(2131100840);
      this.n = findViewById(2131559118);
      this.n.setOnClickListener(new ap(this));
      this.o = findViewById(2131559121);
      this.o.setOnClickListener(new aq(this));
      this.s = findViewById(2131559125);
      this.s.setOnClickListener(new ar(this));
      this.t = ((TextView)findViewById(2131559120));
      this.u = ((TextView)findViewById(2131559123));
      this.v = ((TextView)findViewById(2131559127));
      this.w = ((Button)findViewById(2131559129));
      this.w.setOnClickListener(new as(this));
      this.x = ((DatePickerView)findViewById(2131559033));
      this.x.setMinDate(System.currentTimeMillis() - this.a);
      this.x.setMaxDate(System.currentTimeMillis());
      this.x.setDatePickerListener(new at(this));
      this.x.getYearWheel().setOnTouchListener(new au(this));
      this.x.getMonthWheel().setOnTouchListener(new av(this));
      this.x.getDayWheel().setOnTouchListener(new ae(this));
      this.y = ((WheelView)findViewById(2131559124));
      this.y.setCyclic(true);
      this.y.setVisibleItems(5);
      this.y.setViewAdapter(new a(this, 6, 15, com.xiaoenai.app.utils.as.a(2131100833)));
      this.y.a(new af(this));
      this.y.setOnTouchListener(new ag(this));
      this.z = ((WheelView)findViewById(2131559128));
      this.z.setCyclic(true);
      this.z.setVisibleItems(5);
      this.z.setViewAdapter(new a(this, 15, 90, com.xiaoenai.app.utils.as.a(2131100833)));
      this.z.a(new ah(this));
      this.z.setOnTouchListener(new ai(this));
      l1 = ac.m();
      if (0L != l1) {
        break label692;
      }
      this.t.setText(com.xiaoenai.app.utils.d.d.c(com.xiaoenai.app.utils.d.d.a()));
      label501:
      i1 = ac.d();
      if (i1 != 0) {
        break label704;
      }
      this.u.setText(String.format(com.xiaoenai.app.utils.as.a(2131100833), new Object[] { Integer.valueOf(5) }));
      this.y.setCurrentItem(-1);
      label544:
      i1 = ac.e();
      if (i1 != 0) {
        break label745;
      }
      this.v.setText(String.format(com.xiaoenai.app.utils.as.a(2131100833), new Object[] { Integer.valueOf(28) }));
      this.z.setCurrentItem(13);
    }
    for (;;)
    {
      this.B = ((ImageView)findViewById(2131559132));
      this.o.setVisibility(8);
      ((TextView)findViewById(2131559130)).setOnClickListener(new aj(this));
      if (!this.D) {
        break label786;
      }
      this.mStopView.setVisibility(8);
      this.mScrollStopView.setVisibility(8);
      return;
      ((TextView)findViewById(2131559116)).setText(2131100845);
      ((TextView)findViewById(2131559117)).setText(2131100846);
      break;
      label692:
      this.x.a(l1, false);
      break label501;
      label704:
      this.u.setText(String.format(com.xiaoenai.app.utils.as.a(2131100833), new Object[] { Integer.valueOf(i1) }));
      this.y.setCurrentItem(i1 - 6);
      break label544;
      label745:
      this.v.setText(String.format(com.xiaoenai.app.utils.as.a(2131100833), new Object[] { Integer.valueOf(i1) }));
      this.z.setCurrentItem(i1 - 15);
    }
    label786:
    TextView localTextView = this.mStopView;
    if (this.b) {}
    for (int i1 = 0;; i1 = 8)
    {
      localTextView.setVisibility(i1);
      this.mScrollStopView.setVisibility(8);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.y.setVisibility(0);
      f();
      return;
    }
    this.y.setVisibility(8);
    d();
  }
  
  private void d()
  {
    this.w.setFocusable(true);
    this.w.setFocusableInTouchMode(true);
    this.w.requestFocus();
  }
  
  private void f()
  {
    this.B.setFocusable(true);
    this.B.setFocusableInTouchMode(true);
    this.B.requestFocus();
    this.A.fullScroll(130);
    this.E.post(this.F);
  }
  
  private void f(boolean paramBoolean)
  {
    int i1 = 0;
    if (paramBoolean)
    {
      this.z.setVisibility(0);
      this.mStopView.setVisibility(8);
      TextView localTextView = this.mScrollStopView;
      if (this.b) {}
      for (;;)
      {
        localTextView.setVisibility(i1);
        f();
        return;
        i1 = 8;
      }
    }
    this.z.setVisibility(8);
    d();
  }
  
  private void g()
  {
    User.getInstance();
    if (User.isSingle())
    {
      com.xiaoenai.app.utils.as.a();
      return;
    }
    long l1 = this.x.getAdjustDateTs();
    ac.a(this.x.getDateTs());
    int i1 = this.z.getCurrentItem() + 15;
    a(l1, i1, 7, 0L, 0L, ac.h());
    this.e = h.a(this);
    this.e.setCancelable(false);
    if (!this.e.isShowing()) {
      this.e.show();
    }
    new b(new an(this, this)).a(l1, 7, i1);
  }
  
  public int a()
  {
    return 2130903177;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(MensesActivity.class);
    }
  }
  
  protected void b()
  {
    super.b();
    this.C = getIntent().getIntExtra("type", 0);
    this.D = getIntent().getBooleanExtra("isStart", false);
    if (1 == this.C) {
      this.g.a(2130839000, 2131100855);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    String str = getIntent().getStringExtra("from");
    super.onCreate(paramBundle);
    if ((str != null) && (str.equals(MensesEditSexActivity.class.getName()))) {
      this.g.a(getResources().getString(2131100855), null);
    }
    for (;;)
    {
      this.b = ac.p();
      c();
      ac.a(this);
      return;
      this.g.a(getResources().getString(2131100871), null);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ac.b(this);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  @OnClick({2131559131, 2131559133})
  protected void showColseDialog()
  {
    g localg = new g(this);
    localg.a(2131100898, new ak(this));
    localg.b(2131099973, new al(this));
    localg.a(getResources().getString(2131100873));
    localg.show();
  }
  
  class a
    extends com.xiaoenai.app.widget.wheel.a.d
  {
    public a(Context paramContext, int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt1, paramInt2, paramString);
    }
    
    protected void a(TextView paramTextView)
    {
      paramTextView.setTextColor(-16777216);
      paramTextView.setGravity(17);
      paramTextView.setTextSize(20.0F);
      paramTextView.setLines(1);
      paramTextView.setTypeface(Typeface.SANS_SERIF);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\menses\MensesSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */