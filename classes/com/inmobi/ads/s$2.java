package com.inmobi.ads;

class s$2
  implements Runnable
{
  s$2(s params) {}
  
  public void run()
  {
    if (s.a(this.a)) {
      return;
    }
    this.a.a(AdUnit.AdState.STATE_FAILED);
    this.a.m().a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\ads\s$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */