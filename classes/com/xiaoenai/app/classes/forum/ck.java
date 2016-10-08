package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView.a;
import com.xiaoenai.app.ui.a.h;

class ck
  implements View.OnClickListener
{
  ck(ForumReplyActivity paramForumReplyActivity) {}
  
  public void onClick(View paramView)
  {
    ForumReplyActivity.b(this.a, ForumReplyActivity.c(this.a).a);
    paramView = ForumReplyActivity.c(this.a).a.getText().toString();
    if ((paramView == null) || (paramView.length() <= 0)) {
      h.c(this.a, 2131100378, 1500L);
    }
    do
    {
      return;
      if ((ForumReplyActivity.e(this.a) == 1) || (ForumReplyActivity.e(this.a) == 2))
      {
        ForumReplyActivity.a(this.a, ForumReplyActivity.e(this.a));
        return;
      }
      if (ForumReplyActivity.e(this.a) == 3)
      {
        this.a.a(ForumReplyActivity.f(this.a), ForumReplyActivity.g(this.a), paramView);
        return;
      }
    } while (ForumReplyActivity.e(this.a) != 4);
    this.a.b(ForumReplyActivity.f(this.a), ForumReplyActivity.g(this.a), paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */