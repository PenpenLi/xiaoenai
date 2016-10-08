package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;

class ac
  implements View.OnClickListener
{
  ac(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ChatActivity.b(this.a) != null) && (ChatActivity.b(this.a).isAdded()))
    {
      this.a.q();
      return;
    }
    this.a.p();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */