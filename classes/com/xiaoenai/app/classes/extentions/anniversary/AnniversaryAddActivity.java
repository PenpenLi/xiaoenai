package com.xiaoenai.app.classes.extentions.anniversary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.extentions.reward.model.BaseTask;
import com.xiaoenai.app.net.b;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.utils.f.a;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class AnniversaryAddActivity
  extends TitleBarActivity
{
  private EditText a;
  private TextView b;
  private View c;
  private TextView i;
  private TextView j;
  private Button k;
  private TextView l;
  private TextView m;
  private DatePickerView n;
  private int o;
  private ah s;
  private com.xiaoenai.app.ui.a.h t;
  private long u = 0L;
  private int v = 1;
  private int w = 0;
  private String x;
  private boolean y = false;
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.i.setText(2131099943);
      return;
    case 1: 
      this.i.setText(2131099933);
      return;
    case 2: 
      this.i.setText(2131099932);
      return;
    }
    this.i.setText(2131099934);
  }
  
  private void a(ah paramah)
  {
    boolean bool = true;
    this.g.setTitle(2131099931);
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.k.setVisibility(0);
    this.j.setVisibility(0);
    this.a.setText(paramah.i());
    this.a.setSelection(paramah.i().length());
    DatePickerView localDatePickerView;
    long l1;
    if (this.v == 1)
    {
      this.b.setText(paramah.h());
      this.g.setRightButtonClickListener(new j(this));
      localDatePickerView = this.n;
      l1 = paramah.b();
      if (this.v != 0) {
        break label146;
      }
    }
    for (;;)
    {
      localDatePickerView.a(l1 * 1000L, bool);
      return;
      this.b.setText(paramah.h());
      break;
      label146:
      bool = false;
    }
  }
  
  private void b(ah paramah)
  {
    this.g.setTitle(2131099931);
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.k.setVisibility(8);
    this.j.setVisibility(8);
    this.a.setEnabled(false);
    this.a.setText(paramah.j());
    this.a.setText(paramah.i());
    this.y = false;
    this.b.setText(paramah.h());
    if (paramah.a().equals(ah.b)) {
      this.g.setRightButtonClickListener(new k(this));
    }
    for (;;)
    {
      this.l.setEnabled(false);
      this.m.setEnabled(false);
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      this.c.setVisibility(8);
      findViewById(2131559034).setVisibility(8);
      this.n.setMaxDate(System.currentTimeMillis());
      this.n.a(paramah.b() * 1000L, false);
      return;
      if (paramah.l() == null) {
        this.g.setRightButtonClickListener(new l(this));
      } else {
        this.g.setRightButtonClickListener(new m(this));
      }
    }
  }
  
  private void c(int paramInt)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(paramInt);
    localg.a(2131100898, new o(this));
    localg.show();
  }
  
  private void d()
  {
    this.k = ((Button)findViewById(2131559041));
    this.j = ((TextView)findViewById(2131559040));
    this.k.setOnClickListener(new w(this));
    this.a = ((EditText)findViewById(2131559028));
    this.b = ((TextView)findViewById(2131559029));
    this.b.setText(d.d(System.currentTimeMillis()));
    this.b.setOnClickListener(new y(this));
    this.a.addTextChangedListener(new z(this));
    this.c = findViewById(2131559035);
    this.c.setOnClickListener(new aa(this));
    this.i = ((TextView)findViewById(2131559038));
    this.l = ((TextView)findViewById(2131559030));
    this.m = ((TextView)findViewById(2131559031));
    f();
    this.l.setOnClickListener(new ab(this));
    this.m.setOnClickListener(new ac(this));
    this.n = ((DatePickerView)findViewById(2131559033));
    this.n.setDatePickerListener(new g(this));
    this.a.setOnClickListener(new h(this));
  }
  
  private void f()
  {
    if (this.v == 1)
    {
      this.l.setTextColor(-1);
      this.m.setTextColor(-16742916);
      this.l.setBackgroundResource(2130837612);
      this.m.setBackgroundResource(2130837613);
      return;
    }
    this.m.setBackgroundResource(2130837614);
    this.l.setBackgroundResource(2130837611);
    this.l.setTextColor(-16742916);
    this.m.setTextColor(-1);
  }
  
  private void g()
  {
    this.n.setVisibility(8);
    findViewById(2131559032).setVisibility(8);
  }
  
  private void h()
  {
    this.n.setVisibility(0);
    findViewById(2131559032).setVisibility(0);
  }
  
  private void i()
  {
    this.g.setTitle(2131099919);
    this.a.setVisibility(0);
    this.a.setHint(2131099947);
    this.b.setVisibility(0);
    this.k.setVisibility(8);
    this.j.setVisibility(0);
    this.g.b(0, 2131099929);
    this.g.setRightButtonClickListener(new i(this));
  }
  
  private void j()
  {
    new b(new n(this, this)).a(this.s.l());
  }
  
  private void k()
  {
    com.xiaoenai.app.utils.ab.b(this);
    if ((this.a.getText() == null) || (this.a.getText().length() == 0))
    {
      c(2131099920);
      return;
    }
    if ((this.b.getText() == null) || (this.b.getText().length() == 0))
    {
      c(2131099922);
      return;
    }
    this.x = this.a.getText().toString();
    new b(new p(this, this)).a(this.u, this.x, this.v, this.w);
  }
  
  private void o()
  {
    com.xiaoenai.app.utils.ab.b(this);
    if ((this.a.getText() == null) || (this.a.getText().length() == 0))
    {
      c(2131099920);
      return;
    }
    if ((this.b.getText() == null) || (this.b.getText().length() == 0))
    {
      c(2131099922);
      return;
    }
    this.x = this.a.getText().toString();
    new b(new r(this, this)).a(this.s.l(), this.x, Long.valueOf(this.u), this.v, this.w);
  }
  
  private void p()
  {
    a.c("Loving_time = {}", new Object[] { Long.valueOf(this.u) });
    Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
    localCalendar.setTimeInMillis(this.u * 1000L);
    new com.xiaoenai.app.net.l(new s(this, this, localCalendar)).a(localCalendar.getTimeInMillis() / 1000L, null, null, null, null, null);
  }
  
  private void q()
  {
    BaseTask.doTaskAction(4, 1, this);
  }
  
  public int a()
  {
    return 2130903165;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new q(this));
    this.g.b(0, 2131099929);
    this.g.setRightButtonClickListener(new v(this));
  }
  
  public void c()
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(this);
    localg.a(2131100898, new t(this));
    localg.b(2131099973, new u(this));
    localg.a(2131100392);
    localg.show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 11) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("repeat", this.w);
      if (paramInt1 != this.w)
      {
        this.y = true;
        this.w = paramInt1;
        a(paramInt1);
      }
    }
    while ((paramInt1 != 100) || (paramInt2 != -1)) {
      return;
    }
    this.s.a(paramIntent.getLongExtra("ts", 0L));
    this.b.setText(this.s.h());
    this.y = true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = getIntent().getIntExtra("index", -1);
    if (this.o == -1)
    {
      this.s = new ah();
      if (this.u == 0L) {
        this.u = (System.currentTimeMillis() / 1000L);
      }
      d();
      if (this.o != -1) {
        break label227;
      }
      i();
    }
    for (;;)
    {
      a(this.s.c());
      if (this.c.getVisibility() != 8)
      {
        this.b.clearFocus();
        this.a.setFocusableInTouchMode(true);
        this.a.setFocusable(true);
        this.a.requestFocus();
        this.a.postDelayed(new f(this), 100L);
      }
      return;
      this.s = ((ah)ai.a().b().get(this.o));
      this.u = this.s.b();
      if (this.s.d()) {}
      for (int i1 = 0;; i1 = 1)
      {
        this.v = i1;
        this.w = this.s.c();
        this.x = this.s.i();
        break;
      }
      label227:
      if (this.s.a().equals(ah.a)) {
        a(this.s);
      } else {
        b(this.s);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.y) {
        c();
      }
      for (;;)
      {
        return true;
        r();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    com.xiaoenai.app.utils.ab.b(this);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\anniversary\AnniversaryAddActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */