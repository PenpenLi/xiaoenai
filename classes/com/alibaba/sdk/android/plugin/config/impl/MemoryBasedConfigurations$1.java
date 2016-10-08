package com.alibaba.sdk.android.plugin.config.impl;

import com.alibaba.sdk.android.config.PropertyChangeListener;
import com.alibaba.sdk.android.impl.KernelContext;
import com.alibaba.sdk.android.registry.ServiceRegistry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MemoryBasedConfigurations$1
  implements Runnable
{
  MemoryBasedConfigurations$1(MemoryBasedConfigurations paramMemoryBasedConfigurations, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$list.iterator();
    MemoryBasedConfigurations.InternalPropertyChangeEvent localInternalPropertyChangeEvent;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localInternalPropertyChangeEvent = (MemoryBasedConfigurations.InternalPropertyChangeEvent)localIterator.next();
      if ("$global$".equals(localInternalPropertyChangeEvent.owner)) {
        localObject1 = Collections.singletonMap("property.scope", "global");
      }
    }
    for (;;)
    {
      localObject1 = (PropertyChangeListener[])KernelContext.serviceRegistry.getServices(PropertyChangeListener.class, (Map)localObject1);
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break;
      }
      int j = localObject1.length;
      int i = 0;
      label80:
      if (i >= j) {
        break;
      }
      Object localObject2 = localObject1[i];
      try
      {
        ((PropertyChangeListener)localObject2).propertyChanged(localInternalPropertyChangeEvent.key, localInternalPropertyChangeEvent.oldValue, localInternalPropertyChangeEvent.newValue);
        i += 1;
        break label80;
        localObject1 = new HashMap();
        ((Map)localObject1).put("property.scope", "plugin");
        ((Map)localObject1).put("plugin.vendor", localInternalPropertyChangeEvent.owner);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alibaba\sdk\android\plugin\config\impl\MemoryBasedConfigurations$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */