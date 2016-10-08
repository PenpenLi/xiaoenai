package com.alimama.mobile.sdk.config;

import android.app.Activity;
import android.view.ViewGroup;
import com.alimama.config.custom.MMUBannerCustomAdapter;
import com.alimama.listener.MMUListener;
import java.lang.ref.WeakReference;

public class BannerProperties
  extends MmuProperties
{
  public static final int TYPE = 6;
  private WeakReference<MMUListener> adsMogoListener;
  private WeakReference<ViewGroup> container;
  private boolean isManualRefresh;
  private final BannerController mController = new BannerController();
  private boolean stretch = false;
  
  public BannerProperties(Activity paramActivity, String paramString, ViewGroup paramViewGroup)
  {
    super(paramActivity, paramString, 6);
    this.container = new WeakReference(paramViewGroup);
  }
  
  public void addCustomAdapter(int paramInt, MMUBannerCustomAdapter paramMMUBannerCustomAdapter)
  {
    putExtra("" + paramInt, paramMMUBannerCustomAdapter);
  }
  
  public ViewGroup getContainer()
  {
    if (this.container != null) {
      return (ViewGroup)this.container.get();
    }
    return null;
  }
  
  public BannerController getController()
  {
    return this.mController;
  }
  
  public MMUListener getMMUListener()
  {
    if (this.adsMogoListener != null) {
      return (MMUListener)this.adsMogoListener.get();
    }
    return null;
  }
  
  public String[] getPluginNames()
  {
    return new String[] { "BannerPlugin" };
  }
  
  public boolean isManualRefresh()
  {
    return this.isManualRefresh;
  }
  
  public boolean isStretch()
  {
    return this.stretch;
  }
  
  public void setMMUListener(MMUListener paramMMUListener)
  {
    this.adsMogoListener = new WeakReference(paramMMUListener);
  }
  
  public void setManualRefresh(boolean paramBoolean)
  {
    this.isManualRefresh = paramBoolean;
  }
  
  public void setStretch(boolean paramBoolean)
  {
    this.stretch = paramBoolean;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\BannerProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */