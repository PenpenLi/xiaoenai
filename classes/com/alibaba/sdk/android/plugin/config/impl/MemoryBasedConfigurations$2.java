package com.alibaba.sdk.android.plugin.config.impl;

import com.alibaba.sdk.android.config.PropertyChangeListener;

class MemoryBasedConfigurations$2
  implements Runnable
{
  MemoryBasedConfigurations$2(MemoryBasedConfigurations paramMemoryBasedConfigurations, PropertyChangeListener[] paramArrayOfPropertyChangeListener, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    PropertyChangeListener[] arrayOfPropertyChangeListener = this.val$listeners;
    int j = arrayOfPropertyChangeListener.length;
    int i = 0;
    for (;;)
    {
      PropertyChangeListener localPropertyChangeListener;
      if (i < j) {
        localPropertyChangeListener = arrayOfPropertyChangeListener[i];
      }
      try
      {
        localPropertyChangeListener.propertyChanged(this.val$name, this.val$oldValue, this.val$newValue);
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\config\impl\MemoryBasedConfigurations$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */