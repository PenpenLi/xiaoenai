package com.xiaoenai.app.classes.chat;

import android.widget.ListView;

class ai
  implements Runnable
{
  ai(ChatActivity paramChatActivity) {}
  
  public void run()
  {
    ChatActivity.c(this.a).scrollTo(0, 0);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */