package com.xiaoenai.app.classes.street.pay.a;

import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.net.ae;

public class d
  implements o
{
  private StreetPayBaseActivity a;
  private int b = 0;
  
  public d(StreetPayBaseActivity paramStreetPayBaseActivity, int paramInt)
  {
    this.a = paramStreetPayBaseActivity;
    this.b = paramInt;
  }
  
  public void a(f paramf)
  {
    paramf = new ae(new e(this, this.a, paramf));
    paramf.d(this.b);
    paramf.a(true);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */