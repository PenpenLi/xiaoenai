package com.ut.mini.internal;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;

public class UTTeamWork
{
  private static UTTeamWork a = null;
  
  public static UTTeamWork getInstance()
  {
    try
    {
      if (a == null) {
        a = new UTTeamWork();
      }
      UTTeamWork localUTTeamWork = a;
      return localUTTeamWork;
    }
    finally {}
  }
  
  public void closeAuto1010Track()
  {
    com.alibaba.mtl.log.c.a().p();
  }
  
  public void disableNetworkStatusChecker() {}
  
  public void dispatchLocalHits() {}
  
  public String getUtsid()
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        if (a.a() != null)
        {
          String str1 = a.a().getAppkey();
          String str2 = UTDevice.getUtdid(b.a().getContext());
          long l = Long.valueOf(a.G).longValue();
          Object localObject2 = localObject3;
          if (!TextUtils.isEmpty(str1))
          {
            localObject2 = localObject3;
            if (!TextUtils.isEmpty(str2)) {
              localObject2 = str2 + "_" + str1 + "_" + l;
            }
          }
          return (String)localObject2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      Object localObject1 = null;
    }
  }
  
  public void initialized() {}
  
  public void saveCacheDataToLocal()
  {
    com.alibaba.mtl.log.c.c.a().E();
  }
  
  public void setToAliyunOsPlatform()
  {
    UTMIVariables.getInstance().setToAliyunOSPlatform();
  }
  
  public void turnOffRealTimeDebug() {}
  
  public void turnOnRealTimeDebug(Map<String, String> paramMap)
  {
    AppMonitor.turnOnRealTimeDebug(paramMap);
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\internal\UTTeamWork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */