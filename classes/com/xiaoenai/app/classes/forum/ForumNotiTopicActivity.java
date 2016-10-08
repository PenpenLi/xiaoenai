package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.xiaoenai.app.classes.forum.a.b;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.classes.forum.widget.ForumNotiTopicView;
import com.xiaoenai.app.classes.forum.widget.ForumPostLayoutView;
import com.xiaoenai.app.utils.ab;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;

public class ForumNotiTopicActivity
  extends ForumTopicActivity
{
  private int s;
  private int t;
  private ForumNotiTopicView u;
  private com.xiaoenai.app.classes.forum.presenter.g v;
  
  private void i()
  {
    this.a.setOnLastItemVisibleListener(null);
    this.a.setOnRefreshListener(new ba(this));
  }
  
  private void j()
  {
    Intent localIntent = getIntent();
    this.s = localIntent.getIntExtra("forum_topic_id", 0);
    this.t = localIntent.getIntExtra("forum_reply_id", 0);
  }
  
  private void k()
  {
    this.u = new ForumNotiTopicView(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, ab.a(100.0F));
    this.v = new com.xiaoenai.app.classes.forum.presenter.g(this.u, localLayoutParams);
    this.v.a();
    ((ListView)this.a.getRefreshableView()).addFooterView(this.u);
  }
  
  private void o()
  {
    this.v.a(new bc(this));
  }
  
  private void p()
  {
    this.b.setVisibility(0);
    this.u.setVisibility(0);
  }
  
  private void q()
  {
    this.b.setVisibility(4);
    this.u.setVisibility(4);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public void c()
  {
    new com.xiaoenai.app.net.g(new be(this, this)).e(this.s, this.t);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setTheme(2131296397);
    this.n = false;
    this.o = false;
    super.onCreate(paramBundle);
    this.b.setCardType(1);
    this.c = new ForumTopicViewPresenter(1, this, this.b.getViewHolder());
    i();
    j();
    c();
    this.i.b(false);
    k();
    o();
    q();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumNotiTopicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */