package com.xiaoenai.app.classes.forum;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xiaoenai.app.Xiaoenai;

class ba
  implements PullToRefreshBase.e<ListView>
{
  ba(ForumNotiTopicActivity paramForumNotiTopicActivity) {}
  
  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    Xiaoenai.j().a(new bb(this), 500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */