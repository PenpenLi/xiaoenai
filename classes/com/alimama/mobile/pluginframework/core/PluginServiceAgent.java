package com.alimama.mobile.pluginframework.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.alimama.mobile.sdk.config.system.bridge.CMPluginBridge;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public class PluginServiceAgent
{
  public ProviderShell provider;
  
  public PluginServiceAgent(ProviderShell paramProviderShell)
  {
    this.provider = paramProviderShell;
  }
  
  public static class ProviderShell
  {
    Object provider;
    
    public ProviderShell(Object paramObject)
    {
      this.provider = paramObject;
    }
    
    public IBinder onBind(Intent paramIntent)
    {
      try
      {
        paramIntent = (IBinder)CMPluginBridge.DownloadProvider_onBind.invoke(this.provider, new Object[] { paramIntent });
        return paramIntent;
      }
      catch (Exception paramIntent)
      {
        Log.e("PluginServiceContext", "invoke onBind error", paramIntent);
      }
      return null;
    }
    
    public void onCreate()
    {
      try
      {
        CMPluginBridge.DownloadProvider_onCreate.invoke(this.provider, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        Log.e("PluginServiceContext", "invoke onCreate error", localException);
      }
    }
    
    public void onDestroy()
    {
      try
      {
        CMPluginBridge.DownloadProvider_onDestroy.invoke(this.provider, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        Log.e("PluginServiceContext", "invoke onDestroy error", localException);
      }
    }
    
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
    {
      try
      {
        paramInt1 = ((Integer)CMPluginBridge.DownloadProvider_onStartCommand.invoke(this.provider, new Object[] { paramIntent, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) })).intValue();
        return paramInt1;
      }
      catch (Exception paramIntent)
      {
        Log.e("PluginServiceContext", "invoke onStartCommand error", paramIntent);
      }
      return 0;
    }
    
    public void setHostService(Service paramService)
    {
      try
      {
        CMPluginBridge.DownloadProvider_setHostService.invoke(this.provider, new Object[] { paramService });
        return;
      }
      catch (Exception paramService)
      {
        Log.e("PluginServiceContext", "invoke onDestroy error", paramService);
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\pluginframework\core\PluginServiceAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */