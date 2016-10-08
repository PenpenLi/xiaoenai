package com.ut.mini.plugin;

public abstract class UTPlugin
{
  public static final int MSG_ID_IN_DISPATCH_AGGREGATION_LOG_MAP = 5;
  public static final int MSG_ID_IN_DISPATCH_LOG_STRING_4_UTPERF_PLUGIN = 9;
  public static final int MSG_ID_IN_NOMATCH_ONLINE_CONF = 7;
  public static final int MSG_ID_IN_SWITCH_BACKGROUND = 2;
  public static final int MSG_ID_IN_SWITCH_FOREGROUND = 8;
  public static final int MSG_ID_OUT_AGGREGATED_LOG_MAP = 65536;
  private UTPluginContext a = null;
  
  void a(UTPluginContext paramUTPluginContext)
  {
    this.a = paramUTPluginContext;
  }
  
  public final void deliverMsgToSDK(int paramInt, Object paramObject)
  {
    UTPluginMgr.getInstance().dispatchPluginMsg(paramInt, paramObject);
  }
  
  public final UTPluginContext getPluginContext()
  {
    return this.a;
  }
  
  public void onPluginContextValueUpdate(int paramInt) {}
  
  public abstract void onPluginMsgArrivedFromSDK(int paramInt, Object paramObject);
  
  public void onRegistered() {}
  
  public void onUnRegistered() {}
  
  public abstract int[] returnRequiredMsgIds();
  
  public String[] returnRequiredOnlineConfNames()
  {
    return null;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\plugin\UTPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */