package com.alibaba.wireless.security.open.staticdatastore;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IStaticDataStoreComponent
  extends IComponent
{
  public abstract String getAppKeyByIndex(int paramInt, String paramString);
  
  public abstract String getExtraData(String paramString1, String paramString2);
  
  public abstract int getKeyType(String paramString1, String paramString2);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\staticdatastore\IStaticDataStoreComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */