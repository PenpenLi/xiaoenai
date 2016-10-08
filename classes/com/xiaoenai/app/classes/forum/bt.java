package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.classes.forum.presenter.h;

class bt
  implements View.OnClickListener
{
  bt(ForumPostActivity paramForumPostActivity) {}
  
  public void onClick(View paramView)
  {
    ForumPostActivity.b(this.a, ForumPostActivity.e(this.a));
    ForumPostActivity.b(this.a, ForumPostActivity.f(this.a));
    ForumPostActivity.a(this.a).a(ForumPostActivity.e(this.a).getText().toString(), ForumPostActivity.f(this.a).getText().toString(), ForumPostActivity.a(this.a).e());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */