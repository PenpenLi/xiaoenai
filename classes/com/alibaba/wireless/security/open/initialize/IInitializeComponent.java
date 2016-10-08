package com.alibaba.wireless.security.open.initialize;

import android.content.Context;

public abstract interface IInitializeComponent
{
  public abstract int initialize(Context paramContext);
  
  public abstract void initializeAsync(Context paramContext);
  
  public abstract boolean isSoValid(Context paramContext);
  
  public abstract void loadLibraryAsync(Context paramContext);
  
  public abstract int loadLibrarySync(Context paramContext);
  
  public abstract void registerInitFinishListener(IInitFinishListener paramIInitFinishListener);
  
  public abstract void unregisterInitFinishListener(IInitFinishListener paramIInitFinishListener);
  
  public static abstract interface IInitFinishListener
  {
    public abstract void onError();
    
    public abstract void onSuccess();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\wireless\security\open\initialize\IInitializeComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */