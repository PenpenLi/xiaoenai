package com.alimama.mobile.sdk.config.system;

import android.content.res.AssetManager;
import com.alimama.mobile.sdk.config.MmuProperties;

abstract interface STSystem
{
  public abstract boolean stAssetPlugin(AssetManager paramAssetManager);
  
  public abstract boolean stLoadedCommonPlugin();
  
  public abstract boolean stLoadedFrameWorkPlugin();
  
  public abstract boolean stManifest();
  
  public abstract <T extends MmuProperties> boolean stPlugin(T paramT);
  
  public static final class STSException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\STSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */