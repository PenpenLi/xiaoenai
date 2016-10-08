package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Activity;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import com.alimama.listener.MMUFeedListener;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.MMUFeedController.FeedViewActionListener;
import com.alimama.mobile.sdk.config.MMUFeedProperties;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedConstructor;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FeedPluginBridge2
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static FeedPluginBridge2 mBridge;
  private Hack.HackedClass<Object> FeedViewFactory;
  public Hack.HackedMethod FeedViewFactory_getFeedView;
  private Hack.HackedClass<Object> MMUNative;
  private Hack.HackedMethod MMUNative_addMaterial;
  private Hack.HackedConstructor MMUNative_obj;
  private Hack.HackedMethod MMUNative_setMMUNativeListener;
  private Object adsMogoNative = null;
  private AssertionArrayException mExceptionArray = null;
  
  private static ClassLoader getClassLoader()
  {
    try
    {
      ClassLoader localClassLoader = PluginFramework.getPluginClassLoader();
      return localClassLoader;
    }
    catch (Exception localException)
    {
      Log.e("wt", "", localException);
    }
    return null;
  }
  
  public static FeedPluginBridge2 getInstance()
  {
    FeedPluginBridge2 localFeedPluginBridge2;
    if (mBridge == null) {
      localFeedPluginBridge2 = new FeedPluginBridge2();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localFeedPluginBridge2);
        localFeedPluginBridge2.allClasses();
        localFeedPluginBridge2.allMethods();
        localFeedPluginBridge2.allFields();
        AssertionArrayException localAssertionArrayException = localFeedPluginBridge2.mExceptionArray;
        if (localAssertionArrayException == null) {
          continue;
        }
        i = 0;
        Hack.setAssertionFailureHandler(null);
        if (i != 0) {
          continue;
        }
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create FeedPluginBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create FeedPluginBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localFeedPluginBridge2 == null) {
          continue;
        }
        Log.e("Hack", "Create FeedPluginBridge failed.", localFeedPluginBridge2.mExceptionArray);
        continue;
      }
      finally
      {
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          break label187;
        }
      }
      return mBridge;
      i = 1;
      continue;
      if (localFeedPluginBridge2 != null)
      {
        Log.e("Hack", "Create FeedPluginBridge failed.", localFeedPluginBridge2.mExceptionArray);
        continue;
        mBridge = localFeedPluginBridge2;
      }
    }
    Log.e("Hack", "Create FeedPluginBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localFeedPluginBridge2 != null) {
        Log.e("Hack", "Create FeedPluginBridge failed.", localFeedPluginBridge2.mExceptionArray);
      }
    }
  }
  
  public void allClasses()
  {
    this.MMUNative = Hack.into(getClassLoader(), "com.alimama.natives.MMUNative");
    this.FeedViewFactory = Hack.into(getClassLoader(), "com.taobao.newxp.view.feed.FeedViewFactory");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.MMUNative_addMaterial = this.MMUNative.method("addMaterial", new Class[] { MMUFeedProperties.class });
    this.MMUNative_setMMUNativeListener = this.MMUNative.method("setmMUFeedListener", new Class[] { MMUFeedListener.class });
    this.FeedViewFactory_getFeedView = this.FeedViewFactory.method("getFeedView", new Class[] { Activity.class, List.class, Integer.TYPE, FrameLayout.LayoutParams.class, MMUFeedController.FeedViewActionListener.class });
    this.MMUNative_obj = this.MMUNative.constructor(new Class[0]);
  }
  
  public void invoke_addMaterial(MMUFeedProperties paramMMUFeedProperties)
  {
    try
    {
      this.adsMogoNative = mBridge.MMUNative_obj.getInstance(new Object[0]);
      this.MMUNative_addMaterial.invoke(this.adsMogoNative, new Object[] { paramMMUFeedProperties });
      return;
    }
    catch (InvocationTargetException paramMMUFeedProperties)
    {
      throw new RuntimeException("Hack调用失败", paramMMUFeedProperties);
    }
  }
  
  public boolean onAssertionFailure(Hack.HackDeclaration.HackAssertionException paramHackAssertionException)
  {
    if (this.mExceptionArray == null) {
      this.mExceptionArray = new AssertionArrayException("FeedPluginBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\FeedPluginBridge2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */