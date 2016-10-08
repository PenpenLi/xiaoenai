package com.alibaba.wireless.security.open.datacollection;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IDataCollectionComponent
  extends IComponent
{
  public abstract String getNick();
  
  public abstract boolean setNick(String paramString);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\datacollection\IDataCollectionComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */