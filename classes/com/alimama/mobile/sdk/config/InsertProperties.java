package com.alimama.mobile.sdk.config;

import android.app.Activity;
import com.alimama.config.custom.MMUInterstitialCustomAdapter;
import com.alimama.listener.MMUInterstitialListener;

public class InsertProperties
  extends MmuProperties
{
  public static final int TYPE = 15;
  private MMUInterstitialListener adsMogoInterstitialListener;
  private boolean isCanThrough = false;
  private boolean isManualRefresh;
  private boolean isShowMask = true;
  private final InsertController mController = new InsertController();
  private boolean videoInsert = false;
  
  public InsertProperties(Activity paramActivity, String paramString)
  {
    super(paramActivity, paramString, 15);
  }
  
  public void addCustomAdapter(int paramInt, MMUInterstitialCustomAdapter paramMMUInterstitialCustomAdapter)
  {
    putExtra("" + paramInt, paramMMUInterstitialCustomAdapter);
  }
  
  public InsertController getController()
  {
    return this.mController;
  }
  
  public MMUInterstitialListener getMMUInterstitialListener()
  {
    return this.adsMogoInterstitialListener;
  }
  
  public String[] getPluginNames()
  {
    return new String[] { "InsertPlugin" };
  }
  
  public boolean getVideoInsert()
  {
    return this.videoInsert;
  }
  
  public boolean isCanThrough()
  {
    return this.isCanThrough;
  }
  
  public boolean isManualRefresh()
  {
    return this.isManualRefresh;
  }
  
  public boolean isShowMask()
  {
    return this.isShowMask;
  }
  
  public void setCanThrough(boolean paramBoolean)
  {
    this.isCanThrough = paramBoolean;
  }
  
  public void setMMUInterstitialListener(MMUInterstitialListener paramMMUInterstitialListener)
  {
    this.adsMogoInterstitialListener = paramMMUInterstitialListener;
  }
  
  public void setManualRefresh(boolean paramBoolean)
  {
    this.isManualRefresh = paramBoolean;
  }
  
  public void setShowMask(boolean paramBoolean)
  {
    this.isShowMask = paramBoolean;
  }
  
  public void setVideoInsert(boolean paramBoolean)
  {
    this.videoInsert = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\InsertProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */