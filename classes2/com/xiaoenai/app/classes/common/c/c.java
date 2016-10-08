package com.xiaoenai.app.classes.common.c;

import android.content.Context;

public class c
{
  private d a;
  private b b = null;
  
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    this.a = new e();
    paramString1 = this.b.a(paramString1, paramString2);
    this.a.a(paramContext, paramString1);
  }
  
  public void a(Context paramContext, String paramString1, b paramb, String paramString2)
  {
    this.b = paramb;
    if ((paramString1.startsWith("xiaoenai://")) || (paramString1.startsWith("http")) || (paramString1.startsWith("https"))) {
      a(paramContext, paramString1, paramString2);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\common\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */