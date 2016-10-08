package com.alibaba.wireless.security.open.umid;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IUMIDComponent
  extends IComponent
{
  public static final int ENVIRONMENT_DAILY = 1;
  public static final int ENVIRONMENT_ONLINE = 0;
  public static final int ENVIRONMENT_PRE = 2;
  
  public abstract String getSecurityToken();
  
  public abstract void initUMID(String paramString1, int paramInt, String paramString2, IUMIDInitListenerEx paramIUMIDInitListenerEx);
  
  public abstract void registerInitListener(IUMIDInitListener paramIUMIDInitListener);
  
  public abstract void setOnlineHost(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\umid\IUMIDComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */