package com.xiaoenai.app.classes.forum;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

class bp
  implements View.OnTouchListener
{
  bp(ForumPostActivity paramForumPostActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ForumPostActivity.b(this.a, false);
    ForumPostActivity.h(this.a);
    ForumPostActivity.a(this.a, 0);
    ForumPostActivity.c(this.a).setImageResource(2130838430);
    return false;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */