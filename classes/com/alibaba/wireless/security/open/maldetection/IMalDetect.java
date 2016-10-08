package com.alibaba.wireless.security.open.maldetection;

import com.alibaba.wireless.security.open.IComponent;

public abstract interface IMalDetect
  extends IComponent
{
  public abstract void registerCallBack(ICallBack paramICallBack);
  
  public abstract void unregisterCallBack(ICallBack paramICallBack);
  
  public static abstract interface ICallBack
  {
    public abstract void onDetection(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\maldetection\IMalDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */