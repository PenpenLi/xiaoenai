package com.xiaoenai.app.classes.store;

import android.content.Context;
import com.xiaoenai.app.classes.store.sticker.BaseSticker;
import com.xiaoenai.app.ui.a.g;
import com.xiaoenai.app.ui.a.h;

public class a
{
  protected static boolean a = false;
  
  public static void a(Context paramContext, a parama)
  {
    if (!a)
    {
      a = true;
      paramContext = new g(paramContext);
      paramContext.a(2131101331);
      paramContext.a(2131100898, new d(parama));
      paramContext.show();
    }
  }
  
  public static void a(Context paramContext, BaseSticker paramBaseSticker, String paramString1, String paramString2, int paramInt)
  {
    if (!a)
    {
      a = true;
      h.b(paramContext, 2131101331, 1500L, new c(paramString1, paramString2, paramInt, paramContext));
    }
  }
  
  public static void a(Context paramContext, String paramString, a parama)
  {
    if (!a)
    {
      a = true;
      g localg = new g(paramContext);
      localg.setTitle(2131101313);
      localg.setCancelable(false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
      localStringBuilder.append(paramContext.getString(2131101332));
      localg.a(localStringBuilder.toString());
      localg.a(2131100898, new b(parama));
      localg.b(17);
      localg.setCancelable(false);
      localg.show();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\store\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */