package com.alimama.listener;

import android.view.ViewGroup;

public abstract interface MMUListener
{
  public abstract void onClickAd();
  
  public abstract boolean onCloseAd();
  
  public abstract void onFailedReceiveAd();
  
  public abstract void onInitFinish();
  
  public abstract void onRealClickAd();
  
  public abstract void onReceiveAd(ViewGroup paramViewGroup);
  
  public abstract void onRequestAd();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\listener\MMUListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */