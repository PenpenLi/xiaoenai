package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.xiaoenai.app.widget.PullToRefreshListViewWithFirstItem;

class dg
  implements View.OnClickListener
{
  dg(ForumTopicActivity paramForumTopicActivity) {}
  
  public void onClick(View paramView)
  {
    ((ListView)this.a.a.getRefreshableView()).setSelection(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */