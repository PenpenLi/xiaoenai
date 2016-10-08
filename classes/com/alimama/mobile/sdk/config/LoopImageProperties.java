package com.alimama.mobile.sdk.config;

import android.app.Activity;
import android.view.ViewGroup;
import com.alimama.config.custom.MMULoopImageCustomAdapter;
import com.alimama.listener.MMULoopImageListener;

public class LoopImageProperties
  extends MmuProperties
{
  public static final int TYPE = 43;
  private LoopImageConfig config;
  private ViewGroup container;
  private LoopImageController loopImageController;
  private MMULoopImageListener mmuLoopImageListener;
  
  public LoopImageProperties(Activity paramActivity, String paramString)
  {
    super(paramActivity, paramString, 43);
  }
  
  public void addCustomAdapter(int paramInt, MMULoopImageCustomAdapter paramMMULoopImageCustomAdapter)
  {
    putExtra("" + paramInt, paramMMULoopImageCustomAdapter);
  }
  
  public LoopImageConfig getConfig()
  {
    return this.config;
  }
  
  public ViewGroup getContainer()
  {
    return this.container;
  }
  
  public LoopImageController getLoopImageController()
  {
    if (this.loopImageController == null) {
      this.loopImageController = LoopImageController.newInstance();
    }
    return this.loopImageController;
  }
  
  public MMULoopImageListener getMmuLoopImageListener()
  {
    return this.mmuLoopImageListener;
  }
  
  public String[] getPluginNames()
  {
    return new String[] { "LoopImagePlugin" };
  }
  
  public void setConfig(LoopImageConfig paramLoopImageConfig)
  {
    this.config = paramLoopImageConfig;
  }
  
  public void setContainer(ViewGroup paramViewGroup)
  {
    this.container = paramViewGroup;
  }
  
  public void setMmuLoopImageListener(MMULoopImageListener paramMMULoopImageListener)
  {
    this.mmuLoopImageListener = paramMMULoopImageListener;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\LoopImageProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */