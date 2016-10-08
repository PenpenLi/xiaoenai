package com.baidu.location;

import android.os.Handler;
import android.os.Message;

class ah
  extends ag
  implements ax, n
{
  private static ah eo = null;
  final int eA = 2000;
  private String eB = null;
  final Handler eg = new ag.b(this);
  final int el = 1000;
  public ag.a em = null;
  private volatile boolean en = false;
  private int ep;
  private long eq = 0L;
  private as er = null;
  private long es = 0L;
  private t.a et = null;
  private ar.b eu = null;
  private boolean ev = false;
  private boolean ew = true;
  private boolean ex = true;
  private BDLocation ey = null;
  private BDLocation ez = null;
  
  private void aB()
  {
    if (this.ex) {
      aE();
    }
    while (this.en) {
      return;
    }
    if (ar.bW().bX())
    {
      this.ev = true;
      this.eg.postDelayed(new a(null), 2000L);
      return;
    }
    aE();
  }
  
  private void aD()
  {
    if (this.ey != null) {
      q.x().E();
    }
  }
  
  private void aE()
  {
    if (this.en) {
      return;
    }
    if ((System.currentTimeMillis() - this.eq < 1000L) && (this.ey != null))
    {
      k.p().jdMethod_do(this.ey);
      av();
      return;
    }
    c.jdMethod_if("baidu_location_service", "start network locating ...");
    this.en = true;
    this.ew = jdMethod_if(this.et);
    if ((!jdMethod_if(this.eu)) && (!this.ew) && (this.ey != null) && (this.ep == 0))
    {
      if ((this.ez != null) && (System.currentTimeMillis() - this.es > 30000L))
      {
        this.ey = this.ez;
        this.ez = null;
      }
      k.p().jdMethod_do(this.ey);
      av();
      return;
    }
    String str = e(null);
    if (str == null)
    {
      localObject = new BDLocation();
      ((BDLocation)localObject).setLocType(62);
      k.p().jdMethod_do((BDLocation)localObject);
      av();
      return;
    }
    Object localObject = str;
    if (this.eB != null)
    {
      localObject = str + this.eB;
      this.eB = null;
    }
    this.em.d((String)localObject);
    this.et = this.eh;
    this.eu = this.ek;
    if (this.ex == true) {
      this.ex = false;
    }
    this.eq = System.currentTimeMillis();
  }
  
  private boolean au()
  {
    this.ek = ar.bW().b1();
    return !this.er.jdMethod_do(this.ek);
  }
  
  private void av()
  {
    this.en = false;
    aD();
  }
  
  public static ah ay()
  {
    if (eo == null) {
      eo = new ah();
    }
    return eo;
  }
  
  private void jdMethod_char(Message paramMessage)
  {
    String str = x.a4().aP();
    BDLocation localBDLocation = new BDLocation(str);
    k.p().jdMethod_if(localBDLocation, paramMessage);
    ak.a().a(null);
    ak.a().jdMethod_if(str);
  }
  
  private void jdMethod_else(Message paramMessage)
  {
    c.jdMethod_if("baidu_location_service", "on request location ...");
    if (ae.bp().bq()) {}
    do
    {
      return;
      int i = k.p().jdMethod_for(paramMessage);
      this.ep = paramMessage.arg1;
      switch (i)
      {
      default: 
        throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[] { Integer.valueOf(i) }));
      }
    } while (!x.a4().aR());
    jdMethod_char(paramMessage);
    return;
    jdMethod_goto(paramMessage);
    return;
    aB();
  }
  
  private void jdMethod_goto(Message paramMessage)
  {
    if (x.a4().aR())
    {
      jdMethod_char(paramMessage);
      return;
    }
    aB();
  }
  
  private boolean jdMethod_if(ar.b paramb)
  {
    boolean bool2 = true;
    this.ek = ar.bW().b1();
    boolean bool1;
    if (paramb == this.ek) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.ek == null);
        bool1 = bool2;
      } while (paramb == null);
      bool1 = bool2;
    } while (!paramb.a(this.ek));
    return false;
  }
  
  private boolean jdMethod_if(t.a parama)
  {
    boolean bool2 = true;
    this.eh = t.an().ak();
    boolean bool1;
    if (this.eh == parama) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.eh == null);
        bool1 = bool2;
      } while (parama == null);
      bool1 = bool2;
    } while (!parama.a(this.eh));
    return false;
  }
  
  public boolean aA()
  {
    return this.ew;
  }
  
  void aC()
  {
    this.ex = true;
    this.en = false;
  }
  
  void at()
  {
    c.jdMethod_if("baidu_location_service", "on network exception");
    if ((this.ew) || (this.ey == null)) {
      k.p().jdMethod_if(ay.cd().jdMethod_case(false), 21);
    }
    for (;;)
    {
      this.ey = null;
      this.ez = null;
      this.er.b6();
      av();
      return;
      k.p().jdMethod_if(this.ey, 21);
    }
  }
  
  public void aw()
  {
    if (this.ev)
    {
      aE();
      this.ev = false;
    }
  }
  
  void ax()
  {
    this.en = false;
    az();
  }
  
  void az()
  {
    this.ey = null;
    this.er.b6();
  }
  
  void jdMethod_byte(Message paramMessage)
  {
    c.jdMethod_if("baidu_location_service", "on network success");
    paramMessage = (BDLocation)paramMessage.obj;
    BDLocation localBDLocation = new BDLocation(paramMessage);
    this.ez = null;
    int j = 0;
    int i = j;
    if (paramMessage.getLocType() == 161)
    {
      i = j;
      if ("cl".equals(paramMessage.getNetworkLocationType()))
      {
        i = j;
        if (this.ey != null)
        {
          i = j;
          if (this.ey.getLocType() == 161)
          {
            i = j;
            if ("wf".equals(this.ey.getNetworkLocationType()))
            {
              i = j;
              if (System.currentTimeMillis() - this.es < 30000L)
              {
                i = 1;
                this.ez = paramMessage;
              }
            }
          }
        }
      }
    }
    if (i != 0)
    {
      k.p().jdMethod_if(this.ey, 21);
      if (!c.jdMethod_if(paramMessage)) {
        break label252;
      }
      if (i == 0) {
        this.ey = paramMessage;
      }
      label164:
      i = c.jdMethod_do(ee, "ssid\":\"", "\"");
      if ((i == Integer.MIN_VALUE) || (this.eu == null)) {
        break label267;
      }
    }
    label252:
    label267:
    for (this.eB = this.eu.jdMethod_if(i);; this.eB = null)
    {
      ay.cd().jdMethod_if(ee, this.et, this.eu, localBDLocation);
      j.cZ().jdMethod_byte(localBDLocation);
      av();
      return;
      k.p().jdMethod_if(paramMessage, 21);
      this.es = System.currentTimeMillis();
      break;
      this.ey = null;
      this.er.b6();
      break label164;
    }
  }
  
  public void jdMethod_case(Message paramMessage)
  {
    jdMethod_else(paramMessage);
  }
  
  public void jdMethod_for(BDLocation paramBDLocation)
  {
    az();
    this.ey = paramBDLocation;
  }
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      if (ah.jdMethod_do(ah.this) == true)
      {
        ah.jdMethod_if(ah.this, false);
        ah.jdMethod_if(ah.this);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\baidu\location\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */