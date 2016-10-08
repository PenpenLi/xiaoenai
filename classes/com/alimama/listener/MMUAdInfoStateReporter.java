package com.alimama.listener;

import android.view.ViewGroup;

public abstract interface MMUAdInfoStateReporter
{
  public abstract void onAttachAdView(ViewGroup paramViewGroup);
  
  public abstract void onClickAd();
  
  public abstract void onDestroy();
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\listener\MMUAdInfoStateReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */