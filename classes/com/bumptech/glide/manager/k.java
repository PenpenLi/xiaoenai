package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.i.h;
import java.util.HashMap;
import java.util.Map;

public class k
  implements Handler.Callback
{
  private static final k c = new k();
  final Map<android.app.FragmentManager, RequestManagerFragment> a = new HashMap();
  final Map<android.support.v4.app.FragmentManager, n> b = new HashMap();
  private volatile f d;
  private final Handler e = new Handler(Looper.getMainLooper(), this);
  
  public static k a()
  {
    return c;
  }
  
  private f b(Context paramContext)
  {
    if (this.d == null) {}
    try
    {
      if (this.d == null) {
        this.d = new f(paramContext.getApplicationContext(), new b(), new g());
      }
      return this.d;
    }
    finally {}
  }
  
  @TargetApi(17)
  private static void b(Activity paramActivity)
  {
    if ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())) {
      throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }
  }
  
  @TargetApi(11)
  public f a(Activity paramActivity)
  {
    if ((h.d()) || (Build.VERSION.SDK_INT < 11)) {
      return a(paramActivity.getApplicationContext());
    }
    b(paramActivity);
    return a(paramActivity, paramActivity.getFragmentManager());
  }
  
  @TargetApi(17)
  public f a(android.app.Fragment paramFragment)
  {
    if (paramFragment.getActivity() == null) {
      throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
    if ((h.d()) || (Build.VERSION.SDK_INT < 17)) {
      return a(paramFragment.getActivity().getApplicationContext());
    }
    android.app.FragmentManager localFragmentManager = paramFragment.getChildFragmentManager();
    return a(paramFragment.getActivity(), localFragmentManager);
  }
  
  public f a(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("You cannot start a load on a null Context");
    }
    if ((h.c()) && (!(paramContext instanceof Application)))
    {
      if ((paramContext instanceof FragmentActivity)) {
        return a((FragmentActivity)paramContext);
      }
      if ((paramContext instanceof Activity)) {
        return a((Activity)paramContext);
      }
      if ((paramContext instanceof ContextWrapper)) {
        return a(((ContextWrapper)paramContext).getBaseContext());
      }
    }
    return b(paramContext);
  }
  
  @TargetApi(11)
  f a(Context paramContext, android.app.FragmentManager paramFragmentManager)
  {
    RequestManagerFragment localRequestManagerFragment = a(paramFragmentManager);
    f localf = localRequestManagerFragment.b();
    paramFragmentManager = localf;
    if (localf == null)
    {
      paramFragmentManager = new f(paramContext, localRequestManagerFragment.a(), localRequestManagerFragment.c());
      localRequestManagerFragment.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  f a(Context paramContext, android.support.v4.app.FragmentManager paramFragmentManager)
  {
    n localn = a(paramFragmentManager);
    f localf = localn.b();
    paramFragmentManager = localf;
    if (localf == null)
    {
      paramFragmentManager = new f(paramContext, localn.a(), localn.c());
      localn.a(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  public f a(android.support.v4.app.Fragment paramFragment)
  {
    if (paramFragment.getActivity() == null) {
      throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
    if (h.d()) {
      return a(paramFragment.getActivity().getApplicationContext());
    }
    android.support.v4.app.FragmentManager localFragmentManager = paramFragment.getChildFragmentManager();
    return a(paramFragment.getActivity(), localFragmentManager);
  }
  
  public f a(FragmentActivity paramFragmentActivity)
  {
    if (h.d()) {
      return a(paramFragmentActivity.getApplicationContext());
    }
    b(paramFragmentActivity);
    return a(paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager());
  }
  
  @TargetApi(17)
  RequestManagerFragment a(android.app.FragmentManager paramFragmentManager)
  {
    RequestManagerFragment localRequestManagerFragment2 = (RequestManagerFragment)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    RequestManagerFragment localRequestManagerFragment1 = localRequestManagerFragment2;
    if (localRequestManagerFragment2 == null)
    {
      localRequestManagerFragment2 = (RequestManagerFragment)this.a.get(paramFragmentManager);
      localRequestManagerFragment1 = localRequestManagerFragment2;
      if (localRequestManagerFragment2 == null)
      {
        localRequestManagerFragment1 = new RequestManagerFragment();
        this.a.put(paramFragmentManager, localRequestManagerFragment1);
        paramFragmentManager.beginTransaction().add(localRequestManagerFragment1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(1, paramFragmentManager).sendToTarget();
      }
    }
    return localRequestManagerFragment1;
  }
  
  n a(android.support.v4.app.FragmentManager paramFragmentManager)
  {
    n localn2 = (n)paramFragmentManager.findFragmentByTag("com.bumptech.glide.manager");
    n localn1 = localn2;
    if (localn2 == null)
    {
      localn2 = (n)this.b.get(paramFragmentManager);
      localn1 = localn2;
      if (localn2 == null)
      {
        localn1 = new n();
        this.b.put(paramFragmentManager, localn1);
        paramFragmentManager.beginTransaction().add(localn1, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.e.obtainMessage(2, paramFragmentManager).sendToTarget();
      }
    }
    return localn1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    boolean bool = true;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
      localObject1 = null;
      paramMessage = (Message)localObject2;
    }
    for (;;)
    {
      if ((bool) && (localObject1 == null) && (Log.isLoggable("RMRetriever", 5))) {
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + paramMessage);
      }
      return bool;
      paramMessage = (android.app.FragmentManager)paramMessage.obj;
      localObject1 = this.a.remove(paramMessage);
      continue;
      paramMessage = (android.support.v4.app.FragmentManager)paramMessage.obj;
      localObject1 = this.b.remove(paramMessage);
    }
  }
}


/* Location:              E:\apk\xiaoenai2\classes-dex2jar.jar!\com\bumptech\glide\manager\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */