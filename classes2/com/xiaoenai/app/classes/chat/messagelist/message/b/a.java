package com.xiaoenai.app.classes.chat.messagelist.message.b;

import com.xiaoenai.app.classes.chat.messagelist.view.BaseItemView;
import com.xiaoenai.app.classes.chat.messagelist.view.b;
import com.xiaoenai.app.classes.chat.messagelist.view.d;

public class a
{
  public static void a(com.xiaoenai.app.classes.chat.messagelist.message.model.a parama, BaseItemView paramBaseItemView, int paramInt)
  {
    paramBaseItemView.setStatus(parama.f().intValue());
    if (parama.r().equalsIgnoreCase("gif"))
    {
      ((d)paramBaseItemView).a(parama.s(), paramInt, parama.g());
      return;
    }
    ((b)paramBaseItemView).a(parama.s(), parama.f().intValue());
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */