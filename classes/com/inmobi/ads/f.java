package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.c;

final class f
{
  private c a;
  private InMobiAdRequestStatus b;
  private e c;
  
  public f(e parame, c paramc)
  {
    this.c = parame;
    this.a = paramc;
    if (this.a.c() != null) {
      e();
    }
  }
  
  private void e()
  {
    switch (f.1.a[this.a.c().a().ordinal()])
    {
    default: 
      this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
      return;
    case 1: 
      this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
      return;
    case 2: 
      this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID);
      return;
    case 3: 
      this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT);
      return;
    }
    this.b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.SERVER_ERROR);
  }
  
  public InMobiAdRequestStatus a()
  {
    return this.b;
  }
  
  public e b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.a.b();
  }
  
  public NetworkError d()
  {
    return this.a.c();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */