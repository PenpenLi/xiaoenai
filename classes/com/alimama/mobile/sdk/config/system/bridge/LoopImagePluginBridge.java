package com.alimama.mobile.sdk.config.system.bridge;

import android.util.Log;
import android.view.ViewGroup;
import com.alimama.mobile.pluginframework.core.PluginFramework;
import com.alimama.mobile.sdk.config.system.BridgeSystem.HackCollection;
import com.alimama.mobile.sdk.hack.AssertionArrayException;
import com.alimama.mobile.sdk.hack.Hack;
import com.alimama.mobile.sdk.hack.Hack.AssertionFailureHandler;
import com.alimama.mobile.sdk.hack.Hack.HackDeclaration.HackAssertionException;
import com.alimama.mobile.sdk.hack.Hack.HackedClass;
import com.alimama.mobile.sdk.hack.Hack.HackedMethod;
import java.lang.reflect.InvocationTargetException;

public class LoopImagePluginBridge
  implements BridgeSystem.HackCollection, Hack.AssertionFailureHandler
{
  private static LoopImagePluginBridge mBridge;
  private Hack.HackedMethod LoopImageReflect_setTitle;
  private Hack.HackedClass<Object> loopImageReflect;
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
  
  public static LoopImagePluginBridge getInstance()
  {
    LoopImagePluginBridge localLoopImagePluginBridge;
    if (mBridge == null) {
      localLoopImagePluginBridge = new LoopImagePluginBridge();
    }
    for (;;)
    {
      try
      {
        Hack.setAssertionFailureHandler(localLoopImagePluginBridge);
        localLoopImagePluginBridge.allClasses();
        localLoopImagePluginBridge.allMethods();
        localLoopImagePluginBridge.allFields();
        AssertionArrayException localAssertionArrayException = localLoopImagePluginBridge.mExceptionArray;
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
        Log.e("Hack", "Create loopImagePluginBridge failed.", mBridge.mExceptionArray);
      }
      catch (Hack.HackDeclaration.HackAssertionException localHackAssertionException)
      {
        int i;
        Log.e("Hack", "HackAssertionException", localHackAssertionException);
        Hack.setAssertionFailureHandler(null);
        if (mBridge == null) {
          continue;
        }
        Log.e("Hack", "Create loopImagePluginBridge failed.", mBridge.mExceptionArray);
        continue;
        if (localLoopImagePluginBridge == null) {
          continue;
        }
        Log.e("Hack", "Create loopImagePluginBridge failed.", localLoopImagePluginBridge.mExceptionArray);
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
      if (localLoopImagePluginBridge != null)
      {
        Log.e("Hack", "Create loopImagePluginBridge failed.", localLoopImagePluginBridge.mExceptionArray);
        continue;
        mBridge = localLoopImagePluginBridge;
      }
    }
    Log.e("Hack", "Create loopImagePluginBridge failed.", mBridge.mExceptionArray);
    for (;;)
    {
      throw ((Throwable)localObject);
      label187:
      if (localLoopImagePluginBridge != null) {
        Log.e("Hack", "Create loopImagePluginBridge failed.", localLoopImagePluginBridge.mExceptionArray);
      }
    }
  }
  
  public void allClasses()
  {
    this.loopImageReflect = Hack.into(getClassLoader(), "com.taobao.newxp.view.largeimage.LoopImageReflect");
  }
  
  public void allFields() {}
  
  public void allMethods()
  {
    this.LoopImageReflect_setTitle = this.loopImageReflect.staticMethod("setTitle", new Class[] { ViewGroup.class, String.class });
  }
  
  public void invoke_setTitle(ViewGroup paramViewGroup, String paramString)
  {
    try
    {
      if (this.LoopImageReflect_setTitle != null) {
        this.LoopImageReflect_setTitle.invoke(this.loopImageReflect, new Object[] { paramViewGroup, paramString });
      }
      return;
    }
    catch (InvocationTargetException paramViewGroup)
    {
      throw new RuntimeException("Hack调用失败", paramViewGroup);
    }
  }
  
  public boolean onAssertionFailure(Hack.HackDeclaration.HackAssertionException paramHackAssertionException)
  {
    if (this.mExceptionArray == null)
    {
      Log.i("LoopImagePluginBridge", "onassertionFailure is null");
      this.mExceptionArray = new AssertionArrayException("loopImagePluginBridge hack failed");
    }
    this.mExceptionArray.addException(paramHackAssertionException);
    Log.i("LoopImagePluginBridge", "onassertionFailure in loopimagepluginbridge");
    return true;
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\bridge\LoopImagePluginBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */