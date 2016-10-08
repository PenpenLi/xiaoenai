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

public class CustomBannerAdapterBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static CustomBannerAdapterBridge mBridge;
  private Hack.HackedClass<Object> MMUCustomBannerAdapter;
  private Hack.HackedMethod addAdView;
  private Hack.HackedMethod getActivity;
  private Hack.HackedMethod getId;
  private AssertionArrayException mExceptionArray = null;
  private Object mmuCustomBannerAdapter;
  private Hack.HackedMethod notifyMMUAdRequestAdFail;
  private Hack.HackedMethod notifyMMUAdRequestAdSuccess;
  
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
  
  public static CustomBannerAdapterBridge getInstance()
  {
    CustomBannerAdapterBridge localCustomBannerAdapterBridge;
    if (mBridge == null) {
      localCustomBannerAdapterBridge = new CustomBannerAdapterBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localCustomBannerAdapterBridge);
        localCustomBannerAdapterBridge.allClasses();
        localCustomBannerAdapterBridge.allMethods();
        localCustomBannerAdapterBridge.allFields();
        AssertionArrayException localAssertionArrayException = localCustomBannerAdapterBridge.mExceptionArray;
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
        Log.e("Hack", "Create CustomBannerAdapterBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomBannerAdapterBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localCustomBannerAdapterBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomBannerAdapterBridge failed.", localCustomBannerAdapterBridge.mExceptionArray);
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
      if (localCustomBannerAdapterBridge != null)
      {
        Log.e("Hack", "Create CustomBannerAdapterBridge failed.", localCustomBannerAdapterBridge.mExceptionArray);
        continue;
        mBridge = localCustomBannerAdapterBridge;
      }
    }
    Log.e("Hack", "Create CustomBannerAdapterBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localCustomBannerAdapterBridge != null) {
        Log.e("Hack", "Create CustomBannerAdapterBridge failed.", localCustomBannerAdapterBridge.mExceptionArray);
      }
    }
  }
  
  public void addAdView(ViewGroup paramViewGroup)
  {
    try
    {
      if (this.mmuCustomBannerAdapter != null)
      {
        this.addAdView.invoke(this.mmuCustomBannerAdapter, new Object[] { paramViewGroup });
        return;
      }
      MMLog.e("mmuCustomBannerAdapter is null", new Object[0]);
      return;
    }
    catch (Exception paramViewGroup)
    {
      MMLog.e(paramViewGroup.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void allClasses()
  {
    this.MMUCustomBannerAdapter = Hack.into(getClassLoader(), "com.alimama.adapters.MMUCustomBannerAdapter");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.addAdView = this.MMUCustomBannerAdapter.method("addAdView", new Class[] { ViewGroup.class });
    this.getActivity = this.MMUCustomBannerAdapter.method("getActivity", new Class[0]);
    this.getId = this.MMUCustomBannerAdapter.method("getId", new Class[0]);
    this.notifyMMUAdRequestAdFail = this.MMUCustomBannerAdapter.method("notifyMMUAdRequestAdFail", new Class[0]);
    this.notifyMMUAdRequestAdSuccess = this.MMUCustomBannerAdapter.method("notifyMMUAdRequestAdSuccess", new Class[0]);
  }
  
  public Activity getActivity()
  {
    try
    {
      if (this.mmuCustomBannerAdapter != null) {
        return (Activity)this.getActivity.invoke(this.mmuCustomBannerAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomBannerAdapter is null", new Object[0]);
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
      if (this.mmuCustomBannerAdapter != null) {
        return (String)this.getId.invoke(this.mmuCustomBannerAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomBannerAdapter is null", new Object[0]);
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
  
  public void notifyMMUAdRequestAdFail()
  {
    try
    {
      if (this.mmuCustomBannerAdapter != null)
      {
        this.notifyMMUAdRequestAdFail.invoke(this.mmuCustomBannerAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomBannerAdapter is null", new Object[0]);
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
      if (this.mmuCustomBannerAdapter != null)
      {
        this.notifyMMUAdRequestAdSuccess.invoke(this.mmuCustomBannerAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomBannerAdapter is null", new Object[0]);
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
      this.mExceptionArray = new AssertionArrayException("CustomBannerAdapterBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    return true;
  }
  
  public void setMmuCustomBannerAdapter(Object paramObject)
  {
    this.mmuCustomBannerAdapter = paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\CustomBannerAdapterBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */