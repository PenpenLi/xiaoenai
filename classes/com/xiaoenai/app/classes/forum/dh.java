package com.xiaoenai.app.classes.forum;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xiaoenai.app.classes.forum.a.b;

class dh
  implements PullToRefreshBase.e<ListView>
{
  dh(ForumTopicActivity paramForumTopicActivity) {}
  
  public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
  {
    ForumTopicActivity.d(this.a);
    this.a.i.a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */