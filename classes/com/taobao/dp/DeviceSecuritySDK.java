package com.taobao.dp;

import android.content.Context;
import com.taobao.dp.client.IInitResultListener;
import com.taobao.dp.client.a;
import com.taobao.dp.client.b;
import com.taobao.dp.http.IUrlRequestService;
import com.taobao.wireless.security.adapter.common.SPUtility2;
import com.taobao.wireless.security.adapter.common.c;

public final class DeviceSecuritySDK
  extends b
{
  public static final int ENVIRONMENT_DAILY = 1;
  public static final int ENVIRONMENT_ONLINE = 0;
  public static final int ENVIRONMENT_PRE = 2;
  private static DeviceSecuritySDK instance = null;
  
  private DeviceSecuritySDK(Context paramContext)
  {
    super(paramContext);
  }
  
  public static DeviceSecuritySDK getInstance(Context paramContext)
  {
    if (instance == null) {}
    try
    {
      if (instance == null)
      {
        SPUtility2.init(paramContext);
        c.a(paramContext);
        instance = new DeviceSecuritySDK(paramContext);
      }
      return instance;
    }
    finally {}
  }
  
  public final String getSecurityToken()
  {
    return super.getSecurityToken();
  }
  
  public final String getSecurityTokenEx()
  {
    return super.getSecurityTokenEx();
  }
  
  public final String getVersion()
  {
    return "1.5.1";
  }
  
  public final void initAsync(String paramString, int paramInt, IUrlRequestService paramIUrlRequestService, IInitResultListener paramIInitResultListener)
  {
    initAsync(paramString, "", paramInt, paramIUrlRequestService, paramIInitResultListener);
  }
  
  public final void initAsync(String paramString1, String paramString2, int paramInt, IUrlRequestService paramIUrlRequestService, IInitResultListener paramIInitResultListener)
  {
    super.init(getEnvironment(paramInt), paramIUrlRequestService, paramIInitResultListener, false);
  }
  
  public final int initSync(String paramString, int paramInt, IUrlRequestService paramIUrlRequestService)
  {
    return initSync(paramString, "", paramInt, paramIUrlRequestService);
  }
  
  public final int initSync(String paramString1, String paramString2, int paramInt, IUrlRequestService paramIUrlRequestService)
  {
    return super.init(getEnvironment(paramInt), paramIUrlRequestService, null, true);
  }
  
  public final void setEnvironment(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      super.setEnvironment(a.a);
      return;
    case 2: 
      super.setEnvironment(a.b);
      return;
    }
    super.setEnvironment(a.c);
  }
  
  public final void setOnlineHost(OnlineHost paramOnlineHost)
  {
    if (paramOnlineHost != null) {}
    try
    {
      if ((paramOnlineHost.getHost() == null) || (paramOnlineHost.getHost().length() == 0)) {
        throw new IllegalArgumentException("host is null");
      }
    }
    finally
    {
      throw paramOnlineHost;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\taobao\dp\DeviceSecuritySDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */