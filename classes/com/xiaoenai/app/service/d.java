package com.xiaoenai.app.service;

import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import java.util.Comparator;

class d
  implements Comparator<a>
{
  d(MessageService paramMessageService) {}
  
  public int a(a parama1, a parama2)
  {
    if (parama1.h() > parama2.h()) {
      return 1;
    }
    if (parama1.h() < parama2.h()) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\service\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */