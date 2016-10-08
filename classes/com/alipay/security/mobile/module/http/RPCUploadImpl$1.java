package com.alipay.security.mobile.module.http;

import com.alipay.security.mobile.module.a.c;
import com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

class RPCUploadImpl$1
  implements Runnable
{
  RPCUploadImpl$1(RPCUploadImpl paramRPCUploadImpl, DeviceDataReportRequest paramDeviceDataReportRequest) {}
  
  public void run()
  {
    try
    {
      RPCUploadImpl.a(this.b.b.reportStaticData(this.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      RPCUploadImpl.a(new DeviceDataReportResult());
      RPCUploadImpl.a().success = false;
      RPCUploadImpl.a().resultCode = ("static data rpc upload error, " + c.b(localThrowable));
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\http\RPCUploadImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */