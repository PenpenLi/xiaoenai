package com.xiaoenai.app.classes.extentions.todo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.handmark.pulltorefresh.library.internal.PinnedSectionListView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.extentions.todo.a.a;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.stat.c;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.utils.as;
import com.xiaoenai.app.utils.d.d;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TodoActivity
  extends TitleBarActivity
  implements AbsListView.OnScrollListener
{
  public boolean a = true;
  private int b = 0;
  private boolean c = false;
  private PinnedSectionListView i;
  private o j;
  private ProgressView k;
  private ViewGroup l;
  
  private List<a> a(List<com.xiaoenai.app.classes.extentions.todo.a.b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Collections.sort(paramList, new u(this));
    int m = 0;
    while (m < paramList.size())
    {
      String str = d.c(((com.xiaoenai.app.classes.extentions.todo.a.b)paramList.get(m)).b() * 1000L);
      if (!localHashMap.containsKey(str))
      {
        a locala = new a();
        locala.a(1);
        locala.a(((com.xiaoenai.app.classes.extentions.todo.a.b)paramList.get(m)).b());
        localArrayList.add(locala);
        localHashMap.put(str, locala);
      }
      localArrayList.add(paramList.get(m));
      m += 1;
    }
    localHashMap.clear();
    return localArrayList;
  }
  
  private void d()
  {
    if (this.c) {
      return;
    }
    new com.xiaoenai.app.net.b(new t(this, this, this.b)).a(Integer.valueOf(this.b), Integer.valueOf(20), 0);
  }
  
  private void f()
  {
    if (ao.a().c() > 0)
    {
      this.l.setVisibility(8);
      return;
    }
    this.l.setVisibility(0);
  }
  
  public int a()
  {
    return 2130903185;
  }
  
  protected void b()
  {
    super.b();
    this.g.setLeftButtonClickListener(new r(this));
    this.g.setRightButtonClickListener(new s(this));
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = ((ProgressView)findViewById(2131559170));
    this.l = ((ViewGroup)findViewById(2131560075));
    this.i = ((PinnedSectionListView)findViewById(2131559169));
    this.j = new o(this);
    this.i.setAdapter(this.j);
    this.i.setShadowVisible(false);
    ao.a();
    this.i.setOnScrollListener(this);
    as.a(this.i);
    d();
    c.a().a(105);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      r();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.c)
    {
      this.j.a(a(ao.a().b()));
      this.b = ao.a().c();
    }
    if (!UserConfig.getBoolean("first_time_in_todo", Boolean.valueOf(true)).booleanValue()) {
      f();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView.getCount() > 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (c())) {
      d();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void r()
  {
    ab.b(this);
    finish();
    overridePendingTransition(2130968606, 2130968607);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\extentions\todo\TodoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */