package com.ut.mini.plugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UTPluginMgr
  implements UTMCAppStatusCallbacks
{
  public static final String PARTNERPLUGIN_UTPREF = "com.ut.mini.perf.UTPerfPlugin";
  private static UTPluginMgr a = new UTPluginMgr();
  private HandlerThread b = null;
  private Handler mHandler = null;
  private List<UTPlugin> n = new LinkedList();
  private List<String> o = new ArrayList();
  private List<String> p = new UTPluginMgr.1(this);
  private List<UTPlugin> q = new LinkedList();
  
  private UTPluginMgr()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      UTMCAppStatusRegHelper.registerAppStatusCallbacks(this);
    }
  }
  
  private void N()
  {
    this.b = new HandlerThread("UT-PLUGIN-ASYNC");
    this.b.start();
    this.mHandler = new UTPluginMgr.2(this, this.b.getLooper());
  }
  
  private UTPluginContext a()
  {
    UTPluginContext localUTPluginContext = new UTPluginContext();
    localUTPluginContext.setContext(b.a().getContext());
    if (i.n()) {
      localUTPluginContext.setDebugLogFlag(i.n());
    }
    return localUTPluginContext;
  }
  
  /* Error */
  private void a(int paramInt, UTPluginContextValueDispatchDelegate paramUTPluginContextValueDispatchDelegate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 57	com/ut/mini/plugin/UTPluginMgr:q	Ljava/util/List;
    //   13: invokeinterface 122 1 0
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 127 1 0
    //   25: ifeq -19 -> 6
    //   28: aload_3
    //   29: invokeinterface 131 1 0
    //   34: checkcast 133	com/ut/mini/plugin/UTPlugin
    //   37: astore 4
    //   39: aload_2
    //   40: aload 4
    //   42: invokevirtual 136	com/ut/mini/plugin/UTPlugin:getPluginContext	()Lcom/ut/mini/plugin/UTPluginContext;
    //   45: invokeinterface 142 2 0
    //   50: aload 4
    //   52: iload_1
    //   53: invokevirtual 146	com/ut/mini/plugin/UTPlugin:onPluginContextValueUpdate	(I)V
    //   56: goto -37 -> 19
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	UTPluginMgr
    //   0	64	1	paramInt	int
    //   0	64	2	paramUTPluginContextValueDispatchDelegate	UTPluginContextValueDispatchDelegate
    //   18	11	3	localIterator	Iterator
    //   37	14	4	localUTPlugin	UTPlugin
    // Exception table:
    //   from	to	target	type
    //   9	19	59	finally
    //   19	56	59	finally
  }
  
  private boolean a(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          break;
        }
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
        i += 1;
      }
    }
    return bool2;
  }
  
  public static UTPluginMgr getInstance()
  {
    return a;
  }
  
  public boolean dispatchPluginMsg(int paramInt, Object paramObject)
  {
    label249:
    label255:
    for (;;)
    {
      try
      {
        if (this.mHandler == null) {
          N();
        }
        boolean bool2 = false;
        bool1 = false;
        if (this.q.size() > 0)
        {
          Iterator localIterator = this.q.iterator();
          bool2 = bool1;
          if (localIterator.hasNext())
          {
            UTPlugin localUTPlugin = (UTPlugin)localIterator.next();
            Object localObject = localUTPlugin.returnRequiredMsgIds();
            if ((localObject == null) || (!a(paramInt, (int[])localObject))) {
              break label249;
            }
            if (paramInt != 1)
            {
              if (this.n != null)
              {
                bool2 = this.n.contains(localUTPlugin);
                if (!bool2) {}
              }
            }
            else {
              try
              {
                if ((paramObject instanceof UTPluginMsgDispatchDelegate))
                {
                  localObject = (UTPluginMsgDispatchDelegate)paramObject;
                  if (((UTPluginMsgDispatchDelegate)localObject).isMatchPlugin(localUTPlugin)) {
                    localUTPlugin.onPluginMsgArrivedFromSDK(paramInt, ((UTPluginMsgDispatchDelegate)localObject).getDispatchObject(localUTPlugin));
                  }
                }
                else
                {
                  localUTPlugin.onPluginMsgArrivedFromSDK(paramInt, paramObject);
                }
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
                break label255;
              }
            }
            localObject = new a(null);
            ((a)localObject).g(paramInt);
            ((a)localObject).c(paramObject);
            ((a)localObject).a(localThrowable);
            Message localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.obj = localObject;
            this.mHandler.sendMessage(localMessage);
            bool1 = true;
            break label255;
          }
        }
        return bool2;
      }
      finally {}
      break label255;
      boolean bool1 = true;
    }
  }
  
  public boolean isPartnerPluginExist(String paramString)
  {
    return this.o.contains(paramString);
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onSwitchBackground()
  {
    dispatchPluginMsg(2, null);
  }
  
  public void onSwitchForeground()
  {
    dispatchPluginMsg(8, null);
  }
  
  public void registerPlugin(UTPlugin paramUTPlugin, boolean paramBoolean)
  {
    if (paramUTPlugin != null) {}
    try
    {
      if (!this.q.contains(paramUTPlugin))
      {
        paramUTPlugin.a(a());
        this.q.add(paramUTPlugin);
        if (!paramBoolean) {
          this.n.add(paramUTPlugin);
        }
        paramUTPlugin.onRegistered();
      }
      return;
    }
    finally {}
  }
  
  public void runPartnerPlugin()
  {
    if ((this.p != null) && (this.p.size() > 0))
    {
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          try
          {
            Object localObject = Class.forName(str).newInstance();
            if ((localObject instanceof UTPlugin))
            {
              registerPlugin((UTPlugin)localObject, true);
              i.a("runPartnerPlugin[OK]:" + str, new String[0]);
              this.o.add(str);
            }
          }
          catch (ClassNotFoundException localClassNotFoundException) {}catch (InstantiationException localInstantiationException)
          {
            localInstantiationException.printStackTrace();
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void unregisterPlugin(UTPlugin paramUTPlugin)
  {
    if (paramUTPlugin != null) {}
    try
    {
      if (this.q.contains(paramUTPlugin))
      {
        this.q.remove(paramUTPlugin);
        paramUTPlugin.onUnRegistered();
        paramUTPlugin.a(null);
      }
      if ((this.n != null) && (this.n.contains(paramUTPlugin))) {
        this.n.remove(paramUTPlugin);
      }
      return;
    }
    finally {}
  }
  
  public void updatePluginContextValue(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramInt, new UTPluginMgr.3(this));
  }
  
  private static class a
  {
    private int K = 0;
    private UTPlugin a = null;
    private Object f = null;
    
    public UTPlugin a()
    {
      return this.a;
    }
    
    public void a(UTPlugin paramUTPlugin)
    {
      this.a = paramUTPlugin;
    }
    
    public void c(Object paramObject)
    {
      this.f = paramObject;
    }
    
    public void g(int paramInt)
    {
      this.K = paramInt;
    }
    
    public Object getMsgObj()
    {
      return this.f;
    }
    
    public int i()
    {
      return this.K;
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes2-dex2jar.jar!\com\ut\mini\plugin\UTPluginMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */