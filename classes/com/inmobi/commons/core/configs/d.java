package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class d
  implements Runnable
{
  private static final String a = d.class.getName();
  private e b;
  private int c;
  private a d;
  
  public d(a parama, e parame)
  {
    this.d = parama;
    this.b = parame;
    this.c = 0;
  }
  
  private void a()
  {
    while (this.c <= this.b.c())
    {
      Object localObject1 = new com.inmobi.commons.core.network.d(this.b).a();
      localObject1 = new ConfigNetworkResponse(this.b.b(), (c)localObject1).a();
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        Object localObject3 = (Map.Entry)localIterator.next();
        localObject2 = (ConfigNetworkResponse.ConfigResponse)((Map.Entry)localObject3).getValue();
        localObject3 = (String)((Map.Entry)localObject3).getKey();
        if (!((ConfigNetworkResponse.ConfigResponse)localObject2).d())
        {
          this.d.a((ConfigNetworkResponse.ConfigResponse)localObject2);
          this.b.a((String)localObject3);
        }
      }
      if (this.b.b().isEmpty()) {
        break;
      }
      this.c += 1;
      if (this.c > this.b.c())
      {
        localIterator = this.b.b().entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (String)((Map.Entry)localIterator.next()).getKey();
          if (((Map)localObject1).containsKey(localObject2)) {
            this.d.a((ConfigNetworkResponse.ConfigResponse)((Map)localObject1).get(localObject2));
          }
        }
      }
      Thread.sleep(this.b.d() * 1000);
    }
    this.d.b();
  }
  
  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.a(Logger.InternalLogLevel.INTERNAL, a, "Fetching config interrupted by the component de-initialization.");
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ConfigNetworkResponse.ConfigResponse paramConfigResponse);
    
    public abstract void b();
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\inmobi\commons\core\configs\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */