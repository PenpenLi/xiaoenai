package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.v;

class aj
  implements View.OnClickListener
{
  aj(ForumMineInfoActivity paramForumMineInfoActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForumMineInfoActivity.e(this.a) == -1) {
      ForumMineInfoActivity.a(this.a, ForumMineInfoActivity.d(this.a).a());
    }
    ForumMineInfoActivity.a(this.a, null, ForumMineInfoActivity.e(this.a), true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */