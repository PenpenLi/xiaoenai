package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.os.Bundle;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xiaoenai.app.classes.common.TitleBarActivity;
import com.xiaoenai.app.classes.forum.a.j;
import com.xiaoenai.app.model.UserConfig;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.widget.TitleBarView;

public class ForumMineTopicActivity
  extends TitleBarActivity
{
  private int a = 1;
  private PullToRefreshListView b;
  private j c;
  private boolean i = false;
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.a == 1) {
      c(paramInt1, paramInt2, paramBoolean);
    }
    while (this.a != 2) {
      return;
    }
    b(paramInt1, paramInt2, paramBoolean);
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.i) {
      return;
    }
    new g(new ap(this, this, paramBoolean)).b(paramInt1, paramInt2);
  }
  
  private void c()
  {
    this.b = ((PullToRefreshListView)findViewById(2131559325));
    this.b.setAdapter(this.c);
  }
  
  private void c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.i) {
      return;
    }
    new g(new au(this, this, paramBoolean)).c(paramInt1, paramInt2);
  }
  
  private void d()
  {
    this.b.setOnRefreshListener(new an(this));
    this.b.setOnScrollListener(new ao(this));
    this.b.setOnItemClickListener(this.c);
  }
  
  public int a()
  {
    return 2130903200;
  }
  
  protected void b()
  {
    super.b();
    if (this.a == 1) {
      this.g.setTitle(2131100501);
    }
    while (this.a != 2) {
      return;
    }
    this.g.setTitle(2131100500);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2)) {
      this.b.l();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.d(UserConfig.getBoolean("forum_night_theme", Boolean.valueOf(false)).booleanValue());
    this.a = getIntent().getIntExtra("forum_mine_topic_key", 1);
    super.onCreate(paramBundle);
    this.c = new j(this, null);
    c();
    d();
    this.b.l();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ForumMineTopicActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */