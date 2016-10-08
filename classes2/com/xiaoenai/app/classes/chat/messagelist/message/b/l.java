package com.xiaoenai.app.classes.chat.messagelist.message.b;

import android.content.Context;
import android.view.View.OnLongClickListener;
import com.xiaoenai.app.classes.chat.messagelist.message.model.PhotoMessage;
import com.xiaoenai.app.classes.chat.messagelist.message.model.c;
import com.xiaoenai.app.classes.chat.messagelist.view.BaseItemView;
import com.xiaoenai.app.classes.chat.messagelist.view.j;
import com.xiaoenai.app.classes.chat.messagelist.view.n;

public class l
{
  public static BaseItemView a(Context paramContext, int paramInt)
  {
    com.xiaoenai.app.classes.chat.messagelist.view.o localo = null;
    if (paramInt == 3)
    {
      localo = new com.xiaoenai.app.classes.chat.messagelist.view.o(paramContext);
      localo.setUserType(2);
    }
    do
    {
      return localo;
      if (paramInt == 0)
      {
        paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.o(paramContext);
        paramContext.setUserType(1);
        return paramContext;
      }
      if (paramInt == 4)
      {
        paramContext = new j(paramContext);
        paramContext.setUserType(2);
        return paramContext;
      }
      if (paramInt == 1)
      {
        paramContext = new j(paramContext);
        paramContext.setUserType(1);
        return paramContext;
      }
      if (paramInt == 5)
      {
        paramContext = new n(paramContext);
        paramContext.setUserType(2);
        return paramContext;
      }
      if (paramInt == 2)
      {
        paramContext = new n(paramContext);
        paramContext.setUserType(1);
        return paramContext;
      }
      if (paramInt == 7)
      {
        paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.p(paramContext);
        paramContext.setUserType(2);
        return paramContext;
      }
      if (paramInt == 6)
      {
        paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.p(paramContext);
        paramContext.setUserType(1);
        return paramContext;
      }
      if (paramInt == 9)
      {
        paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.b(paramContext);
        paramContext.setUserType(2);
        return paramContext;
      }
      if (paramInt == 8)
      {
        paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.b(paramContext);
        paramContext.setUserType(1);
        return paramContext;
      }
      if (paramInt == 11)
      {
        paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.d(paramContext);
        paramContext.setUserType(2);
        return paramContext;
      }
    } while (paramInt != 10);
    paramContext = new com.xiaoenai.app.classes.chat.messagelist.view.d(paramContext);
    paramContext.setUserType(1);
    return paramContext;
  }
  
  public static void a(int paramInt1, com.xiaoenai.app.classes.chat.messagelist.message.a.a parama, BaseItemView paramBaseItemView, int paramInt2, int paramInt3, View.OnLongClickListener paramOnLongClickListener)
  {
    switch (paramInt1)
    {
    default: 
      p.a((com.xiaoenai.app.classes.chat.messagelist.message.model.m)parama, (com.xiaoenai.app.classes.chat.messagelist.view.o)paramBaseItemView, paramOnLongClickListener);
      return;
    case 0: 
    case 3: 
      p.a((com.xiaoenai.app.classes.chat.messagelist.message.model.m)parama, (com.xiaoenai.app.classes.chat.messagelist.view.o)paramBaseItemView, paramOnLongClickListener);
      return;
    case 1: 
    case 4: 
      m.a((PhotoMessage)parama, (j)paramBaseItemView, paramInt3);
      return;
    case 2: 
      if (k.a(parama.b(), parama.c()))
      {
        d.a((com.xiaoenai.app.classes.chat.messagelist.message.model.d)parama, (n)paramBaseItemView);
        return;
      }
      if (c.a(parama.b(), parama.c()))
      {
        b.a((c)parama, (n)paramBaseItemView);
        return;
      }
      o.c((com.xiaoenai.app.classes.chat.messagelist.message.model.k)parama, (n)paramBaseItemView);
      return;
    case 5: 
      if (k.a(parama.b(), parama.c()))
      {
        d.b((com.xiaoenai.app.classes.chat.messagelist.message.model.d)parama, (n)paramBaseItemView);
        return;
      }
      if (c.a(parama.b(), parama.c()))
      {
        b.b((c)parama, (n)paramBaseItemView);
        return;
      }
      o.c((com.xiaoenai.app.classes.chat.messagelist.message.model.k)parama, (n)paramBaseItemView);
      return;
    case 6: 
    case 7: 
      s.a((com.xiaoenai.app.classes.chat.messagelist.message.model.o)parama, (com.xiaoenai.app.classes.chat.messagelist.view.p)paramBaseItemView);
      return;
    case 8: 
    case 9: 
      a.a((com.xiaoenai.app.classes.chat.messagelist.message.model.a)parama, (com.xiaoenai.app.classes.chat.messagelist.view.b)paramBaseItemView, paramInt2);
      return;
    }
    a.a((com.xiaoenai.app.classes.chat.messagelist.message.model.a)parama, (com.xiaoenai.app.classes.chat.messagelist.view.d)paramBaseItemView, paramInt2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\chat\messagelist\message\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */