package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.xiaoenai.app.classes.forum.presenter.h;

class bl
  implements View.OnClickListener
{
  bl(ForumPostActivity paramForumPostActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForumPostActivity.b(this.a))
    {
      ForumPostActivity.c(this.a).setImageResource(2130838430);
      ForumPostActivity.a(this.a).c();
      if (ForumPostActivity.d(this.a))
      {
        ForumPostActivity.a(this.a, ForumPostActivity.e(this.a));
        paramView = this.a;
        if (ForumPostActivity.b(this.a)) {
          break label162;
        }
      }
    }
    label162:
    for (boolean bool = true;; bool = false)
    {
      ForumPostActivity.a(paramView, bool);
      return;
      ForumPostActivity.a(this.a, ForumPostActivity.f(this.a));
      break;
      ForumPostActivity.c(this.a).setImageResource(2130838424);
      ForumPostActivity.b(this.a, ForumPostActivity.e(this.a));
      ForumPostActivity.b(this.a, ForumPostActivity.f(this.a));
      ForumPostActivity.c(this.a).postDelayed(new bm(this), 300L);
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */