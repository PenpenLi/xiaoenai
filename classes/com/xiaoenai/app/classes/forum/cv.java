package com.xiaoenai.app.classes.forum;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class cv
  implements View.OnClickListener
{
  cv(ForumTopicActivity paramForumTopicActivity) {}
  
  public void onClick(View paramView)
  {
    if (dm.a(this.a, 1))
    {
      paramView = new Intent();
      paramView.setClass(this.a, ForumReplyActivity.class);
      paramView.putExtra("forum_topic_id", ForumTopicActivity.a(this.a));
      this.a.startActivityForResult(paramView, 257);
      this.a.overridePendingTransition(2130968608, 2130968609);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */