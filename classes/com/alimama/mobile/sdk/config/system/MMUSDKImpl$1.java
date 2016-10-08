package com.alimama.mobile.sdk.config.system;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import com.alimama.mobile.sdk.MMUSDK.PLUGIN_LOAD_STATUS;
import com.alimama.mobile.sdk.config.ExchangeConstants;
import com.alimama.mobile.sdk.config.MmuController.InitAsyncComplete;
import com.alimama.mobile.sdk.config.system.bridge.CMPluginBridge;
import com.alimama.mobile.sdk.config.system.bridge.GodModeHacks;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

class MMUSDKImpl$1
  extends AsyncTask<String, String, Boolean>
{
  MMUSDKImpl$1(MMUSDKImpl paramMMUSDKImpl, Application paramApplication) {}
  
  protected Boolean doInBackground(String... paramVarArgs)
  {
    MMUSDKImpl.access$000(this.this$0, this.val$application, true);
    return Boolean.valueOf(true);
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue() == Boolean.TRUE.booleanValue()) {}
    try
    {
      Object localObject = CMPluginBridge.AlimmContext_getAliContext.invoke(null, new Object[0]);
      CMPluginBridge.AlimmContext_init.invoke(localObject, new Object[] { this.val$application });
      GodModeHacks.inject(this.val$application.getBaseContext());
      MMUSDKImpl.access$102(this.this$0, MMUSDK.PLUGIN_LOAD_STATUS.COMPLETED);
      CMPluginBridge.accountServiceInit(this.val$application.getApplicationContext());
      if (MMUSDKImpl.access$200(this.this$0) != null) {
        MMUSDKImpl.access$200(this.this$0).onComplete(paramBoolean.booleanValue());
      }
      super.onPostExecute(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w(ExchangeConstants.LOG_TAG, "无法完成初始化，alimmContext未初始化成功。");
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    MMUSDKImpl.access$302(this.this$0, this.val$application);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\MMUSDKImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */