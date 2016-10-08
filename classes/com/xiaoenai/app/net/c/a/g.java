package com.xiaoenai.app.net.c.a;

import android.app.Activity;
import android.content.Context;

public class g
{
  public void a(Activity paramActivity, String paramString)
  {
    com.xiaoenai.app.ui.a.g localg = new com.xiaoenai.app.ui.a.g(paramActivity);
    localg.a(paramString);
    localg.setCancelable(false);
    localg.a(2131100898, new i(this, paramActivity));
    localg.show();
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    com.xiaoenai.app.ui.a.h.c(paramContext, paramString2, 1500L).show();
  }
  
  public void b(Context paramContext, String paramString1, String paramString2)
  {
    com.xiaoenai.app.ui.a.h.a(paramContext, paramString2, 1500L).show();
  }
  
  public void c(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new com.xiaoenai.app.ui.a.g(paramContext);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(2131100898, new h(this));
    paramContext.show();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\net\c\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */