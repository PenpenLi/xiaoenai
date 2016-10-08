package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import com.alimama.listener.MMUAdInfoStateReporter;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.config.system.MMLog;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.util.HashMap;

public class CustomLoopImageAdapterBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static CustomLoopImageAdapterBridge mBridge;
  private Hack.HackedClass<Object> MMUCustomLoopImageAdapter;
  private Hack.HackedMethod addMMUAdInfo;
  private Hack.HackedMethod getActivity;
  private Hack.HackedMethod getContainer;
  private Hack.HackedMethod getId;
  private AssertionArrayException mExceptionArray = null;
  private Object mmuCustomLoopImageAdapter;
  private Hack.HackedMethod notifyMMUAdClicked;
  private Hack.HackedMethod notifyMMUAdRequestAdFail;
  private Hack.HackedMethod notifyMMUAdRequestAdSuccess;
  private Hack.HackedMethod notifyMMUAdShowAdSuccess;
  
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
  
  public static CustomLoopImageAdapterBridge getInstance()
  {
    CustomLoopImageAdapterBridge localCustomLoopImageAdapterBridge;
    if (mBridge == null) {
      localCustomLoopImageAdapterBridge = new CustomLoopImageAdapterBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localCustomLoopImageAdapterBridge);
        localCustomLoopImageAdapterBridge.allClasses();
        localCustomLoopImageAdapterBridge.allMethods();
        localCustomLoopImageAdapterBridge.allFields();
        AssertionArrayException localAssertionArrayException = localCustomLoopImageAdapterBridge.mExceptionArray;
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
        Log.e("Hack", "Create CustomLoopImageAdapterBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomLoopImageAdapterBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localCustomLoopImageAdapterBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomLoopImageAdapterBridge failed.", localCustomLoopImageAdapterBridge.mExceptionArray);
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
      if (localCustomLoopImageAdapterBridge != null)
      {
        Log.e("Hack", "Create CustomLoopImageAdapterBridge failed.", localCustomLoopImageAdapterBridge.mExceptionArray);
        continue;
        mBridge = localCustomLoopImageAdapterBridge;
      }
    }
    Log.e("Hack", "Create CustomLoopImageAdapterBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localCustomLoopImageAdapterBridge != null) {
        Log.e("Hack", "Create CustomLoopImageAdapterBridge failed.", localCustomLoopImageAdapterBridge.mExceptionArray);
      }
    }
  }
  
  public void addMMUAdInfo(HashMap<String, Object> paramHashMap, MMUAdInfoStateReporter paramMMUAdInfoStateReporter)
  {
    try
    {
      if (this.mmuCustomLoopImageAdapter != null)
      {
        this.addMMUAdInfo.invoke(this.mmuCustomLoopImageAdapter, new Object[] { paramHashMap, paramMMUAdInfoStateReporter });
        return;
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
      return;
    }
    catch (Exception paramHashMap)
    {
      MMLog.e(paramHashMap.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void allClasses()
  {
    this.MMUCustomLoopImageAdapter = Hack.into(getClassLoader(), "com.alimama.adapters.MMUCustomLoopImageAdapter");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.addMMUAdInfo = this.MMUCustomLoopImageAdapter.method("addMMUAdInfo", new Class[] { HashMap.class, MMUAdInfoStateReporter.class });
    this.getActivity = this.MMUCustomLoopImageAdapter.method("getActivity", new Class[0]);
    this.getId = this.MMUCustomLoopImageAdapter.method("getId", new Class[0]);
    this.getContainer = this.MMUCustomLoopImageAdapter.method("getContainer", new Class[0]);
    this.notifyMMUAdRequestAdFail = this.MMUCustomLoopImageAdapter.method("notifyMMUAdRequestAdFail", new Class[0]);
    this.notifyMMUAdRequestAdSuccess = this.MMUCustomLoopImageAdapter.method("notifyMMUAdRequestAdSuccess", new Class[0]);
    this.notifyMMUAdShowAdSuccess = this.MMUCustomLoopImageAdapter.method("notifyMMUAdShowAdSuccess", new Class[0]);
    this.notifyMMUAdClicked = this.MMUCustomLoopImageAdapter.method("notifyMMUAdClicked", new Class[0]);
  }
  
  public Activity getActivity()
  {
    try
    {
      if (this.mmuCustomLoopImageAdapter != null) {
        return (Activity)this.getActivity.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
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
  
  public ViewGroup getContainer()
  {
    try
    {
      if (this.mmuCustomLoopImageAdapter != null) {
        return (ViewGroup)this.getContainer.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
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
      if (this.mmuCustomLoopImageAdapter != null) {
        return (String)this.getId.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
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
      if (this.mmuCustomLoopImageAdapter != null)
      {
        this.notifyMMUAdClicked.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
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
      if (this.mmuCustomLoopImageAdapter != null)
      {
        this.notifyMMUAdRequestAdFail.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
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
      if (this.mmuCustomLoopImageAdapter != null)
      {
        this.notifyMMUAdRequestAdSuccess.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      MMLog.e(localException.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void notifyMMUAdShowAdSuccess()
  {
    try
    {
      if (this.mmuCustomLoopImageAdapter != null)
      {
        this.notifyMMUAdShowAdSuccess.invoke(this.mmuCustomLoopImageAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomLoopImageAdapter is null", new Object[0]);
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
      this.mExceptionArray = new AssertionArrayException("CustomLoopImageAdapterBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    return true;
  }
  
  public void setMmuCustomLoopImageAdapter(Object paramObject)
  {
    this.mmuCustomLoopImageAdapter = paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\CustomLoopImageAdapterBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */