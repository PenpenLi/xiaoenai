package com.xiaoenai.app.classes.chat;

import com.xiaoenai.app.classes.chat.messagelist.message.model.o;
import com.xiaoenai.app.classes.common.dialog.b;
import com.xiaoenai.app.utils.af;
import com.xiaoenai.app.utils.af.a;

class g
  implements af.a
{
  g(BaseChatActivity paramBaseChatActivity) {}
  
  public void a(int paramInt)
  {
    if ((1 < BaseChatActivity.a(this.a).b()) && (BaseChatActivity.b(this.a) != null) && (BaseChatActivity.b(this.a).isShowing())) {
      BaseChatActivity.b(this.a).cancel();
    }
  }
  
  public void b(int paramInt)
  {
    o localo = (o)com.xiaoenai.app.utils.h.g.a().b();
    if (localo != null)
    {
      paramInt = localo.w().intValue() * 1000;
      if ((1 >= BaseChatActivity.a(this.a).b()) && (paramInt > 0))
      {
        if (localo.z() == 0L) {
          localo.d(System.currentTimeMillis());
        }
        if ((BaseChatActivity.b(this.a) == null) || (!BaseChatActivity.b(this.a).isShowing())) {
          BaseChatActivity.a(this.a, b.a(this.a, (int)(localo.z() - System.currentTimeMillis()) + paramInt + 2000));
        }
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */