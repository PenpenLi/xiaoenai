package com.xiaoenai.app.classes.forum;

import android.os.Bundle;
import android.widget.ListView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.extentions.forum.SwitchLayout;
import com.xiaoenai.app.classes.extentions.forum.SwitchLayout.a;
import com.xiaoenai.app.model.Forum.f;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.widget.PullToRefreshListViewEx;
import java.util.ArrayList;
import java.util.List;

public class ForumShowoffActivity
  extends TitleBarActivity
  implements SwitchLayout.a
{
  private PullToRefreshListViewEx a;
  private com.xiaoenai.app.classes.forum.a.g b;
  private SwitchLayout c;
  private int i = 0;
  private List<f> j = new ArrayList();
  private List<f> k = new ArrayList();
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  
  private void d()
  {
    this.c = ((SwitchLayout)findViewById(2131559302));
    this.c.setTheme(this.h);
    this.c.setLeftTabString(getString(2131100455));
    this.c.setRightTabString(getString(2131100454));
    this.c.setOnTabChangeListener(this);
    this.a = ((PullToRefreshListViewEx)findViewById(2131559303));
    ((ListView)this.a.getRefreshableView()).setHeaderDividersEnabled(true);
    this.b = new com.xiaoenai.app.classes.forum.a.g(this, this.j);
    this.a.setAdapter(this.b);
    this.a.setOnRefreshListener(new cp(this));
    this.a.setOnLastItemVisibleListener(new cq(this));
    if (this.j.size() == 0) {
      this.a.setRefreshing(false);
    }
  }
  
  private void f()
  {
    if (this.l) {
      return;
    }
    if (!this.m)
    {
      this.a.p();
      return;
    }
    this.a.o();
    if (this.i == 0)
    {
      g();
      return;
    }
    h();
  }
  
  private void g()
  {
    new com.xiaoenai.app.net.g(new cr(this, this)).f(1);
  }
  
  private void h()
  {
    new com.xiaoenai.app.net.g(new ct(this, this)).f(0);
  }
  
  public int a()
  {
    return 2130903215;
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
    if (this.i == 0) {
      this.b.a(this.j, 1);
    }
    do
    {
      return;
      this.b.a(this.k, 0);
    } while (this.k.size() != 0);
    this.a.setRefreshing(false);
  }
  
  protected void c()
  {
    if (this.l) {
      return;
    }
    this.n = true;
    if (this.i == 0)
    {
      g();
      return;
    }
    h();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    super.onCreate(paramBundle);
    d();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumShowoffActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */