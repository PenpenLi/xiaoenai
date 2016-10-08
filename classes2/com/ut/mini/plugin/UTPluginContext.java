package com.ut.mini.plugin;

import android.content.Context;

public class UTPluginContext
{
  public static final int DEBUG_LOG_SWITCH = 1;
  private boolean S = false;
  private boolean T = false;
  private Context mContext = null;
  
  public void enableRealtimeDebug()
  {
    this.T = true;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public boolean isDebugLogEnable()
  {
    return this.S;
  }
  
  public boolean isRealtimeDebugEnable()
  {
    return this.T;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setDebugLogFlag(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\plugin\UTPluginContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */