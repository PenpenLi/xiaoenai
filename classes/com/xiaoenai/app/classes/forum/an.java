package com.xiaoenai.app.classes.forum;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xiaoenai.app.classes.forum.a.j;

class an
  implements PullToRefreshBase.e<ListView>
{
  an(ForumMineTopicActivity paramForumMineTopicActivity) {}
  
  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    ForumMineTopicActivity.a(this.a).a(true);
    ForumMineTopicActivity.a(this.a, 20, 0, true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */