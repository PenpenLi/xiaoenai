package com.alimama.mobile.sdk.config;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.alimama.config.custom.MMUWelcomeCustomAdapter;
import com.alimama.listener.MMUWelcomeListener;
import java.lang.ref.WeakReference;

public class WelcomeProperties
  extends MmuProperties
{
  public static final int TYPE = 9;
  private static final WelcomeController mController = new WelcomeController();
  private WeakReference<MMUWelcomeListener> adsMogoSplashListener;
  private int animations;
  private int height = -1;
  private boolean manualDis = false;
  private long maxDelay = 3000L;
  private long minDelay = 1000L;
  private ImageView.ScaleType scaleType;
  private int style;
  private WeakReference<ViewGroup> viewContainer;
  private int width = -1;
  
  public WelcomeProperties(Activity paramActivity, String paramString)
  {
    super(paramActivity, paramString, 9);
  }
  
  public WelcomeProperties(Activity paramActivity, String paramString, long paramLong1, long paramLong2, MMUWelcomeListener paramMMUWelcomeListener)
  {
    super(paramActivity, paramString, 9);
    this.minDelay = paramLong1;
    this.maxDelay = paramLong2;
    this.adsMogoSplashListener = new WeakReference(paramMMUWelcomeListener);
  }
  
  public void addCustomAdapter(int paramInt, MMUWelcomeCustomAdapter paramMMUWelcomeCustomAdapter)
  {
    putExtra("" + paramInt, paramMMUWelcomeCustomAdapter);
  }
  
  public int getAnimations()
  {
    return this.animations;
  }
  
  public WelcomeController getController()
  {
    return mController;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public MMUWelcomeListener getMMUSplashListener()
  {
    if (this.adsMogoSplashListener != null) {
      return (MMUWelcomeListener)this.adsMogoSplashListener.get();
    }
    return null;
  }
  
  public long getMaxDelay()
  {
    return this.maxDelay;
  }
  
  public long getMinDelay()
  {
    return this.minDelay;
  }
  
  public String[] getPluginNames()
  {
    return new String[] { "WelcomePlugin" };
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.scaleType;
  }
  
  public int getStyle()
  {
    return this.style;
  }
  
  public ViewGroup getWelcomeContainer()
  {
    if (this.viewContainer == null) {
      return null;
    }
    return (ViewGroup)this.viewContainer.get();
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isManualDis()
  {
    return this.manualDis;
  }
  
  public void setAnimations(int paramInt)
  {
    this.animations = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setMMUSplashListener(MMUWelcomeListener paramMMUWelcomeListener)
  {
    this.adsMogoSplashListener = new WeakReference(paramMMUWelcomeListener);
  }
  
  public void setManualDis(boolean paramBoolean)
  {
    this.manualDis = paramBoolean;
  }
  
  public void setMaxDelay(long paramLong)
  {
    this.maxDelay = paramLong;
  }
  
  public void setMinDelay(long paramLong)
  {
    this.minDelay = paramLong;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.scaleType = paramScaleType;
  }
  
  public void setStyle(int paramInt)
  {
    this.style = paramInt;
  }
  
  public void setWelcomeContainer(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      paramViewGroup.setTag("cs");
      this.viewContainer = new WeakReference(paramViewGroup);
    }
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\WelcomeProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */