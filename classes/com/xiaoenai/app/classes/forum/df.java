package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.h;

class df
  implements View.OnClickListener
{
  df(ForumTopicActivity paramForumTopicActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.m != null)
    {
      ForumTopicActivity.c(this.a);
      return;
    }
    h.c(this.a, 2131100229, 1500L);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */