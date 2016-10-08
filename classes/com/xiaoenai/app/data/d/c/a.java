package com.xiaoenai.app.data.d.c;

import android.content.Context;
import android.os.Handler;
import com.xiaoenai.app.data.d.f;
import com.xiaoenai.app.data.d.h;
import com.xiaoenai.app.data.d.j;
import com.xiaoenai.app.data.d.m;
import javax.inject.Inject;

public class a
  extends h
{
  @Inject
  public a(Context paramContext, j paramj, m paramm, f paramf, Handler paramHandler)
  {
    super(paramContext, paramj, paramm, paramf, paramHandler);
    a("v2/feedback/submit");
  }
  
  public rx.a<String> b(String paramString)
  {
    return rx.a.a(new b(this, paramString));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\data\d\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */