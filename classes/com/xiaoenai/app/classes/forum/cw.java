package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.forum.presenter.ForumTopicViewPresenter;
import com.xiaoenai.app.classes.forum.presenter.x;
import com.xiaoenai.app.model.Forum.Post;
import com.xiaoenai.app.model.Forum.f;

class cw
  implements View.OnClickListener
{
  cw(ForumTopicActivity paramForumTopicActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = f.d();
    if ((paramView != null) && (paramView.d))
    {
      this.a.c.a(this.a, ForumTopicActivity.f(this.a), ForumTopicActivity.f(this.a), ForumTopicActivity.f(this.a));
      return;
    }
    if ((this.a.m != null) && (paramView != null) && (this.a.m.i.a == paramView.a))
    {
      this.a.c.a(this.a, ForumTopicActivity.f(this.a));
      return;
    }
    x.b(this.a, null, ForumTopicActivity.a(this.a), 3);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */