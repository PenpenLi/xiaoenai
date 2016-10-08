package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.xiaoenai.app.classes.forum.a.b;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;

class bc
  implements View.OnClickListener
{
  bc(ForumNotiTopicActivity paramForumNotiTopicActivity) {}
  
  public void onClick(View paramView)
  {
    ((ListView)this.a.a.getRefreshableView()).removeFooterView(ForumNotiTopicActivity.a(this.a));
    this.a.i.a(true);
    this.a.i.b(true);
    this.a.i.b();
    this.a.i.notifyDataSetChanged();
    this.a.a(ForumNotiTopicActivity.b(this.a), -1, 20, new bd(this));
    this.a.g();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */