package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.v;

class ai
  implements View.OnClickListener
{
  ai(ForumMineInfoActivity paramForumMineInfoActivity) {}
  
  public void onClick(View paramView)
  {
    ForumMineInfoActivity.a(this.a, -1);
    ForumMineInfoActivity.d(this.a).dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */