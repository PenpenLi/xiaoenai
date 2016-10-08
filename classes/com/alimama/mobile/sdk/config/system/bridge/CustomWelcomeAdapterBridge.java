package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;

public class CustomWelcomeAdapterBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static CustomWelcomeAdapterBridge mBridge;
  private Hack.HackedClass<Object> MMUCustomWelcomeAdapter;
  private Hack.HackedMethod getActivity;
  private Hack.HackedMethod getAdView;
  private Hack.HackedMethod getId;
  private Hack.HackedMethod getViewContainer;
  private AssertionArrayException mExceptionArray = null;
  private Object mmuCustomWelcomeAdapter;
  private Hack.HackedMethod notifyMMUAdClicked;
  private Hack.HackedMethod notifyMMUAdCloseed;
  private Hack.HackedMethod notifyMMUAdRequestAdFail;
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
  
  public static CustomWelcomeAdapterBridge getInstance()
  {
    CustomWelcomeAdapterBridge localCustomWelcomeAdapterBridge;
    if (mBridge == null) {
      localCustomWelcomeAdapterBridge = new CustomWelcomeAdapterBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localCustomWelcomeAdapterBridge);
        localCustomWelcomeAdapterBridge.allClasses();
        localCustomWelcomeAdapterBridge.allMethods();
        localCustomWelcomeAdapterBridge.allFields();
        AssertionArrayException localAssertionArrayException = localCustomWelcomeAdapterBridge.mExceptionArray;
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
        Log.e("Hack", "Create CustomWelcomeAdapterBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomWelcomeAdapterBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localCustomWelcomeAdapterBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomWelcomeAdapterBridge failed.", localCustomWelcomeAdapterBridge.mExceptionArray);
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
      if (localCustomWelcomeAdapterBridge != null)
      {
        Log.e("Hack", "Create CustomWelcomeAdapterBridge failed.", localCustomWelcomeAdapterBridge.mExceptionArray);
        continue;
        mBridge = localCustomWelcomeAdapterBridge;
      }
    }
    Log.e("Hack", "Create CustomWelcomeAdapterBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localCustomWelcomeAdapterBridge != null) {
        Log.e("Hack", "Create CustomWelcomeAdapterBridge failed.", localCustomWelcomeAdapterBridge.mExceptionArray);
      }
    }
  }
  
  public void allClasses()
  {
    this.MMUCustomWelcomeAdapter = Hack.into(getClassLoader(), "com.alimama.adapters.MMUCustomSplashAdapter");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.getActivity = this.MMUCustomWelcomeAdapter.method("getActivity", new Class[0]);
    this.getId = this.MMUCustomWelcomeAdapter.method("getId", new Class[0]);
    this.getAdView = this.MMUCustomWelcomeAdapter.method("getAdView", new Class[0]);
    this.getViewContainer = this.MMUCustomWelcomeAdapter.method("getViewContainer", new Class[0]);
    this.notifyMMUAdClicked = this.MMUCustomWelcomeAdapter.method("notifyMMUAdClicked", new Class[0]);
    this.notifyMMUAdCloseed = this.MMUCustomWelcomeAdapter.method("notifyMMUAdCloseed", new Class[0]);
    this.notifyMMUAdRequestAdFail = this.MMUCustomWelcomeAdapter.method("notifyMMUAdRequestAdFail", new Class[0]);
    this.notifyMMUAdShowSuccess = this.MMUCustomWelcomeAdapter.method("notifyMMUAdShowSuccess", new Class[0]);
  }
  
  public Activity getActivity()
  {
    try
    {
      if (this.mmuCustomWelcomeAdapter != null) {
        return (Activity)this.getActivity.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
  
  public ViewGroup getAdView()
  {
    try
    {
      if (this.mmuCustomWelcomeAdapter != null) {
        return (ViewGroup)this.getAdView.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
      if (this.mmuCustomWelcomeAdapter != null) {
        return (String)this.getId.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
  
  public ViewGroup getViewContainer()
  {
    try
    {
      if (this.mmuCustomWelcomeAdapter != null) {
        return (ViewGroup)this.getViewContainer.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
      if (this.mmuCustomWelcomeAdapter != null)
      {
        this.notifyMMUAdClicked.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
      if (this.mmuCustomWelcomeAdapter != null)
      {
        this.notifyMMUAdCloseed.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
      if (this.mmuCustomWelcomeAdapter != null)
      {
        this.notifyMMUAdRequestAdFail.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
      if (this.mmuCustomWelcomeAdapter != null)
      {
        this.notifyMMUAdShowSuccess.invoke(this.mmuCustomWelcomeAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomWelcomeAdapter is null", new Object[0]);
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
      this.mExceptionArray = new AssertionArrayException("CustomWelcomeAdapterBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    return true;
  }
  
  public void setMmuCustomWelcomeAdapter(Object paramObject)
  {
    this.mmuCustomWelcomeAdapter = paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\CustomWelcomeAdapterBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */