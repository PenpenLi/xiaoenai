package com.baidu.location;

import android.os.Message;

class u
  extends ag
  implements ax, n
{
  private static u eD = null;
  static final int eE = 3000;
  private long eF = 0L;
  private BDLocation eG = null;
  public ag.a eH = null;
  
  private void aF()
  {
    q.x().E();
  }
  
  public static u aG()
  {
    if (eD == null) {
      eD = new u();
    }
    return eD;
  }
  
  private void jdMethod_void(Message paramMessage)
  {
    if ((System.currentTimeMillis() - this.eF < 3000L) && (this.eG != null))
    {
      k.p().jdMethod_if(this.eG, 26);
      return;
    }
    paramMessage = e(k.p().jdMethod_if(paramMessage));
    this.eH.d(paramMessage);
    this.eF = System.currentTimeMillis();
  }
  
  void at()
  {
    c.jdMethod_if("baidu_location_service", "on network exception");
    this.eG = null;
    k.p().jdMethod_if(ay.cd().jdMethod_case(false), 26);
    aF();
  }
  
  void jdMethod_byte(Message paramMessage)
  {
    c.jdMethod_if("baidu_location_service", "on network success");
    paramMessage = (BDLocation)paramMessage.obj;
    k.p().jdMethod_if(paramMessage, 26);
    if (c.jdMethod_if(paramMessage)) {}
    for (this.eG = paramMessage;; this.eG = null)
    {
      aF();
      return;
    }
  }
  
  public void jdMethod_long(Message paramMessage)
  {
    jdMethod_void(paramMessage);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */