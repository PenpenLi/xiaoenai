package com.xiaoenai.app.classes.forum.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.classes.forum.ForumReplyActivity;
import com.xiaoenai.app.model.Forum.d;

final class ab
  implements View.OnClickListener
{
  ab(e parame, int paramInt1, d paramd, int paramInt2, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent();
    paramView.putExtra("forum_topic_id", this.b);
    if (this.c == null) {}
    for (int i = -1;; i = this.c.b)
    {
      paramView.putExtra("forum_reply_id", i);
      paramView.putExtra("forum_Reply_type", this.d);
      paramView.setClass(this.e, ForumReplyActivity.class);
      ((Activity)this.e).startActivityForResult(paramView, 259);
      ((Activity)this.e).overridePendingTransition(2130968608, 2130968609);
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */