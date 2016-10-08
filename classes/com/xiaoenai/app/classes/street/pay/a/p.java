package com.xiaoenai.app.classes.street.pay.a;

import com.xiaoenai.app.classes.street.model.BuyInfo;
import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.net.ae;

public class p
  implements o
{
  private int a = 0;
  private int b = 0;
  private BuyInfo[] c = null;
  private StreetPayBaseActivity d;
  
  public p(StreetPayBaseActivity paramStreetPayBaseActivity, int paramInt1, int paramInt2, BuyInfo[] paramArrayOfBuyInfo)
  {
    this.d = paramStreetPayBaseActivity;
    this.c = paramArrayOfBuyInfo;
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(f paramf)
  {
    new ae(new q(this, this.d, paramf)).a(this.a, this.b, this.c);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */