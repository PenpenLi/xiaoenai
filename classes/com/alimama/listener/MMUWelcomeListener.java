package com.alimama.listener;

import com.alimama.config.MMUAdInfo;

public abstract interface MMUWelcomeListener
{
  public abstract void onRequestAdSuccess(MMUAdInfo paramMMUAdInfo);
  
  public abstract void onWelcomeClickAd();
  
  public abstract void onWelcomeClose();
  
  public abstract void onWelcomeError(String paramString);
  
  public abstract void onWelcomeRealClickAd();
  
  public abstract void onWelcomeSucceed();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\listener\MMUWelcomeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */