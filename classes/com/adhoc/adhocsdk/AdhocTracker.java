package com.adhoc.adhocsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MotionEvent;
import com.adhoc.a;
import com.adhoc.ab;
import com.adhoc.ad;
import com.adhoc.ae;
import com.adhoc.b;
import com.adhoc.c;
import com.adhoc.d;
import com.adhoc.e;
import com.adhoc.f;
import com.adhoc.fl;
import com.adhoc.g;
import com.adhoc.h;
import com.adhoc.i;
import com.adhoc.k;
import com.adhoc.m;
import com.adhoc.o;
import com.adhoc.q;
import com.adhoc.s;
import com.adhoc.w;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdhocTracker
{
  public static String APPKEY = null;
  public static String client_id;
  private static int current_api_level;
  private static String msg = "ADHOC_SDK仅支持 Android SDK API level 9及以上,level 8及以下版本client将不加入试验";
  
  static
  {
    client_id = null;
    current_api_level = Build.VERSION.SDK_INT;
  }
  
  @Deprecated
  public static void autoTracking(Context paramContext, MotionEvent paramMotionEvent)
  {
    if (paramContext == null) {}
    while ((!ad.a(paramContext.getApplicationContext()).b()) || (current_api_level < 9)) {
      return;
    }
    k.a().a(paramContext.getApplicationContext(), paramMotionEvent);
  }
  
  public static String getClientId(Context paramContext)
  {
    if (paramContext == null) {}
    while (!ad.a(paramContext.getApplicationContext()).b()) {
      return null;
    }
    return a.a(paramContext.getApplicationContext()).a();
  }
  
  public static JSONArray getCurrentExperiments()
  {
    if (current_api_level < 9) {
      return new JSONArray();
    }
    try
    {
      JSONArray localJSONArray = q.a().e();
      return localJSONArray;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
    return new JSONArray();
  }
  
  public static ExperimentFlags getExperimentFlags(Context paramContext)
  {
    if (paramContext == null) {}
    try
    {
      fl.b("get experiment flag context is null");
      return getNullExperimentflag();
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
    fl.a("need refresh right now " + s.a(paramContext.getApplicationContext()).a);
    if (!ad.a(paramContext.getApplicationContext()).b()) {
      return getNullExperimentflag();
    }
    if (current_api_level < 9) {
      return getNullExperimentflag();
    }
    paramContext = s.a(paramContext.getApplicationContext()).b(paramContext.getApplicationContext());
    return paramContext;
    return getNullExperimentflag();
  }
  
  public static void getExperimentFlags(Context paramContext, OnAdHocReceivedData paramOnAdHocReceivedData)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          fl.a("need refresh right now " + s.a(paramContext.getApplicationContext()).a);
          s.a(paramContext.getApplicationContext()).a(paramOnAdHocReceivedData);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  @Deprecated
  public static void getExperimentFlagsTimeOut(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          fl.a("need refresh right now " + s.a(paramContext.getApplicationContext()).a);
          s.a(paramContext.getApplicationContext()).b(paramInt);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  public static void getExperimentFlagsTimeOut(Context paramContext, int paramInt, OnAdHocReceivedData paramOnAdHocReceivedData)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          fl.a("need refresh right now " + s.a(paramContext.getApplicationContext()).a);
          s.a(paramContext.getApplicationContext()).a(paramInt, paramOnAdHocReceivedData);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  private static ExperimentFlags getNullExperimentflag()
  {
    ExperimentFlags localExperimentFlags = new ExperimentFlags(new JSONObject());
    localExperimentFlags.setFlagState(ExperimentFlags.a.b.toString());
    return localExperimentFlags;
  }
  
  public static void incrementStat(Context paramContext, String paramString, double paramDouble)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          new Thread(new b(paramContext, paramString, paramDouble)).start();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  public static void incrementStat(Context paramContext, String paramString, float paramFloat)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          new Thread(new e(paramContext, paramString, paramFloat)).start();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  public static void incrementStat(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          new Thread(new c(paramContext, paramString, paramInt)).start();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  public static void incrementStat(Context paramContext, String paramString, long paramLong)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if (current_api_level >= 9)
        {
          new Thread(new d(paramContext, paramString, paramLong)).start();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  public static void init(Context paramContext, String paramString)
  {
    new Thread(new f(paramString, paramContext)).start();
  }
  
  public static void initWithClientId(Context paramContext, String paramString1, String paramString2)
  {
    setClientId(paramString2, paramContext);
    init(paramContext, paramString1);
  }
  
  public static void onFragmentCreate(Activity paramActivity, Object paramObject)
  {
    if (paramActivity == null) {}
    while (current_api_level < 9) {
      return;
    }
    try
    {
      ae.a().a(paramActivity, paramObject);
      return;
    }
    catch (IllegalAccessException paramActivity)
    {
      fl.a(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      fl.a(paramActivity);
    }
  }
  
  public static void onFragmentDestory(Activity paramActivity, Object paramObject)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramActivity.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          ae.a().a(paramObject);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        fl.a(paramActivity);
      }
    }
  }
  
  public static void onPause(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramActivity.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          fl.a("onPause : " + paramActivity.getClass().getName());
          ab.a().c(paramActivity);
          new Thread(new h(paramActivity)).start();
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        fl.a(paramActivity);
      }
    }
  }
  
  public static void onResume(Activity paramActivity)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramActivity.getApplicationContext()).b()) && (current_api_level >= 9))
        {
          fl.a("onResume : " + paramActivity.getClass().getName());
          ab.a().b(paramActivity);
          if (ae.a().a)
          {
            Log.d("FragmentManager", " Operations:");
            fl.a("resume Opertions");
            return;
          }
        }
      }
      catch (Throwable paramActivity)
      {
        fl.a(paramActivity);
      }
    }
  }
  
  public static void reportCrashEnable(boolean paramBoolean)
  {
    try
    {
      if (current_api_level < 9) {
        return;
      }
      o.a().a(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
  
  private static void setBack2Menu(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new g());
    }
  }
  
  private static void setClientId(String paramString, Context paramContext)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      fl.a("设置client_id" + paramString);
      client_id = paramString;
      new Thread(new i(paramContext, paramString)).start();
      return;
    }
    fl.b("client_id is null");
  }
  
  public static void setCustomStatParameter(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramContext == null) {}
    while (!ad.a(paramContext.getApplicationContext()).b()) {
      return;
    }
    try
    {
      m.a(paramContext.getApplicationContext()).a(paramHashMap);
      return;
    }
    catch (Throwable paramContext)
    {
      fl.a(paramContext);
    }
  }
  
  public static void setGapTimeGetFlag(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((ad.a(paramContext.getApplicationContext()).b()) && (paramInt >= 0))
        {
          s.a(paramContext.getApplicationContext()).a(paramInt);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        fl.a(paramContext);
      }
    }
  }
  
  public static void setGapTimeSendCacheData(long paramLong)
  {
    try
    {
      w.a().a(paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
  
  public static void setOnlyWifiReport(boolean paramBoolean)
  {
    try
    {
      w.a().a(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      fl.a(localThrowable);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\adhoc\adhocsdk\AdhocTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */