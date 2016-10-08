package com.xiaoenai.app.classes.chat.history;

import android.view.View;
import android.view.View.OnClickListener;

class h
  implements View.OnClickListener
{
  h(ChatHisEditActivity paramChatHisEditActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = com.xiaoenai.app.ui.a.h.a(this.a);
    paramView.a(2131100622);
    paramView.show();
    if (ChatHisEditActivity.j(this.a) != null)
    {
      int i = x.a(ChatHisEditActivity.j(this.a).a(), true);
      new r(this.a, i, "prev", paramView, new i(this), true).execute(new Object[0]);
    }
    ChatHisEditActivity.e(this.a).f();
    ChatHisEditActivity.e(this.a).h();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\history\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */