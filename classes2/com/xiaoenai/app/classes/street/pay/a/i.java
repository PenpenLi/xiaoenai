package com.xiaoenai.app.classes.street.pay.a;

import android.content.Context;
import android.content.Intent;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.classes.street.pay.b;

public class i
  implements o
{
  private StreetPayBaseActivity a;
  private String b = "";
  private String c = "";
  private b d = null;
  
  public i(StreetPayBaseActivity paramStreetPayBaseActivity, String paramString1, String paramString2)
  {
    this.a = paramStreetPayBaseActivity;
    this.b = paramString1;
    this.c = paramString2;
    this.d = new b(paramString2);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.d.a(paramContext, paramInt1, paramInt2, paramIntent);
  }
  
  public void a(f paramf)
  {
    paramf.a();
    this.d.a(new j(this, paramf));
    this.d.a(this.a, this.b);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */