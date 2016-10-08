package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.xiaoenai.app.ui.a.h;
import com.xiaoenai.app.utils.ab;

class y
  implements View.OnClickListener
{
  y(ForumMineInfoActivity paramForumMineInfoActivity) {}
  
  public void onClick(View paramView)
  {
    ab.b(this.a);
    paramView = ForumMineInfoActivity.f(this.a).getText().toString().trim();
    if (paramView.length() == 0) {
      h.c(this.a, 2131100459, 1500L);
    }
    while (!ForumMineInfoActivity.a(this.a, paramView)) {
      return;
    }
    ForumMineInfoActivity.a(this.a, paramView, -1, false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */