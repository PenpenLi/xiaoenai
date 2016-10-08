package com.xiaoenai.app.classes.chat;

import android.widget.ListView;
import com.xiaoenai.app.Xiaoenai;
import com.xiaoenai.app.classes.chat.messagelist.a;
import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.utils.as;

class z
  implements Runnable
{
  z(ChatActivity paramChatActivity, o paramo) {}
  
  public void run()
  {
    this.a.c(6);
    this.b.i();
    o localo = a.a().a(this.a);
    if ((localo != null) && (ChatActivity.f(this.b)))
    {
      this.b.a(localo);
      if (ChatActivity.c(this.b).getLastVisiblePosition() <= localo.y()) {
        ChatActivity.c(this.b).setSelection(localo.y());
      }
      return;
    }
    this.b.d();
    ChatActivity.b(this.b, false);
    this.b.k();
    as.a(Xiaoenai.j(), false);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */