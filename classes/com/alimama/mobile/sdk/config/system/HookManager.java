package com.alimama.mobile.sdk.config.system;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  private static final Set<WeakReference<Activity>> hookActivitys = new HashSet();
  private static final Set<String> regActivitys = new HashSet();
  
  public static void addHookActivity(Activity paramActivity)
  {
    hookActivitys.add(new WeakReference(paramActivity));
  }
  
  public static boolean containsHookActivity(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    Iterator localIterator = hookActivitys.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramActivity) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean containsRegActivity(String paramString)
  {
    if ((paramString.startsWith("com.alimama.mobile.sdk.shell")) || (paramString.startsWith("com.alimama.mobile.sdk"))) {
      return true;
    }
    return regActivitys.contains(paramString);
  }
  
  public static void registerAcvitity(Class<? extends Activity> paramClass)
  {
    regActivitys.add(paramClass.getCanonicalName());
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\alimama\mobile\sdk\config\system\HookManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */