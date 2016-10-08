package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public abstract interface IUpload
{
  public abstract AppListResult getAppList(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract boolean logCollect(String paramString);
  
  public abstract DeviceDataReportResult updateStaticData(DeviceDataReportRequest paramDeviceDataReportRequest);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\http\IUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */