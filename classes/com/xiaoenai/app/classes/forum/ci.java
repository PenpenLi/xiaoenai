package com.xiaoenai.app.classes.forum;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class ci
  implements View.OnTouchListener
{
  ci(ForumReplyActivity paramForumReplyActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.h();
    ForumReplyActivity.a(this.a, false);
    ForumReplyActivity.b(this.a).setImageResource(2130838430);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */