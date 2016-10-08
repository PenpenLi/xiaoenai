package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Activity;
import android.util.Log;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public class CustomInterstitialAdapterBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static CustomInterstitialAdapterBridge mBridge;
  private Hack.HackedClass<Object> MMUCustomInterstitialAdapter;
  private Hack.HackedMethod getActivity;
  private Hack.HackedMethod getId;
  private AssertionArrayException mExceptionArray = null;
  private Object mmuCustomInterstitialAdapter;
  private Hack.HackedMethod notifyMMUAdClicked;
  private Hack.HackedMethod notifyMMUAdCloseed;
  private Hack.HackedMethod notifyMMUAdRequestAdFail;
  private Hack.HackedMethod notifyMMUAdRequestAdSuccess;
  private Hack.HackedMethod notifyMMUAdShowSuccess;
  
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
  
  public static CustomInterstitialAdapterBridge getInstance()
  {
    CustomInterstitialAdapterBridge localCustomInterstitialAdapterBridge;
    if (mBridge == null) {
      localCustomInterstitialAdapterBridge = new CustomInterstitialAdapterBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localCustomInterstitialAdapterBridge);
        localCustomInterstitialAdapterBridge.allClasses();
        localCustomInterstitialAdapterBridge.allMethods();
        localCustomInterstitialAdapterBridge.allFields();
        AssertionArrayException localAssertionArrayException = localCustomInterstitialAdapterBridge.mExceptionArray;
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
        Log.e("Hack", "Create CustomInterstitialAdapterBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomInterstitialAdapterBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localCustomInterstitialAdapterBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomInterstitialAdapterBridge failed.", localCustomInterstitialAdapterBridge.mExceptionArray);
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
      if (localCustomInterstitialAdapterBridge != null)
      {
        Log.e("Hack", "Create CustomInterstitialAdapterBridge failed.", localCustomInterstitialAdapterBridge.mExceptionArray);
        continue;
        mBridge = localCustomInterstitialAdapterBridge;
      }
    }
    Log.e("Hack", "Create CustomInterstitialAdapterBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localCustomInterstitialAdapterBridge != null) {
        Log.e("Hack", "Create CustomInterstitialAdapterBridge failed.", localCustomInterstitialAdapterBridge.mExceptionArray);
      }
    }
  }
  
  public void allClasses()
  {
    this.MMUCustomInterstitialAdapter = Hack.into(getClassLoader(), "com.alimama.adapters.MMUCustomInterstitialAdapter");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.getActivity = this.MMUCustomInterstitialAdapter.method("getActivity", new Class[0]);
    this.getId = this.MMUCustomInterstitialAdapter.method("getId", new Class[0]);
    this.notifyMMUAdClicked = this.MMUCustomInterstitialAdapter.method("notifyMMUAdClicked", new Class[0]);
    this.notifyMMUAdCloseed = this.MMUCustomInterstitialAdapter.method("notifyMMUAdCloseed", new Class[0]);
    this.notifyMMUAdRequestAdFail = this.MMUCustomInterstitialAdapter.method("notifyMMUAdRequestAdFail", new Class[0]);
    this.notifyMMUAdRequestAdSuccess = this.MMUCustomInterstitialAdapter.method("notifyMMUAdRequestAdSuccess", new Class[0]);
    this.notifyMMUAdShowSuccess = this.MMUCustomInterstitialAdapter.method("notifyMMUAdShowSuccess", new Class[0]);
  }
  
  public Activity getActivity()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null) {
        return (Activity)this.getActivity.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
      }
    }
    return null;
  }
  
  public String getId()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null) {
        return (String)this.getId.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
      }
    }
    return null;
  }
  
  public void notifyMMUAdClicked()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null)
      {
        this.notifyMMUAdClicked.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void notifyMMUAdCloseed()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null)
      {
        this.notifyMMUAdCloseed.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void notifyMMUAdRequestAdFail()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null)
      {
        this.notifyMMUAdRequestAdFail.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void notifyMMUAdRequestAdSuccess()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null)
      {
        this.notifyMMUAdRequestAdSuccess.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void notifyMMUAdShowSuccess()
  {
    try
    {
      if (this.mmuCustomInterstitialAdapter != null)
      {
        this.notifyMMUAdShowSuccess.invoke(this.mmuCustomInterstitialAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomInterstitialAdapter is null", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public boolean onAssertionFailure(Hack.HackDeclaration.HackAssertionException paramHackAssertionException)
  {
    if (this.mExceptionArray == null) {
      this.mExceptionArray = new AssertionArrayException("CustomInterstitialAdapterBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    return true;
  }
  
  public void setMmuCustomInterstitialAdapter(Object paramObject)
  {
    this.mmuCustomInterstitialAdapter = paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\CustomInterstitialAdapterBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */