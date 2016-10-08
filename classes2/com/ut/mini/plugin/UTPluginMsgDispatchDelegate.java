package com.ut.mini.plugin;

public abstract class UTPluginMsgDispatchDelegate
{
  private Object f = null;
  
  public UTPluginMsgDispatchDelegate(Object paramObject)
  {
    this.f = paramObject;
  }
  
  public Object getDispatchObject(UTPlugin paramUTPlugin)
  {
    return this.f;
  }
  
  public final Object getMsgObj()
  {
    return this.f;
  }
  
  public boolean isMatchPlugin(UTPlugin paramUTPlugin)
  {
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\plugin\UTPluginMsgDispatchDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */