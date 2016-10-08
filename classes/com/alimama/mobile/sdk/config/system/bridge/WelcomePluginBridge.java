package com.alimama.mobile.sdk.config.system.bridge;

import android.util.Log;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public class WelcomePluginBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static WelcomePluginBridge mBridge;
  public Hack.HackedClass<Object> AlimamaSplashAdapter;
  public Hack.HackedMethod AlimamaSplashAdapter_ManualDismiss;
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
  
  public static WelcomePluginBridge getInstance()
  {
    WelcomePluginBridge localWelcomePluginBridge;
    if (mBridge == null) {
      localWelcomePluginBridge = new WelcomePluginBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localWelcomePluginBridge);
        localWelcomePluginBridge.allClasses();
        localWelcomePluginBridge.allMethods();
        localWelcomePluginBridge.allFields();
        AssertionArrayException localAssertionArrayException = localWelcomePluginBridge.mExceptionArray;
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
        if (localWelcomePluginBridge == null) {
          continue;
        }
        Log.e("Hack", "Create FeedPluginBridge failed.", localWelcomePluginBridge.mExceptionArray);
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
      if (localWelcomePluginBridge != null)
      {
        Log.e("Hack", "Create FeedPluginBridge failed.", localWelcomePluginBridge.mExceptionArray);
        continue;
        mBridge = localWelcomePluginBridge;
      }
    }
    Log.e("Hack", "Create FeedPluginBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localWelcomePluginBridge != null) {
        Log.e("Hack", "Create FeedPluginBridge failed.", localWelcomePluginBridge.mExceptionArray);
      }
    }
  }
  
  public void allClasses()
  {
    this.AlimamaSplashAdapter = Hack.into(getClassLoader(), "com.alimama.adapters.sdk.AlimamaSplashAdapter");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.AlimamaSplashAdapter_ManualDismiss = this.AlimamaSplashAdapter.method("ManualDismiss", new Class[0]);
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\WelcomePluginBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */