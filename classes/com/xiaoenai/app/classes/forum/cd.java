package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView.a;

class cd
  implements View.OnClickListener
{
  cd(ForumReplyActivity paramForumReplyActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForumReplyActivity.a(this.a))
    {
      ForumReplyActivity.b(this.a).setImageResource(2130838430);
      this.a.h();
      ForumReplyActivity.a(this.a, ForumReplyActivity.c(this.a).a);
      paramView = this.a;
      if (ForumReplyActivity.a(this.a)) {
        break label127;
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      ForumReplyActivity.a(paramView, bool);
      return;
      ForumReplyActivity.b(this.a, ForumReplyActivity.c(this.a).a);
      ForumReplyActivity.b(this.a).setImageResource(2130838424);
      ForumReplyActivity.c(this.a).a.postDelayed(new ce(this), 300L);
      break;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */