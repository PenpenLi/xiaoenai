package com.alimama.mobile.sdk.config.system;

final class PluginStatistics$1
  implements Runnable
{
  PluginStatistics$1(String paramString) {}
  
  public void run()
  {
    AppUtil.httpGet(this.val$url);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\PluginStatistics$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */