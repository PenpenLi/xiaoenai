package com.alipay.tscenter.biz.rpc.vkeydfp;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public abstract interface DeviceDataReportService
{
  @OperationType("alipay.security.vkeyDFP.appList.get")
  public abstract AppListResult getAppList(String paramString);
  
  @OperationType("alipay.security.vkeyDFP.staticData.report")
  public abstract DeviceDataReportResult reportStaticData(DeviceDataReportRequest paramDeviceDataReportRequest);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\tscenter\biz\rpc\vkeydfp\DeviceDataReportService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */