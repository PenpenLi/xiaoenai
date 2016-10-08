package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.classes.common.dialog.v;

class ca
  implements View.OnClickListener
{
  ca(ForumRegisterActivity paramForumRegisterActivity) {}
  
  public void onClick(View paramView)
  {
    ForumRegisterActivity.a(this.a, -1);
    ForumRegisterActivity.e(this.a).dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */