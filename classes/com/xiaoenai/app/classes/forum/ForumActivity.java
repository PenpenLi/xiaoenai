package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.common.widget.RedView;
import com.xiaoenai.app.classes.forum.fragment.NewForumTopicsFragment;
import com.xiaoenai.app.classes.forum.widget.RedPointThreeTabLayout;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.widget.TitleBarView;

public class ForumActivity
  extends TitleBarActivity
{
  protected boolean a = UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue();
  private RedPointThreeTabLayout b;
  private ViewPager c;
  private PopupWindow i;
  private RedView j;
  private RedView k;
  private TextView l;
  private SparseArray<com.xiaoenai.app.classes.common.mvp.view.a.a> m;
  private FragmentStatePagerAdapter n = new a(this, getSupportFragmentManager());
  
  private void d()
  {
    String str = getIntent().getStringExtra("from");
    if ((str != null) && (str.length() > 0))
    {
      if (!str.equals("notification")) {
        break label56;
      }
      this.g.a(getResources().getDrawable(2130839000), getResources().getString(2131100897));
    }
    label56:
    while (!str.equals("push")) {
      return;
    }
    this.g.a(getResources().getDrawable(2130839000), null);
  }
  
  private void f()
  {
    this.c = ((ViewPager)findViewById(2131559194));
    this.c.setAdapter(this.n);
    this.c.setOffscreenPageLimit(2);
    this.c.setCurrentItem(0);
    if (!this.a)
    {
      int i1 = UserConfig.getInt("chat_title_color", Integer.valueOf(-1864528)).intValue();
      Object localObject = { 16842919 };
      int[] arrayOfInt = new int[0];
      localObject = new ColorStateList(new int[][] { { 16842913 }, localObject, arrayOfInt }, new int[] { i1, i1, -1 });
      this.b.setRedTextViewColorList((ColorStateList)localObject);
    }
  }
  
  private void g()
  {
    this.b.setOnTabSelectedListener(new b(this));
    this.c.setOnPageChangeListener(new c(this));
  }
  
  public int a()
  {
    return 2130903190;
  }
  
  public void a(int paramInt)
  {
    if (dm.c())
    {
      this.b.a(paramInt);
      return;
    }
    this.b.b(paramInt);
  }
  
  protected void b()
  {
    super.b();
    View localView = getLayoutInflater().inflate(2130903210, null);
    this.b = ((RedPointThreeTabLayout)localView.findViewById(2131559270));
    this.g.a(null, localView);
    localView = getLayoutInflater().inflate(2130903217, null);
    this.l = ((TextView)localView.findViewById(2131559310));
    this.g.setRightButtonView(localView);
    this.g.setLeftButtonClickListener(new d(this));
    this.g.setRightButtonClickListener(new e(this));
  }
  
  public void c()
  {
    if ((this.j.c()) || (this.k.c())) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }
  
  @OnClick({2131559227})
  void doNewPostAction()
  {
    this.i.dismiss();
    if (dm.a(this))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this, ForumPostActivity.class);
      startActivityForResult(localIntent, 1);
      overridePendingTransition(2130968608, 2130968609);
    }
  }
  
  @OnClick({2131559230})
  void forumSetting()
  {
    this.i.dismiss();
    startActivity(new Intent(this, ForumMineActivity.class));
    overridePendingTransition(2130968604, 2130968605);
  }
  
  @OnClick({2131559228})
  void goMessage()
  {
    this.i.dismiss();
    Object localObject = new Intent(this, ForumNotifyActivity.class);
    ((Intent)localObject).putExtra("key_is_new", false);
    ((Intent)localObject).putExtra("key_is_from_forum", true);
    startActivity((Intent)localObject);
    localObject = (com.xiaoenai.app.common.view.a.a)this.m.get(0);
    if (localObject != null) {
      ((NewForumTopicsFragment)localObject).b(true);
    }
    overridePendingTransition(2130968604, 2130968605);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        break label141;
      }
      if ((this.m != null) && (this.m.size() > 2) && (this.c.getCurrentItem() != 1))
      {
        this.b.setCurrentPosition(1);
        this.c.setCurrentItem(1, false);
      }
      paramIntent = (NewForumTopicsFragment)this.m.get(1);
      if (paramIntent != null)
      {
        paramIntent.f().a();
        paramIntent.j();
      }
      if (paramInt1 != 2) {
        break label123;
      }
      Xiaoenai.j().a(new f(this), 300L);
    }
    label123:
    label141:
    while (paramInt1 != 259)
    {
      return;
      Xiaoenai.j().a(new g(this), 300L);
      return;
    }
    Xiaoenai.j().a(new h(this), 300L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(this.a);
    y();
    super.onCreate(paramBundle);
    com.xiaoenai.app.h.b.a.a(ForumActivity.class);
    f();
    this.m = new SparseArray();
    g();
    d();
    com.xiaoenai.app.stat.c.a().a(111);
    if (this.i == null)
    {
      paramBundle = View.inflate(this, 2130903198, null);
      this.j = ((RedView)paramBundle.findViewById(2131559231));
      this.k = ((RedView)paramBundle.findViewById(2131559229));
      this.i = new PopupWindow(paramBundle, -2, -2, true);
      this.i.setOutsideTouchable(true);
      this.i.setBackgroundDrawable(getResources().getDrawable(2130839016));
      ButterKnife.bind(this, paramBundle);
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    d();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (UserConfig.getBoolean("forum_first_click_wifi_loaded_flag", Boolean.valueOf(false)).booleanValue()) {
      this.j.a();
    }
    for (;;)
    {
      c();
      Boolean localBoolean = UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false));
      if (this.a != localBoolean.booleanValue())
      {
        this.a = localBoolean.booleanValue();
        e(this.a);
      }
      return;
      this.j.b();
    }
  }
  
  protected void y()
  {
    new com.xiaoenai.app.net.g(new i(this, this)).a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */