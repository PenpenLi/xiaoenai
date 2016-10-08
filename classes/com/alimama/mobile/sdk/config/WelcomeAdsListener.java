package com.alimama.mobile.sdk.config;

import android.view.View;
import com.alimama.config.MMUAdInfo;

public abstract interface WelcomeAdsListener
{
  public abstract void onClick();
  
  public abstract void onCountdown(int paramInt);
  
  public abstract void onDataReviced(MMUAdInfo paramMMUAdInfo);
  
  public abstract void onError(String paramString);
  
  public abstract void onFinish();
  
  public abstract void onShow(View paramView);
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\WelcomeAdsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */