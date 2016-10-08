package com.alipay.apmobilesecuritysdk.a;

import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public final class g
{
  private boolean a = false;
  private String b;
  private String c;
  private String d;
  private String e;
  private boolean f = true;
  private String g;
  
  public g(DeviceDataReportResult paramDeviceDataReportResult)
  {
    if (paramDeviceDataReportResult == null) {
      return;
    }
    this.e = paramDeviceDataReportResult.resultCode;
    this.a = paramDeviceDataReportResult.success;
    this.b = paramDeviceDataReportResult.apdid;
    this.c = paramDeviceDataReportResult.token;
    this.d = paramDeviceDataReportResult.currentTime;
    this.g = paramDeviceDataReportResult.appListVer;
    if ("1".equals(paramDeviceDataReportResult.bugTrackSwitch)) {}
    for (;;)
    {
      this.f = bool;
      return;
      bool = false;
    }
  }
  
  public final boolean a()
  {
    if (!a.a(this.b)) {
      return this.a;
    }
    return false;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final String c()
  {
    return this.c;
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public final String e()
  {
    return this.e;
  }
  
  public final boolean f()
  {
    return this.f;
  }
  
  public final String g()
  {
    return this.g;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\apmobilesecuritysdk\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */