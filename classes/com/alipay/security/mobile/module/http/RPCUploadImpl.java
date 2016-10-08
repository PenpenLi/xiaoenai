package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.a.c;
import com.alipay.security.mobile.module.http.constant.ConfigConstant;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.vkeydfp.AppListCmdService;
import com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.AppListCmdRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;
import org.json.JSONException;
import org.json.JSONObject;

public class RPCUploadImpl
  implements IUpload
{
  private static RPCUploadImpl f = null;
  private static DeviceDataReportResult g;
  BugTrackMessageService a = null;
  DeviceDataReportService b = null;
  AppListCmdService c = null;
  private Context d;
  private w e = null;
  
  private RPCUploadImpl(Context paramContext)
  {
    this.d = paramContext;
    try
    {
      aa localaa = new aa();
      localaa.a(ConfigConstant.DATA_POST_RPC_ADDRESS);
      this.e = new h(paramContext);
      this.a = ((BugTrackMessageService)this.e.a(BugTrackMessageService.class, localaa));
      this.b = ((DeviceDataReportService)this.e.a(DeviceDataReportService.class, localaa));
      this.c = ((AppListCmdService)this.e.a(AppListCmdService.class, localaa));
      return;
    }
    catch (Exception paramContext)
    {
      c.a(paramContext);
    }
  }
  
  public static RPCUploadImpl getInstance(Context paramContext)
  {
    try
    {
      if (f == null) {
        f = new RPCUploadImpl(paramContext);
      }
      paramContext = f;
      return paramContext;
    }
    finally {}
  }
  
  public AppListResult getAppList(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      AppListCmdRequest localAppListCmdRequest = new AppListCmdRequest();
      localAppListCmdRequest.os = paramString1;
      localAppListCmdRequest.apdid = paramString4;
      localAppListCmdRequest.userId = paramString2;
      localAppListCmdRequest.token = paramString3;
      paramString1 = this.c.getAppListCmd(localAppListCmdRequest);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public boolean logCollect(String paramString)
  {
    if (a.a(paramString)) {
      return false;
    }
    Object localObject;
    if (this.a != null) {
      localObject = null;
    }
    try
    {
      paramString = this.a.logCollect(a.c(paramString));
      if (!a.a(paramString)) {}
      for (;;)
      {
        try
        {
          bool = ((Boolean)new JSONObject(paramString).get("success")).booleanValue();
          return bool;
        }
        catch (JSONException paramString)
        {
          c.a(paramString);
        }
        boolean bool = false;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = (String)localObject;
      }
    }
  }
  
  public DeviceDataReportResult updateStaticData(DeviceDataReportRequest paramDeviceDataReportRequest)
  {
    if (paramDeviceDataReportRequest == null) {
      return null;
    }
    if (this.b != null) {
      try
      {
        g = null;
        new Thread(new RPCUploadImpl.1(this, paramDeviceDataReportRequest)).start();
        int i = 300000;
        while ((g == null) && (i >= 0))
        {
          Thread.sleep(50L);
          i -= 50;
        }
        return g;
      }
      catch (Exception paramDeviceDataReportRequest)
      {
        c.a(paramDeviceDataReportRequest);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alipay\security\mobile\module\http\RPCUploadImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */