package com.xiaoenai.app.classes.forum;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class ak
  implements View.OnClickListener
{
  ak(ForumMineInfoActivity paramForumMineInfoActivity) {}
  
  public void onClick(View paramView)
  {
    ForumMineInfoActivity.f(this.a).getText().clear();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */