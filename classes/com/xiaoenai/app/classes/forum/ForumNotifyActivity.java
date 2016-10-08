package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.RefreshCustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.e;
import com.xiaoenai.app.classes.common.mvp.view.activity.BaseListActivity;
import com.xiaoenai.app.classes.common.mvp.view.c;
import com.xiaoenai.app.classes.common.webview.WebViewActivity;
import com.xiaoenai.app.classes.forum.a.k.a;
import com.xiaoenai.app.classes.forum.b.d;
import com.xiaoenai.app.classes.forum.presenter.an;
import com.xiaoenai.app.classes.street.ea;
import com.xiaoenai.app.model.Forum.b;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.ui.component.view.ProgressView;
import com.xiaoenai.app.widget.TitleBarView;
import java.util.List;

public class ForumNotifyActivity
  extends BaseListActivity<com.xiaoenai.app.model.g>
  implements c<com.xiaoenai.app.model.g>, k.a, com.xiaoenai.app.classes.forum.c.a
{
  protected boolean a = UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue();
  private com.xiaoenai.app.ui.a.g b;
  private com.xiaoenai.app.classes.forum.a.k c;
  private an i;
  private boolean j;
  @BindView(2131558669)
  ProgressView mProgessView;
  @BindView(2131558668)
  RefreshCustomUltimateRecyclerview mRecyclerview;
  
  public int a()
  {
    return 2130903069;
  }
  
  public void a(View paramView, com.xiaoenai.app.model.g paramg)
  {
    paramView = new Intent();
    if (paramg.j.m == 3)
    {
      if ((paramg.i == null) || (paramg.i.length() == 0))
      {
        paramView.setClass(this, ForumMomentActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putInt("moment_flag", paramg.h);
        localBundle.putString("from", getString(2131100475));
        localBundle.putString("post_id", String.valueOf(paramg.j.n));
        localBundle.putString("topic_id", String.valueOf(paramg.j.i));
        paramView.putExtras(localBundle);
      }
      for (;;)
      {
        startActivity(paramView);
        overridePendingTransition(2130968604, 2130968605);
        return;
        paramView.setClass(this, WebViewActivity.class);
        paramView.putExtra("url", ea.a(paramg.i));
      }
    }
    if (paramg.j.n > 0) {
      paramView.setClass(this, ForumNotiTopicActivity.class);
    }
    for (;;)
    {
      paramView.putExtra("forum_topic_id", paramg.j.i);
      paramView.putExtra("forum_reply_id", paramg.j.n);
      break;
      paramView.setClass(this, ForumTopicActivity.class);
    }
  }
  
  public void a(List<com.xiaoenai.app.model.g> paramList)
  {
    if (paramList != null) {
      this.c.a(0, paramList);
    }
  }
  
  public void a(List<com.xiaoenai.app.model.g> paramList, boolean paramBoolean)
  {
    if ((this.j) && ((paramList == null) || (paramList.size() == 0)))
    {
      this.j = false;
      this.c.a(false);
      this.i.a(0);
      return;
    }
    super.a(paramList, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!this.j) && (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      super.a(paramBoolean);
      return;
    }
  }
  
  protected void b()
  {
    super.b();
    this.g.setRightButtonClickListener(new bh(this));
  }
  
  public e<com.xiaoenai.app.model.g> d()
  {
    return this.c;
  }
  
  public ProgressView e()
  {
    return this.mProgessView;
  }
  
  public com.xiaoenai.app.classes.common.mvp.a.a<com.xiaoenai.app.model.g> f()
  {
    return this.i;
  }
  
  public void g()
  {
    this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    super.g();
    Resources localResources = getResources();
    int k;
    if (UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue())
    {
      k = 2131492944;
      k = localResources.getColor(k);
      int m = d.a().c();
      if ((!this.j) || (m <= 0)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      this.c = new com.xiaoenai.app.classes.forum.a.k(this, bool);
      this.c.d().setBackgroundColor(k);
      this.mRecyclerview.setEmptyView(2130903205);
      this.mRecyclerview.setAdapter(this.c);
      this.c.a(this);
      return;
      k = 2131492952;
      break;
    }
  }
  
  public c<com.xiaoenai.app.model.g> i()
  {
    return this;
  }
  
  public CustomUltimateRecyclerview i_()
  {
    return this.mRecyclerview;
  }
  
  public void j()
  {
    ButterKnife.bind(this);
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.j = localIntent.getBooleanExtra("key_is_new", true);
      if (localIntent.getBooleanExtra("key_is_from_forum", false)) {
        this.g.a(2130839000, 2131100366);
      }
    }
  }
  
  public boolean k()
  {
    return this.j;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(this.a);
    this.i = new an(this);
    super.onCreate(paramBundle);
    this.b = new com.xiaoenai.app.ui.a.g(this);
    this.b.a(2131100053);
    this.b.d(com.xiaoenai.app.ui.a.k.j);
    this.b.a(2131100898, new bf(this));
    this.b.b(2131099973, new bg(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.b = null;
  }
  
  public void onNewMoreClick(View paramView)
  {
    this.j = false;
    this.c.a(false);
    this.i.a(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumNotifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */