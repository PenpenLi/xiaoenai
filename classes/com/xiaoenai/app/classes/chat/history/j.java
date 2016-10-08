package com.xiaoenai.app.classes.chat.history;

import android.view.View;
import android.view.View.OnClickListener;
import com.xiaoenai.app.ui.a.h;

class j
  implements View.OnClickListener
{
  j(ChatHisEditActivity paramChatHisEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = h.a(this.a);
    paramView.a(2131100622);
    paramView.show();
    if (ChatHisEditActivity.j(this.a) != null)
    {
      int i = x.a(ChatHisEditActivity.j(this.a).a(), false);
      new r(this.a, i, "next", paramView, new k(this, paramView), true).execute(new Object[0]);
    }
    ChatHisEditActivity.e(this.a).f();
    ChatHisEditActivity.e(this.a).h();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */