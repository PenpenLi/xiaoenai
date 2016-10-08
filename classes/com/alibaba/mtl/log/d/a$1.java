package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

class a$1
  extends b
{
  a$1(a parama) {}
  
  public void I()
  {
    if (a.a(this.b))
    {
      com.alibaba.mtl.log.b.a.C();
      a.a(this.b);
      i.a("UploadTask", new Object[] { "mPeriod:", Long.valueOf(this.b.z) });
      if (r.a().b(2)) {
        r.a().f(2);
      }
      if (!b.isRunning()) {
        r.a().a(2, this, this.b.z);
      }
    }
  }
  
  public void J()
  {
    this.b.H();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\mtl\log\d\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */