package com.alimama.mobile.sdk.config.system.bridge;

import android.support.v4.app.Fragment;
import android.util.Log;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedConstructor;

public class TaePluginBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static TaePluginBridge mBridge;
  private Hack.HackedClass<Fragment> LoginWebViewFragment;
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
  
  public static TaePluginBridge getInstance()
  {
    TaePluginBridge localTaePluginBridge;
    if (mBridge == null) {
      localTaePluginBridge = new TaePluginBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localTaePluginBridge);
        localTaePluginBridge.allClasses();
        localTaePluginBridge.allMethods();
        localTaePluginBridge.allFields();
        AssertionArrayException localAssertionArrayException = localTaePluginBridge.mExceptionArray;
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
        if (localTaePluginBridge == null) {
          continue;
        }
        Log.e("Hack", "Create FeedPluginBridge failed.", localTaePluginBridge.mExceptionArray);
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
      if (localTaePluginBridge != null)
      {
        Log.e("Hack", "Create FeedPluginBridge failed.", localTaePluginBridge.mExceptionArray);
        continue;
        mBridge = localTaePluginBridge;
      }
    }
    Log.e("Hack", "Create FeedPluginBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localTaePluginBridge != null) {
        Log.e("Hack", "Create FeedPluginBridge failed.", localTaePluginBridge.mExceptionArray);
      }
    }
  }
  
  public void allClasses()
  {
    this.LoginWebViewFragment = Hack.into(getClassLoader(), "com.alibaba.sdk.android.login.ui.LoginWebViewFragment");
  }
  
  public void allFields() {}
  
  public void allMethods() {}
  
  public Fragment getLoginWebViewFragment()
  {
    try
    {
      Fragment localFragment = (Fragment)this.LoginWebViewFragment.constructor(new Class[0]).getInstance(new Object[0]);
      return localFragment;
    }
    catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
    {
      MMLog.e(localHackAssertionException, "", new Object[0]);
    }
    return null;
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


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\TaePluginBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */