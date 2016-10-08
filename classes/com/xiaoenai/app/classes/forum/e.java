package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

class e
  implements View.OnClickListener
{
  e(ForumActivity paramForumActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForumActivity.d(this.a).isShowing())
    {
      ForumActivity.d(this.a).dismiss();
      return;
    }
    ForumActivity.d(this.a).showAsDropDown(paramView);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */