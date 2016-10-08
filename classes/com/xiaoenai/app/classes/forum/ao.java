package com.xiaoenai.app.classes.forum;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.xiaoenai.app.classes.forum.a.j;

class ao
  implements AbsListView.OnScrollListener
{
  ao(ForumMineTopicActivity paramForumMineTopicActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView.getLastVisiblePosition() == ForumMineTopicActivity.a(this.a).getCount()) && (ForumMineTopicActivity.a(this.a).a())) {
      ForumMineTopicActivity.a(this.a, 20, ForumMineTopicActivity.a(this.a).getCount(), false);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */