package com.xiaoenai.app.classes.forum;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xiaoenai.app.classes.common.dialog.v;

class cb
  implements View.OnClickListener
{
  cb(ForumRegisterActivity paramForumRegisterActivity) {}
  
  public void onClick(View paramView)
  {
    if (ForumRegisterActivity.f(this.a) == -1) {
      ForumRegisterActivity.a(this.a, ForumRegisterActivity.e(this.a).a());
    }
    ForumRegisterActivity.h(this.a).setText(ForumRegisterActivity.g(this.a)[ForumRegisterActivity.f(this.a)]);
    ForumRegisterActivity.e(this.a).dismiss();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */