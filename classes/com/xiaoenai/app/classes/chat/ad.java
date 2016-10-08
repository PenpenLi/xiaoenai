package com.xiaoenai.app.classes.chat;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

class ad
  implements View.OnClickListener
{
  ad(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    ChatActivity.c(this.a).setSelection(0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */