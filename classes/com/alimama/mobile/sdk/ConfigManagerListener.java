package com.alimama.mobile.sdk;

import java.util.Map;

public abstract interface ConfigManagerListener
{
  public abstract void onError(Exception paramException);
  
  public abstract void onProcessConfigSuccess(Map<String, Object> paramMap);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\ConfigManagerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */