package com.xiaoenai.app.classes.settings;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.sdk.android.callback.CallbackContext;
import com.alibaba.sdk.android.session.model.Session;
import com.alibaba.sdk.android.session.model.User;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.utils.as;

public class SettingsActivity
  extends TitleBarActivity
{
  private View a;
  private View b;
  private View c;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private View n;
  private TextView o;
  private View s;
  private ImageView t;
  
  private void d()
  {
    g localg = new g(this);
    localg.a(2131101096);
    localg.a(2131101086, new ar(this));
    localg.b(2131099973, new at(this));
    localg.show();
  }
  
  private void f()
  {
    if (bj.a().b())
    {
      this.o.setText(bj.a().b.getUser().nick);
      return;
    }
    this.o.setText("未登录");
  }
  
  private void g()
  {
    e locale = new e(this);
    if (!bj.a().b()) {
      locale.a(2131101236, 1, new au(this, locale));
    }
    for (;;)
    {
      locale.show();
      return;
      locale.a(String.format(getResources().getString(2131101238), new Object[] { bj.a().b.getUser().nick }));
      locale.a(2131101233, 1, new av(this, locale));
    }
  }
  
  private void h()
  {
    bj.a().a(this, new aw(this));
  }
  
  private void i()
  {
    bj.a().a(this, new ax(this));
  }
  
  private void j()
  {
    g localg = new g(this);
    localg.a(2131101095);
    localg.a(2131100898, new ay(this));
    localg.b(2131099973, new az(this));
    localg.show();
  }
  
  private void k()
  {
    new ba(this).execute(new Void[0]);
  }
  
  public int a()
  {
    return 2130903315;
  }
  
  public void a(Class<?> paramClass)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    startActivity(localIntent);
    overridePendingTransition(2130968604, 2130968605);
  }
  
  public void c()
  {
    this.a = findViewById(2131559720);
    this.t = ((ImageView)findViewById(2131558621));
    this.a.setOnClickListener(new ap(this));
    if (as.e())
    {
      this.t.setImageResource(2130837822);
      this.b = findViewById(2131559721);
      this.b.setOnClickListener(new bb(this));
      this.c = findViewById(2131559722);
      this.c.setOnClickListener(new bc(this));
      this.i = findViewById(2131559725);
      this.i.setOnClickListener(new bd(this));
      this.j = findViewById(2131559726);
      this.j.setOnClickListener(new be(this));
      this.k = findViewById(2131559727);
      this.k.setOnClickListener(new bf(this));
      this.l = findViewById(2131559728);
      this.l.setOnClickListener(new bg(this));
      this.m = findViewById(2131559730);
      this.m.setOnClickListener(new bh(this));
      this.n = findViewById(2131559723);
      this.o = ((TextView)findViewById(2131559724));
      if (!bj.a().b()) {
        break label339;
      }
      this.o.setText(bj.a().b.getUser().nick);
    }
    for (;;)
    {
      this.n.setOnClickListener(new bi(this));
      this.s = findViewById(2131559729);
      this.s.setOnClickListener(new aq(this));
      return;
      this.t.setImageResource(2130837821);
      break;
      label339:
      this.o.setText("未登录");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    CallbackContext.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (as.e())
    {
      this.t.setImageResource(2130837822);
      return;
    }
    this.t.setImageResource(2130837821);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\settings\SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */