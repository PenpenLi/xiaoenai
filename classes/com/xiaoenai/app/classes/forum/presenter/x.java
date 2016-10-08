package com.xiaoenai.app.classes.forum.presenter;

import android.content.Context;
import com.xiaoenai.app.classes.common.dialog.e;
import com.xiaoenai.app.model.Forum.d;
import com.xiaoenai.app.net.g;
import com.xiaoenai.app.utils.as;

public class x
{
  public static String a(d paramd, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramd == null) {
      localStringBuilder.append(as.a(2131100485));
    }
    for (;;)
    {
      localStringBuilder.append("，");
      localStringBuilder.append(as.a(2131100456));
      localStringBuilder.append("：");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      localStringBuilder.append(as.a(2131100484));
      localStringBuilder.append(paramd.e);
      localStringBuilder.append(as.a(2131100386));
    }
  }
  
  public static void a(Context paramContext, d paramd, int paramInt1, int paramInt2)
  {
    e locale = new e(paramContext);
    locale.a(paramContext.getString(2131100484) + paramContext.getString(2131100456));
    locale.a(2131100486, 1, new y(locale, paramContext, paramd, paramInt1, paramInt2));
    locale.a(2131100487, 1, new z(locale, paramContext, paramd, paramInt1, paramInt2));
    locale.a(2131100488, 1, new aa(locale, paramContext, paramd, paramInt1, paramInt2));
    locale.a(2131100489, 1, new ab(locale, paramInt1, paramd, paramInt2, paramContext));
    locale.show();
  }
  
  public static void a(Context paramContext, d paramd, int paramInt, String paramString)
  {
    paramContext = new g(new ad(paramContext, paramContext));
    if (paramd == null) {}
    for (int i = -1;; i = paramd.b)
    {
      paramContext.c(paramInt, i, a(paramd, paramString));
      return;
    }
  }
  
  public static void a(Context paramContext, d paramd, int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt2 == 4)
    {
      b(paramContext, paramd, paramInt1, paramString);
      return;
    }
    a(paramContext, paramd, paramInt1, paramString);
  }
  
  public static void b(Context paramContext, d paramd, int paramInt1, int paramInt2)
  {
    e locale = new e(paramContext);
    locale.a(2131100485, 1, new ac(paramContext, paramd, paramInt1, paramInt2, locale));
    locale.show();
  }
  
  public static void b(Context paramContext, d paramd, int paramInt, String paramString)
  {
    paramContext = new g(new ae(paramContext, paramContext));
    if (paramd == null) {}
    for (int i = -1;; i = paramd.b)
    {
      paramContext.b(paramInt, i, a(paramd, paramString));
      return;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\forum\presenter\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */