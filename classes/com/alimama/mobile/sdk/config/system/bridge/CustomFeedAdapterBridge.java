package com.alimama.mobile.sdk.config.system.bridge;

import android.app.Activity;
import android.util.Log;
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

public class CustomFeedAdapterBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static CustomFeedAdapterBridge mBridge;
  private Hack.HackedClass<Object> MMUCustomFeedAdapter;
  private Hack.HackedMethod addMMUAdInfo;
  private Hack.HackedMethod getActivity;
  private Hack.HackedMethod getId;
  private AssertionArrayException mExceptionArray = null;
  private Object mmuCustomFeedAdapter;
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
  
  public static CustomFeedAdapterBridge getInstance()
  {
    CustomFeedAdapterBridge localCustomFeedAdapterBridge;
    if (mBridge == null) {
      localCustomFeedAdapterBridge = new CustomFeedAdapterBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localCustomFeedAdapterBridge);
        localCustomFeedAdapterBridge.allClasses();
        localCustomFeedAdapterBridge.allMethods();
        localCustomFeedAdapterBridge.allFields();
        AssertionArrayException localAssertionArrayException = localCustomFeedAdapterBridge.mExceptionArray;
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
        Log.e("Hack", "Create CustomFeedAdapterBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomFeedAdapterBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localCustomFeedAdapterBridge == null) {
          continue;
        }
        Log.e("Hack", "Create CustomFeedAdapterBridge failed.", localCustomFeedAdapterBridge.mExceptionArray);
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
      if (localCustomFeedAdapterBridge != null)
      {
        Log.e("Hack", "Create CustomFeedAdapterBridge failed.", localCustomFeedAdapterBridge.mExceptionArray);
        continue;
        mBridge = localCustomFeedAdapterBridge;
      }
    }
    Log.e("Hack", "Create CustomFeedAdapterBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localCustomFeedAdapterBridge != null) {
        Log.e("Hack", "Create CustomFeedAdapterBridge failed.", localCustomFeedAdapterBridge.mExceptionArray);
      }
    }
  }
  
  public void addMMUAdInfo(HashMap<String, Object> paramHashMap, MMUAdInfoStateReporter paramMMUAdInfoStateReporter)
  {
    try
    {
      if (this.mmuCustomFeedAdapter != null)
      {
        this.addMMUAdInfo.invoke(this.mmuCustomFeedAdapter, new Object[] { paramHashMap, paramMMUAdInfoStateReporter });
        return;
      }
      MMLog.e("mmuCustomFeedAdapter is null", new Object[0]);
      return;
    }
    catch (Exception paramHashMap)
    {
      MMLog.e(paramHashMap.fillInStackTrace(), "", new Object[0]);
    }
  }
  
  public void allClasses()
  {
    this.MMUCustomFeedAdapter = Hack.into(getClassLoader(), "com.alimama.adapters.MMUCustomFeedAdapter");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.addMMUAdInfo = this.MMUCustomFeedAdapter.method("addMMUAdInfo", new Class[] { HashMap.class, MMUAdInfoStateReporter.class });
    this.getActivity = this.MMUCustomFeedAdapter.method("getActivity", new Class[0]);
    this.getId = this.MMUCustomFeedAdapter.method("getId", new Class[0]);
    this.notifyMMUAdRequestAdFail = this.MMUCustomFeedAdapter.method("notifyMMUAdRequestAdFail", new Class[0]);
    this.notifyMMUAdRequestAdSuccess = this.MMUCustomFeedAdapter.method("notifyMMUAdRequestAdSuccess", new Class[0]);
  }
  
  public Activity getActivity()
  {
    try
    {
      if (this.mmuCustomFeedAdapter != null) {
        return (Activity)this.getActivity.invoke(this.mmuCustomFeedAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomFeedAdapter is null", new Object[0]);
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
      if (this.mmuCustomFeedAdapter != null) {
        return (String)this.getId.invoke(this.mmuCustomFeedAdapter, new Object[0]);
      }
      MMLog.e("mmuCustomFeedAdapter is null", new Object[0]);
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
      if (this.mmuCustomFeedAdapter != null)
      {
        this.notifyMMUAdRequestAdFail.invoke(this.mmuCustomFeedAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomFeedAdapter is null", new Object[0]);
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
      if (this.mmuCustomFeedAdapter != null)
      {
        this.notifyMMUAdRequestAdSuccess.invoke(this.mmuCustomFeedAdapter, new Object[0]);
        return;
      }
      MMLog.e("mmuCustomFeedAdapter is null", new Object[0]);
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
      this.mExceptionArray = new AssertionArrayException("CustomFeedAdapterBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    return true;
  }
  
  public void setMmuCustomFeedAdapter(Object paramObject)
  {
    this.mmuCustomFeedAdapter = paramObject;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\CustomFeedAdapterBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */