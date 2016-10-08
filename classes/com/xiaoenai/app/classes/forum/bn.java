package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.xiaoenai.app.classes.forum.presenter.h;
import com.xiaoenai.app.classes.forum.widget.ForumScrollEditTextView.a;

class bn
  implements View.OnClickListener
{
  bn(ForumPostActivity paramForumPostActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = ForumPostActivity.a(this.a);
    if (!ForumPostActivity.a(this.a).f()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.a(bool);
      ForumPostActivity.g(this.a).d.setSelected(ForumPostActivity.a(this.a).f());
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */