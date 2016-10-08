package com.xiaoenai.app.classes.forum.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.forum.ForumTopicActivity;

class k
  implements View.OnClickListener
{
  k(h paramh) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(h.a(this.a), ForumTopicActivity.class);
    paramView.putExtra("forum_topic_type_key", 2);
    h.a(this.a).startActivity(paramView);
    h.a(this.a).overridePendingTransition(2130968604, 2130968605);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */