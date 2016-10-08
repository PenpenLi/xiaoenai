package com.alimama.listener;

public abstract interface MMUInterstitialListener
{
  public abstract void onInitFinish();
  
  public abstract void onInterstitialClickAd();
  
  public abstract boolean onInterstitialClickCloseButton();
  
  public abstract void onInterstitialCloseAd(boolean paramBoolean);
  
  public abstract void onInterstitialRealClickAd();
  
  public abstract boolean onInterstitialStaleDated();
  
  public abstract void onShowInterstitialScreen();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\listener\MMUInterstitialListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */