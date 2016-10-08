package com.xiaoenai.app.classes.street.pay.a;

import com.xiaoenai.app.classes.street.pay.StreetPayBaseActivity;
import com.xiaoenai.app.net.ae;

public class g
  implements o
{
  private StreetPayBaseActivity a = null;
  private long[] b = null;
  private String c = "";
  private int d = 0;
  
  public g(StreetPayBaseActivity paramStreetPayBaseActivity, long paramLong, String paramString, int paramInt)
  {
    this.a = paramStreetPayBaseActivity;
    this.b = new long[1];
    this.b[0] = paramLong;
    this.c = paramString;
    this.d = paramInt;
  }
  
  public g(StreetPayBaseActivity paramStreetPayBaseActivity, long[] paramArrayOfLong, String paramString, int paramInt)
  {
    this.a = paramStreetPayBaseActivity;
    this.b = paramArrayOfLong;
    this.c = paramString;
    this.d = paramInt;
  }
  
  public void a(f paramf)
  {
    new ae(new h(this, this.a, paramf)).a(this.b, this.c, this.d);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\xiaoenai\app\classes\street\pay\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */