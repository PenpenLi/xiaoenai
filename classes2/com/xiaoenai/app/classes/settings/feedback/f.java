package com.xiaoenai.app.classes.settings.feedback;

import com.xiaoenai.app.classes.chat.messagelist.message.a.a;
import com.xiaoenai.app.classes.chat.messagelist.message.b.p;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.chat.messagelist.view.BaseItemView;
import com.xiaoenai.app.classes.chat.messagelist.view.j;
import com.xiaoenai.app.classes.chat.messagelist.view.o;

public class f
{
  public static void a(int paramInt, a parama, BaseItemView paramBaseItemView)
  {
    if ((paramInt == 1) || (paramInt == 0))
    {
      p.a((com.xiaoenai.app.classes.chat.messagelist.message.model.m)parama, (o)paramBaseItemView, null);
      if (paramInt == 1) {
        paramBaseItemView.setUserType(parama.g());
      }
    }
    while (paramInt != 2) {
      return;
    }
    com.xiaoenai.app.classes.chat.messagelist.message.b.m.a((PhotoMessage)parama, (j)paramBaseItemView, 3);
  }
  
  public static void a(int paramInt, a parama, BaseItemView paramBaseItemView, long paramLong)
  {
    if ((paramInt == 1) || (paramInt == 0))
    {
      p.a((com.xiaoenai.app.classes.chat.messagelist.message.model.m)parama, (o)paramBaseItemView, null);
      if (paramInt == 1) {
        paramBaseItemView.setUserType(parama.g());
      }
    }
    while (paramInt != 2) {
      return;
    }
    com.xiaoenai.app.classes.chat.messagelist.message.b.m.a((PhotoMessage)parama, (j)paramBaseItemView, paramLong);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\settings\feedback\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */