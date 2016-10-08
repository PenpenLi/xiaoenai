package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.forum.presenter.h;
import com.xiaoenai.app.utils.ab;

class bj
  implements View.OnClickListener
{
  bj(ForumPostActivity paramForumPostActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForumPostActivity.a(this.a).e().length < 9)
    {
      ab.b(this.a);
      ForumPostActivity.a(this.a).a();
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */