package com.xiaoenai.app.classes.chat.messagelist;

import java.util.Comparator;

class h
  implements Comparator<com.xiaoenai.app.classes.chat.messagelist.message.a.a>
{
  h(a parama) {}
  
  public int a(com.xiaoenai.app.classes.chat.messagelist.message.a.a parama1, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama2)
  {
    if (parama1.d() > parama2.d()) {
      return 1;
    }
    if (parama1.d() < parama2.d()) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */